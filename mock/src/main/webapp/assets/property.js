var withSessionIdsCallback = function(f, d) {
	var output = document.getElementById("txtOutput");

	append(output, "Handled session ID callback in 'property.jsp'", true);
	append(output, "<Document> id=" + d.id + ", displayName=" + d.displayName);
	append(output, "<Folder> id=" + f.id + ", displayName=" + f.displayName);

	for(var i in f.documents) {
		append(output, "<Child Document> id=" + f.documents[i].id + ", displayName=" + f.documents[i].displayName);
	}
};

var withPageUrisCallback = function(f, d) {
	var output = document.getElementById("txtOutput");

	append(output, "Handled page URI callback in 'property.jsp'", true);
	append(output, "<Document> id=" + d.id + ", displayName=" + d.displayName);
	append(output, "<Folder> id=" + f.id + ", displayName=" + f.displayName);

	for(var i in f.documents) {
		append(output, "<Child Document> id=" + f.documents[i].id + ", displayName=" + f.documents[i].displayName);
	}
};

window.onload = function() {
	var output = document.getElementById("txtOutput");

	document.getElementById("btnClear").onclick = function(evt) {
		output.value = "";
	};

	// Reverse AJAX.
	document.getElementById("btnSwitchReverseAjax").onclick = function(evt) {
		xeno.remoting.web.Engine.setReverseAjaxEnabled(this.checked);
	};

	// Timeout Setting.
	document.getElementById("btnSetTimeout").onclick = function(evt) {
		var value = document.getElementById("txtValTimeout").value;

		xeno.remoting.web.Engine.setTimeout(parseInt(value));
	};

	var interval = null;

	document.getElementById("btnStartInternalLoop").onclick = function(evt) {
		clear(output, true);
		clearInterval(interval);

		var guid = null;

		document.cookie = "client-c1=" + escape("This is a client cookie: " + new Date().getTime());
		document.cookie = "client-c2=" + escape("This is another client cookie: " + new Date().getTime());

		interval = setInterval(function() {

			com.since10.web.service.PropertyService.loop({
				onBeforeSend: function(header) {
					header["request-h1"] = "This is a request header test, for: " + guid;
					header["request-h2"] = "This is another request header test, for: " + guid;
				},
				onSuccess: function(result, xhr) {
					clear(output, true);

					append(output, "Context Path - Client\t: " + xeno.remoting.web.Engine.getContextPath());
					append(output, "Timeout Setting\t: " + xeno.remoting.web.Engine.getTimeout());
					append(output, "Reverse Ajax Enabled\t: " + xeno.remoting.web.Engine.isReverseAjaxEnabled());

					guid = result.data.GUID;

					append(output, "");
					append(output, "Hashed GUID\t: " + result.data.GUID);
					append(output, "Timestamp\t: " + result.data.Timestamp);
					append(output, "Session ID\t: " + result.data.SessionID);
					append(output, "Page URI\t: " + result.data.PageURI);
					append(output, "Encoding\t: " + result.data.CharacterEncoding);
					append(output, "Context Path\t: " + result.data.ContextPath);
					append(output, "");
					append(output, "Server Name\t: " + result.data.ServerName);
					append(output, "Server Port\t: " + result.data.ServerPort);
					append(output, "Local Addr\t: " + result.data.LocalAddress);
					append(output, "Local Name\t: " + result.data.LocalName);
					append(output, "Local Port\t: " + result.data.LocalPort);
					append(output, "Remote Addr\t: " + result.data.RemoteAddress);
					append(output, "Remote Host\t: " + result.data.RemoteHost);
					append(output, "Remote Port\t: " + result.data.RemotePort);
					append(output, "");
					append(output, "Request Header 1\t: " + result.data.RequestHeader1);
					append(output, "Request Header 2\t: " + result.data.RequestHeader2);
					append(output, "Request Header 3\t: " + result.data.RequestHeader3);
					append(output, "Response Header 1\t: " + result.header["response-h1"]);
					append(output, "Response Header 2\t: " + result.header["response-h2"]);
					append(output, "Response Header 3\t: " + result.header["response-h3"]);
					append(output, "");
					append(output, "Client Cookie 1\t: " + result.data["client-c1"]);
					append(output, "Client Cookie 2\t: " + result.data["client-c2"]);
					append(output, "Client Cookie 3\t: " + result.data["client-c3"]);
					append(output, "Server Cookie 1\t: " + result.data["server-c1"]);
					append(output, "Server Cookie 2\t: " + result.data["server-c2"]);
					append(output, "Server Cookie 3\t: " + result.data["server-c3"]);
				},
				onTimeout: function(xhr) {
					clear(output, true);
					append(output, "Timeout");
				},
				onError: function(fault, xhr) {
					clear(output, true);
					append(output, "Error");
				}
			});

		}, 3000);
	};

	document.getElementById("btnClearInternalLoop").onclick = function(evt) {
		clear(output);
		clearInterval(interval);
	};
};
