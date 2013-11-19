package minesweeper;

public class Square {
	private boolean mine = false;
	private boolean open = false;
	private boolean flag = false;
	private int neighborMineCount = 0;
	
	public Square() {}
	
	private Square(boolean open, boolean mine) {
		this.open = open;
		this.mine = mine;
	}

	private Square(boolean open, int neighborMineCount) {
		this.open = open;
		this.neighborMineCount = neighborMineCount;
	}

	public boolean hasMine() {
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
		this.flag = true;
		
	}
	
	public void setNeighborMineCount(int neighborMineCount) {
		this.neighborMineCount  = neighborMineCount;
	}

	public boolean isLose() {
		return isOpen() && hasMine();
	}
	
	public int getNeighborMineCount() {
		return neighborMineCount;
	}

	public String status() {
		if (isOpen()) {
			if (hasMine()) {
				return "*";
			}
			
			return this.neighborMineCount + "";
		}
		
		if (isFlag()) {
			return "X";
		}
		
		return ".";
	}

	public static Square createSquareMine() {
		return new Square(false, true);
	}
	
	public static Square createSquare(int neighborMineCount) {
		return new Square(false, neighborMineCount);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (flag ? 1231 : 1237);
		result = prime * result + (mine ? 1231 : 1237);
		result = prime * result + neighborMineCount;
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
		if (neighborMineCount != other.neighborMineCount)
			return false;
		if (open != other.open)
			return false;
		return true;
	}
}
