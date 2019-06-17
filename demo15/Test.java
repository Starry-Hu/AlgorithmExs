package demo15;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("-----请分别输入大牛、中牛、小牛的承重量----");
		float[] weight = new float[3];
		for (int i = 0; i < 3; i++) {
			weight[i] = scanner.nextFloat();
		}
		System.out.println("-----请输入大米数量----");
		int riceNumber = scanner.nextInt();
		scanner.close();
		
		RiceQuestion riceQuestion = new RiceQuestion();
		riceQuestion.initial(weight, riceNumber);
		riceQuestion.compute();
	}
}
