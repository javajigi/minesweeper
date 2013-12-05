package minesweeper;

import java.util.List;

class View {

	String render(Grid grid) {
		List<Square> squares = grid.getSquares();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < grid.sizeOfRow(); i++) {
			for (int j = 0; j < grid.sizeOfColumn(); j++) {
				int position = getPosition(grid, i, j);
				Square square = squares.get(position);
				sb.append(square.getCountOfNeighborMines());
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}

	static int getPosition(Grid grid, int x, int y) {
		return x * grid.sizeOfColumn() + y;
	}

}
