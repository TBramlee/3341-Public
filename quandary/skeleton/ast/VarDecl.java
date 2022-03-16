package ast;

public class VarDecl extends ASTNode {

    final String varType;
    final String varName;

    public VarDecl(String varName, Location loc) {
        super(loc);
        this.varType = "int";
        this.varName = varName;
    }

    public String getName() {
        return varName;
    }

    public String getType() {
        return varType;
    }
    

}
