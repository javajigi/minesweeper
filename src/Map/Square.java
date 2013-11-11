package Map;

public class Square {
	private boolean mine = false;
	private  boolean flag = false;
	private boolean empty = true;
	private int aroundMine = 0;
	
	public void setMine(){
		this.mine = true;
		openSquare();
	}
	
	
	public boolean openSquare() {
		if(getMine()){
			return true;
		}
		empty = false;
		
		return false;
	}
	
	public boolean getMine(){
		return mine;
	}

	public void setFlag(){
		this.flag = true;
		openSquare();
	}

	public boolean isFlag() {
		return flag;
	}

	public boolean isEmpty() {
		return empty ;
	}

	public void printSquare() {
		if (flag == true){
			System.out.println("falg");
		}
		else if (mine == true){
			System.out.println("mine");
		}
		System.out.println(aroundMine);
	}
	
	public void setAroundMine(int num){
		this.aroundMine = num;
	}

}
