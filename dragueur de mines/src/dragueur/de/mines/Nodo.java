/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dragueur.de.mines;

/**
 *
 * @author gabon
 */
public class Nodo {
    private Nodo next;
    private int i;
    private int j;
    private boolean isMine;
    
    public Nodo(int i,int j){
        this.i=i;
        this.j=j;
        this.next= null;
        this.isMine=false;
    }
    public void setNext(Nodo nodo){
        this.next=nodo;
    }
    
    public void setI(int i){
        this.i=i;
    }
    
    public void setJ(int j){
        this.j=j;
    }
    
    public Nodo getNext(){
        return this.next;
    }
    
    public int getI(){
        return this.i;
    }
    
    public int getJ(){
        return this.j;
    }
    
    public void setIsMina(){
        this.isMine=true;
    }
    
    public boolean getIsMine(){
        return this.isMine;
    }
}
    

