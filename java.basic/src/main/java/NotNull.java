import lombok.NonNull;

/**
 * Created by diwu.sld on 2017/1/10.
 */
public class NotNull {

    public void test(@NonNull Integer integer){
        System.out.println(integer);
    }

    public static  void main(String [] args){
        NotNull notNull = new NotNull();
        notNull.test(null);
    }
}
