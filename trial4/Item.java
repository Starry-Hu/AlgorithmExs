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
	
	public Item() {
		super();
	}
	// 初始化方法
	public Item(float value, float size) {
		super();
		this.value = value;
		this.size = size;
		singleValue = value/size;
	}
	@Override
	public String toString() {
		return "Item [value=" + value + ", size=" + size + ", singleValue=" + singleValue + "]";
	}
	
	
}
