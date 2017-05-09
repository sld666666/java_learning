package contex.utils;

/**
 * Created by diwu.sld on 2017/5/5.
 */
public final class InstanceUtils  {

    private  InstanceUtils(){

    }

    public  static <T> T createInstance(Class<?> clazz){

        T rtn = null;
        try {
             rtn = (T)clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return  rtn;
    }
}
