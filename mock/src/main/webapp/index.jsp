<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="xr" uri="http://www.since10.com/xeno-remoting" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!doctype html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link type="text/css" href="${context}/assets/default.css" rel="stylesheet" />
		<script type="text/javascript" src="${context}/assets/global.js"></script>
		<script type="text/javascript" src="${context}/assets/index.js"></script>
		<xr:proxy>
			import com.since10.web.*;
		</xr:proxy>
		<script type="text/javascript">
			var CONTEXT_PATH = "${context}";
		</script>
	</head>
	<body>
		<details>
			<summary>Change Views</summary>
			<div>
				<form method="post" action="${context}/index/next">
					<input type="submit" value="Change URL and Stage in the Same Page 1" />
				</form>
				<form method="post" action="${context}/index/next/inner/change.do">
					<input type="submit" value="Change URL and Stage in the Same Page 2" />
				</form>
				<form method="post" action="${context}/index/next?t=123456&p=abcdef">
					<input type="submit" value="Change URL with Parameters and Stage in the Same Page" />
				</form>
			</div>
			<div>
				<form method="post" action="${context}/property">
					<input type="submit" value="Goto Property Page" />
				</form>
				<form method="post" action="${context}/reverse_ajax">
					<input type="submit" value="Goto Reverse Ajax Page" />
				</form>
			</div>
		</details>
		<details>
			<summary>Reverse AJAX</summary>
			<div>
				<input id="btnSwitchReverseAjax" type="checkbox" />
				<label>Enable Reverse AJAX</label>
				<input id="btnEnableReverseAjax" type="button" value="Enable Reverse Ajax" />
				<input id="btnDisableReverseAjax" type="button" value="Disable Reverse Ajax" />
			</div>
		</details>
		<details>
			<summary>Single Calling Options</summary>
			<div>
				<input id="btnCallWebMethodWithGlobalNoneOption" type="button" value="Call with Global None Option" />
				<input id="btnCallWebMethodWithGlobalTimeoutOnly" type="button" value="Call with Global Timeout Only" />
				<input id="btnCallWebMethodWithGlobalBeforeSendOnly" type="button" value="Call with Global Before Send Only" />
				<input id="btnCallWebMethodWithGlobalSuccessOnly" type="button" value="Call with Global Success Only" />
				<input id="btnCallWebMethodWithGlobalErrorOnly" type="button" value="Call with Global Error Only" />
				<input id="btnCallWebMethodWithGlobalCompleteOnly" type="button" value="Call with Global Complete Only" />
			</div>
			<div>
				<input id="btnCallWebMethodWithLocalNoneOption" type="button" value="Call with Local None Option" />
				<input id="btnCallWebMethodWithLocalTimeoutOnly" type="button" value="Call with Local Timeout Only" />
				<input id="btnCallWebMethodWithLocalBeforeSendOnly" type="button" value="Call with Local Before Send Only" />
				<input id="btnCallWebMethodWithLocalSuccessOnly" type="button" value="Call with Local Success Only" />
				<input id="btnCallWebMethodWithLocalErrorOnly" type="button" value="Call with Local Error Only" />
				<input id="btnCallWebMethodWithLocalCompleteOnly" type="button" value="Call with Local Complete Only" />
			</div>
		</details>
		<details>
			<summary>Integrated Calling Options</summary>
			<div>
				<input id="btnCallWebMethodWithGlobalTimeout1" type="button" value="Call with Global Timeout (Client)" />
				<input id="btnCallWebMethodWithGlobalTimeout2" type="button" value="Call with Global Timeout (Server)" />
				<input id="btnCallWebMethodWithGlobalBeforeSend" type="button" value="Call with Global Before Send" />
				<input id="btnCallWebMethodWithGlobalSuccess" type="button" value="Call with Global Success" />
				<input id="btnCallWebMethodWithGlobalError" type="button" value="Call with Global Error" />
				<input id="btnCallWebMethodWithGlobalComplete" type="button" value="Call with Global Complete" />
			</div>
			<div>
				<input id="btnCallWebMethodWithLocalTimeout1" type="button" value="Call with Local Timeout (Client)" />
				<input id="btnCallWebMethodWithLocalTimeout2" type="button" value="Call with Local Timeout (Server)" />
				<input id="btnCallWebMethodWithLocalBeforeSend" type="button" value="Call with Local Before Send" />
				<input id="btnCallWebMethodWithLocalSuccess" type="button" value="Call with Local Success" />
				<input id="btnCallWebMethodWithLocalError" type="button" value="Call with Local Error" />
				<input id="btnCallWebMethodWithLocalComplete" type="button" value="Call with Local Complete" />
			</div>
		</details>
		<details>
			<summary>Abort Running Request</summary>
			<div>
				<input id="btnStartLongTimeResponse" type="button" value="Start Long Time Response" />
				<input id="btnAbortLongTimeResponse" type="button" value="Abort Long Time Response" />
			</div>
		</details>
		<details>
			<summary>Handling Exceptions</summary>
			<div>
				<input id="btnCallWebMethodWithException1" type="button" value="Call with Exception (Failed Deserialization)" />
				<input id="btnCallWebMethodWithException2" type="button" value="Call with Exception (Failed Serialization)" />
				<input id="btnCallWebMethodWithException3" type="button" value="Call with Exception (Custom Exception)" />
			</div>
			<div>
				<input id="btnCallWebMethodWithUnhandlableException1" type="button" value="Call with Unhandlable Exception (Failed Serialization)" />
				<input id="btnCallWebMethodWithUnhandlableException2" type="button" value="Call with Unhandlable Exception (Nested Exception)" />
			</div>
		</details>
		<details>
			<summary>Spring Framework Integration</summary>
			<div>
				<input id="btnSpringFrameworkIntegration1" type="button" value="Call with Spring Bean" />
				<input id="btnSpringFrameworkIntegration2" type="button" value="Call with Spring URL" />
			</div>
		</details>
		<details>
			<summary>Output Console</summary>
			<div>
				<input id="btnClear" type="button" value="Clear" />
			</div>
			<textarea id="txtOutput" readonly="readonly"></textarea>
		</details>
	</body>
</html>
