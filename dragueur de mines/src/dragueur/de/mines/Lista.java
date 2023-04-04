/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dragueur.de.mines;

/**
 *
 * @author gabon
 */
public class Lista {
    private int size;
    private Nodo head;
    
    public Lista(){
        this.size=0;
        this.head=null;
    }
    
    public void deleteList(){
        this.head=null;
        this.size=0;
    }
    
    public void add(Nodo nodo){
        if(this.head==null){
            this.head=nodo;
        }else{
            Nodo temp=this.head;
            while(temp.getNext()!=null){
                temp=temp.getNext();
            }
            temp.setNext(nodo);
        }
        this.size++;
    }
    
    public void delete(Nodo nodo){
        if(this.head==nodo){
            this.head=nodo.getNext();
        }else{
            Nodo temp=this.head;
            while(temp.getNext()!=nodo){
                temp=temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
        this.size--;
    }
    
    public Nodo buscar(int i, int j){
        Nodo temp=this.head;
        while(temp!=null){
            if(temp.getI()==i&&temp.getJ()==j){
                return temp;
            }else{
                temp=temp.getNext();
            }
        }
        return null;
    }
    
    public Nodo buscarAleatorio(){
        int contador=0;
        int b= (int)(Math.random()*this.size);
        Nodo temp=this.head;
        while(b!=contador){
           temp=temp.getNext();
           contador++;
        }
        return temp;
    }
    
    public void setHead(Nodo nodo){
        this.head=nodo;
    }
    
    public Nodo getHead(){
        return this.head;
    }
    
    public void setSize(int size){
        this.size=size;
    }
    
    public int getSize(){
        return this.size;
    }    
    
}
