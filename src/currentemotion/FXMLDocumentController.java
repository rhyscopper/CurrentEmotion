/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currentemotion;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

/**
 *
 * @author Rhys
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
     private AnchorPane Background;
    
    @FXML
     private Pane Happy;
    
    @FXML
     private Pane Anger;
    
    @FXML
     private Pane Fear;
    
    @FXML
     private Pane Sad;
    
    @FXML
     private Pane Suprised;
    
    @FXML
     private Pane Disgust;
    
     private EmotionInstance instance;
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Background.setId("background");
       // where are the classifier models?
	String installDir = "/Users/Rhys/NetBeansProjects/Classifier/rhys";
	// which models do you have?
	final String[] emotions = new String[] { 
	    "happy", "anger", "fear", "sad", "surprise", "disgust"
	};
	
	SVMClassifier svm = new SVMClassifier(installDir, emotions);
	instance = EmotionInstance.getInstance();
	// if it's new, classify and start new display 
        
	String[] sents = {instance.GetQuestion()};
	for (int s=0; s<sents.length; s++) { 
	    
	    String sent = sents[s];
	    //System.out.println("\nnew sentence: " + sent);
	    
	    // classify
	    // get raw list of confidences for each emotion
	    double[] p = svm.predict(sent);
	    // scale to [0,1] and find max
	    double max = -1.0;
	    int maxind = -1;
	    for (int i=0; i<p.length; i++) {
		p[i] = 1.0 / (1.0 + Math.exp(-p[i]));
		if (p[i]>max) {
		    maxind = i;
		    max = p[i];
		}
		//System.out.println(emotions[i] + " = " + p[i]);
	    }
            
            System.out.println(emotions[maxind]);
	    if(emotions[maxind].equals("happy")){
                Happy.setId("happyColour");
                Anger.setId("angerBlack");
                Fear.setId("fearBlack");
                Sad.setId("sadBlack");
                Suprised.setId("suprisedBlack");
                Disgust.setId("disgustBlack");
            }  
            else if(emotions[maxind].equals("anger")){
                Happy.setId("happyBlack");
                Anger.setId("angerColour");
                Fear.setId("fearBlack");
                Sad.setId("sadBlack");
                Suprised.setId("suprisedBlack");
                Disgust.setId("disgustBlack");
            } 
            else if(emotions[maxind].equals("fear")){
                Happy.setId("happyBlack");
                Anger.setId("angerBlack");
                Fear.setId("fearColour");
                Sad.setId("sadBlack");
                Suprised.setId("suprisedBlack");
                Disgust.setId("disgustBlack");
            } 
            else if(emotions[maxind].equals("sad")){
                Happy.setId("happyBlack");
                Anger.setId("angerBlack");
                Fear.setId("fearBlack");
                Sad.setId("sadColour");
                Suprised.setId("suprisedBlack");
                Disgust.setId("disgustBlack");
            } 
            else if(emotions[maxind].equals("surprise")){
                Happy.setId("happyBlack");
                Anger.setId("angerBlack");
                Fear.setId("fearBlack");
                Sad.setId("sadBlack");
                Suprised.setId("suprisedColour");
                Disgust.setId("disgustBlack");
            } 
            else {
                Happy.setId("happyBlack");
                Anger.setId("angerBlack");
                Fear.setId("fearBlack");
                Sad.setId("sadBlack");
                Suprised.setId("suprisedBlack");
                Disgust.setId("disgustColour");
            } 
	}
    }    
    
}
