package minesweeper.view;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import minesweeper.engine.Position;

import org.junit.Test;

public class CommandParserTest {
	@Test
	public void start() throws Exception {
		CommandParser parser = new CommandParser();
		CommandLine command = parser.parse("open:1,1");
		assertThat(command,  is(new CommandLine("open", new Position(1, 1))));
		
		command = parser.parse("open : 1 , 1");
		assertThat(command,  is(new CommandLine("open", new Position(1, 1))));
	}
}
