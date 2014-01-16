package MineSweeper;

import java.util.ArrayList;

public class Row {
	private ArrayList<Cell> row;
	
	/*
	 * CONSTRUCTORS
	 */
	
	private Row() {
		row = new ArrayList<Cell>(Field.getDefaultSquareSize());
		
		for (int i = 0; i < Field.getDefaultSquareSize(); i++) {
			row.add(Cell.makeDefaultCell());
		}
	}
	
	private Row(int squareSize) {
		row = new ArrayList<Cell>(squareSize);
		
		for (int i = 0; i < squareSize; i++) {
			row.add(Cell.makeDefaultCell());
		}
	}
	
	/*
	 * FACTORY METHODS
	 */
	
	public static Row makeDefaultRow() {
		Row row = new Row();
		
		return row;
	}
	
	public static Row makeRow(int squareSize) {
		Row row = new Row(squareSize);
		
		return row;
	}
	
	@Override
	public String toString() {
		
		StringBuffer buffer = new StringBuffer();
		
		for (Cell cell : row) {
			buffer.append(cell.getSymbol());
			buffer.append(" ");
		}
		
		return buffer.toString();
	}

	public void setupMine(int colPos) {
		row.get(colPos).setIsMine(true);
	}

	public void disassembleMine(int colPos) {
		row.get(colPos).setIsMine(false);
	}
	
	public boolean isMine(int colPos) {
		if (row.get(colPos).getIsMine() == true) return true;
		else									 return false;
	}

	public Cell getCell(int colPos) {
		return row.get(colPos);
	}

	public int getNumOfMines() {
		int result = 0;
		for (Cell cell : row) {
			if (cell.getIsMine() == true) result ++;
		}
		return result;
	}
}
