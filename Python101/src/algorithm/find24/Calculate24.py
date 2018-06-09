# 有4张扑克, 计算出来结果是24
from algorithm.find24.Node import TreeNode


def calculate24(ary):
    pass


"""
:return Array<TreeNode>
每个TreeNode都是一个树的根结点. 
所以这其实是返回一系列树
"""


def findAllTrees(ary):
    length = len(ary)

    if length == 1:
        node = TreeNode(ary[0])
        return [node]  # 因为后面要遍历, 所以统一是返回一个list

    trees = []
    for i in range(1, length):
        leftArray = ary[:i]
        rightArray = ary[i:]
        leftTrees = findAllTrees(leftArray)
        rightTrees = findAllTrees(rightArray)
        for left in leftTrees:
            for right in rightTrees:
                assembled = buildTrees(left, right)
                trees.extend(assembled)

    return trees


def buildTrees(left, right):
    trees = []
    trees.append(TreeNode(operator="+", left=left, right=right))
    trees.append(TreeNode(operator="-", left=left, right=right))
    trees.append(TreeNode(operator="*", left=left, right=right))
    trees.append(TreeNode(operator="/", left=left, right=right))  # TODO 分母不能为0
    return trees


if __name__ == '__main__':
    ary = [4, 10, 2, 5]
    calculate24(ary)

    # ========= ========= ========= =========
    trees = findAllTrees(ary)
    for item in trees:
        expression = "{} {} {}".format(item.left.num, item.operator, item.right.num)
        result = eval(expression)
        if result == 24 or result == 24.0: # math.isclose()也行
            print(expression)

    # ========= ========= ========= =========
    n1 = TreeNode(4)
    n2 = TreeNode(10)
    n3 = TreeNode(2)
    n4 = TreeNode(5)
    n12 = TreeNode(operator="+", left=n1, right=n2)
    n34 = TreeNode(operator="*", left=n3, right=n4)
    root = TreeNode(operator="+", left=n12, right=n34)
    print("(1) : root = " + str(root.num))

    # ========= ========= ========= =========

    n1 = TreeNode(5)
    n2 = TreeNode(2)
    n3 = TreeNode(10)
    n4 = TreeNode(5)
    n23 = TreeNode(operator="/", left=n2, right=n3)
    n34 = TreeNode(operator="-", left=n1, right=n23)
    root = TreeNode(operator="*", left=n34, right=n4)
    print("(2) : root = " + str(root.num))
