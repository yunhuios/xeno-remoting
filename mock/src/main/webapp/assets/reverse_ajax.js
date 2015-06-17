var withSessionIdsCallback = function(f, d) {
	var output = document.getElementById("txtOutput");

	append(output, "Handled session ID callback in 'reverse_ajax.jsp'", true);
	append(output, "<Document> id=" + d.id + ", displayName=" + d.displayName);
	append(output, "<Folder> id=" + f.id + ", displayName=" + f.displayName);

	for(var i in f.documents) {
		append(output, "<Child Document> id=" + f.documents[i].id + ", displayName=" + f.documents[i].displayName);
	}
};

var withPageUrisCallback = function(f, d) {
	var output = document.getElementById("txtOutput");

	append(output, "Handled page URI callback in 'reverse_ajax.jsp'", true);
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

	document.getElementById("btnReverseCallSelfOnly").onclick = function(evt) {
		com.since10.web.service.AjaxBridgeService.testReverseCallSelfOnly();
	};

	document.getElementById("btnReverseCallAll").onclick = function(evt) {
		com.since10.web.service.AjaxBridgeService.testReverseCallAll();
	};

	document.getElementById("btnReverseCallWithSessionIds").onclick = function(evt) {
		var sessionIds = document.getElementById("txtReverseCallWithSessionIds").value.split(",");

		com.since10.web.service.AjaxBridgeService.testReverseCallWithSessionIds(sessionIds);
	};

	document.getElementById("btnReverseCallWithPageUris").onclick = function(evt) {
		var pageUris = document.getElementById("txtReverseCallWithPageUris").value.split(",");

		com.since10.web.service.AjaxBridgeService.testReverseCallWithPageUris(pageUris);
	};
};
