package minesweeper.view;

import java.util.List;

import minesweeper.engine.Grid;
import minesweeper.engine.GridSize;
import minesweeper.engine.Square;

public class ConsoleView implements View {
	public String render(Grid grid) {
		List<Square> squares = grid.getSquares();
		StringBuilder sb = new StringBuilder();
		GridSize gridSize = grid.sizeOfGrid();
		
		for (int i = 1; i <= gridSize.getX(); i++) {
			for (int j = 1; j <= gridSize.getY(); j++) {
				Square square = squares.get(gridSize.indexOfSquare(i, j));
				sb.append(square.getSymbol());
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
