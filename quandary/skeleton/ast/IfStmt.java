package ast;

import java.util.HashMap;

public class IfStmt extends Stmt {

    Cond c;
    Stmt s1;
    Stmt s2;

    public IfStmt(Cond c, Stmt s1, Stmt s2, Location loc) {
        super(loc);
        this.c = c;
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    Long exec(HashMap<String, Long> env) {
        if (c.eval(env)) {
            return s1.exec(env);
        }
        else if (s2 != null) {
            return s2.exec(env);
        }
        return null;
    }

}
