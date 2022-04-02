package ast;

import java.util.HashMap;

public class NilExpr extends Expr {

    public NilExpr(Location loc) {
        super(loc);
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    Long eval(HashMap<String, Long> env) {
        return null;
    }
}
