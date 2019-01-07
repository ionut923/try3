package steps.api;

import constants.ApiUrlConstants;
import constants.SerenityKeyConstants;
import entities.Item;
import net.thucydides.core.annotations.Step;
import tools.factories.ItemFactory;
import tools.utils.InstanceUtils;
import tools.utils.SerenitySessionUtils;

public class ApiItemSteps extends AbstractApiSteps {

	private static final long serialVersionUID = 1L;

    @Step
    public void createItem() {

        Item itemRequest = ItemFactory.geItemInstance();
        Item itemResponse = createResource(ApiUrlConstants.ITEMS, itemRequest, Item.class);

        itemRequest = (Item) InstanceUtils.mergeObjects(itemRequest, itemResponse);
        SerenitySessionUtils.saveObjectListInSerenitySession(SerenityKeyConstants.ITEMS, itemRequest);
    }
}
