package ast;

import java.util.concurrent.atomic.AtomicBoolean;

public class QIntVal extends QVal {

    public long value;
    public AtomicBoolean isLocked;

    public QIntVal(long value) {
        this.value = value;
        isLocked = new AtomicBoolean(); //initialized to false
    }

    @Override
    public String toString() {
        return Long.toString(value);
    }

}
