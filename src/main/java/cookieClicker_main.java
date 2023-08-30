import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import static java.util.concurrent.TimeUnit.*;

public class cookieClicker_main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ema7a\\Desktop\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, MINUTES);
        driver.get("https://orteil.dashnet.org/cookieclicker/beta/");
        driver.manage().window().maximize();

        // select the language and accept all cookies
        driver.findElement(By.id("langSelect-EN")).click();

        Thread.sleep(500);
        driver.findElement(By.cssSelector("a[class='cc_btn cc_btn_accept_all']")).click();

        // choose a random bakery name
        Thread.sleep(1500);
        driver.findElement(By.id("bakeryName")).click();
        // randomize the name three times for fum
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.id("promptOption1")).click();
            Thread.sleep(500);
        }
        driver.findElement(By.id("promptOption0")).click();


        // buy 10 cursors
        WebElement theBigCookie = driver.findElement(By.id("bigCookie"));
        WebElement cursor = driver.findElement(By.id("product0"));

        int cursorTotal = 0;
        while (cursorTotal < 10) {
            theBigCookie.click();
            Thread.sleep(200);

            String[] cookieAmount = driver.findElement(By.cssSelector("div[id='cookies']")).getText().split(" ");
            String cookieAmountArr = cookieAmount[0];
            int cookieCount = Integer.parseInt(cookieAmountArr);

            int cursorPrice = Integer.parseInt(driver.findElement(By.id("productPrice0")).getText());
            if (cookieCount > cursorPrice) {
                // one second wait for the cursor to be interactable
                Thread.sleep(500);
                cursor.click();
                cursorTotal++;
            }
        }
        // buy 10 grandmas
        WebElement grandma = driver.findElement(By.id("product1"));
        int grandmaTotal = 0;
        while (grandmaTotal < 10) {
            theBigCookie.click();
            Thread.sleep(200);

            String[] cookieAmount = driver.findElement(By.cssSelector("div[id='cookies']")).getText().split(" ");
            String cookieAmountArr = cookieAmount[0];
            int cookieCount = Integer.parseInt(cookieAmountArr);

            int grandmaPrice = Integer.parseInt(driver.findElement(By.id("productPrice1")).getText());
            if (cookieCount > grandmaPrice) {
                Thread.sleep(500);
                grandma.click();
                grandmaTotal++;
            }
        }

        // buy 10 farms
        WebElement farm = driver.findElement(By.id("product2"));
        int farmTotal = 0;
        while (farmTotal < 10) {
            theBigCookie.click();
            Thread.sleep(200);

            String[] cookieAmount = driver.findElement(By.cssSelector("div[id='cookies']")).getText().split(" ");
            String cookieAmountArr = cookieAmount[0];
            int cookieCount = Integer.parseInt(cookieAmountArr);

            int farmPrice = Integer.parseInt(driver.findElement(By.id("productPrice2")).getText());
            if (cookieCount > farmPrice) {
                Thread.sleep(500);
                farm.click();
                farmTotal++;
            }
        }

        // close achievements
        WebElement achievementsClose = driver.findElement(By.cssSelector("div[class='framed close sidenote']"));

        if (achievementsClose.isDisplayed()) {
            achievementsClose.click();
        }

    }

}


