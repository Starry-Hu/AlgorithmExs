package demo4;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		GameTable gameTable = new GameTable();
		Scanner scanner = new Scanner(System.in);
		System.out.println("----------请输入k值（选手数为2^k）----------");
		int k = scanner.nextInt();
		scanner.close();
		gameTable.setK(k);
		gameTable.tableGenerate();
	}

}
