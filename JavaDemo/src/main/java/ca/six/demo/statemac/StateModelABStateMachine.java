package ca.six.demo.statemac;

// 要求检查一串string是不是 "a[b]*" 的形式. 即正则表达式的检查
public class StateModelABStateMachine implements IABStateMachine {
    State state = State.Init;
    StringBuilder sb = new StringBuilder();

    @Override
    public void process(SmStringReader reader) {
        state.process(this, reader);
    }

    enum State {
        Init {
            @Override
            public void process(StateModelABStateMachine machine, SmStringReader reader) {
                char ch = reader.read();
                if (ch == 'a') {
                    machine.state = AfterA;
                    machine.sb.append(ch);
                } else {
                    throw new RuntimeException("The string does not start with 'a' ");
                }
            }
        },

        Accept {
            @Override
            public void process(StateModelABStateMachine machine, SmStringReader reader) {
                System.out.println("find " + machine.sb.toString());
                machine.sb = new StringBuilder();
                machine.state = Init;
                reader.unread();
            }
        },

        AfterA {
            @Override
            public void process(StateModelABStateMachine machine, SmStringReader reader) {
                char ch = reader.read();
                if (ch == 'b') {
                    machine.sb.append(ch);
                    machine.state = AfterB;
                } else {
                    machine.state = Accept;
                }
            }
        },

        AfterB {
            @Override
            public void process(StateModelABStateMachine machine, SmStringReader reader) {
                char ch = reader.read();
                if (ch == 'b') {
                    machine.sb.append(ch);
                    machine.state = AfterB;
                } else {
                    machine.state = Accept;
                }
            }
        };

        public void process(StateModelABStateMachine machine, SmStringReader reader) {
        }
    }

    public static void main(String[] args) {
        IABStateMachine abStateMachine = new StateModelABStateMachine();
        String text = "abbbababbbaa";
        SmStringReader reader = new SmStringReader(text);
        while (true) {
            abStateMachine.process(reader);
        }
    }
}