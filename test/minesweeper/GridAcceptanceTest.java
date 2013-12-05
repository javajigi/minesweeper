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
		grid.openSquare(new Position(1, 2));
		grid.openSquare(new Position(2, 1));
		grid.openSquare(new Position(2, 2));
		assertThat(renderView(grid), is("C1C\n11C\nCCC\n"));
	}

	private String renderView(Grid grid) {
		return new View().render(grid);
	}
	
	@Test
	public void 이웃_마인_수가_0인_스퀘어를_여는_경우() throws Exception {
		grid.openSquare(new Position(1, 1));
		assertThat(renderView(grid), is("000\n000\n000\n"));
	}

}
