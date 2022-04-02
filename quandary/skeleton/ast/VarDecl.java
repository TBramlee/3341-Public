package ast;

public class VarDecl extends ASTNode {

    final Type type;
    final String varName;

    public static final int INT = 1;
    public static final int REF = 2;
    public static final int Q = 3;


    public VarDecl(Type type, String varName, Location loc) {
        super(loc);
        this.varName = varName;
        this.type = type;
    }

    public String getName() {
        return varName;
    }

    public String getType() {
        switch (type.type) {
            case INT:  return "int";
            case REF: return "Ref";
            case Q: return "Q";
        }
        throw new RuntimeException("Unexpected in VarDecl.getType()");
    }
    

}
