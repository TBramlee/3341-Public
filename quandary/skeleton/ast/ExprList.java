package ast;

import java.util.HashMap;
import java.util.Random;

public class ExprList extends Expr {

    Expr expr;
    ExprList eList;

    public ExprList(Expr expr, ExprList eList, Location loc) {
        super(loc);
        this.expr = expr;
        this.eList = eList;
    }

    @Override
    Long eval(HashMap<String, Long> env) {

        
        return null;
    }
}
