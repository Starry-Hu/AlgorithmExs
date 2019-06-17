package demo12;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("-------请输入数的个数n-------");
		int n = scanner.nextInt();
		System.out.println("-------请依次输入每个数的个数ai与bi-------");
		NumberObj[] data = new NumberObj[n];
		for (int i = 0; i < n; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			NumberObj numberObj = new NumberObj(a, b);
			data[i] = numberObj;
		}
		scanner.close();
		NumberGame numberGame = new NumberGame();
		numberGame.initial(data);
		numberGame.compute();
	}
}
