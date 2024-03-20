import java.util.HashMap;

class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int result = 0;
        int t = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {

            if (map.containsKey(s.charAt(i))) {
                int index = map.get(s.charAt(i));
                for (int j = t; j < index + 1; j++) {
                    map.remove(s.charAt(j));
                }
                t = index + 1;
            }
            map.put(s.charAt(i), i);
            result = Math.max(map.size(), result);
        }
        return result;
    }
}