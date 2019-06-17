package demo11;

/**
 * 使用贪心算法解决排队等待时间最短问题
 * @author StarryHu
 *
 */
public class QueueGreedy {
	// 总人数
	private int n;
	// 每个人的处理时间
	private int[] dealTime;
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public int[] getDealTime() {
		return dealTime;
	}
	public void setDealTime(int[] dealTime) {
		this.dealTime = dealTime;
	}
	
	/**
	 * 初始化
	 * @param n 总人数
	 * @param waitTime 每个人的处理时间数组
	 */
	public void initial(int n,int[] dealTime) {
		this.n = n;
		this.dealTime = dealTime;
	}
	
	/**
	 * 求出最短等待时间的队列
	 */
	public void shortestWaitQueue() {
		// 根据等待队列的大小排序
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if (dealTime[i] > dealTime[j]) {
					int temp = dealTime[i];
					dealTime[i] = dealTime[j];
					dealTime[j] = temp;
				}
			}
		}
		
		int sum = 0;
		// 进行不同位置对应累加次数的累加运算，实现总和最小
		for (int i = 0; i < n; i++) {
			sum += dealTime[i] * (n-i);
		}
		
		System.out.println("最短等待时间为：" + sum);
	}
}
