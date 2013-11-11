package Map;

import java.util.ArrayList;
import java.util.List;

public class RowOfGrid {
	private List<Square> squareList = new ArrayList<Square>();

	public RowOfGrid(int mapSizeCol) {
		for ( int i = 0 ; i < mapSizeCol ; i++ ){
			squareList.add(new Square());
		}
	}
	
	public void setMine(int col){
		squareList.get(col).setMine();
	}

	
	public boolean openSquare(int col) {
		return squareList.get(col).openSquare();
	}
	
	public boolean isSizeTrue(int col) {
		return squareList.size() == col;
	}
	
	public void setFlag(int col){
		squareList.get(col).setFlag();
	}
	
	public boolean isFlag(int col){
		return squareList.get(col).isFlag();
	}

	public boolean isNotGameOver() {
		for (Square space : squareList) {
			if ( space.isEmpty()){
				return true;
			}
		}
		return false;
	}
	
	public Boolean getMine(int col){
		return squareList.get(col).getMine();
	}


	public void printRow() {
		for (Square square : squareList){
			square.printSquare();
		}
		
	}
	
	public void setArroundMine(int col, int num){
		squareList.get(col).setAroundMine(num);
	}



}
