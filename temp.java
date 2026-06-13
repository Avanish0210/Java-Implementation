import java .util.*;
public class temp{
    static void perm(String str , String perm){
        if(str.length()==0){
            System.out.println(perm);
            return;
        }

        for(int i=0; i<str.length(); i++){
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i) +
                    str.substring(i + 1);
            perm(newStr , perm+currChar);
        }
    }
    public static void main(String[] args){
        perm("ABC" , "");
        String temp = "PQRSTU";
        System.out.println(temp.substring(0,1));
    }


}