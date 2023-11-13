package sauce_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Project-4 - ProjectName : com-saucedemo
 * BaseUrl = https://www.saucedemo.com/
 * 1. Setup Chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Navigate to baseUrl
 * 11. Refresh the page.
 * 12. Close the browser.
 */

public class SauceDemo {
    static String browser = "Chrome";
    static String baseUrl = "https://www.saucedemo.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
        driver.get(baseUrl);//Open Url
        driver.manage().window().maximize();//Window Maximize
        System.out.println(driver.getTitle());//Print the title of page
        System.out.println(driver.getCurrentUrl());//Print the current URL
        System.out.println(driver.getPageSource());//Print the page Source

        //Enter email to email Field
        WebElement emailFields = driver.findElement(By.id("user-name"));
        emailFields.sendKeys("standard_user");

        //Enter password to password field
        WebElement passwordFields = driver.findElement(By.id("password"));
        passwordFields.sendKeys("secret_sauce");

        //Click on login Button
        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();
        System.out.println(driver.getCurrentUrl());//Print the Current Url
        driver.navigate().to("https://www.saucedemo.com/");//Navigate to baseUrl
        driver.quit();//Close the Browser
    }

}
