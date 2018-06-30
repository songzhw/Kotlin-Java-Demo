def generator101():
    print("before any yield")
    yield '100'
    print("between yields")
    yield 200
    print("last yield")
    yield 300.0
    print("no more yields")

if __name__ == '__main__':
    aAenerator = generator101();
    print(next(aAenerator))
    print("================")

    print(next(aAenerator))
    print("================")

    print(next(aAenerator))
    print("================")

    #Error : StopIteration
    # print(next(aAenerator))
    # print("================")