package ca.six.demo.design;

public class VisitorPattern {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.accept(new ComputerVisitorImpl());
    }
}

interface ComputerPart {
    void accept(ComputerVisitor visitor);
}

class Mouse implements ComputerPart{
    @Override
    public void accept(ComputerVisitor visitor) {
        visitor.visit(this);
    }
}

class Keyboard implements ComputerPart{
    @Override
    public void accept(ComputerVisitor visitor) {
        visitor.visit(this);
    }
}

class Monitor implements ComputerPart{
    @Override
    public void accept(ComputerVisitor visitor) {
        visitor.visit(this);
    }
}

class Computer implements ComputerPart{
    ComputerPart[] parts;

    Computer(){
        parts = new ComputerPart[]{new Mouse(), new Keyboard(), new Monitor()};
    }

    @Override
    public void accept(ComputerVisitor visitor) {
        for(ComputerPart part : parts) {
            part.accept(visitor);
        }
    }
}

interface ComputerVisitor {
    void visit(Mouse mouse);
    void visit(Keyboard keyboard);
    void visit(Monitor monitor);
}

class ComputerVisitorImpl implements ComputerVisitor {

    @Override
    public void visit(Mouse mouse) {
        System.out.println("visitor visit mouse");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("visitor visit keyboard");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("visitor visit monitor");
    }
}