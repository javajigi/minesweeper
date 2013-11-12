package Minesweeper;

import java.util.ArrayList;
import java.util.Random;

public class Board implements BoardController {
	private static final char COLUMN_START_CHAR = 'a';
	private ArrayList<ArrayList<Block>> XLineBlocks = new ArrayList<ArrayList<Block>>();
	private int xNum, yNum;
	private int numOfMines;
	private int numOfInvisibleBlocks;
	private int numOfFlagedBlocks;
	private boolean isAnyMineBomb = false;

	private Board(int xNum, int yNum, int numOfMines) {
		this.xNum = xNum;
		this.yNum = yNum;
		this.numOfMines = numOfMines;
		initialize(xNum, yNum, numOfMines);
	}

	public static Board createBoard(int xNum, int yNum, int NumofMines) {
		return new Board(xNum, yNum, NumofMines);
	}

	private void initialize(int xNum, int yNum, int NumofMines) {
		for (int i = 0 ; i < xNum ; i++) {
			ArrayList<Block> YLineBlocks = new ArrayList<Block>();
			for (int j = 0 ; j < yNum ; j++) {

				YLineBlocks.add(new Block(i, j));
			}
			XLineBlocks.add(YLineBlocks);
		}
		setRandomMines(NumofMines);
	}

	private void setRandomMines(int Mines) {
		while(Mines!=0) {
			Random random = new Random();
			int xAxis = random.nextInt(xNum) + 1;
			int yAxis = random.nextInt(yNum) + 1;

			if (getBlock(xAxis, yAxis).isMine())
				;
			else {
				setMine(xAxis, yAxis, true);
				Mines = Mines - 1;
			}
		}
	}

	private ArrayList<Block> getAllBlocks() {
		ArrayList<Block> Blocks = new ArrayList<Block>();
		for (int i = 0 ; i < xNum ; i++)
			for (int j = 0 ; j < yNum ; j++)
				Blocks.add(XLineBlocks.get(i).get(j));

		return Blocks;
	}

	private boolean isValid(int xAxis, int yAxis) {
		if (xAxis < 0 || xAxis >= xNum)
			return false;
		if (yAxis < 0 || yAxis >= yNum)
			return false;
		return true;
	}

	private ArrayList<Block> getAllNearBlocks(int xAxis, int yAxis) {
		ArrayList<Block> Blocks = new ArrayList<Block>();

		if (isValid(xAxis, yAxis-1))
			Blocks.add(XLineBlocks.get(xAxis).get(yAxis-1));

		if (isValid(xAxis, yAxis))
			Blocks.add(XLineBlocks.get(xAxis).get(yAxis));

		if (isValid(xAxis-1, yAxis))
			Blocks.add(XLineBlocks.get(xAxis-1).get(yAxis));

		if (isValid(xAxis-2, yAxis))
			Blocks.add(XLineBlocks.get(xAxis-2).get(yAxis));

		if (isValid(xAxis-2, yAxis-1))
			Blocks.add(XLineBlocks.get(xAxis-2).get(yAxis-1));

		if (isValid(xAxis-2, yAxis-2))
			Blocks.add(XLineBlocks.get(xAxis-2).get(yAxis-2));

		if (isValid(xAxis-1, yAxis-2))
			Blocks.add(XLineBlocks.get(xAxis-1).get(yAxis-2));

		if (isValid(xAxis, yAxis-2))
			Blocks.add(XLineBlocks.get(xAxis).get(yAxis-2));

		return Blocks;
	}

	@Override
	public void calcBoard() {
		int NumofInvisibleBlocks = 0;
		int NumofFlagedBlocks = 0;
		boolean bomb = false;

		for (int i = 0 ; i < xNum * yNum ; i++) {
			if (!(getAllBlocks().get(i).isShow()))
				NumofInvisibleBlocks = NumofInvisibleBlocks + 1;
			if (getAllBlocks().get(i).isFlag())
				NumofFlagedBlocks = NumofFlagedBlocks + 1;
			if (getAllBlocks().get(i).isBomb())
				bomb = true;

		}

		this.numOfInvisibleBlocks = NumofInvisibleBlocks;
		this.numOfFlagedBlocks = NumofFlagedBlocks;
		this.isAnyMineBomb = bomb;
	}

	@Override
	public void openAllMines() {
		ArrayList<Block> blocks = getAllBlocks();
		for (Block block : blocks) {
			if (block.isMine())
				block.setShow(true);
		}
	}

	@Override
	public int getNumofNearMines(int xAxis, int yAxis) {
		int NumofNearMines = 0;

		ArrayList<Block> Blocks = getAllNearBlocks(xAxis, yAxis);

		for (Block block : Blocks) {
			if (block.isMine())
				NumofNearMines = NumofNearMines + 1;
		}
		return NumofNearMines;
	}

	@Override
	public int getNumOfInvisibleBlocks() {
		return numOfInvisibleBlocks;
	}

	@Override
	public int getNumOfFlagedBlocks() {
		return numOfFlagedBlocks;
	}

	@Override
	public int getNumOfMines() {
		return numOfMines;
	}

	@Override
	public int getNumOfBlocks() {
		return xNum * yNum;
	}

	@Override
	public int getXNum() {
		return xNum;
	}

	@Override
	public int getYNum() {
		return yNum;
	}

	@Override
	public boolean isAnyMineBomb() {
		return isAnyMineBomb;
	}

	@Override
	public void setMine(int xAxis, int yAxis, boolean mine) {
		((XLineBlocks.get(xAxis-1)).get(yAxis-1)).setMine(mine);
	}

	@Override
	public void setFlag(int xAxis, int yAxis, boolean flag) {
		XLineBlocks.get(xAxis-1).get(yAxis-1).setFlag(flag);
	}

	@Override
	public void setShow(int xAxis, int yAxis, boolean show) {
		XLineBlocks.get(xAxis-1).get(yAxis-1).setShow(show);
	}

	@Override
	public void openBlock(int xAxis, int yAxis) {
		if (!getBlock(xAxis, yAxis).isShow()) {
			getBlock(xAxis, yAxis).setShow(true);
			if (getNumofNearMines(xAxis, yAxis)==0 && !getBlock(xAxis, yAxis).isMine()) {
				for (Block block : getAllNearBlocks(xAxis, yAxis)) {
					openBlock(block);
				}
			}
		}
		else
			;
	}

	@Override
	public void openBlock(String axis) {
		openBlock(Integer.parseInt(axis.substring(1)), generateColumnIndex(axis.charAt(0)) + 1);
	}

	private int generateColumnIndex(char columnIndex) {
		int target = Character.getNumericValue(columnIndex);
		int source = Character.getNumericValue(COLUMN_START_CHAR);
		return target - source;
	}

	private void openBlock(Block block) {
		int xAxis = block.getxAxis();
		int yAxis = block.getyAxis();
		openBlock(xAxis, yAxis);
	}

	@Override
	public Block getBlock(int xAxis, int yAxis) {
		return XLineBlocks.get(xAxis-1).get(yAxis-1);
	}

	@Override
	public Block getBlock(String axis) {
		return getBlock(generateColumnIndex(axis.charAt(0)), Integer.parseInt(axis.substring(1)) - 1);
	}
}
