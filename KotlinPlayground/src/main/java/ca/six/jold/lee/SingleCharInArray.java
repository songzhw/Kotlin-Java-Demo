package ca.six.jold.lee;

// 从数组中找出唯一一个不重复的数字来 (重复的数字, 都是重复2次, 4次,... 即偶数次)
class SingleCharInArray {
  public static void main(String[] args) {
  // 好处是: 时间复杂度O(n), 空间复杂度O(1)
  // 坏处是: 只能处理重复次数为偶数的情形
    int[] ary = new int[]{2, 3, 2, 3, 4};
    int ret = ary[0]; //从0号开始, 所以下面for循环就是从1开始. 总之就是所有数字全异或一下
    for (int i = 1; i < ary.length; i++) {
      ret ^= ary[i];  // ^是异或. 即"相同为0, 不同为1"
    }
    System.out.println("the result = " + ret); //=> 4

    /*
    解析: 因为相同为0, 所以那些重复的(偶数次重复)异或之后, 肯定全是为0
    这样就成了0与那个单独的数再异或了, 如0与4(100), 就成了100; 0与3(11), 就成了11
    这样就成了: 全部异或一次后, 结果就是那个单独出来不重复的数字
     */
  }

}
