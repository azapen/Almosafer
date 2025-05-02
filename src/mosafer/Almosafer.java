package mosafer;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Almosafer extends TestDataAndFunctions {

	@BeforeTest
	public void mySetup() {

		EnterTheWebsite();
	}

	@Test(priority = 1)

	public void CheckTheLanguage() {

		// driver.findElement(By.className("sc-imABML jBAuIA")).click();

		String ActualLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");
		Assert.assertEquals(ActualLanguage, ExpectedLanguage);

	}

	@Test(priority = 2)

	public void CheckTheCurrency() {

		String ActualCurrency = driver.findElement(By.cssSelector(".sc-hUfwpO.kAhsZG")).getText();

		Assert.assertEquals(ActualCurrency, ExpectedCurrency);

	}

	@Test(priority = 3)

	public void CheckTheContactNumber() {

		String ActualNumber = driver.findElement(By.tagName("strong")).getText();

		Assert.assertEquals(ActualNumber, ExpectedNumber);

	}

	@Test(priority = 4)

	public void CheckqitafLogo() {

		JS.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		WebElement Footer = driver.findElement(By.tagName("footer"));
		WebElement QitafLogo = Footer.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-lcpuFF.jipXfR"));
		boolean ActualResult = QitafLogo.isDisplayed();
		Assert.assertEquals(ActualResult, ExpectedResultForQitafLogo);
	}

	@Test(priority = 5)

	public void CheckHotelTabIsNotSelectedByDefault() {

		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));

		boolean isHotelTabSelected = HotelTab.isSelected();
		Assert.assertFalse(isHotelTabSelected, "Hotel tab should not be selected by default");

	}

	@Test(priority = 6)
	public void CheckDepatureDate() {

		WebElement DepatureDateField = driver
				.findElement(By.cssSelector("div[class='sc-bYnzgO sc-cPuPxo jNskcH'] span[class='sc-dXfzlN iPVuSG']"));

		String ActualDepatureDate = DepatureDateField.getText();
		Assert.assertEquals(ActualDepatureDate, ExpectedDepartureDate);

	}

	@Test(priority = 7)
	public void CheckReturnDate() {

		WebElement ActualReturnField = driver
				.findElement(By.cssSelector("div[class='sc-bYnzgO sc-hvvHee aiGEY'] span[class='sc-dXfzlN iPVuSG']"));
		String ActualReturnDate = ActualReturnField.getText();
		Assert.assertEquals(ActualReturnDate, ExpectedReturnDate);

	}

	// This Test Contains More Than One Test
	@Test(priority = 8)
	public void RandomlyChangeTheLanguage_And_Random_Ar_Or_En_Cities() {

		// RandomlyChangeTheLanguage
		driver.get(MyWebsites[RandomWebsiteIndex]);

		// Switching To Hotel Search Tab
		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		HotelTab.click();

		// Checking The Language And Then Send Random City Name Based On The Language
		CheckTheLanguageAndSendRandomCityName();

		// Random Selecting For The Number Of The Visitors
		RandomlySelectNumberOfVisitors();

	}

	@Test(priority = 9)
	public void CheckThatTheNewSearchPageIsFullyLoaded() {
		// To Check The Page Is Fully Loaded We Can Check The Last Element Appears In
		// The New Page So By Observing The Page Its This Line In Arabic :"(تيجة البحث
		// عدد) مكان إقامة في (سم المدينة )", In English : "(Number Of Hotel Result)
		// stays found in (Name Of The City)"

		WebElement TheLastElementInTheNewPageField = driver
				.findElement(By.xpath("//span[@data-testid='srp_properties_found']"));

		String TheLastElementInTheNewPage = TheLastElementInTheNewPageField.getText();

		boolean ActualValueToCheckTheNewPage = TheLastElementInTheNewPage.contains("مكان")
				|| TheLastElementInTheNewPage.contains("found");

		assertEquals(ActualValueToCheckTheNewPage, ExpectedValueToCheckTheNewPage);
	}
}
