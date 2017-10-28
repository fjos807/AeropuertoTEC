/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author frank
 */
public class Heap {
    static int i=0;
    public int[] heap;
    
    public Heap(){
        this.heap= new int[i];
    }
    /**
     *
     * @param elemento
     */
    public void insert (int elemento){
        this.push(elemento);
        this.reorderHeapFromBack(this.i-1);
    }
    public void removeRoot(){
        int elemento=this.heap[0];
        this.heap[0]=this.heap[i-1];
        this.heap[i-1]=elemento;
        this.pop();
        this.reorderheap();
    }
    public int parent(int pos){
            return (int) ((pos-1)/2);
    }
    public void swap(int pos1, int pos2){
        int padre = this.getElement(pos1);
        int hijo=this.getElement(pos2);
        this.heap[pos1]=hijo;
        this.heap[pos2]=padre;
    }
    public int getLeftChild(int pos){
        int hijo = (2*pos)+1;
        if (hijo<i){
            return hijo;
        }
        return pos;
    }
    public int getRightChild(int pos){
        int hijo = (2*pos)+2;
        if (hijo<i){
            return hijo;
        }
        return pos;
    }
    public void remove(int pos){
        int[] array=this.heap;
        this.heap=new int[i-1];
        for (int c=0;c<i-1;c++)
        { 
            if (c!=pos){
                this.heap[c]=array[c];
            }
        }
        this.heap[i-2]=array[i-1];
        this.i --;
    }
    public boolean isLeaf(int pos){
        int hijo=(2*pos)+1;
        if (hijo>=this.i){
            return false;
        }
        return true;
    }
    public void reorderHeapFromBack(int pos){
        int hijo_pos=pos;
        int padre_pos=this.parent(hijo_pos);
        int padre = this.getElement(padre_pos);
        int hijo=this.getElement(hijo_pos);
        while (hijo<padre){
            this.swap(padre_pos, hijo_pos);
            hijo_pos=padre_pos;
            padre_pos=this.parent(hijo_pos);
            hijo=this.getElement(hijo_pos);
            padre=this.getElement(padre_pos);
            }
    }
  
    public void reorderheap(){
        if (i>1){
            int padre_pos=0;
            int padre = this.getElement(padre_pos);
            int hijo_derecho_pos=this.getRightChild(0);
            int hijo_izquierdo_pos=this.getLeftChild(0);
            int hijo_derecho = this.getElement(hijo_derecho_pos);
            int hijo_izquierdo=this.getElement(hijo_izquierdo_pos);
            int hijo_menor=hijo_derecho;
            int hijo_menor_pos=hijo_derecho_pos;
            if (hijo_derecho>hijo_izquierdo){
                hijo_menor=hijo_izquierdo;
                hijo_menor_pos = hijo_izquierdo_pos;
            }
            while (hijo_menor<padre){
                this.swap(padre_pos, hijo_menor_pos);
                padre_pos=hijo_menor_pos;
                padre = this.getElement(padre_pos);
                hijo_derecho_pos=this.getRightChild(padre_pos);
                hijo_izquierdo_pos=this.getLeftChild(padre_pos);
                hijo_derecho = this.getElement(hijo_derecho_pos);
                hijo_izquierdo=this.getElement(hijo_izquierdo_pos);
                hijo_menor=hijo_derecho;
                hijo_menor_pos=hijo_derecho_pos;
                if (hijo_derecho>hijo_izquierdo){
                    hijo_menor=hijo_izquierdo;
                    hijo_menor_pos = hijo_izquierdo_pos;
                }
            }
        }
    }
    public void buildheap (int[] array){
        for(int c=0;c<array.length;c++)
        {
            Heap heap=new Heap();
            heap.insert(array[c]);
        }
    }
    public int getElement(int pos){
        return this.heap[pos];
    }
    public void push(int element){
        int[] array=this.heap;
        this.heap=new int[i+1];
        for (int c=0;c<i;c++)
        { 
            this.heap[c]=array[c];
        }
        this.heap[i]=element;
        this.i ++;
    }
    public void pop(){
        int[] array=this.heap;
        this.heap=new int[i-1];
        for (int c=0;c<i-1;c++)
        { 
            this.heap[c]=array[c];
        }
        this.i --;
    }
    public void print(){
        String text = "";
        for (int c=0;c<i-1;c++)
        {
            text+=String.valueOf(this.heap[c])+",";
            
        }
        text+=String.valueOf(this.heap[i-1]);
        System.out.print(text);
    }
    public static void main (String args[]){
    }
}
    