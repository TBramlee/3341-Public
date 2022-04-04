package ast;

public class QRefVal extends QVal {

    QObj value;

    public QRefVal(QObj value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
