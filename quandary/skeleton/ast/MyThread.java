package ast;
import java.util.HashMap;


public class MyThread extends Thread {

    final Expr expr;
    HashMap<String, QVal> env;

    static final Object otherObject = new Object();
    MyThread(Expr expr, HashMap<String, QVal> env) {
       this.expr = expr;
       this.env = env;
    }

    @Override
    public void run() {
    }

    public QVal eval() {
        synchronized(env) {
            return expr.eval(env);
        }
        
    }

}

