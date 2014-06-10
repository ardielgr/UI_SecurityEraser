/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package security_eraser;

import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import static java.lang.System.exit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.*;
//import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author Aegis
 */

public class Security_Eraser extends Application {
   
    @Override
    public void start(Stage primaryStage) {
               
        primaryStage.setTitle("Security Eraser");
        Group root = new Group();
        Scene scene = new Scene(root, 300,250,Color.WHITE);
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("File");
        MenuItem open = new MenuItem("Open");
        open.setOnAction(new EventHandler(){
            private String[] args;
            @Override
            public void handle(Event event){
                System.out.println("Hola");
                //FilePathTreeItem.main(args);
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Resource File");
                File file;
                file = fileChooser.showOpenDialog(primaryStage);
                if (file != null){
                    try {
                        Eraser_Method.OpenFile(file);
                    } catch (IOException ex) {
                        Logger.getLogger(Security_Eraser.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }
        });
        menu.getItems().add(open);
       // menu.getItems().add(new MenuItem("Open"));
        menu.getItems().add(new SeparatorMenuItem());
        //menu.getItems().add(new MenuItem("Exit"));
        MenuItem quit = new MenuItem("Exit");
        quit.setOnAction (new EventHandler(){
        /*    @Override
            public void handle(ActionEvent t){
                primaryStage.close();
            }*/
            @Override
            public void handle(Event event) {
                primaryStage.close();
                
            }
        });
        menu.getItems().add(quit);
        menuBar.getMenus().add(menu);
        
        //Menu codificacion
        Menu tools = new Menu("Tools");
        tools.getItems().add(new MenuItem("Random"));
        
        menuBar.getMenus().add(tools);
        
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        
        root.getChildren().add(menuBar);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
