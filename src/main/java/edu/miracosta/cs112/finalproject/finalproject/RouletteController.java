package edu.miracosta.cs112.finalproject.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class RouletteController {

    @FXML
    private Label walletLabel, currentBetLabel;

    @FXML
    private Button howToButton, spinButton, redBetButton, blackBetButton;

    RouletteWheel wheel = new RouletteWheel();
    BetManager bet = new BetManager();
    String winningColor;
    int winningNumber;

    /**Figure out labeling for the history    <Label fx:id="winNumber" alignment="CENTER" prefHeight="55.0" prefWidth="54.0" text="Winning Number" textAlignment="CENTER" wrapText="true">
     <font>
     <Font size="14.0" />
     </font>
     </Label>
     <Label fx:id="lastWinNumber0" alignment="CENTER" prefHeight="27.0" prefWidth="54.0" text="History" textAlignment="CENTER" wrapText="true" />
     <Label fx:id="lastWinNumber1" alignment="CENTER" prefHeight="28.0" prefWidth="54.0" text="history" textAlignment="CENTER" wrapText="true">
     <font>
     <Font size="12.0" />
     </font>
     </Label>
     <Label fx:id="lastWinNumber3" alignment="CENTER" prefHeight="30.0" prefWidth="54.0" text="history" textAlignment="CENTER" wrapText="true">
     <font>
     <Font size="11.0" />
     </font>
     </Label>
     <Label fx:id="lastWinNumber2" alignment="CENTER" prefHeight="32.0" prefWidth="54.0" text="history" textAlignment="CENTER" wrapText="true">
     <font>
     <Font size="10.0" />
     </font>
     </Label>
     <Label fx:id="lastWinNumber4" alignment="CENTER" prefHeight="27.0" prefWidth="54.0" text="history" textAlignment="CENTER" wrapText="true">
     <font>
     <Font size="10.0" />*/


    @FXML
    public void intialize(){

    }

    private void updateLabels(){

        walletLabel.setText("Wallet: $" + bet.getWallet());
        currentBetLabel.setText("Current Bet: $" + bet.getCurrentBet());

    }

//handle buttons
    private void handleHowToButton(ActionEvent event){

    //System.print
    }
    private void handleSpinButton(ActionEvent event){
        //handle spin

        wheel.spinWheel();
        winningNumber = wheel.getWinningNumber();
        winningColor = wheel.getWinningColor();


    }
    private void handleRedBetButton(ActionEvent event) throws IllegalBetException {
        bet.placeBet("Red");

    }
    private void handleBlackBetButton(ActionEvent event) throws IllegalBetException {
        bet.placeBet("Black");
    }

    private void placeBet(){

    }


}



