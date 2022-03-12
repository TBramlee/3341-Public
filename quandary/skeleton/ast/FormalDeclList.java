package ast;

import java.util.HashMap;
import java.util.List;

public class FormalDeclList extends ASTNode{

    String paramName;
    FormalDeclList others;

    public FormalDeclList(String paramName, FormalDeclList others, Location loc) {
        super(loc);
        this.paramName = paramName;
        this.others = others;
        // return RuntimeException.printStackTrace();

    }

    void fillNameList(List<String> names, HashMap<String, Long> env) {

        if (paramName != null) {
            names.add(paramName);
        }
        

        if(others != null) {
            others.fillNameList(names, env);
        }
    }

}
