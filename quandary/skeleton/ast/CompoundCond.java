package ast;

public class CompoundCond extends Expr {

    public static final int AND = 1;
    public static final int OR = 2;

    final Expr expr1;
    final int operator;
    final Expr expr2;

    public CompoundCond(CondExpr expr1, int operator, CondExpr expr2, Location loc) {
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
            case AND:  s = "&&"; break;
            case OR: s = "||"; break;
        }
        return expr1 + " " + s + " " + expr2;
    }

    @Override
    Object eval() {
        boolean eval = false;
        boolean leftSide = (boolean)expr1.eval();
        boolean rightSide = (boolean)expr2.eval();

        switch (operator) {
            case AND:  
                if (leftSide && rightSide) {
                    eval = true;
                }
                return eval;
            case OR: 
                if (leftSide ||rightSide) {
                    eval = true;
                }
                return eval;
        throw new RuntimeException("Unexpected in CondExpr.eval()");
    }
}
