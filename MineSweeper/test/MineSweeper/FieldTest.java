package MineSweeper;
import static org.junit.Assert.*;

import org.junit.Test;

public class FieldTest {
	
	@Test
	public void printFieldTest() {
		Field defaultField = Field.initField();
		String buffer = defaultField.toString();
		defaultField.printField();
		assertEquals("x x " + Field.getNewLine()
				   + "x x " + Field.getNewLine(), buffer);
		
		defaultField = Field.initField(4);
		buffer = defaultField.toString();
		defaultField.printField();
		assertEquals("x x x x " + Field.getNewLine()
				   + "x x x x " + Field.getNewLine()
				   + "x x x x " + Field.getNewLine()
				   + "x x x x " + Field.getNewLine() , buffer);
	}
	
	@Test
	public void mineTest() {
		Field field = Field.initField(8);
		field.initCurField();
		
		field.setupMine(0, 0);
		field.setupMine(0, 1);
		field.setupMine(1, 0);
		
		field.printField();
		
		assertEquals(2, field.getNumOfMinesAround(0, 0));
		assertEquals(2, field.getNumOfMinesAround(1, 0));
		assertEquals(3, field.getNumOfMinesAround(1, 1));
		assertEquals(1, field.getNumOfMinesAround(0, 2));
	}
	
}
