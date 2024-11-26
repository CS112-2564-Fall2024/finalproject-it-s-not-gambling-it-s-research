package edu.miracosta.cs112.finalproject.finalproject;

public class BetManager extends RouletteWheel implements RedBet, BlackBet,GreenBet{
    double wallet = 1000;
    double currentBet = 0;
    String bettingColor = "Green";

    public BetManager() {
    }

    public BetManager(double wallet, double currentBet, String bettingColor) {
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

    public double getWallet() {return wallet; }

    public double getCurrentBet() {
        return currentBet;
    }

    public String getBettingColor() {
        return bettingColor;
    }

    public void setBettingColor(String bettingColor) {
        this.bettingColor = bettingColor;
    }

    @Override
    public boolean isBlackWinning() {
        return "Black".equalsIgnoreCase(getWinningColor());
    }
    @Override
    public boolean isRedWinning() {
        return "Red".equalsIgnoreCase(getWinningColor());
    }
    @Override
    public boolean isGreenWinning() {
        return "Green".equalsIgnoreCase(getWinningColor());
    }

    public void placeBet(String color) throws IllegalBetException {

        if (wallet < 100) {
            throw new IllegalBetException("Not enough funds to place the bet!");
        }
        if (!"Red".equalsIgnoreCase(color) && !"Black".equalsIgnoreCase(color) && !"Green".equalsIgnoreCase(color)) {
            throw new IllegalBetException("Invalid bet color!");
        }

        setBettingColor(color);
        currentBet += 100;
        wallet -= 100;
    }

    public boolean decideBet() {
        boolean won;
        double multiplier;

        if (bettingColor == null || bettingColor.isBlank()) {
            throw new IllegalStateException("Betting color not set!");
        }

        switch (bettingColor.toLowerCase()) {
            case "red":
                won = isRedWinning();
                multiplier = RedBet.redMultiplier;
                break;
            case "black":
                if (isBlackWinning()) won = true;
                else won = false;
                multiplier = BlackBet.blackMultiplier;
                break;
            case "green":
                won = isGreenWinning();
                multiplier = GreenBet.greenMultiplier;
                break;
            default:
                throw new IllegalStateException("Unexpected betting color: " + bettingColor);
        }

        if (won) {
            wallet += currentBet * multiplier;
        }
        return won;
    }

}


