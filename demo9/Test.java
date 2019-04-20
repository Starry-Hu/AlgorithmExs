package demo9;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		System.out.println("------------请输入导弹数目--------------");
		int n = scanner.nextInt();
		System.out.println("------------请输入每发导弹高度--------------");
		int[] data = new int[n];
		for (int i = 0; i < data.length; i++) {
			data[i] = scanner.nextInt();
		}
		scanner.close();
		
		MaxNoIncreaseSequ mSequ = new MaxNoIncreaseSequ();
		mSequ.initial(data);
		mSequ.computeMaxNum();
	}
}
