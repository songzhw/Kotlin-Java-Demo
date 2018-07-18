package bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PropertyChangeDemo {
    public static void main(String[] args) {
        Bean obj = new Bean();
        obj.addPropertyChangeListener(ev ->
                System.out.println("szw " + ev.getPropertyName() + " ; "
                        + ev.getOldValue() + " - " + ev.getNewValue()));
        obj.setValue("newValue");
    }
}

class Bean {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // ========== property change ==========
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.support.removePropertyChangeListener(listener);
    }


}
