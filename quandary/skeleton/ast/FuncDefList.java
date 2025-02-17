package ast;


public class FuncDefList extends ASTNode {

    FuncDef function;
    FuncDefList rest;

    public FuncDefList(FuncDef funcDef, FuncDefList list, Location loc) {
        super(loc);
        this.function = funcDef;
        this.rest = list;
      
    }

    public void fillList () {

        Program.theProgram.funcDefMap.put(function.getName(), function);

        if (rest != null) {
            rest.fillList();
        }
        
    }

}
