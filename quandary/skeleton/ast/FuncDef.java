package ast;

import java.util.HashMap;

public class FuncDef extends ASTNode {

    String funcName;
    FormalDeclList parameters;
    StmtList stmtList;

    public FuncDef(String funcName, FormalDeclList parameters, StmtList stmtList, Location loc) {
        super(loc);
        this.funcName = funcName;
        this.parameters = parameters;
        this.stmtList = stmtList;
    }

    public String getName() {
        return funcName;
    }

    public FormalDeclList getDeclList() {
        return parameters;
    }

    //localEnv already has formal parameters and values
    public Long execBody(HashMap<String, Long> localEnv) {
        
        return stmtList.exec(localEnv);
    }
}
