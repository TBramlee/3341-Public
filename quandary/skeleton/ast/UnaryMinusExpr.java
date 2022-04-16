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
    QVal eval(HashMap<String, QVal> env) {
        long val = ((QIntVal)expr.eval(env)).value;
        return new QIntVal(-val);
        //return -(long)expr.eval(env);
    }

}
