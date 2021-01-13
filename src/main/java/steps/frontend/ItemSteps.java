package steps.frontend;

import com.google.inject.Inject;

import dao.booking.BookingAbstractDao;
import entities.Booking;
import net.thucydides.core.annotations.Step;
import pages.ItemsPage;
import steps.AbstractSteps;
import tools.factories.BookingFactory;

public class ItemSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	ItemsPage itemsPage;
	@Inject
	BookingAbstractDao bookingAbstgractDao;
	@Inject
	BookingFactory bookingFactory;

	@Step
	public void bookItem(String itemTitle){
		Booking booking = bookingFactory.getBookingInstance();
		itemsPage.clickBookItem(itemTitle);
		itemsPage.selectStartDate(booking.getStartDate());
		itemsPage.selectStartHour(booking.getStartDate());
		itemsPage.selectEndDate(booking.getEndDate());
		itemsPage.selectEndHour(booking.getEndDate());
		itemsPage.saveBooking();
		
		bookingAbstgractDao.saveBooking(booking);

	}
	
	@Step
	public void verifyItemIsPresent(String itemTitle) {
		itemsPage.itemExists(itemTitle, true);
	}
}
