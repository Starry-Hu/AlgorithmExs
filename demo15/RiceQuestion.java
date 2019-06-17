package demo15;

public class RiceQuestion {
	// 每种牛的承重量
	private float[] weight;
	// 每头牛的数量
	private int[] number;
	// 大米数量
	private float riceNumber;

	public void initial(float[] weight, float riceNumber) {
		this.weight = weight;
		this.riceNumber = riceNumber;
		number = new int[3];
	}

	public void compute() {
		backtrack(0);
	}

	public void backtrack(int t) {
		// 如果回溯次数大于等于3，则判断并输出结果
		if (t == 3) {
			System.out.println("大牛数：" + number[0] + "，中牛数：" + number[1] + "，小牛数：" + number[2]);
		} else {
			// 每头牛的数量不超过2*riceNumber（小牛的最坏情况）
			for (int i = 0; i <= 2* riceNumber; i++) {
				number[t] = i;
				// 判断合法性
				if (legal(t)) {
					backtrack(t + 1);
				}
			}
		}
	}

	private boolean legal(int t) {
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			sum += number[i] * weight[i];
		}
		// 如果没有达到目标则继续
		if ((t <= 2) && (sum < riceNumber)) {
			return true;
		}
		// 如果已经是最后一层且达到目标，则返回true
		if ((t == 3) && (sum == riceNumber)) {
			return true;
		}
		return false;
	}
}
