package minesweeper;

import java.util.List;

class ConsoleView implements View {
	public String render(Grid grid) {
		List<Square> squares = grid.getSquares();
		StringBuilder sb = new StringBuilder();
		GridSize position = grid.sizeOfGrid();
		for (int i = 1; i <= position.getX(); i++) {
			for (int j = 1; j <= position.getY(); j++) {
				Square square = squares.get(position.indexOfSquare(i, j));
				sb.append(square.getSymbol());
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
}
