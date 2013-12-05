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
		assertThat(renderView(grid), is("CCC\nCCC\nCCC\n"));
	}

	@Test
	public void 이웃_마인_수() throws Exception {
		grid.putMine(new Position(1, 1));
		grid.putMine(new Position(1, 1));
		grid.putMine(new Position(1, 3));
		
		grid.openSquare(new Position(1, 2));
		grid.openSquare(new Position(2, 1));
		grid.openSquare(new Position(2, 2));
		assertThat(renderView(grid), is("C2C\n12C\nCCC\n"));
	}

	private String renderView(Grid grid) {
		return new ConsoleView().render(grid);
	}
	
	@Test
	public void 이웃_마인_수가_0인_스퀘어를_여는_경우() throws Exception {
		grid.openSquare(new Position(1, 1));
		assertThat(renderView(grid), is("000\n000\n000\n"));
	}
	
	@Test
	public void rendering() throws Exception {
		grid = new Grid(5, 5);
		grid.putMine(new Position(1, 1));
		grid.putMine(new Position(2, 2));
		grid.putMine(new Position(3, 3));
		grid.putMine(new Position(4, 4));
		
		grid.openSquare(new Position(5, 1));
		String result = renderView(grid);
		System.out.println(result);
	}

}
