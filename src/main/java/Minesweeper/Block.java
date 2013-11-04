package Minesweeper;

public class Block {
	private boolean show;
	private boolean mine;
	private boolean flag;

	Block(boolean mine) {
		this.flag = false;
		this.show = false;
		this.mine = mine;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public boolean isMine() {
		return mine;
	}

	public void setMine(boolean mine) {
		this.mine = mine;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public boolean isBomb() {
		return isShow() && isMine();
	}
}
