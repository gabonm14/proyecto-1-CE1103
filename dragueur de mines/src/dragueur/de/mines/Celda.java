/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dragueur.de.mines;

/**
 *
 * @author gabon
 */
public class Celda {
    private boolean estado;
    private boolean active;
    private boolean flag;
    
    public Celda(boolean estado){
        this.estado=estado;
        this.active=false;
        this.flag=false;
    }
    
    public boolean getEstado(){
        return this.estado;
    }
    
    public boolean getActive(){
        return this.active;
    }
    
    public void setActive(){
        this.active=true;
    }
    
    public boolean getFlag(){
        return this.flag;
    }
    
    public void setFlag(boolean Flag){
        this.flag=flag;
    }
    
    public int getCelda(){
        if(estado){
            return 10;
        }else{
            return 0;
        }
    }
    
}
