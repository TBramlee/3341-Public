package ast;

import java.util.HashMap;

public class WhileStmt extends Stmt {

    Cond c;
    Stmt s;

    public WhileStmt(Cond c, Stmt s, Location loc) {
        super(loc);
        this.c = c;
        this.s = s;
    }

    @Override
    Long exec(HashMap<String, Long> env) {
        while (c.eval(env)) {
            return s.exec(env);
        }
        return null;
    }

}
