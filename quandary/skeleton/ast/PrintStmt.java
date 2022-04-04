package ast;

import java.util.HashMap;

public class PrintStmt extends Stmt {

    Expr e;

    public PrintStmt(Expr e, Location loc) {
        super(loc);
        this.e = e;
    }

    @Override
    QVal exec(HashMap<String, QVal> env) {
        
        System.out.println(e.eval(env));
        return null;
    }

}
