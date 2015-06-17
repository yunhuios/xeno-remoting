var withSessionIdsCallback = function(f, d) {
	var output = document.getElementById("txtOutput");

	append(output, "Handled session ID callback in 'index.jsp'", true);
	append(output, "<Document> id=" + d.id + ", displayName=" + d.displayName);
	append(output, "<Folder> id=" + f.id + ", displayName=" + f.displayName);

	for(var i in f.documents) {
		append(output, "<Child Document> id=" + f.documents[i].id + ", displayName=" + f.documents[i].displayName);
	}
};

var withPageUrisCallback = function(f, d) {
	var output = document.getElementById("txtOutput");

	append(output, "Handled page URI callback in 'index.jsp'", true);
	append(output, "<Document> id=" + d.id + ", displayName=" + d.displayName);
	append(output, "<Folder> id=" + f.id + ", displayName=" + f.displayName);

	for(var i in f.documents) {
		append(output, "<Child Document> id=" + f.documents[i].id + ", displayName=" + f.documents[i].displayName);
	}
};

window.onload = function() {
	var output = document.getElementById("txtOutput");

	xeno.remoting.web.Engine.setReverseAjaxProgressHandler(function() {
		append(output, "Caught reverse AJAX progress handler, callback arguments count: " + arguments.length, true);
		append(output, "Is reverse AJAX enabled: " + xeno.remoting.web.Engine.isReverseAjaxEnabled());
	});

	xeno.remoting.web.Engine.setReverseAjaxCompleteHandler(function() {
		append(output, "Caught reverse AJAX complete handler, callback arguments count: " + arguments.length, true);
		append(output, "Is reverse AJAX enabled: " + xeno.remoting.web.Engine.isReverseAjaxEnabled());
	});

	// Global settings.
	var onBeforeSend = function(header) {
		append(output, "Caught global before send handler, callback arguments count: " + arguments.length, true);
	};

	var onSuccess = function(result, xhr) {
		append(output, "Caught global success handler, callback arguments count: " + arguments.length, true);
	};

	var onError = function(fault, xhr) {
		append(output, "Caught global error handler, callback arguments count: " + arguments.length, true);
	};

	var onTimeout = function(xhr) {
		append(output, "Caught global timeout handler, callback arguments count: " + arguments.length, true);
	};

	var onComplete = function(status, xhr) {
		append(output, "Caught global complete handler, callback arguments count: " + arguments.length + ", status: " + status, true);
	};

	document.getElementById("btnClear").onclick = function(evt) {
		output.value = "";
	};

	// Reverse AJAX.
	document.getElementById("btnSwitchReverseAjax").onclick = function(evt) {
		xeno.remoting.web.Engine.setReverseAjaxEnabled(this.checked);
	};

	document.getElementById("btnEnableReverseAjax").onclick = function(evt) {
		xeno.remoting.web.Engine.setReverseAjaxEnabled(true);
	};

	document.getElementById("btnDisableReverseAjax").onclick = function(evt) {
		xeno.remoting.web.Engine.setReverseAjaxEnabled(false);
	};

	// Single Global Calling Options.
	document.getElementById("btnCallWebMethodWithGlobalNoneOption").onclick = function(evt) {
		clear(output);

		com.since10.web.BasicFunctionController.testComplete();
	};

	document.getElementById("btnCallWebMethodWithGlobalTimeoutOnly").onclick = function(evt) {
		clear(output);

		xeno.remoting.web.Engine.setTimeout(5000);
		xeno.remoting.web.Engine.setTimeoutHandler(onTimeout);

		com.since10.web.BasicFunctionController.testTimeout1();
	};

	document.getElementById("btnCallWebMethodWithGlobalBeforeSendOnly").onclick = function(evt) {
		clear(output);

		xeno.remoting.web.Engine.setBeforeSendHandler(onBeforeSend);

		com.since10.web.BasicFunctionController.testComplete();
	};

	document.getElementById("btnCallWebMethodWithGlobalSuccessOnly").onclick = function(evt) {
		clear(output);

		xeno.remoting.web.Engine.setSuccessHandler(onSuccess);

		com.since10.web.BasicFunctionController.testComplete();
	};

	document.getElementById("btnCallWebMethodWithGlobalErrorOnly").onclick = function(evt) {
		clear(output);

		xeno.remoting.web.Engine.setErrorHandler(onError);

		com.since10.web.BasicFunctionController.testError();
	};

	document.getElementById("btnCallWebMethodWithGlobalCompleteOnly").onclick = function(evt) {
		clear(output);

		xeno.remoting.web.Engine.setCompleteHandler(onComplete);

		com.since10.web.BasicFunctionController.testComplete();
	};

	// Single Local Calling Options.
	document.getElementById("btnCallWebMethodWithLocalNoneOption").onclick = function(evt) {
		clear(output);

		com.since10.web.BasicFunctionController.testComplete();
	};

	document.getElementById("btnCallWebMethodWithLocalTimeoutOnly").onclick = function(evt) {
		clear(output);

		com.since10.web.BasicFunctionController.testTimeout1({
			timeout: 5000,
			onTimeout: function(xhr) {
				append(output, "Caught local timeout handler, callback arguments count: " + arguments.length, true);
			}
		});
	};

	document.getElementById("btnCallWebMethodWithLocalBeforeSendOnly").onclick = function(evt) {
		clear(output);

		com.since10.web.BasicFunctionController.testComplete({
			onBeforeSend: function(header) {
				append(output, "Caught local before send handler, callback arguments count: " + arguments.length, true);
			}
		});
	};

	document.getElementById("btnCallWebMethodWithLocalSuccessOnly").onclick = function(evt) {
		clear(output);

		com.since10.web.BasicFunctionController.testComplete({
			onSuccess: function(result, xhr) {
				append(output, "Caught local success handler, callback arguments count: " + arguments.length, true);
			}
		});
	};

	document.getElementById("btnCallWebMethodWithLocalErrorOnly").onclick = function(evt) {
		clear(output);

		com.since10.web.BasicFunctionController.testError({
			onError: function(fault, xhr) {
				append(output, "Caught local error handler, callback arguments count: " + arguments.length, true);
			}
		});
	};

	document.getElementById("btnCallWebMethodWithLocalCompleteOnly").onclick = function(evt) {
		clear(output);

		com.since10.web.BasicFunctionController.testComplete({
			onComplete: function(status, xhr) {
				append(output, "Caught local complete handler, callback arguments count: " + arguments.length + ", status: " + status, true);
			}
		});
	};

	// Integrated Global Calling Options.
	document.getElementById("btnCallWebMethodWithGlobalTimeout1").onclick = function(evt) {
		clear(output);

		xeno.remoting.web.Engine.setTimeout(5000);
		xeno.remoting.web.Engine.setBeforeSendHandler(onBeforeSend);
		xeno.remoting.web.Engine.setSuccessHandler(onSuccess);
		xeno.remoting.web.Engine.setErrorHandler(onError);
		xeno.remoting.web.Engine.setTimeoutHandler(onTimeout);
		xeno.remoting.web.Engine.setCompleteHandler(onComplete);

		com.since10.web.BasicFunctionController.testTimeout1();
	};

	document.getElementById("btnCallWebMethodWithGlobalTimeout2").onclick = function(evt) {
		clear(output);

		xeno.remoting.web.Engine.setTimeout(0);
		xeno.remoting.web.Engine.setBeforeSendHandler(onBeforeSend);
		xeno.remoting.web.Engine.setSuccessHandler(function(result, xhr) {
			append(output, "Caught global success handler, callback arguments count: " + arguments.length, true);
			append(output, result.data);
		});
		xeno.remoting.web.Engine.setErrorHandler(onError);
		xeno.remoting.web.Engine.setTimeoutHandler(onTimeout);
		xeno.remoting.web.Engine.setCompleteHandler(onComplete);

		com.since10.web.BasicFunctionController.testTimeout2();
	};

	document.getElementById("btnCallWebMethodWithGlobalBeforeSend").onclick = function(evt) {
		clear(output);

		xeno.remoting.web.Engine.setTimeout(0);
		xeno.remoting.web.Engine.setBeforeSendHandler(function(header) {
			append(output, "Caught global before send handler, callback arguments count: " + arguments.length, true);

			header.prop1 = "g-prop-1";
			header["prop-2"] = true;
			header["prop-3"] = 300;
			header[new Date()] = true;

			for(var i in header) {
				append(output, i + "=" + header[i]);
			}
		});
		xeno.remoting.web.Engine.setSuccessHandler(function(result, xhr) {
			append(output, "Caught global success handler, callback arguments count: " + arguments.length, true);

			for(var i in result.data) {
				append(output, i + "=" + result.data[i]);
			}
		});
		xeno.remoting.web.Engine.setErrorHandler(onError);
		xeno.remoting.web.Engine.setTimeoutHandler(onTimeout);
		xeno.remoting.web.Engine.setCompleteHandler(onComplete);

		com.since10.web.BasicFunctionController.testBeforeSend();
	};

	document.getElementById("btnCallWebMethodWithGlobalSuccess").onclick = function(evt) {
		clear(output);

		xeno.remoting.web.Engine.setTimeout(0);
		xeno.remoting.web.Engine.setBeforeSendHandler(onBeforeSend);
		xeno.remoting.web.Engine.setSuccessHandler(function(result, xhr) {
			append(output, "Caught global success handler, callback arguments count: " + arguments.length, true);
			append(output, "<Folder> id=" + result.data.id + ", displayName=" + result.data.displayName);

			for(var i in result.data.documents) {
				append(output, "<Document> id=" + result.data.documents[i].id + ", displayName=" + result.data.documents[i].displayName);
			}
		});
		xeno.remoting.web.Engine.setErrorHandler(onError);
		xeno.remoting.web.Engine.setTimeoutHandler(onTimeout);
		xeno.remoting.web.Engine.setCompleteHandler(onComplete);

		com.since10.web.BasicFunctionController.testSuccess({
			id: 10001,
			displayName: "Root",
			documents: [{
				id: 2001,
				displayName: "爪哇语言"
			}, {
				id: 2002,
				displayName: "C#"
			}]
		}, {
			id: 2003,
			displayName: "软件工程"
		});
	};

	document.getElementById("btnCallWebMethodWithGlobalError").onclick = function(evt) {
		clear(output);

		xeno.remoting.web.Engine.setTimeout(0);
		xeno.remoting.web.Engine.setBeforeSendHandler(onBeforeSend);
		xeno.remoting.web.Engine.setSuccessHandler(onSuccess);
		xeno.remoting.web.Engine.setErrorHandler(function(fault, xhr) {
			append(output, "Caught global error handler, callback arguments count: " + arguments.length, true);
			append(output, "<Error> type=" + fault.type + ", message=" + fault.message + ", data=" + fault.data);
		});
		xeno.remoting.web.Engine.setTimeoutHandler(onTimeout);
		xeno.remoting.web.Engine.setCompleteHandler(onComplete);

		com.since10.web.BasicFunctionController.testError();
	};

	document.getElementById("btnCallWebMethodWithGlobalComplete").onclick = function(evt) {
		clear(output);

		xeno.remoting.web.Engine.setTimeout(0);
		xeno.remoting.web.Engine.setBeforeSendHandler(onBeforeSend);
		xeno.remoting.web.Engine.setSuccessHandler(onSuccess);
		xeno.remoting.web.Engine.setErrorHandler(onError);
		xeno.remoting.web.Engine.setTimeoutHandler(onTimeout);
		xeno.remoting.web.Engine.setCompleteHandler(onComplete);

		com.since10.web.BasicFunctionController.testComplete();
	};

	// Integrated Local Calling Options.
	document.getElementById("btnCallWebMethodWithLocalTimeout1").onclick = function(evt) {
		clear(output);

		xeno.remoting.web.Engine.setTimeout(0);
		xeno.remoting.web.Engine.setBeforeSendHandler(onBeforeSend);
		xeno.remoting.web.Engine.setSuccessHandler(onSuccess);
		xeno.remoting.web.Engine.setErrorHandler(onError);
		xeno.remoting.web.Engine.setTimeoutHandler(onTimeout);
		xeno.remoting.web.Engine.setCompleteHandler(onComplete);

		com.since10.web.BasicFunctionController.testTimeout1({
			timeout: 5000,
			onTimeout: function(xhr) {
				append(output, "Caught local timeout handler, callback arguments count: " + arguments.length, true);
			}
		});
	};

	document.getElementById("btnCallWebMethodWithLocalTimeout2").onclick = function(evt) {
		clear(output);

		xeno.remoting.web.Engine.setTimeout(0);
		xeno.remoting.web.Engine.setBeforeSendHandler(onBeforeSend);
		xeno.remoting.web.Engine.setSuccessHandler(onSuccess);
		xeno.remoting.web.Engine.setErrorHandler(onError);
		xeno.remoting.web.Engine.setTimeoutHandler(onTimeout);
		xeno.remoting.web.Engine.setCompleteHandler(onComplete);

		com.since10.web.BasicFunctionController.testTimeout2({
			onSuccess: function(result, xhr) {
				append(output, "Caught local success handler, callback arguments count: " + arguments.length, true);
				append(output, result.data);
			}
		});
	};

	document.getElementById("btnCallWebMethodWithLocalBeforeSend").onclick = function(evt) {
		clear(output);

		xeno.remoting.web.Engine.setTimeout(0);
		xeno.remoting.web.Engine.setBeforeSendHandler(onBeforeSend);
		xeno.remoting.web.Engine.setSuccessHandler(onSuccess);
		xeno.remoting.web.Engine.setErrorHandler(onError);
		xeno.remoting.web.Engine.setTimeoutHandler(onTimeout);
		xeno.remoting.web.Engine.setCompleteHandler(onComplete);

		com.since10.web.BasicFunctionController.testBeforeSend({
			onBeforeSend: function(header) {
				append(output, "Caught local before send handler, callback arguments count: " + arguments.length, true);

				header.prop1 = "g-prop-1";
				header["prop-2"] = true;
				header["prop-3"] = 300;
				header[new Date()] = true;

				for(var i in header) {
					append(output, i + "=" + header[i]);
				}
			},
			onSuccess: function(result, xhr) {
				append(output, "Caught local success handler, callback arguments count: " + arguments.length, true);

				for(var i in result.data) {
					append(output, i + "=" + result.data[i]);
				}
			}
		});
	};

	document.getElementById("btnCallWebMethodWithLocalSuccess").onclick = function(evt) {
		clear(output);

		xeno.remoting.web.Engine.setTimeout(0);
		xeno.remoting.web.Engine.setBeforeSendHandler(onBeforeSend);
		xeno.remoting.web.Engine.setSuccessHandler(onSuccess);
		xeno.remoting.web.Engine.setErrorHandler(onError);
		xeno.remoting.web.Engine.setTimeoutHandler(onTimeout);
		xeno.remoting.web.Engine.setCompleteHandler(onComplete);

		com.since10.web.BasicFunctionController.testSuccess({
			id: 10001,
			displayName: "Root",
			documents: [{
				id: 2001,
				displayName: "爪哇语言"
			}, {
				id: 2002,
				displayName: "C#"
			}]
		}, {
			id: 2003,
			displayName: "软件工程"
		}, {
			onSuccess: function(result, xhr) {
				append(output, "Caught local success handler, callback arguments count: " + arguments.length, true);
				append(output, "<Folder> id=" + result.data.id + ", displayName=" + result.data.displayName);

				for(var i in result.data.documents) {
					append(output, "<Document> id=" + result.data.documents[i].id + ", displayName=" + result.data.documents[i].displayName);
				}
			}
		});
	};

	document.getElementById("btnCallWebMethodWithLocalError").onclick = function(evt) {
		clear(output);

		xeno.remoting.web.Engine.setTimeout(0);
		xeno.remoting.web.Engine.setBeforeSendHandler(onBeforeSend);
		xeno.remoting.web.Engine.setSuccessHandler(onSuccess);
		xeno.remoting.web.Engine.setErrorHandler(onError);
		xeno.remoting.web.Engine.setTimeoutHandler(onTimeout);
		xeno.remoting.web.Engine.setCompleteHandler(onComplete);

		com.since10.web.BasicFunctionController.testError({
			onError: function(fault, xhr) {
				append(output, "Caught local error handler, callback arguments count: " + arguments.length, true);
				append(output, "<Error> type=" + fault.type + ", message=" + fault.message + ", data=" + fault.data);
			}
		});
	};

	document.getElementById("btnCallWebMethodWithLocalComplete").onclick = function(evt) {
		clear(output);

		xeno.remoting.web.Engine.setTimeout(0);
		xeno.remoting.web.Engine.setBeforeSendHandler(onBeforeSend);
		xeno.remoting.web.Engine.setSuccessHandler(onSuccess);
		xeno.remoting.web.Engine.setErrorHandler(onError);
		xeno.remoting.web.Engine.setTimeoutHandler(onTimeout);
		xeno.remoting.web.Engine.setCompleteHandler(onComplete);

		com.since10.web.BasicFunctionController.testComplete({
			onComplete: function(status, xhr) {
				append(output, "Caught local complete handler, callback arguments count: " + arguments.length + ", status: " + status, true);
			}
		});
	};

	// Abort Running Request.
	var progress= null;

	document.getElementById("btnStartLongTimeResponse").onclick = function(evt) {
		clear(output);

		progress = com.since10.web.ResponseSuspendedController.performTask({
			onComplete: function(status, xhr) {
				append(output, "Caught local complete handler, callback arguments count: " + arguments.length + ", status: " + status, true);
			}
		});
	};

	document.getElementById("btnAbortLongTimeResponse").onclick = function(evt) {

		if(progress != null) {
			progress.abort();
		}
	};

	// Handling Exceptions.
	document.getElementById("btnCallWebMethodWithException1").onclick = function(evt) {
		clear(output);

		com.since10.web.ExceptionHandledController.testFailedDeserialization("a", {
			onError: function(fault, xhr) {
				append(output, "Caught local error handler, callback arguments count: " + arguments.length, true);
				append(output, "<Error> type=" + fault.type + ", message=" + fault.message + ", data=" + fault.data);
			}
		});
	};

	document.getElementById("btnCallWebMethodWithException2").onclick = function(evt) {
		clear(output);

		com.since10.web.ExceptionHandledController.testFailedSerialization({
			onError: function(fault, xhr) {
				append(output, "Caught local error handler, callback arguments count: " + arguments.length, true);
				append(output, "<Error> type=" + fault.type + ", message=" + fault.message + ", data=" + fault.data);
			}
		});
	};

	document.getElementById("btnCallWebMethodWithException3").onclick = function(evt) {
		clear(output);

		com.since10.web.ExceptionHandledController.testCustomException({
			onError: function(fault, xhr) {
				append(output, "Caught local error handler, callback arguments count: " + arguments.length, true);
				append(output, "<Error> type=" + fault.type + ", message=" + fault.message + ", data=" + fault.data);
			}
		});
	};

	document.getElementById("btnCallWebMethodWithUnhandlableException1").onclick = function(evt) {
		clear(output);

		com.since10.web.ExceptionHandledController.testUnhandlableException1({
			onError: function(fault, xhr) {
				append(output, "Caught local error handler, callback arguments count: " + arguments.length, true);
				append(output, "<Error> type=" + fault.type + ", message=" + fault.message + ", data=" + fault.data);
			}
		});
	};

	document.getElementById("btnCallWebMethodWithUnhandlableException2").onclick = function(evt) {
		clear(output);

		com.since10.web.ExceptionHandledController.testUnhandlableException2({
			onError: function(fault, xhr) {
				append(output, "Caught local error handler, callback arguments count: " + arguments.length, true);
				append(output, "<Error> type=" + fault.type + ", message=" + fault.message + ", data=" + fault.data);
			}
		});
	};

	// Spring Framework Integration.
	document.getElementById("btnSpringFrameworkIntegration1").onclick = function(evt) {
		clear(output);

		com.since10.web.BasicFunctionController.testSpringBean("sn-201b", {
			onSuccess: function(result, xhr) {
				append(output, "Caught local success handler, callback arguments count: " + arguments.length, true);
				append(output, result.data);
			}
		});
	};

	document.getElementById("btnSpringFrameworkIntegration2").onclick = function(evt) {
		clear(output);

		var _request = null;

		if(window.XMLHttpRequest) {
			_request = new XMLHttpRequest();

		} else if(window.ActiveXObject) {
			_request = new ActiveXObject("Microsoft.XMLHTTP");
		}

		if(_request === null) {
			alert("Your browser does not support AJAX!");

		} else {

			_request.onreadystatechange = function(evt) {
				var readyState = _request.readyState;

				if(readyState === 4) {
					append(output, "Caught data from server: " + _request.responseText, true);
				}
			};

			_request.open("POST", CONTEXT_PATH + "/basic/function/test.do", true);
			_request.send();
		}
	};
};
