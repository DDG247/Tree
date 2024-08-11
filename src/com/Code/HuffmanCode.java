package com.Code;

import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
    byte[] bytes=huffmanZip(str);
        System.out.println(Arrays.toString(bytes));
    }
    //封装赫夫曼编码
    static byte[] huffmanZip(String str){
        byte[] strByte=str.getBytes();
        List<Node> nodes=getNodes(strByte);
        Node root=CreatTree(nodes);
        Map<Byte,String> huffmanCodes=CreatCode(root);
        return zip(strByte,huffmanCodes);
    }

    static List<Node> getNodes(byte[] arr) {
        List<Node> list = new ArrayList<>();
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : arr) {
            counts.merge(b, 1, Integer::sum);
        }
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            list.add(new Node(entry.getKey(), entry.getValue()));
        }
        return list;
    }

    static Node CreatTree(List<Node> list) {
        while (list.size() > 1) {
            Collections.sort(list);
            Node left = list.get(0);
            Node right = list.get(1);
            Node root = new Node(null, left.key + right.key);
            root.left = left;
            root.right = right;
            list.remove(left);
            list.remove(right);
            list.add(root);
        }
        return list.get(0);
    }

    static Map<Byte, String> huffmancode = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();

    static void CreatCode(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if (node != null) {
            if (node.data == null) {
                CreatCode(node.left, "0", stringBuilder2);
                CreatCode(node.right, "1", stringBuilder2);
            } else {
                huffmancode.put(node.data, stringBuilder2.toString());
            }
        }
    }

    //重载编码实现
    static Map<Byte, String> CreatCode(Node root) {
        if (root == null) {
            return null;
        }
        CreatCode(root.left, "0", stringBuilder);
        CreatCode(root.right, "1", stringBuilder);
        return huffmancode;
    }

    static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        int len = (stringBuilder.length() + 7) / 8;
        byte[] by = new byte[len];
        int index=0;
        for (int i = 0; i < stringBuilder.length(); i+=8) {
            String str;
            if(i+8>stringBuilder.length()){
                str=stringBuilder.substring(i);
            }else {
                str = stringBuilder.substring(i, i + 8);
            }
            by[index]=(byte) Integer.parseInt(str,2);
            index++;
        }
        return by;
    }

    static void preorder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("空");
        }
    }
}

class Node implements Comparable<Node> {
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
        return this.key - o.key;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", key=" + key +
                '}';
    }

    void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
