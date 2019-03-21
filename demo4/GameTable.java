package demo4;

/**
 * 解题思路：
 * 将比赛日程表设计成一个n行和n-1列的表，第i行，第j列分别填入第i个选手在第j天所遇到的选手
 * 栗子：
 * 4个选手
 * ---------
 * |1|2|3|4|
 * ---------
 * |2|1|4|3|
 * ---------
 * |3|4|1|2|
 * ---------
 * |4|3|2|1|
 * ---------
 * 分治思想：将所有区域看成四块，区域1：(0,i) 区域2：(0,r+i) 区域3：(r,i) 区域4：(r,r+i)
 * 递归执行的是区域1拷贝到区域4，区域2拷贝到区域3
 * ---------
 * | 1 | 2 |
 * ---------
 * | 3 | 4 |
 * ---------
 * 
 * @author StarryHu
 *
 */
public class GameTable {
	// 2^k个选手
	private int k;
	// 赛场总人数
	private int n = 1;
	// 安排的日程表
	private int[][] table;

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int[][] getTable() {
		return table;
	}

	public void setTable(int[][] table) {
		this.table = table;
	}

	/**
	 * 生成赛程表
	 */
	public void tableGenerate() {
		// 根据得到的的k获取总人数
		for (int i = 0; i < k; i++) {
			n = n * 2;
		}
		// 初始化赛程表二维数组
		table = new int[n][n];
		// 对第一行进行初始化赋值,第一行排1-n
		for (int i = 0; i < n; i++) {
			table[0][i] = i + 1;
		}

		// r为平移数,每次增加两倍(总共执行k-1次,n=2^k),即进行对称赋值的依据
		// 进行对应区域的赋值
		for (int r = 1; r < n; r *= 2) {
			for (int i = 0; i < n; i += 2 * r) {
				// 从(0,i)复制到(r,r+i),其中行列在平移r的范围内变化
				copy(r, r + i, 0, i, r);
				// 从(0,r+i)复制到(r,i),其中行列在平移r的范围内变化
				copy(r, i, 0, r + i, r);
			}
		}
		
		show();
	}

	
	
	/**
	 * 在行列都平移r的有限范围内
	 * 将对应区域数复制过去
	 * 
	 * @param tox
	 *            目标x
	 * @param toy
	 *            目标y
	 * @param fromx
	 *            起始x
	 * @param fromy
	 *            起始y
	 * @param r
	 *            共平移r行r列
	 */
	private void copy(int tox, int toy, int fromx, int fromy, int r) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < r; j++) {
				table[tox + i][toy + j] = table[fromx + i][fromy + j];
			}
		}
	}
	
	
	/**
	 * 展示赛程表
	 */
	private void show() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
	}
}
