package ast;

import java.util.HashMap;

public class StmtList extends Stmt {

    Stmt first;
    StmtList rest;

    public StmtList(Stmt first, StmtList rest, Location loc) {
        super(loc);
        this.first = first;
        this.rest = rest;
    }

    @Override
    Long exec(HashMap<String, QVal> env) {
        Long retVal = first.exec(env);
        if(retVal != null) {
            return retVal;
        }    
        if (rest != null) {
            return rest.exec(env);
        }
        return null;
    }

}
