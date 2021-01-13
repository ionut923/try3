package steps.frontend;

import constants.EnvironmentConstants;
import net.thucydides.core.annotations.Step;
import pages.HomePage;
import steps.AbstractSteps;

public class HomePageSteps extends AbstractSteps {
	
	private static final long serialVersionUID = 1L;
	
	HomePage homePage;

    @Step
    public void clickLogin(){
        homePage.clickLogin();
    }

    public void navigateToHomePage(){
        getDriver().get("https://google.com");
        getDriver().manage().window().maximize();
    }
}
