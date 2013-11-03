package Map;

public class Space {
	private boolean mine = false;
	private  boolean flag = false;
	private boolean empty = true;

	public Space(int mine) {
		if ( mine == 1){
			this.mine = true;
			clickSpace();
		}
		else{
			this.mine = false;
		}
	}
	
	public void clickSpace() {
		empty = false;
	}

	public boolean isGetMine() {
		if (flag == true){
			return false;
		}
		return mine;
	}

	public void setFlag(){
		this.flag = true;
		clickSpace();
	}

	public boolean isFlag() {
		return flag;
	}

	public boolean isEmpty() {
		return empty ;
	}

}
