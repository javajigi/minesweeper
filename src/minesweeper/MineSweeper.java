package minesweeper;

public class MineSweeper {
	private GridFactory gridFactory;
	private View view;
	private Grid grid;

	public MineSweeper(GridFactory gridFactory, View view) {
		this.gridFactory = gridFactory;
		this.view = view;
	}

	public void openSquare(Position position) {
		grid.openSquare(position);
	}

	public String render() {
		return view.render(grid);
	}

	public void start(GridSize gridSize, int countOfMine) {
		grid = gridFactory.create(gridSize, countOfMine);
	}
}
