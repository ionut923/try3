package steps.api;

import com.google.inject.Inject;

import constants.ApiUrlConstants;
import constants.SerenityKeyConstants;
import entities.Login;
import entities.User;
import net.thucydides.core.annotations.Step;
import steps.AbstractSteps;
import tools.factories.LoginFactory;
import tools.utils.InstanceUtils;
import tools.utils.SerenitySessionUtils;

public class ApiLoginSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	@Inject
	AbstractApiSteps abstractApiSteps;
	@Inject
	LoginFactory loginFactory;

	@Step
	public void loginAsAdmin() {
		Login loginRequest = loginFactory.getLoginInstance();
		User userResponse = abstractApiSteps.createResource(ApiUrlConstants.LOGIN, loginRequest, User.class);

		loginRequest.setUser((User) InstanceUtils.mergeObjects(loginRequest.getUser(), userResponse));
		AbstractApiSteps.extraHeaders.put("Authorization", "Basic " + userResponse.getAuthenticationToken());

		SerenitySessionUtils.putOnSession(SerenityKeyConstants.USER, loginRequest.getUser());
	}
}
