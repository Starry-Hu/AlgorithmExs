package trial3;

public class KnapSack {
	// 背包的最大容量
	private int bagMaxSize;
	// 可选物品的数量
	private int itemNum;
	// 可选物品的容量大小
	private int[] itemSize;
	// 可选物品的价值
	private int[] itemValue;
	// 背包容量为j时从前i件中选取物品的最大价值和
	private int[][] valueBag;
	// 物品的选择情况(0-1)
	private int[] itemChoose;

	public int getSizeBag() {
		return bagMaxSize;
	}

	public void setSizeBag(int sizeBag) {
		this.bagMaxSize = sizeBag;
	}

	public int getItemNum() {
		return itemNum;
	}

	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}

	public int[] getItemSize() {
		return itemSize;
	}

	public void setItemSize(int[] itemSize) {
		this.itemSize = itemSize;
	}

	public int[] getItemValue() {
		return itemValue;
	}

	public void setItemValue(int[] itemValue) {
		this.itemValue = itemValue;
	}

	public int[][] getValueBag() {
		return valueBag;
	}

	public void setValueBag(int[][] valueBag) {
		this.valueBag = valueBag;
	}

	public int[] getItemChoose() {
		return itemChoose;
	}

	public void setItemChoose(int[] itemChoose) {
		this.itemChoose = itemChoose;
	}

	/**
	 * 初始化
	 * 
	 * @param bagMaxSize
	 *            背包的最大容量
	 * @param itemNum
	 *            可选物品的数目
	 * @param itemSize
	 *            可选物品的大小
	 * @param itemValue
	 *            可选物品的价值
	 */
	public void initial(int bagMaxSize,int itemNum, int[] itemSize, int[] itemValue) {
		this.bagMaxSize = bagMaxSize;
		this.itemNum = itemNum;
		this.itemSize = itemSize;
		this.itemValue = itemValue;
		itemChoose = new int[itemNum];
		// 背包容量为j时从前i件中选取物品的最大价值和
		// 此处需要注意长度+1的情况，以存储背包容量为0和取出物品为0的总价值是0的情况，便于递推
		valueBag = new int[itemNum + 1][bagMaxSize + 1];

	}

	/**
	 * 找出最优的物品放置背包问题解法 注意数组的长度，二维数组从1开始，而一维数组从0开始
	 */
	public void findOptimalBag() {
		// 初始化背包容量为0和取出物品为0时，总价值是0的情况;
		// 即i=0||j=0时置valueBag[i][j]=0
		// 由于java能够初始化数据成员，所以可省去该步骤

		// 遍历前i件物品在对应背包大小为j的情况
		for (int i = 1; i < itemNum + 1; i++) {
			for (int j = 1; j < bagMaxSize + 1; j++) {
				// 如果背包此时的容量装不下第i件物品，则总的背包价值仍为相同背包容量下从前i-1件中选择的情况
				if (j < itemSize[i - 1]) {
					valueBag[i][j] = valueBag[i - 1][j];
				} else {
					// 背包此时能够放下，选择放与不放（使得背包价值最大）
					// 不放 -- 总价值仍为相同背包容量下从前i-1件中选择的情况
					int notPutValue = valueBag[i - 1][j];
					// 放 -- 总价值为背包空出第i件的位置时从前i-1件中选择的情况 + 当前第i件的价值
					int putValue = valueBag[i - 1][j - itemSize[i - 1]] + itemValue[i - 1];
					valueBag[i][j] = Integer.max(notPutValue, putValue);
				}
			}
		}

		showValueBag();
		showItemsChoose();
	}

	/**
	 * 展示背包价值数组
	 */
	private void showValueBag() {
		for (int i = 0; i < itemNum + 1; i++) {
			for (int j = 0; j < bagMaxSize + 1; j++) {
				System.out.print(valueBag[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------背包最大价值为：" + valueBag[itemNum][bagMaxSize] + "---------");
	}
	
	/**
	 * 回溯展示选择的物品
	 */
	private void showItemsChoose() {
		int c =bagMaxSize;
		// 与valueBag二维数组比较价值(第i件选与不选 i>0 为正常意义)
		for (int i = itemNum; i > 0; i--) {
			// 如果价值选与不选都一样，则置为0
			// 否则置为1选择，同时将背包容量变小
			if (valueBag[i][c] == valueBag[i-1][c]) {
				itemChoose[i-1] = 0;
			}else {
				itemChoose[i-1] = 1;
				c-=itemSize[i-1];
			}
		}
		
		for (int i = 0; i < itemChoose.length; i++) {
			System.out.print(itemChoose[i] + " ");
		}
	}
}
