package ast;

public class QIntVal extends QVal {

    public long value;

    public QIntVal(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Long.toString(value);
    }

}
