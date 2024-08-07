public class Traversal {
    public static void main(String[] args) {
        System.out.println("oo");
    }
}
class Tree{
    Tree childL;
    Tree childR;
    int key;
    static void Preorder_Tree(Tree tree){
        if(tree==null){
            return;
        }
        System.out.println(tree.key);
        Preorder_Tree(tree.childL);
        Preorder_Tree(tree.childR);
    }
    static void Mediate_Tree(Tree tree){
        if(tree==null){
            return;
        }
        Preorder_Tree(tree.childL);
        System.out.println(tree.key);
        Preorder_Tree(tree.childR);
    }
    static void Post_Tree(Tree tree){
        if(tree==null){
            return;
        }
        Preorder_Tree(tree.childL);
        Preorder_Tree(tree.childR);
        System.out.println(tree.key);
    }

}