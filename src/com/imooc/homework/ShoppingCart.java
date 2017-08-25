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
		int num=0;
		do{
			try{
				num=sc.nextInt();
			}catch(java.util.InputMismatchException e){
				System.out.println("商品数量输入格式有误，须为大于0的整型数值！请重新输入");
				sc.next();
				continue;
			}
			if(num<=0){
				System.out.println("商品数量须为大于0的整型数值！请重新输入");
				continue;
			}
		}while(num<=0);
		GoodsInCart goodsInC=new GoodsInCart(findGoods,num);
		shoppingCart.put(id, goodsInC);
		System.out.println("商品："+goodsInC.getGoods().getGoodsName()+"  数量："+num+" 添加成功");
	}
	
	//修改购物中的商品数量
	public void updataNumInCart(){
		if (shoppingCart != null) {
			Scanner sc=new Scanner(System.in);
			System.out.println("请输入商品编号");
			String id=sc.next();
			
			Iterator<GoodsInCart> it=shoppingCart.values().iterator();
			boolean findFlag=false;
			while(it.hasNext()){
				GoodsInCart temp=it.next();
				if(temp.getGoods().getGoodsId().equals(id)){
					findFlag=true;
					System.out.println("请输入修改后的商品数量");
					int num=-1;
					//当商品数量输入格式不正确或者为负值时，重新输入
					do{
						try{
							num=sc.nextInt();
						}catch(java.util.InputMismatchException e){
							System.out.println("商品数量输入格式有误，请重新输入");
							sc.next();
							continue;
						}
						if(num==0){
							shoppingCart.remove(id);
							System.out.println("因为商品数量为0，已将该商品从购物车移除！");
						}else if(num>0){
							temp.setNum(num);
							System.out.println("商品："+temp.getGoods().getGoodsName()+"  修改后的数量："+num);
						}else{
							System.out.println("商品数量不能为负值，请重新输入！");
						}
					}while(num<0);
					
				}
			}
			if(!findFlag){
				System.out.println("你所修改的商品不在购物车中");
			}
		}
	}
	
	//显示购物车中的所有商品
	public void displayAllInCart(){
		if (shoppingCart != null) {
			if(shoppingCart.isEmpty()){
				System.out.println("购物车空空如也，请赶快装满吧");
			}else{
				Iterator<GoodsInCart> it=shoppingCart.values().iterator();
				while(it.hasNext()){
					System.out.println(it.next());
				}
			}
		}else{
			System.out.println("购物车空空如也，请赶快装满吧");
		}
	}
	
	//结算
	public void settleAccounts(){
		Iterator<GoodsInCart> it=shoppingCart.values().iterator();
		double sum=0;
		while(it.hasNext()){
			GoodsInCart temp=it.next(); 
			sum+=temp.getGoods().getPrice()*temp.getNum();
		}
		System.out.println("商品总价为："+sum);
		displayAllInCart();
		shoppingCart.clear();
	}

	@Override
	public String toString() {
		return "购物车信息 [购物车：" + shoppingCart + "]";
	}
	
}
