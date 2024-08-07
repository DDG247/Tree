public class ThreadedBinaryTree {
    int data;
    ThreadedBinaryTree left = null;
    ThreadedBinaryTree right = null;
    int Ltag, Rtag;
    ThreadedBinaryTree pre = null;
    void ThreadedBinaryTreeCreat(ThreadedBinaryTree node){
        ThreadedBinaryTreeCreat(node.left);
        if(node.left==null){
            node.left=pre;
            node.Ltag=1;
        }
        if(pre!=null&&pre.right==null){
            pre.right=node;
            pre.Rtag=1;
        }
        pre=node;
        ThreadedBinaryTreeCreat(node.right);
    }

    void ThreadedBinaryTreeTraverse(ThreadedBinaryTree node){
        while(node!=null){
            while(node.Ltag==0){
                node=node.left;
            }
            System.out.println(node);
            while(node.Rtag==1){
                node=node.right;
                System.out.println(node);
            }
            node=node.right;
        }
    }
}

