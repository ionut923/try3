package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;

import constants.StatusConstants;
import entities.Booking;
import entities.Item;
import entities.User;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class BookingsPage extends AbstractPage {

	@FindBy(css = "ul[class*='bookings-listing']")
	WebElementFacade itemBookingsContainer;
	@FindBy(css = "button#item-return-item")
	WebElementFacade returnItemConfirmationPopup;
	@FindBy(css = "ul[class*='nav-tabs']")
	WebElementFacade headerContainer;

	public void checkBookingCategory(String header) {

		List<WebElementFacade> headerList = headerContainer.thenFindAll(By.cssSelector("li a"));
		WebElementFacade headerElement = headerList.stream().map(element -> {
			element.getText().replace("\"", "");
			return element;
		}).filter(element -> element.getText().contentEquals(header)).findFirst().orElse(null);

		Assert.assertTrue("The element has not been found", headerElement != null);

		headerElement.click();
	}

	public void returnItem(String itemName) {
		WebElementFacade selectedBooking = selectBookingToReturn(itemName);
		selectedBooking.find(By.cssSelector("button[class*='return-item']")).click();
		returnItemConfirmationPopup.click();
	}

	/**
	 * @param bookingList
	 * @return actual booking list from ui, filtered by expected booking list in
	 *         case that there are more bookings than expected.
	 */
	public List<Booking> getBookings(List<Booking> bookingList) {
		List<Booking> createdBookings = new ArrayList<>();
		List<WebElementFacade> selectedBookings = selectBookings(bookingList);

		for (WebElementFacade booking : selectedBookings) {
			Booking bookedItem = new Booking();
			String actualItemName = booking
					.find(By.cssSelector("div[class*='booking-details-container'] ul li:nth-child(1) a")).getText()
					.trim();
			String from = booking.find(
					By.cssSelector("div[class*='booking-details-container'] ul li:nth-child(2) span:nth-child(2)"))
					.getText();
			String to = booking.find(
					By.cssSelector("div[class*='booking-details-container'] ul li:nth-child(2) span:nth-child(4)"))
					.getText();
			String userName = booking
					.find(By.cssSelector("div[class*='booking-details-container'] ul li:nth-child(3) a")).getText()
					.trim();

			User user = new User();
			user.setName(userName);
			Item item = new Item();
			item.setTitle(actualItemName);

			bookedItem.setStatus(booking.find(By.cssSelector(".status-label")).getText());
			bookedItem.setStartDate(from);
			bookedItem.setEndDate(to);
			bookedItem.setUser(user);
			bookedItem.setItem(item);

			createdBookings.add(bookedItem);
		}
		return createdBookings;
	}
	
	

	public List<WebElementFacade> selectBookings(List<Booking> expectedBookingList) {

		List<WebElementFacade> bookingsInUi = itemBookingsContainer
				.thenFindAll(By.cssSelector("div[class*='item-booking-container']"));

		Predicate<WebElementFacade> bookingCheck = bookingInUi -> expectedBookingList.stream()
				.anyMatch(expectedBooking -> expectedBooking.getItem().getTitle() == bookingInUi
						.find(By.cssSelector("div[class*='booking-details-container'] ul li:nth-child(1) a")).getText()
						.trim()
						&& expectedBooking.getStartDate() == bookingInUi
								.find(By.cssSelector(
										"div[class*='booking-details-container'] ul li:nth-child(2) span:nth-child(2)"))
								.getText());

		return bookingsInUi.stream().filter(bookingCheck).collect(Collectors.toList());
	}
	
	

	public WebElementFacade selectBookingToReturn(String itemName) {
		List<WebElementFacade> bookings = itemBookingsContainer
				.thenFindAll(By.cssSelector("div[class*='item-booking-container']"));

		WebElementFacade headerElement = bookings.stream()
				.filter(booking -> booking
						.find(By.cssSelector("div[class*='booking-details-container'] ul li:nth-child(1) a")).getText()
						.trim().contentEquals(itemName))
				.filter(booking -> booking.find(By.cssSelector(".status-label")).getText()
						.contentEquals(StatusConstants.ACCEPTED))
				.filter(booking -> booking.containsElements(By.cssSelector("button[class*='return-item']"))).findAny()
				.orElse(null);

		Assert.assertTrue("The element has not been found", headerElement != null);

		return headerElement;
	}
}
