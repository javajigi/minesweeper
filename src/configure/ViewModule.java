package configure;

import minesweeper.view.ConsoleView;
import minesweeper.view.View;

import com.google.inject.AbstractModule;

public class ViewModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(View.class).to(ConsoleView.class);
	}
}
