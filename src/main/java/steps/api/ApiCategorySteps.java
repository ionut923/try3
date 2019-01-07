package steps.api;

import constants.ApiUrlConstants;
import constants.SerenityKeyConstants;
import entities.Category;
import net.thucydides.core.annotations.Step;
import tools.factories.CategoryFactory;
import tools.utils.InstanceUtils;
import tools.utils.SerenitySessionUtils;

public class ApiCategorySteps extends AbstractApiSteps {

	private static final long serialVersionUID = 1L;

	@Step
	public void createCategory() {
		Category categoryRequest = CategoryFactory.getCategoryInstance();
		Category categoryResponse = createResource(ApiUrlConstants.CATEGORIES, categoryRequest, Category.class);

		categoryRequest = (Category) InstanceUtils.mergeObjects(categoryRequest, categoryResponse);
		SerenitySessionUtils.putOnSession(SerenityKeyConstants.CATEGORY, categoryRequest);
	}
}
