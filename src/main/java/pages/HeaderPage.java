package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class HeaderPage extends AbstractPage {

	@FindBy(css = "ul[class='nav navbar-nav views']")
	WebElementFacade tabContainer;

	public void selectHeader(String header) {
		List<WebElementFacade> headersList = tabContainer.thenFindAll(By.cssSelector("li a"));
		WebElementFacade headerElement = headersList.stream().filter(element -> element.getText().contentEquals(header))
				.findAny().orElse(null);
		Assert.assertTrue("The element has not been found", headerElement != null);
		headerElement.click();
	}

}
