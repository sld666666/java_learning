package effectiveJava.enumset;

import java.util.EnumSet;
import java.util.Set;

/**
 * Created by diwu.sld on 2017/4/11.
 */
public class EnumSetTestor {

    private  enum LastModifyType{
        LMT_TITLE(1),
        LMT_SUB_TITLE(2);

        private  final int value;

        LastModifyType(int value) {
            this.value = value;
        }
    }

    private EnumSetTestor(){

    }

    public  static Set<LastModifyType> addMOdify(Set<LastModifyType> source, LastModifyType val){
        source.addAll(EnumSet.of(val));
        return source;
    }

    public  static void main(String [] args){
        Set<LastModifyType> source = EnumSet.of(LastModifyType.LMT_TITLE);
        System.out.println(EnumSetTestor.addMOdify(source, LastModifyType.LMT_SUB_TITLE));
    }
}
