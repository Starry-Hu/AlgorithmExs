package demo14;

public class MakeSquare {
	// 火柴棍个数
	private int n;
	// 各个火柴棍长度数组
	private int[] data;

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int[] getData() {
		return data;
	}

	public void setData(int[] data) {
		this.data = data;
	}

	public void initial(int n, int[] data) {
		this.n = n;
		this.data = data;
	}

	public boolean compute() {
		int sum = 0;
		// 对长度降序排序，并长度求和
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[j] > data[i]) {
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
			sum += data[i];
		}
		sum += data[n-1];

		// 对长度降序排序，并长度求和
		// 如果长度总和除四余数不为0，则直接返回false
		if (sum % 4 != 0) {
			return false;
		}
		// 创建四个边数组
		int[] edge = new int[4];
		return generate(0, sum / 4, edge);
	}

	private boolean generate(int t, int target, int[] edge) {
		// 如果计算到第n+1次(即t=n)，即全部火柴棍考虑计算完毕了
		// 则返回所有的四条边是否都等于目标值（长度总和的四分之一）
		if (t == n) {
			return ((edge[0] == target) && (edge[1] == target) 
					&& (edge[2] == target) && (edge[3] == target));
		}
		// 对于当前这个火柴，尝试拼入上下左右四个边
		for (int i = 0; i < edge.length; i++) {
			// 如果当前边加上这个火柴小于等于目标值，则将该火柴加入到该边，继续下一根火柴
			if (edge[i] + data[t] <= target) {
				edge[i] += data[t];
				boolean result = generate(t + 1, target, edge);
				if (result) {
					break; // 如果返回为真，即找到一个方案则退出循环
				}
				// 若不为真则数据返回原情况
				edge[i] -= data[i];
			}
		}
		return true;
	}

}
