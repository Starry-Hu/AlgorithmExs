package demo6;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Hanoi hanoi = new Hanoi();
		System.out.println("------请输入盘子个数------");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		
		char from = 'A';
		char depend = 'B';
		char to = 'C';
		hanoi.hanNuo(n, from, depend, to);
	}

}
