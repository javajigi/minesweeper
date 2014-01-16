package MineSweeper;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;


public class Field {
	
	private static final int DEFAULT_SQUARE_SIZE = 2;
	private static final String NEW_LINE = System.getProperty("line.separator");
	
	private final int sizeOfSide;
	
	private ArrayList<Row> field = new ArrayList<Row>();

	
	public static String getNewLine() {
		return Field.NEW_LINE;
	}
	
	/*
	 * CONSTRUCTORS
	 * 
	 * There are three kind of constructors.
	 * 
	 * Field()     : DEFAULT. size 4x4 with 1 mine
	 * Field(n)    : size n x n with (n x n) / 4 mines
	 * Field(n, p) : size n x n with p mines
	 * 
	 *  And each constructor has its own factory method "initBoard"
	 *  
	 */
	
	private Field() {
		for(int i = 0; i < getDefaultSquareSize(); i++) {
			Row oneRow = Row.makeDefaultRow();
			field.add(oneRow);
		}
		
		sizeOfSide = getDefaultSquareSize();
		
		this.distributeMines(1);		
	}
	
	private Field(int squareSize) {
		for(int i = 0; i < squareSize; i++) {
			Row oneRow = Row.makeRow(squareSize);
			field.add(oneRow);
		}
		
		sizeOfSide = squareSize;
		
		this.distributeMines(sizeOfSide * sizeOfSide / 4);
	}
	
	private Field(int squareSize, int numOfMine) {
		for(int i = 0; i < squareSize; i++) {
			Row oneRow = Row.makeRow(squareSize);
			field.add(oneRow);
		}
		
		sizeOfSide = squareSize;
		
		this.distributeMines(numOfMine);
	}
	
	static public Field initField() {
		Field newField = new Field();
		
		return newField;
	}
	
	static public Field initField(int squareSize) {
		Field newField = new Field(squareSize);
		
		return newField;
	}
	
	static public Field initField(int squareSize, int numOfMine) {
		Field newField = new Field(squareSize, numOfMine);
		
		return newField;
	}
	
	/*
	 * SHOW BOARD
	 * 
	 * toString -> make the board into String
	 * printField -> show the board through STDOUT
	 * 
	 */
	
	public void printField() {
		String buffer = this.toString();
		System.out.println(buffer);
	}
	
	@Override
	public String toString() {
		
		int squareSize = field.size();
		StringBuilder buffer = new StringBuilder();
		
		for (Row row : field) {
			String rowString = row.toString();
			buffer.append(rowString);
			buffer.append(Field.getNewLine());
		}
		
		return buffer.toString();
	}

	/*
	 * DISTRIBUT MINES
	 * 
	 * distributeMines :
	 * setupMine :
	 * generateRandomPosSet :
	 * 
	 */
	
	private Boolean distributeMines(int numOfMine) {
		
		// exception handling
		if (numOfMine >= sizeOfSide * sizeOfSide) return false;
		
		Set<String> minePos = generateRandomPosSet(numOfMine);
		
		for (String pos: minePos) {
			String[] buffer = pos.split(",");
			int rowPos = Integer.parseInt(buffer[0]);
			int colPos = Integer.parseInt(buffer[1]);
			
			setupMine(rowPos, colPos);
		}
		
		return true;
	}
	
	public void setupMine(int rowPos, int colPos) {
		
		field.get(rowPos).setupMine(colPos);
	}
	
	public Set<String> generateRandomPosSet(int numOfMine) {
		
		Set<String> minePos = new TreeSet<String>();
		
		Random newRand = new Random();
		
		for(int i = 0; i < numOfMine; i++) {
			
			int rowPos = newRand.nextInt(sizeOfSide);
			int colPos = newRand.nextInt(sizeOfSide);
			String pos = Integer.toString(rowPos) + "," + Integer.toString(colPos);
			
			if(minePos.contains(pos)) i--;	// Iterate until no duplication generated
			else 					  minePos.add(pos);
		}
		
		return minePos;
	}
	
	public int getNumOfMinesInField() {
		int result = 0;
		
		for (Row row : field) {
			result += row.getNumOfMines();
		}
		
		return result;
	}
	
	/*
	 * This is just for test
	 */
	public void initCurField() {
		for (int i = 0; i < sizeOfSide; i++) {
			for (int j = 0; j < sizeOfSide; j++) {
				field.get(i).disassembleMine(j);
			}
		}
	}

	public static int getDefaultSquareSize() {
		return DEFAULT_SQUARE_SIZE;
	}

	public Row getRow(int idx) {
		return field.get(idx);
	}

	public boolean isMine(int rowPos, int colPos) {
		if (field.get(rowPos).isMine(colPos) == true)  return true;
		else 										   return false;
	}
	
	public int getNumOfMinesAround(int rowPos, int colPos) {
		int result = 0;
				
		if (rowPos != 0) {
			if (colPos != 0) {
				if (field.get(rowPos - 1).getCell(colPos - 1).getIsMine() == true) result++;
			}
			
			if (field.get(rowPos - 1).getCell(colPos).getIsMine() == true) result++;
			
			if (colPos != sizeOfSide - 1) {
				if (field.get(rowPos - 1).getCell(colPos + 1).getIsMine() == true) result++;
			}
		}
		
		if (colPos != 0) {
			if (field.get(rowPos).getCell(colPos - 1).getIsMine() == true) result++;
		}
		
		if (colPos != sizeOfSide - 1) {
			if (field.get(rowPos).getCell(colPos + 1).getIsMine() == true) result++;
		}
		
		if (rowPos != sizeOfSide - 1) {
			if (colPos != 0) {
				if (field.get(rowPos + 1).getCell(colPos - 1).getIsMine() == true) result++;
			}
			
			if (field.get(rowPos + 1).getCell(colPos).getIsMine() == true) result++;
			
			if (colPos != sizeOfSide - 1) {
				if (field.get(rowPos + 1).getCell(colPos + 1).getIsMine() == true) result++;
			}
		}
		
		return result;
	}
}
