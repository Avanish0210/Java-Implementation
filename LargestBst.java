public class LargestBst {
    static class Node{
        int data ;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
        }
    }

    public static Node insert(Node root , int val){
        if(root == null){
            root= new Node(val);
            return root;
        }

        if(root.data > val){
            //left subtree
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }

        return root;
        
    }

    static class Info{
        int min;
        int max;
        int sz;
        Info(int min , int max , int sz){
            this.min = min;
            this.max = max;
            this.sz = sz;
        }
    }

    static Info helper(Node root){
        Info left = helper(root.left);
        Info right = helper(root.right);
        if(root.data > left.max && root.data < right.min){
            int currMin = Math.min(root.data, left.min);
            int currMax = Math.max(root.data, right.max);
            int currSz = left.sz + right.sz + 1;
            return Info(currMin , currMax , currSz);
        }

        return Info(Integer.MIN_VALUE , Integer.MAX_VALUE , Math.max(left.sz, right.sz));
    }
    int largestBSTinBT(Node root){
        return helper(root);
        

    }
    public static void main(String []args){

        Node root = new Node(10);
        root.left=new Node(5);
        root.right=new Node(15);
        root.left.left=new Node(1);
        root.left.right= new Node(8);
        root.right.right= new Node(7);


    }
    
}
