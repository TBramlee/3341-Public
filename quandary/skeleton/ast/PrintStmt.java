package ast;

import java.util.HashMap;

public class PrintStmt extends Stmt {

    Expr e;

    public PrintStmt(Expr e, Location loc) {
        super(loc);
        this.e = e;
    }

    @Override
    Long exec(HashMap<String, Long> env) {
        
        System.out.println(e.eval(env));
        return null;
    }

}
