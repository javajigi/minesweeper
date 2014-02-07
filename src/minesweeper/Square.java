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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (flag ? 1231 : 1237);
		result = prime * result + (mine ? 1231 : 1237);
		result = prime * result + numOfNearMines;
		result = prime * result + (open ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Square other = (Square) obj;
		if (flag != other.flag)
			return false;
		if (mine != other.mine)
			return false;
		if (numOfNearMines != other.numOfNearMines)
			return false;
		if (open != other.open)
			return false;
		return true;
	}

	
}
