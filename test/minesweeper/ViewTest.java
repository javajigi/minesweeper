package minesweeper;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ViewTest {
	@Test
	public void render() throws Exception {
		View view = new View();
		String actual = view.render(new Grid(3, 3));
		assertThat(actual, is("CCC\nCCC\nCCC\n"));
	}
}
