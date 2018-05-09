package ca.six.demo.design;

public class ResponsibilityChain03 {
    public void requestForSickLeave() {
        Leader vp = new VP(null);
        Leader director = new Director(vp);
        Leader manager = new Manager(director);

        int sickDays = 5;
        manager.approve(sickDays);
    }
}

abstract class Leader {
    Leader higher;

    public Leader(Leader higher) {
        this.higher = higher;
    }

    abstract boolean approve(int sickLeaveDays);
}

class Manager extends Leader {
    public Manager(Leader higher) {
        super(higher);
    }

    @Override
    public boolean approve(int sickLeaveDays) {
        if (sickLeaveDays <= 1) {
            return true;
        } else {
            higher.approve(sickLeaveDays);
        }
        return false;
    }
}

class Director extends Leader {
    public Director(Leader higher) {
        super(higher);
    }

    @Override
    boolean approve(int sickLeaveDays) {
        if (sickLeaveDays <= 3) {
            return true;
        } else {
            higher.approve(sickLeaveDays);
        }
        return false;
    }
}

class VP extends Leader {
    public VP(Leader higher) {
        super(higher);
    }

    @Override
    boolean approve(int sickLeaveDays) {
        return true;
    }
}