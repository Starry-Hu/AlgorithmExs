package demo14;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("-----请输入火柴棍数目-----");
		int n = scanner.nextInt();
		System.out.println("-----请依次输入火柴棍长度-----");
		int[] data = new int[n];
		for (int i = 0; i < n; i++) {
			data[i] = scanner.nextInt();
		}
		scanner.close();
		
		
		MakeSquare makeSquare = new MakeSquare();
		makeSquare.initial(n, data);
		System.out.println(makeSquare.compute());
	}
}
