package demo8;

/**
 * 编辑距离 - 动态规划
 * 
 * @author StarryHu
 *
 */
public class Levenshtein {
	private String A;
	private String B;
	private char[] Achars;
	private char[] Bchars;
	// 从A[1...i] 变为 B[1...j]的最小编辑距离
	private int[][] result;

	public String getA() {
		return A;
	}

	public void setA(String a) {
		A = a;
	}

	public String getB() {
		return B;
	}

	public void setB(String b) {
		B = b;
	}

	public int[][] getResult() {
		return result;
	}

	public void setResult(int[][] result) {
		this.result = result;
	}

	public char[] getAchars() {
		return Achars;
	}

	public void setAchars(char[] achars) {
		Achars = achars;
	}

	public char[] getBchars() {
		return Bchars;
	}

	public void setBchars(char[] bchars) {
		Bchars = bchars;
	}

	/**
	 * 初始化
	 * 
	 * @param A
	 *            第一个串
	 * @param B
	 *            第二个串
	 */
	public void initial(String A, String B) {
		this.A = A;
		this.B = B;

		// 初始化结果数组，同时空出0行/0列用来存储基本值
		result = new int[A.length() + 1][B.length() + 1];

		Achars = A.toCharArray();
		Bchars = B.toCharArray();

		// 对结果数组进行初始化,A为空想要变成对应i长的B/B为空...
		// 即result[0][i] = i (1=<i<=B.length)
		// result[i][0] = i (1=<i<=A.length)
		for (int i = 1; i <= Achars.length; i++) {
			result[i][0] = i;
		}
		for (int i = 1; i <= Bchars.length; i++) {
			result[0][i] = i;
		}
	}

	public void compute() {
		// 比较A串的第i个字符和B串的第j个字符，同时动态选择情况
		for (int i = 1; i <= Achars.length; i++) {
			for (int j = 1; j <= Bchars.length; j++) {
				// 先查看两者是否相等，同时将此种 “改情况的值”存入，并与其他两者情况比较
				// 如果两者相等，则此时最小编辑距离为去掉这个字符的最小编辑距离
				// 如果不相等，则替换A串的最后一个为B串的最后一个，需要在原来的基础上加1
				if (Achars[i - 1] == Bchars[j - 1]) {
					result[i][j] = result[i - 1][j - 1];
				} else {
					result[i][j] = result[i - 1][j - 1] + 1;
				}

				// 最后对三种情况（即对A的最后一个字符的增删、改操作）进行比较，取值最小的作为此时的最小编辑距离
				int tempMin = Math.min(result[i - 1][j] + 1, result[i][j - 1] + 1);
				result[i][j] = Math.min(result[i][j], tempMin);
			}
		}
		System.out.println(result[A.length()][B.length()]);
	}
}
