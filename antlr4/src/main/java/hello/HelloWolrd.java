package hello;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

import gen.ArrayInitBaseListener;
import gen.ArrayInitLexer;
import gen.ArrayInitListener;
import gen.ArrayInitParser;

/**
 * Created by diwu.sld on 2016/12/1.
 */
public class HelloWolrd {

    public static void main(String [] args) throws IOException {
        ANTLRInputStream inputStream = new ANTLRInputStream("{1, 2, {11, 12}, 3}");
        ArrayInitLexer lexer = new ArrayInitLexer(inputStream);

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        ArrayInitParser initParser = new ArrayInitParser(tokenStream);

        ParseTree parseTree = initParser.init();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new ArrayInitBaseListener(), parseTree);
        System.out.println(parseTree.toStringTree(initParser));

    }
}
