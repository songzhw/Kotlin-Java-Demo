package ca.six.demo.statemac;

public interface IABStateMachine {
    void process(SmStringReader reader) throws SmStringReader.EOFException;
}