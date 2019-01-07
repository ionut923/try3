package steps.api;

import constants.ApiUrlConstants;
import constants.SerenityKeyConstants;
import entities.Login;
import entities.User;
import net.thucydides.core.annotations.Step;
import tools.factories.LoginFactory;
import tools.utils.InstanceUtils;
import tools.utils.SerenitySessionUtils;

public class ApiLoginSteps extends AbstractApiSteps {

	private static final long serialVersionUID = 1L;

	@Step
	public void loginAsAdmin() {
		Login loginRequest = LoginFactory.getLoginInstance();
		User userResponse = createResource(ApiUrlConstants.LOGIN, loginRequest, User.class);

		loginRequest.setUser((User) InstanceUtils.mergeObjects(loginRequest.getUser(), userResponse));
		AbstractApiSteps.extraHeaders.put("Authorization", "Basic " + userResponse.getAuthenticationToken());

		SerenitySessionUtils.putOnSession(SerenityKeyConstants.USER, loginRequest.getUser());
	}
}
