/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currentemotion;

/**
 *
 * @author Rhys
 */
public class EmotionInstance {
    
    private static final EmotionInstance instance = new EmotionInstance();
    
    public String Question;
    
    public static EmotionInstance getInstance() {
        
        return instance;
    }
        
    public String GetQuestion() {
        return Question;
    }
    
    public void SetQuestion(String Question) {
        this.Question = Question;
    }
}
