import java.util.Iterator;

/**
 * TODO
 *
 * @author bobstone
 * @version 1.0
 * @date 2023/8/17 19:53
 */
public class Bag <Item> implements Iterable<Item> {

    private Node first;
    private int N;
    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty(){
        return first==null;
    }
    public int size(){
        return N;
    }
    public void add(Item item){
        Node oldfirst=first;
        first=new Node();//first并没有实例化,所以需要在这里实例化
        first.item=item;
        first.next=oldfirst;
        N++;
    }

    public Iterator<Item> iterator(){
        return new ListIterator();
    }
    public class ListIterator implements Iterator<Item>{
        private Node current=first;
        public boolean hasNext(){
            return current!=null;
        }
        public Item next(){
            Item item=current.item;
            current=current.next;
            return item;
        }
    }
}
