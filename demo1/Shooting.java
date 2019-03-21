package demo1;

/**
 * 递归方法解决打靶问题
 * 
 * @author StarryHu
 *
 */
public class Shooting {
	
	// 记录打靶的环数
	private int[] records = new int[10];

	// 可能方案数
	private int sum = 0;

	public int[] getRecords() {
		return records;
	}

	public void setRecords(int[] records) {
		this.records = records;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	/**
	 * 显示本次打靶的环数记录
	 */
	public void show() {
		// for (int i = 0; i < records.length; i++) {
		// System.out.print(records[i] + " ");
		// }
		// System.out.println();
		sum++;
	}

	/**
	 * @param score
	 *            达到90环还需要打的环数
	 * @param num
	 *            剩余开枪次数(0-9) 第i次，其剩余次数为10-i
	 */
	public void compute(int score, int num) {
		/*
		 * 本次开枪前判断 如果剩余要打的环数<0(即现在的总环数大于90) 
		 * 或者剩余的环数即使本次+后面都10环也达不到90
		 * 
		 * 即 >90 || <90 退出循环
		 */
		if (score < 0 || score > (num + 1) * 10) {
			return;
		}

		// 剩余次数为0，第10次才符合条件(最后一次时)
		if (num == 0) {
			records[num] = score;
			show();
			return;
		}

		for (int i = 0; i <= 10; i++)// 每枪的环数，0-10,11种
		{
			// 每抢的环数存到数据中(从后开始存)
			records[num] = i;
			// 递归，剩余环数减去当前这一枪的环数，剩余枪数减去1
			compute(score - i, num - 1);
		}
	}
}
