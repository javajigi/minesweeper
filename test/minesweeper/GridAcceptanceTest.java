package minesweeper;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GridAcceptanceTest {
	private Grid grid;
	
	@Before
	public void setup() {
		grid = new Grid(3, 3);
	}
	
	@Test
	public void Grid_최초_생성() {
		View view = new View();
		String actual = view.render(grid);
		assertThat(actual, is("CCC\nCCC\nCCC\n"));
	}

	@Test
	public void 특정_위치의_마인_열기() {
		grid.openSquare(new Position(2, 2));
		View view = new View();
		String actual = view.render(grid);
		assertThat(actual, is("CCC\nC0C\nCCC\n"));
	}
	
	@Test
	public void 이웃_마인_수() throws Exception {
		grid.putMine(new Position(1, 1));
		grid.openSquare(new Position(1, 2));
		grid.openSquare(new Position(2, 1));
		grid.openSquare(new Position(2, 2));
		View view = new View();
		String actual = view.render(grid);
		assertThat(actual, is("C1C\n11C\nCCC\n"));
	}

}
