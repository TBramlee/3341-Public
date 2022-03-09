package ast;

import java.util.HashMap;
import java.util.Random;

public class CallExpr extends Expr {

    final String funcName;
    ExprList eList;

    public CallExpr(String funcName, ExprList eList, Location loc) {
        super(loc);
        this.funcName = funcName;
        this.eList = eList;
    }

    @Override
    Long eval(HashMap<String, Long> env) {

        if (funcName == "randomInt") {
            Random rand = new Random();
            return rand.NextInt(ExprList.eval());
        }
        
        //create environment for function
        HashMap<String, Long> localEnv = new HashMap<String, Long>();

        //Find function in Program.funcDefList
        FuncDef function = Program.theProgram.funcDefMap.get(funcName);

        //check if 
        function.execBody(localEnv);
    }
}
