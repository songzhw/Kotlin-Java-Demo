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

from pythonic.utils import const
const.NAME = "szw"
const.ERROR_CODE = 40