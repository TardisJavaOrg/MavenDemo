
public class LongCommonPreFix {
    public static void main(String[] args) {
        String[] s = new String[]{};
        System.out.println(longestCommonPrefix(s));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String prefix = strs[0];
        int len = strs.length;
        for (int i = 1; i < len; i++) {
            prefix = check(prefix, strs[i]);
        }
        return prefix;
    }

    public static String check(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        int index = 0;
        while (index < len && s1.charAt(index) == s2.charAt(index)) index++;
        return s1.substring(0, index);
    }
}
