public class StringBufferAndStringReader {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hii My Name Is , Gaurav Somdatta Kulkarni . ");
        System.err.println(sb.capacity());
        System.err.println("Length Of String : " + sb.length());
        sb.append(" And I AM An Professional SOftware Developer");
        System.out.println(sb);

        String str = sb.toString();
        System.out.println("Converted string buffer to string :  " + str);
    }
}
