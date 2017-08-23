package com.imooc.homework;

import java.util.Iterator;
import java.util.Set;

public class TestDemo {

	public static void main(String[] args) {
		//ʵ������Ʒ��
		Goods[] goodsArr=new Goods[4];
		goodsArr[0]=new Goods("goods001", "ˮ��", 56.0, "�����ˮ��");
		goodsArr[1]=new Goods("goods002", "��ˮ��", 299.0, "���������ܵ���ˮ��");
		goodsArr[2]=new Goods("goods003", "�ʼǱ�����", 4999.0, "15��ʼǱ�����");
		goodsArr[3]=new Goods("goods004", "�ֻ�", 2300.0, "Android�ֻ�");
		
		//ʵ������Ʒ������
		System.out.println("**************************************************************************************************");
		GoodsManage gm=new GoodsManage();
		for(Goods goods:goodsArr){
			gm.importGoods(goods);
		}
		System.out.println("gm.displayAllGoods():");
		gm.displayAllGoods();
		System.out.println("*************************************************************************************************");
		System.out.println("�����������");
		Set<Goods>  goodsSet=gm.getGoodsSet();
		Iterator<Goods> it=goodsSet.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		
		//���ﳵ�е���Ʒ��Ϣ��
		System.out.println("*************************************************************************************************");
		System.out.println("���ﳵ�е���Ʒ��Ϣ��");
		GoodsInCart goodsInC=new GoodsInCart(goodsArr[3],3);
		System.out.println(goodsInC);
		
		//���ﳵ��
		//���ﳵ�е���Ʒ��Ϣ��
		System.out.println("*************************************************************************************************");
		System.out.println("���ﳵ��");
		ShoppingCart shopC=new ShoppingCart();
		shopC.addGoodsToCart(gm);
		shopC.addGoodsToCart(gm);
		shopC.displayAllInCart();
		shopC.updataNumInCart();
		shopC.displayAllInCart();
	}

}
