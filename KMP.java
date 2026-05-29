public class KMP{
    public static int[] buildlps(String pattern){
        int m = pattern.length();
        int[] lps = new int[m];

        int len = 0;
        int i= 1;

        while(i<m){
            if(pattern.charAt(i)==pattern.charAt(len)){
                len +=1;
                lps[i]=len;
                i+=1;
            }else{
                if(len!=0){
                    len=lps[len-1];
                }else{
                    lps[i]=0;
                    i+=1;
                }
            }
        }

        return lps;

    }
    public static void kmp(String text, String pattern){
        int[] lps = buildlps(pattern);
        int i= 0; //text
        int j=0;  //pattern

        while(i<text.length()){
            if(text.charAt(i)==pattern.charAt(j)){
                i+=1;
                j+=1;
            }
            if(j==pattern.length()){
                System.out.println("Pattern found at index " + (i-j));
                j=lps[j-1];
            }else if(i<text.length() && text.charAt(i)!=pattern.charAt(j)){
                if(j!=0){
                    j=lps[j-1];
                }else{
                    i+=1;
                }
            }
        }


    }

    public static void main(String[] args) {
        String pattern = "ababc";
        int[] lps = buildlps(pattern);
        for(int i=0; i<lps.length; i++){
            System.out.print(lps[i]+" ");
        }
    }
}