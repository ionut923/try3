package tests;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

import dao.category.CategoryAbstractDao;
import dao.item.ItemAbstractDao;
import entities.Item;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import steps.api.ApiCategorySteps;
import steps.api.ApiItemSteps;
import steps.api.ApiLoginSteps;
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
	ApiLoginSteps apiLoginSteps;
	@Steps
	ApiCategorySteps apiCategorySteps;
	@Steps
	ApiItemSteps apiItemSteps;
	@Steps
	HomePageSteps homePageSteps;
	@Steps
	PageNavigationFlowSteps pageNavigationFlowSteps;

	@Inject
	ItemAbstractDao itemAbstractDao;
	@Inject
	CategoryAbstractDao categoryAbstractDao;

	@Before
	public void setUp() {
		//apiLoginSteps.loginAsAdmin();
		apiCategorySteps.createBoard();
//		apiItemSteps.createItem();
//		apiCategorySteps.createCategory();
//		apiItemSteps.createItem();
	}

	@Test
	public void bookItemTest() {
//		homePageSteps.navigateToHomePage();
//		loginFlowSteps.login();
//		List<Item> itemsFromLastCategory = itemAbstractDao
//				.getItemsByCategoryId(String.valueOf(categoryAbstractDao.getLastCreatedCategory()));
//		bookingFlowSteps.bookItems(itemsFromLastCategory);
//		pageNavigationFlowSteps.goToMyBookings();
//		itemValidationSteps.validateBookedItems();
	}
}
