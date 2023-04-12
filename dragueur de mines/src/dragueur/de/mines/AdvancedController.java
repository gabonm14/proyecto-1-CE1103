/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package dragueur.de.mines;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author gabon
 */
public class AdvancedController implements Initializable {
    
    private int total=8;
    
    private int leftMines= this.total;
    
    private int turno= 0;
    
    private Matriz juego;
    
    private boolean lost;

    @FXML
    private Label lblminas;
    @FXML
    private Label lbltime;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
