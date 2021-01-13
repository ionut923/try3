package steps.frontend;

import net.thucydides.core.annotations.Step;
import pages.CategoriesPage;
import steps.AbstractSteps;

public class CategorySteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	CategoriesPage categoriesPage;

	@Step
	public void selectCategory(String categoryName) {
	//	categoriesPage.selectCategory(categoryName);
	}

	@Step
	public void searchItem(String itemName) {
	//	categoriesPage.searchItem(itemName);
	}
}
