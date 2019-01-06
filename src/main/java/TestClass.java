import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.*;
import java.util.stream.*;

public class TestClass {

    public static void main(String[] args) {

        String str = "ankit";

        String rev = new StringBuilder(str).reverse().toString();
        System.out.println(rev);
        IntFunction<Character> ifs = new IntFunction<Character>(){

            @Override
            public Character apply(int value) {
                return (char)value;
            }
        };

        List<Character> charList = str.chars().mapToObj(c -> (char)c ).sorted().collect(Collectors.toList());
        System.out.println(charList);
        StringBuilder sb = new StringBuilder();
        charList.stream().forEach(cc-> sb.append(cc));
        System.out.println("sb="+sb.toString());

        List<Integer> list = new ArrayList<>();
        list.add(1);
        int[] intarr = list.stream().mapToInt( Integer::intValue).toArray();
        System.out.println(Arrays.toString(intarr));

        String [] myStr = {"Ankit", "Gupta"};
        StringBuilder[] sss = Stream.of(myStr).map(StringBuilder::new).toArray(StringBuilder[]::new);
        Stream.of(sss).forEach(System.out::println);

        int [][] i = new  int [2][];
        for(int a =0; a<i.length; a++){
            System.out.println(i[a]);
        }
    }
}

