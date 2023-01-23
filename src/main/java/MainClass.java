import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainClass {

    public static void main(String[] args) {
        System.out.println("Main Started");
//        SingletonClass.dummy();

        String str= "leet";
        System.out.println(str.indexOf("lee"));

        /*

        char [] tmp = new char[10];
        StringBuffer sss = new StringBuffer();
        sss.append("13");
        StringBuffer ss = new StringBuffer();
        ss.append("13");
        System.out.println(sss.append(ss.reverse()).toString().length());
        System.out.println(sss);
        System.out.println(new String(tmp).length());
        String input = "ankit";
        String input2 = "iank";
        char[] ch = input.toCharArray();
        char[] ch1 = input2.toCharArray();
        List<Character> i1 = IntStream.range(0,ch.length).mapToObj(i -> ch[i]).sorted().collect(Collectors.toList());
        List<Character> i2 = IntStream.range(0,ch1.length).mapToObj(i -> ch1[i]).sorted().collect(Collectors.toList());
        String res= i1.stream().map(c -> c.toString()).reduce( (c1, c2) -> c1+c2 ).get();
        String res2= i2.stream().map(c -> c.toString()).reduce( (c1, c2) -> c1+c2 ).get();

        //        i1.forEach(System.out::print);
        System.out.println(res);
        System.out.println(res2);

        System.out.println(res2.equals(res));
*/
//        i2.forEach(System.out::print);
    }



}
