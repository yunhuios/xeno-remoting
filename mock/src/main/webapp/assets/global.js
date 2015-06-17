var global = {
	version: "2.0.0",
	calculate: function(a, b) {
		var output = document.getElementById("txtOutput");

		append(output, "Result: " + (a + b), true);
	}
};

var now = function() {
	var n = new Date();

	return n.getFullYear() + "-" + format(n.getMonth() + 1) + "-" + format(n.getDate()) + " " + format(n.getHours()) + ":" + format(n.getMinutes()) + ":" + format(n.getSeconds());
};

var format = function(value) {
	return value < 10 ? ("0" + value) : value.toString();
};

var clear = function(output, flag) {
	output.value = "";

	if(flag !== true) {
		xeno.remoting.web.Engine.setTimeout(0);
		xeno.remoting.web.Engine.setBeforeSendHandler(null);
		xeno.remoting.web.Engine.setSuccessHandler(null);
		xeno.remoting.web.Engine.setErrorHandler(null);
		xeno.remoting.web.Engine.setTimeoutHandler(null);
		xeno.remoting.web.Engine.setCompleteHandler(null);
	}
};

var append = function(output, content, flag) {
	var value = "";

	if(flag === true) {
		value = output.value + "\n\n[" + now() + "] " + content;

	} else {
		value = output.value + "\n# " + content;
	}

	output.value = value.replace(/^\s+|\s+$/g, "");
};
