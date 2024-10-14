package GameFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GiikerSliderPuzzle extends JPanel {
	
	public boolean isGameStarted() {
		return gameStarted;
	}

	public void setGameStarted(boolean gameStarted) {
		this.gameStarted = gameStarted;
	}

	private int gridSizeX = 4;
	private int gridSizeY = 5;
	private int margin = 30;
	private int tileSize = 100;

	private ArrayList<Block> blocks;
	private Block selectedBlock;
	private Block targetBlock;
	private int level = 1;

	private final int winX = 1;
	private final int winY = 3;

	private boolean gameStarted = false;

	private WinCounterButton winCounter;
	private GameTimer gameTimer;
	private LevelButton LevelButton;

	public GiikerSliderPuzzle(WinCounterButton winCounter, GameTimer gameTimer, LevelButton LevelButton) {

		this.winCounter = winCounter;
		this.gameTimer = gameTimer;
		this.LevelButton = LevelButton;

		setFocusable(true);
		setupLevel(level);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (gameStarted) { // ถ้าเกมเริ่มแล้วเท่านั้นถึงจะทำงาน
					handleClick(e.getX(), e.getY());
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				selectedBlock = null;
				repaint();
				checkWinCondition();
			}
		});

		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if (selectedBlock != null) {
					handleDrag(e.getX(), e.getY());
					repaint();
				}
			}
		});
	}

	private void setupLevel(int level) {
		AbstractLevel currentLevel = LevelFactory.createLevel(level);
		currentLevel.setupLevel();
		blocks = currentLevel.getBlocks();
		targetBlock = currentLevel.getTargetBlock();
		
	}

	private void handleClick(int x, int y) {
		int row = (y - margin) / tileSize;
		int col = (x - margin) / tileSize;

		selectedBlock = null;
		for (Block block : blocks) {
			if (row >= block.y && row < block.y + block.height && col >= block.x && col < block.x + block.width) {
				selectedBlock = block;
				break;
			}
		}
	}

	private void handleDrag(int x, int y) {
		int row = (y - margin) / tileSize;
		int col = (x - margin) / tileSize;

		if (selectedBlock != null) {
			int newX = Math.max(0, Math.min(gridSizeX - selectedBlock.width, col));
			int newY = Math.max(0, Math.min(gridSizeY - selectedBlock.height, row));

			if (Math.abs(newX - selectedBlock.x) + Math.abs(newY - selectedBlock.y) == 1) {
				if (!isPositionOccupied(newX, newY, selectedBlock.width, selectedBlock.height)) {
					selectedBlock.x = newX;
					selectedBlock.y = newY;
				}
			}
		}
	}

	private boolean isPositionOccupied(int x, int y, int width, int height) {
		for (Block block : blocks) {
			if (block != selectedBlock) {
				if (x < block.x + block.width && x + width > block.x && y < block.y + block.height
						&& y + height > block.y) {
					return true;
				}
			}
		}
		return false;
	}

	private void checkWinCondition() {
		if (targetBlock.x == winX && targetBlock.y == winY) {
			
			if (level < 10) {
				JOptionPane.showMessageDialog(this, "YOU WIN!!!");  
	                level++;
	                winCounter.incrementWin();
	                setupLevel(level);
	                LevelButton.levelup();
	                repaint();
	        } else if (level == 10) {
	        	
	        	Object[] options = {"Retry", "Exit"};
	        	
	        	
	        	winCounter.incrementWin();
	        	gameStarted = false;
	            gameTimer.stopTimer();
	            int result = JOptionPane.showOptionDialog(this, "CONGRATULATIONS!!! Do you want to play again?", "Final Win", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,
	                    null,
	                    options,
	                    options[0]);
	            if (result == 0) {
	                level = 1; // Reset level
	                setupLevel(level);
	                repaint();
	                startGame();
	                winCounter.resetCounter();
	                LevelButton.resetlevel();
	                gameTimer.ResetTimer();
	                gameStarted = false;
	            } else {
	                System.exit(0);
	            }
	            
	        }


			
		}
	}
	public void startGame() {
		
		gameStarted = true;
		if (level == 10) { // กำหนดเมื่อถึงด่านสุดท้าย
			level = 1; //goto level 1
			setupLevel(level);
			winCounter.resetCounter();
			gameTimer.ResetTimer();
			LevelButton.resetlevel();
			
		}
		
		
		
	}
	public void resetGame() {
		gameStarted = true;
		
			for (int i = level; i <= 10; i++) {
				if (level == i) {
					setupLevel(i);
					
				}
			}
			repaint();
		}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(new Color(158, 164, 155));
		int highlightX = margin + tileSize;
		int highlightY = margin + 3 * tileSize;
		g2d.fillRect(highlightX, highlightY, 2 * tileSize, 2 * tileSize);

		for (Block block : blocks) {
			g2d.setColor(block.color);
			int x = margin + block.x * tileSize;
			int y = margin + block.y * tileSize;
			g2d.fillRect(x, y, block.width * tileSize, block.height * tileSize);

			g2d.setColor(Color.BLACK);
			g2d.drawRect(x, y, block.width * tileSize, block.height * tileSize);

			if (block == selectedBlock) {
				g2d.setColor(Color.DARK_GRAY);
				g2d.setStroke(new BasicStroke(3));
				g2d.drawRect(x, y, block.width * tileSize, block.height * tileSize);
				g2d.setStroke(new BasicStroke(1));
			}
		}

		g2d.setColor(Color.DARK_GRAY);
		g2d.drawRect(margin, margin, gridSizeX * tileSize, gridSizeY * tileSize);
	}
}