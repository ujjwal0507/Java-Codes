import java.util.*;

public class ConstructBinaryTree{

    public TreeNode constructPreOrder(int[] preOrder, int[] inOrder){
        return constructPreOrder(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1);
    }

    public TreeNode constructPreOrder(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd){
        if(inStart>inEnd || preStart>preEnd)
            return null;
        TreeNode cur = new TreeNode(preOrder[preStart], null);
        int offset = inStart;
        for(;offset<inEnd;offset++)
            if(cur.data==inOrder[offset])
                break;
        cur.left = constructPreOrder(preOrder, preStart+1, preStart+offset-inStart, inOrder, inStart, offset-1);
        cur.right = constructPreOrder(preOrder, preStart+offset-inStart+1, preEnd, inOrder, offset+1, inEnd);
        return cur;
    }

    public void preOrder(TreeNode root){
        if(root==null)
            return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(TreeNode root){
        if(root==null)
            return;
        preOrder(root.left);
        System.out.print(root.data+" ");
        preOrder(root.right);
    }

    public void levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node!=null){
                System.out.print(node.data+" ");
                queue.add(node.left);
                queue.add(node.right);
            }
        }
    }

    public TreeNode constructPostOrder(int[] postOrder, int[] inOrder){
        return constructPostOrder(postOrder, 0, postOrder.length-1,inOrder, 0, inOrder.length);
    }

    public TreeNode constructPostOrder(int[] postOrder, int postStart, int postEnd, int[] inOrder, int inStart, int inEnd){
        if(inStart>inEnd || postStart>postEnd)
            return null;
        TreeNode node = new TreeNode(postOrder[postEnd], null);
        int index = inStart;
        for(;index<=inEnd;index++)
            if(inOrder[index]==node.data)
                break;
        node.left = constructPostOrder(postOrder, postEnd-index+inStart, postEnd-1, inOrder, inStart, index-1);
        node.left = constructPostOrder(postOrder, postStart, postEnd-index+inStart-1, inOrder, index+1, inEnd);
        return node;
    }   

    public static void main(String[] args){
        int pre[] = {1 ,2 ,4 ,5 ,3 ,6 ,7};
        int in[] = {4 ,2 ,5 ,1 ,6 ,3 ,7};
        int post[] = {4 ,5 ,2 ,6 ,7 ,3 ,1 };
        ConstructBinaryTree cons = new ConstructBinaryTree();
        TreeNode preNode = cons.constructPreOrder(pre, in);
        cons.levelOrder(preNode);
        TreeNode postNode = cons.constructPostOrder(post, in);
        cons.levelOrder(postNode);
    }   
}