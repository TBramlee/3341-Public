package ast;

import java.util.HashMap;

public abstract class Expr extends ASTNode {

    Expr(Location loc) {
        super(loc);
    }

    abstract Long eval(HashMap<String, Long> env);
}
