import java.util.Hashtable;
import java.util.Map;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        Map<Integer, StringBuilder> map = new Hashtable<Integer, StringBuilder>();

        int key = 0;
        boolean down = true;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(key)) {
                map.put(key, new StringBuilder());
            }
            map.get(key).append(s.charAt(i));
            if (down) {
                if (key == numRows - 1) {
                    down = false;
                    key--;
                } else {
                    key++;
                }
            } else {
                if (key == 0) {
                    down = true;
                    key++;
                } else {
                    key--;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            var string = map.get(i);
            result.append(string == null ? "" : string);
        }
        return result.toString();
    }

}
