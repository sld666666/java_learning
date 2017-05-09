package hello;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import java.io.IOException;
import gen.ArrayInitLexer;
import gen.JsonBaseListener;
import gen.JsonParser;

/**
 * Created by diwu.sld on 2016/12/9.
 */
public class Json {

    public static void main(String [] args) throws IOException {
        String value = "{\n" +
                "\"aaa\":11 ,\n" +
                "\"bbb\": 222,\n" +
                "\"ccc\" : [1, 2, 3, 4],\n" +
                "\"ddd\" : [{\"aaaa\" : \"ababa\"}]\n" +
                "}";
        ANTLRInputStream inputStream = new ANTLRInputStream(value);
        ArrayInitLexer lexer = new ArrayInitLexer(inputStream);

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        JsonParser parser = new JsonParser(tokenStream);

        ParseTree parseTree = parser.json();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new JsonBaseListener(), parseTree);
        System.out.println(parseTree.toStringTree(parser));

    }
}
