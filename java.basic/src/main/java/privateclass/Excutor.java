package privateclass;

//import privateclass.sub.SubTestor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Hashtable;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by diwu.sld on 2017/4/10.
 */
public class Excutor {

    public  static void main(String [] args){
        Map<String, String> tmp = new HashMap();
        tmp.put("aaa", "123");

        Map<String, String> tmp1 = new  Hashtable();

        tmp = new ConcurrentHashMap();

        List<String> tmp2 = new ArrayList();
        tmp2.add("aaa");

        String result = tmp.get("aaa");

        Testor testor = new Testor();
        testor.excute();

        Integer test = 1;

        //SubTestor subTestor = new SubTestor();
       // subTestor.excute();
    }
}
