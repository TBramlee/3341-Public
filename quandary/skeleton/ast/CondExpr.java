package ast;

public class CondExpr extends Expr {

    public static final int LESSTHAN = 1;
    public static final int GREATERTHAN = 2;
    public static final int LESSTHANEQUAL = 3;
    public static final int GREATERTHANEQUAL = 4;
    public static final int EQUAL = 5;
    public static final int NOTEQUAL = 6;

    final Expr expr1;
    final int operator;
    final Expr expr2;

    public CondExpr(Expr expr1, int operator, Expr expr2, Location loc) {
        super(loc);
        this.expr1 = expr1;
        this.operator = operator;
        this.expr2 = expr2;
    }

    @Override
    public String toString() {
        return "(" + simpleString() + ")";
    }

    public String simpleString() {
        String s = null;
        switch (operator) {
            case LESSTHAN:  s = "<"; break;
            case GREATERTHAN: s = ">"; break;
            case LESSTHANEQUAL: s = "<="; break;
            case GREATERTHANEQUAL: s = ">="; break;
            case EQUAL: s = "=="; break;
            case NOTEQUAL: s = "!="; break;
        }
        return expr1 + " " + s + " " + expr2;
    }

    @Override
    Object eval() {
        boolean eval = false;
        long leftSide = (long)expr1.eval();
        long rightSide = (long)expr2.eval();

        switch (operator) {
            case LESSTHAN:  
                if (leftSide < rightSide) {
                    eval = true;
                }
                return eval;
            case GREATERTHAN: 
                if (leftSide > rightSide) {
                    eval = true;
                }
                return eval;
            case LESSTHANEQUAL: 
                if (leftSide >= rightSide) {
                    eval = true;
                }
                return eval;
            case GREATERTHANEQUAL: 
                if (leftSide <= rightSide) {
                    eval = true;
                }
                return eval;
            case EQUAL: 
                if (leftSide == rightSide) {
                    eval = true;
                }
                return eval;
            case NOTEQUAL: 
                if (leftSide != rightSide) {
                    eval = true;
                }
                return eval;
        throw new RuntimeException("Unexpected in CondExpr.eval()");
    }
}
