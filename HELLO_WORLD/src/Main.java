import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String s ="hello";
        String s1 =new String("haha");
        System.out.println(s.equals(s1));
        System.out.println(s.toUpperCase());
        System.out.println(s.indexOf("l"));
        System.out.println(s.lastIndexOf("l"));
        System.out.println(s.charAt(0));
        System.out.println(s.substring(1));
        System.out.println(s.substring(1,2));//从0开始 左闭右开
        char[] chars = s.toCharArray();
        for (char c:chars
             ) {
            System.out.println(c);
        }
        int [] n ={1,2,3,4};
        Arrays.stream(n).forEach(System.out::println);
        StringBuffer sf =new StringBuffer(100);
        sf.append(2);
        System.out.println(sf);
        int capacity = sf.capacity();
        System.out.print(capacity);


        //aaaaa


    }
}
