package ast;

import java.util.HashMap;
import java.util.List;

public class ExprList extends Expr {

    Expr expr;
    ExprList eList;


    public ExprList(Expr expr, ExprList eList, Location loc) {
        super(loc);
        this.expr = expr;
        this.eList = eList;
    }

    Long eval(HashMap<String, Long> env) {
        
        return null;
    }

    void fillValueList(List<Long> values) {}
}
