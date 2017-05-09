package effectiveJava;

/**
 * Created by diwu.sld on 2017/4/10.
 */
public final class Complex {

    private  final  double   re;
    private  final  double  im;

    public Complex(double re, double im){
        this.re = re;
        this.im = im;
    }

    public Complex add( Complex c){
        return  new Complex(this.re + c.re, this.im + c.im);
    }
}
