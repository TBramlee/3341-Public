package ast;
import java.util.HashMap;


public class MyThread extends Thread {

    final Expr expr;
    final String threadName;
    HashMap<String, QVal> env;
    private QVal evalValue;

    MyThread(String threadName, Expr expr, HashMap<String, QVal> env) {
       this.expr = expr;
       this.env = env;
       this.threadName = threadName;
    }

    @Override
    public void run() {
        evalValue = expr.eval(env);
    }

    public QVal getRetVal() {
        return evalValue;
    }
}

