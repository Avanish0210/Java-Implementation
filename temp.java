import java .util.*;
public class temp{
    static final int base = 256;
    static void search(String pattern ,  String text , int mod ){
        int m = pattern.length();
        int n = text.length();

        int p = 0;// hash value for pattern
        int t = 0;// hash value for text window

        for(int i=0; i<m; i++){
            p = (p*base + pattern.charAt(i))%mod;
        }
    }
    public static void main(String []args){
        
    }


}