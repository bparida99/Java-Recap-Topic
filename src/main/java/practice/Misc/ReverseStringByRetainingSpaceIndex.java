package practice.Misc;


import java.util.ArrayList;
import java.util.List;

public class ReverseStringByRetainingSpaceIndex {

    public static void main(String[] args) {
        //    Input: I live in India
        //    Output: a idnI ni evilI
        List<Integer> spaceIndex = new ArrayList<>();
        String s = "I live in India";
        StringBuilder rev = new StringBuilder();
        String res ="";
        int index =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                spaceIndex.add(index);
            }else{
                rev.append(s.charAt(i));
                index++;
            }
        }

        for(int i=0;i<rev.length();i++){
            if(spaceIndex.contains(i)){
                res = res+' '+rev.charAt(i);
            }else{
                res = res+rev.charAt(i);
            }
        }

        System.out.println(res);
    }
}
