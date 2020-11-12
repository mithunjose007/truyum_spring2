package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	 
	 
	public static void main(String[] args) {
		
		System.out.println("adding to cart..");
		testAddCartItem();
		System.out.println("cart items are..");
		testGetAllCartItems();
		System.out.println("removing...");
		testRemoveCartItem();
	}
	
	public static void testAddCartItem() {
		CartDao testObj=new CartDaoCollectionImpl();
		testObj.addCartItem(1, 1);
	
		
		try {
			List<MenuItem> cartList=testObj.getAllCartItems(1);
			for(MenuItem m:cartList)
					System.out.println(m);
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static void testGetAllCartItems() {
		CartDao testObj=new CartDaoCollectionImpl();
		try {
			List<MenuItem> cartList=testObj.getAllCartItems(1);
			for(MenuItem m:cartList)
				System.out.println(m);
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testRemoveCartItem() {
		CartDao testObj=new CartDaoCollectionImpl();
		testObj.removeCartItem(1,1);
		List<MenuItem> cartList;
		try {
			cartList = testObj.getAllCartItems(1);
			for(MenuItem m:cartList)
				System.out.println(m);
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
