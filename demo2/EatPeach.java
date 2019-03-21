package demo2;

/**
 * 猴子吃桃问题
 * 
 * @author StarryHu
 *
 */
public class EatPeach {
	
	
	/**
	 * 递归方法
	 * 求解最开始的桃子数(第一天的桃子数)
	 * @param day 第几天
	 * @param peach 该天吃之前剩余的桃子数
	 * @return
	 */
	public int compute(int day, int peach) {
		// 输出该天剩余的桃子数
		System.out.println(day + ":" + peach);

		if (day == 1) {
			return peach;
		} else {
			// 求得上一天的桃子数,同时递归
			peach = (peach + 1) * 2;
			day--;
			return compute(day, peach);
		}
	}
	
	
	/**
	 * 普通for循环
	 * 求解最开始的桃子数(第一天的桃子数)
	 * @param day 第几天
	 * @param peach 该天吃之前剩余的桃子数
	 * @return
	 */
	public int compute2(int day,int peach) {
		for (int i = day; i > 1 ; i--) {
			System.out.println(i + ":" + peach);
			peach = (peach + 1) * 2;
		}
		// 退出循环时获得总数
		System.out.println(1 + ":" + peach);
		return peach;
	}
	
	
}
