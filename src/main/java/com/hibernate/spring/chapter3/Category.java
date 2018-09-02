package com.hibernate.spring.chapter3;

import java.util.HashSet;
import java.util.Set;

import org.springframework.util.ObjectUtils;

public class Category {
	private String name;
	private Category parentCategory;
	private Set<Category> childCategories = new HashSet<Category>();
	private Set<Item> items = new HashSet<Item>();

	public Category() {
		// empty
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final Category getParentCategory() {
		return parentCategory;
	}

	public final void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	public final Set<Category> getChildCategories() {
		return childCategories;
	}

	public final void setChildCategories(Set<Category> childCategories) {
		this.childCategories = childCategories;
	}
	
	public final Set<Item> getItems() {
		return items;
	}

	public final void setItems(Set<Item> items) {
		this.items = items;
	}

	public void addChildCategory(Category childCategory) {
		
		if (ObjectUtils.isEmpty(childCategory)) {
			throw new IllegalArgumentException("Null child category");
		}
		
		if (!ObjectUtils.isEmpty(childCategory.getParentCategory())) {
			childCategory.getParentCategory().getChildCategories().remove(childCategory);
		}
		
		childCategory.setParentCategory(this);
		childCategories.add(childCategory);
	}

	@Override
	public String toString() {
		return new StringBuffer().append("Category [name=").append(name)
				.append(", parentCategory=").append(parentCategory)
				.append(", childCategories=").append(childCategories.toString())
				.append(", items=").append(items.toString())
				.append("]").toString();
	}
	
	
}
