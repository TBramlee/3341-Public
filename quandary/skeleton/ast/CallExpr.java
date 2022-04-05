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
    QVal eval(HashMap<String, QVal> env) {

        //create environment for function
        HashMap<String, QVal> localEnv = new HashMap<String, QVal>();

        //create lists of param names and values
        List<QVal> values = new ArrayList<QVal>();
        List<String> names = new ArrayList<String>();

        /*
        if (funcName.equals("randomInt")) {
            Random rand = new Random();

            eList.fillValueList(values, env);
            QVal obj = values.get(0);
            Long val = ((QIntVal)obj).value;

            int retval = rand.nextInt(val.intValue());
            return new QIntVal(new Long(retval));
        }
        */

        //check for built-in functions (non-mutable)
        switch (funcName) {
            case "randomInt": return randomInt(env, values);
            case "left": return left(env, values);
            case "right": return right(env, values);
            case "isAtom": return isAtom(env, values);
            case "isNil": return isNil(env, values);
            case "setLeft": return setLeft(env, values);
            case "setRight": return setRight(env, values);
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

    /*
    Non-mutable built in functions for quandary
    -randomInt
    -left
    -right
    -isAtom
    -isNil
    */

    QVal randomInt(HashMap<String, QVal> env, List<QVal> values) {
        Random rand = new Random();

        eList.fillValueList(values, env);
        QVal obj = values.get(0);
        Long val = ((QIntVal)obj).value;

        int retval = rand.nextInt(val.intValue());
        return new QIntVal(new Long(retval));
    }

    QVal left(HashMap<String, QVal> env, List<QVal> values) {

        eList.fillValueList(values, env);
        QVal obj = values.get(0);
        QRefVal ref = (QRefVal)obj;
        return ref.value.left;
    }

    QVal right(HashMap<String, QVal> env, List<QVal> values) {

        eList.fillValueList(values, env);
        QVal obj = values.get(0);
        QRefVal ref = (QRefVal)obj;
        return ref.value.right;
    }

    QVal isAtom(HashMap<String, QVal> env, List<QVal> values) {

        eList.fillValueList(values, env);
        QVal obj = values.get(0);
        
        QRefVal ref = null;

        if (obj instanceof QIntVal) {
            return new QIntVal(1);
        }
        else if (obj instanceof QRefVal){
            ref = (QRefVal)obj;
            if(ref.value == null) {
                return new QIntVal(0);
            }
        }

        return new QIntVal(0);
    }

    QVal isNil(HashMap<String, QVal> env, List<QVal> values) {

        eList.fillValueList(values, env);
        QVal obj = values.get(0);
        
        QRefVal ref = null;

        if (obj instanceof QRefVal){
            ref = (QRefVal)obj;
            if(ref.value == null) {
                return new QIntVal(1);
            }
        }

        return new QIntVal(0);
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

}
