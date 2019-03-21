package demo1;

public class Test {
	public static void main(String[] args) {
		Shooting shooting = new Shooting();
		
		// 需要打90环，总共打10次，则开始时除去第一次还剩9次
		shooting.compute(90, 9);

		System.out.println(shooting.getSum());
	}
}
