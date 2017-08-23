package com.imooc.homework;

public class GoodsInCart {
	private Goods goods;
	private int num;

	// 构造方法
	public GoodsInCart() {

	}

	public GoodsInCart(Goods goods, int num) {
		this.setGoods(goods);
		this.setNum(num);
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "购物车中的商品信息 [商品：" + goods + ", 数量：" + num + "]";
	}
	
	
	
}
