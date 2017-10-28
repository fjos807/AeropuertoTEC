/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
public class LQueue {
    private class Node {

        //atributos

        private Object element;
        private Node next;
        private Node previous;

        //Constructores
        public Node() {
            this.element = null;
            this.next = null;
            this.previous = null;
        }

        public Node(Object element) {
            this.element = element;
            this.next = null;
            this.previous= null;
        }

        public Node(Object element, Node next, Node previous) {
            this.element = element;
            this.next = next;
            this.previous= previous;
        }

        //m�todos

        public Object getElement() {
            return this.element;
        }

        public void setElement(Object element) {
            this.element = element;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
        public Node getPrevious() {
            return this.previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }
    }
    private Node front;
    private Node rear;
    private int size;
    
    public LQueue (){
        this.front= new Node();
        this.rear=this.front;
        this.size=0;
    }

    /**
     *
     * @param front
     */
    public LQueue (Node front){
        this.front= front;
        this.rear=this.front;
        this.size=0;
    }
    public void enqueueRear (Object element){
        this.rear.setNext(new Node (element));
        this.rear= this.rear.getNext();
        this.size++;
    }
    public Object dequeueFront (){
        if (this.size==0){
            System.out.println("Cola esta vacía");
            return null;
        }
        Node nTemp = this.front.getNext();
        Object elemento=nTemp.getElement();
        this.front.setNext(nTemp.getNext());
        if (this.rear==nTemp){
            this.rear=this.front;
        }
        this.size--;
        System.out.println(elemento);
        return elemento;
    }
    public Object first (){
        if (this.size==0){
            System.out.println("Cola vacía");
            return null;
        }
        return this.front.getNext().getElement();
    }
    public int size(){
        return this.size; 
    }
    public boolean isEmpty(){
        if (size==0){
            return true;
        }
        return false;
    }
    public void clear() {
        this.front = this.rear  = new Node();
        this.size = 0;
    }
    public void enqueueFront(Object  element){
        Node temp=this.front.getNext().getNext();
        this.front.getNext().setNext(new Node (element));
        this.front.getNext().getNext().setNext(temp);
        this.size++;
    }
    public Object dequeueRear (){
        if (this.size==0){
            System.out.println("Cola esta vacía");
            return null;
        }
        Node temp = this.front;
        while(temp.getNext()!=this.rear){
            temp=temp.getNext();
        }
        temp.setNext(null);
        Object elemento = this.rear.getElement();
        this.rear=temp;
        this.size--;
        return elemento;
    }
    public static void main(String args[]) {
    }
}
