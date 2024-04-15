package tree;

/**
 * TODO
 *
 * @author bobstone
 * @version 1.0
 * @date 2023/3/22 10:35
 */
public class BinaryTree<T> {

    public static class Node<T> {

        private Node lNode;
        private Node rNode;
        private T data;

        public Node(T data) {
            this.data=data;
        }
        //构造一个新结点，该结点以lNode结点为其左孩子，rNode结点为其右孩子
        public Node(Node lNode,Node rNode,T data) {
            this.lNode=lNode;
            this.rNode=rNode;
            this.data=data;
        }
    }

    private Node root;//用一个根结点来表示二叉树
    public BinaryTree(T data) {
        this.root=new Node(data);
    }

}
