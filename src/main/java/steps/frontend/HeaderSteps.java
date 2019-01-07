package steps.frontend;

import net.thucydides.core.annotations.Step;
import pages.HeaderPage;
import steps.AbstractSteps;

public class HeaderSteps extends AbstractSteps {
   
	private static final long serialVersionUID = 1L;
	
	HeaderPage headerPage;

    @Step
    public void selectHeader(String header){
        headerPage.selectHeader(header);
    }
}
