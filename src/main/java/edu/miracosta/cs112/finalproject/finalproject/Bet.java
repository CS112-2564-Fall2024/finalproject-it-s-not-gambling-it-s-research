package edu.miracosta.cs112.finalproject.finalproject;

public interface Bet {
    String getDescription(); // Returns a description of the bet
    double getPayoutMultiplier(); // Returns the payout multiplier for the bet
    boolean isWinningBet(String winningColor, int winningNumber); // Checks if the bet wins
    double getBetAmount(); // Returns the bet amount
}


