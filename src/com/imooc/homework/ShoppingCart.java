package com.imooc.homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ShoppingCart {
	private Map<String, GoodsInCart> shoppingCart;

	// ���췽��
	public ShoppingCart() {

	}

	// getter��setter����
	public Map<String, GoodsInCart> getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(Map<String, GoodsInCart> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	// �����Ʒ�����ﳵ
	public void addGoodsToCart(GoodsManage gm) {
		System.out.println("�����Ʒ�����ﳵ");
		gm.displayAllGoods();
		if (shoppingCart == null) {
			shoppingCart = new HashMap<String, GoodsInCart>();
		}
		Set<Goods> goodsSet = gm.getGoodsSet();
		Iterator<Goods> it = goodsSet.iterator();
		boolean flag=true;
		System.out.println("������Ҫ��ӵ���Ʒ��ţ�");
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
			System.out.println("�����������Ʒ������");
			return;
		}
		System.out.println("�����빺���������");
		int num=sc.nextInt();
		GoodsInCart goodsInC=new GoodsInCart(findGoods,num);
		shoppingCart.put(id, goodsInC);
	}
	
	//�޸Ĺ����е���Ʒ����
	public void updataNumInCart(){
		if (shoppingCart != null) {
			System.out.println("�޸Ĺ��ﳵ�е���Ʒ����");
			Scanner sc=new Scanner(System.in);
			System.out.println("��������Ʒ���");
			String id=sc.next();
			System.out.println("�������޸ĺ����Ʒ����");
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
	
	//��ʾ���ﳵ�е�������Ʒ
	public void displayAllInCart(){
		if (shoppingCart != null) {
			System.out.println("��ʾ���ﳵ�е�������Ʒ��Ϣ");
			Iterator<GoodsInCart> it=shoppingCart.values().iterator();
			while(it.hasNext()){
				System.out.println(it.next());
			}
		}
	}

	@Override
	public String toString() {
		return "���ﳵ��Ϣ [���ﳵ��" + shoppingCart + "]";
	}
	
}
