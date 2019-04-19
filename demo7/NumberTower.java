package demo7;

public class NumberTower {
	private int level;
	private int[] data;
	private int[] result;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int[] getData() {
		return data;
	}

	public void setData(int[] data) {
		this.data = data;
	}

	public int[] getResult() {
		return result;
	}

	public void setResult(int[] result) {
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
	public void initial(int level, int[] data) {
		this.level = level;
		this.data = data;
		result = new int[(level + 1) * level / 2];
		// 初始化result(将最后一层的数直接赋过去)
		for (int i = result.length - 1; i >= result.length - level; i--) {
			result[i] = data[i];
		}
	}

	public void compute() {
		// 依赖第i层数据求第i-1层(只需要最后求到第1层，即最终依赖到第2层即可)
		for (int i = level; i > 1; i--) {
			// 计算得到前i层数值总个数,即整体最后一个数的下标（-1）
			int j = i * (i + 1) / 2 - 1;
			// 求（上层）第i-1层数需要计算次数为i-1
			for (int k = 0; k < i - 1; k++) {
				// 通过该层最后一个数减去该层的长度（即i）得到上层
				result[j - i] = Math.max(result[j], result[j - 1]) + data[j - i];
				j--;
			}
		}

		showResult();
	}

	/**
	 * 展示最大路径和与所选路径
	 */
	public void showResult() {
		System.out.println("----------最大路径值为：" + result[0] + "-----------");

		System.out.println("----------所选路径为：" + "-----------");
		System.out.print(data[0]);

		// 展示选择的点
		int j = 0;
		for (int i = 1; i < level; i++) {
			// 得到当前一层的长度(数个数)
			int iLength = i * (i + 1) / 2 - (i-1)*i/2;

			int temp = result[j] - data[j];
			if (temp == result[j + iLength]) {
				j = j + iLength;
			} else if (temp == result[j + iLength + 1]) {
				j = j + iLength + 1;
			}

			System.out.print(" " + data[j]);
		}
	}
}
