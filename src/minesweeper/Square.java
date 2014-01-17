package minesweeper;

import org.junit.Test.None;

public class Square {
	private boolean mine = false;
	private boolean open = false;
	private boolean flag = false;
	private boolean dummy = false;
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

		
	/////////////////////////////////
	public boolean isDummy(){
		return dummy;
	}
	
	public void setDummy(){
		this.dummy = true;
	}
	
	public void putMine2() {
		mine = true;
	}


	public void increaseNearNumber() {
		numOfNearMines++;
	}

	public char openSquare2() {
		if (isDummy()){ //더미노드는 처리 
			return 'd';
		}
		
		this.open = true; //오픈 상태로 표시 
		
		if (isMine()){//마인일때 
			return 'm';
		}
		if (this.numOfNearMines != 0){ //주변에 지뢰가 있을때 
			return 'n';
		}
		return 0;
	}

	public char continueOpen() {
		if(isContinueOpen()){
			this.open = true;
		}
		return 'Y';
	}
	
	public boolean isContinueOpen(){
		return !(isDummy() || isMine() || numOfNearMines !=0);
	}
	
	/////////////////////////////////

}
