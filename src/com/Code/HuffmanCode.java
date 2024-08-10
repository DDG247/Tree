package com.Code;
import java.util.*;

public class HuffmanCode{
    public static void main(String[] args) {
        String str="i like like like java do you like a java";
        byte[] strBytes=str.getBytes();

    }
    static List<Node> getNodes(byte[] arr){
        List<Node> list=new ArrayList<Node>();
        Map<Byte,Integer> counts=new HashMap<>();
        for(byte b:arr){
                Integer count= counts.get(b);
                if(count==null){
                    counts.put(b,1);
                }else{
                    counts.put(b,count+1);
                }
        }
        for(Map.Entry<Byte,Integer> entry: counts.entrySet()){
            list.add(new Node(entry.getKey(), entry.getValue()));
        }
        return list;
    }
    static Node Creat(List<Node> list){
        while(list.size()>1){
            Collections.sort(list);
            Node left=list.get(0);
            Node right=list.get(1);
            Node root=new Node(null, left.key+ right.key);
            root.left=left;
            root.right=right;
            list.remove(0);
            list.remove(1);
            list.add(root);
        }
        return list.get(0);
    }
    static void preorder(Node root){
        if(root!=null){
            root.preOrder();
        }else{
            System.out.println("空");
        }
    }
}
class Node  implements Comparable<Node> {
    Byte data;
    int key;
    Node left;
    Node right;

    public Node(Byte data, int key) {
        this.data = data;
        this.key = key;
    }

    @Override
    public int compareTo(Node o) {
        return this.key-o.key;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", key=" + key +
                '}';
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
}
