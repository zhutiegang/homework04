package com.imooc.homework;

import java.util.Map;

public class ShoppingCart {
	private Map<String,GoodsInCart> shoppingCart;
	//构造方法
	public ShoppingCart(){
		
	}
	//getter和setter方法
	public Map<String, GoodsInCart> getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(Map<String, GoodsInCart> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	//添加商品到购物车
	public void addGoodsToCart(GoodsManage gm){
		
	}
	
	
}
