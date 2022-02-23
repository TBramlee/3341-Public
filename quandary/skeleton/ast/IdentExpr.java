package ast;

import java.util.HashMap;

public class IdentExpr extends Expr {

    final String varName;

    public IdentExpr(String varName, Location loc) {
        super(loc);
        this.varName = varName;
    }

    @Override
    Long eval(HashMap<String, Long> env) {
        return env.get(varName);
    }
}
