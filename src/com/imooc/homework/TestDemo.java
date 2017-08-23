package com.imooc.homework;

import java.util.Iterator;
import java.util.Set;

public class TestDemo {

	public static void main(String[] args) {
		//实例化商品类
		Goods[] goodsArr=new Goods[4];
		goodsArr[0]=new Goods("goods001", "水杯", 56.0, "不锈钢水杯");
		goodsArr[1]=new Goods("goods002", "饮水机", 299.0, "带净化功能的饮水机");
		goodsArr[2]=new Goods("goods003", "笔记本电脑", 4999.0, "15寸笔记本电脑");
		goodsArr[3]=new Goods("goods004", "手机", 2300.0, "Android手机");
		
		//实例化商品管理类
		System.out.println("**************************************************************************************************");
		GoodsManage gm=new GoodsManage();
		for(Goods goods:goodsArr){
			gm.importGoods(goods);
		}
		System.out.println("gm.displayAllGoods():");
		gm.displayAllGoods();
		System.out.println("*************************************************************************************************");
		System.out.println("迭代器输出：");
		Set<Goods>  goodsSet=gm.getGoodsSet();
		Iterator<Goods> it=goodsSet.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		
		//购物车中的商品信息类
		System.out.println("*************************************************************************************************");
		System.out.println("购物车中的商品信息类");
		GoodsInCart goodsInC=new GoodsInCart(goodsArr[3],3);
		System.out.println(goodsInC);
		
		//购物车类
		//购物车中的商品信息类
		System.out.println("*************************************************************************************************");
		System.out.println("购物车类");
		ShoppingCart shopC=new ShoppingCart();
		shopC.addGoodsToCart(gm);
		shopC.addGoodsToCart(gm);
		shopC.displayAllInCart();
		shopC.updataNumInCart();
		shopC.displayAllInCart();
	}

}
