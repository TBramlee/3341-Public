package ast;

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
    Object eval() {
        return doOperation(expr.eval());
    }

    static Object doOperation(Object value1) {
        
        return -(long)value1;
    }
}
