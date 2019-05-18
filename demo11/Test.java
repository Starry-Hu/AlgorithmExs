package demo11;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("------请输入总人数-----");
		int n = scanner.nextInt();
		int[] dealTime = new int[n];
		System.out.println("------请依次输入所需处理时间-----");
		for (int i = 0; i < dealTime.length; i++) {
			dealTime[i] = scanner.nextInt();
		}
		scanner.close();
		
		
		QueueGreedy queueGreedy = new QueueGreedy();
		queueGreedy.initial(n, dealTime);
		queueGreedy.shortestWaitQueue();
	}
}
