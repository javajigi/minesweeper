package Map;

import java.util.ArrayList;
import java.util.List;

public class Map {
	private List<RowOfMap> map = new ArrayList<RowOfMap>();
	private int mapSizeRow;
	private int mapSizeCol;
	private int mineNum;

	public Map(int mapSizeRow, int mapSizeCol, int mineNum){
		this.mapSizeRow = mapSizeRow;
		this.mapSizeCol = mapSizeCol;
		this.mineNum = mineNum;
		init();
	}
	
	private void init(){
		for (int i = 0 ; i < mapSizeRow ; i++ ){
			map.add(new RowOfMap(mapSizeCol, mineNum));
		}
	}

	public boolean checkInit(int row, int col) {
		return map.size() == row && map.get(0).isSizeTrue(col);
	}
	
	public boolean isGameOver(){
		for (RowOfMap row : map){
			if ( row.isNotGameOver())
				return false;
		}
		return true;
	}
	
	public void setFlag(int row, int col){
		map.get(row).setFlag(col);
	}
	
	public boolean isFlag(int row, int col){
		return map.get(row).isFlag(col);
	}
	
	public void clickSpace(int row, int col){
		map.get(row).clickSpace(col);
	}
	
}
