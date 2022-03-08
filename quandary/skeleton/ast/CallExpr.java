package ast;

import java.util.HashMap;

public class CallExpr extends Expr {

    final String varName;

    public CallExpr(String funcName, ExprList, Location loc) {
        super(loc);
        this.varName = varName;
    }

    @Override
    Long eval(HashMap<String, Long> env) {
        //create environment for function
        HashMap<String, FuncDef
        //Find function in Program.funcDefList

        //Call funcDef.eval(), pass in env
    }
}
