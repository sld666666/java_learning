package effectiveJava.enumset;

/**
 * Created by diwu.sld on 2017/4/11.
 */
public class BitsetTestor {
    private static final int LAST_MODIFY_TITLE = 1 << 0;
    private static final int LAST_MODIFY_SUBTILE = 1 << 1;

    private BitsetTestor(){

    }

    public  static int setLastModifyFields(int source, int val){
        return  source | val;
    }

    public  static  void main(String [] args){
        int tmp = BitsetTestor.LAST_MODIFY_TITLE;
        System.out.println(BitsetTestor.setLastModifyFields(tmp, BitsetTestor.LAST_MODIFY_SUBTILE));
    }
}
