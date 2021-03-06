package tests;

import org.junit.Before;
import org.openqa.selenium.WebDriver;

import injector.AppInjector;
import net.thucydides.core.annotations.Managed;

public class BaseTest {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;
	

	@Before
	public void setup() {
		System.setProperty("http.proxyHost", "localhost");
		System.setProperty("http.proxyPort", "8282");
		System.setProperty("https.proxyHost", "localhost");
		System.setProperty("https.proxyPort", "8282");
		System.setProperty("env", "qa-env");

		AppInjector.getInjector().injectMembers(this);
	}
}
