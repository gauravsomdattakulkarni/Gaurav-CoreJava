public class StringPractice {
    public static void main(String[] args) {
       String name = new String("Hii My Name Is Gaurav Somdatta Kulkarni");

       System.out.println(name);

       System.out.println(name.charAt(10));

       System.out.println("length of string is : " + name.length());

       System.out.println("Lowercase  of string is : " + name.toLowerCase());

       System.out.println("Uppercase  of string is : " + name.toUpperCase());

       String new_nm[] = name.split(" ");

       for (String str : new_nm) {
        System.out.println(str);
        }

        String str ="";

        System.out.println(str.isEmpty());

        String str1 = "java ";
        String str2 = "Programming";
        String lang = str1.concat(str2);
        System.out.println("Name Of Language is " + lang);

        System.out.println("Index of java " + lang.indexOf("java"));


    }
}
