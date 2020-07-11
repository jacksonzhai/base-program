public class Test {
    public static void main(String[] args) {
        String str1 = new StringBuilder("jisuanji").append("run").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("java").toString();
        System.out.println(str2.intern() == str2
        );
    }
}
