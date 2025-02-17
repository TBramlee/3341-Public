package ast;

import java.io.PrintStream;
import java.util.HashMap;

public class Program extends ASTNode {

    static Program theProgram;
    HashMap<String, FuncDef> funcDefMap;
    final FuncDefList funcDefList;

    public Program(FuncDefList funcDefList, Location loc) {
        super(loc);
        Program.theProgram = this;
        this.funcDefList = funcDefList;
        this.funcDefMap = new HashMap<String, FuncDef>();
    }

    public Object exec(long argument) {

        QIntVal newArg = new QIntVal(argument);

        //Fill HashMap of function names to FuncDefinitions
        funcDefList.fillList();

        //create main env, and pass to main FuncDef
        HashMap<String, QVal> mainEnv = new HashMap<String, QVal>();
        FuncDef main = funcDefMap.get("main");

        //get arg for main, and put into environment
        //String argName = main.parameters.paramName;
        mainEnv.put(main.parameters.getName(), newArg);

        return main.execBody(mainEnv);

    }
}
