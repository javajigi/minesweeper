package MineSweeper;

public class Cell {
	private Boolean isMine;
	private Boolean isFlag;
	
	private Boolean isOpen;
	private int 	numOfMinesAround;
	
	/*
	 * CONSTRUCTOR
	 */
	
	private Cell() {
		isMine = false;
		isFlag = false;
		isOpen = false;
		this.numOfMinesAround = 0;
	}
	
	private Cell(Boolean isMine) {
		this.isMine = isMine;
		this.isFlag	= false;
		this.isOpen	= false;
		this.numOfMinesAround = 0;
	}
	
	/*
	 * FACTORY METHOD
	 */
	
	public static Cell makeDefaultCell() {
		Cell cell = new Cell();
		return cell;
	}
	
	public static Cell makeCellWithMine() {
		Cell cell = new Cell(true);
		return cell;
	}
	
	/*
	 * GETTER AND SETTER
	 */
	
	public Boolean getIsMine() {
		return isMine;
	}
	
	public void setIsMine(Boolean isMine) {
		this.isMine = isMine;
	}
	
	public Boolean getIsFlag() {
		return isFlag;
	}
	
	public void setIsFlag(Boolean isFlag) {
		this.isFlag = isFlag;
	}
	
	public Boolean getIsOpen() {
		return isOpen;
	}
	
	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}
	
	public int getNumOfMinesAround() {
		return numOfMinesAround;
	}
	
	public void setNumOfMinesAround(int numOfMinesAround) {
		this.numOfMinesAround = numOfMinesAround;
	}
	
	/*
	 * GET SYMBOL
	 */
	
	public char getSymbol() {
		if (this.getIsFlag() == true) 									return 'f';
		else if (this.getIsOpen() == true && this.getIsMine() == false) return '.';
		else if (this.getIsOpen() == true && this.getIsMine() == true)	return 'M';
		else															return 'x';		// not yet open
	}
}
