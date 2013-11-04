package board;

public class Point {

	private boolean open;
	private boolean boom;
	private int hint;
	private boolean flag;
	
	public Point() {
		flag=false;
		open=false;
		boom=false;
		hint=0;
	}
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isBoom() {
		return boom;
	}

	public void setBoom(boolean boom) {
		this.boom = boom;
	}

	public int getHint() {
		return hint;
	}

	public void setHint(int hint) {
		this.hint = hint;
	}
}
