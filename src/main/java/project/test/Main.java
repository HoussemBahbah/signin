package project.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.Select;




public class Main {
    static Wait<WebDriver> wait;
    public static void main(String[] args) {
        boolean result1;
        System.setProperty("webdriver.chrome.driver", "G:\\My Programs\\NetBeansProjects\\TestSelenium\\chromedriver.exe");
        WebDriver driver =new ChromeDriver();
       
        try {
            
            result1 = testForm(driver);
        } catch(Exception e) {
            e.printStackTrace();
            result1 = false;
        } finally {
            driver.close();
        }

        
        System.out.println("Result1 Test " + (result1? "passed." : "failed."));
        if (!result1) {
          //  System.exit(1);
          System.out.println("the test failed");
        }
    }

    


public static boolean testText(WebDriver driver){
    driver.get("http://selenium.thinkcode.se/requestPassword");
    driver.manage().window().maximize();

    driver.findElement(By.id("account")).sendKeys("this password");
    driver.findElement(By.name("submit")).click();
    try{
    Thread.sleep(2000);
}catch(Exception e){} 
WebElement headline = driver.findElement(By.id("confirmation"));
return ( headline.getText().equals("A new password has been sent to this password"));
} 
    

public static boolean testForm(WebDriver driver){
    driver.get("http://selenium.thinkcode.se/buyCurrency");
    driver.manage().window().maximize();

    driver.findElement(By.id("buy")).click();
    Select dropdown = new Select(driver.findElement(By.id("toCurrency")));
    dropdown.selectByVisibleText("USD");
    driver.findElement(By.id("amount")).sendKeys("20");
    Select dropdown2 = new Select(driver.findElement(By.id("fromCurrency")));
    dropdown2.selectByVisibleText("EUR");
    driver.findElement(By.id("orderCurrency")).submit();
    try{
        Thread.sleep(2000);
    }catch(Exception e){} 


WebElement headline = driver.findElement(By.id("result"));
return ( headline.getText().equals("Buying 20 USD will cost you 26 EUR."));

} 




    
}