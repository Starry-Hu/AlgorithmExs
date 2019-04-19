package demo5;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		MaxSubsequeTotal mTotal = new MaxSubsequeTotal();
		Scanner scanner = new Scanner(System.in);
		System.out.println("--------请输入序列值个数--------");
		int n = scanner.nextInt();
		int[] data = new int[n];
		for (int i = 0; i < n; i++) {
			data[i] = scanner.nextInt();
		}
		
		scanner.close();
		
		mTotal.initial(data);
		System.out.println("--------方法一测试--------");
		mTotal.maxSum1();
		System.out.println("\n--------方法二测试--------");
		mTotal.maxSum2();
		System.out.println("\n--------方法三测试（动态规划）--------");
		mTotal.maxSum3();
		System.out.println("\n--------方法四测试（分治）--------");
		mTotal.maxSum4();
	}

}
