package trial3;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("-------------请输入背包容量------------");
		int bagMaxSize = scanner.nextInt();
		System.out.println("-------------请输入可选物品数目------------");
		int itemNum = scanner.nextInt();
		
		System.out.println("-------------请依次输入可选物品的体积大小------------");
		int[] itemSize = new int[itemNum];
		for (int i = 0; i < itemNum; i++) {
			itemSize[i] = scanner.nextInt();
		}
		
		System.out.println("-------------请依次输入可选物品的价值大小------------");
		int[] itemValue = new int[itemNum];
		for (int i = 0; i < itemNum; i++) {
			itemValue[i] = scanner.nextInt();
		}

		scanner.close();
		
		KnapSack knapSack = new KnapSack();
		knapSack.initial(bagMaxSize, itemNum, itemSize, itemValue);
		knapSack.findOptimalBag();
	}
}
