package ast;

import java.util.HashMap;

public class FuncDef extends ASTNode {

    final VarDecl varDecl;
    FormalDeclList parameters;
    StmtList stmtList;

    public FuncDef(VarDecl varDecl, FormalDeclList parameters, StmtList stmtList, Location loc) {
        super(loc);
        this.varDecl = varDecl;
        this.parameters = parameters;
        this.stmtList = stmtList;
    }

    public String getName() {
        return varDecl.getName();
    }

    public FormalDeclList getDeclList() {
        return parameters;
    }

    //localEnv already has formal parameters and values
    public QVal execBody(HashMap<String, QVal> localEnv) {
        
        return stmtList.exec(localEnv);
    }
}
