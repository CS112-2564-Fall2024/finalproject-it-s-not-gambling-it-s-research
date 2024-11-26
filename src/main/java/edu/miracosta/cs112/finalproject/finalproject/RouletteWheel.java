package edu.miracosta.cs112.finalproject.finalproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RouletteWheel {

    private static class RouletteSlot {
        private final int number;
        private final String color;

        public RouletteSlot(int number, String color) {
            this.number = number;
            this.color = color;
        }

        public int getNumber() {
            return number;
        }

        public String getColor() {
            return color;
        }

        @Override
        public String toString() {
            return number + " (" + color + ")";
        }
    }

    private final List<RouletteSlot> wheel = new ArrayList<>();
    private final Random random = new Random();
    public RouletteSlot winningSlot;

    public void RouletteWheel() {
        initializeWheel();
    }

    void initializeWheel() {
        wheel.add(new RouletteSlot(0, "Green")); // 0 is green
        // Red and Black numbers alternate
        for (int i = 1; i <= 35; i++) {
            String color = (i % 2 == 0) ? "Black" : "Red";
            wheel.add(new RouletteSlot(i, color));
        }
        wheel.add(new RouletteSlot(36, "Green"));//00 Green too
    }


    public void spinWheel() {
        int index = random.nextInt(wheel.size());
        winningSlot = wheel.get(index);
    }

    public int getWinningNumber() {
        return winningSlot.getNumber();
    }

    public String getWinningColor() {
        if (winningSlot == null) {
            throw new IllegalStateException("Wheel has not been spun yet!");
        }
        return winningSlot.getColor();
    }

    @Override
    public String toString() {
        return "Winning Number: " + getWinningNumber() + " (" + getWinningColor() + ")";
    }
}

