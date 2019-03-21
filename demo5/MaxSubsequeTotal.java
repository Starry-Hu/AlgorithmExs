package demo5;

/**
 * 求给定序列的最大子序列和
 * 
 * @author StarryHu
 *
 */
public class MaxSubsequeTotal {
	// 存放给定序列
	private int[] data;

	public int[] getData() {
		return data;
	}

	public void setData(int[] data) {
		this.data = data;
	}

	// 初始化给定序列
	public void initial(int[] data) {
		this.data = data;
	}

	// 展示子序列
	public void show(int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(data[i] + " ");
		}
	}

	/**
	 * 使用二重循环用来扫描以i为起点的所有子序列 求和并于max比较
	 */
	public void maxSum1() {
		// 记录最大值和子序列的起始编号与结束编号
		int max = 0, start = 0, end = 0;

		for (int i = 0; i < data.length; i++) {
			// 一个序列的子序列结束时将sum清空
			int sum = 0;
			for (int j = i; j < data.length; j++) {
				sum += data[j];

				// 如果当前计算得到的和大于最大值，则替换
				if (sum > max) {
					max = sum;
					start = i;
					end = j;
				}
			}
		}

		System.out.println("最大值为：" + max);

		show(start, end);
	}

	/**
	 * 使用以data[0]为首的子序列的和，来获取任意子序列和 并进行比较取最大值
	 * data[b]~data[e]=sum[e+1]-sum[b-1]
	 */
	public void maxSum2() {
		// 建立和的数组，并初始化第一个为1.
		int[] sums = new int[data.length + 1];
		sums[0] = 0;
		// 每个sums对应的值为前一个sums值加上对应位置上的data值
		for (int i = 1; i < sums.length; i++) {
			sums[i] = sums[i - 1] + data[i - 1];
		}

		// 记录最大值和子序列的起始编号与结束编号
		int max = 0, start = 0, end = 0;
		// 循环计算sums相减，得到各个子序列的和
		for (int i = 0; i < sums.length; i++) {
			for (int j = i + 1; j < sums.length; j++) {
				int temp = sums[j] - sums[i];
				if (temp > max) {
					max = temp;
					// 设置子序列的起始终止下标
					// 注意是基于data数组而非sums数组，因此下标应-1以匹配data
					// data[b]~data[e]=sum[e+1]-sum[b]
					start = i;
					end = j-1;
				}
			}
		}

		System.out.println("最大值为：" + max);
		// 展示子序列
		show(start, end);
	}

	
	/**
	 * 使用分治/线性规划？解决
	 */
	public void maxSum3() {
		if (data == null || data.length == 0)
			return ;

		int global = data[0], local = data[0];
		int startG = 0, endG = 0, startLocal = 0, endLocal = 0;

		for (int i = 1; i < data.length; i++) {
			// local = Math.max(data[i], local+data[i]);
			// 如果单独这个数比加上局部最优还要大，则只取单独的这个数为局部最优
			// 否则在原本的局部最优的基础上扩展子序列长度（接着下一个）
			if (data[i] > local + data[i]) {
				local = data[i];
				// 重置子序列起始结束位置
				startLocal = i;
				endLocal = i;
			} else {
				local += data[i];
				// 改变子序列的结束位置
				endLocal = i;
			}

			// global = Math.max(local, global);
			// 如果此时局部最优比全局最优大，则替换
			if (local > global) {
				global = local;
				startG = startLocal;
				endG = endLocal;
			}
		}

		System.out.println("最大值为：" + global);
		// 展示子序列
		show(startG, endG);
	}
}
