package demo6;

public class Hanoi {
	
	/**
	 * 圆盘移动
	 * @param n 盘子编号
	 * @param from 起始柱子编号
	 * @param to 目的柱子编号
	 */
	public void move(int n ,char from,char to) {
		System.out.println("------将盘子" + n + "从" + from + "移到" + to);
	}
	
	/**
	 * 汉诺递归法
	 * @param n 盘子总数
	 * @param from 起始柱子编号
	 * @param depend 依赖柱子编号
	 * @param to 目标柱子编号
	 */
	public void hanNuo(int n ,char from ,char depend ,char to) {
		// 一个盘子时直接从起始移动过去
		if (n == 1) {
			move(1, from, to);
		}else {
			// 其他柱子从起始柱（当前柱）到达依赖柱
 			hanNuo(n-1, from, to, depend);
 			// 其他柱子让出来之后，第n个柱子过去
			move(n, from, to);
			// 其他柱子从依赖柱（当前柱）到达目标柱
			hanNuo(n-1, depend, from, to);
		}
	}
}
