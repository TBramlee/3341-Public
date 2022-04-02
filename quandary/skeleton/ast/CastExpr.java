package ast;

import java.util.HashMap;

public class CastExpr extends Expr {

    final Type type;
    final Expr expr;

    public CastExpr(Type type, Expr expr, Location loc) {
        super(loc);
        this.type = type;
        this.expr = expr;
    }

    @Override
    Long eval(HashMap<String, Long> env) {
        switch(type.type) {
            case Type.INT: return null;
            case Type.REF: return null;
            case Type.Q: return null;
        }
        throw new RuntimeException("Unexpected in CastExpr.eval()");
    }
}
