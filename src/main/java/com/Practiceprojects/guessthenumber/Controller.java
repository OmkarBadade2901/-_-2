package com.Practiceprojects.guessthenumber;

import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class Controller {

    @FXML
    Label msg1,msg2,msg3;
    @FXML
    TextField textField;
    ArrayList<Integer> noOfGuessList;
    Model model;
    int count;
    @FXML
    VBox vbox;
    
    public Controller(){
       model = new Model();
       noOfGuessList= new ArrayList<>();
    }
    

   public void newGame(){
      model.createNewRandomNumber();
      noOfGuessList.clear();
      count=0;
      msg1.setText("");
      msg2.setText("");
      msg3.setText("");
   }
    
    
    @FXML
    public void buttonPressed (ActionEvent e) throws InterruptedException{
        int userGuess = Integer.parseInt(textField.getText());
        textField.setText("");
        
       if( model.findWinner(userGuess)){
           msg1.setText("Your Guess is right!!!");
           
           if(showAlertBox()) newGame();
           else {
               Platform.exit();
           }
       }
       else{
           msg1.setText(model.find(userGuess));
           count++;
           noOfGuessList.add(userGuess);
           msg2.setText("No of Guessws: "+ count);
           msg3.setText("Guesswd no. are: "+noOfGuessList);
           
       }
        
    }   
    
    public boolean showAlertBox(){
        Stage stage =(Stage) vbox.getScene().getWindow();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);
        alert.getDialogPane().setHeaderText("You Win!!!");
        alert.getDialogPane().setContentText("Do you want play again? ");
        Optional<ButtonType> result =alert.showAndWait();
        if(result.get()==ButtonType.OK) return true;
        else if(result.get()==ButtonType.CANCEL) return false;        
        return false;
        
    }
    
}
