package hello;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

import gen.EvalVisitor;
import gen.ExprLexer;
import gen.ExprParser;
import gen.ExprVisitor;

/**
 * Created by diwu.sld on 2016/12/1.
 */
public class Expr {

    public static void main(String [] args) throws IOException {
        ANTLRInputStream inputStream = new ANTLRInputStream("1 + 2 + 3 * 4+ 6 / 2");
        ExprLexer lexer = new ExprLexer(inputStream);

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokenStream);
        ParseTree parseTree = parser.prog();
        EvalVisitor visitor = new EvalVisitor();
        Integer rtn = visitor.visit(parseTree);
        System.out.println("#result#"+rtn.toString());
    }
}
