package GameFinal;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Giiker Slider Puzzle");
		WinCounterButton winCounter = new WinCounterButton();
		GameTimer gameTimer = new GameTimer();
		LevelButton levelButton = new LevelButton();

		frame.setResizable(false);
		GiikerSliderPuzzle puzzle = new GiikerSliderPuzzle(winCounter, gameTimer, levelButton);

		StartButton startButton = new StartButton(gameTimer, puzzle);
		ResetButton resetButton = new ResetButton(gameTimer, winCounter, puzzle);
		

		JPanel rightPanel = new JPanel(new GridLayout(6, 1, 10, 10));
		rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		rightPanel.add(startButton);
		rightPanel.add(resetButton);
		rightPanel.add(gameTimer);
		rightPanel.add(winCounter);
		rightPanel.add(levelButton);

		frame.add(rightPanel, BorderLayout.EAST);
		frame.add(puzzle);
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
