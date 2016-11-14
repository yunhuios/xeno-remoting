<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="xr" uri="http://www.since10.com/xeno-remoting" %>
<!doctype html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Hello World</title>
		<xr:script>
			import xeno.remoting.sample.web.HelloWorldController;
		</xr:script>
		<script type="text/javascript">

			window.onload = function(evt) {

				document.getElementById("btnTest").onclick = function(evt) {

					var account = {
						id: 3,
						name: "Mike Zhang"
					};

					var token = "171398";

					var option = {

						successCallback: function(result, xhr) {
							var organization = result.data;

							var organizationText = "# Organization #" + "\n";
							organizationText += "CODE: " + organization.code + ", ";
							organizationText += "REGION: " + organization.region + "\n";

							var accountsText = "# Accounts #" + "\n";

							for(var i = 0; i < organization.accounts.length; i += 1) {
								var account = organization.accounts[i];

								accountsText += "ID: " + organization.accounts[i].id + ", ";
								accountsText += "NAME: " + organization.accounts[i].name + "\n";
							}

							alert(organizationText + "\n" + accountsText);
						}
					};

					xeno.remoting.sample.web.HelloWorldController.getOrganization(account, token, option);
				};
			};
		</script>
	</head>
	<body>
		<input id="btnTest" type="button" value="Get Organization" />
	</body>
</html>
