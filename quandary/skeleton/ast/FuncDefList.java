package ast;

import java.util.HashMap;

public class FuncDefList {

    FuncDef function;
    FuncDefList list;

    public FuncDefList(FuncDef funcDef, FuncDefList list, Location loc) {
        super(loc);
        this.function = funcDef;
        this.list = list;
        Program.funcDefList
    }

}
