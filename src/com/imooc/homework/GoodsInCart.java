package com.imooc.homework;

public class GoodsInCart {
	private Goods goods;
	private int num;

	// ���췽��
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
		return  "��Ʒ���ƣ�"+goods.getGoodsName() +" �� ��Ʒ�۸�"+goods.getPrice() +" �� ��Ʒ������"+goods.getGoodsDesp()+ " �� ������" + num;
	}
	
	
	
}
