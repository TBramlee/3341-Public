package ast;

import java.io.PrintStream;
import java.util.HashMap;

public class Program extends ASTNode {

    static Program theProgram;
    HashMap<String, FuncDef> funcDefList;
    final String argName;
    final StmtList stmtList;

    public Program(String argName, StmtList stmtList, Location loc) {
        super(loc);
        this.argName = argName;
        this.stmtList = stmtList;
        this.theProgram = this;
        funcDefList = new HashMap<String, FuncDef>();
    }

    public Object exec(long argument) {
        HashMap<String, Long> env = new HashMap<String, Long>();
        env.put(argName, argument);
        return stmtList.exec(env);

    }
}
