package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest  {
	
	//static MenuItemDaoCollectionImpl testObj=new MenuItemDaoCollectionImpl();
	
	public static void main(String[] args) {
		
		System.out.println("menu item list admin:");
		testGetMenuItemListAdmin();
		System.out.println("menu item list customer:");
		testGetMenuItemListCustomer();
		System.out.println("Editing...");
		testModifyMenuItem();
		System.out.println("Menu item with id 1 is");
		testGetMenuItem();
		
	}
	
	public static void testGetMenuItemListAdmin() {
		MenuItemDaoCollectionImpl testObj=new MenuItemDaoCollectionImpl();
		List<MenuItem> mList=testObj.getMenuItemListAdmin();
		for(MenuItem m:mList)
				System.out.println(m);
	}
	public static void testGetMenuItemListCustomer() {
		MenuItemDaoCollectionImpl testObj=new MenuItemDaoCollectionImpl();
		List<MenuItem> cList=testObj.getMenuItemListCustomer();
		for(MenuItem c:cList)
			System.out.println(c);
	}
	public static void testModifyMenuItem() {
		MenuItemDaoCollectionImpl testObj=new MenuItemDaoCollectionImpl();
		MenuItem m=new MenuItem(3, "French Fries", 300.0f, true, DateUtil.convertToDate("11/08/2019"),"starter", false);
		testObj.modifyMenuItem(m);
	}
	public static void testGetMenuItem() {
		MenuItemDaoCollectionImpl testObj=new MenuItemDaoCollectionImpl();
		MenuItem mi=testObj.getMenuItem(1);
		System.out.println(mi);
	}
}
