package ast;
import java.util.HashMap;

public abstract class Stmt extends ASTNode {

    Stmt(Location loc) {
        super(loc);
    }

    abstract Long exec(HashMap<String, Long> env);
}
