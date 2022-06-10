package MiscellaneousProblems;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacter {

    public static int longestSubstringWithoutRepeatingCharacter(String s){
        int start =0;
        int end = 0;
        int max=0;

        HashSet<Character> hs= new HashSet();
        while(end<s.length()){
            if(!hs.contains(s.charAt(end))){
                hs.add(s.charAt(end));
                end++;
                max= Math.max(hs.size(),max);
            }else{
                hs.remove(s.charAt(start));
                start++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutRepeatingCharacter("hellogoodboyishere"));
    }
}
