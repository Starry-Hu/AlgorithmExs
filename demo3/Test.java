package demo3;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		HuiWen huiWen = new HuiWen();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("-------请输入字符串-------");
		String string = scanner.nextLine();
		System.out.println("-------递归方法结果-------");
		huiWen.check1(string);
		System.out.println("-------检查正逆序字符串结果-------");
		huiWen.check2(string);
		System.out.println("-------检查正逆序字符串对应字符结果-------");
		huiWen.check3(string);
		scanner.close();
	}

}
