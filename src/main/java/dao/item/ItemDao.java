package dao.item;

import java.util.List;
import java.util.stream.Collectors;

import com.google.inject.Singleton;

import constants.SerenityKeyConstants;
import entities.Item;
import tools.utils.SerenitySessionUtils;

public class ItemDao implements ItemAbstractDao {

	@Override
	public Item getItemById(String id) {
		List<Item> items = SerenitySessionUtils.getFromSession(SerenityKeyConstants.ITEMS);
		return items.stream().filter(item -> String.valueOf(item.getId()).contains(id)).findFirst().orElse(null);
	}

	@Override
	public List<Item> getItemsByCategoryId(String categoryId) {
		List<Item> items = SerenitySessionUtils.getFromSession(SerenityKeyConstants.ITEMS);
		return items.stream().filter(item -> String.valueOf(item.getCategoryId()).contains(categoryId))
				.collect(Collectors.toList());
	}

	@Override
	public void addItem(Item item) {
		System.out.println("Saving item...");
		SerenitySessionUtils.saveObjectInSerenityList(SerenityKeyConstants.ITEMS, item);
	}
}
