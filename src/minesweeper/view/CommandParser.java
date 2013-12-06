package minesweeper.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import minesweeper.engine.Position;

public class CommandParser {

	public CommandLine parse(String commandLine) {
		String regex = "([a-z]*)\\s?:\\s?(\\d+)\\s?,\\s?(\\d+)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(commandLine);
		if (!matcher.find()) {
			return null;
		}
		
		String x = matcher.group(2);
		String y = matcher.group(3);
		Position position = new Position(Integer.parseInt(x), Integer.parseInt(y));
		CommandLine command = new CommandLine(matcher.group(1).trim(), position);
		System.out.println(command);
		return command;
	}

}
