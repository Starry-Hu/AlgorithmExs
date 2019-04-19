package demo7;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("----------请输入数塔的层数-----------");
		int level = scanner.nextInt();
		System.out.println("----------请输入数塔点的数值（方式一）-----------");
		int[] data = new int[level * (1 + level) / 2];
		for (int i = 0; i < data.length; i++) {
			data[i] = scanner.nextInt();
		}
		
		NumberTower numberTower = new NumberTower();
		numberTower.initial(level, data);
		numberTower.compute();

		System.out.println();
		System.out.println("----------请输入数塔点的数值（方式二）-----------");
		int[][] data2 = new int[level][level];
		for (int i = 0; i < level; i++) {
			for (int j = 0; j <= i; j++) {
				data2[i][j] = scanner.nextInt();
			}
		}

		NumberTower2 nTower2 = new NumberTower2();
		nTower2.initial(level, data2);
		nTower2.compute();
		
		scanner.close();
	}
}
