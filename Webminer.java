/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webminer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 *
 * @author RamLah
 */
public class Webminer extends Application {
public static TextArea taResult = new TextArea("AREA");
 
@Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5, 5, 5, 5));
        gridPane.setHgap(5);
        //col constraints
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.NEVER);
        ColumnConstraints col2= new ColumnConstraints();
        col2.setHgrow(Priority.ALWAYS);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setHgrow(Priority.NEVER);
        //row constraints
        RowConstraints row1 = new RowConstraints();
        row1.setVgrow(Priority.ALWAYS);
        row1.setPercentHeight(40);
        RowConstraints row2 = new RowConstraints();
        row2.setVgrow(Priority.ALWAYS);
        row2.setPercentHeight(560);
        //set constrain untuk gridPane
        gridPane.getColumnConstraints().addAll(col1, col2, col3);
        gridPane.getRowConstraints().addAll(row1, row2);
        
        Label labelURL = new Label("URL");
        gridPane.add(labelURL, 0, 0);
        
        TextField tfURL = new TextField();     
        tfURL.setText("https://karakterunsulbar.com");
        gridPane.add(tfURL, 1, 0);
        
        Button buttonRUN = new Button("RUN");
        gridPane.add(buttonRUN, 2, 0);
        buttonRUN.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    String url = tfURL.getText();
                    Document document = Jsoup.connect(url).get();
                    String textDariWeb = document.text();
                    System.out.println(textDariWeb);
                    taResult.setText(textDariWeb);
                    
                    //System.out.println("RUN");
                } catch (IOException ex) {
                    Logger.getLogger(Webminer.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });  
        
        
        gridPane.add(taResult, 0, 1, 3, 2);
  
        root.getChildren().add(gridPane);        
        Scene scene = new Scene(root, 800, 600);        
        primaryStage.setTitle("Web Miner");
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
