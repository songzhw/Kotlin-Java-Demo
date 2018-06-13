# 1. swap values + 格式化输出
a = 20
b = 33
a, b = b, a
print("%d, %d" % (a, b))  # => 33, 20
print("a = {v1}, b = {v2}".format(v1=a, v2=b))  # 比用"%"可读性更好, 特别是参数很长时. 本句更pythonic

# 2. 三元操作符
# c = a > 20 ? 10 : 11  # 错误的写法
c = 40 if a >= 40 else a
print("c = ", c)  # => 33

# 3.没有switch-case
if a == 10:
    print("a == 10")
elif a == 20:
    print("a == 20")
else:
    print("a != 10 and a != 20")  # => a != 10 and a != 20
