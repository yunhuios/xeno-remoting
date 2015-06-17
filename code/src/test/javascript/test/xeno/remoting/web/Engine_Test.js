describe("xeno.remoting.web.Engine.Engine", function() {

	it("registerClass", function() {

		// Tests required arguments.
		expect(function() { xeno.remoting.web.Engine.registerClass(); }).toThrow(new Error("The 'name' is required, index: 0"));

		// Tests arguments data types.
		expect(function() { xeno.remoting.web.Engine.registerClass(undefined); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.registerClass(null); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.registerClass(1); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.registerClass(1.1); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.registerClass(-3); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.registerClass(new Number()); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.registerClass(1.2E3); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.registerClass(0xFF); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.registerClass(NaN); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.registerClass(Infinity); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.registerClass(true); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.registerClass(new Boolean()); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.registerClass([]); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.registerClass(new Array()); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.registerClass(/[w]/); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.registerClass(new RegExp()); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.registerClass(new Date()); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.registerClass({}); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.registerClass(new Object()); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.registerClass(function() {}); }).toThrow(new Error("The 'name' is not a String"));

		// Test invalid namespaces.
		expect(function() { xeno.remoting.web.Engine.registerClass(""); }).toThrow(new Error("The 'name' is not a valid class name: "));
		expect(function() { xeno.remoting.web.Engine.registerClass(" "); }).toThrow(new Error("The 'name' is not a valid class name:  "));
		expect(function() { xeno.remoting.web.Engine.registerClass("2com"); }).toThrow(new Error("The 'name' is not a valid class name: 2com"));
		expect(function() { xeno.remoting.web.Engine.registerClass("com.2since10"); }).toThrow(new Error("The 'name' is not a valid class name: com.2since10"));
		expect(function() { xeno.remoting.web.Engine.registerClass("com.2since10.service.UserService.test"); }).toThrow(new Error("The 'name' is not a valid class name: com.2since10.service.UserService.test"));
		expect(function() { xeno.remoting.web.Engine.registerClass("com.since10.service..UserService.test"); }).toThrow(new Error("The 'name' is not a valid class name: com.since10.service..UserService.test"));
		expect(function() { xeno.remoting.web.Engine.registerClass(".com.since10.service.UserService.test"); }).toThrow(new Error("The 'name' is not a valid class name: .com.since10.service.UserService.test"));
		expect(function() { xeno.remoting.web.Engine.registerClass("com.since10.service.UserService.test."); }).toThrow(new Error("The 'name' is not a valid class name: com.since10.service.UserService.test."));

		// Tests normal scenarios.
		window.xxa = {
			a: {},
			b: {
				a: {}
			},
			C: {}
		};

		expect(window.xxxa).toBeUndefined();

		xeno.remoting.web.Engine.registerClass("xxxa.b.c.d.e.f");
		expect(window.xxxa).toEqual({
			b: {
				c: {
					d: {
						e: {
							f: {}
						}
					}
				}
			}
		});

		xeno.remoting.web.Engine.registerClass("xxxa.b.c");
		expect(window.xxxa).toEqual({
			b: {
				c: {
					d: {
						e: {
							f: {}
						}
					}
				}
			}
		});

		xeno.remoting.web.Engine.registerClass("xxxa.b.c.$");
		expect(window.xxxa).toEqual({
			b: {
				c: {
					d: {
						e: {
							f: {}
						}
					},
					$: {}
				}
			}
		});

		expect(window.xxxb).toBeUndefined();

		xeno.remoting.web.Engine.registerClass("xxxb");
		expect(window.xxxb).toEqual({});

		expect(window.xxa.C.xc60).toBeUndefined();

		xeno.remoting.web.Engine.registerClass("xxa.C.xc60._China.Jiading_");
		expect(window.xxa).toEqual({
			a: {},
			b: {
				a: {}
			},
			C: {
				xc60: {
					_China: {
						Jiading_: {}
					}
				}
			}
		});
	});

	it("processRemoteCall", function() {

		// Tests required arguments.
		expect(function() { xeno.remoting.web.Engine.processRemoteCall(); }).toThrow(new Error("The 'name' is required, index: 0"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a"); }).toThrow(new Error("The 'method' is required, index: 1"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", "b"); }).toThrow(new Error("The 'params' is required, index: 2"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", "b", []); }).toThrow(new Error("The 'option' is required, index: 3"));

		// Tests arguments data types.
		expect(function() { xeno.remoting.web.Engine.processRemoteCall(undefined, "b", [], {}); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall(null, "b", [], {}); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall(1, "b", [], {}); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall(1.1, "b", [], {}); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall(-3, "b", [], {}); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall(new Number(), "b", [], {}); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall(1.2E3, "b", [], {}); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall(0xFF, "b", [], {}); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall(NaN, "b", [], {}); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall(Infinity, "b", [], {}); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall(true, "b", [], {}); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall(new Boolean(), "b", [], {}); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall([], "b", [], {}); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall(new Array(), "b", [], {}); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall(/[w]/, "b", [], {}); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall(new RegExp(), "b", [], {}); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall(new Date(), "b", [], {}); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall({}, "b", [], {}); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall(new Object(), "b", [], {}); }).toThrow(new Error("The 'name' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall(function() {}, "b", [], {}); }).toThrow(new Error("The 'name' is not a String"));

		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", undefined, [], {}); }).toThrow(new Error("The 'method' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", null, [], {}); }).toThrow(new Error("The 'method' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", 1, [], {}); }).toThrow(new Error("The 'method' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", 1.1, [], {}); }).toThrow(new Error("The 'method' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", -3, [], {}); }).toThrow(new Error("The 'method' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", new Number(), [], {}); }).toThrow(new Error("The 'method' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", 1.2E3, [], {}); }).toThrow(new Error("The 'method' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", 0xFF, [], {}); }).toThrow(new Error("The 'method' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", NaN, [], {}); }).toThrow(new Error("The 'method' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", Infinity, [], {}); }).toThrow(new Error("The 'method' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", true, [], {}); }).toThrow(new Error("The 'method' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", new Boolean(), [], {}); }).toThrow(new Error("The 'method' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", [], [], {}); }).toThrow(new Error("The 'method' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", new Array(), [], {}); }).toThrow(new Error("The 'method' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", /[w]/, [], {}); }).toThrow(new Error("The 'method' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", new RegExp(), [], {}); }).toThrow(new Error("The 'method' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", new Date(), [], {}); }).toThrow(new Error("The 'method' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", {}, [], {}); }).toThrow(new Error("The 'method' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", new Object(), [], {}); }).toThrow(new Error("The 'method' is not a String"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", function() {}, [], {}); }).toThrow(new Error("The 'method' is not a String"));

		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", "b", undefined, {}); }).toThrow(new Error("The 'params' is not an Array"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", "b", null, {}); }).toThrow(new Error("The 'params' is not an Array"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", "b", 1, {}); }).toThrow(new Error("The 'params' is not an Array"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", "b", 1.1, {}); }).toThrow(new Error("The 'params' is not an Array"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", "b", -3, {}); }).toThrow(new Error("The 'params' is not an Array"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", "b", new Number(), {}); }).toThrow(new Error("The 'params' is not an Array"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", "b", 1.2E3, {}); }).toThrow(new Error("The 'params' is not an Array"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", "b", 0xFF, {}); }).toThrow(new Error("The 'params' is not an Array"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", "b", NaN, {}); }).toThrow(new Error("The 'params' is not an Array"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", "b", Infinity, {}); }).toThrow(new Error("The 'params' is not an Array"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", "b", true, {}); }).toThrow(new Error("The 'params' is not an Array"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", "b", new Boolean(), {}); }).toThrow(new Error("The 'params' is not an Array"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", "b", "", {}); }).toThrow(new Error("The 'params' is not an Array"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", "b", new String(), {}); }).toThrow(new Error("The 'params' is not an Array"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", "b", /[w]/, {}); }).toThrow(new Error("The 'params' is not an Array"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", "b", new RegExp(), {}); }).toThrow(new Error("The 'params' is not an Array"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", "b", new Date(), {}); }).toThrow(new Error("The 'params' is not an Array"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", "b", {}, {}); }).toThrow(new Error("The 'params' is not an Array"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", "b", new Object(), {}); }).toThrow(new Error("The 'params' is not an Array"));
		expect(function() { xeno.remoting.web.Engine.processRemoteCall("a", "b", function() {}, {}); }).toThrow(new Error("The 'params' is not an Array"));

		// Tests normal scenarios.
		var globalTimeout = 10000;
		var globalBeforeSendHandler = function() {};
		var globalSuccessHandler = function() {};
		var globalErrorHandler = function() {};
		var globalTimeoutHandler = function() {};
		var globalCompleteHandler = function() {};

		var localTimeout = 20000;
		var localBeforeSendHandler = function() {};
		var localSuccessHandler = function() {};
		var localErrorHandler = function() {};
		var localTimeoutHandler = function() {};
		var localCompleteHandler = function() {};

		expect(globalTimeout).not.toBe(localTimeout);
		expect(globalBeforeSendHandler).not.toBe(localBeforeSendHandler);
		expect(globalSuccessHandler).not.toBe(localSuccessHandler);
		expect(globalErrorHandler).not.toBe(localErrorHandler);
		expect(globalTimeoutHandler).not.toBe(localTimeoutHandler);
		expect(globalCompleteHandler).not.toBe(localCompleteHandler);

		var reset = function() {
			xeno.remoting.web.Engine.setTimeout(0);
			xeno.remoting.web.Engine.setBeforeSendHandler(null);
			xeno.remoting.web.Engine.setSuccessHandler(null);
			xeno.remoting.web.Engine.setErrorHandler(null);
			xeno.remoting.web.Engine.setTimeoutHandler(null);
			xeno.remoting.web.Engine.setCompleteHandler(null);
		};

		var progress = xeno.remoting.web.Engine.processRemoteCall("a", "b", [], { internal_preventProgress: true });
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(0);
		expect(xeno.remoting.web.Engine.getBeforeSendHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getSuccessHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getErrorHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getTimeoutHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getCompleteHandler()).toBeNull();
		expect(progress.getStatus()).toBe("init");
		expect(progress.getTimeout()).toBe(0);
		expect(progress.getBeforeSendHandler()).toBeNull();
		expect(progress.getSuccessHandler()).toBeNull();
		expect(progress.getErrorHandler()).toBeNull();
		expect(progress.getTimeoutHandler()).toBeNull();
		expect(progress.getCompleteHandler()).toBeNull();

		// For timeout.
		reset();
		xeno.remoting.web.Engine.setTimeout(globalTimeout);
		progress = xeno.remoting.web.Engine.processRemoteCall("a", "b", [], { internal_preventProgress: true });
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(globalTimeout);
		expect(xeno.remoting.web.Engine.getBeforeSendHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getSuccessHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getErrorHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getTimeoutHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getCompleteHandler()).toBeNull();
		expect(progress.getStatus()).toBe("init");
		expect(progress.getTimeout()).toBe(globalTimeout);
		expect(progress.getBeforeSendHandler()).toBeNull();
		expect(progress.getSuccessHandler()).toBeNull();
		expect(progress.getErrorHandler()).toBeNull();
		expect(progress.getTimeoutHandler()).toBeNull();
		expect(progress.getCompleteHandler()).toBeNull();

		reset();
		progress = xeno.remoting.web.Engine.processRemoteCall("a", "b", [], { internal_preventProgress: true, timeout: localTimeout });
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(0);
		expect(xeno.remoting.web.Engine.getBeforeSendHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getSuccessHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getErrorHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getTimeoutHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getCompleteHandler()).toBeNull();
		expect(progress.getStatus()).toBe("init");
		expect(progress.getTimeout()).toBe(localTimeout);
		expect(progress.getBeforeSendHandler()).toBeNull();
		expect(progress.getSuccessHandler()).toBeNull();
		expect(progress.getErrorHandler()).toBeNull();
		expect(progress.getTimeoutHandler()).toBeNull();
		expect(progress.getCompleteHandler()).toBeNull();

		reset();
		xeno.remoting.web.Engine.setTimeout(globalTimeout);
		progress = xeno.remoting.web.Engine.processRemoteCall("a", "b", [], { internal_preventProgress: true, timeout: localTimeout });
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(globalTimeout);
		expect(xeno.remoting.web.Engine.getBeforeSendHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getSuccessHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getErrorHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getTimeoutHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getCompleteHandler()).toBeNull();
		expect(progress.getStatus()).toBe("init");
		expect(progress.getTimeout()).toBe(localTimeout);
		expect(progress.getBeforeSendHandler()).toBeNull();
		expect(progress.getSuccessHandler()).toBeNull();
		expect(progress.getErrorHandler()).toBeNull();
		expect(progress.getTimeoutHandler()).toBeNull();
		expect(progress.getCompleteHandler()).toBeNull();

		// For before send handler.
		reset();
		xeno.remoting.web.Engine.setBeforeSendHandler(globalBeforeSendHandler);
		progress = xeno.remoting.web.Engine.processRemoteCall("a", "b", [], { internal_preventProgress: true });
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(0);
		expect(xeno.remoting.web.Engine.getBeforeSendHandler()).toBe(globalBeforeSendHandler);
		expect(xeno.remoting.web.Engine.getSuccessHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getErrorHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getTimeoutHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getCompleteHandler()).toBeNull();
		expect(progress.getStatus()).toBe("init");
		expect(progress.getTimeout()).toBe(0);
		expect(progress.getBeforeSendHandler()).toBe(globalBeforeSendHandler);
		expect(progress.getSuccessHandler()).toBeNull();
		expect(progress.getErrorHandler()).toBeNull();
		expect(progress.getTimeoutHandler()).toBeNull();
		expect(progress.getCompleteHandler()).toBeNull();

		reset();
		progress = xeno.remoting.web.Engine.processRemoteCall("a", "b", [], { internal_preventProgress: true, onBeforeSend: localBeforeSendHandler });
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(0);
		expect(xeno.remoting.web.Engine.getBeforeSendHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getSuccessHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getErrorHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getTimeoutHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getCompleteHandler()).toBeNull();
		expect(progress.getStatus()).toBe("init");
		expect(progress.getTimeout()).toBe(0);
		expect(progress.getBeforeSendHandler()).toBe(localBeforeSendHandler);
		expect(progress.getSuccessHandler()).toBeNull();
		expect(progress.getErrorHandler()).toBeNull();
		expect(progress.getTimeoutHandler()).toBeNull();
		expect(progress.getCompleteHandler()).toBeNull();

		reset();
		xeno.remoting.web.Engine.setBeforeSendHandler(globalBeforeSendHandler);
		progress = xeno.remoting.web.Engine.processRemoteCall("a", "b", [], { internal_preventProgress: true, onBeforeSend: localBeforeSendHandler });
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(0);
		expect(xeno.remoting.web.Engine.getBeforeSendHandler()).toBe(globalBeforeSendHandler);
		expect(xeno.remoting.web.Engine.getSuccessHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getErrorHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getTimeoutHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getCompleteHandler()).toBeNull();
		expect(progress.getStatus()).toBe("init");
		expect(progress.getTimeout()).toBe(0);
		expect(progress.getBeforeSendHandler()).toBe(localBeforeSendHandler);
		expect(progress.getSuccessHandler()).toBeNull();
		expect(progress.getErrorHandler()).toBeNull();
		expect(progress.getTimeoutHandler()).toBeNull();
		expect(progress.getCompleteHandler()).toBeNull();

		// For success handler.
		reset();
		xeno.remoting.web.Engine.setSuccessHandler(globalSuccessHandler);
		progress = xeno.remoting.web.Engine.processRemoteCall("a", "b", [], { internal_preventProgress: true });
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(0);
		expect(xeno.remoting.web.Engine.getBeforeSendHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getSuccessHandler()).toBe(globalSuccessHandler);
		expect(xeno.remoting.web.Engine.getErrorHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getTimeoutHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getCompleteHandler()).toBeNull();
		expect(progress.getStatus()).toBe("init");
		expect(progress.getTimeout()).toBe(0);
		expect(progress.getBeforeSendHandler()).toBeNull();
		expect(progress.getSuccessHandler()).toBe(globalSuccessHandler);
		expect(progress.getErrorHandler()).toBeNull();
		expect(progress.getTimeoutHandler()).toBeNull();
		expect(progress.getCompleteHandler()).toBeNull();

		reset();
		progress = xeno.remoting.web.Engine.processRemoteCall("a", "b", [], { internal_preventProgress: true, onSuccess: localSuccessHandler });
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(0);
		expect(xeno.remoting.web.Engine.getBeforeSendHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getSuccessHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getErrorHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getTimeoutHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getCompleteHandler()).toBeNull();
		expect(progress.getStatus()).toBe("init");
		expect(progress.getTimeout()).toBe(0);
		expect(progress.getBeforeSendHandler()).toBeNull();
		expect(progress.getSuccessHandler()).toBe(localSuccessHandler);
		expect(progress.getErrorHandler()).toBeNull();
		expect(progress.getTimeoutHandler()).toBeNull();
		expect(progress.getCompleteHandler()).toBeNull();

		reset();
		xeno.remoting.web.Engine.setSuccessHandler(globalSuccessHandler);
		progress = xeno.remoting.web.Engine.processRemoteCall("a", "b", [], { internal_preventProgress: true, onSuccess: localSuccessHandler });
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(0);
		expect(xeno.remoting.web.Engine.getBeforeSendHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getSuccessHandler()).toBe(globalSuccessHandler);
		expect(xeno.remoting.web.Engine.getErrorHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getTimeoutHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getCompleteHandler()).toBeNull();
		expect(progress.getStatus()).toBe("init");
		expect(progress.getTimeout()).toBe(0);
		expect(progress.getBeforeSendHandler()).toBeNull();
		expect(progress.getSuccessHandler()).toBe(localSuccessHandler);
		expect(progress.getErrorHandler()).toBeNull();
		expect(progress.getTimeoutHandler()).toBeNull();
		expect(progress.getCompleteHandler()).toBeNull();

		// For error handler.
		reset();
		xeno.remoting.web.Engine.setErrorHandler(globalErrorHandler);
		progress = xeno.remoting.web.Engine.processRemoteCall("a", "b", [], { internal_preventProgress: true });
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(0);
		expect(xeno.remoting.web.Engine.getBeforeSendHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getSuccessHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getErrorHandler()).toBe(globalErrorHandler);
		expect(xeno.remoting.web.Engine.getTimeoutHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getCompleteHandler()).toBeNull();
		expect(progress.getStatus()).toBe("init");
		expect(progress.getTimeout()).toBe(0);
		expect(progress.getBeforeSendHandler()).toBeNull();
		expect(progress.getSuccessHandler()).toBeNull();
		expect(progress.getErrorHandler()).toBe(globalErrorHandler);
		expect(progress.getTimeoutHandler()).toBeNull();
		expect(progress.getCompleteHandler()).toBeNull();

		reset();
		progress = xeno.remoting.web.Engine.processRemoteCall("a", "b", [], { internal_preventProgress: true, onError: localErrorHandler });
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(0);
		expect(xeno.remoting.web.Engine.getBeforeSendHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getSuccessHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getErrorHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getTimeoutHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getCompleteHandler()).toBeNull();
		expect(progress.getStatus()).toBe("init");
		expect(progress.getTimeout()).toBe(0);
		expect(progress.getBeforeSendHandler()).toBeNull();
		expect(progress.getSuccessHandler()).toBeNull();
		expect(progress.getErrorHandler()).toBe(localErrorHandler);
		expect(progress.getTimeoutHandler()).toBeNull();
		expect(progress.getCompleteHandler()).toBeNull();

		reset();
		xeno.remoting.web.Engine.setErrorHandler(globalErrorHandler);
		progress = xeno.remoting.web.Engine.processRemoteCall("a", "b", [], { internal_preventProgress: true, onError: localErrorHandler });
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(0);
		expect(xeno.remoting.web.Engine.getBeforeSendHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getSuccessHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getErrorHandler()).toBe(globalErrorHandler);
		expect(xeno.remoting.web.Engine.getTimeoutHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getCompleteHandler()).toBeNull();
		expect(progress.getStatus()).toBe("init");
		expect(progress.getTimeout()).toBe(0);
		expect(progress.getBeforeSendHandler()).toBeNull();
		expect(progress.getSuccessHandler()).toBeNull();
		expect(progress.getErrorHandler()).toBe(localErrorHandler);
		expect(progress.getTimeoutHandler()).toBeNull();
		expect(progress.getCompleteHandler()).toBeNull();

		// For timeout handler.
		reset();
		xeno.remoting.web.Engine.setTimeoutHandler(globalTimeoutHandler);
		progress = xeno.remoting.web.Engine.processRemoteCall("a", "b", [], { internal_preventProgress: true });
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(0);
		expect(xeno.remoting.web.Engine.getBeforeSendHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getSuccessHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getErrorHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getTimeoutHandler()).toBe(globalTimeoutHandler);
		expect(xeno.remoting.web.Engine.getCompleteHandler()).toBeNull();
		expect(progress.getStatus()).toBe("init");
		expect(progress.getTimeout()).toBe(0);
		expect(progress.getBeforeSendHandler()).toBeNull();
		expect(progress.getSuccessHandler()).toBeNull();
		expect(progress.getErrorHandler()).toBeNull();
		expect(progress.getTimeoutHandler()).toBe(globalTimeoutHandler);
		expect(progress.getCompleteHandler()).toBeNull();

		reset();
		progress = xeno.remoting.web.Engine.processRemoteCall("a", "b", [], { internal_preventProgress: true, onTimeout: localTimeoutHandler });
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(0);
		expect(xeno.remoting.web.Engine.getBeforeSendHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getSuccessHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getErrorHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getTimeoutHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getCompleteHandler()).toBeNull();
		expect(progress.getStatus()).toBe("init");
		expect(progress.getTimeout()).toBe(0);
		expect(progress.getBeforeSendHandler()).toBeNull();
		expect(progress.getSuccessHandler()).toBeNull();
		expect(progress.getErrorHandler()).toBeNull();
		expect(progress.getTimeoutHandler()).toBe(localTimeoutHandler);
		expect(progress.getCompleteHandler()).toBeNull();

		reset();
		xeno.remoting.web.Engine.setTimeoutHandler(globalTimeoutHandler);
		progress = xeno.remoting.web.Engine.processRemoteCall("a", "b", [], { internal_preventProgress: true, onTimeout: localTimeoutHandler });
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(0);
		expect(xeno.remoting.web.Engine.getBeforeSendHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getSuccessHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getErrorHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getTimeoutHandler()).toBe(globalTimeoutHandler);
		expect(xeno.remoting.web.Engine.getCompleteHandler()).toBeNull();
		expect(progress.getStatus()).toBe("init");
		expect(progress.getTimeout()).toBe(0);
		expect(progress.getBeforeSendHandler()).toBeNull();
		expect(progress.getSuccessHandler()).toBeNull();
		expect(progress.getErrorHandler()).toBeNull();
		expect(progress.getTimeoutHandler()).toBe(localTimeoutHandler);
		expect(progress.getCompleteHandler()).toBeNull();

		// For complete handler.
		reset();
		xeno.remoting.web.Engine.setCompleteHandler(globalCompleteHandler);
		progress = xeno.remoting.web.Engine.processRemoteCall("a", "b", [], { internal_preventProgress: true });
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(0);
		expect(xeno.remoting.web.Engine.getBeforeSendHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getSuccessHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getErrorHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getTimeoutHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getCompleteHandler()).toBe(globalCompleteHandler);
		expect(progress.getStatus()).toBe("init");
		expect(progress.getTimeout()).toBe(0);
		expect(progress.getBeforeSendHandler()).toBeNull();
		expect(progress.getSuccessHandler()).toBeNull();
		expect(progress.getErrorHandler()).toBeNull();
		expect(progress.getTimeoutHandler()).toBeNull();
		expect(progress.getCompleteHandler()).toBe(globalCompleteHandler);

		reset();
		progress = xeno.remoting.web.Engine.processRemoteCall("a", "b", [], { internal_preventProgress: true, onComplete: localCompleteHandler });
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(0);
		expect(xeno.remoting.web.Engine.getBeforeSendHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getSuccessHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getErrorHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getTimeoutHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getCompleteHandler()).toBeNull();
		expect(progress.getStatus()).toBe("init");
		expect(progress.getTimeout()).toBe(0);
		expect(progress.getBeforeSendHandler()).toBeNull();
		expect(progress.getSuccessHandler()).toBeNull();
		expect(progress.getErrorHandler()).toBeNull();
		expect(progress.getTimeoutHandler()).toBeNull();
		expect(progress.getCompleteHandler()).toBe(localCompleteHandler);

		reset();
		xeno.remoting.web.Engine.setCompleteHandler(globalCompleteHandler);
		progress = xeno.remoting.web.Engine.processRemoteCall("a", "b", [], { internal_preventProgress: true, onComplete: localCompleteHandler });
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(0);
		expect(xeno.remoting.web.Engine.getBeforeSendHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getSuccessHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getErrorHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getTimeoutHandler()).toBeNull();
		expect(xeno.remoting.web.Engine.getCompleteHandler()).toBe(globalCompleteHandler);
		expect(progress.getStatus()).toBe("init");
		expect(progress.getTimeout()).toBe(0);
		expect(progress.getBeforeSendHandler()).toBeNull();
		expect(progress.getSuccessHandler()).toBeNull();
		expect(progress.getErrorHandler()).toBeNull();
		expect(progress.getTimeoutHandler()).toBeNull();
		expect(progress.getCompleteHandler()).toBe(localCompleteHandler);

		// Reset global setting.
		reset();
	});

	it("getContextPath", function() {
		expect(xeno.remoting.web.Engine.getContextPath()).toBe("${Param.Value.ContextPath}");
	});

	it("getTimeout, setTimeout", function() {

		// Tests required arguments.
		expect(function() { xeno.remoting.web.Engine.setTimeout(); }).toThrow(new Error("The 'value' is required, index: 0"));

		// Tests arguments data types.
		expect(function() { xeno.remoting.web.Engine.setTimeout(NaN); }).toThrow(new Error("The 'value' is not undefined or null, or not a Number"));
		expect(function() { xeno.remoting.web.Engine.setTimeout(Infinity); }).toThrow(new Error("The 'value' is not undefined or null, or not a Number"));
		expect(function() { xeno.remoting.web.Engine.setTimeout(true); }).toThrow(new Error("The 'value' is not undefined or null, or not a Number"));
		expect(function() { xeno.remoting.web.Engine.setTimeout(new Boolean()); }).toThrow(new Error("The 'value' is not undefined or null, or not a Number"));
		expect(function() { xeno.remoting.web.Engine.setTimeout(""); }).toThrow(new Error("The 'value' is not undefined or null, or not a Number"));
		expect(function() { xeno.remoting.web.Engine.setTimeout(new String()); }).toThrow(new Error("The 'value' is not undefined or null, or not a Number"));
		expect(function() { xeno.remoting.web.Engine.setTimeout([]); }).toThrow(new Error("The 'value' is not undefined or null, or not a Number"));
		expect(function() { xeno.remoting.web.Engine.setTimeout(new Array()); }).toThrow(new Error("The 'value' is not undefined or null, or not a Number"));
		expect(function() { xeno.remoting.web.Engine.setTimeout(/[w]/); }).toThrow(new Error("The 'value' is not undefined or null, or not a Number"));
		expect(function() { xeno.remoting.web.Engine.setTimeout(new RegExp()); }).toThrow(new Error("The 'value' is not undefined or null, or not a Number"));
		expect(function() { xeno.remoting.web.Engine.setTimeout(new Date()); }).toThrow(new Error("The 'value' is not undefined or null, or not a Number"));
		expect(function() { xeno.remoting.web.Engine.setTimeout({}); }).toThrow(new Error("The 'value' is not undefined or null, or not a Number"));
		expect(function() { xeno.remoting.web.Engine.setTimeout(new Object()); }).toThrow(new Error("The 'value' is not undefined or null, or not a Number"));
		expect(function() { xeno.remoting.web.Engine.setTimeout(function() {}); }).toThrow(new Error("The 'value' is not undefined or null, or not a Number"));

		// Tests normal scenarios.
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(0);

		xeno.remoting.web.Engine.setTimeout(100);
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(100);

		xeno.remoting.web.Engine.setTimeout(-1);
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(0);

		xeno.remoting.web.Engine.setTimeout(170);
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(170);

		xeno.remoting.web.Engine.setTimeout(0);
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(0);

		xeno.remoting.web.Engine.setTimeout(30.8);
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(30);

		xeno.remoting.web.Engine.setTimeout(null);
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(0);

		xeno.remoting.web.Engine.setTimeout(431414.3434);
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(431414);

		xeno.remoting.web.Engine.setTimeout(undefined);
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(0);

		xeno.remoting.web.Engine.setTimeout(304);
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(304);

		xeno.remoting.web.Engine.setTimeout(19);
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(20);

		xeno.remoting.web.Engine.setTimeout(20);
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(20);

		xeno.remoting.web.Engine.setTimeout(21);
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(21);

		xeno.remoting.web.Engine.setTimeout(19.1);
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(20);

		xeno.remoting.web.Engine.setTimeout(190.1);
		expect(xeno.remoting.web.Engine.getTimeout()).toBe(190);
	});

	it("getBeforeSendHandler, setBeforeSendHandler", function() {

		// Tests required arguments.
		expect(function() { xeno.remoting.web.Engine.setBeforeSendHandler(); }).toThrow(new Error("The 'callback' is required, index: 0"));

		// Tests arguments data types.
		expect(function() { xeno.remoting.web.Engine.setBeforeSendHandler(1); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setBeforeSendHandler(1.1); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setBeforeSendHandler(-3); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setBeforeSendHandler(new Number()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setBeforeSendHandler(1.2E3); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setBeforeSendHandler(0xFF); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setBeforeSendHandler(NaN); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setBeforeSendHandler(Infinity); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setBeforeSendHandler(true); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setBeforeSendHandler(new Boolean()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setBeforeSendHandler(""); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setBeforeSendHandler(new String()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setBeforeSendHandler([]); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setBeforeSendHandler(new Array()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setBeforeSendHandler(/[w]/); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setBeforeSendHandler(new RegExp()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setBeforeSendHandler(new Date()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setBeforeSendHandler({}); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setBeforeSendHandler(new Object()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));

		// Tests normal scenarios.
		expect(xeno.remoting.web.Engine.getBeforeSendHandler()).toBeNull();

		var func1 = function() {};
		var func2 = function() {};
		var func3 = function() {};
		var func4 = function() {};
		var func5 = function() {};

		xeno.remoting.web.Engine.setBeforeSendHandler(func1);
		expect(xeno.remoting.web.Engine.getBeforeSendHandler()).toBe(func1);

		xeno.remoting.web.Engine.setBeforeSendHandler(func2);
		expect(xeno.remoting.web.Engine.getBeforeSendHandler()).toBe(func2);

		xeno.remoting.web.Engine.setBeforeSendHandler(null);
		expect(xeno.remoting.web.Engine.getBeforeSendHandler()).toBeNull();

		xeno.remoting.web.Engine.setBeforeSendHandler(func3);
		expect(xeno.remoting.web.Engine.getBeforeSendHandler()).toBe(func3);

		xeno.remoting.web.Engine.setBeforeSendHandler(undefined);
		expect(xeno.remoting.web.Engine.getBeforeSendHandler()).toBeNull();

		xeno.remoting.web.Engine.setBeforeSendHandler(func4);
		expect(xeno.remoting.web.Engine.getBeforeSendHandler()).toBe(func4);

		xeno.remoting.web.Engine.setBeforeSendHandler(func5);
		expect(xeno.remoting.web.Engine.getBeforeSendHandler()).toBe(func5);

		xeno.remoting.web.Engine.setBeforeSendHandler(func2);
		expect(xeno.remoting.web.Engine.getBeforeSendHandler()).toBe(func2);
	});

	it("getSuccessHandler, setSuccessHandler", function() {

		// Tests required arguments.
		expect(function() { xeno.remoting.web.Engine.setSuccessHandler(); }).toThrow(new Error("The 'callback' is required, index: 0"));

		// Tests arguments data types.
		expect(function() { xeno.remoting.web.Engine.setSuccessHandler(1); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setSuccessHandler(1.1); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setSuccessHandler(-3); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setSuccessHandler(new Number()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setSuccessHandler(1.2E3); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setSuccessHandler(0xFF); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setSuccessHandler(NaN); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setSuccessHandler(Infinity); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setSuccessHandler(true); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setSuccessHandler(new Boolean()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setSuccessHandler(""); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setSuccessHandler(new String()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setSuccessHandler([]); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setSuccessHandler(new Array()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setSuccessHandler(/[w]/); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setSuccessHandler(new RegExp()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setSuccessHandler(new Date()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setSuccessHandler({}); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setSuccessHandler(new Object()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));

		// Tests normal scenarios.
		expect(xeno.remoting.web.Engine.getSuccessHandler()).toBeNull();

		var func1 = function() {};
		var func2 = function() {};
		var func3 = function() {};
		var func4 = function() {};
		var func5 = function() {};

		xeno.remoting.web.Engine.setSuccessHandler(func1);
		expect(xeno.remoting.web.Engine.getSuccessHandler()).toBe(func1);

		xeno.remoting.web.Engine.setSuccessHandler(func2);
		expect(xeno.remoting.web.Engine.getSuccessHandler()).toBe(func2);

		xeno.remoting.web.Engine.setSuccessHandler(null);
		expect(xeno.remoting.web.Engine.getSuccessHandler()).toBeNull();

		xeno.remoting.web.Engine.setSuccessHandler(func3);
		expect(xeno.remoting.web.Engine.getSuccessHandler()).toBe(func3);

		xeno.remoting.web.Engine.setSuccessHandler(undefined);
		expect(xeno.remoting.web.Engine.getSuccessHandler()).toBeNull();

		xeno.remoting.web.Engine.setSuccessHandler(func4);
		expect(xeno.remoting.web.Engine.getSuccessHandler()).toBe(func4);

		xeno.remoting.web.Engine.setSuccessHandler(func5);
		expect(xeno.remoting.web.Engine.getSuccessHandler()).toBe(func5);

		xeno.remoting.web.Engine.setSuccessHandler(func2);
		expect(xeno.remoting.web.Engine.getSuccessHandler()).toBe(func2);
	});

	it("getErrorHandler, setErrorHandler", function() {

		// Tests required arguments.
		expect(function() { xeno.remoting.web.Engine.setErrorHandler(); }).toThrow(new Error("The 'callback' is required, index: 0"));

		// Tests arguments data types.
		expect(function() { xeno.remoting.web.Engine.setErrorHandler(1); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setErrorHandler(1.1); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setErrorHandler(-3); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setErrorHandler(new Number()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setErrorHandler(1.2E3); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setErrorHandler(0xFF); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setErrorHandler(NaN); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setErrorHandler(Infinity); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setErrorHandler(true); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setErrorHandler(new Boolean()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setErrorHandler(""); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setErrorHandler(new String()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setErrorHandler([]); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setErrorHandler(new Array()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setErrorHandler(/[w]/); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setErrorHandler(new RegExp()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setErrorHandler(new Date()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setErrorHandler({}); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setErrorHandler(new Object()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));

		// Tests normal scenarios.
		expect(xeno.remoting.web.Engine.getErrorHandler()).toBeNull();

		var func1 = function() {};
		var func2 = function() {};
		var func3 = function() {};
		var func4 = function() {};
		var func5 = function() {};

		xeno.remoting.web.Engine.setErrorHandler(func1);
		expect(xeno.remoting.web.Engine.getErrorHandler()).toBe(func1);

		xeno.remoting.web.Engine.setErrorHandler(func2);
		expect(xeno.remoting.web.Engine.getErrorHandler()).toBe(func2);

		xeno.remoting.web.Engine.setErrorHandler(null);
		expect(xeno.remoting.web.Engine.getErrorHandler()).toBeNull();

		xeno.remoting.web.Engine.setErrorHandler(func3);
		expect(xeno.remoting.web.Engine.getErrorHandler()).toBe(func3);

		xeno.remoting.web.Engine.setErrorHandler(undefined);
		expect(xeno.remoting.web.Engine.getErrorHandler()).toBeNull();

		xeno.remoting.web.Engine.setErrorHandler(func4);
		expect(xeno.remoting.web.Engine.getErrorHandler()).toBe(func4);

		xeno.remoting.web.Engine.setErrorHandler(func5);
		expect(xeno.remoting.web.Engine.getErrorHandler()).toBe(func5);

		xeno.remoting.web.Engine.setErrorHandler(func2);
		expect(xeno.remoting.web.Engine.getErrorHandler()).toBe(func2);
	});

	it("getTimeoutHandler, setTimeoutHandler", function() {

		// Tests required arguments.
		expect(function() { xeno.remoting.web.Engine.setTimeoutHandler(); }).toThrow(new Error("The 'callback' is required, index: 0"));

		// Tests arguments data types.
		expect(function() { xeno.remoting.web.Engine.setTimeoutHandler(1); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setTimeoutHandler(1.1); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setTimeoutHandler(-3); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setTimeoutHandler(new Number()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setTimeoutHandler(1.2E3); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setTimeoutHandler(0xFF); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setTimeoutHandler(NaN); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setTimeoutHandler(Infinity); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setTimeoutHandler(true); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setTimeoutHandler(new Boolean()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setTimeoutHandler(""); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setTimeoutHandler(new String()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setTimeoutHandler([]); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setTimeoutHandler(new Array()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setTimeoutHandler(/[w]/); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setTimeoutHandler(new RegExp()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setTimeoutHandler(new Date()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setTimeoutHandler({}); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setTimeoutHandler(new Object()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));

		// Tests normal scenarios.
		expect(xeno.remoting.web.Engine.getTimeoutHandler()).toBeNull();

		var func1 = function() {};
		var func2 = function() {};
		var func3 = function() {};
		var func4 = function() {};
		var func5 = function() {};

		xeno.remoting.web.Engine.setTimeoutHandler(func1);
		expect(xeno.remoting.web.Engine.getTimeoutHandler()).toBe(func1);

		xeno.remoting.web.Engine.setTimeoutHandler(func2);
		expect(xeno.remoting.web.Engine.getTimeoutHandler()).toBe(func2);

		xeno.remoting.web.Engine.setTimeoutHandler(null);
		expect(xeno.remoting.web.Engine.getTimeoutHandler()).toBeNull();

		xeno.remoting.web.Engine.setTimeoutHandler(func3);
		expect(xeno.remoting.web.Engine.getTimeoutHandler()).toBe(func3);

		xeno.remoting.web.Engine.setTimeoutHandler(undefined);
		expect(xeno.remoting.web.Engine.getTimeoutHandler()).toBeNull();

		xeno.remoting.web.Engine.setTimeoutHandler(func4);
		expect(xeno.remoting.web.Engine.getTimeoutHandler()).toBe(func4);

		xeno.remoting.web.Engine.setTimeoutHandler(func5);
		expect(xeno.remoting.web.Engine.getTimeoutHandler()).toBe(func5);

		xeno.remoting.web.Engine.setTimeoutHandler(func2);
		expect(xeno.remoting.web.Engine.getTimeoutHandler()).toBe(func2);
	});

	it("getCompleteHandler, setCompleteHandler", function() {

		// Tests required arguments.
		expect(function() { xeno.remoting.web.Engine.setCompleteHandler(); }).toThrow(new Error("The 'callback' is required, index: 0"));

		// Tests arguments data types.
		expect(function() { xeno.remoting.web.Engine.setCompleteHandler(1); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setCompleteHandler(1.1); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setCompleteHandler(-3); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setCompleteHandler(new Number()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setCompleteHandler(1.2E3); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setCompleteHandler(0xFF); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setCompleteHandler(NaN); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setCompleteHandler(Infinity); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setCompleteHandler(true); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setCompleteHandler(new Boolean()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setCompleteHandler(""); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setCompleteHandler(new String()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setCompleteHandler([]); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setCompleteHandler(new Array()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setCompleteHandler(/[w]/); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setCompleteHandler(new RegExp()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setCompleteHandler(new Date()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setCompleteHandler({}); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setCompleteHandler(new Object()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));

		// Tests normal scenarios.
		expect(xeno.remoting.web.Engine.getCompleteHandler()).toBeNull();

		var func1 = function() {};
		var func2 = function() {};
		var func3 = function() {};
		var func4 = function() {};
		var func5 = function() {};

		xeno.remoting.web.Engine.setCompleteHandler(func1);
		expect(xeno.remoting.web.Engine.getCompleteHandler()).toBe(func1);

		xeno.remoting.web.Engine.setCompleteHandler(func2);
		expect(xeno.remoting.web.Engine.getCompleteHandler()).toBe(func2);

		xeno.remoting.web.Engine.setCompleteHandler(null);
		expect(xeno.remoting.web.Engine.getCompleteHandler()).toBeNull();

		xeno.remoting.web.Engine.setCompleteHandler(func3);
		expect(xeno.remoting.web.Engine.getCompleteHandler()).toBe(func3);

		xeno.remoting.web.Engine.setCompleteHandler(undefined);
		expect(xeno.remoting.web.Engine.getCompleteHandler()).toBeNull();

		xeno.remoting.web.Engine.setCompleteHandler(func4);
		expect(xeno.remoting.web.Engine.getCompleteHandler()).toBe(func4);

		xeno.remoting.web.Engine.setCompleteHandler(func5);
		expect(xeno.remoting.web.Engine.getCompleteHandler()).toBe(func5);

		xeno.remoting.web.Engine.setCompleteHandler(func2);
		expect(xeno.remoting.web.Engine.getCompleteHandler()).toBe(func2);
	});

	it("getReverseAjaxProgressHandler, setReverseAjaxProgressHandler", function() {

		// Tests required arguments.
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxProgressHandler(); }).toThrow(new Error("The 'callback' is required, index: 0"));

		// Tests arguments data types.
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxProgressHandler(1); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxProgressHandler(1.1); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxProgressHandler(-3); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxProgressHandler(new Number()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxProgressHandler(1.2E3); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxProgressHandler(0xFF); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxProgressHandler(NaN); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxProgressHandler(Infinity); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxProgressHandler(true); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxProgressHandler(new Boolean()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxProgressHandler(""); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxProgressHandler(new String()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxProgressHandler([]); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxProgressHandler(new Array()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxProgressHandler(/[w]/); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxProgressHandler(new RegExp()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxProgressHandler(new Date()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxProgressHandler({}); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxProgressHandler(new Object()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));

		// Tests normal scenarios.
		expect(xeno.remoting.web.Engine.getReverseAjaxProgressHandler()).toBeNull();

		var func1 = function() {};
		var func2 = function() {};
		var func3 = function() {};
		var func4 = function() {};
		var func5 = function() {};

		xeno.remoting.web.Engine.setReverseAjaxProgressHandler(func1);
		expect(xeno.remoting.web.Engine.getReverseAjaxProgressHandler()).toBe(func1);

		xeno.remoting.web.Engine.setReverseAjaxProgressHandler(func2);
		expect(xeno.remoting.web.Engine.getReverseAjaxProgressHandler()).toBe(func2);

		xeno.remoting.web.Engine.setReverseAjaxProgressHandler(null);
		expect(xeno.remoting.web.Engine.getReverseAjaxProgressHandler()).toBeNull();

		xeno.remoting.web.Engine.setReverseAjaxProgressHandler(func3);
		expect(xeno.remoting.web.Engine.getReverseAjaxProgressHandler()).toBe(func3);

		xeno.remoting.web.Engine.setReverseAjaxProgressHandler(undefined);
		expect(xeno.remoting.web.Engine.getReverseAjaxProgressHandler()).toBeNull();

		xeno.remoting.web.Engine.setReverseAjaxProgressHandler(func4);
		expect(xeno.remoting.web.Engine.getReverseAjaxProgressHandler()).toBe(func4);

		xeno.remoting.web.Engine.setReverseAjaxProgressHandler(func5);
		expect(xeno.remoting.web.Engine.getReverseAjaxProgressHandler()).toBe(func5);

		xeno.remoting.web.Engine.setReverseAjaxProgressHandler(func2);
		expect(xeno.remoting.web.Engine.getReverseAjaxProgressHandler()).toBe(func2);
	});

	it("getReverseAjaxCompleteHandler, setReverseAjaxCompleteHandler", function() {

		// Tests required arguments.
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxCompleteHandler(); }).toThrow(new Error("The 'callback' is required, index: 0"));

		// Tests arguments data types.
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxCompleteHandler(1); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxCompleteHandler(1.1); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxCompleteHandler(-3); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxCompleteHandler(new Number()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxCompleteHandler(1.2E3); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxCompleteHandler(0xFF); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxCompleteHandler(NaN); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxCompleteHandler(Infinity); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxCompleteHandler(true); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxCompleteHandler(new Boolean()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxCompleteHandler(""); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxCompleteHandler(new String()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxCompleteHandler([]); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxCompleteHandler(new Array()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxCompleteHandler(/[w]/); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxCompleteHandler(new RegExp()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxCompleteHandler(new Date()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxCompleteHandler({}); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxCompleteHandler(new Object()); }).toThrow(new Error("The 'callback' is not undefined or null, or not a Function"));

		// Tests normal scenarios.
		expect(xeno.remoting.web.Engine.getReverseAjaxCompleteHandler()).toBeNull();

		var func1 = function() {};
		var func2 = function() {};
		var func3 = function() {};
		var func4 = function() {};
		var func5 = function() {};

		xeno.remoting.web.Engine.setReverseAjaxCompleteHandler(func1);
		expect(xeno.remoting.web.Engine.getReverseAjaxCompleteHandler()).toBe(func1);

		xeno.remoting.web.Engine.setReverseAjaxCompleteHandler(func2);
		expect(xeno.remoting.web.Engine.getReverseAjaxCompleteHandler()).toBe(func2);

		xeno.remoting.web.Engine.setReverseAjaxCompleteHandler(null);
		expect(xeno.remoting.web.Engine.getReverseAjaxCompleteHandler()).toBeNull();

		xeno.remoting.web.Engine.setReverseAjaxCompleteHandler(func3);
		expect(xeno.remoting.web.Engine.getReverseAjaxCompleteHandler()).toBe(func3);

		xeno.remoting.web.Engine.setReverseAjaxCompleteHandler(undefined);
		expect(xeno.remoting.web.Engine.getReverseAjaxCompleteHandler()).toBeNull();

		xeno.remoting.web.Engine.setReverseAjaxCompleteHandler(func4);
		expect(xeno.remoting.web.Engine.getReverseAjaxCompleteHandler()).toBe(func4);

		xeno.remoting.web.Engine.setReverseAjaxCompleteHandler(func5);
		expect(xeno.remoting.web.Engine.getReverseAjaxCompleteHandler()).toBe(func5);

		xeno.remoting.web.Engine.setReverseAjaxCompleteHandler(func2);
		expect(xeno.remoting.web.Engine.getReverseAjaxCompleteHandler()).toBe(func2);
	});

	it("setReverseAjaxEnabled", function() {

		// Tests required arguments.
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxEnabled(); }).toThrow(new Error("The 'flag' is required, index: 0"));

		// Tests arguments data types.
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxEnabled(undefined); }).toThrow(new Error("The 'flag' is not a Boolean"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxEnabled(null); }).toThrow(new Error("The 'flag' is not a Boolean"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxEnabled(1); }).toThrow(new Error("The 'flag' is not a Boolean"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxEnabled(1.1); }).toThrow(new Error("The 'flag' is not a Boolean"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxEnabled(-3); }).toThrow(new Error("The 'flag' is not a Boolean"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxEnabled(new Number()); }).toThrow(new Error("The 'flag' is not a Boolean"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxEnabled(1.2E3); }).toThrow(new Error("The 'flag' is not a Boolean"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxEnabled(0xFF); }).toThrow(new Error("The 'flag' is not a Boolean"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxEnabled(NaN); }).toThrow(new Error("The 'flag' is not a Boolean"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxEnabled(Infinity); }).toThrow(new Error("The 'flag' is not a Boolean"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxEnabled(""); }).toThrow(new Error("The 'flag' is not a Boolean"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxEnabled(new String()); }).toThrow(new Error("The 'flag' is not a Boolean"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxEnabled([]); }).toThrow(new Error("The 'flag' is not a Boolean"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxEnabled(new Array()); }).toThrow(new Error("The 'flag' is not a Boolean"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxEnabled(/[w]/); }).toThrow(new Error("The 'flag' is not a Boolean"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxEnabled(new RegExp()); }).toThrow(new Error("The 'flag' is not a Boolean"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxEnabled(new Date()); }).toThrow(new Error("The 'flag' is not a Boolean"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxEnabled({}); }).toThrow(new Error("The 'flag' is not a Boolean"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxEnabled(new Object()); }).toThrow(new Error("The 'flag' is not a Boolean"));
		expect(function() { xeno.remoting.web.Engine.setReverseAjaxEnabled(function() {}); }).toThrow(new Error("The 'flag' is not a Boolean"));
	});
});
