package ast;

import java.util.HashMap;

public class ReturnStmt extends Stmt {

    Expr e;

    public ReturnStmt(Expr e, Location loc) {
        super(loc);
        this.e = e;
    }

    @Override
    QVal exec(HashMap<String, QVal> env) {
        env.put("return", new QRefVal(null));
        return e.eval(env);
    }

}
