package ast;

import java.util.HashMap;

public class IdentExpr extends Expr {

    final String varName;

    public IdentExpr(String varName, Location loc) {
        super(loc);
        this.varName = varName;
    }

    @Override
    QVal eval(HashMap<String, QVal> env) {
        QVal returnVal = env.get(varName);
        //System.out.println(varName + " = " + returnVal);
        return returnVal;
    }

    @Override
    public String toString() {
        return varName;
    }
}
