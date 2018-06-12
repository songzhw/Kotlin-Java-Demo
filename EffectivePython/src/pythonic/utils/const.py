class _const:
    class ConstError(TypeError): pass
    class ConstCaseError(ConstError): pass
    def __setattr__(self, key, value):
        if self.__dict__.__contains__(key): # has_key()是python2.x中的方法. 3.x中用__contains__()
            raise self.ConstError("Can't change const %s" % key)
        if not key.isupper():
            raise self.ConstError("%s is not all upppercase" % key)
        self.__dict__[key] = value

import sys
sys.modules[__name__] = _const()

from src.pythonic.utils import const
const.NAME = "szw"
const.ERROR_CODE = 40

# 若不先设置, 而是直接使用const.NAME, 那就报错 "_const' object has no attribute 'NAME'
# 这时也可以考虑 __getattr__