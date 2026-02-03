package stepdefinition;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import reusablecode.LaunchBrowser;
import reusablecode.ReadExcel;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AmazonSteps extends LaunchBrowser{

    WebElement categoryElement;
    String name;
    private boolean flag;
    private int a;
    @Given("user navigate to Amazon Homepage")
    public void homePage() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @When("user enters the product name {string} in search box")
    public void searchBox(String productname) {
        name = productname;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")))
                .sendKeys(productname);

    }

    @And("user clicks the search icon")
    public void clickSearchIcon() {
        driver.findElement(By.id("nav-search-submit-button")).click();

    }

    @Then("user validates the title of search result page")
    public void validateTitle() {
        String ExpectedTitle = "Amazon.in : " + name;
        String ActualTitle = driver.getTitle();
//        Assert.assertEquals(ExpectedTitle,ActualTitle);

        if (ExpectedTitle.equals(ActualTitle)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @When("user clicks on baby wishlist")
    public void userClicksOnBabyWishlist() {
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        Actions a = new Actions(driver);
        a.clickAndHold(accountList).build().perform();
    }

    @Then("validate the title")
    public void validateTheTitle() {

    }

    @When("user selects the value from the category dropdown")
    public void userSelectsTheValueFromTheCategoryDropdown() {
        categoryElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id("searchDropdownBox"))
        );
    }

    @And("user extract the value from the category dropdown")
    public void userExtractTheValueFromTheCategoryDropdown() {

//        int categorySize = categoryElement.findElements(By.tagName("option")).size();
//
//        List<String> DropDownValues = new ArrayList<String>();
//
//        for (int i = 0; i < categorySize; i++) {
//            String categoryValue = categoryElement
//                    .findElements(By.tagName("option"))
//                    .get(i).getText();
//            DropDownValues.add(categoryValue);
//        }
//        System.out.println(DropDownValues);

        List<WebElement> dropdownElement = categoryElement.findElements(By.tagName("option"));
        List<String> DropDownValues = new ArrayList<String>();
        for (WebElement e:dropdownElement){
          DropDownValues.add(e.getText());
        }
        System.out.println(DropDownValues);
         flag = false;
            int a=0;
         for (String Values: DropDownValues){
             if (Values.equals("Books")){
                 flag=true;
                 a++;
             }
         }
    }

//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript(
//                "arguments[0].value='search-alias=baby-products';" +
//                        "arguments[0].dispatchEvent(new Event('change'));",
//                categoryElement
//        );
//        List<WebElement> options = driver.findElements(
//                By.xpath("//select[@id='searchDropdownBox']/option")
//        );
//
//        for (int i = 0; i < options.size(); i++) {
//            System.out.println(options.get(i).getText());
//        }
//
//    }

        @Given("user navigate to jquery")
        public void userNavigateToJquery () {
            driver = new ChromeDriver();
            driver.get("https://jqueryui.com/droppable/");
        }

        @When("user performs drag and drop actions")
        public void userPerformsDragAndDropActions () {
            WebElement frameElement = driver.findElement(By.className("demo-frame"));
            driver.switchTo().frame(frameElement);
            WebElement dragElement = driver.findElement(By.id("draggable"));
            WebElement dropElement = driver.findElement(By.id("droppable"));
            Actions dragAction = new Actions(driver);
            dragAction.dragAndDrop(dragElement, dropElement).build().perform();
            driver.switchTo().defaultContent();
        }

        @Given("user extract the column one values")
        public void userExtractTheColumnValues () {
            int columnOneSize = driver.findElements(By.xpath("//table[@class='infobox ib-company vcard']/descendant::th")).size();
            for (int i = 0; i < columnOneSize; i++) {
                String columnOneValues = driver.findElements(By.xpath("//table[@class='infobox ib-company vcard']/descendant::th")).get(i).getText();
                System.out.println(columnOneValues);
            }
        }

        @Given("user navigates to SalesForce Login page")
        public void userNavigatesToSalesforceLoginpage () {
            // Write code here that turns the phrase above into concrete actions
            driver = new ChromeDriver();
            driver.get("https://learnmoreplayground.blogspot.com/p/loginpage.html");
        }

        @When("user enters the username {string} and password {string}")
        public void userEntersTheUsernameAndPassword (String username, String password) throws IOException {
            driver.findElement(By.id("username")).sendKeys(ReadExcel.getData("Login", 0, 0));
            driver.findElement(By.id("password")).sendKeys(ReadExcel.getData("Login", 1, 0));

        }

        @And("user clicks the login button")
        public void userClicksTheLoginButton () {
            driver.findElement(By.xpath("//button[@onclick='login()']")).click();

        }

        @Then("validate the error message")
        public void validateTheErrorMessage () {

        }


    @Then("validate the dropdown value")
    public void validateTheDropdownValue() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("Value not found inside the dropdown",flag);

        if (a==1){
            Assert.assertTrue("Duplicate Value not Found",true);
        }
        else {
            Assert.assertTrue("Duplicate Value Found",false);
        }


    }
}