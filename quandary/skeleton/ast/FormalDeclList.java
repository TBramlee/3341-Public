package ast;

import java.util.List;

public class FormalDeclList extends ASTNode{

    String paramName;
    FormalDeclList others;

    public FormalDeclList(String paramName, FormalDeclList others, Location loc) {
        super(loc);
        this.paramName = paramName;
        this.others = others;
      
    }

    List<String> eval() {


        return null;
    }

}
