package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class CategoriesPage extends AbstractPage {
	@FindBy(css = "ul#categories_container")
	WebElementFacade categoriesContainer;
	@FindBy(css = "input#title")
	WebElementFacade searchBar;
	@FindBy(css = "div[class*='list-container']")
	WebElementFacade cont;

	public void selectCategory(String categoryName) {
		WebElementFacade selectedCategory = getCategory(categoryName);
		selectedCategory.find(By.cssSelector("h3 a")).click();
	}

	public WebElementFacade getCategory(String categoryName) {
		List<WebElementFacade> categoryList = categoriesContainer.thenFindAll("div[class*='categoryDetails']");
		WebElementFacade searchedCategory = categoryList.stream()
				.filter(element -> element.find(By.cssSelector("h3 a")).getText().contentEquals(categoryName))
				.findFirst().orElse(null);
		Assert.assertTrue("The element has not been found", searchedCategory != null);
		return searchedCategory;
	}

	public void searchItem(String itemName) {
		searchBar.waitUntilClickable();
		searchBar.clear();
		searchBar.sendKeys(itemName);
	}

}
