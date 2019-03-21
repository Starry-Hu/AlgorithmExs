package demo2;

public class Test {
	public static void main(String[] args) {
		// 从已知的第十天剩余一个开始（第十天发现只剩一个，还没吃）
		// 总共吃了的天数只有9天
		EatPeach eatPeach = new EatPeach();
		
		System.out.println("---------递归---------");
		int sum1 = eatPeach.compute(10, 1);
		System.out.println("--------总数为" + sum1 + "--------");
		
		
		System.out.println("---------纯循环--------");
		int sum2 = eatPeach.compute2(10, 1);
		System.out.println("--------总数为" + sum2 + "--------");
	}
}
