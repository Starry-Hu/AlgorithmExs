package trial4;

public class GreedyKnapSack {
	// 背包的最大容量
	private float bagMaxSize;
	// 可选物品的数量
	private int itemNum;
	// 最大价值和
	private float valueBag;
	// 物品的选择情况(0~1)区间
	private float[] itemChoose;
	// 物品数组
	private Item[] itemList;

	public float getBagMaxSize() {
		return bagMaxSize;
	}

	public void setBagMaxSize(float bagMaxSize) {
		this.bagMaxSize = bagMaxSize;
	}

	public int getItemNum() {
		return itemNum;
	}

	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}

	public float getValueBag() {
		return valueBag;
	}

	public void setValueBag(float valueBag) {
		this.valueBag = valueBag;
	}

	public float[] getItemChoose() {
		return itemChoose;
	}

	public void setItemChoose(float[] itemChoose) {
		this.itemChoose = itemChoose;
	}

	public Item[] getItemList() {
		return itemList;
	}

	public void setItemList(Item[] itemList) {
		this.itemList = itemList;
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
	public void initial(float bagMaxSize, int itemNum, float[] itemSize, float[] itemValue) {
		this.bagMaxSize = bagMaxSize;
		this.itemNum = itemNum;
		itemChoose = new float[itemNum];

		// 物品数组,在添加的同时计算出物品的单价
		itemList = new Item[itemNum];
		for (int i = 0; i < itemNum; i++) {
			itemList[i] = new Item(itemValue[i], itemSize[i],i);
		}
		// 将物品根据单价降序排列
		for (int i = 0; i < itemNum - 1; i++) {
			for (int j = i + 1; j < itemNum; j++) {
				if (itemList[i].getSingleValue() < itemList[j].getSingleValue()) {
					Item temp = itemList[i];
					itemList[i] = itemList[j];
					itemList[j] = temp;
				}
			}
		}
	}

	/**
	 * 找出最优的物品放置背包问题解法 注意数组的长度，二维数组从1开始，而一维数组从0开始
	 */
	public void findOptimalBag() {
		// 初始化物品选择数组为0...0
		// java自动初始化，可省略

		float C = bagMaxSize;
		int i = 0;
		int index = 0;

		// 当物品还未全部遍历完且背包容量还能装下当前的物品，从大到小对物品进行选择
		// 前边的物品能选的都选1，之后第一个剩下的占据全部剩余大小
		while ((i <= itemNum) && (C >= itemList[i].getSize())) {
			// 获取原物品的序号，存储选择信息
			index = itemList[i].getIndex();
			itemChoose[index] = 1;
			valueBag += itemList[i].getValue();
			C -= itemList[i].getSize();
			
			System.out.println(itemList[i] + "选择量为" + 1);
			
			i++;
		}

		// 若是因为不能全部装下该物品而退出循环（此时还未遍历到物品列表尽头），则剩下的全部都用来装该物品
		if (i <= itemNum) {
			float leftValue = C * itemList[i].getSingleValue();
			// 获取原物品的序号，存储选择信息，当前物品剩余大小/当前物品全部大小
			index = itemList[i].getIndex();
			itemChoose[index] = C/itemList[i].getSize() ;
			valueBag += leftValue;
			C = 0;
			
			System.out.println(itemList[i] + "选择量为" + itemChoose[index]);
			i++;
		}
		
		// 按原物品存入的顺序（物品原序号）展示选择情况
		System.out.println("-------------按原顺序展示选择情况-------------");
		for (int j = 0; j < itemChoose.length; j++) {
			System.out.print(itemChoose[j] + " ");
		}
		
		System.out.println("\n-------------总价值为："+ valueBag + "-------------");
	}
	
}
