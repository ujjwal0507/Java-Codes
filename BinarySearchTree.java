import java.util.*;

public class BinarySearchTree {
    TreeNode root;
    
    BinarySearchTree(){
        root = null;
    }

    public boolean search(int value){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.remove();
            if(curr==null)
                return false;
            System.out.print(curr.data+" ");
            if(curr.data==value)
                return true;
            else if(value<curr.data)
                queue.add(curr.left);
            else if(value>curr.data)
                queue.add(curr.right);
        }
        return false;
    }

    public void inOrder(TreeNode root){
        if(root==null)
            return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public boolean search1(TreeNode root, int value){
        if(root==null)
            return false;
        if(root.data==value)
            return true;
        else if(root.data<value)
            return search1(root.right, value);
        else
            return search1(root.left, value);
    }

    public void insert(int value){
        TreeNode node = new TreeNode(value, null);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(true){
            TreeNode curr = queue.remove();
            if(curr.data>value){
                if(curr.left==null){
                    curr.left = node;
                    break;
                }
                else
                    queue.add(curr.left);
            }
            else{
                if(curr.right==null){
                    curr.right = node;
                    break;
                }
                else
                    queue.add(curr.right);
            }
        }
    }

    public int getMin(TreeNode root){
        int val = root.data;
        while(root.left!=null){
            val = root.left.data;
            root = root.left;
        }
        return val;
    }

    public void delete(int data){
        root = delete(this.root, data);
    }

    public TreeNode delete(TreeNode root, int value){
        if(root==null)
            return root;
        if(value<root.data)
            root.left = delete(root.left, value);
        else if(value>root.data)
            root.right = delete(root.right, value);
        else{
            if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;
            root.data = getMin(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    public boolean isBinaryTree(){
        return isBinaryTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBinaryTree(TreeNode root, int min, int max){
        if(root==null)
            return true;
        if(root.data<min || root.data>max)
            return false;
        return isBinaryTree(root.left, min, root.data) && isBinaryTree(root.right, root.data, max);
    }

    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = new TreeNode(6, null);
        tree.root.left = new TreeNode(3, null);
        tree.root.right = new TreeNode(9, null);
        tree.root.left.left = new TreeNode(1, null);
        tree.root.left.right = new TreeNode(4, null);
        tree.root.right.left = new TreeNode(8, null);
        tree.root.right.right = new TreeNode(10, null);
        tree.insert(7);
        /*tree.inOrder(tree.root);
        tree.delete(6);
        System.out.println();
        tree.inOrder(tree.root);
        */
        System.out.println(tree.isBinaryTree());
    }
}