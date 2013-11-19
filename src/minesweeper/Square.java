package minesweeper;

public class Square {
	private boolean mine = false;
	private boolean open = false;
	private boolean flag = false;
	private int numOfNearMines = 0;

	public boolean isMine() {
		return mine;
	}

	public boolean isOpen() {
		return open;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setMine() {
		this.mine = true;
	}

	public void setOpen() {
		this.open = true;
		
	}

	public void setFlag() {
		if (this.flag)
			this.flag = false;
		else
			this.flag = true;
		
	}

	public boolean isLose() {
		return isOpen() && isMine();
	}
	
	public String printSymbol() {
		if (isMine() && isOpen())
			return "M";
		if (!isMine() && isOpen())
			return numOfNearMines+"";
		if (isFlag() && !isOpen())
			return "F";
		if (!isFlag() && !isOpen())
			return "C";
		return "";
	}

	public int getNumOfNearMines() {
		return numOfNearMines;
	}

	public void setNumOfNearMines() {
		this.numOfNearMines++;
	}

}
