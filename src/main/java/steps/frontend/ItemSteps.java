package steps.frontend;

import constants.SerenityKeyConstants;
import entities.Booking;
import net.thucydides.core.annotations.Step;
import pages.ItemsPage;
import steps.AbstractSteps;
import tools.factories.BookingFactory;
import tools.utils.SerenitySessionUtils;

public class ItemSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	ItemsPage itemsPage;

	@Step
	public void bookItem(String itemTitle){
		Booking booking = BookingFactory.getBookingInstance();
		itemsPage.clickBookItem(itemTitle);
		itemsPage.selectStartDate(booking.getStartDate());
		itemsPage.selectStartHour(booking.getStartDate());
		itemsPage.selectEndDate(booking.getEndDate());
		itemsPage.selectEndHour(booking.getEndDate());
		itemsPage.saveBooking();

		SerenitySessionUtils.saveObjectListInSerenitySession(SerenityKeyConstants.BOOKINGS, booking);
	}
	
	@Step
	public void verifyItemIsPresent(String itemTitle) {
		itemsPage.itemExists(itemTitle, true);
	}
}
