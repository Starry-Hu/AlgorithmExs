package demo9;

/**
 * 最长非递增序列 具体应用：导弹拦截
 * 
 * @author StarryHu
 *
 */
public class MaxNoIncreaseSequ {
	// 记录导弹的高度
	private int[] data;
	// 最长拦截序列的最后一个导弹为i时的最大拦截个数
	private int[] result1;
	// 记录拦截序列最后一个导弹为i时的最少系统配置数
	private int[] result2;

	public int[] getData() {
		return data;
	}

	public void setData(int[] data) {
		this.data = data;
	}

	public int[] getResult1() {
		return result1;
	}

	public void setResult1(int[] result1) {
		this.result1 = result1;
	}

	public int[] getResult2() {
		return result2;
	}

	public void setResult2(int[] result2) {
		this.result2 = result2;
	}

	/**
	 * 初始化
	 * 
	 * @param data
	 *            导弹高度数组
	 */
	public void initial(int[] data) {
		this.data = data;
		result1 = new int[data.length];
		result2 = new int[data.length];

		// 以第1个为最后一个拦截导弹时的最长拦截序列的长度
		for (int i = 0; i < data.length; i++) {
			result1[i] = 1;
			result2[i] = 1;
		}
	}

	/**
	 * 计算一套系统拦截导弹的最大数目（即最长降序子序列）
	 */
	public void computeMaxNum() {
		int maxNum1 = 0;
		int maxNum2 = 0;
		// i表示结束，j表示开始（从第j个开始，最后一个拦截的为第i个的最大拦截数）之后取最大即可
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < i; j++) {
				// 如果此时结束时最后拦截的导弹i比上一次的最后一个导弹j的高度低，则在上一次的基础上加1进行拦截
				// 选择是否拦截
				if (data[i] <= data[j]) {
					result1[i] = Math.max(result1[i],result1[j] + 1);
				} else {
					// 如果当前导弹的高度更高，则系统数+1
					result2[i] = Math.max(result2[i], result2[j] + 1);
				}
			}
			
			maxNum1 = Math.max(maxNum1, result1[i]);
			maxNum2 = Math.max(maxNum2, result2[i]);
		}
		
		System.out.println("-----------一套系统最多可拦截：" + maxNum1 + "----------");
		System.out.println("-----------全部拦截最少需要：" + maxNum2 + "----------");
	}
}
