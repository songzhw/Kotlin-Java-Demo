# 有4张扑克, 计算出来结果是24
from others.Node import Node


def calculate24(array):
    treelist = buildAllTrees(array)
    for tree in treelist:
        if tree.result == 24:
            expression = getExpression(tree)
            print("{} - {}").format(tree, expression)

def getExpression(tree):
    expression = "{} {} {}".format(tree.left.result, tree.operator, tree.right.result)
    return expression

def buildAllTrees(array):
    length = len(array)
    if length == 1:
        tree = Node(array[0])
        return [tree]

    trees = []
    for i in range(1, length):
        leftItems = array[:i]
        rightItems = array[i:]
        leftTrees = buildAllTrees(leftItems)
        rightTrees = buildAllTrees(rightItems)

        for treeLeft in leftTrees:
            for treeRight in rightTrees:
                result = buildTree(treeLeft, treeRight)
                trees.extend(result)

    return trees


'''
有了左右子树, 那组成的树也有几种可能
因为根结点可能是+, -, *, /
'''
def buildTree(leftTree, rightTree):
    ret = []
    ret.append(Node().setExpression(leftTree, rightTree, "+"))
    ret.append(Node().setExpression(leftTree, rightTree, "-"))
    ret.append(Node().setExpression(leftTree, rightTree, "*"))
    if rightTree.result != 0:  #除法有点特殊, 因为分母不能为0
        ret.append(Node().setExpression(leftTree, rightTree, "/"))
    return ret


