package com.imooc.homework;

import java.util.Map;

public class ShoppingCart {
	private Map<String,GoodsInCart> shoppingCart;
	//���췽��
	public ShoppingCart(){
		
	}
	//getter��setter����
	public Map<String, GoodsInCart> getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(Map<String, GoodsInCart> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	//�����Ʒ�����ﳵ
	public void addGoodsToCart(GoodsManage gm){
		
	}
	
	
}
