package trial2;

import java.util.Stack;

public class LongComSubsequ {
	// 记录此时的最长公共子序列长度
	private int[][] recordLength;
	// 记录位置来源
	private PositionEnum[][] position;
	// 第一个子串的分割数组
	private char[] dataA;
	// 第二个子串的分割数组
	private char[] dataB;
	
	
	public int[][] getRecordLength() {
		return recordLength;
	}


	public void setRecordLength(int[][] recordLength) {
		this.recordLength = recordLength;
	}


	public PositionEnum[][] getPosition() {
		return position;
	}


	public void setPosition(PositionEnum[][] position) {
		this.position = position;
	}


	public char[] getDataA() {
		return dataA;
	}


	public void setDataA(char[] dataA) {
		this.dataA = dataA;
	}


	public char[] getDataB() {
		return dataB;
	}


	public void setDataB(char[] dataB) {
		this.dataB = dataB;
	}


	
	/**
	 * 进行初始化
	 * @param dataA 第一个串的字符数组
	 * @param dataB 第二个串的字符数组
	 */
	public void initial(char[] dataA,char[] dataB) {
		this.dataA = dataA;
		this.dataB = dataB;
		
		// 多一位用于存储0个数时的情况，便于之后根据此累计变化
		int lengthA = dataA.length+1;
		int lengthB = dataB.length+1;
		
		recordLength = new int[lengthA][lengthB];
		position = new PositionEnum[lengthA-1][lengthB-1];
	}
	
	public void findLongestComSubsequ() {
		// 初始化某子串长度为0时的情况，公共子串为0长度
		// 即在i=0||j=0时置recordLength[i][j]数为0
		// 由于java能够初始化数据成员，所以可省去该步骤
		
		// 判断串的各个位置字符相等情况
		for (int i = 1; i < dataA.length+1; i++) {
			for (int j = 1; j < dataB.length+1; j++) {
				// 判断此时的字符是否相等
				// 相等则在原来的基础上进行长度加一,同时置此时的位置为左上
				if (dataA[i-1] == dataB[j-1]) {
					recordLength[i][j] = recordLength[i-1][j-1] + 1;
					position[i-1][j-1] = PositionEnum.LEFT_UP;
				}else {
					// 如果两个字符不相等，则取去掉两个字符的最大公共子序列长度
					// 此处设计为以向上为默认标准
					if (recordLength[i-1][j] >= recordLength[i][j-1]) {
						recordLength[i][j] = recordLength[i-1][j];
						position[i-1][j-1] = PositionEnum.UP;
					}else {
						recordLength[i][j] = recordLength[i][j-1];
						position[i-1][j-1] = PositionEnum.LEFT;
					}
				}
			}
		}
		
		showRecord();
		showCommonSubSequ();
	}
	
	/**
	 * 展示记录长度的数组，并显示最长公共子串的长度
	 * 对recordLength数组显示，注意长度在data的长度上加一
	 */
	private void showRecord() {
		for (int i = 0; i < dataA.length+1; i++) {
			for (int j = 0; j < dataB.length+1; j++) {
				System.out.print(recordLength[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------最大长度为" + recordLength[dataA.length][dataB.length] + "--------");
	}
	
	
	/**
	 * 对最长公共子序列的显示,从最后一个进行逆推
	 * 对position数组进行判断，注意长度即为data的长度
	 */
	private void showCommonSubSequ() {
		// 存储相同字符
		Stack<Character> stack = new Stack<>();
		int i = dataA.length - 1;
		int j = dataB.length - 1;
		
		// 在判断的字符没有达到两端时进行从后递推判断
		while(i >= 0 && j >= 0) {
			// 如果是从左上方继承而来+1的数，则该位置对应的字符为相同字符
			// 压栈，便于之后显示
			// 否则调整i，j位置
			switch (position[i][j]) {
			case LEFT_UP:
				stack.push(dataA[i]);
				i-=1;
				j-=1;
				break;
			case LEFT:
				j-=1;
				break;
			case UP:
				i-=1;
				break;
			}
		}
		
		// 显示栈的字符
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
}
