package effective

/*
 一. 考虑用 静态工厂 替代 构造函数
如: String number = String.valueOf(1, 2)
List<Integer> list = Arrays.asList(1, 2, 4)

原因有:
1. 可读性好. 如: ArrayList.withSize(3)
2. 静态工厂内里的实现还可以用cache. 不见得像constructor一样每次都是new一个对象
3. 静态工厂可以返回子类, constructor不行 -- 即可以隐去细节, 有个别场景需要这样的灵活
4. 像Builder模式一样, 静态工厂可以避免过于冗长的constructor参数表. 但又不像builder一样要写一个Builder类.

静态工厂的缺点是: 与其它static方法不容易区分开来. 这点就比不上Builder
*/

