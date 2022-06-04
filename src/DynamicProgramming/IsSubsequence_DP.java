package DynamicProgramming;

public class IsSubsequence_DP {
    public static boolean isSubsequence(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int i = 0;
        int j = 0;
        while(i<sLength && j< tLength){
            if(t.charAt(j) == s.charAt(i)){
                i++;
            }
            j++;
        }

        return i == sLength;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abcde","anhxdbcjkjkcduipoiuipwsre"));
    }
}

