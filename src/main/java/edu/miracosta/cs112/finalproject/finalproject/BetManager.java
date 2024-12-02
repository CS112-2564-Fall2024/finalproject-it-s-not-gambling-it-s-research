package edu.miracosta.cs112.finalproject.finalproject;

public class BetManager implements RedBet, BlackBet,GreenBet{
    double wallet = 3000;
    double currentBet = 0;
    String bettingColor = "Green";
    private RouletteWheel wheel;

    public BetManager(RouletteWheel wheel) {
        this.wheel = wheel;
    }

    public BetManager(double wallet, double currentBet, String bettingColor, RouletteWheel wheel) {
        this.wallet = wallet;
        this.currentBet = currentBet;
        this.bettingColor = bettingColor;
        this.wheel = wheel;
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
        return "Black".equalsIgnoreCase(this.wheel.getWinningColor());
    }
    @Override
    public boolean isRedWinning() {
        return "Red".equalsIgnoreCase(this.wheel.getWinningColor());
    }
    @Override
    public boolean isGreenWinning() {
        return "Green".equalsIgnoreCase(this.wheel.getWinningColor());
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
        if (bettingColor == null || bettingColor.isBlank()) {
            throw new IllegalStateException("Betting color not set!");
        }
        boolean won;
        double multiplier;

        switch (bettingColor.toLowerCase()) {
            case "red":
                if (isRedWinning()) won = true;
                else won = false;
                multiplier = RedBet.redMultiplier;
                break;
            case "black":
                if (isBlackWinning()) won = true;
                else won = false;
                multiplier = BlackBet.blackMultiplier;
                break;
            case "green":
                if (isGreenWinning()) won = true;
                else won = false;
                multiplier = GreenBet.greenMultiplier;
                break;
            default:
                throw new IllegalStateException("Unexpected betting color: " + bettingColor);
        }

        if (won) {
            wallet += currentBet * multiplier;
        } currentBet = 0;
        return won;
    }

}


