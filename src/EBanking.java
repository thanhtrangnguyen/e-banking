import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EBanking {

    private String acc = "1";
    private String password = "admin";
    private String wrongPass = "adnin";
    private String acc_get = "100001866";
    private String get_amount = "100000";
    private String content_bill = "Chuyển khoản";
    private String wrongAmount = "haii ba bon nam";
    private String label = "//label";
    private WebDriver driver;

    @BeforeClass
    public static void PreAll() {
        System.setProperty("webdriver.chrome.driver", "./src/driver/chromedriver.exe");
    }

    @Before
    public void Precodition() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://14.176.232.213:8080/EBankingWebsite/faces/admin/Login.xhtml");
    }

    @Test
    public void LoginPass() {
        Admin.EnterallFields(driver, acc, password);
        Admin.ClickOnSubmit(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List inform_loginPass = (driver.findElements(By.xpath(Admin.customerList)));
        if (inform_loginPass.size() == 1) {
            Assert.assertEquals("Đăng nhập thành công", true, true);
        } else {
            Assert.assertEquals("Đăng nhập thất bại", false, true);
        }
    }

    @Test
    public void LoginFail() {

        Admin.EnterWrongPass(driver, acc, wrongPass);
        Admin.ClickOnSubmit(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List inform_loginFail = (driver.findElements(By.xpath(Admin.submit)));
        if (inform_loginFail.size() == 1) {
            Assert.assertEquals("Đăng nhập ko thành công", true, true);
        } else {
            Assert.assertEquals("Sai pass nhưng vẫn đăng nhập được", false, true);
        }


    }

    @Test
    public void TestingDeposit() {
        Admin.EnterallFields(driver, acc, password);
        Admin.ClickOnSubmit(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Deposit.clickOnLink(driver);
        Deposit.TestDeposit(driver, acc_get, get_amount, content_bill);
        Deposit.Confirm(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        boolean informDepositPass = driver.findElement(By.xpath(Deposit.labelDeposit)).isDisplayed();
        //Assert.assertEquals(true, informDepositPass);
        Assert.assertTrue(informDepositPass);
    }

    @Test
    public void TestingDepositFail() {
        Admin.EnterallFields(driver, acc, password);
        Admin.ClickOnSubmit(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Deposit.clickOnLink(driver);
        Deposit.TestDepositFailMessage(driver, acc_get, wrongAmount, content_bill);
        Deposit.Confirm(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String validation_message = "Số tiền phải nhập bằng số";
        String inform_DepositFail = driver.findElement(By.xpath(label)).getText();
        Assert.assertEquals(validation_message, inform_DepositFail);
    }

    @Test
    public void TestingWithdraw() {
        Admin.EnterallFields(driver, acc, password);
        Admin.ClickOnSubmit(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Withdrawal.clickOnLnkWithdraw(driver);
        Withdrawal.EnterToWithdraw(driver, acc_get, get_amount, content_bill);
        Withdrawal.clickOnDeal(driver);
        boolean informWithdrawPass = driver.findElement(By.xpath(Withdrawal.labelWithdraw)).isDisplayed();
        Assert.assertEquals(true, informWithdrawPass);
    }

    @After
    public void After() {
        driver.quit();

    }

    @AfterClass
    public static void AfterClass() {
    }

}




