package edu.miracosta.cs112.finalproject.finalproject;

public class BetManager extends RouletteWheel implements RedBet, BlackBet {
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

    public double getWallet() {
        return wallet;
    }

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

    public void placeBet(String color) throws IllegalBetException {

        if (wallet < 100) {
            throw new IllegalBetException("Not enough funds to place the bet!");
        }
        if (!"Red".equalsIgnoreCase(color) && !"Black".equalsIgnoreCase(color)) {
            throw new IllegalBetException("Invalid bet color!");
        }

        setBettingColor(color);
        currentBet += 100;
        wallet -= 100;
    }

    public void decideBet() {

        boolean won;
        double multiplier = switch (getBettingColor().toLowerCase()) {
            case "red" -> {
                won = isRedWinning();
                yield RedBet.redMultiplier;
            }
            case "black" -> {
                won = isBlackWinning();
                yield BlackBet.blackMultiplier;
            }
            default ->
                //should not occur since we validate in the placeBet()
                    throw new IllegalStateException("Unexpected color?");
        };

        if (won) {
            wallet += currentBet * multiplier;
        }
        //already lost money on the placeBet(), any additional lost would net a double money loss
        // Reset bet state
        currentBet = 0;
        bettingColor = "green";
    }
}


