public class RabinKarpAlgo {
    static final int base = 256; // Number of characters in input alphabet

    static void search(String pattern , String text){
        int m = pattern.length();
        int n = text.length();

        int p = 0;// hash value for pattern
        int t = 0;// hash value for text window
        int h = 1;
        int mod = 101; // A prime number

        for(int i=0; i<m-1; i++){
            h = (h*base)%mod;
        }

        //calculate initial hash value
        for(int i=0; i<m; i++){
            p = (base*p + pattern.charAt(i))%mod;
            t = (base*t + text.charAt(i))%mod;
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
                t = (t - text.charAt(i) * h) % mod;
                t = (t * 256 + text.charAt(i+m))%mod;

                // Handle negative hash value
                if (t < 0)
                    t += mod;
            }
        }

    }
    public static void main(String[] args) {
        String text = "ABCCDDAEFG";
        String pattern = "CDD";

        search(pattern, text);
    }
}
