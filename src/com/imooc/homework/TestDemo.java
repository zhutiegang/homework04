package com.imooc.homework;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class TestDemo {
	// ��ʾ���˵�
	public void displayMainMenu() {
		System.out.println("**************************************************************************************************************");
		System.out.println("                                          ***���˵�***");
		System.out.println("                                          1--��Ʒ����");
		System.out.println("                                          2--���ﳵ");
		System.out.println("                                          0--�˳�");
		System.out.println("**************************************************************************************************************");
		System.out.println("�������Ӧ���ֽ��в�����");
	}
	//��ʾ��Ʒ����˵�
	public void displayGMMenu(){
		System.out.println("**************************************************************************************************************");
		System.out.println("                                          ***��Ʒ����***");
		System.out.println("                                          1--��Ʒ��Ϣ����");
		System.out.println("                                          2--��ʾ������Ʒ��Ϣ");
		System.out.println("                                          9--������һ���˵�");
		System.out.println("**************************************************************************************************************");
		System.out.println("�������Ӧ�����ֶ���Ʒ���й���");
	}
	//��ʾ���ﳵ����˵�
	public void displayCartMenu(){
		System.out.println("**************************************************************************************************************");
		System.out.println("                                          ***���ﳵ����***");
		System.out.println("                                          1--�����Ʒ�����ﳵ");
		System.out.println("                                          2--�޸Ĺ��ﳵ�е���Ʒ����");
		System.out.println("                                          3--��ʾ���ﳵ�е�������Ʒ��Ϣ");
		System.out.println("                                          4--����");
		System.out.println("                                          9--������һ���˵�");
		System.out.println("**************************************************************************************************************");
		System.out.println("�������Ӧ�����ֶԹ��ﳵ���й���");
	}
	

	public static void main(String[] args) {
		// ʵ������Ʒ��
		Goods[] goodsArr = new Goods[4];
		goodsArr[0] = new Goods("goods001", "ˮ��", 56.0, "�����ˮ��");
		goodsArr[1] = new Goods("goods002", "��ˮ��", 299.0, "���������ܵ���ˮ��");
		goodsArr[2] = new Goods("goods003", "�ʼǱ�����", 4999.0, "15��ʼǱ�����");
		goodsArr[3] = new Goods("goods004", "�ֻ�", 2300.0, "Android�ֻ�");

		// ʵ������Ʒ������
		GoodsManage gm = new GoodsManage();
		boolean gmFlag=false;

		// ���ﳵ�е���Ʒ��Ϣ��
		/*
		 * System.out.println(
		 * "*************************************************************************************************"
		 * ); System.out.println("���ﳵ�е���Ʒ��Ϣ��"); GoodsInCart goodsInC=new
		 * GoodsInCart(goodsArr[3],3); System.out.println(goodsInC);
		 */

		// ���ﳵ��
		// ���ﳵ�е���Ʒ��Ϣ��
		 ShoppingCart shopC=new ShoppingCart();
		 
		int menuIndex = -1;
		int gmMenuIndex=-1;
		int cartMenuIndex=-1;
		TestDemo testDemo = new TestDemo();
		do {
			testDemo.displayMainMenu();
			Scanner console = new Scanner(System.in);
			menuIndex = console.nextInt();
			switch (menuIndex) {
			case 1:		//������Ʒ����Ŀ¼
				do{
					testDemo.displayGMMenu();
					gmMenuIndex=console.nextInt();
					switch(gmMenuIndex){
					case 1:
						System.out.println("��Ʒ��Ϣ����");
						if(!gmFlag){
							for (Goods goods : goodsArr) {
								gm.importGoods(goods);
							}
							System.out.println("����ɹ�!");
							gmFlag=true;
						}else{
							System.out.println("��Ʒ��Ϣ�Ѿ�����!");
						}
						break;
					case 2:
						if(gmFlag){
							System.out.println("��ʾ������Ʒ��Ϣ");
							gm.displayAllGoods();
						}else{
							System.out.println("��û����Ʒ���ǵõ�����Ʒ��Ϣ��");
						}
						break;
					case 9:
						break;
					default:
						System.out.println("�˵�ѡ������");
						break;
					}
				}while(gmMenuIndex!=9);
				break;
			case 2:		//���빺�ﳵĿ¼
				do{
					testDemo.displayCartMenu();
					try{
						cartMenuIndex=console.nextInt();
					}catch(InputMismatchException e){
						System.out.println("�˵�ѡ�������ʽ����");
						continue;
					}
					switch(cartMenuIndex){
					case 1:		//�����Ʒ�����ﳵ
						if(gm.getGoodsSet()==null){
							System.out.println("��û����Ʒ���ǵõ�����Ʒ��Ϣ��");
						}else{
							shopC.addGoodsToCart(gm);
						}
						break;
					case 2:
						shopC.updataNumInCart();
						break;
					case 3:
						shopC.displayAllInCart(); 
						break;
					case 4:
						System.out.println("����");
						break;
					case 9:
						break;
						default:
							System.out.println("�˵�ѡ������");
							break;
					}
				}while(cartMenuIndex!=9);
				break;
			case 0:

				break;
			}
		} while (menuIndex != 0);
	}

}
