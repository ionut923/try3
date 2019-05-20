package steps.frontend.flowSteps;

import java.util.List;

import constants.SerenityKeyConstants;
import entities.Item;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.Steps;
import steps.frontend.CategorySteps;
import steps.frontend.HeaderSteps;
import steps.frontend.ItemSteps;
import tools.utils.SerenitySessionUtils;

public class BookingFlowSteps {

	@Steps
	HeaderSteps headerSteps;
	@Steps
	CategorySteps categorySteps;
	@Steps
	ItemSteps itemSteps;

	@StepGroup
	public void bookItems(List<Item> items) {
		for (Item item : items) {
			SerenitySessionUtils.putOnSession(SerenityKeyConstants.ITEM, item);
			headerSteps.selectHeader("ITEMS");
			categorySteps.selectCategory(item.getCategory().getName());
			itemSteps.bookItem(item.getTitle());
		}
	}

	@StepGroup
	public void bookAllItems() {
		List<Item> items = SerenitySessionUtils.getFromSession(SerenityKeyConstants.ITEMS);
		bookItems(items);
	}

	@StepGroup
	public void bookItemsFromSearchResults(List<Item> items) {
		headerSteps.selectHeader("ITEMS");
		for (Item item : items) {
			categorySteps.searchItem(item.getTitle());
			itemSteps.bookItem(item.getTitle());
		}
	}

	@StepGroup
	public void bookAllItemFromSearchResults() {
		List<Item> items = SerenitySessionUtils.getFromSession(SerenityKeyConstants.ITEMS);
		bookItemsFromSearchResults(items);
	}
}
