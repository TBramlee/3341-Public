package ast;
import java.util.HashMap;


public class MyThread extends Thread {

    final Expr expr;
    final String threadName;
    HashMap<String, QVal> env;

    MyThread(String threadName, Expr expr, HashMap<String, QVal> env) {
       this.expr = expr;
       this.env = env;
       this.threadName = threadName;
    }

    @Override
    public void run() {
        env.put(threadName, expr.eval(env));
    }

}

