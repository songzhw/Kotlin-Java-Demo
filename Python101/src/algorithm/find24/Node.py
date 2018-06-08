class TreeNode:
    def __init__(self, num=None, operator=None, left=None, right=None):
        self.operator = operator
        self.left = left
        self.right = right

        if num is None:
            expression = "{} {} {}".format(self.left.num, self.operator, self.right.num)  # 2 * 3
            self.num = eval(expression)  # 6
        else:
            self.num = num


    def __repr__(self):
        return self.num if self.operator is None else self.operator


class BinaryTree:
    def __init__(self):
        self.node = TreeNode()
        self.left = None
        self.right = None

    # def __repr__(self):
    #     if self.key in ['+', '-', '*', '/']:
    #         return '<Node operator="{}">'.format(self.operator)
    #     else:
    #         return '<Node value="{}">'.format(self.result)

    def setExpression(self, left, right, operator):
        self.left = left
        self.rigth = right
        self.node.operator = operator

        expression = "{} {} {}".format(left.node.num, operator, right.node.num)  # 2 * 3
        self.node.num = eval(expression)  # 6
        return self
