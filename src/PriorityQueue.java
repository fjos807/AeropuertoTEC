/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
public class PriorityQueue {
    private class NodeP {

        //atributos

        private LQueue cola;
        private NodeP next;
        private String etiqueta;

        //Constructores
        public NodeP() {
            this.setEtiqueta(null);
            this.cola=new LQueue();
            this.setNext(null);
        }
        public NodeP (String etiqueta){
            this.setEtiqueta(etiqueta);
            this.cola=new LQueue();
            this.setNext(null);
        }
        public NodeP (String etiqueta, LQueue cola){
            this.setEtiqueta(etiqueta);
            this.setCola(cola);
            this.setNext(null);
        }
        public NodeP(String etiqueta,LQueue cola, NodeP next) {
            this.setCola(cola);
            this.setEtiqueta(etiqueta);
            this.setNext(next);
        
    }
        public LQueue getCola() {
            return this.cola;
        }

        private void setCola(LQueue cola) {
            this.cola = cola;
        }

        public NodeP getNext() {
            return this.next;
        }

        private void setNext(NodeP next) {
            this.next = next;
        }
        public String getEtiqueta(){
            return this.etiqueta;
        }
        private void setEtiqueta(String etiqueta){
            this.etiqueta=etiqueta;
        }
    }
    private NodeP rear;
    private NodeP front;
    private int size;
    
    public PriorityQueue(){
        this.front = new NodeP();
        this.size = 0;
        this.rear = this.front;
    }
    public PriorityQueue (String etiqueta){
        this.front= new NodeP();
        this.rear=new NodeP(etiqueta);
        this.front.setNext(this.rear);
        this.size=1;
    }
    public void enqueue (Object element){
        this.rear.getCola().enqueueRear(element);
    }
    public void enqueueInEti(String etiqueta,Object element ){
        NodeP temp=this.front;
        while(temp.etiqueta!=etiqueta){
            temp=temp.getNext();
        }
        temp.getCola().enqueueRear(element);
    }
    public void enqueueEti(String etiqueta){
        NodeP nuevo = new NodeP(etiqueta);
        this.rear.setNext(nuevo);
        this.rear=this.rear.getNext();
    }
    public String dequeueEti(){
        String etiqueta = this.front.getNext().getEtiqueta();
        this.front.setNext(this.front.getNext().getNext());
//        System.out.println(etiqueta);
        return etiqueta;
    }
    public Object dequeueInEti(String etiqueta){
        NodeP temp=this.front;
        while(temp.etiqueta!=etiqueta){
            temp=temp.getNext();
        }
        return temp.getCola().dequeueFront();
    }
    public Object dequeue(){
        Object elemento=this.front.getNext().getCola().dequeueFront();
//        System.out.println(elemento);
        return elemento;
    }
    public Object first (){
        if (this.size==0){
            System.out.println("Cola vacía");
            return null;
        }
        return this.front.getNext().getCola().first();
    }
    public int size(){
        return this.size; 
    }
    public boolean isEmpty(){
        if (this.front.equals(this.rear)){
            return true;
        }
        return false;
    }
    public static void main (String args[]){
    }
}
