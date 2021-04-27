import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Admin {

    public static String account = "//input[@name='j_idt9:id1']";
    public static String pass = "//input[@name='j_idt9:pwd1']";
    public static String submit = "//span[contains(text(),'Login')]";
    public static String customerList = "//span[contains(text(),'Danh sách khách hàng')]";

    //Enter
    public static void EnterallFields(WebDriver driver, String acc, String password) {
        //  System.out.println(acc);
        driver.findElement(By.xpath(account)).sendKeys(acc);
        driver.findElement(By.xpath(pass)).sendKeys(password);
    }

    public static void EnterWrongPass(WebDriver driver, String acc, String wrongPass) {
        driver.findElement(By.xpath(account)).sendKeys(acc);
        driver.findElement(By.xpath(pass)).sendKeys(wrongPass);
    }


    //click button ĐĂng nhập
    public static void ClickOnSubmit(WebDriver driver) {
        driver.findElement(By.xpath(submit)).click();
    }


}