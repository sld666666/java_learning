package java_learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by diwu.sld on 2016/12/30.
 */
public class StreamTestor {
    private List<Integer> datas = Arrays.asList(1, 2,3,4,5);

    public void normalIterator(){
        int counts = 0;
        Iterator<Integer> iter =  datas.iterator();
        while (iter.hasNext()){
            int tmp = iter.next();
            if (tmp > 3){
                ++counts;
            }
        }

        System.out.println(counts);
    }

    public void lambadaIterator(){
        long counts = this.datas.stream()
                .filter( input -> input > 3)
                .count();

        System.out.println(counts);
    }

    public void testCollectors(){
        List<String> collected = Stream.of("a", "b", "c")
                                .collect(Collectors.toList());
        System.out.println(collected);
    }

    public void normalUpper(){
        List<String> collected = new ArrayList<>();
        for (String string : Arrays.asList("a", "b", "hello")) {
            String uppercaseString = string.toUpperCase();
            collected.add(uppercaseString);
        }

        System.out.println(collected);
    }

    public  void lambadeUpper(){
        List<String> collected = Stream.of("a", "b", "hello")
                                .map(str -> str.toUpperCase())
                                .collect(Collectors.toList());
        System.out.println(collected);
    }

    public  void testMin(){
        Integer min = this.datas.stream()
                .min(Comparator.comparing(x -> x)).get();
        System.out.println(min);
    }

    public  void testMax(){
        Integer max = this.datas.stream()
                .max(Comparator.comparing(x -> x)).get();
        System.out.println(max);
    }

    public static void main(String [] args){
        String[] parts = "538756545147".split("-");
        StreamTestor streamTestor = new StreamTestor();
        streamTestor.normalIterator();
        streamTestor.lambadaIterator();
        streamTestor.testCollectors();
        streamTestor.normalUpper();
        streamTestor.lambadeUpper();
        streamTestor.testMin();
        streamTestor.testMax();
    }
}
