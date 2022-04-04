package ast;

import java.util.*;

public class CallStmt extends Stmt {

    final String funcName;
    final ExprList eList;

    public CallStmt(String funcName, ExprList eList, Location loc) {
        super(loc);
        this.funcName = funcName;
        this.eList = eList;
    }


    //Evaluates call to function. Creates local environment for function and populates it with parameters.
    @Override
    QVal exec(HashMap<String, QVal> env) {

        //create environment for function
        HashMap<String, QVal> localEnv = new HashMap<String, QVal>();

        //create lists of param names and values
        List<QVal> values = new ArrayList<QVal>();
        List<String> names = new ArrayList<String>();

        //check for built in function
        if (funcName.equals("randomInt")) {
            Random rand = new Random();

            eList.fillValueList(values, env);
            QVal obj = values.get(0);
            Long val = ((QIntVal)obj).value;

            int retval = rand.nextInt(val.intValue());
            return new QIntVal(new Long(retval));
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
