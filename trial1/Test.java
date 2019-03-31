package trial1;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		MatrixMultiplyOptimal mOptimal = new MatrixMultiplyOptimal();
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] r = new int[n+1];
		for (int i = 0; i <= n; i++) {
			r[i] = scanner.nextInt();
		}
		
		mOptimal.initial(n, r);
		mOptimal.getOptimal();
		
		scanner.close();
	}

}
