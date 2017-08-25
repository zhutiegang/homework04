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
		int num=0;
		do{
			try{
				num=sc.nextInt();
			}catch(java.util.InputMismatchException e){
				System.out.println("��Ʒ���������ʽ������Ϊ����0��������ֵ������������");
				sc.next();
				continue;
			}
			if(num<=0){
				System.out.println("��Ʒ������Ϊ����0��������ֵ������������");
				continue;
			}
		}while(num<=0);
		GoodsInCart goodsInC=new GoodsInCart(findGoods,num);
		shoppingCart.put(id, goodsInC);
		System.out.println("��Ʒ��"+goodsInC.getGoods().getGoodsName()+"  ������"+num+" ��ӳɹ�");
	}
	
	//�޸Ĺ����е���Ʒ����
	public void updataNumInCart(){
		if (shoppingCart != null) {
			Scanner sc=new Scanner(System.in);
			System.out.println("��������Ʒ���");
			String id=sc.next();
			
			Iterator<GoodsInCart> it=shoppingCart.values().iterator();
			boolean findFlag=false;
			while(it.hasNext()){
				GoodsInCart temp=it.next();
				if(temp.getGoods().getGoodsId().equals(id)){
					findFlag=true;
					System.out.println("�������޸ĺ����Ʒ����");
					int num=-1;
					//����Ʒ���������ʽ����ȷ����Ϊ��ֵʱ����������
					do{
						try{
							num=sc.nextInt();
						}catch(java.util.InputMismatchException e){
							System.out.println("��Ʒ���������ʽ��������������");
							sc.next();
							continue;
						}
						if(num==0){
							shoppingCart.remove(id);
							System.out.println("��Ϊ��Ʒ����Ϊ0���ѽ�����Ʒ�ӹ��ﳵ�Ƴ���");
						}else if(num>0){
							temp.setNum(num);
							System.out.println("��Ʒ��"+temp.getGoods().getGoodsName()+"  �޸ĺ��������"+num);
						}else{
							System.out.println("��Ʒ��������Ϊ��ֵ�����������룡");
						}
					}while(num<0);
					
				}
			}
			if(!findFlag){
				System.out.println("�����޸ĵ���Ʒ���ڹ��ﳵ��");
			}
		}
	}
	
	//��ʾ���ﳵ�е�������Ʒ
	public void displayAllInCart(){
		if (shoppingCart != null) {
			if(shoppingCart.isEmpty()){
				System.out.println("���ﳵ�տ���Ҳ����Ͽ�װ����");
			}else{
				Iterator<GoodsInCart> it=shoppingCart.values().iterator();
				while(it.hasNext()){
					System.out.println(it.next());
				}
			}
		}else{
			System.out.println("���ﳵ�տ���Ҳ����Ͽ�װ����");
		}
	}
	
	//����
	public void settleAccounts(){
		Iterator<GoodsInCart> it=shoppingCart.values().iterator();
		double sum=0;
		while(it.hasNext()){
			GoodsInCart temp=it.next(); 
			sum+=temp.getGoods().getPrice()*temp.getNum();
		}
		System.out.println("��Ʒ�ܼ�Ϊ��"+sum);
		displayAllInCart();
		shoppingCart.clear();
	}

	@Override
	public String toString() {
		return "���ﳵ��Ϣ [���ﳵ��" + shoppingCart + "]";
	}
	
}
