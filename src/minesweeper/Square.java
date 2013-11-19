package minesweeper;

public class Square {
	private boolean mine = false;
	private boolean open = false;
	private boolean flag = false;
	private int neighborMineCount = 0;
	
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
}
