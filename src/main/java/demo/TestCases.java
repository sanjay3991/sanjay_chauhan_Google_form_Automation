package demo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.time.LocalDateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public void testCase01() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    try {
        System.out.println("Start Test case: testCase01");
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");

        WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));
        nameElement.click();
        nameElement.sendKeys("Sanjay Chauhan");

        long epoch = System.currentTimeMillis() / 1000;
        WebElement practicingAutomation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@aria-label='Your answer']")));
        practicingAutomation.click();
        practicingAutomation.sendKeys("I want to be the best QA Engineer!" + epoch);

        WebElement experience = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='i16']//div[@class='AB7Lab Id5V1']")));
        experience.click();

        WebElement java = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='i30']//div[@class='uHMk6b fsHoPb']")));
        java.click();

        WebElement selenium = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='i33']//div[@class='uHMk6b fsHoPb']")));
        selenium.click();

        WebElement testNg = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='i39']//div[@class='uHMk6b fsHoPb']")));
        testNg.click();

        WebElement dropDown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Choose']")));
        dropDown.click();
        

        Thread.sleep(1000);
        WebElement selectMr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option']//span[@class='vRMGwf oJeWuf'][normalize-space()='Mr']")));
        selectMr.click();
        Thread.sleep(1000);

      
        LocalDate date7DaysAgo = LocalDate.now().minusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = date7DaysAgo.format(formatter);

        WebElement dateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='date']")));
        dateInput.sendKeys(formattedDate);

        LocalDateTime currentTime = LocalDateTime.now(); 
        String hour = String.valueOf(currentTime.getHour());
        String min = String.valueOf(currentTime.getMinute());

        WebElement Hour = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@jsname='YPqjbf'])[3]")));
        Hour.sendKeys(hour);

        WebElement Min = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@jsname='YPqjbf'])[4]")));
        Min.sendKeys(min);


        WebElement Submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='l4V7wb Fxmcue'])[1]")));
        Submit.click();

        WebElement Verify_Response = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='vHW8K']")));
        if(Verify_Response.getText().equals("Thanks for your response, Automation Wizard!")){
            System.out.println("Successfully submitted the response");
        }

        System.out.println("End Test case: testCase01");
    } catch (Exception e) {
        e.printStackTrace();
    }
}



}
