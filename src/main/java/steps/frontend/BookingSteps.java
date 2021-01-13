package steps.frontend;

import java.util.List;

import constants.DateConstants;
import constants.SerenityKeyConstants;
import constants.StatusConstants;
import entities.Booking;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.Title;
//import pages.BookingsPage;
import steps.AbstractSteps;
import tools.utils.DateUtils;
import tools.utils.SerenitySessionUtils;

public class BookingSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	//BookingsPage bookingsPage;

	@StepGroup
	public void returnAllItems() {
		List<Booking> bookings = SerenitySessionUtils.getFromSession(SerenityKeyConstants.BOOKINGS);
		for (Booking booking : bookings) {
			if (booking.getStatus().equalsIgnoreCase(StatusConstants.ACCEPTED))
				returnItem(booking);
		}
	}
	@Title("Return items")
	@StepGroup
	public void returnItems(List<Booking> bookings) {
		for (Booking booking : bookings) {
			returnItem(booking);
		}
	}

	@Title("Return item")
	@Step
	public void returnItem(Booking booking) {
		//bookingsPage.returnItem(booking.getItem().getTitle());
		booking.setEndDate(DateUtils.convertLocalDateTimeToString(DateUtils.getCurrentDate(), DateConstants.WW_PATTERN));
		booking.setStatus(StatusConstants.COMPLETED);
	}

	@Step
	public void checkBookings(String bookingCategory) {
	//	bookingsPage.checkBookingCategory(bookingCategory);
	}
}
