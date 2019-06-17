package demo12;

public class NumberGame {
	private NumberObj[] data;

	public NumberObj[] getData() {
		return data;
	}

	public void setData(NumberObj[] data) {
		this.data = data;
	}

	/**
	 * 初始化
	 * 
	 * @param data
	 */
	public void initial(NumberObj[] data) {
		this.data = data;
	}

	public void compute() {
		// 根据b（减数）进行升序排序
		for (int i = 0; i < data.length - 1; i++) {
			int temp = i;
			for (int j = i + 1; j < data.length; j++) {
				if (data[j].b < data[i].b) {
					temp = j;
				}
			}
			if (temp != i) {
				NumberObj test = data[i];
				data[i] = data[temp];
				data[temp] = test;
			}
		}
		// 循环，进行擦数
		for (int i = 0; i < data.length; i++) {
			for (int j = i + 1; j < data.length; j++) {
				data[j].a = data[j].a - data[i].b;
			}
		}
		// 求擦除数的和
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i].a;
		}
		System.out.println("最大得分：" + sum);
	}
}
