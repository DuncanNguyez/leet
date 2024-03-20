
class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        return processingHasPoint(s,processingNonePoint(s));
    }

    String processingHasPoint(String s,String nonePointResult) {
        Location location = new Location();
        String result = nonePointResult;
        if (s.length() < 3) {
            return result;
        }
        int length = s.length();
        for (int i = length / 2; i < length - 1; i++) {
            if (s.charAt(i - 1) == s.charAt((i + 1))) {
                location.beginIndex = i - 1;
                location.endIndex = i + 1;
                scan(s, location);
                if (result.length() < s.substring(location.beginIndex, location.endIndex + 1).length()) {
                    result = s.substring(location.beginIndex, location.endIndex + 1);
                }
                if (location.endIndex == length - 1) {
                    break;
                }
            }
        }
        for (int i = length / 2; i > 0; i--) {
            if (s.charAt(i - 1) == s.charAt((i + 1))) {
                location.beginIndex = i - 1;
                location.endIndex = i + 1;
                scan(s, location);
                if (result.length() < s.substring(location.beginIndex, location.endIndex + 1).length()) {
                    result = s.substring(location.beginIndex, location.endIndex + 1);
                }
                if (location.beginIndex == 0) {
                    break;
                }


            }
        }

        return result;
    }



    String processingNonePoint(String s) {
        Location location = new Location();
        String result = s.substring(0, 1);
        int length = s.length();
        for (int i = length / 2; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt((i + 1))) {
                location.beginIndex = i;
                location.endIndex = i + 1;
                scan(s, location);
                if (result.length() < s.substring(location.beginIndex, location.endIndex + 1).length()) {
                    result = s.substring(location.beginIndex, location.endIndex + 1);
                }

                int palindromicLength = i - 1 - location.beginIndex + 1;
                if (location.endIndex == length - 1) {
                    break;
                }
            }
        }
        for (int i = length / 2; i > 0; i--) {
            if (s.charAt(i - 1) == s.charAt((i))) {
                location.beginIndex = i - 1;
                location.endIndex = i;
                scan(s, location);
                if (result.length() < s.substring(location.beginIndex, location.endIndex + 1).length()) {
                    result = s.substring(location.beginIndex, location.endIndex + 1);
                }
                if (location.beginIndex == 0) {
                    break;
                }
            }
        }

        return result;
    }
    void scan(String s, Location location) {
        if (location.beginIndex == 0 || location.endIndex == s.length() - 1) {
            return;
        }
        if (s.charAt(location.beginIndex - 1) == s.charAt(location.endIndex + 1)) {
            location.beginIndex -= 1;
            location.endIndex += 1;
            scan(s, location);
        }
    }
    static class Location {
        int beginIndex;
        int endIndex;
    }
}