package net.sudha.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.sudha.onlineshoppingbackend.dto.Category;
import net.sudha.shoppingbackend.dao.CategoryDAO;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();

		// Adding first category
		category.setId(1);
		category.setName("Western");
		category.setDescription("This is some description about western clothes");
		category.setImageURL("");

		categories.add(category);
		
		// Adding Second category

		category = new Category();
		category.setId(2);
		category.setName("Indian");
		category.setDescription("This is some description about Indian clothes");
		category.setImageURL("");

		categories.add(category);

		

		// Adding third category
		category = new Category();
		category.setId(3);
		category.setName("IndoWestern");
		category.setDescription("This is some description about Indian western clothes");
		category.setImageURL("");

		categories.add(category);

	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		//enchache for each
		for(Category category:categories)
		{
			
			if(category.getId()==id) return category;
		}
		return null;
	}

	
	@Transactional
	public boolean add(Category category) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		try
		{
			System.out.println("hello1");
			sessionFactory.getCurrentSession().persist(category);
			System.out.println("hello2");
			return true;
		}
		
		catch(Exception ex)
		{
			
			ex.printStackTrace();
			return false;
		}
		
	}

}
