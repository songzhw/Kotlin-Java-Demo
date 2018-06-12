class Node(object):
    def __init__(self, result = None):
        self.result = result
        self.left = None
        self.right = None
        self.operator = None

    def __repr__(self):
        pass

    def setExpression(self, left, right, operator):
        self.left = left
        self.rigth = right
        self.operator = operator

        expression = "{} {} {}".format(left.result, operator, right.result)
        self.result = eval(expression)
        return self

