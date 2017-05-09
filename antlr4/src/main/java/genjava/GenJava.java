package genjava;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import genjava.gen.ExtractInterfaceListener;
import genjava.gen.JavaLexer;
import genjava.gen.JavaParser;

/**
 * Created by diwu.sld on 2016/12/8.
 */
public class GenJava {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("E:\\project\\github\\java_learning\\antlr4\\src\\main\\java\\genjava\\Demo.java");
        ANTLRInputStream input = new ANTLRInputStream(inputStream);
        JavaLexer lexer = new JavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);
        ParseTree tree = parser.compilationUnit(); // parse
        ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
        ExtractInterfaceListener extractor = new ExtractInterfaceListener(parser);
        walker.walk(extractor, tree); // initiate walk of tree with listener
    }
}
