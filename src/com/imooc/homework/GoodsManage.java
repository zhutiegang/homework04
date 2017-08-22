package com.imooc.homework;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GoodsManage {
	private Set<Goods> goodsSet;

	// 构造方法
	public GoodsManage() {

	}

	public GoodsManage(Set<Goods> goodsSet) {
		this.setGoodsSet(goodsSet);
	}

	public Set<Goods> getGoodsSet() {
		return goodsSet;
	}

	public void setGoodsSet(Set<Goods> goodsSet) {
		this.goodsSet = goodsSet;
	}
	
	//商品信息导入
	public void importGoods(Goods goods){
		if(goodsSet==null){
			goodsSet=new HashSet<Goods>();
		}
		goodsSet.add(goods);
	}
	//显示所有商品信息
	public void displayAllGoods(){
		if(goodsSet!=null){
			Iterator<Goods> it=goodsSet.iterator();
			while(it.hasNext()){
				System.out.println(it.next());
			}
		}
	}
	

}
