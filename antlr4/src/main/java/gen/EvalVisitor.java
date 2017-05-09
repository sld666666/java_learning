package gen;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by diwu.sld on 2016/12/8.
 */
public class EvalVisitor extends ExprBaseVisitor<Integer> {
    Map<String, Integer> memory = new HashMap<String, Integer>();

    @Override
    public Integer visitPrintExpr(ExprParser.PrintExprContext ctx) {
        Integer value = visit(ctx.expr());
        System.out.println("printExpr: "+ value.toString());
        return value;
    }


    @Override
    public Integer visitAssign(ExprParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        Integer value = visit(ctx.expr());
        this.memory.put(id, value);
        return value;

    }

    @Override
    public Integer visitInt(ExprParser.IntContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }

    @Override
    public Integer visitId(ExprParser.IdContext ctx) {
        String id = ctx.ID().getText();
        if ( memory.containsKey(id) ) return memory.get(id);
        return 0;
    }

    @Override
    public Integer visitMulDiv(ExprParser.MulDivContext ctx) {
        Integer left = visit(ctx.expr(0));
        Integer right = visit(ctx.expr(1));

        if (ctx.op.getType() == ExprParser.MUL){
            return left * right;
        }else{
            return left / right;
        }

    }

    @Override
    public Integer visitAddSub(ExprParser.AddSubContext ctx) {
        Integer left = visit(ctx.expr(0));
        Integer right = visit(ctx.expr(1));

        if (ctx.op.getType() == ExprParser.ADD){
            return  left + right;
        }else{
            return  left - right;
        }

    }

    @Override
    public Integer visitParens(ExprParser.ParensContext ctx) {
            return  visit(ctx.expr());
    }
}
