package LeveL;


import GameFinal.AbstractLevel;
import GameFinal.Block;

public class Level3 extends AbstractLevel {
	@Override
	public void setupLevel() {

		addBlock(0, 4, 1, 1, Block.Citron);
		addBlock(2, 4, 1, 1, Block.Citron);
		addBlock(3, 4, 1, 1, Block.Citron);
		addBlock(0, 1, 1, 1, Block.Citron);
		addBlock(0, 2, 1, 1, Block.Citron);
		addBlock(3, 2, 1, 1, Block.Citron);
		addBlock(1, 4, 1, 1, Block.Citron);
		addBlock(3, 1, 1, 1, Block.Citron);
		addBlock(0, 3, 1, 1, Block.Citron);
		addBlock(3, 3, 1, 1, Block.Citron);
		// Red block (2x2)
		setTargetBlock(1, 0, 2, 2, Block.SoftRed);
		// Blue block (1x2)
		addBlock(1, 2, 2, 1, Block.Green);
		addBlock(1, 3, 2, 1, Block.Green);

	}
}