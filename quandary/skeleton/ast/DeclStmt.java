package ast;

import java.util.HashMap;

public class DeclStmt extends Stmt {

    final VarDecl varDecl;
    final Expr expr;

    public DeclStmt(VarDecl varDecl, Expr expr, Location loc) {
        super(loc);
        this.varDecl = varDecl;
        this.expr = expr;
    }

    @Override
    QVal exec(HashMap<String, QVal> env) {
        env.put(varDecl.getName(), expr.eval(env));
        return null;
    }

}
