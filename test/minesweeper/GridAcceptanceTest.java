package minesweeper;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
	public void 모든_스퀘어_폭탄이_아닐_경우() {
		grid.openSquare(Position.create(2, 2));
		View view = new View();
		String actual = view.render(grid);
		assertThat(actual, is("000\n000\n000\n"));
	}

}
