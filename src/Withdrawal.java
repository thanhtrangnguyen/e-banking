import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Withdrawal {
    public static String withdraw = "//input[@name='j_idt23:j_idt27']";
    public static String amount_money = "//input[@name='j_idt23:j_idt29']";
    public static String withdraw_content = "//input[@name='j_idt23:j_idt31']";
    public static String btn_Deal = "//input[@name='j_idt23:j_idt34']";
    public static String lnk_Withdraw = "//span[contains(text(),'Rút tiền')]";
    public static String labelWithdraw = "//*[contains(text(),'rút tiền  thành công')]";

    public static void clickOnLnkWithdraw(WebDriver driver) {
        driver.findElement(By.xpath(lnk_Withdraw)).click();
    }

    public static void EnterToWithdraw(WebDriver driver, String acc_get, String get_amount, String content_bill) {
        driver.findElement(By.xpath(withdraw)).sendKeys(acc_get);
        driver.findElement(By.xpath(amount_money)).sendKeys(get_amount);
        driver.findElement(By.xpath(withdraw_content)).sendKeys(content_bill);

    }

    public static void clickOnDeal(WebDriver driver) {
        driver.findElement(By.xpath(btn_Deal)).click();
    }
}
