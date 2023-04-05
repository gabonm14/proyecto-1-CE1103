/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dragueur.de.mines;

/**
 *
 * @author gabon
 */
public class Matriz {
    int size=8;
    private Celda[][] matriz;
    
    public Matriz(int total){
        matriz=new Celda[this.size][this.size];
        llenaMatriz(total);
    }
    
    public void llenaMatriz(int total){
        int cont=0;
        while(cont<total){
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    int rand= (int)(Math.random()*6+1);
                    if(rand>1){
                        if(this.matriz[i][j]==null){
                            this.matriz[i][j]=new Celda(false);
                        }
                    }else{
                        if(cont<total){
                            this.matriz[i][j]=new Celda(true);
                            cont++;
                        }
                        if(this.matriz[i][j]==null){
                            this.matriz[i][j]=new Celda(false);
                        }
                    }
                }
            }
        }
    }
    
    public boolean checkMate(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(!this.matriz[i][j].getActive()){
                    if(!this.matriz[i][j].getEstado()){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public Celda[][] getMatriz(){
        return this.matriz;
    }
    
    public void setMatriz(Celda[][] matriz){
        this.matriz=matriz;
    }
     
    
}
