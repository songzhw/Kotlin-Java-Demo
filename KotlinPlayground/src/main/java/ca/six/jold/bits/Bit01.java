package ca.six.jold.bits;

class Bit01 {
	public static void main(String[] args) {
		swap1(3, 7);
		swap2(9, 4);
	}

	public static void isOdd(int n) {
		// 判断奇偶
		if (n % 2 == 0) {/*奇数*/}

		int after = n & 1; //1其实是000..01, 所以after值就是只有n的最后一位留了下来
		if (after == 1) {/*奇数*/}
	}

	// 要求不借用额外空间
	public static void swap1(int x, int y) {
		x = x - y; //10, 4 -> 6, 4
		y = x + y; //=> 6, 10
		x = y - x; //=> 4, 10
		System.out.println("swap01 : x = " + x + " ; y = " + y);
	}

	// 要求不借用额外空间 (异或, xor, ^ : 相同为0, 不同为1)
	public static void swap2(int x, int y) {
		x = x ^ y;  //// 其实这个值是多少无所谓, 主要就是存起来. 如x=4, 那就存起4^y后, 后面再用^y, 就成了4了
		y = x ^ y;
		x = x ^ y;
		System.out.println("swap02 : x = " + x + " ; y = " + y);
	}
}
