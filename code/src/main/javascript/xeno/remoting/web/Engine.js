if(typeof(window.xeno) === "undefined") {
	window.xeno = {};
}

if(typeof(xeno.remoting) === "undefined") {
	xeno.remoting = {};
}

if(typeof(xeno.remoting.web) === "undefined") {
	xeno.remoting.web = {};
}

if(typeof(xeno.remoting.web.Engine) === "undefined") {

	/**
	 * @class
	 * <p>
	 * Client side request engine class, provide functions to communicate with server side.
	 * </p>
	 * 
	 * @description
	 * <p>
	 * The class constructor.
	 * </p>
	 */
	xeno.remoting.web.Engine = (function() {
		var CLASS_NAME = /^[_$a-z][_$0-9a-z]*(\.[_$a-z][_$0-9a-z]*)*$/i;
		var STATUS_TEXT = { INIT: "init", PROGRESS: "progress", SUCCESS: "success", ERROR: "error", TIMEOUT: "timeout", ABORT: "abort" };
		var CONTEXT_PATH = "${Param.Value.ContextPath}";
		var PAGE_URI = location.pathname.substring(CONTEXT_PATH.length);

		var _timeout = 0;
		var _onBeforeSend = null;
		var _onSuccess = null;
		var _onError = null;
		var _onTimeout = null;
		var _onComplete = null;

		var _reverseAjaxRetryCount = 0;
		var _reverseAjaxEnabled = false;
		var _reverseAjaxProgress = null;
		var _onReverseAjaxProgress = null;
		var _onReverseAjaxComplete = null;

		var _isUndefinedOrNull = function(data) {
			return typeof(data) === "undefined" || data === null;
		};

		var _isNumber = function(data) {
			return !_isUndefinedOrNull(data) && !_isString(data) && !isNaN(parseFloat(data)) && isFinite(data);
		};

		var _isString = function(data) {
			return !_isUndefinedOrNull(data) && data.constructor === String;
		};

		var _isFunction = function(data) {
			return !_isUndefinedOrNull(data) && data.constructor === Function;
		};

		var _isArray = function(data) {
			return !_isUndefinedOrNull(data) && data.constructor === Array;
		};

		var _isBoolean = function(data) {
			return !_isUndefinedOrNull(data) && data.constructor === Boolean;
		};

		var _ensures = function(result, message) {

			if(!result) {
				throw new Error(message);
			}
		};

		var _fixTimeout = function(value) {
			var val = Math.floor(value);

			if(val > 0) {
				return val < 20 ? 20 : val;
			}

			return 0;
		};

		var _convert = function(func) {
			var result = func.name + "(";
			var params = func.arguments;

			for(var i = 0; i < params.length; i += 1) {

				if(i > 0) {
					result += ", ";
				}

				result += JSON.stringify(params[i]);
			}

			return result + ");";
		};

		var _polling = function() {
			_reverseAjaxProgress = new _AjaxProgress({
				url: "${Param.Value.ReverseAjaxRequestUrl}",
				contentType: "${Param.Value.ContentType}",
				data: JSON.stringify({
					"${Param.DataKey.CurrentPageUri}": PAGE_URI
				}),
				timeout: 0,
				onBeforeSend: function(header) {

					if(_isFunction(_onReverseAjaxProgress)) {
						_onReverseAjaxProgress();
					}
				},
				onSuccess: function(result, xhr) {
					_reverseAjaxRetryCount = 0;

					for(var i in result.data) {

						try {
							var script = _convert(result.data[i]);

							eval(script);

						} catch(err) {
							// Does nothing.
						}
					}
				},
				onError: function(fault, xhr) {
					_reverseAjaxRetryCount += 1;
				},
				onTimeout: function(xhr) {
					_reverseAjaxRetryCount += 1;
				},
				onComplete: function(status, xhr) {

					if(xeno.remoting.web.Engine.isReverseAjaxEnabled()) {
						_polling();

					} else {
						_reverseAjaxProgress = null;

						if(_isFunction(_onReverseAjaxComplete)) {
							_onReverseAjaxComplete();
						}
					}
				}
			});
		};

		var _AjaxProgress = function(option) {
			var _self = this;

			var _hasInitialComplete = false;
			var _hasRequestComplete = false;

			var _status = STATUS_TEXT.INIT;

			var _request = null;
			var _progress = null;

			/**
			 * @ignore
			 */
			this.abort = function() {
				_attemptToAbortRequest(STATUS_TEXT.ABORT);
			};

			/**
			 * @ignore
			 */
			this.getStatus = function() {
				return _status;
			};

			/**
			 * @ignore
			 */
			this.getTimeout = function() {
				return option.timeout;
			};

			/**
			 * @ignore
			 */
			this.getBeforeSendHandler = function() {
				return option.onBeforeSend;
			};

			/**
			 * @ignore
			 */
			this.getSuccessHandler = function() {
				return option.onSuccess;
			};

			/**
			 * @ignore
			 */
			this.getErrorHandler = function() {
				return option.onError;
			};

			/**
			 * @ignore
			 */
			this.getTimeoutHandler = function() {
				return option.onTimeout;
			};

			/**
			 * @ignore
			 */
			this.getCompleteHandler = function() {
				return option.onComplete;
			};

			var _attemptToClearProgress = function() {

				if(!_isUndefinedOrNull(_progress)) {
					_progress = clearTimeout(_progress);
					_progress = null;
				}
			};

			var _attemptToAbortRequest = function(status) {

				if(!_isUndefinedOrNull(_request)) {

					try {
						_status = status;
						_request.abort();

					} catch(err) {
						// Does nothing.
					}
				}
			};

			if(window.XMLHttpRequest) {  // For all modern browsers.
				_request = new XMLHttpRequest();

			} else if(window.ActiveXObject) {  // For IE5 or IE6.
				_request = new ActiveXObject("Microsoft.XMLHTTP");
			}

			if(_isUndefinedOrNull(_request)) {
				alert("Your browser does not support AJAX!");

			} else {

				_request.onreadystatechange = function(evt) {
					var readyState = _request.readyState;

					// --------------------------------------------------
					// 0: Initial state.
					// 1: Open has been called, but data not to be sent yet.
					// 2: Request has been sent, wait response back.
					// 3: Response header data has been received, begin to receive response body.
					// 4: Request complete.
					// --------------------------------------------------

					if(readyState === 1 && _hasInitialComplete === false) {
						_hasInitialComplete = true;

						if(_isFunction(option.onBeforeSend)) {
							var header = {};

							option.onBeforeSend(header);

							for(var i in header) {

								try {
									_request.setRequestHeader(i, header[i]);

								} catch(err) {
									// Does nothing.
								}
							}
						}

					} else if(readyState === 4 && _hasRequestComplete === false) {
						_hasRequestComplete = true;
						_attemptToClearProgress();

						if(_status === STATUS_TEXT.TIMEOUT) {

							if(_isFunction(option.onTimeout)) {
								option.onTimeout(_request);
							}

						} else if(_status === STATUS_TEXT.ABORT) {
							// Does nothing.

						} else {

							try {
								var header = {};

								var items = _request.getAllResponseHeaders().split("\r\n");

								for(var i in items) {

									try {
										var line = items[i];
										var index = line.indexOf(": ");

										if(index > 0) {
											var name = line.substring(0, index);
											var value = line.substring(index + 2);

											header[name] = value;
										}

									} catch(err) {
										// Does nothing.
									}
								}

								var result = JSON.parse(_request.responseText);

								if(_isString(result.type)) {
									_status = STATUS_TEXT.ERROR;

									if(_isFunction(option.onError)) {
										option.onError({
											header: header,
											type: result.type,
											message: result.message,
											data: result.data
										}, _request);
									}

								} else {
									_status = STATUS_TEXT.SUCCESS;

									if(_isFunction(option.onSuccess)) {
										option.onSuccess({
											header: header,
											data: result.data
										}, _request);
									}
								}

							} catch(err) {
								_status = STATUS_TEXT.ERROR;

								if(_isFunction(option.onError)) {
									option.onError({
										type: "${Param.Value.UnhandlableException}",
										message: "Failed to parse response data",
										data: null
									}, _request);
								}
							}
						}

						if(_isFunction(option.onComplete)) {
							option.onComplete(_status, _request);
						}
					}
				};

				if(option.internal_preventProgress !== true) {
					_status = STATUS_TEXT.PROGRESS;

					_request.open("POST", option.url + "?t=" + new Date().getTime() + "&r=" + (Math.floor(Math.random() * 1000000) + 1), true);
					// _request.setRequestHeader("Accept", "*/*");
					_request.setRequestHeader("Content-Type", option.contentType);
					_request.send(option.data);

					if(_isNumber(option.timeout) && option.timeout > 0) {
						_progress = setTimeout(function() {
							_attemptToClearProgress();
							_attemptToAbortRequest(STATUS_TEXT.TIMEOUT);
						}, option.timeout);
					}
				}
			}
		};

		return {

			/**
			 * @ignore
			 */
			registerClass: function(name) {
				_ensures(arguments.length > 0, "The 'name' is required, index: 0");
				_ensures(_isString(name), "The 'name' is not a String");
				_ensures(CLASS_NAME.test(name), "The 'name' is not a valid class name: " + name);

				var data = name.split(".");
				var path = "";
				var exec = "";

				for(var i = 0; i < data.length; i += 1) {

					if(i != 0) {
						path += ".";
					}

					path += data[i];
					exec += "if(typeof(" + path + ") === 'undefined') { " + path + " = {}; }";
				}

				if(exec !== "") {
					eval(exec);
				}
			},

			/**
			 * @ignore
			 */
			processRemoteCall: function(name, method, params, option) {
				var _arguments = arguments.length;

				_ensures(_arguments > 0, "The 'name' is required, index: 0");
				_ensures(_arguments > 1, "The 'method' is required, index: 1");
				_ensures(_arguments > 2, "The 'params' is required, index: 2");
				_ensures(_arguments > 3, "The 'option' is required, index: 3");
				_ensures(_isString(name), "The 'name' is not a String");
				_ensures(_isString(method), "The 'method' is not a String");
				_ensures(_isArray(params), "The 'params' is not an Array");

				var settings = _isUndefinedOrNull(option) ? {} : option;
				var timeout = _isNumber(settings.timeout) ? _fixTimeout(settings.timeout) : _timeout;
				var onBeforeSend = _isFunction(settings.onBeforeSend) ? settings.onBeforeSend : _onBeforeSend;
				var onSuccess = _isFunction(settings.onSuccess) ? settings.onSuccess : _onSuccess;
				var onError = _isFunction(settings.onError) ? settings.onError : _onError;
				var onTimeout = _isFunction(settings.onTimeout) ? settings.onTimeout : _onTimeout;
				var onComplete = _isFunction(settings.onComplete) ? settings.onComplete : _onComplete;

				return new _AjaxProgress({
					url: "${Param.Value.RemoteCallRequestUrl}",
					contentType: "${Param.Value.ContentType}",
					data: JSON.stringify({
						"${Param.DataKey.CurrentPageUri}": PAGE_URI,
						"${Param.DataKey.RemoteProxyName}": name,
						"${Param.DataKey.WebMethodName}": method,
						"${Param.DataKey.InputArguments}": params
					}),
					timeout: timeout,
					onBeforeSend: onBeforeSend,
					onSuccess: onSuccess,
					onError: onError,
					onTimeout: onTimeout,
					onComplete: onComplete,
					internal_preventProgress: settings.internal_preventProgress
				});
			},

			/**
			 * @description
			 * <p>
			 * Returns the context path.
			 * </p>
			 * 
			 * @return The String.
			 */
			getContextPath: function() {
				return CONTEXT_PATH;
			},

			/**
			 * @description
			 * <p>
			 * Returns the global request timeout, in millisecond.
			 * 0 means request without timeout.
			 * </p>
			 * 
			 * @return The Number.
			 */
			getTimeout: function() {
				return _timeout;
			},

			/**
			 * @description
			 * <p>
			 * Sets the global request timeout.
			 * If there is no "timeout" option for each request, the global setting will be applied.
			 * Otherwise, using the individual "timeout" setting of each request.
			 * </p>
			 * <p>
			 * For the value of timeout, undefined, null, negative value, or 0 means request without timeout.
			 * </p>
			 * <p>
			 * For the performance reason, if the timeout value greater than 0 and lower than 20, it will be convert into 20 automatically.
			 * </p>
			 * <p>
			 * And the "timeout" maybe a float value, the "Math.floor(n)" action will be processed first to convert it into an integer Number.
			 * </p>
			 * 
			 * @param timeout
			 * 			The timeout, in millisecond.
			 * 
			 * @throws
			 * 			The Error will be thrown when the "value" is missing.<br/>
			 * 			Or it will be thrown when the "value" is not undefined or null, or not a Number.
			 */
			setTimeout: function(value) {
				_ensures(arguments.length > 0, "The 'value' is required, index: 0");
				_ensures(_isUndefinedOrNull(value) || _isNumber(value), "The 'value' is not undefined or null, or not a Number");

				_timeout = _isNumber(value) ? _fixTimeout(value) : 0;
			},

			/**
			 * @description
			 * <p>
			 * Returns the global before send handler.
			 * </p>
			 * 
			 * @return The Function.
			 */
			getBeforeSendHandler: function() {
				return _onBeforeSend;
			},

			/**
			 * @description
			 * <p>
			 * Sets the global before send handler.
			 * If there is no "onBeforeSend" option for each request, the global setting will be applied.
			 * Otherwise, using the individual "onBeforeSend" setting of each request.
			 * </p>
			 * <p>
			 * A undefined or null argument of "callback" passes in will remove the handler.
			 * </p>
			 * 
			 * @example
			 * <b>Examples</b>
			 * 
			 * xeno.remoting.web.Engine.setBeforeSendHandler(function(header) {
			 * 
			 * 	[header Object]
			 * 	This Object allow you to header data into it.
			 * 	------------------------------------------------------------
			 * 	|	header["setting-1"] = "Your value here";
			 * 	|	header["setting-2"] = 1;
			 * 	|	header["setting-3"] = true;
			 * 	------------------------------------------------------------
			 * 
			 * });
			 * 
			 * @param callback
			 * 			The before send handler.
			 * 
			 * @throws
			 * 			The Error will be thrown when the "callback" is missing.<br/>
			 * 			Or it will be thrown when the "callback" is not undefined or null, or not a Function.
			 */
			setBeforeSendHandler: function(callback) {
				_ensures(arguments.length > 0, "The 'callback' is required, index: 0");
				_ensures(_isUndefinedOrNull(callback) || _isFunction(callback), "The 'callback' is not undefined or null, or not a Function");

				_onBeforeSend = _isFunction(callback) ? callback : null;
			},

			/**
			 * @description
			 * <p>
			 * Returns the global success handler.
			 * </p>
			 * 
			 * @return The Function.
			 */
			getSuccessHandler: function() {
				return _onSuccess;
			},

			/**
			 * @description
			 * <p>
			 * Sets the global success handler.
			 * If there is no "onSuccess" option for each request, the global setting will be applied.
			 * Otherwise, using the individual "onSuccess" setting of each request.
			 * </p>
			 * <p>
			 * A undefined or null argument of "callback" passes in will remove the handler.
			 * </p>
			 * 
			 * @example
			 * <b>Examples</b>
			 * 
			 * xeno.remoting.web.Engine.setSuccessHandler(function(result, xhr) {
			 * 
			 * 	[result Object]
			 * 	This Object contains response content from server side, never be undefined or null.
			 * 	Below is the data structure of this Object.
			 * 	--------------------------------------------------
			 * 	|	"result": {
			 * 	|		"header": Object, the HTTP response header, never be undefined or null.
			 * 	|		"data": The response data, if there is no data return, this value will be null.
			 * 	|	}
			 * 	--------------------------------------------------
			 * 
			 * 	[xhr Object]
			 * 	The original XML HTTP request, never be undefined or null.
			 * 
			 * });
			 * 
			 * @param callback
			 * 			The success handler.
			 * 
			 * @throws
			 * 			The Error will be thrown when the "callback" is missing.<br/>
			 * 			Or it will be thrown when the "callback" is not undefined or null, or not a Function.
			 */
			setSuccessHandler: function(callback) {
				_ensures(arguments.length > 0, "The 'callback' is required, index: 0");
				_ensures(_isUndefinedOrNull(callback) || _isFunction(callback), "The 'callback' is not undefined or null, or not a Function");

				_onSuccess = _isFunction(callback) ? callback : null;
			},

			/**
			 * @description
			 * <p>
			 * Returns the global error handler.
			 * </p>
			 * 
			 * @return The Function.
			 */
			getErrorHandler: function() {
				return _onError;
			},

			/**
			 * @description
			 * <p>
			 * Sets the global error handler.
			 * If there is no "onError" option for each request, the global setting will be applied.
			 * Otherwise, using the individual "onError" setting of each request.
			 * </p>
			 * <p>
			 * A undefined or null argument of "callback" passes in will remove the handler.
			 * </p>
			 * 
			 * @example
			 * <b>Examples</b>
			 * 
			 * xeno.remoting.web.Engine.setErrorHandler(function(fault, xhr) {
			 * 
			 * 	[fault Object]
			 * 	This Object contains response content from server side, never be undefined or null.
			 * 	Below is the data structure of this Object.
			 * 	--------------------------------------------------
			 * 	|	"fault": {
			 * 	|		"header": Object, the HTTP response header, never be undefined or null.
			 * 	|		"type": String, the server side exception type, never be undefined or null.
			 * 	|		"message": String, the server side exception carried message, if there is no message, this value will be null.
			 * 	|		"data": The response data, if there is no data return, this value will be null.
			 * 	|	}
			 * 	--------------------------------------------------
			 * 
			 * 	[xhr Object]
			 * 	The original XML HTTP request, never be undefined or null.
			 * 
			 * });
			 * 
			 * @param callback
			 * 			The error handler.
			 * 
			 * @throws
			 * 			The Error will be thrown when the "callback" is missing.<br/>
			 * 			Or it will be thrown when the "callback" is not undefined or null, or not a Function.
			 */
			setErrorHandler: function(callback) {
				_ensures(arguments.length > 0, "The 'callback' is required, index: 0");
				_ensures(_isUndefinedOrNull(callback) || _isFunction(callback), "The 'callback' is not undefined or null, or not a Function");

				_onError = _isFunction(callback) ? callback : null;
			},

			/**
			 * @description
			 * <p>
			 * Returns the global timeout handler.
			 * </p>
			 * 
			 * @return The Function.
			 */
			getTimeoutHandler: function() {
				return _onTimeout;
			},

			/**
			 * @description
			 * <p>
			 * Sets the global timeout handler.
			 * If there is no "onTimeout" option for each request, the global setting will be applied.
			 * Otherwise, using the individual "onTimeout" setting of each request.
			 * </p>
			 * <p>
			 * A undefined or null argument of "callback" passes in will remove the handler.
			 * </p>
			 * 
			 * @example
			 * <b>Examples</b>
			 * 
			 * xeno.remoting.web.Engine.setTimeoutHandler(function(xhr) {
			 * 
			 * 	[xhr Object]
			 * 	The original XML HTTP request, never be undefined or null.
			 * 
			 * });
			 * 
			 * @param callback
			 * 			The timeout handler.
			 * 
			 * @throws
			 * 			The Error will be thrown when the "callback" is missing.<br/>
			 * 			Or it will be thrown when the "callback" is not undefined or null, or not a Function.
			 */
			setTimeoutHandler: function(callback) {
				_ensures(arguments.length > 0, "The 'callback' is required, index: 0");
				_ensures(_isUndefinedOrNull(callback) || _isFunction(callback), "The 'callback' is not undefined or null, or not a Function");

				_onTimeout = _isFunction(callback) ? callback : null;
			},

			/**
			 * @description
			 * <p>
			 * Returns the global complete handler.
			 * </p>
			 * 
			 * @return The Function.
			 */
			getCompleteHandler: function() {
				return _onComplete;
			},

			/**
			 * @description
			 * <p>
			 * Sets the global complete handler.
			 * If there is no "onComplete" option for each request, the global setting will be applied.
			 * Otherwise, using the individual "onComplete" setting of each request.
			 * </p>
			 * <p>
			 * A undefined or null argument of "callback" passes in will remove the handler.
			 * </p>
			 * 
			 * @example
			 * <b>Examples</b>
			 * 
			 * xeno.remoting.web.Engine.setCompleteHandler(function(status, xhr) {
			 * 
			 * 	[status String]
			 * 	A text to summarize the status, never be undefined or null.
			 * 	The possible values are: success, error, timeout, abort.
			 * 
			 * 	[xhr Object]
			 * 	The original XML HTTP request, never be undefined or null.
			 * 
			 * });
			 * 
			 * @param callback
			 * 			The complete handler.
			 * 
			 * @throws
			 * 			The Error will be thrown when the "callback" is missing.<br/>
			 * 			Or it will be thrown when the "callback" is not undefined or null, or not a Function.
			 */
			setCompleteHandler: function(callback) {
				_ensures(arguments.length > 0, "The 'callback' is required, index: 0");
				_ensures(_isUndefinedOrNull(callback) || _isFunction(callback), "The 'callback' is not undefined or null, or not a Function");

				_onComplete = _isFunction(callback) ? callback : null;
			},

			/**
			 * @description
			 * <p>
			 * Returns the reverse AJAX progress handler.
			 * </p>
			 * 
			 * @return The Function.
			 */
			getReverseAjaxProgressHandler: function() {
				return _onReverseAjaxProgress;
			},

			/**
			 * @description
			 * <p>
			 * Sets the handler to monitor the reverse AJAX status.
			 * This function will be triggered when each reverse AJAX period start.
			 * </p>
			 * <p>
			 * A undefined or null argument of "callback" passes in will remove the handler.
			 * </p>
			 * 
			 * @example
			 * <b>Examples</b>
			 * 
			 * xeno.remoting.web.Engine.setReverseAjaxProgressHandler(function() {
			 * 	// Do your logic here...
			 * });
			 * 
			 * @param callback
			 * 			The reverse AJAX progress handler.
			 * 
			 * @throws
			 * 			The Error will be thrown when the "callback" is missing.<br/>
			 * 			Or it will be thrown when the "callback" is not undefined or null, or not a Function.
			 */
			setReverseAjaxProgressHandler: function(callback) {
				_ensures(arguments.length > 0, "The 'callback' is required, index: 0");
				_ensures(_isUndefinedOrNull(callback) || _isFunction(callback), "The 'callback' is not undefined or null, or not a Function");

				_onReverseAjaxProgress = _isFunction(callback) ? callback : null;
			},

			/**
			 * @description
			 * <p>
			 * Returns the reverse AJAX complete handler.
			 * </p>
			 * 
			 * @return The Function.
			 */
			getReverseAjaxCompleteHandler: function() {
				return _onReverseAjaxComplete;
			},

			/**
			 * @description
			 * <p>
			 * Sets the handler to monitor the reverse AJAX status.
			 * This function will be triggered when all reverse AJAX periods complete.
			 * For an example, the reverse AJAX has tried the max count during error occurs.
			 * </p>
			 * <p>
			 * A undefined or null argument of "callback" passes in will remove the handler.
			 * </p>
			 * 
			 * @example
			 * <b>Examples</b>
			 * 
			 * xeno.remoting.web.Engine.setReverseAjaxCompleteHandler(function() {
			 * 	// Do your logic here...
			 * });
			 * 
			 * @param callback
			 * 			The reverse AJAX complete handler.
			 * 
			 * @throws
			 * 			The Error will be thrown when the "callback" is missing.<br/>
			 * 			Or it will be thrown when the "callback" is not undefined or null, or not a Function.
			 */
			setReverseAjaxCompleteHandler: function(callback) {
				_ensures(arguments.length > 0, "The 'callback' is required, index: 0");
				_ensures(_isUndefinedOrNull(callback) || _isFunction(callback), "The 'callback' is not undefined or null, or not a Function");

				_onReverseAjaxComplete = _isFunction(callback) ? callback : null;
			},

			/**
			 * @description
			 * <p>
			 * Returns the whether the reverse AJAX feature is enabled or not.
			 * </p>
			 * <p>
			 * If you have enabled the reverse AJAX feature, but reverse AJAX thread failed after the specific continuous error retry count, this value will return false when all reverse AJAX thread have been stopped.
			 * </p>
			 * 
			 * @return The Boolean.
			 */
			isReverseAjaxEnabled: function() {
				return _reverseAjaxEnabled && ("${Param.Value.ReverseAjaxMaxRetryCount}" === 0 || _reverseAjaxRetryCount < "${Param.Value.ReverseAjaxMaxRetryCount}");
			},

			/**
			 * @description
			 * <p>
			 * Enables the reverse AJAX feature or not.
			 * </p>
			 * 
			 * @param flag
			 * 			The flag, true to enabled the reverse AJAX feature.
			 * 
			 * @throws
			 * 			The Error will be thrown when the "flag" is missing.<br/>
			 * 			Or it will be thrown when the "flag" is not a Boolean.
			 */
			setReverseAjaxEnabled: function(flag) {
				_ensures(arguments.length > 0, "The 'flag' is required, index: 0");
				_ensures(_isBoolean(flag), "The 'flag' is not a Boolean");

				_reverseAjaxEnabled = flag;

				if(_reverseAjaxEnabled === true) {

					if(_isUndefinedOrNull(_reverseAjaxProgress)) {
						_reverseAjaxRetryCount = 0;
						_polling();
					}

				} else {

					try {
						_reverseAjaxProgress.abort();

					} catch(err) {
						// Does nothing.
					}
				}
			}
		};
	})();
}
