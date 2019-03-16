volatile
AtmoicInteger
CAS (Compare and Set)

CasScenario01 : 使用普通做法, 使用AtomicInteger, 看下10000万个线程同时操作一个数的++, 会是什么样的结果
CasScenario02 : 使用volatile呢? -- 不行
CasScenario03 : 使用synchronized呢? -- 行, 但代码高
MyAtomicInt : 自己仿AtomicInteger写一个类似的类, 但是其中的CAS其实是native代码 (code in C), 故没实现