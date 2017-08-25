package com.imooc.homework;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class TestDemo {
	// 显示主菜单
	public void displayMainMenu() {
		System.out.println("**************************************************************************************************************");
		System.out.println("                                          ***主菜单***");
		System.out.println("                                          1--商品管理");
		System.out.println("                                          2--购物车");
		System.out.println("                                          0--退出");
		System.out.println("**************************************************************************************************************");
		System.out.println("请输入对应数字进行操作：");
	}
	//显示商品管理菜单
	public void displayGMMenu(){
		System.out.println("**************************************************************************************************************");
		System.out.println("                                          ***商品管理***");
		System.out.println("                                          1--商品信息导入");
		System.out.println("                                          2--显示所有商品信息");
		System.out.println("                                          9--返回上一级菜单");
		System.out.println("**************************************************************************************************************");
		System.out.println("请输入对应的数字对商品进行管理：");
	}
	//显示购物车管理菜单
	public void displayCartMenu(){
		System.out.println("**************************************************************************************************************");
		System.out.println("                                          ***购物车管理***");
		System.out.println("                                          1--添加商品到购物车");
		System.out.println("                                          2--修改购物车中的商品数量");
		System.out.println("                                          3--显示购物车中的所有商品信息");
		System.out.println("                                          4--结算");
		System.out.println("                                          9--返回上一级菜单");
		System.out.println("**************************************************************************************************************");
		System.out.println("请输入对应的数字对购物车进行管理：");
	}
	

	public static void main(String[] args) {
		// 实例化商品类
		Goods[] goodsArr = new Goods[4];
		goodsArr[0] = new Goods("goods001", "水杯", 56.0, "不锈钢水杯");
		goodsArr[1] = new Goods("goods002", "饮水机", 299.0, "带净化功能的饮水机");
		goodsArr[2] = new Goods("goods003", "笔记本电脑", 4999.0, "15寸笔记本电脑");
		goodsArr[3] = new Goods("goods004", "手机", 2300.0, "Android手机");

		// 实例化商品管理类
		GoodsManage gm = new GoodsManage();
		boolean gmFlag=false;

		// 实例化购物车类
		 ShoppingCart shopC=new ShoppingCart();
		 
		int menuIndex = -1;
		int gmMenuIndex=-1;
		int cartMenuIndex=-1;
		TestDemo testDemo = new TestDemo();
		do {	//进入主目录
			testDemo.displayMainMenu();
			Scanner console = new Scanner(System.in);
			try{
				menuIndex = console.nextInt();
			}catch(InputMismatchException e){
				System.out.println("主菜单目录选项输入有误，请重新输入");
				console.next();
				continue;
			}
			
			switch (menuIndex) {
			case 1:		//进入商品管理目录
				do{
					testDemo.displayGMMenu();
					try{
						gmMenuIndex=console.nextInt();
					}catch(InputMismatchException e){
						System.out.println("商品管理菜单输入格式有误！请重新输入");
						console.next();
						continue;
					}
					
					switch(gmMenuIndex){
					case 1:
						System.out.println("商品信息导入");
						if(!gmFlag){
							for (Goods goods : goodsArr) {
								gm.importGoods(goods);
							}
							System.out.println("导入成功!");
							gmFlag=true;
						}else{
							System.out.println("商品信息已经导入!");
						}
						break;
					case 2:
						if(gmFlag){
							System.out.println("显示所有商品信息");
							gm.displayAllGoods();
						}else{
							System.out.println("还没有商品，记得导入商品信息！");
						}
						break;
					case 9:
						break;
					default:
						System.out.println("商品管理菜单选择有误！请重新输入");
						break;
					}
				}while(gmMenuIndex!=9);
				break;
			case 2:		//进入购物车目录
				do{
					testDemo.displayCartMenu();
					try{
						cartMenuIndex=console.nextInt();
					}catch(InputMismatchException e){
						System.out.println("购物车管理菜单选项输入格式有误，请输入整型数值");
						console.next();
						continue;
					}
					switch(cartMenuIndex){
					case 1:		//添加商品到购物车
						if(gm.getGoodsSet()==null){
							System.out.println("还没有商品，记得导入商品信息！");
						}else{
							System.out.println("添加商品到购物车");
							shopC.addGoodsToCart(gm);
						}
						break;
					case 2:
						System.out.println("修改购物车中的商品数量");
						shopC.updataNumInCart();
						break;
					case 3:
						System.out.println("显示购物车中的所有商品信息");
						shopC.displayAllInCart(); 
						break;
					case 4:
						System.out.println("结算");
						shopC.settleAccounts();
						break;
					case 9:
						break;
						default:
							System.out.println("购物车管理菜单选择有误！请重新输入");
							break;
					}
				}while(cartMenuIndex!=9);
				break;
			case 0:
				break;
				default:
					System.out.println("主菜单目录选项输入有误，请重新输入");
			}
		} while (menuIndex != 0);
	}

}
