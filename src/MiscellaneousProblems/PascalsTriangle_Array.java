package MiscellaneousProblems;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_Array {

    public static List<List<Integer>> generate (int numRows){
        List<List<Integer>> result = new ArrayList();
        for(int i=0; i<numRows; i++){
            List temp = new ArrayList<>();
            for(int j = 0; j<=i; j++){
                if(j == 0 || j == i){
                    temp.add(1);
                }
                else{
                    temp.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
                }
            }
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
