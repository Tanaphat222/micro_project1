package GameFinal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButton extends JButton {
    private GameTimer gameTimer;
    private GiikerSliderPuzzle puzzle;

    public StartButton(GameTimer gameTimer, GiikerSliderPuzzle puzzle) {
        super("Start");
        this.gameTimer = gameTimer;
        this.puzzle = puzzle;

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameTimer.startTimer();
                puzzle.startGame(); // เริ่มเกมเมื่อกดปุ่ม Start
            }
        });
    }
}
