public class CPSolutionOfRabinKarp {
    static void rk(String s, String p){
        int n=s.length(), m=p.length();
        long mod=1000000007L, base=31, sh=0, ph=0, pow=1;

        for(int i=0;i<m;i++){
            ph=(ph*base+p.charAt(i))%mod;
            sh=(sh*base+s.charAt(i))%mod;
            if(i<m-1) pow=(pow*base)%mod;
        }

        for(int i=0;i<=n-m;i++){
            if(ph==sh && s.startsWith(p,i))
                System.out.print(i+" ");

            if(i<n-m){
                sh=((sh-s.charAt(i)*pow)%mod+mod)%mod;
                sh=(sh*base+s.charAt(i+m))%mod;
            }
        }
    }

    public static void main(String[] args) {
        String s = "ababcababc";
        String p = "abc";
        rk(s, p);
    }
}
