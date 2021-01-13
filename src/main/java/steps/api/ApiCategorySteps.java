package steps.api;

import com.google.inject.Inject;

import constants.ApiUrlConstants;
import dao.category.CategoryAbstractDao;
import entities.Category;
import net.thucydides.core.annotations.Step;
import steps.AbstractSteps;
import tools.factories.CategoryFactory;
import tools.utils.InstanceUtils;

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
		categoryAbstractDao.saveCategory(categoryRequest);
	}
	@Step
	public void createBoard() {
		String param1 ="417931c8aadf29f8ee3ac906230feb81";
		String param2 ="54c9c479d37dc10ac75653ac481273a8149396ac889a54048963213ab7619da9";
		String param3 ="testionut";
		abstractApiSteps.createResourcee("/1/boards/", param1, param2, param3);
		
	
	}
}
