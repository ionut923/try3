package steps;

import injector.AppInjector;
import net.thucydides.core.steps.ScenarioSteps;

public class AbstractSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;

	public AbstractSteps() {
		super();
		AppInjector.getInjector().injectMembers(this);
	}
}
