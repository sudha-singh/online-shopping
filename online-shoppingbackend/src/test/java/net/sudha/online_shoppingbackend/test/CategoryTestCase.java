package net.sudha.online_shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.sudha.onlineshoppingbackend.dto.Category;
import net.sudha.shoppingbackend.dao.CategoryDAO;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("net.sudha");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
	
	@Test
	public void testAddCategory()
	{
		category=new Category();
		category.setName("Indian");
		category.setDescription("This is some description about Indianclothes");
		category.setImageURL("");
		assertEquals("Successfully  added a category inside the table",true,categoryDAO.add(category));
		
		
	}
}
