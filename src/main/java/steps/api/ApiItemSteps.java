package steps.api;

import com.google.inject.Inject;

import constants.ApiUrlConstants;
import dao.item.ItemAbstractDao;
import entities.Item;
import net.thucydides.core.annotations.Step;
import steps.AbstractSteps;
import tools.factories.ItemFactory;
import tools.utils.InstanceUtils;

public class ApiItemSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	@Inject
	ItemAbstractDao itemAbstractDao;
	@Inject 
	ItemFactory itemfactory;
	@Inject
	AbstractApiSteps abstractApiSteps;
	
	@Step
	public void createItem() {
		Item itemRequest = itemfactory.geItemInstance();
		Item itemResponse = abstractApiSteps.createResource(ApiUrlConstants.ITEMS, itemRequest, Item.class);

		itemRequest = (Item) InstanceUtils.mergeObjects(itemRequest, itemResponse);
		itemAbstractDao.addItem(itemRequest);
	}
}
