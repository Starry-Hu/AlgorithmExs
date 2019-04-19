package trial2;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("--------------请输入第一个串--------------");
		String stringA = scanner.nextLine();
		System.out.println("--------------请输入第二个串--------------");
		String stringB = scanner.nextLine();
		
		scanner.close();
		
		char[] dataA = stringA.toCharArray();
		char[] dataB = stringB.toCharArray();
		
		LongComSubsequ longComSubsequ = new LongComSubsequ();
		longComSubsequ.initial(dataA, dataB);
		longComSubsequ.findLongestComSubsequ();
		
	}
}
