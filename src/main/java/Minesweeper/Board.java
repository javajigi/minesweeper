package Minesweeper;

import java.util.ArrayList;

public class Board implements BoardController {
	private ArrayList<ArrayList<Block>> XLineBlocks = new ArrayList<ArrayList<Block>>();
	private int xNum, yNum;
	private int NumofMines;
	private int NumofInvisibleBlocks;
	private int NumofFlagedBlocks;
	private boolean bomb = false;

	/*
		TODO 아직 NumofMines 가 구현되지 않음.
	 */

	public Board(int xNum, int yNum, int NumofMines) {
		this.xNum = xNum;
		this.yNum = yNum;
		this.NumofMines = NumofMines;
		initialize(xNum, yNum);
	}

	private void initialize(int xNum, int yNum) {
		ArrayList<Block> YLineBlocks = new ArrayList<Block>();
		for (int i = 0 ; i < yNum ; i++)
			YLineBlocks.add(new Block(false));
		for (int j = 0 ; j < xNum ; j++)
			XLineBlocks.add(YLineBlocks);
	}

	private ArrayList<Block> getAllBlocks() {
		ArrayList<Block> Blocks = new ArrayList<Block>();
		for (int i = 0 ; i < xNum ; i++)
			for (int j = 0 ; j < yNum ; j++)
				Blocks.add(XLineBlocks.get(i).get(j));

		return Blocks;
	}

	@Override
	public void calcBoard() {
		int NumofInvisibleBlocks = 0;
		int NumofFlagedBlocks = 0;
		boolean bomb = false;
		for (int i = 0 ; i < xNum * yNum ; i++) {
			if (!(getAllBlocks().get(i).isShow()))
				NumofInvisibleBlocks = NumofFlagedBlocks + 1;
			if (getAllBlocks().get(i).isFlag())
				NumofFlagedBlocks = NumofFlagedBlocks + 1;
			if (getAllBlocks().get(i).isBomb())
				bomb = true;

		}

		this.NumofInvisibleBlocks = NumofInvisibleBlocks;
		this.NumofFlagedBlocks = NumofFlagedBlocks;
		this.bomb = bomb;
	}

	@Override
	public int getNumofInvisibleBlocks() {
		return NumofInvisibleBlocks;
	}

	@Override
	public int getNumofFlagedBlocks() {
		return NumofFlagedBlocks;
	}

	@Override
	public int getNumofMines() {
		return NumofMines;
	}

	@Override
	public int getNumofBlocks() {
		return xNum * yNum;
	}

	@Override
	public boolean isBomb() {
		return bomb;
	}

	@Override
	public void setMine(int xNum, int yNum, boolean mine) {
		XLineBlocks.get(xNum-1).get(yNum-1).setMine(mine);
	}

	@Override
	public void setFlag(int xNum, int yNum, boolean flag) {
		XLineBlocks.get(xNum-1).get(yNum-1).setFlag(flag);
	}

	@Override
	public void setShow(int xNum, int yNum, boolean show) {
		XLineBlocks.get(xNum-1).get(yNum-1).setShow(show);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Board)) return false;

		Board board = (Board) o;

		if (!XLineBlocks.equals(board.XLineBlocks)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return XLineBlocks.hashCode();
	}


}
