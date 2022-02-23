package ast;

import java.util.HashMap;

public class DeclStmt extends Stmt {

    final String varName;
    final Expr expr;

    public DeclStmt(String varName, Expr expr, Location loc) {
        super(loc);
        this.varName = varName;
        this.expr = expr;
    }

    @Override
    Long exec(HashMap<String, Long> env) {
        env.put(varName, expr.eval(env));
        return null;
    }

}
