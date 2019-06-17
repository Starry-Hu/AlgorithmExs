package demo10;

import java.util.Scanner;

import javax.xml.stream.events.StartDocument;
import javax.xml.transform.Templates;

public class WaDilei {
	// 每个地窖的地雷数
	private int data[];
	// 地窖的连接情况(i号地窖能否到j号地窖)
	private int[][] links;
	// 从第i个地窖开始挖所获得的最大地雷数的动态规划结果
	private int[] result;

	public int[] getData() {
		return data;
	}

	public void setData(int[] data) {
		this.data = data;
	}

	public int[][] getLinks() {
		return links;
	}

	public void setLinks(int[][] links) {
		this.links = links;
	}

	public int[] getResult() {
		return result;
	}

	public void setResult(int[] result) {
		this.result = result;
	}

	/**
	 * 初始化地雷数组及地窖关系
	 * 
	 * @param data
	 */
	public void initial() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("--------请输入地窖个数-------");
		int n = scanner.nextInt();
		data = new int[n];
		links = new int[n][n];
		result = new int[n];

		System.out.println("--------请依次输入每个地窖的地雷个数-------");
		for (int i = 0; i < n; i++) {
			data[i] = scanner.nextInt();
		}

		System.out.println("--------请输入地窖关系（0 0为结束）-------");
		int start = scanner.nextInt();
		int end = scanner.nextInt();
		while (start != 0) {
			// 当输入不为0 0时，使两个地窖连接
			links[start - 1][end - 1] = 1;
			start = scanner.nextInt();
			end = scanner.nextInt();
		}
		scanner.close();
	}

	public void compute() {
		int n = data.length;
		// 最后一个的赋值（也可以将data值全部赋过去）
		result[n - 1] = data[n - 1];

		// 从后往前推,(最开始第i个地窖的值认为不放入result[i]中,通过与后边的result[j]+data[i]组合得到全新的值)
		for (int i = n - 2; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				// i号能到j号
				if (links[i][j] == 1) {
					// 如果前地窖i现能挖到的最大地雷数 < 后地窖j能挖到的最大地雷数+前地窖的地雷数，则进行新赋值
					result[i] = Math.max(result[i], result[j] + data[i]);
				}
			}
		}
		showResult();
	}

	private void showResult() {
		int maxNum = 0;
		int start = 0;
		for (int i = 0; i < result.length; i++) {
			if (result[i] > maxNum) {
				maxNum = result[i];
				start = i;
			}
		}
		System.out.println("---------最大地雷数：" + maxNum + "---------");
		System.out.println("---------所选路径：---------");
		
		// 显示具体的路径
		int temp = start;
		int C = maxNum - data[temp];
		System.out.print(temp+1 + " ");

		while (C > 0) {
			// 遍历与当前temp相连的点，找到下一个满足条件的（即减去当前temp的地雷数之后剩下的最大值为之后子情况的最大值）
			for (int i = 0; i < result.length; i++) {
				if (links[temp][i] == 1 && C == result[i]) {
					temp = i;
					System.out.print(temp+1 + " ");
					C -= data[temp];
					break;
				}
			}
		}
	}
}
