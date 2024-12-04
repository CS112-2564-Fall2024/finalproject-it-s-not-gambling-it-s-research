package edu.miracosta.cs112.finalproject.finalproject;

import com.sun.tools.javac.Main;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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


    private static final RouletteWheel wheel = new RouletteWheel(); // Single instance
    private BetManager bet;

    public RouletteController() {
        this.bet = new BetManager(wheel); // Pass shared instance
    }



    public void initialize(){
        walletLabel.setText(String.format("Wallet: $%.2f", bet.getWallet()));
        currentBetLabel.setText(String.format("Current Bet: $%.2f" , bet.getCurrentBet()));
        winNumber.setText("Haven't played yet.");
        lastWinNumber0.setText(" ");
        lastWinNumber1.setText(" ");
        lastWinNumber2.setText(" ");
        lastWinNumber3.setText(" ");
        lastWinNumber4.setText(" ");
        Image image = null;

            URL imageURL = RouletteApplication.class.getResource("/edu/miracosta/cs112/finalproject/finalproject/Image/rouletteWheel.png");
            if(imageURL != null) {
                image = new Image(imageURL.toString());
            }
            rouletteWheel.setImage(image);

    }

    private void updateLabels(){

        walletLabel.setText(String.format("Wallet: $%.2f", bet.getWallet()));
        currentBetLabel.setText(String.format("Current Bet: $%.2f" , bet.getCurrentBet()));
    }

    private final List<String> history = new ArrayList<>(List.of("", "", "", "", "")); // Initializes empty history with 5 slots.
    private void updateHistory() {

        String currentResult = wheel.getWinningNumber() + " (" + wheel.getWinningColor() + ")";

        winNumber.setText("Winning Number: " + currentResult);

        history.add(0, currentResult);
        if (history.size() > 5) {
            history.remove(5);
        }
        lastWinNumber0.setText(history.size() > 0 ? history.get(0) : "");
        lastWinNumber1.setText(history.size() > 1 ? history.get(1) : "");
        lastWinNumber2.setText(history.size() > 2 ? history.get(2) : "");
        lastWinNumber3.setText(history.size() > 3 ? history.get(3) : "");
        lastWinNumber4.setText(history.size() > 4 ? history.get(4) : "");
    }


    //handle buttons
    @FXML
    private void handleHowToButton(ActionEvent event){
        //System.print
        //open to new how toController?
    }
    @FXML
    private void handleSpinButton(ActionEvent event) {
       try{
       animateRoulette();
        wheel.spinWheel();
        bet.decideBet();
        updateLabels();
        updateHistory();
        }
        catch (IllegalStateException e)
        {System.out.println("Please place bet before spinning the wheel");}
    }
    @FXML
    private void handleRedBetButton(ActionEvent event) throws IllegalBetException{
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
    @FXML
    private void handleGreenBetButton(ActionEvent event) throws IllegalBetException{
        try{
            bet.placeBet("Green");
            updateLabels();
        }catch (IllegalBetException e){
            System.out.println("Not enough funds for bet!");
        }

    }

    private void animateRoulette(){
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(3), rouletteWheel);
        rotateTransition.setByAngle(185 * 5);
        rotateTransition.setCycleCount(1);
        rotateTransition.setInterpolator(javafx.animation.Interpolator.EASE_OUT);
        rotateTransition.play();}

}



