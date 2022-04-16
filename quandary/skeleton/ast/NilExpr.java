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
    QVal eval(HashMap<String, QVal> env) {
        return new QRefVal(null);
    }
}
