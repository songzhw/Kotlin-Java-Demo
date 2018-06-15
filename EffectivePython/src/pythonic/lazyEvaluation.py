from itertools import islice


def fib():
    x, y = 1, 1
    while True:
        yield x
        x, y = y, x + y
        print("x = " + str(x) + "; y = " + str(y))


if __name__ == '__main__':
    list(islice(fib(), 8))
