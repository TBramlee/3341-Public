package ast;
import java.util.HashMap;

public class UnaryMinusExpr extends Expr {

    final Expr expr;
    

    public UnaryMinusExpr(Expr expr, Location loc) {
        super(loc);
        this.expr = expr;
    }

    @Override
    public String toString() {
        return "(" + simpleString() + ")";
    }

    public String simpleString() {
       
        return "-" + expr;
    }

    @Override
    Long eval(HashMap<String, Long> env) {
        return -(long)expr.eval(env);
    }

}
