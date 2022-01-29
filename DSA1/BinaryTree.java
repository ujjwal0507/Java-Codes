import java.util.*;

class TreeNode{
    int data;
    TreeNode parent;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data, TreeNode parent){
        this.data = data;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree{
    TreeNode root;
    boolean inserted = false;
    Map<TreeNode, Integer> map = new HashMap<>();

    public void preOrder(){
        System.out.print("Pre Order Traversal: ");
        preOrder(this.root);
        System.out.println();
    }

    public void preOrder(TreeNode root){
        if(root==null)
            return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(){
        System.out.print("Post Order Traversal: ");
        postOrder(this.root);
        System.out.println();
    }

    public void postOrder(TreeNode root){
        if(root==null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public void inOrder(){
        System.out.print("In Order Traversal: ");
        inOrder(this.root);
        System.out.println();
    }

    public void inOrder(TreeNode root){
        if(root==null)
            return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public void getHeight(){
        System.out.println("The height of the formed Binary Tree is: "+this.getHeight(this.root));
    }

    public int getHeight(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }

    public void queuedLevelOrderTraversal(){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        System.out.print("Queued Level Order Traversal of the Tree: ");
        while(!queue.isEmpty()){
            TreeNode curr = queue.remove();
            if(curr!=null){
                System.out.print(curr.data+" ");
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        System.out.println();
    }

    public void printAtLevel(TreeNode root, int level){
        if(root==null)
            return;
        else if(level==1)
            System.out.print(root.data+" ");
        printAtLevel(root.left, level-1);
        printAtLevel(root.right, level-1);
    }

    public void recursiveLevelOrderTraversal(){
        System.out.print("Recursively Level Order Traversal of the tree: ");
        for(int i=1;i<=this.getHeight(root);i++){
            printAtLevel(root, i);
        }
        System.out.println();
    }

    public int getMax(){
        int max = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this.root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.remove();
            if(curr!=null){
                if(curr.data>max)
                    max = curr.data;
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        return max;
    }
    
    public int sizeOfTree(TreeNode node){
        if(node==null)
            return 0;
        return 1+sizeOfTree(node.left)+sizeOfTree(node.right);
    }

    public void insertQueue(int data){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this.root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.remove();
            if(curr!=null){
                if(curr.left==null){
                    curr.left = new TreeNode(data, curr);
                    break;
                }
                else if(curr.right==null){
                    curr.right = new TreeNode(data, curr);
                    break;
                }
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        queuedLevelOrderTraversal();
    }

    public void insertRecursive(int data){
        insertRecursive(root, data);
        inserted = false;
        queuedLevelOrderTraversal();
    }

    public void insertRecursive(TreeNode root, int data){
        if(inserted==true || root==null)
            return;
        else if(root.left==null){
            root.left = new TreeNode(data, root);
            inserted = true;
        }
        else if(root.right==null){
            root.right = new TreeNode(data, root);
            inserted = true;
        }
        else{
            insertRecursive(root.left, data);
            insertRecursive(root.right, data);
        }
    }

    public int giveAtLevel(int level){
        return countAtLevel(this.root, level, 0);
    }

    public int countAtLevel(TreeNode root, int level, int count){
        if(root==null)
            return 0;
        else if(level==1)
            return count+1;
            
        return countAtLevel(root.left,level-1,0)+countAtLevel(root.right, level-1, 0);
    }

    public void getWidthOfTree(){
        int max = 0;
        for(int i=1;i<=this.getHeight(this.root);i++){
            int curr = this.giveAtLevel(i);
            if(curr>max)
                max = curr;
        }
        System.out.println("The width of the tree: "+max);
    }

    public int maxAtLevel(){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> res  = new LinkedList<TreeNode>();
        int max = 0;
        queue.add(this.root);
        queue.add(null);
        int curr = 0;
        while(!queue.isEmpty()){
            TreeNode cur = queue.remove();
            res.add(cur);
            if(cur!=null){
                curr+=cur.data;
                if(cur.left!=null)
                    queue.add(cur.left);
                if(cur.right!=null)
                    queue.add(cur.right);
            }
            else{
                if(curr>max){
                    max = curr;
                }
                curr = 0;
                if(!queue.isEmpty())
                    queue.add(null);
            }
        }
        System.out.println(res);
        return max;
    }

    public void printAllPaths(){
        int[] path = new int[100];
        printAllPaths(this.root, path, 0);
    }

    public void printAllPaths(TreeNode root, int[] path, int pathLength){
        if(root==null)
            return;
        path[pathLength] = root.data;
        pathLength++;
        if(root.left==null && root.right==null){
            System.out.print(path[0]);
            for(int i=1;i<pathLength;i++){
                System.out.print("->"+path[i]);
            }
            System.out.println();
        }
        printAllPaths(root.left, path, pathLength);
        printAllPaths(root.right, path, pathLength);
    }

    public void printAncestors(int data){
        int[] ances = new int[100];
        System.out.print("Ancestors of "+data+" are: ");
        printAncestors(root, data, ances, 0);
        System.out.println();
    }

    public void printAncestors(TreeNode root, int data, int[] ances, int ancesCount){
        if(root!=null){
            ances[ancesCount++] = root.data;
            if(root.data==data){
                for(int i=0;i<ancesCount;i++){
                    System.out.print(ances[i]+" ");
                }
            }
            printAncestors(root.left, data, ances, ancesCount);
            printAncestors(root.right, data, ances, ancesCount);
        }
    }

    public void zigZagTraversal(){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> seq = new LinkedList<TreeNode>();
        queue.add(this.root);
        queue.add(null);
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            seq.add(node);
            if(node!=null){
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            else{        
                if(!queue.isEmpty()){
                    queue.add(null);
                }
            }
        }   
    }

    public void horizontalDistance(TreeNode root){
        if(map.isEmpty()){
            map.put(root, 0);
        }
        if(root==null)
            return;
        if(root.left!=null){
            map.put(root.left, map.get(root)-1);
        }
        if(root.right!=null)
            map.put(root.right, map.get(root)+1);
        horizontalDistance(root.left);
        horizontalDistance(root.right);
    }

    public void createMap(TreeNode root, int hd){
        if(root!=null){
            map.put(root, hd);
            createMap(root.left, hd-1);
            createMap(root.right, hd+1);
        }
    }

    public void printMap(){
        System.out.println("Horizontal Distance of all the nodes: ");
        for(Map.Entry<TreeNode, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey().data+" "+entry.getValue());
        }
    }

    public void verticalOrder(){
        this.createMap(this.root, 0);
        List<Map.Entry<TreeNode, Integer>> list = new ArrayList<>();
        for(Map.Entry<TreeNode, Integer> entry: map.entrySet()){
            list.add(entry);
        }
        Collections.sort(list, new Comparator<Map.Entry<TreeNode, Integer>>(){
            public int compare(Map.Entry<TreeNode, Integer> entry1, Map.Entry<TreeNode, Integer> entry2){
                if(entry1.getValue()<entry2.getValue())
                    return -1;
                if(entry1.getValue()>entry2.getValue())
                    return 1;
                else
                    return 0;
            }
        });
        System.out.print("Vertical Order Traversal of the tree: ");
        for(Map.Entry<TreeNode, Integer> entry: list){
            System.out.print(entry.getKey().data+" ");
        }
        System.out.println();
    }

    public TreeNode buildBST(int[] arr, int start, int end){
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(arr[mid], null);
        if(start==mid)
            return node;
        node.left = buildBST(arr, start, mid-1);
        node.right = buildBST(arr, mid+1, end);
        return node;
    } 

    public void buildBST(int[] arr){
        TreeNode built = buildBST(arr, 0, arr.length);
        preOrder(built);
    }    


    public void mirror(TreeNode node){
        if(node==null)
            return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        mirror(node.left);
        mirror(node.right);
        
    }
    
    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1, null);
        tree.root.left = new TreeNode(2, tree.root);
        tree.root.right = new TreeNode(3, tree.root);
        tree.root.left.left = new TreeNode(4, tree.root.left);
        tree.root.left.right = new TreeNode(5, tree.root.left);
        tree.root.right.left = new TreeNode(6, tree.root.right);
        tree.root.right.right = new TreeNode(7, tree.root.right);
        tree.root.right.right.right = new TreeNode(8, tree.root.right.right);
        tree.root.right.right.right.right = new TreeNode(9, tree.root.right.right.right);
        /*tree.preOrder();
        tree.postOrder();
        tree.inOrder();
        tree.getHeight();
        tree.queuedLevelOrderTraversal();
        tree.recursiveLevelOrderTraversal();
        tree.getWidthOfTree();
        System.out.println("Maximum at a level: "+tree.maxAtLevel());
        */
        tree.queuedLevelOrderTraversal();
        tree.mirror(tree.root);
        tree.queuedLevelOrderTraversal();
    }
}