import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class cookieClicker_main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ema7a\\Desktop\\chromedriver114\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        driver.get("https://orteil.dashnet.org/cookieclicker/beta/");
        driver.manage().window().maximize();

        //select the language and accept all cookies
        driver.findElement(By.id("langSelect-EN")).click();

        Thread.sleep(500);
        driver.findElement(By.cssSelector("a[class='cc_btn cc_btn_accept_all']")).click();

        //choose a random bakery name
        Thread.sleep(1500);
        driver.findElement(By.id("bakeryName")).click();
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.id("promptOption1")).click();
            Thread.sleep(500);
        }
        driver.findElement(By.id("promptOption0")).click();

        //start clicking and buy the first cursor
        WebElement theBigCookie = driver.findElement(By.id("bigCookie"));
        for (int i = 0; i < 15; i++) {
            theBigCookie.click();
        }
        Thread.sleep(2000);
        WebElement cursor = driver.findElement(By.id("product0"));
        cursor.click();
        //driver.findElement(By.id("productPrice0")).click();

        //buy 10 cursors
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 50; j++) {
                theBigCookie.click();
            }
            Thread.sleep(3000);
            cursor.click();
        }

        //buy the first grandma
        WebElement grandma = driver.findElement(By.id("product1"));
        grandma.click();

        //closing achievements
        WebElement achievementsClose = driver.findElement(By.cssSelector("div[class='framed close sidenote']"));

        if (achievementsClose.isDisplayed()) {
            achievementsClose.click();
        }

    }




}
