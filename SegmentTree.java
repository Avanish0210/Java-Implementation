public class SegmentTree {
    //build Segment tree
    static void buildTree(int[] arr , int[] SegTree , int i , int l ,  int r){

        if(l==r){
            SegTree[i] = arr[l];
            return;
        }
        int mid = l + (r-l)/2;
        buildTree(arr, SegTree, 2*i+1, l, mid);
        buildTree(arr , SegTree , 2*i+2 , mid+1 , r);

        SegTree[i] = SegTree[2*i+1] + SegTree[2*i+2]; //we have taken sum because we are using sum query just for example, we can also take min or max depending on the query we want to perform
    }

    //Range sum query
    static int Query(int[] SegTree , int i , int l , int r , int st , int end){ //TC = O(log n)

        if(st>r || end<l){
            return 0; //we have taken 0 because we are using sum query just for example, we can also take min or max depending on the query we want to perform
        }
        if(st<=l && end>=r){
            return SegTree[i];
        }
        int mid = l + (r-l)/2;

        return Query(SegTree , 2*i+1 , l , mid , st , end) + 
                Query(SegTree , 2*i+2 , mid+1 , r , st , end);
    }

    //to update the value at index idx to val in segment tree
    static void updateSegTree(int[] SegTree , int idx , int val , int i , int l , int r ){

        if(l==r){
            SegTree[i] = val;
            return;
        }
        int mid = (l+r)/2;

        if(idx<=mid){//left Child
            updateSegTree(SegTree, idx, val, 2*i+1 , l, mid);
        }else{
            updateSegTree(SegTree, idx, val, 2*i+2 , mid+1, r);
        }

        SegTree[i] = SegTree[2*i+1] + SegTree[2*i+2]; //we have taken sum because we are using sum query just for example, we can also take min or max depending on the query we want to perform
    }

    public static void main(String[] args) {
        int n = 5; // n is the size of the input array
        int[] arr = {1, 2, 3, 4, 5}; // Example input array
        int[] SegTree = new int[4*n];
        buildTree(arr, SegTree, 0, 0, n-1);

        // Print the segment tree
        for (int i = 0; i < 4*n; i++) {
            System.out.print(SegTree[i] + " ");
        }
        System.out.println();

        // Example query: sum of elements from index 1 to 3
        int result = Query(SegTree, 0, 0, n-1, 1, 3);
        System.out.println("Sum of elements from index 1 to 3: " + result);
        // Example update: update index 2 to value 10
        updateSegTree(SegTree, 2, 10, 0, 0, n-1);
        // Print the segment tree after update
        for (int i = 0; i < 4*n; i++) {
            System.out.print(SegTree[i] + " ");
        }
    }
}
