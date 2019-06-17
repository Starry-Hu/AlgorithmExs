package demo13;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		System.out.println("------请输入过河人数n-----");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println("------请输入每个人的耗时量-----");
		int[] data = new int[n];
		for (int i = 0; i < data.length; i++) {
			data[i] = scanner.nextInt();
		}
		scanner.close();
		ShipAcrossRiver shipAcrossRiver = new ShipAcrossRiver();
		shipAcrossRiver.initial(data);
		shipAcrossRiver.compute();
	}

}
