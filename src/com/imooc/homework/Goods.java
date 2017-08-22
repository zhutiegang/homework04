package com.imooc.homework;

public class Goods {
	private String goodsId;
	private String goodsName;
	private double price;
	private String goodsDesp;
	//构造方法
	public Goods(){
		
	}
	public Goods(String goodsId, String goodsName, double price, String goodsDesp){
		this.setGoodsId(goodsId);
		this.setGoodsName(goodsName);
		this.setPrice(price);
		this.setGoodsDesp(goodsDesp);
	}
	//getter和setter方法
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getGoodsDesp() {
		return goodsDesp;
	}
	public void setGoodsDesp(String goodsDesp) {
		this.goodsDesp = goodsDesp;
	}
	//hashCode()和equals()方法
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goodsDesp == null) ? 0 : goodsDesp.hashCode());
		result = prime * result + ((goodsId == null) ? 0 : goodsId.hashCode());
		result = prime * result + ((goodsName == null) ? 0 : goodsName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if(obj.getClass()==Goods.class){
			Goods temp=(Goods)obj;
			return temp.getGoodsId().equals(goodsId)&&temp.getGoodsName().equals(goodsName);
		}
		return false;
	}
	@Override
	public String toString() {
		return "商品信息 [商品编号： " + goodsId + ", 名称： " + goodsName + ", 价格： " + price + ", 描述： "
				+ goodsDesp + "]";
	}
	
}
