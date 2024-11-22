package edu.miracosta.cs112.finalproject.finalproject;

import java.util.Objects;

public class BetManager extends RouletteWheel implements RedBet, BlackBet {
    double wallet = 1000;
    double currentBet = 0;
    String bettingColor;

    public BetManager(){

    }

    public BetManager(double wallet, double currentBet, String bettingColor)
    {
        this.wallet = wallet;
        this.currentBet = currentBet;
        this.bettingColor = bettingColor;
    }


    public void setCurrentBet(double currentBet) {
        this.currentBet = currentBet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public double getWallet() {
        return wallet;
    }

    public double getCurrentBet() {
        return currentBet;
    }

    public String getBettingColor(){
        return bettingColor;
    }

    public void setBettingColor(String bettingColor) {
        this.bettingColor = bettingColor;
    }

    public void placeBet(String color) throws IllegalBetException{
        try
        {
            if(wallet <= 0)
            {
                throw new IllegalBetException();
            }
        }
        catch(IllegalBetException e)
        {
           System.out.println("Not enough funds for bet!");
        }
        bettingColor = color;
        currentBet += 100;
        wallet -= 100;
    }

    public void decideBet(){
        if(Objects.equals(getWinningColor(), bettingColor)){
        wallet = 100 ;
        System.out.println("You have won the bet!");
        }else
        {
            wallet -= 100;
            System.out.println("You have lost the bet!");
        }

    }


}
