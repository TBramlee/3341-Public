package ast;

public class QObj {

    public QVal left;
    public QVal right;

    public QObj(QVal left, QVal right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " . " + right.toString() + ")";
    }

}
