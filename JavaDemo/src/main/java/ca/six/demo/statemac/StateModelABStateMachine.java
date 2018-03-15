package ca.six.demo.statemac;

public class StateModelABStateMachine implements IABStateMachine {
    State state = State.Init;
    StringBuilder accum = new StringBuilder();

    enum State {
        Init {
            @Override
            public void process(StateModelABStateMachine stateModelABStateMachine, SmStringReader reader) throws SmStringReader.EOFException {
                char ch = reader.read();
                if (ch == 'a') {
                    stateModelABStateMachine.state = AfterA;
                    stateModelABStateMachine.accum.append(ch);
                }
            }
        },

        Accept {
            @Override
            public void process(StateModelABStateMachine stateModelABStateMachine, SmStringReader reader) throws SmStringReader.EOFException {
                System.out.println("find " + stateModelABStateMachine.accum.toString());
                stateModelABStateMachine.accum = new StringBuilder();
                stateModelABStateMachine.state = Init;
                reader.unread();
            }
        },

        AfterA {
            @Override
            public void process(StateModelABStateMachine stateModelABStateMachine, SmStringReader reader) throws SmStringReader.EOFException {
                char ch = reader.read();
                if (ch == 'b') {
                    stateModelABStateMachine.accum.append(ch);
                    stateModelABStateMachine.state = AfterB;
                } else {
                    stateModelABStateMachine.state = Accept;
                }
            }
        },

        AfterB {
            @Override
            public void process(StateModelABStateMachine stateModelABStateMachine, SmStringReader reader) throws SmStringReader.EOFException {
                char ch = reader.read();
                if (ch == 'b') {
                    stateModelABStateMachine.accum.append(ch);
                    stateModelABStateMachine.state = AfterB;
                } else {
                    stateModelABStateMachine.state = Accept;
                }
            }
        };

        public void process(StateModelABStateMachine stateModelABStateMachine, SmStringReader reader) throws SmStringReader.EOFException {
        }
    }

    @Override
    public void process(SmStringReader reader) throws SmStringReader.EOFException {
        state.process(this, reader);
    }

    public static void main(String[] args) {
        IABStateMachine abStateMachine = new StateModelABStateMachine();
        String text = "abbbababbbaa";
        SmStringReader reader = new SmStringReader(text);
        try {
            while (true) {
                abStateMachine.process(reader);
            }
        } catch (SmStringReader.EOFException e) {
        }
    }
}