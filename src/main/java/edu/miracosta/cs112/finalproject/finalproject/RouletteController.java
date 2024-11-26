package edu.miracosta.cs112.finalproject.finalproject;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class RouletteController {

    @FXML
    private Label walletLabel;
    @FXML
    private Label currentBetLabel;
    @FXML
    private Label winNumber;
    @FXML
    private Label lastWinNumber0;
    @FXML
    private Label lastWinNumber1;
    @FXML
    private Label lastWinNumber2;
    @FXML
    private Label lastWinNumber3;
    @FXML
    private Label lastWinNumber4;

    @FXML
    private Button howToButton, spinButton, redBetButton, blackBetButton;

    @FXML
    public ImageView rouletteWheel;

    @FXML
    private Circle rouletteBall;

    private RouletteWheel wheel = new RouletteWheel();
    private BetManager bet = new BetManager();
    private String winningColor;
    private int winningNumber;

    public void initialize(){
        walletLabel.setText("Wallet: $" + bet.getWallet());
        currentBetLabel.setText("Current Bet: $" + bet.getCurrentBet());
        winNumber.setText("Haven't played yet.");
        lastWinNumber0.setText(" ");
        lastWinNumber1.setText(" ");
        lastWinNumber2.setText(" ");
        lastWinNumber3.setText(" ");
        lastWinNumber4.setText(" ");
        wheel.RouletteWheel();

    }

    private void updateLabels(){

        walletLabel.setText("Wallet: $" + bet.getWallet());
        currentBetLabel.setText("Current Bet: $" + bet.getCurrentBet());

    }

//handle buttons
    @FXML
    private void handleHowToButton(ActionEvent event){
    //open to new how toController?
    //System.print
    }
    @FXML
    private void handleSpinButton(ActionEvent event){

        wheel.spinWheel();
        winningNumber = wheel.getWinningNumber();
        winningColor = wheel.getWinningColor();

        //animateRoulette();
        boolean b = bet.decideBet();

        updateLabels();
        updateWinningHistory();

    }
    @FXML
    private void handleRedBetButton(ActionEvent event){
        try{
            bet.placeBet("Red");
            updateLabels();
        }catch (IllegalBetException e){
            System.out.println("Not enough funds for bet!");
        }

    }
    @FXML
    private void handleBlackBetButton(ActionEvent event) throws IllegalBetException {
        try{
            bet.placeBet("Black");
            updateLabels();
        }catch (IllegalBetException e){
            System.out.println("Not enough funds for bet!");
        }
    }

    private void updateWinningHistory(){
        winNumber.setText("Winning Number: " + winningNumber+ " (" + winningColor + ")");
        lastWinNumber0.setText(winningNumber + " (" + winningColor + ")");
        lastWinNumber1.setText(lastWinNumber0.getText());
        lastWinNumber2.setText(lastWinNumber1.getText());
        lastWinNumber3.setText(lastWinNumber2.getText());
        lastWinNumber4.setText(lastWinNumber3.getText());
    }

    //private void animateRoulette(){}

}



