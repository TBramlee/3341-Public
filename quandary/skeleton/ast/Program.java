package ast;

import java.io.PrintStream;
import java.util.HashMap;

public class Program extends ASTNode {

    static Program theProgram;
    HashMap<String, FuncDef> funcDefMap;
    FuncDefList funcDefList;

    public Program(FuncDefList funcDefList, Location loc) {
        super(loc);
        Program.theProgram = this;
        this.funcDefList = funcDefList;
        this.funcDefMap = new HashMap<String, FuncDef>();
    }

    public Object exec(long argument) {
        //Fill HashMap of function names to FuncDefinitions
        funcDefList.fillList();
        //create main env, and pass to main FuncDef
        HashMap<String, Long> mainEnv = new HashMap<String, Long>();
        FuncDef main = funcDefMap.get("main");
        return main.execBody(mainEnv);

    }
}
