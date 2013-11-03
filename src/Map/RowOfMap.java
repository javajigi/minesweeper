package Map;

import java.util.ArrayList;
import java.util.List;

public class RowOfMap {
	private List<Space> spaceList = new ArrayList<Space>();
	private int mineNum;

	public RowOfMap(int mapSizeCol, int mineNum) {
		this.mineNum = mineNum;
		for ( int i = 0 ; i < mapSizeCol ; i++ ){
			spaceList.add(new Space(mineNum));
		}
	}

	
	public void clickSpace(int col) {
		spaceList.get(col).clickSpace();
	}
	
	public boolean isSizeTrue(int col) {
		return spaceList.size() == col;
	}
	
	public void setFlag(int col){
		spaceList.get(col).setFlag();
	}
	
	public boolean isFlag(int col){
		return spaceList.get(col).isFlag();
	}

	public boolean isNotGameOver() {
		for (Space space : spaceList) {
			if ( space.isGetMine()){
				return true;
			}
			if ( space.isEmpty()){
				return true;
			}
		}
		return false;
	}



}
