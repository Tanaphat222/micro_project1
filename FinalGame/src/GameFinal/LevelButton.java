package GameFinal;

import javax.swing.*;

public class LevelButton extends JButton{
	private int level = 1;
	
	public LevelButton(){
		super("Level: 1");
		level = 1;
	}
	public void levelup() {
		level++;
		setText("Level: " + this.level);
	}
	
	public void resetlevel() {
		level = 1;
        setText("Level: 1");
    }

}
