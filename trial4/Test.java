package trial4;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("-------------请输入背包容量------------");
		float bagMaxSize = scanner.nextInt();
		System.out.println("-------------请输入可选物品数目------------");
		int itemNum = scanner.nextInt();
		
		System.out.println("-------------请依次输入可选物品的体积大小------------");
		float[] itemSize = new float[itemNum];
		for (int i = 0; i < itemNum; i++) {
			itemSize[i] = scanner.nextInt();
		}
		
		System.out.println("-------------请依次输入可选物品的价值大小------------");
		float[] itemValue = new float[itemNum];
		for (int i = 0; i < itemNum; i++) {
			itemValue[i] = scanner.nextInt();
		}

		scanner.close();
		
		GreedyKnapSack greedyKnapSack = new GreedyKnapSack();
		greedyKnapSack.initial(bagMaxSize, itemNum, itemSize, itemValue);
		greedyKnapSack.findOptimalBag();
	}
}
