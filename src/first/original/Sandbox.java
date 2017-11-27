package first.original;

/**
 * Created by student on 11/15/17.
 */
public class Sandbox {

    public static void main(String[] args) {
        Sandbox te = new Sandbox();
        System.out.println(te.merge("hello","hiasd"));
    }

    public String merge(String first, String second) {
        char[] firstChars = first.toCharArray();
        char[] secondChars = second.toCharArray();

        int smallerCharsCount = Math.min(firstChars.length, secondChars.length);
        StringBuilder builder = new StringBuilder(smallerCharsCount * 2);
        for (int i = 0; i < smallerCharsCount; i++) {
            if(i % 2 == 0) {
                builder.append(firstChars[i]);
            }else {
                builder.append(secondChars[i]);
            }
        }
        return builder.toString();
    }
}
