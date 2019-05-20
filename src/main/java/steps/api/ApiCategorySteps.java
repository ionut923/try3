package steps.api;

import com.google.inject.Inject;

import constants.ApiUrlConstants;
import constants.SerenityKeyConstants;
import dao.category.CategoryAbstractDao;
import entities.Category;
import net.thucydides.core.annotations.Step;
import steps.AbstractSteps;
import tools.factories.CategoryFactory;
import tools.utils.InstanceUtils;
import tools.utils.SerenitySessionUtils;

public class ApiCategorySteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;
	
	@Inject
	CategoryAbstractDao categoryAbstractDao;
	@Inject
	CategoryFactory categoryFactory;
	@Inject
	AbstractApiSteps abstractApiSteps;
	
	@Step
	public void createCategory() {
		Category categoryRequest = categoryFactory.getCategoryInstance();
		Category categoryResponse = abstractApiSteps.createResource(ApiUrlConstants.CATEGORIES, categoryRequest,
				Category.class);

		categoryRequest = (Category) InstanceUtils.mergeObjects(categoryRequest, categoryResponse);
		SerenitySessionUtils.putOnSession(SerenityKeyConstants.CATEGORY, categoryRequest);
		categoryAbstractDao.saveCategory(categoryRequest);
	}
}
