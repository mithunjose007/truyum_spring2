package com.cognizant.truyum.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;


public class MenuItemServiceTest {
	MenuItemService service;
	@Before
	public void initializeService() {
		ApplicationContext context=new AnnotationConfigApplicationContext();
		((AnnotationConfigApplicationContext) context).scan("com.cognizant.truyum");
		((AnnotationConfigApplicationContext) context).refresh();
		service=(MenuItemService) context.getBean("menuItemService");
		
		//ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml"); 
		//service=context.getBean(MenuItemService.class);
		
	}
	@Test
	public void testGetMenuItemListAdminSize() {
		assertEquals(5, service.getMenuItemListAdmin().size());
	}
	@Test
	public void testGetMenuItemListAdminContainsSandwich(){
		//boolean flag=service.getMenuItemListAdmin().contains("Sandwich");
		//assertTrue(flag);
		boolean flag=false;
		boolean expected=true;
		for(MenuItem item:service.getMenuItemListAdmin()) {
			if(item.getName().equalsIgnoreCase("sandwich")) {
				flag=true;
				break;
			}
		}
		assertEquals(expected,flag);
		
	}
	@Test
	public void testGetMenuItemListCustomerSize(){
		assertEquals(2,service.getMenuItemListCustomer().size());
	}
	@Test
	public void testGetMenuItemListCustomerNotContainsFrenchFries() {
		boolean flag=true;
		for(MenuItem item:service.getMenuItemListCustomer()) {
			if(!(item.getName().equalsIgnoreCase("FrenchFries"))){
				flag=false;
			}
		}
		assertFalse(flag);
	}
	@Test
	public void testGetMenuItem() {
		
		assertTrue(service.getMenuItem(2).getName().equalsIgnoreCase("Burger"));
	}
	@Test
	public void testModifyMenuItem() {
		MenuItem item=new MenuItem(1, "pizza", 92.5f, true, DateUtil.convertToDate("15/03/2017"),"Main Course", true);
		service.modifyMenuItem(item);
		
		assertTrue(service.getMenuItem(1).getName().equalsIgnoreCase("pizza"));
		assertTrue(92.5==service.getMenuItem(1).getPrice());
	}


}