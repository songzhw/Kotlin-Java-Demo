# 有4张扑克, 计算出来结果是24
from algorithm.find24.Node import TreeNode


def calculate24(ary):
    pass


if __name__ == '__main__':
    calculate24([4, 10, 2, 5])

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
    print("(2) : root = " + str(int(root.num)))
