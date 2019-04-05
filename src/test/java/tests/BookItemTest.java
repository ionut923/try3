package tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import steps.api.flowSteps.ApiCreateItemFlowSteps;
import steps.frontend.HomePageSteps;
import steps.frontend.flowSteps.BookingFlowSteps;
import steps.frontend.flowSteps.LoginFlowSteps;
import steps.frontend.flowSteps.PageNavigationFlowSteps;
import steps.validation.ItemValidationSteps;

@RunWith(SerenityRunner.class)
public class BookItemTest extends BaseTest {

	@Steps
	LoginFlowSteps loginFlowSteps;
	@Steps
	ItemValidationSteps itemValidationSteps;
	@Steps
	BookingFlowSteps bookingFlowSteps;
	@Steps
	ApiCreateItemFlowSteps apiCreateItemFlowSteps;
	@Steps
	HomePageSteps homePageSteps;
	@Steps
	PageNavigationFlowSteps pageNavigationFlowSteps;

	@Before
	public void setUp() {
		apiCreateItemFlowSteps.createItem();
	}

	@Test
	public void bookItemTest() {
		homePageSteps.navigateToHomePage();
		//cocojambo
		loginFlowSteps.login();
		bookingFlowSteps.bookAllItemsFromCategory();
		pageNavigationFlowSteps.goToMyBookings();
		itemValidationSteps.validateBookedItems();
	}
}
