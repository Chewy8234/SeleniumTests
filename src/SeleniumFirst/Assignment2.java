package SeleniumFirst;

import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.edge.EdgeDriver;

import javax.swing.*;
import java.util.List;

public class Assignment2 {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.edge.driver","C:\\Users\\sebas\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();
        // Add and delete elements
        WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        WebElement lastName =  driver.findElement(By.xpath("//input[@placeholder='Last Name']"));

        // Add Element
        firstName.sendKeys("Sebastian");
        lastName.sendKeys("Campos");
        Thread.sleep(2000);

        // Delete Element
        firstName.clear();
        lastName.clear();
        Thread.sleep(2000);

        // Add Element
        firstName.sendKeys("Sebastian");
        lastName.sendKeys("Campos");
        Thread.sleep(2000);

        //text in textbox
        WebElement address = driver.findElement(By.cssSelector("textarea[ng-model='Adress']"));
        address.sendKeys("10501 FGCU Blvd, Fort Myers, FL 33965");

        //CheckBox
        WebElement option1 = driver.findElement(By.id("checkbox1"));
        option1.click();
        if(option1.isSelected())
        {
            System.out.println("Checkbox is toggled on");
        }
        else
        {
            System.out.println("Something went wrong");
        }

        Thread.sleep(3000);

        // Searches for male button using cssSelector
        WebElement maleRadioButton = driver.findElement(By.cssSelector("input[type='radio'][value='Male']"));

        // Clicks button for male
        maleRadioButton.click();

        Thread.sleep(3000);
        //Dropdown Menu
        WebElement skillsMenu = driver.findElement(By.id("Skills"));
        Select skills = new Select(skillsMenu);
        skills.selectByIndex(10);

        Thread.sleep(3000);

        // Current URL and Title
        String currentUrlNew = driver.getCurrentUrl();
        System.out.println(currentUrlNew);

        String title = driver.getTitle();
        System.out.println(title);

        Thread.sleep(3000);

        //the number of elements:
        List<WebElement> numElements = driver.findElements(By.cssSelector("*"));
        System.out.println(numElements.size());

        for (WebElement l: numElements){
            System.out.println(l.getText());
        }
        Thread.sleep(2000);

        //Search Button
        // Open new Website
        driver.get("https://leafground.com/");
        WebElement search = driver.findElement(By.cssSelector("input[placeholder='Search...']"));
        search.sendKeys("Java");
        search.click();
        Thread.sleep(2000);

        //Drag and drop
        driver.get("https://demoqa.com/droppable/");

        // Find the source element by ID
        WebElement source = driver.findElement(By.id("draggable"));

        // Find the target element by ID
        WebElement target = driver.findElement(By.id("droppable"));

        // Use Actions class to perform drag and drop
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).build().perform();

        Thread.sleep(3000);
        driver.close();

    }
}
