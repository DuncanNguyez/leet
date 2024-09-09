public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        return f(strs, "");
    }

    String f(String[] strings, String prefix) {
        boolean isMore = true;
        for (String string : strings) {
            if (!string.startsWith(prefix)) {
                isMore = false;
                break;
            }
        }
        if (isMore ) {
            if(prefix.equals(strings[0])){
                return prefix;
            }
            return f(strings, strings[0].substring(0, prefix.length() + 1));
        }
        return prefix.substring(0, prefix.length()-1);
    }
}
