package GameFinal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButton extends JButton {
    private GameTimer gameTimer;
    private WinCounterButton winCounter;
    private GiikerSliderPuzzle puzzle;

    public ResetButton(GameTimer gameTimer, WinCounterButton winCounter, GiikerSliderPuzzle puzzle) {
        super("Reset");
        this.gameTimer = gameTimer;
        this.winCounter = winCounter;
        this.puzzle = puzzle;

        addActionListener(new ActionListener() {

			@Override
            public void actionPerformed(ActionEvent e) {
            		puzzle.resetGame();
                
                
                
            }
        });
    }
}
