package steps.api.flowSteps;

import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.Steps;
import steps.api.ApiCategorySteps;
import steps.api.ApiItemSteps;
import steps.api.ApiLoginSteps;

public class ApiCreateItemFlowSteps {

	@Steps
	ApiLoginSteps apiLoginSteps;
	@Steps
	ApiCategorySteps apiCategorySteps;
	@Steps
	ApiItemSteps apiItemSteps;

	@StepGroup
	public void createItem() {
		apiLoginSteps.loginAsAdmin();
		apiCategorySteps.createCategory();
		apiItemSteps.createItem();
	}
}
