package ast;

import java.util.HashMap;

public class UpdateStmt extends Stmt {

    final String funcName;
    final Expr expr;

    public UpdateStmt(String funcName, Expr expr, Location loc) {
        super(loc);
        this.funcName = funcName;
        this.expr = expr;
    }

    @Override
    Long exec(HashMap<String, Long> env) {
        env.put(funcName, expr.eval(env));
        return null;
    }

}
