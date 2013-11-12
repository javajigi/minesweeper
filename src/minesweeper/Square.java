package minesweeper;

public class Square {
	private boolean mine = false;
	private boolean open = false;
	private boolean flag = false;

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
		this.flag = true;
		
	}

	public boolean isLose() {
		return isOpen() && isMine();
	}
	

}
