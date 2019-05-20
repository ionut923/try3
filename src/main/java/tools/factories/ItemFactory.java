package tools.factories;

import java.util.ArrayList;
import java.util.List;

import constants.SerenityKeyConstants;
import entities.Category;
import entities.Item;
import tools.utils.FieldGenerator;
import tools.utils.SerenitySessionUtils;

public class ItemFactory {
	
	public Item geItemInstance() {
		
		Category category = SerenitySessionUtils.getFromSession(SerenityKeyConstants.CATEGORY);
		Item item = new Item();
		item.setTitle("Item - " + FieldGenerator.generateStringValue(6, FieldGenerator.TypeOfString.ALPHANUMERIC));
		item.setCustomFields(new Object[0]);
		item.setCategoryId(category.getId());
		item.setCategory(category);

		item.setName(null);
		item.setItemTag(null);
		item.setDescription(null);
		item.setCategoryTitle(null);

		return item;
	}

	public Item geItemCSVInstance() {
		Category category = SerenitySessionUtils.getFromSession(SerenityKeyConstants.CATEGORY);
		Item item = new Item();
		item.setTitle("Item - " + FieldGenerator.generateStringValue(6, FieldGenerator.TypeOfString.ALPHANUMERIC));
		item.setCustomFields(new Object[0]);
		item.setCategoryId(category.getId());
		item.setCategory(category);

		item.setName(item.getTitle());
		item.setItemTag(item.getTitle() + "_tag");
		item.setDescription("Test item description");
		item.setCategoryTitle(category.getName());

		return item;
	}

	public List<Item> getItemCSVInstantceList(int numberOfItems) {
		Category category = SerenitySessionUtils.getFromSession(SerenityKeyConstants.CATEGORY);
		List<Item> items = new ArrayList<Item>();

		for (int i = 0; i < numberOfItems; i++) {
			Item item = new Item();

			item.setTitle("Item - " + FieldGenerator.generateStringValue(6, FieldGenerator.TypeOfString.ALPHANUMERIC));
			item.setCustomFields(new Object[0]);
			item.setCategoryId(category.getId());
			item.setCategory(category);

			item.setName(item.getTitle());
			item.setItemTag(item.getTitle() + "_tag");
			item.setDescription("Test item description");
			item.setCategoryTitle(category.getName());

			items.add(item);
		}
		return items;
	}

}
