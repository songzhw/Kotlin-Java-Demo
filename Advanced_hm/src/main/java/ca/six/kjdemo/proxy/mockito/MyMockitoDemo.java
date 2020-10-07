package ca.six.kjdemo.proxy.mockito;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


interface FooOneService {
    String method1(Integer id);
}

class FooOneServiceInvocationHandler<T> implements InvocationHandler, Serializable {

    private InvocationContainerImpl invocationContainerImpl;

    ThreadSafeMockingProgress mockingProgress = new ThreadSafeMockingProgress();

    public FooOneServiceInvocationHandler(Class<T> targetInterface) {
        this.invocationContainerImpl = new InvocationContainerImpl();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) { // 如果调用方法在Object中声明，对于invoke的第一个参数就使用this
            try {
                return method.invoke(this, args);
            } catch (Throwable t) {
                throw t;
            }
        } else {
            OngoingStubbingImpl ongoingStubbing = new OngoingStubbingImpl(invocationContainerImpl);
            mockingProgress.reportOngoingStubbing(ongoingStubbing);

            StubbedInvocationMatcher stubbedInvocation = invocationContainerImpl.findAnswerFor(method);
            if (stubbedInvocation != null) { // 命中"桩"
                return stubbedInvocation.answer(method); // 返回mock数据
            } else {
                return null;
            }
        }
    }
}


class Mockito {
    static final MockitoCore MOCKITO_CORE = new MockitoCore();

    public static OngoingStubbingImpl when(Object methodCall) {
        return MOCKITO_CORE.when(methodCall);
    }
}

class MockitoCore {
    private final ThreadSafeMockingProgress mockingProgress = new ThreadSafeMockingProgress();

    public OngoingStubbingImpl when(Object methodCall) {
        return stub();
    }

    public OngoingStubbingImpl stub() {
        OngoingStubbingImpl stubbing = mockingProgress.pullOngoingStubbing();
        return stubbing;
    }
}

abstract class AbstractAnswer {
    abstract Object answer(Method method);
}

class StubbedInvocationMatcher {

    private final Queue<AbstractAnswer> answers = new ConcurrentLinkedQueue<>();

    public StubbedInvocationMatcher(AbstractAnswer answer) {
        this.answers.add(answer);
    }

    public boolean matches(Method method) {
        return true;
    }

    public Object answer(Method method) {
        AbstractAnswer a;
        synchronized (answers) {
            a = answers.size() == 1 ? answers.peek() : answers.poll();
        }
        return a.answer(method);
    }
}


class InvocationContainerImpl {
    private final LinkedList<StubbedInvocationMatcher> stubbed = new LinkedList();

    public StubbedInvocationMatcher findAnswerFor(Method method) {
        synchronized (stubbed) {
            for (StubbedInvocationMatcher s : stubbed) {
                if (s.matches(method)) {
                    return s;
                }
            }
        }
        return null;
    }

    public void addAnswer(AbstractAnswer answer) {
        synchronized (stubbed) {
            stubbed.addFirst(new StubbedInvocationMatcher(answer));
        }
    }
}

class OngoingStubbingImpl {
    private final InvocationContainerImpl invocationContainerImpl;

    public OngoingStubbingImpl(InvocationContainerImpl invocationContainerImpl) {
        this.invocationContainerImpl = invocationContainerImpl;
    }

    public OngoingStubbingImpl thenAnswer(AbstractAnswer answer) {
        invocationContainerImpl.addAnswer(answer);
        return this;
    }
}

class ThreadSafeMockingProgress {
    private static final ThreadLocal<MockingProgressImpl> mockingProgress = new ThreadLocal<>();

    static MockingProgressImpl threadSafely() {
        if (mockingProgress.get() == null) {
            mockingProgress.set(new MockingProgressImpl());
        }
        return mockingProgress.get();
    }

    public void reportOngoingStubbing(OngoingStubbingImpl iOngoingStubbing) {
        threadSafely().reportOngoingStubbing(iOngoingStubbing);
    }

    public OngoingStubbingImpl pullOngoingStubbing() {
        return threadSafely().pullOngoingStubbing();
    }
}

class MockingProgressImpl {
    OngoingStubbingImpl iOngoingStubbing;

    public void reportOngoingStubbing(OngoingStubbingImpl iOngoingStubbing) {
        this.iOngoingStubbing = iOngoingStubbing;
    }

    public OngoingStubbingImpl pullOngoingStubbing() {
        OngoingStubbingImpl temp = iOngoingStubbing;
        iOngoingStubbing = null;
        return temp;
    }
}

public class MyMockitoDemo {

    public static void main(String[] args) {
        Class interfaceClass = FooOneService.class;
        FooOneService fooOneService = (FooOneService) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass},
                new FooOneServiceInvocationHandler(interfaceClass));

        // 1、打桩；第一次调用，声明《返回值信息》
        if (false) {
            Mockito.when(fooOneService.method1(1)).thenAnswer(new AbstractAnswer() {
                @Override
                Object answer(Method method) {
                    return "this is " + method.getName();
                }
            });
        } else {
            // 创建 stub
            fooOneService.method1(1);

            // 配置 stub
            Mockito.MOCKITO_CORE.stub().thenAnswer(new AbstractAnswer() {
                @Override
                Object answer(Method method) {
                    return "this is " + method.getName();
                }
            });
        }

        // 2、调用；第二次调用，返回《配置的返回值》
        String result = fooOneService.method1(1);
        System.out.println("result = " + result);
    }

}

