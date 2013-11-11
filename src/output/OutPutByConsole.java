package output;

import board.Grid;
import board.Position;
import board.Square;

public class OutPutByConsole {
	public static final String NEWLINE = System.getProperty("line.separator");
	Position pos = new Position();
	Square sq;
	
	public String showAll(Grid grid) {
		String output = "";
		for (int i = 0; i < grid.girdSizeX; i++) {
			for (int j = 0; j < grid.girdSizeY; j++) {
				pos.x = i;
				pos.y = j;
				sq = grid.getSquare(pos);
				if(sq.isMine()) {
					output += " M ";
				} else {
					output += " O ";
				}
			}
			output += NEWLINE;
		}
		return output;
	}
}
