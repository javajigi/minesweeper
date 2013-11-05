package Minesweeper;

public class Block {
	private boolean show;
	private boolean mine;
	private boolean flag;

	private int xAxis, yAxis;

	Block(int xAxis, int yAxis) {
		this.flag = false;
		this.show = false;
		this.mine = false;
		this.xAxis = xAxis + 1;
		this.yAxis = yAxis + 1;
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

	public int getxAxis() {
		return xAxis;
	}

	public int getyAxis() {
		return yAxis;
	}
}
