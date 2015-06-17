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
		<script type="text/javascript" src="${context}/assets/property.js"></script>
		<xr:proxy>
			import com.since10.web.service.PropertyService;
		</xr:proxy>
	</head>
	<body>
		<details>
			<summary>Change Views</summary>
			<div>
				<form method="post" action="${context}/property/next">
					<input type="submit" value="Change URL and Stage in the Same Page 1" />
				</form>
				<form method="post" action="${context}/property/next/inner/change.do">
					<input type="submit" value="Change URL and Stage in the Same Page 2" />
				</form>
				<form method="post" action="${context}/property/next?t=123456&p=abcdef">
					<input type="submit" value="Change URL with Parameters and Stage in the Same Page" />
				</form>
			</div>
			<div>
				<form method="post" action="${context}/index">
					<input type="submit" value="Goto Index Page" />
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
			</div>
		</details>
		<details>
			<summary>Timeout Setting</summary>
			<div>
				<input id="txtValTimeout" />
				<input id="btnSetTimeout" type="button" value="Set Value" />
			</div>
		</details>
		<details>
			<summary>Request and Response Properties</summary>
			<div>
				<input id="btnStartInternalLoop" type="button" value="Start Internal Loop" />
				<input id="btnClearInternalLoop" type="button" value="Clear Internal Loop" />
			</div>
		</details>
		<details>
			<summary>Output Console</summary>
			<div>
				<input id="btnClear" type="button" value="Clear" />
			</div>
			<textarea id="txtOutput" readonly="readonly" style="height: 600px;"></textarea>
		</details>
	</body>
</html>
