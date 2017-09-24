package generics.stack;

/**
 * User: User
 * Date: 15.09.17
 * Time: 17:12
 */
public class LinkedStack<T> {
    private static class Node<U>{
        U item;
        Node<U> next;
        Node(){item = null ; next = null;}
        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }
        boolean end() {return  item == null && next == null;}
    }
    private Node<T> peek = new Node<T>(); // End sentinel
    public void push(T item){
        peek = new Node<T>(item, peek);
    }
    public T pop(){
        T result = peek.item;
        if(!peek.end())
            peek = peek.next;
        return result;
    }
    public static void main(String[] args){
        LinkedStack<String> lss = new LinkedStack<String>();
        for(String s : "Phasers on stun".split(" "))
            lss.push(s);
        String s;
        while ((s = lss.pop()) != null)
            System.out.println(s);

    }
}
