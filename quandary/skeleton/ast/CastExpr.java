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
    QVal eval(HashMap<String, QVal> env) {
        switch(type.type) {
            case Type.INT: return (QIntVal)expr.eval(env);
            case Type.REF: return (QRefVal)expr.eval(env);
            case Type.Q: return (QVal)expr.eval(env);
        }
        throw new RuntimeException("Unexpected in CastExpr.eval()");
    }
}
