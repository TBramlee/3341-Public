package ast;

import java.util.*;

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

        //create environment for function
        HashMap<String, Long> localEnv = new HashMap<String, Long>();

        //check for built in function
        if (funcName == "randomInt") {
            Random rand = new Random();
            Long val = localEnv.get("n");
            int retval = rand.nextInt(val.intValue());
            return new Long(retval);
        }

        //create lists of param names and values
        List<Long> values = new ArrayList<Long>();
        List<String> names = new ArrayList<String>();
        
        eList.eval(env);


        

        

        //Find function in Program.funcDefList
        FuncDef function = Program.theProgram.funcDefMap.get(funcName);

        //execute function body
        return function.execBody(localEnv);
    }
}
