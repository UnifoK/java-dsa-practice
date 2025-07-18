import java.util.HashSet;
import java.util.Set;

public class longestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, maxL = 0, temp = 0;
        Set<Character> set = new HashSet<>();
        for (right = 0; right < s.length(); right++) {

            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            maxL=Math.max(maxL,right-left+1);

        }
        return maxL;
    }

    public static void main(String[] args) {

        longestSubstring ls = new longestSubstring();
        System.out.println(ls.lengthOfLongestSubstring("abcabcbb"));
    }


}
