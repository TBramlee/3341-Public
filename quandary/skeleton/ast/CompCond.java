package ast;

import java.util.HashMap;

public class CompCond extends Cond {

    public static final int LT = 1;
    public static final int GT = 2;
    public static final int LE = 3;
    public static final int GE = 4;
    public static final int EQ = 5;
    public static final int NE = 6;

    final Expr expr1;
    final int operator;
    final Expr expr2;

    public CompCond(Expr expr1, int operator, Expr expr2, Location loc) {
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
            case LT:  s = "<"; break;
            case GT: s = ">"; break;
            case LE: s = "<="; break;
            case GE: s = ">="; break;
            case EQ: s = "=="; break;
            case NE: s = "!="; break;
        }
        return expr1 + " " + s + " " + expr2;
    }

    @Override
    boolean eval(HashMap<String, Long> env) {

        long leftSide = (long)expr1.eval(env);
        long rightSide = (long)expr2.eval(env);

        switch (operator) {
            case LT: return leftSide < rightSide;
            case GT: return leftSide > rightSide;
            case LE: return leftSide <= rightSide;
            case GE: return leftSide >= rightSide;
            case EQ: return leftSide == rightSide;
            case NE: return leftSide != rightSide;
        }
        throw new RuntimeException("Unexpected in CompCond.eval()");
    }
}
