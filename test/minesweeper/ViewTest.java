package minesweeper;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class ViewTest {
	@Test
	public void render() throws Exception {
		View view = new View();
		String actual = view.render(new Grid(2, 2));
		assertThat(actual, is("00\n00\n"));
	}
	
	@Test
	public void getPosition() throws Exception {
		Grid grid = new Grid(2, 3);
		assertThat(View.getPosition(grid, 0, 0), is(0));
		assertThat(View.getPosition(grid, 0, 1), is(1));
		assertThat(View.getPosition(grid, 1, 0), is(3));
		assertThat(View.getPosition(grid, 1, 2), is(5));
	}
}
