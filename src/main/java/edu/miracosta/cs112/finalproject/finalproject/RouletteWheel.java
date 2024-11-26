package edu.miracosta.cs112.finalproject.finalproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RouletteWheel {

    private static class RouletteSlot {
        private final int number;
        private String color = "Green";

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

    public RouletteWheel() {
        initializeWheel();
    }

    public void initializeWheel() {
        wheel.clear();
        wheel.add(new RouletteSlot(0, "Green")); // 0 is green
        // Red and Black numbers alternate
        for (int i = 2; i <= 35; i++) {
            String color = (i % 2 == 0) ? "Black" : "Red";
            wheel.add(new RouletteSlot(i, color));
            System.out.println("Wheel initialized with " + wheel.size() + " slots.");//debug
        }wheel.add(new RouletteSlot(37, "Green"));
    }


    public void spinWheel() {
        System.out.println("spinWheel() called"); // Debug log
        int index = random.nextInt(wheel.size());
        winningSlot = wheel.get(index);
        System.out.println("Wheel spun. Winning slot: " + winningSlot); // Debug log
    }

    public int getWinningNumber() {
        if (winningSlot == null) {
            System.out.println("getWinningNumber() called, but wheel not spun yet."); // Debug log
            throw new IllegalStateException("Wheel has not been spun yet!");
        }
        return winningSlot.getNumber();
    }

    public String getWinningColor() {
        if (winningSlot == null) {
            System.out.println("getWinningColor() called, but wheel not spun yet."); // Debug log
            throw new IllegalStateException("Wheel has not been spun yet!");
        }
        return winningSlot.getColor();
    }

    @Override
    public String toString() {
        if (winningSlot == null) {
            return "No winning number yet! Spin the wheel.";
        }
        return "Winning Number: " + getWinningNumber() + " (" + getWinningColor() + ")";
    }
}

