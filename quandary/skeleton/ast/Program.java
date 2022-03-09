package ast;

import java.io.PrintStream;
import java.util.HashMap;

public class Program extends ASTNode {

    static Program theProgram;
    HashMap<String, FuncDef> funcDefMap;

    public Program(FuncDefList funcDefList, Location loc) {
        super(loc);
        Program.theProgram = this;
        this.funcDefMap = new HashMap<String, FuncDef>();
    }

    public Object exec(long argument) {
        HashMap<String, Long> env = new HashMap<String, Long>();
        FuncDef main = funcDefMap.get("main");
        return main.execBody(env);

    }
}
