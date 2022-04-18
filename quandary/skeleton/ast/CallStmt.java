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

        //check for built-in functions
        switch (funcName) {
            case "setLeft": setLeft(env, values); return null;
            case "setRight": setRight(env, values); return null;
            case "acq": acquire(env, values); return null;
            case "rel": release(env, values); return null;
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
        function.execBody(localEnv);
        return null;
    }

    QVal setLeft(HashMap<String, QVal> env, List<QVal> values) {

        eList.fillValueList(values, env);
        QRefVal ref = (QRefVal)values.get(0);
        QVal val = values.get(1);
        
        if(ref.value != null) {
            ref.value.left = val;
        }
        else {
            ref.value = new QObj(val, null);
        }

        return new QIntVal(1);
    }

    QVal setRight(HashMap<String, QVal> env, List<QVal> values) {

        eList.fillValueList(values, env);
        QRefVal ref = (QRefVal)values.get(0);
        QVal val = values.get(1);
        
        if(ref.value != null) {
            ref.value.right = val;
        }
        else {
            ref.value = new QObj(null, val);
        }
        

        return new QIntVal(1);
    }

    QIntVal acquire(HashMap<String, QVal> env, List<QVal> values) {

        eList.fillValueList(values, env);
        QVal obj = values.get(0);
        QRefVal ref = (QRefVal)obj;

        while(!ref.value.isLocked.compareAndSet(false, true)) {}
    
        return new QIntVal(1);
    }

    QIntVal release(HashMap<String, QVal> env, List<QVal> values) {

        eList.fillValueList(values, env);
        QVal obj = values.get(0);
        QRefVal ref = (QRefVal)obj;

        ref.value.isLocked.set(false);
        return new QIntVal(1);
    }


}
