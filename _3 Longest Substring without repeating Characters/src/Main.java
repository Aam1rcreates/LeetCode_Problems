import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s = "abcabcd";
        //System.out.println(lengthOfSubString(s));
        System.out.println(lengthOfSubString2(s));

    }
    
    // Time: 0(n); Space: 0(n)
    private static int lengthOfSubString2(String s) {
        int maxLength = 0;
        Map<Character, Integer> visitedChar = new HashMap<>();
        for (int right = 0, left = 0; right < s.length(); right++) {
            // We will move left pointer only when the char repeats
            char currChar = s.charAt(right);
            if(visitedChar.containsKey(currChar) &&
                    visitedChar.get(currChar) >= left){
                left = visitedChar.get(currChar) + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            visitedChar.put(currChar, right);
        }
        return maxLength;
    }


    // Brute force Solution
    // Time: 0(n^2); n being length of the String s
    private static int lengthOfSubString(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder currSubstring = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                if(currSubstring.indexOf(String.valueOf(s.charAt(j))) != -1){
                    break;
                }
                currSubstring.append(s.charAt(j));
                maxLength = Math.max(maxLength, currSubstring.length());
            }
        }
        return maxLength;
    }
}
