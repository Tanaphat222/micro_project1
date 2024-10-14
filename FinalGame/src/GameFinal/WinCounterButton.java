package GameFinal;

import javax.swing.*;

public class WinCounterButton extends JButton {
    private int winCount;
    private int Con = 10;
    public WinCounterButton() {
        super("Wins: 0");
        winCount = 0;
    }

    public void incrementWin() {
        winCount++;
        setText("Wins: " + this.winCount);
    }
    
    public void stopWin() {
        	setText("Wins: " + Con);
        	winCount = 0;
    }

    public void resetCounter() {
        winCount = 0;
        setText("Wins: 0");
    }
}
