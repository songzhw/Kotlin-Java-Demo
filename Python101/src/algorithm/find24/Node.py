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
