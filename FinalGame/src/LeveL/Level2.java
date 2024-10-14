package LeveL;


import GameFinal.AbstractLevel;
import GameFinal.Block;
public class Level2 extends AbstractLevel {
    @Override
    public void setupLevel() {
        addBlock(0, 0, 1, 1, Block.Citron);
        addBlock(1, 0, 1, 1, Block.Citron);
        addBlock(2, 4, 1, 1, Block.Citron);
        addBlock(3, 4, 1, 1, Block.Citron);
        addBlock(0, 1, 1, 1, Block.Citron);
        addBlock(1, 2, 1, 1, Block.Citron);
        addBlock(0, 2, 1, 1, Block.Citron);
        addBlock(2, 2, 1, 1, Block.Citron);
        addBlock(0, 4, 1, 1, Block.Citron);
        addBlock(1, 4, 1, 1, Block.Citron);
        addBlock(0, 3, 1, 1, Block.Citron);
        addBlock(2, 3, 1, 1, Block.Citron);
        setTargetBlock(2, 0, 2, 2, Block.SoftRed);
        addBlock(3, 2, 1, 2, Block.LightBlue);
    }
}