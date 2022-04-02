package ast;

public class Type extends ASTNode {

    final int type;

    public static final int INT = 1;
    public static final int REF = 2;
    public static final int Q = 3;


    public Type(int type, Location loc) {
        super(loc);
        this.type = type;
    }
}
