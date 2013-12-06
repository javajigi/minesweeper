package configure;

import minesweeper.GridFactory;
import minesweeper.RandomGridFactory;

import com.google.inject.AbstractModule;

public class MineSweeperModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(GridFactory.class).to(RandomGridFactory.class);
	}
}
