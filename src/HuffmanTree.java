import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 4, 3, 9, 6, 43, 55};
        Node root=Creat(arr);
        preOrder(root);
    }
    static void preOrder(Node root){
        if(root!=null){
            root.preOrder();
        }else{
            System.out.println("空");
        }
    }
     static Node Creat(int[] arr) {
        List<Node> list = new ArrayList<>();
            for (int key : arr) {
                list.add(new Node(key));
            }
        while (list.size() > 1) {
            Collections.sort(list);
            Node left = list.get(0);
            Node right = list.get(1);
            Node parent = new Node(left.key + right.key);
            parent.left = left;
            parent.right = right;
            list.remove(left);
            list.remove(right);
            list.add(parent);

        }
        return list.get(0);
    }
}

class Node implements Comparable<Node> {
    int key;
    Node left;
    Node right;

    Node(int key) {
        this.key = key;
    }
    void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }
    @Override
    public int compareTo(Node o) {
        return this.key - o.key;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                '}';
    }
}