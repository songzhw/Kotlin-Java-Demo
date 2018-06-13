# 读取完后再关闭文件流
with open('files.py', 'r', encoding="UTF-8") as file:
    content = file.read()
    print("szw file: ", content)  # => 打印出本文件的所有内容

# crash: 'gbk' codec can't decode byte 0xad in position
# when using "with open('files.py', 'r') as file:"