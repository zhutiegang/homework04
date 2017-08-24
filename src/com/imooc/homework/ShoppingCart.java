package com.imooc.homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ShoppingCart {
	private Map<String, GoodsInCart> shoppingCart;

	// 构造方法
	public ShoppingCart() {

	}

	// getter和setter方法
	public Map<String, GoodsInCart> getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(Map<String, GoodsInCart> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	// 添加商品到购物车
	public void addGoodsToCart(GoodsManage gm) {
		System.out.println("添加商品到购物车");
		gm.displayAllGoods();
		if (shoppingCart == null) {
			shoppingCart = new HashMap<String, GoodsInCart>();
		}
		Set<Goods> goodsSet = gm.getGoodsSet();
		Iterator<Goods> it = goodsSet.iterator();
		boolean flag=true;
		System.out.println("请输入要添加的商品编号：");
		Scanner sc=new Scanner(System.in);
		String id=sc.next();
		Goods findGoods=null;
		while (it.hasNext()) {
			Goods temp=it.next();
			if (temp.getGoodsId().equals(id)) {
				findGoods=temp;
				flag=false;
				break;
			}
		}
		if(flag){
			System.out.println("你所购买的商品不存在");
			return;
		}
		System.out.println("请输入购买的数量：");
		int num=sc.nextInt();
		GoodsInCart goodsInC=new GoodsInCart(findGoods,num);
		shoppingCart.put(id, goodsInC);
	}
	
	//修改购物中的商品数量
	public void updataNumInCart(){
		if (shoppingCart != null) {
			System.out.println("修改购物车中的商品数量");
			Scanner sc=new Scanner(System.in);
			System.out.println("请输入商品编号");
			String id=sc.next();
			System.out.println("请输入修改后的商品数量");
			int num=sc.nextInt();
			Iterator<GoodsInCart> it=shoppingCart.values().iterator();
			while(it.hasNext()){
				GoodsInCart temp=it.next();
				if(temp.getGoods().getGoodsId().equals(id)){
					temp.setNum(num);
				}
			}
		}
	}
	
	//显示购物车中的所有商品
	public void displayAllInCart(){
		if (shoppingCart != null) {
			System.out.println("显示购物车中的所有商品信息");
			Iterator<GoodsInCart> it=shoppingCart.values().iterator();
			while(it.hasNext()){
				System.out.println(it.next());
			}
		}
	}

	@Override
	public String toString() {
		return "购物车信息 [购物车：" + shoppingCart + "]";
	}
	
}
