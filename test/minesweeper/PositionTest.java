package minesweeper;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PositionTest {
	@Test
	public void init() {
		assertThat(new Position(2, 3), is(new Position(2, 3)));
	}
}
