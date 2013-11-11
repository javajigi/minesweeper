package Map;

import java.util.ArrayList;
import java.util.List;

public class Grid {
	private List<RowOfGrid> rowOfGrid = new ArrayList<RowOfGrid>();
	private int mapSizeRow;
	private int mapSizeCol;
	private int mineNum;

	public Grid(int mapSizeRow, int mapSizeCol, int mineNum){
		this.mapSizeRow = mapSizeRow;
		this.mapSizeCol = mapSizeCol;
		this.mineNum = mineNum;
		init();
	}
	
	private void init(){
		for (int i = 0 ; i < mapSizeRow ; i++ ){
			rowOfGrid.add(new RowOfGrid(mapSizeCol));
		}
	}

	public boolean checkInit(int row, int col) {
		return rowOfGrid.size() == row && rowOfGrid.get(0).isSizeTrue(col);
	}
	
	public boolean isGameOver(){
		for (RowOfGrid row : rowOfGrid){
			if ( row.isNotGameOver())
				return false;
		}
		return true;
	}
	
	public void setFlag(int row, int col){
		rowOfGrid.get(row).setFlag(col);
	}
	
	public boolean isFlag(int row, int col){
		return rowOfGrid.get(row).isFlag(col);
	}
	
	public void openSquare(int row, int col){
		if (rowOfGrid.get(row).openSquare(col))
			System.out.println("gameover");
		else {
			System.out.println(viewAroundMine());
		}
	}
	
	private int viewAroundMine() {
		return 3;
	}

	public void printGrid(){
		for (RowOfGrid row : rowOfGrid){
			row.printRow();
		}
	}
	
	public void setMine(int row, int col){
		rowOfGrid.get(row).setMine(col);
	}
	
	
}
