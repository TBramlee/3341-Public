package ast;

import java.util.HashMap;

public class BinaryExpr extends Expr {

    public static final int PLUS = 1;
    public static final int MINUS = 2;
    public static final int TIMES = 3;
    public static final int DOT = 4;

    final Expr expr1;
    final int operator;
    final Expr expr2;
    final boolean isConcurrent;

    public BinaryExpr(Expr expr1, int operator, Expr expr2, boolean isConcurrent, Location loc) {
        super(loc);
        this.expr1 = expr1;
        this.operator = operator;
        this.expr2 = expr2;
        this.isConcurrent = isConcurrent;
    }

    @Override
    public String toString() {
        return "(" + simpleString() + ")";
    }

    public String simpleString() {
        String s = null;
        switch (operator) {
            case PLUS:  s = "+"; break;
            case MINUS: s = "-"; break;
            case TIMES: s = "*"; break;
            case DOT:   s = "."; break;
        }
        return expr1 + " " + s + " " + expr2;
    }

    @Override
    QVal eval(HashMap<String, QVal> env) {
        if (expr2!= null) {
            return doOperation(expr1.eval(env), operator, expr2.eval(env));
        }
        return expr1.eval(env);
       
    }

    static QVal doOperation(QVal obj1, int operator, QVal obj2) {

        long value1 = 0;
        long value2 = 0;

        if (operator != BinaryExpr.DOT) {
            value1 = ((QIntVal)obj1).value;
            value2 = ((QIntVal)obj2).value;
        }
        
        switch (operator) {
            case PLUS:  return new QIntVal(value1+value2);
            case MINUS: return new QIntVal(value1-value2);
            case TIMES: return new QIntVal(value1*value2);
            case DOT:   return new QRefVal(new QObj(obj1, obj2));
        }
        throw new RuntimeException("Unexpected in BinaryExpr.doOperation");
    }
}
