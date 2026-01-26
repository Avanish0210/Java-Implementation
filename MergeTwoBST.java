import java.util.ArrayList;

public class MergeTwoBST {
    static class Node{
        int data;
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

    static void inorder(Node root , ArrayList<Integer> list){
        if(root==null) return;
        inorder(root.left , list);
        list.add(root.data);
        inorder(root.right , list);
    }

    static Node buildBst(int[] arr){
        Node root = null;

        for(int val : arr){
            root = insert(root, val);
        }
        return root;
    }

    static Node Merge(Node root1 , Node root2){
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        inorder(root1, list1);
        inorder(root2, list2);

        ArrayList<Integer> temp = new ArrayList<>();
        int i =0;
        int j = 0;
        while(i<list1.size() && j<list2.size()){
            if(list1.get(i) < list2.get(j)){
                temp.add(list1.get(i));
                i++;
            }else{
                temp.add(list2.get(j));
                j++;
            }
        }

        while(i<list1.size()) temp.add(list1.get(i++));
        while(j<list2.size()) temp.add(list2.get(j++));

        Node root = null;

        for(int val : temp){
            root = insert(root, val);
        }

        return root;



    }

    public static void main(String [] args){
        int[] arr1 = {8,2,1,10};
        int[] arr2 = {5,3,0};

        Node root1 = buildBst(arr1);
        Node root2 = buildBst(arr2);

        Node root = Merge(root1 , root2);
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        for(int v : list){
            System.out.print(v+" -> ");
        }

    }


    
}
