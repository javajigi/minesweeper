package minesweeper;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class PositionTest {

	@Test
	public void init() {
		assertThat(Position.create(2, 3), is(Position.create(2, 3)));
	}
	
	@Test
	public void indexOfSquare() throws Exception {
		Position position = Position.create(2, 3);
		assertThat(position.indexOfSquare(1, 1), is(0));
		assertThat(position.indexOfSquare(1, 2), is(1));
		assertThat(position.indexOfSquare(2, 1), is(3));
		assertThat(position.indexOfSquare(2, 3), is(5));
	}

}
