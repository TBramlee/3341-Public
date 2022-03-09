package ast;

import java.util.HashMap;

public class FuncDef {

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

    public Long execBody(HashMap<String, Long> env) {
        //get parameters from FormalDeclList (java list)

        //pass parameters into 

    }
}
