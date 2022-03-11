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

    @Override
    Long eval(HashMap<String, Long> env) {
        if(expr!= null) {
            return expr.eval(env);
        }
        return eList.eval(env);
    }

    void fillValueList(List<Long> values, HashMap<String, Long> env) {

        if(expr!= null) {
            values.add(expr.eval(env));
        }
        
        if(eList != null) {
            eList.fillValueList(values, env);
        }

    }
}
