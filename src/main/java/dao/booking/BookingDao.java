package dao.booking;

import java.util.List;

import constants.SerenityKeyConstants;
import entities.Booking;
import tools.utils.SerenitySessionUtils;

public class BookingDao implements BookingAbstractDao {

	@Override
	public void saveBooking(Booking booking) {
		System.out.println("Saving booking...");
		SerenitySessionUtils.saveObjectInSerenityList(SerenityKeyConstants.BOOKINGS, booking);

	}

	@Override
	public List<Booking> getBookings() {
		return SerenitySessionUtils.getFromSession(SerenityKeyConstants.BOOKINGS);
	}

}
