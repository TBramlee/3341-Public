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
            
        } catch (InterruptedException ex) {
            System.out.println(expr + " failed to be evaluated concurrently.");
        }

        QVal left = t1.getRetVal();
        QVal right = t2.getRetVal();

        if(left == null) {System.out.println(expr + " : left side of concurrent binary expression was null : " + expr.expr1);}
        if (right == null) {System.out.println(expr + " : right side of concurrent binary expression was null : " + expr.expr2);}

        return BinaryExpr.doOperation(left, expr.operator, right);
       
    }
}


