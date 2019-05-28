package ca.six.jold.bits;

class Bit01 {
	public static void main(String[] args) {

	}

	public static void isOdd(int n){
		// 判断奇偶
		if(n % 2 == 0) {/*奇数*/}

		int after = n & 1; //1其实是000..01, 所以after值就是只有n的最后一位留了下来
		if(after == 1) {/*奇数*/}

	}
}
