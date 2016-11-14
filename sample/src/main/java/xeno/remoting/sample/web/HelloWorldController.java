package xeno.remoting.sample.web;

import java.util.Arrays;

import xeno.remoting.bind.RemoteProxy;
import xeno.remoting.bind.WebMethod;
import xeno.remoting.sample.web.model.Account;
import xeno.remoting.sample.web.model.Organization;

@RemoteProxy
public class HelloWorldController {

	@WebMethod
	public Organization getOrganization(Account account, String token) {
		Account account_1 = new Account();
		account_1.setId(9);
		account_1.setName("Jane Lin");

		Account account_2 = new Account();
		account_2.setId(7);
		account_2.setName("Tim Zhang");

		Organization organization = new Organization();
		organization.setCode("org_a_" + token);
		organization.setRegion("Red Zone");
		organization.setAccounts(Arrays.asList(account, account_1, account_2));

		return organization;
	}
}
