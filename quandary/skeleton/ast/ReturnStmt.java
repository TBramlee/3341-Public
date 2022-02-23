package ast;

import java.util.HashMap;

public class ReturnStmt extends Stmt {

    Expr e;

    public ReturnStmt(Expr e, Location loc) {
        super(loc);
        this.e = e;
    }

    @Override
    Long exec(HashMap<String, Long> env) {
        
        return e.eval(env);
    }

}
