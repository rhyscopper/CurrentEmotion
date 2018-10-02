/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currentemotion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Rhys
 */
public class CurrentEmotion extends Application {
    
    private static EmotionInstance instance;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        //instance = EmotionInstance.getInstance();
        //String answer = JOptionPane.showInputDialog(null,"Enter sentence to be analysed!");
        
        //instance.SetQuestion(answer);
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root); 
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        instance = EmotionInstance.getInstance();
        String answer = JOptionPane.showInputDialog(null,"Enter sentence to be analysed!");
        
        instance.SetQuestion(answer);
        launch(args);
    }
    
}
