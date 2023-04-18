/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package dragueur.de.mines;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author gabon
 */
public class DummyController implements Initializable {
    
    private int total=8;
    
    private int leftMines= this.total;
    
    private int turno= 0;
    
    private Matriz juego;
    
    private boolean lost;
            
    @FXML
    private Label lblminas;
    @FXML
    private Label lbltime;
    @FXML
    private GridPane tabla;
    @FXML
    private Label lblwinlose;
    @FXML
    private Button btnpista;
    @FXML
    private Label lblpista;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.juego = new Matriz (this.total);
        this.lblminas.setText(String.valueOf(this.total));
        
        game();
        
    } 
    
    public void game(){
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                Button btn=new Button(" ");
                btn.setPrefSize(50,50);
                
                int x= i;
                int y= j;
                btn.setId("botonxd");
                btn.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    
                    @Override
                    public void handle(MouseEvent event){
                        
                        if(event.getButton()==MouseButton.PRIMARY){
                            revisa(x,y,true,0);
                }
                        if (event.getButton()==MouseButton.SECONDARY){
                            update(x,y,false);
                }
                    }
                });
                tabla.add(btn,i,j);
            }
                       
        }
    }
    
    public void revisa(int x, int y, boolean partida, int jugador){
        if (partida &&jugador==0){
            this.turno ++;
        }
        Label lbl= new Label("");
        int cantidad= this.juego.getMatriz()[x][y].getCelda();
        
        boolean active =! this.juego.getMatriz()[x][y].getActive();
        
        if (cantidad== 10&&active){
            for (final Node node : this.tabla.getChildren()){
                if (GridPane.getRowIndex(node)!=null &&GridPane.getColumnIndex(node)!=null){
                    if(GridPane.getRowIndex(node)== y && GridPane.getColumnIndex(node)==x){
                        node.setDisable(true);
                        
                        if(!this.juego.getMatriz()[x][y].getFlag()&&jugador==0){
                            lbl.setText("m");
                         
                            
                        }else{
                            lbl.setText("O");
                        }
                        lbl.setAlignment(Pos.CENTER);
                        
                        if (partida){
                            if (jugador == 0){
                                lbl.setTextFill(Color.GREEN);
                                
                                lblwinlose.setText("Computer Wins");
                                
                            }else{
                                lbl.setTextFill(Color.RED);
                                lblwinlose.setText("You win");
                            }
                        }
                        this.tabla.add(lbl,x,y);
                        GridPane.setHalignment(lbl,HPos.CENTER);
                        this.juego.getMatriz()[x][y].setActive();
                        this.lost= false;
                        
                        for (int i=0;i<8;i++){
                            for (int j=0;j>8;j++){
                                if (partida){
                                    for (final Node node2 : this.tabla.getChildren()){
                                        if (GridPane.getColumnIndex(node2)!= null&&GridPane.getRowIndex(node2)!=null){
                                            if (node2 instanceof Button){
                                                node2.setVisible(false);
                                                
                                            }
                                        }
                                    }
                                    revisa(i,j,false,jugador);
                                }
                            }
                            
                        }
                        break;
                                
                    }
                }
                 
            }
            
        }else{
            if(active){
                try{
                    if(this.juego.getMatriz()[x+1][y+1].getEstado()){
                        cantidad++;
                    }
                }catch(ArrayIndexOutOfBoundsException exception){
                }
                try{
                    if(this.juego.getMatriz()[x][y+1].getEstado()){
                        cantidad++;
                    }
                }catch(ArrayIndexOutOfBoundsException exception){
                }
                try{
                    if(this.juego.getMatriz()[x-1][y+1].getEstado()){
                        cantidad++;
                    }
                }catch(ArrayIndexOutOfBoundsException exception){
                }
                try{
                    if(this.juego.getMatriz()[x+1][y].getEstado()){
                        cantidad++;
                    }
                }catch(ArrayIndexOutOfBoundsException exception){
                    
                }
                try{
                    if(this.juego.getMatriz()[x-1][y].getEstado()){
                        cantidad++;
                    }
                }catch(ArrayIndexOutOfBoundsException exception){
                    
                }
                try{
                    if(this.juego.getMatriz()[x+1][y-1].getEstado()){
                        cantidad++;
                    }
                }catch(ArrayIndexOutOfBoundsException exception){
                    
                }
                try{
                    if(this.juego.getMatriz()[x][y-1].getEstado()){
                        cantidad++;
                    }
                }catch(ArrayIndexOutOfBoundsException exception){
                    
                }
                try{
                    if(this.juego.getMatriz()[x-1][y-1].getEstado()){
                        cantidad++;
                    }
                }catch(ArrayIndexOutOfBoundsException exception){
                
            }
            for (final Node node : this.tabla.getChildren()){
                if (GridPane.getColumnIndex(node)!=null && GridPane.getRowIndex(node)!=null){
                    if (GridPane.getColumnIndex(node)==x && GridPane.getRowIndex(node)==y){
                        node.setVisible(false);
                        
                        for (final Node node2 : this.tabla.getChildren()){
                            if (GridPane.getColumnIndex(node2)!=null && GridPane.getRowIndex(node2)!=null){
                                if (GridPane.getColumnIndex(node2)==x && GridPane.getRowIndex(node2)==y){
                                    if (node2 instanceof Button){
                                        if (node2.getId().equalsIgnoreCase("flag")){
                                            this.leftMines++;
                                        }
                                        
                                        this.lblminas.setText(String.valueOf(this.leftMines));
                                        node2.setVisible(false);
                                        
                                    }
                                }
                            }
                        }
                        
                        node.setVisible(false);
                        this.juego.getMatriz()[x][y].setActive();
                        if (cantidad==0){
                            if (partida){
                                lbl.setText("X");
                                
                                
                            }else{
                                lbl.setText("");
                                
                            }
                        }else{
                            lbl.setText(String.valueOf(cantidad));
                        }
                        lbl.setAlignment(Pos.CENTER);
                        
                        if (partida){
                            if (jugador==0){
                                lbl.setTextFill(Color.GREEN);
                                
                            }else{
                                lbl.setTextFill(Color.RED);
                              
                            }
                        }
                        this.tabla.add(lbl,x,y);
                        GridPane.setHalignment(lbl,HPos.CENTER);
                        if(cantidad==0){
                            for (int i=(x-1);i<=(x+1);i++){
                                for (int j=(y-1);j<(y+1);j++){
                                    
                                    try{
                                        revisa(i,j,false,0);
                                        
                                    }catch(ArrayIndexOutOfBoundsException exception){
                                        
                                    }
                                }
                            }
                        }
                        break;
                    }
                }
            }
            
        }
        
        
        
    }
    if (this.juego.checkMate()&&!this.lost){
        lblwinlose.setText("You win");
        for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    
                    if(this.juego.getMatriz()[i][j].getEstado()){
                        lbl=new Label("M");
                        
                        lbl.setAlignment(Pos.CENTER);
                        
                        this.tabla.add(lbl, i, j);
                        GridPane.setHalignment(lbl, HPos.CENTER);
                        
                    }
                }
            }
            for (final Node node : this.tabla.getChildren()){
                if (GridPane.getColumnIndex(node)!=null &&GridPane.getRowIndex(node)!=null){
                    if (node instanceof Button){
                        node.setVisible(false);
                    }
                }
            }
        
    }
    
    if (!this.lost&&jugador==0 &&partida){
        pcGame();
        
    }
    
    
    }
    public void update(int x, int y, boolean isFlag){
        if (isFlag){
            this.leftMines++;
            
        }else{
            this.leftMines--;
            
        }
        lblminas.setText(String.valueOf(this.leftMines));
        
        for (final Node node : this.tabla.getChildren()){
            if (GridPane.getColumnIndex(node)!= null&&GridPane.getRowIndex(node)!=null){
                if (GridPane.getColumnIndex(node)== x&&GridPane.getRowIndex(node)==y){
                    
                    node.setVisible(false);
                    
                    Button btn = new Button();
                    if (isFlag){
                        this.juego.getMatriz()[x][y].setFlag(false);
                        
                        btn.setText(" ");
                        btn.setId("botonxd");
                        btn.setPrefSize(50,50);
                        btn.setOnMouseClicked(new EventHandler<MouseEvent>(){
                            @Override
                            public void handle(MouseEvent event){
                                if (event.getButton()== MouseButton.PRIMARY){
                                    btn.setVisible(false);
                                    revisa(x,y,true,0);
                                    
                                }
                                if (event.getButton()==MouseButton.SECONDARY){
                                    btn.setVisible(false);
                                    update(x,y,false);
                                }
                            }
                        });
                     
                        
                    }else{
                        this.juego.getMatriz()[x][y].setFlag(true);
                        
                        btn.setId("Flag");
                        
                        btn.setText("B");
                        btn.setPrefSize(50, 50);
                        btn.setOnMouseClicked(new EventHandler<MouseEvent>(){
                            @Override
                            public void handle(MouseEvent event){
                
                                    
                                
                                if (event.getButton()==MouseButton.SECONDARY){
                                    btn.setVisible(false);
                                    update(x,y,true);
                                }
                            }
                           
                        });
                    }
                    this.tabla.add(btn,x,y);
                    break;
                }
                
            }
        }
        
    }
    
    public void pcGame(){
        boolean played=false;
        
        while(!played){
            int i =(int)(Math.random()*8);
            int j =(int)(Math.random()*8);
            
            if (!this.juego.getMatriz()[i][j].getActive()){
                revisa(i,j,true,1);
                played= true;
            }
        }
    }
    
    
    
}
