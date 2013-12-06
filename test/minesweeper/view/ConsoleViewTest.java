package minesweeper.view;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import minesweeper.engine.GridSize;
import minesweeper.engine.GridTest;

import org.junit.Test;

public class ConsoleViewTest {
	@Test
	public void render() throws Exception {
		ConsoleView view = new ConsoleView();
		String actual = view.render(GridTest.createBy(new GridSize(3, 3)));
		assertThat(actual, is("CCC\nCCC\nCCC\n"));
	}
}
