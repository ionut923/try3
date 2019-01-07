package steps.frontend.flowSteps;

import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.Steps;
import steps.frontend.BookingSteps;
import steps.frontend.HeaderSteps;

public class PageNavigationFlowSteps {

	@Steps
	BookingSteps bookingSteps;
	@Steps
	HeaderSteps headerSteps;

	@StepGroup
	public void goToMyBookings() {
		headerSteps.selectHeader("BOOKINGS");
		bookingSteps.checkBookings("My Bookings");
	}
}
