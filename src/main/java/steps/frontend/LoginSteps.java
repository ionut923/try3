package steps.frontend;

import constants.EnvironmentConstants;
import net.thucydides.core.annotations.Step;
import pages.LoginPage;
import steps.AbstractSteps;

public class LoginSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	LoginPage loginPage;

	@Step
	public void login() {
		loginPage.enterEmail(EnvironmentConstants.USER);
		loginPage.enterPassword(EnvironmentConstants.PASS);
		loginPage.submit();
	}
}
