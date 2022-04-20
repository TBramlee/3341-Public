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
        
        MyThread t1 = new MyThread(expr.expr1, env);
        MyThread t2 = new MyThread(expr.expr2, env);

        QVal left = t1.eval();
        QVal right = t2.eval();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            System.out.println(expr + " failed to be evaluated concurrently.");
        }

        return BinaryExpr.doOperation(left, expr.operator, right);
       
    }
}


