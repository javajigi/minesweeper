package minesweeper.view;

import minesweeper.engine.Position;

public class CommandLine {
	private String command;
	private Position position;

	public CommandLine(String command, Position position) {
		this.command = command;
		this.position = position;
	}
	
	public String getCommand() {
		return command;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public boolean isOpenCommand() {
		return "open".equals(command);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((command == null) ? 0 : command.hashCode());
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommandLine other = (CommandLine) obj;
		if (command == null) {
			if (other.command != null)
				return false;
		} else if (!command.equals(other.command))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CommandLine [command=" + command + ", position=" + position + "]";
	}
}
