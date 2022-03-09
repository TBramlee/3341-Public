package ast;

import java.util.HashMap;

public class FormalDeclList {

    FuncDef function;
    FuncDefList rest;

    public FormalDeclList(FuncDef funcDef, FuncDefList list, Location loc) {
        super(loc);
        this.function = funcDef;
        this.rest = list;
      
    }

    public void fillList () {
        Program.theProgram.funcDefMap.put(function.getName(), function);
        rest.fillList();
    }

}
