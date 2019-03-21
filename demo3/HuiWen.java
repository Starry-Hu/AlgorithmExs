package demo3;

/**
 * 回文串的判断
 * 
 * @author StarryHu
 *
 */
public class HuiWen {

	/**
	 * 采用递归的方法判定
	 * @param str
	 * @return
	 */
	public boolean check1(String str) {
		int length = str.length();

		if (length == 1 || length == 0) {
			System.out.println("yes");
			return true;
		} else if (str.charAt(0) != str.charAt(length - 1)) {
			System.out.println("no");
			return false;
		} else {
			return check1(str.substring(1, length - 1));
			// 切割两端，将子串递归调用
		}
	}

	/**
	 * 将字符串逆置，然后比较逆置字符串是否与原串相等
	 * 
	 * @param string
	 */
	public void check2(String string) {
		StringBuffer string2 = new StringBuffer(string);
		// 逆置存储
		string2.reverse();
		// 转为string类型
		String reverseStr = string2.toString();

		if (reverseStr.equals(string)) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}
	
	/**
	 * 将字符串逆置存储，挨个判断两个串的对应位置上的每个字符是否相等
	 * 
	 * @param string
	 */
	public void check3(String string) {
		StringBuffer string2 = new StringBuffer(string);
		// 逆置存储
		string2.reverse();

		for (int i = 0; i < string.length(); i++) {
			// 挨个比较对应字符
			if (string.charAt(i) != string2.charAt(i)) {
				System.out.println("no");
				return;
			}
		}
		System.out.println("yes");
	}

	

}
