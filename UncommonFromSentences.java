import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonFromSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        var words1 = s1.split(" ");
        var words2 = s2.split(" ");
        Map<String,Boolean> map = new HashMap<>();
        for (String s : words1) {
            if (map.containsKey(s)) {
                map.put(s, false);
            } else {
                map.put(s, true);
            }
        }
        for (String s : words2) {
            if (map.containsKey(s)) {
                map.put(s, false);
            } else {
                map.put(s, true);
            }
        }
        List<String> list = new ArrayList<>();
        map.forEach((k,v)->{
            if(v){
                list.add(k);
            }
        });
        return list.toArray(new String[0]);
    }
}
