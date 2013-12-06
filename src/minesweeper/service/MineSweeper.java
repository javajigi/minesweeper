package minesweeper.service;

import javax.inject.Inject;

import minesweeper.engine.Grid;
import minesweeper.engine.GridFactory;
import minesweeper.engine.GridSize;
import minesweeper.engine.Position;
import minesweeper.engine.View;

import com.google.inject.Guice;
import com.google.inject.Injector;

import configure.MineSweeperModule;
import configure.ViewModule;

public class MineSweeper {
	private GridFactory gridFactory;
	private View view;
	private Grid grid;

	@Inject
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
		System.out.println(render());
	}
	
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new MineSweeperModule(), new ViewModule());
		MineSweeper mineSweeper = injector.getInstance(MineSweeper.class);
		mineSweeper.start(new GridSize(5, 5), 5);
	}
}
