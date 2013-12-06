package minesweeper.view;

import minesweeper.engine.Grid;

public interface View {
	String render(Grid grid);
}