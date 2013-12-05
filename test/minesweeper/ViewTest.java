package minesweeper;

import static minesweeper.GridTest.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class ViewTest {
	@Test
	public void render() throws Exception {
		View view = new View();
		String actual = view.render(THREE_BY_THREE);
		assertThat(actual, is("000\n000\n000\n"));
	}
}
