package demo9;

/**
 * 最长非递增序列
 * 具体应用：导弹拦截
 * @author StarryHu
 *
 */
public class MaxNoIncreaseSequ2 {
	// 记录导弹的高度
	private int[] data;
	// 记录从第i个导弹开始拦截所能拦截的导弹个数
	private int[] result;
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
	 * @param data 导弹高度数组
	 */
	public void initial(int [] data) {
		this.data = data;
		result = new int[data.length];
	}
	
	/**
	 * 计算一套系统拦截导弹的最大数目（即最长降序子序列），由于是最长最大，所以能拦截的一律拦截
	 */
	public void computeMaxNum() {
		// 计算从第i+1个导弹开始拦截的最大数目值
		for (int i = 0; i < data.length; i++) {
			// 从第i+1个导弹开始拦截，并选其值作为最大高度初始值,拦截数加一
			int maxHeight = data[i];
			result[i]++;
			
			for (int j = i+1; j < data.length; j++) {
				// 如果满足要求则拦截
				if (data[j] <= maxHeight) {
					maxHeight = data[j];
					result[i] ++ ;
				}
			}
		}
		
		int maxStart = 0;
		for (int i = 1; i < result.length; i++) {
			if (result[maxStart] < result[i]) {
				maxStart = i;
			}
		}
		System.out.println("-----------开始拦截的导弹高度" + data[maxStart] + "-----------");
		System.out.println("-----------最大拦截数：" + result[maxStart] + "-----------");
	}
}
