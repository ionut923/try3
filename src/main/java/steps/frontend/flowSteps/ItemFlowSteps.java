package steps.frontend.flowSteps;

import java.util.List;

import constants.SerenityKeyConstants;
import entities.Item;
import net.thucydides.core.annotations.Steps;
import steps.frontend.CategorySteps;
import steps.frontend.HeaderSteps;
import steps.frontend.ItemSteps;
import tools.utils.SerenitySessionUtils;

public class ItemFlowSteps {
	
	@Steps
	HeaderSteps headerSteps;
	@Steps
	CategorySteps categorySteps;
	@Steps
	ItemSteps itemSteps;
	
	public void verifyItemsAreCreated() {
		  List<Item> items = SerenitySessionUtils.getFromSession(SerenityKeyConstants.ITEMS);
	      items.forEach(s -> {
	    	  headerSteps.selectHeader("ITEMS");
	    	  categorySteps.selectCategory(s.getCategory().getName()); 
	    	  itemSteps.verifyItemIsPresent(s.getTitle());
	      });
	}

}
