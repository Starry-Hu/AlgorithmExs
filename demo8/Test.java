package demo8;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("-----------请输入A串------------");
		String A = scanner.nextLine();
		System.out.println("-----------请输入B串------------");
		String B = scanner.nextLine();
		scanner.close();
		
		Levenshtein levenshtein = new Levenshtein();
		levenshtein.initial(A, B);
		levenshtein.compute();
	}
}
