import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPageFirst {
    private WebDriver driver;
    //заголовок страницы
    private By header = By.className("Order_Header__BZXOb");
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metroField = By.xpath(".//input[@placeholder='* Станция метро']");
    private By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath(".//button[text()='Далее']");

    public OrderPageFirst(WebDriver driver) {
        this.driver = driver;
    }

    private void waitForLoadPage() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(header).getText() != null
                && !driver.findElement(header).getText().isEmpty()
        ));
    }

    private void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    private void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    private void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    private void setMetro(String metro) {
        driver.findElement(metroField).sendKeys(metro);
    }

    private void setPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    private void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void fillFormAndClickNextButton(String name, String surname, String address, String metro, String phone) {
        waitForLoadPage();
        setName(name);
        setSurname(surname);
        setAddress(address);
        setMetro(metro);
        setPhone(phone);
        clickNextButton();
    }
}
