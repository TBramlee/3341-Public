package ast;

import java.util.HashMap;

public class UpdateStmt extends Stmt {

    final String varName;
    final Expr expr;

    public UpdateStmt(String varName, Expr expr, Location loc) {
        super(loc);
        this.varName = varName;
        this.expr = expr;
    }

    @Override
    QVal exec(HashMap<String, QVal> env) {

        env.put(varName, expr.eval(env));
        return null;
    }

    @Override
    public String toString() {
        return varName +  "=" + expr.toString();
    }

}
