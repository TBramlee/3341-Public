package ast;

import java.util.HashMap;

public class ConstExpr extends Expr {

    final Long value;

    public ConstExpr(long value, Location loc) {
        super(loc);
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    Long eval(HashMap<String, Long> env) {
        return value;
    }
}
