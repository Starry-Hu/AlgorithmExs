package trial4;

/**
 * 贪心算法的物品类
 * 
 * @author StarryHu
 *
 */
public class Item {
	private float value;
	private float size;
	private float singleValue;
	// 原物品序列组的位置
	private int index;
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public float getSize() {
		return size;
	}
	public void setSize(float size) {
		this.size = size;
	}
	public float getSingleValue() {
		return singleValue;
	}
	public void setSingleValue(float singleValue) {
		this.singleValue = singleValue;
	}
	
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Item() {
		super();
	}
	// 初始化方法
	public Item(float value, float size,int index) {
		super();
		this.value = value;
		this.size = size;
		this.index = index;
		singleValue = value/size;
	}
	@Override
	public String toString() {
		return "[" + (index+1) + "号物品 " + ", 总价值：" + value + ", 体积大小：" + size + ", 单价：" + singleValue + "]";
	}
	
	
}
