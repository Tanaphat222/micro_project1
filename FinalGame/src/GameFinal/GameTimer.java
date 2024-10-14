package GameFinal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameTimer extends JButton {
    private Timer timer;
    private int elapsedTime;

    public GameTimer() {
    	 setText("Time: 00:00");
        elapsedTime = 0;

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elapsedTime++;
                updateTimerLabel();
            }
        });
    }

    public void startTimer() {
        elapsedTime = 0;
        timer.start();
        updateTimerLabel();
    }

    public void stopTimer() {
    	timer.stop();
        
    }
    
    public void ResetTimer() {
        elapsedTime = 0;
        updateTimerLabel();
    }
    
    private void updateTimerLabel() {
        int minutes = elapsedTime / 60; // คำนวณนาที
        int seconds = elapsedTime % 60; // คำนวณวินาที
        setText(String.format("Time: %02d:%02d", minutes, seconds)); // แสดงผลเป็น นาที:วินาที
    }
}
