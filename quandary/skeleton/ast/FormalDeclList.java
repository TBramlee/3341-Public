package ast;

import java.util.HashMap;
import java.util.List;

public class FormalDeclList extends ASTNode{

    final VarDecl varDecl;
    FormalDeclList others;

    public FormalDeclList(VarDecl varDecl, FormalDeclList others, Location loc) {
        super(loc);
        this.varDecl = varDecl;
        this.others = others;
        // return RuntimeException.printStackTrace();

    }

    void fillNameList(List<String> names, HashMap<String, QVal> env) {

        //TO-DO: get rid of null check
        if (varDecl != null) {
            names.add(varDecl.getName());
        }
        

        if(others != null) {
            others.fillNameList(names, env);
        }
    }

    String getName() {
        return varDecl.getName();
    }

}
