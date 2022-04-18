package ast;

import java.util.concurrent.atomic.AtomicBoolean;

public class QRefVal extends QVal {

    QObj value;
    AtomicBoolean isLocked;

    public QRefVal(QObj value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if(value == null) {
            return "nil";
        }
        return value.toString();
    }

}
