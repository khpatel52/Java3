public class BinaryTree{
    private class Node{
        DataElement element;//value stores in the node. This case intElement
        Node left,right;//left and right child
        Node(DataElement val){
            left = null;
            right = null;
            element = val;
        }
        public Node(DataElement val, Node leftChild, Node rightChild){
            element = val;
            left = leftChild;
            right = rightChild;
        }
    }
    Node root = null;//Root of the binary tree
    int count;//number of nodes in the bst

    public void preorder(Node tree){
        if(tree != null){
            System.out.print(tree.element + "");//root first
            preorder(tree.left);
            preorder(tree.right);
        }
    }
    public void inorder(Node tree){
        if(tree != null){
            inorder(tree.left);
            System.out.println(tree.element + "");//root in between
            inorder(tree.right);
        }
    }
    public void postorder(Node tree){
        if(tree != null){
            postorder(tree.left);
            postorder(tree.right);
            System.out.print(tree.element + "");//root last
        }
    }
    public int treeNodeCount1(Node tree){//delete method after testing@@@@@@!!!
        if(tree != null){
            treeNodeCount1(tree.left);
            treeNodeCount1(tree.right);
            count++;
            return count;
        }
        return count;
    }
    private int recSize(Node tree){//helper method that returns the number of nodes
        if(tree == null)
            return 0;
        else
            return recSize(tree.left) + recSize(tree.right) + 1;
    }
    public int treeNodeCount(){//returns the number of nodes
        return recSize(root);
    }
    public boolean search(DataElement data){
        boolean found = false;
        Node curr;
        if(root == null) return false;
        else{
            curr = root;
            while(curr != null && !found){
                IntElement temp = (IntElement)curr.element;
                if(temp.equals(data))
                    found = true;
                else{
                    if(temp.compareTo(data) == 1)
                        curr = curr.left;
                    else
                        curr = curr.right;
                }
            }
        }
        return found;
    }
    public void insert(DataElement insertItem){
        Node newNode = new Node(insertItem.getCopy());
        Node curr;
        Node prev = null;
        if(root == null) root = newNode;
        else{
            curr = root;
            while(curr != null){
                prev = curr;
                IntElement temp = (IntElement)curr.element;
                if(temp.equals(insertItem)) return;
                else{
                    if(temp.compareTo(insertItem) > 0)
                        curr = curr.left;
                    else
                        curr = curr.right;
                }
            }
                IntElement temp1 = (IntElement)prev.element;
                if(temp1.compareTo(insertItem) > 0)
                    prev.left = newNode;
                else
                    prev.right = newNode;
            }
        
    }
    public void delete(IntElement data){
        boolean found = false;
        Node curr;
        Node prev = null;
        if(root == null) return;//nothing to delete
        else{
            curr = root;            
            while(curr != null && !found){
                prev = curr;
                IntElement temp = (IntElement)curr.element;
                if(temp.equals(data))
                    found = true;
                else{
                    if(temp.compareTo(data) == 1)
                        curr = curr.left;
                    else
                        curr = curr.right;
                }
            }
        }
        if(!found) return;//did not find matching node to be deleted
        //now testing the node curr with the 4 cases
        if(curr.left == null && curr.right == null){//case 1
            IntElement x = (IntElement)prev.element;
            if(x.compareTo(curr.element) > 0)//if parent greater than child
                prev.left = null;
            else
                prev.right = null;
        }
        else if(curr.left == null && curr.right != null){//case 2
            IntElement x = (IntElement)prev.element;
            if(x.compareTo(curr.element) > 0)//if parent greater than child and
                prev.left = curr.right;       //hence right of child
            else
                prev.right = curr.right;
        }
        else if(curr.right == null && curr.left != null){//case 3
            IntElement x = (IntElement)prev.element;
            if(x.compareTo(curr.element) > 0)//if parent greater than child
                prev.left = curr.left;
            else
                prev.right = curr.left;
        }
        else if(curr.right != null && curr.left != null){//case4
            Node current = curr.left;
            Node trailCurrent = null;
            while(current != null){//finding max value in left subtree which is
                trailCurrent = current;//the logical predecessor which is trailCurr
                current = current.right;
            }
            IntElement z = (IntElement)trailCurrent.element;
            int xy = z.getNum();
            ((IntElement)curr.element).setNum(xy);//swapping values
            //now deleting a node that has no right subtree
            while(curr != null){
                if(curr.right == null) curr = null;
                curr = curr.right;
            }

        }

    }
    public void printTreeStructure(){
        inorder(root);
    }
    public static void level(Node n)
    {
    level(n,0);
    }

    private static void level(Node n, int level)
    {
        if (n.left == null && n.right == null){
            IntElement temp = (IntElement)n.element;
            System.out.println(temp.getNum()+"=>"+level);
        }
        else
        {
            IntElement temp = (IntElement)n.element;
            System.out.println(temp.getNum()+"=>"+level+1);
            if (n.left != null)
                level(n.left, level+1);
            if (n.right != null)
                level(n.right, level+1);
        }

    }
    
}