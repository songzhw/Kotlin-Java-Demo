package ca.six.demo.design;

public class ResponsibilityChain03 {

}

interface ILeader{
    ILeader higher = null;
    boolean approve(int sickLeaveDays);
    default void setBoss(ILeader boss){
        higher = boss;
    }
}

class Leader implements ILeader{
    @Override
    public boolean approve(int sickLeaveDays) {
        if(sickLeaveDays <= 1){
            return true;
        } else {

        }
        return false;
    }
}