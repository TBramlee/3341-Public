package ast;

import java.util.HashMap;

public class ConcurrentBinaryExpr extends Expr {

    final BinaryExpr expr;

    public ConcurrentBinaryExpr(BinaryExpr expr, Location loc) {
        super(loc);
        this.expr = expr;
    }

    @Override
    public String toString() {
        return expr.toString();
    }

    @Override
    QVal eval(HashMap<String, QVal> env) {
        
        return expr.eval(env);
       
    }
}
