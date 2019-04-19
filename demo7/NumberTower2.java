package demo7;

/**
 * 数塔问题-用二维数组（下三角矩阵）存储
 * 
 * @author StarryHu
 *
 */
public class NumberTower2 {
	private int level;
	private int[][] data;
	private int[][] result;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int[][] getData() {
		return data;
	}

	public void setData(int[][] data) {
		this.data = data;
	}

	public int[][] getResult() {
		return result;
	}

	public void setResult(int[][] result) {
		this.result = result;
	}

	/**
	 * 初始化
	 * 
	 * @param level
	 *            数塔层数
	 * @param data
	 *            数塔的数据
	 */
	public void initial(int level, int[][] data) {
		this.level = level;
		this.data = data;
		result = new int[level][level];
		// 初始化result
		for (int i = 0; i < level; i++) {
			result[level - 1][i] = data[level - 1][i];
		}
	}

	public void compute() {
		// 用第i+1层的数据来向上推第i层（该层有i个数据 层数从level-1开始到1，i作为下标需要减一）
		for (int i = level - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				result[i][j] = Math.max(result[i + 1][j], result[i + 1][j + 1]) + data[i][j];
			}
		}

		showResult();
	}

	private void showResult() {
		System.out.println("----------最大路径值为：" + result[0][0] + "-----------");

		System.out.println("----------所选路径为：" + "-----------");
		System.out.print(data[0][0]);

		int j = 0;
		// 已经显示了第一个，则只需要再显示level-1次
		for (int i = 0; i < level-1; i++) {
			int temp = result[i][j] - data[i][j];
			// 如果得到剩下的最优值是和右边选择的相等，则j+1向右移一位
			// 数塔的特点，只会在上一层数的同列或右列，因此对j进行移动即可之后复用
			if (temp == result[i + 1][j + 1]) {
				j++;
			}
			System.out.print(" " + data[i + 1][j]);
		}
	}
}
