public class RabinKarpAlgo {
    static final int d = 256; // Number of characters in input alphabet

    static void search(String pattern , String text , int q){
        int m = pattern.length();
        int n = text.length();

        int p = 0;// hash value for pattern
        int t = 0;// hash value for text window
        int h = 1;

        for(int i=0; i<m-1; i++){
            h = (h*d)%q;
        }

        //calculate initial hash value
        for(int i=0; i<m; i++){
            p = (d*p + pattern.charAt(i))%q;
            t = (d*t + text.charAt(i))%q;
        }

        //slide pattern ocver text
        for(int i=0; i<=n-m; i++){
            //check hash match

            if(p==t){

                //verify characters one by one
                boolean match = true;
                for(int j=0; j<m; j++){
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if(match){
                    System.out.println("Pattern found at index " + i);
                }
            }

            // Calculate next window hash
            if (i < n - m) {
                t = (d * (t - text.charAt(i) * h)
                        + text.charAt(i + m)) % q;

                // Handle negative hash value
                if (t < 0)
                    t += q;
            }
        }

    }
    public static void main(String[] args) {
        String text = "ABCCDDAEFG";
        String pattern = "CDD";

        int prime = 101;

        search(pattern, text, prime);
    }
}
