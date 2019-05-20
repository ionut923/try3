package dao.category;

import java.util.List;

import constants.SerenityKeyConstants;
import entities.Category;
import tools.utils.SerenitySessionUtils;

public class CategoryDao implements CategoryAbstractDao{

	@Override
	public void saveCategory(Category category) {
		System.out.println("Saving category...");
		SerenitySessionUtils.saveObjectInSerenityList(SerenityKeyConstants.CATEGORIES, category);
	}

	@Override
	public List<Category> getCategories() {
		return SerenitySessionUtils.getFromSession(SerenityKeyConstants.CATEGORIES);
		
	}

}
