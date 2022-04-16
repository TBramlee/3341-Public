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
    QVal eval(HashMap<String, QVal> env) {
        if(expr!= null) {
            return expr.eval(env);
        }
        return eList.eval(env);
    }

    @Override
    public String toString(){
        if(eList != null) {
            return expr.toString() + " ," + eList.toString();
        }
       return expr.toString();
    }

    void fillValueList(List<QVal> values, HashMap<String, QVal> env) {

        if(expr!= null) {
            values.add(expr.eval(env));
        }
        
        if(eList != null) {
            eList.fillValueList(values, env);
        }

    }
}
