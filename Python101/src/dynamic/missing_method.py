
class Human:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def eat(self):
        print("I am eating ...")

    def __getattr__(self, item):  #调用type(item)也总是<class 'str'>. 因为item就是属性的名字, 是个String类型
        print(item + " is called. But it does not exist")

        return 'default attr'


if __name__ == '__main__':
    man = Human("bing", 11)
    print(man.name)  # => bing
    print(man.eat)  # => <bound method Human.eat of <__main__.Human object at 0x10a976710>>

    print(man.weight)
    #=> weight is called. But it does not exist.
    #=> <class 'str'>
    #=>  default attr

'''
    man.drink()
    #=> drink is called. But it does not exist
    #=> Crash: 'str' object is not callable. (因为你返回的"default attr"是一个string, 它不是函数, is not callable)
'''