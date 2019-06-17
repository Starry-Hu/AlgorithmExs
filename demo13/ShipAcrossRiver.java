package demo13;

/**
 * 小船过河问题 - 贪心算法
 * 
 * @author StarryHu
 *
 */
public class ShipAcrossRiver {
	// 每个人耗费的时间
	private int[] time;

	public int[] getTime() {
		return time;
	}

	public void setTime(int[] time) {
		this.time = time;
	}

	public void initial(int[] time) {
		this.time = time;
	}

	public void compute() {
		// 对time进行降序排序
		for (int i = 0; i < time.length - 1; i++) {
			for (int j = i + 1; j < time.length; j++) {
				if (time[j] < time[i]) {
					int temp = time[i];
					time[i] = time[j];
					time[j] = temp;
				}
			}
		}
		// 对time升序排序，耗时短的在前面
		// 要过河的人数与耗费的总时间
		int n = time.length;
		int sum = 0;

		// 当人数至少为4时，进行两种方式比较取最小，同时过河人数减2
		// 1. 最快的和最慢的先过河，然后最快的再回来拉次慢的，再自己回来
		// 2. 最快的和次快的先过河，然后最快的回来，让最慢的和次慢的过去，再让次快的回来
		// 两种方法最后剩下的都是最快的和次快的
		while (n >= 4) {
			sum = Math.min(sum + 2 * time[0] + time[n - 1] + time[n - 2], 
					sum + time[0] + 2 * time[1] + time[n - 1]);
			n -= 2;
		}
		// 如果是三个人直接把三个人的时间加起来就可以了
		if (n == 3) {
			sum += time[0] + time[1] + time[2];
		}
		// 如果是两个人，时间为较慢的人的。
		else if (n == 2) {
			sum += time[1];
		}
		// 如果是一个人，时间为他本身
		else {
			sum += time[0];
		}
		System.out.println(sum);
	}
}
