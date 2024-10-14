package GameFinal;

import java.util.ArrayList;
import java.awt.Color;

public abstract class AbstractLevel {
    protected ArrayList<Block> blocks;
    protected Block targetBlock;
    
    

    
    public AbstractLevel() {
        blocks = new ArrayList<>();
    }

    public abstract void setupLevel();

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public Block getTargetBlock() {
        return targetBlock;
    }

    protected void addBlock(int x, int y, int width, int height, Color color) {
        blocks.add(new Block(x, y, width, height, color));
    }

    protected void setTargetBlock(int x, int y, int width, int height, Color color) {
        targetBlock = new Block(x, y, width, height, color);
        blocks.add(targetBlock);
    }
}