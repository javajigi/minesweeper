package Minesweeper;

public interface BoardController {

	void setMine(int xAxis, int yAxis, boolean mine);
	void setFlag(int xAxis, int yAxis, boolean flag);
	void setShow(int xAxis, int yAxis, boolean show);

	void openBlock(int xAxis, int yAxis);
	void openBlock(String axis);

	Block getBlock(int xAxis, int yAxis);
	Block getBlock(String axis);

	int getNumOfInvisibleBlocks();
	int getNumOfFlagedBlocks();
	int getNumOfMines();
	int getNumOfBlocks();

	int getXNum();
	int getYNum();

	int getNumofNearMines(int xAxis, int yAxis);

	boolean isAnyMineBomb();

	void calcBoard();
	void openAllMines();
}
