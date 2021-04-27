import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Deposit {
    public static String lnk_Deposit = "//span[contains(text(),'Nộp Tiền')]";
    public static String accGet = "//input[@name='j_idt23:j_idt27']";
    public static String amount = "//input[@name='j_idt23:j_idt29']";
    public static String content = "//input[@name='j_idt23:j_idt31']";
    public static String confirm = "//input[@name='j_idt23:j_idt33']";
    public static String labelDeposit = "//*[contains(text(),'nộp tiền thành công')]";

    public static void clickOnLink(WebDriver driver) {
        driver.findElement(By.xpath(lnk_Deposit)).click();
    }

    public static void TestDeposit(WebDriver driver, String acc_get, String get_amount, String content_bill) {
        driver.findElement(By.xpath(accGet)).sendKeys(acc_get);
        driver.findElement(By.xpath(amount)).sendKeys(get_amount);
        driver.findElement(By.xpath(content)).sendKeys(content_bill);


    }

    public static void TestDepositFailMessage(WebDriver driver, String acc_get, String wrongAmount, String content_bill) {
        driver.findElement(By.xpath(accGet)).sendKeys(acc_get);
        driver.findElement(By.xpath(amount)).sendKeys(wrongAmount);
        driver.findElement(By.xpath(content)).sendKeys(content_bill);
    }

    public static void Confirm(WebDriver driver) {
        driver.findElement(By.xpath(confirm)).click();
    }

}

