package tools.factories;

import constants.DateConstants;
import constants.SerenityKeyConstants;
import constants.StatusConstants;
import entities.Booking;
import entities.Item;
import entities.User;
import tools.utils.DateUtils;
import tools.utils.SerenitySessionUtils;

public class BookingFactory {

	public Booking getBookingInstance() {
		User sessionUser = SerenitySessionUtils.getFromSession(SerenityKeyConstants.USER);
		Item item = SerenitySessionUtils.getFromSession(SerenityKeyConstants.ITEM);
		Booking booking = new Booking();

		booking.setStatus(StatusConstants.ACCEPTED);
		booking.setStartDate(
				DateUtils.convertLocalDateTimeToString(DateUtils.addHoursToCurrentDate(2), DateConstants.WW_PATTERN));
		booking.setEndDate(
				DateUtils.convertLocalDateTimeToString(DateUtils.addHoursToCurrentDate(3), DateConstants.WW_PATTERN));
		booking.setItem(item);
		booking.setUser(sessionUser);

		return booking;
	}

	public static Booking getApiBookingInstance() {
		Item item = SerenitySessionUtils.getFromSession(SerenityKeyConstants.ITEM);
		User userRequest = SerenitySessionUtils.getFromSession(SerenityKeyConstants.USER);
		Booking booking = new Booking();
		booking.setItemId(item.getId());
		booking.setUserId(userRequest.getId());
		booking.setItem(item);
		booking.setUser(userRequest);
		booking.setStartDate(
				DateUtils.convertLocalDateTimeToString(DateUtils.getCurrentDate(), DateConstants.WW_PATTERN));
		booking.setEndDate(
				DateUtils.convertLocalDateTimeToString(DateUtils.addHoursToCurrentDate(1), DateConstants.WW_PATTERN));
		booking.setClientTime(
				DateUtils.convertLocalDateTimeToString(DateUtils.getCurrentDate(), DateConstants.WW_PATTERN));

		return booking;
	}

	public static Booking getApiBookingReturnInstance() {
		Booking booking = SerenitySessionUtils.getFromSession(SerenityKeyConstants.BOOKING);
		booking.setReturnItem(true);

		return booking;
	}
}
