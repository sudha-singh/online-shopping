package net.sudha.shoppingbackend.dao;

import java.util.List;

import net.sudha.onlineshoppingbackend.dto.Category;

public interface CategoryDAO {

	
	boolean add(Category category);
	List<Category> list();
	Category get(int id);
}
