package steps.frontend.flowSteps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import steps.frontend.HomePageSteps;
import steps.frontend.LoginSteps;

public class LoginFlowSteps {
	
	@Steps
	HomePageSteps homePageSteps;
	@Steps
	LoginSteps loginSteps;

	@Step
	public void login() {
		homePageSteps.clickLogin();
		loginSteps.login();
	}
}
