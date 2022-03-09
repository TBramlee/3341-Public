package ast;

import java.util.HashMap;

public class FormalDeclList {

    String paramName;
    FormalDeclList others;

    public FormalDeclList(String paramName, FormalDeclList others, Location loc) {
        super(loc);
        this.paramName = paramName;
        this.others = others;
      
    }

    public void fillList () {
        Program.theProgram.funcDefMap.put(function.getName(), function);
        rest.fillList();
    }

}
