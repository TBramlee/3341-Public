package ast;

import java.util.concurrent.atomic.AtomicBoolean;

public class QObj {

    public QVal left;
    public QVal right;
    public AtomicBoolean isLocked;

    public QObj(QVal left, QVal right) {
        this.left = left;
        this.right = right;
        this.isLocked = new AtomicBoolean();
    }

    @Override
    public String toString() {
        String leftString = left.toString();
        String rightString = right.toString();
        return "(" + leftString + " . " + rightString + ")";
    }

}
