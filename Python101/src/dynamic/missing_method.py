
class People:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def eat(self):
        print("I am eating ...")

    def __getattr__(self, item):  #调用type(item)也总是<class 'str'>. 因为item就是属性的名字, 是个String类型
        print(item + " is called. But it does not exist")
        def missingMethod(*args, **kwargs):
            return 'called %s with %s and %s' % (item, args, kwargs)
        return missingMethod


if __name__ == '__main__':
    man = People("bing", 11)
    print(man.name)  # => bing
    print(man.eat)  # => <bound method Human.eat of <__main__.Human object at 0x10a976710>>

    ret = man.drink(23, id = 100, name = 's')
    print(ret)
    #=> drink is called. But it does not exist
    #=> called drink with (23,) and {'id': 100, 'name': 's'}