package ast;

import java.util.HashMap;

public class ConcurrentBinaryExpr extends Expr {

    final BinaryExpr expr;

    public ConcurrentBinaryExpr(BinaryExpr expr, Location loc) {
        super(loc);
        this.expr = expr;
    }

    @Override
    public String toString() {
        return expr.toString();
    }

    @Override
    QVal eval(HashMap<String, QVal> env) {
        
        String thread1Name = "threadOne" + this.toString();
        String thread2Name = "threadTwo" + this.toString();

        MyThread t1 = new MyThread(thread1Name, expr.expr1, env);
        MyThread t2 = new MyThread(thread2Name, expr.expr2, env);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();

            /*
            if(left == null) {
                System.out.println(expr.expr1 + " WAS NOT FOUND IN THE ENVIRONMENT");
            }
            if(right == null) {
                System.out.println(expr.expr2 + " WAS NOT FOUND IN THE ENVIRONMENT");
            }
            */
            
        } catch (InterruptedException ex) {
            System.out.println(expr + " failed to be evaluated concurrently.");
        }

        QVal left = env.remove(thread1Name);
        QVal right = env.remove(thread2Name);

        return BinaryExpr.doOperation(left, expr.operator, right);
       
    }
}


