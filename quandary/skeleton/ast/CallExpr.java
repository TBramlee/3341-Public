package ast;

import java.util.*;

public class CallExpr extends Expr {

    final String funcName;
    final ExprList eList;

    public CallExpr(String funcName, ExprList eList, Location loc) {
        super(loc);
        this.funcName = funcName;
        this.eList = eList;
    }


    //Evaluates call to function. Creates local environment for function and populates it with parameters.
    @Override
    Long eval(HashMap<String, Long> env) {

        //create environment for function
        HashMap<String, Long> localEnv = new HashMap<String, Long>();

        //create lists of param names and values
        List<Long> values = new ArrayList<Long>();
        List<String> names = new ArrayList<String>();

        //check for built in function
        if (funcName.equals("randomInt")) {
            Random rand = new Random();

            eList.fillValueList(values, env);
            Long val = values.get(0);

            int retval = rand.nextInt(val.intValue());
            return new Long(retval);
        }

        //Find function in Program.funcDefList
        FuncDef function = Program.theProgram.funcDefMap.get(funcName);

        
        
        if(eList != null) {
            //fill lists
            eList.fillValueList(values, env);
            function.getDeclList().fillNameList(names, env);

            //fill local environment with paramater names and values
            for (int i = 0; i < names.size(); i++) {

                localEnv.put(names.get(i), values.get(i));

            }
        }
        

        //execute function body
        return function.execBody(localEnv);
    }


}
