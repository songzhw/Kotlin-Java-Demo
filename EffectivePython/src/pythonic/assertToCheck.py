# assert expression1[, expression2]
# expressionN应该是返回True, False的表达式

# 用assert来发现问题.
# 但它应该放到用户正常情况到达不了的代码处, 不然会让你的程序可能就会crash
# 所以assert不应用于测试用户输入

# 用assert是有一定性能影响的.
# 数据越界, 类型不匹配这些能处理的就不要用assert了

def getValue(isSunHot):
    if not isinstance(isSunHot, bool):
        assert isinstance(isSunHot, bool)
        print("getValue(False)")
    print("getValue(" + str(isSunHot) + ")")


if __name__ == '__main__':
    getValue(True)

    getValue(False)

    getValue(23)
