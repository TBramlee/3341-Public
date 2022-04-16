package ast;

import java.util.HashMap;

public class LogicalCond extends Cond {

    public static final int AND = 1;
    public static final int OR = 2;
    public static final int NOT = 3;

    Cond c1;
    Cond c2;
    final int operator;
    

    public LogicalCond(Cond c1, int operator, Cond c2, Location loc) {
        super(loc);
        this.c1 = c1;
        this.c2 = c2;
        this.operator = operator;
    }

    @Override
    boolean eval(HashMap<String, QVal> env) {

        switch (operator) {
            case AND: return c1.eval(env) && c2.eval(env);
            case OR: return c1.eval(env) || c2.eval(env);
            case NOT: return !c1.eval(env);
        }
        throw new RuntimeException("Unexpected in CondExpr.eval()");
    }
}
