package trial1;

/**
 * 求矩阵相乘的相乘先后的最优组合
 * 
 * @author StarryHu
 *
 */
public class MatrixMultiplyOptimal {
	// 矩阵个数
	private int n;
	// 对应的阶数
	private int[] r;
	// 存储对应位置矩阵相乘时的次数
	private int[][] count;
	// 存储最优划分位置
	private int[][] location;

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int[][] getS() {
		return location;
	}

	public void setS(int[][] s) {
		this.location = s;
	}

	public int[][] getC() {
		return count;
	}

	public void setC(int[][] c) {
		this.count = c;
	}

	public int[] getR() {
		return r;
	}

	public void setR(int[] r) {
		this.r = r;
	}

	/**
	 * 初始化
	 * 
	 * @param n
	 *            矩阵个数
	 */
	public void initial(int n, int[] r) {
		this.n = n;
		this.r = r;
		location = new int[n][n];
		count = new int[n][n];
	}

	public void getOptimal() {
		// 初始化矩阵（由于之前初始化JAVA默认给数组里每个元素为0，即可跳过此步）

		// 首先计算两个矩阵相乘的情况，分别找出以i为起始矩阵的最优相乘次序位置和相乘次数
		// 之后再计算三个(p个)矩阵相乘的情况，直至最后到n个矩阵相乘的情况，找到最优相乘次序和相乘次数

		for (int p = 2; p <= n; p++) {
			for (int i = 0; i < n - p + 1; i++) {
				int j = i + p - 1;
				// 得到每次的第一种划分情况，在第i个矩阵后划分开(i<=k<j,k为划分位置)
				// 第一次划分情况默认为最优划分，之后再进行比较替换
				count[i][j] = count[i][i] + count[i + 1][j] + r[i] * r[i+1] * r[j + 1];
				location[i][j] = i;

				// 计算其他划分位置的乘法次数(i<=k<j)
				for (int k = i+1; k < j; k++) {
					int temp = count[i][k] + count[k + 1][j] + r[i] * r[k + 1] * r[j + 1];
					// 若更优则进行替换
					if (temp < count[i][j]) {
						count[i][j] = temp;
						location[i][j] = k;
					}
				}
			}
		}

		show();
		
	}

	/**
	 * 展示次数数组与位置划分数组，同时展示最优划分序列
	 */
	private void show() {
		System.out.println("乘法次数相关矩阵为：");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(count[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("划分位置相关矩阵为：");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(location[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("最优乘法次数为："+count[0][n-1]);
		// 展示最优组合矩阵序列
		showList(0, n-1);
	}
	
	
	/**
	 * 找从start-end的最优组合矩阵序列(递归显示)
	 * @param start
	 * @param end
	 */
	private void showList(int start,int end) {
		if (start >= end) {
			System.out.print("(A" + start + ")");
		}else {
			// 以此时的最优位置为分界点，找两边的最优划分位置
			System.out.print("(");
			showList(start, location[start][end]);
			showList(location[start][end]+1, end);
			System.out.print(")");
		}
	}
}
