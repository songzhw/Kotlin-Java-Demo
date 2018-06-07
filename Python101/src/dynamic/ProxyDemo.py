class ClickListener:
    def onClick(self, view):
        print("click " + view)

class TraceProxy:
    def __init__(self, target):
        self.target = target

    # TODO 还有一个 __getattr__(). 区别是?
    def __getattribute__(self, item):
        targetObject = object.__getattribute__(self, "target")
        attr = object.__getattribute__(targetObject, item)

        def newAttr(*args, **kwargs):
            # TODO 要验证下attr是否为函数?
            print("prepare to track")
            result = attr(*args, **kwargs)
            print("done tracking")
            return result

        return newAttr


if __name__ == '__main__':
    listener = ClickListener()
    proxy = TraceProxy(listener)
    proxy.onClick("Button")
