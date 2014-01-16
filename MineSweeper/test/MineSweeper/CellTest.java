package MineSweeper;

import static org.junit.Assert.*;

import org.junit.Test;

public class CellTest {

	@Test
	public void test() {
		Field field = Field.initField();
		
		field.initCurField();
		field.printField();
		
		field.setupMine(0, 0);
		assertEquals(true, field.isMine(0, 0));
		assertEquals(false, field.isMine(1, 0));
	}

}
