package steps.validation;

import java.util.List;
import java.util.Objects;

import com.google.inject.Inject;

import constants.SerenityKeyConstants;
import dao.booking.BookingAbstractDao;
import entities.Booking;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
//import pages.BookingsPage;
import tools.utils.SerenitySessionUtils;

public class ItemValidationSteps {
	//BookingsPage bookingsPage;

	@Steps
	SoftValidation softValidation;
	
	@Inject
	BookingAbstractDao bookingAbstractDao;

	@Step
	public void validateBookedItems() {
		List<Booking> expectedBookings = bookingAbstractDao.getBookings();
		//List<Booking> actualdBookings = bookingsPage.getBookings(expectedBookings);
	//	validateBookings(expectedBookings, actualdBookings);
	}

	@Step
	public void validateItemsAreReturned() {
		List<Booking> expectedBookings = SerenitySessionUtils.getFromSession(SerenityKeyConstants.BOOKINGS);
	//	List<Booking> actualdBookings = bookingsPage.getBookings(expectedBookings);
	//	validateBookings(expectedBookings, actualdBookings);
	}

	private void validateBookings(List<Booking> expectedBookings, List<Booking> actualdBookings) {
		int counter = 0;
		for (Booking expectedBooking : expectedBookings) {

			Booking actualBooking = findBookingInList(expectedBooking, actualdBookings);
			
			if(Objects.nonNull(actualBooking)){
				counter++;
			}

			SoftValidation.verifyStringValuesIgnoreCase("status", expectedBooking.getStatus(),
					actualBooking.getStatus());
			SoftValidation.verifyStringValues("end date", expectedBooking.getEndDate(), actualBooking.getEndDate());
			SoftValidation.verifyStringValues("start date", expectedBooking.getStartDate(),
					actualBooking.getStartDate());
			SoftValidation.verifyStringValues("user", expectedBooking.getUser().getName(),
					actualBooking.getUser().getName());
			SoftValidation.verifyStringValues("item", expectedBooking.getItem().getTitle(),
					actualBooking.getItem().getTitle());
		}

		SoftValidation.verifyIntValues("no. of validations vs booking list size:", counter, expectedBookings.size());
		SoftValidation.verifyIntValues("booking list size:", actualdBookings.size(), expectedBookings.size());
		softValidation.printErrors();
	}

	private Booking findBookingInList(Booking searchedBooking, List<Booking> bookings) {
		return bookings.stream()
				.filter(booking -> booking.getItem().getTitle().contentEquals(searchedBooking.getItem().getTitle()))
				.filter(booking -> booking.getStartDate().contentEquals(searchedBooking.getStartDate())).findFirst()
				.orElse(null);
	}
}
