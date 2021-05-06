package t07_midExam.techMid;

public class omg {
    public static void main(String[] args) {
        String s1 = new String("a").intern();
        String s2 = new String("a").intern();
        Integer a;
        Integer b;

        if(s1 == s2){
            a = s1.length() + 127;
            b = s2.length() + 127;
        }else {
            a = s1.length() + 126;
            b = s2.length() + 126;
        }

        if(a==b){
            System.out.println(a+b+((s1==s2) ? -70 : -30));
        }else{
            System.out.println(a-b+((s1!=s2) ? 30 : 70));
        }
    }
}
