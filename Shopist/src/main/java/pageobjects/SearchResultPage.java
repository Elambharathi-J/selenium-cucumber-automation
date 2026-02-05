package pageobjects;

import org.openqa.selenium.By;
import reusablecode.LaunchBrowser;

public class SearchResultPage extends LaunchBrowser {
    public void selectProductFromSearchResult(int resultIndex){

        driver.findElement(By.xpath("//div[@cel_widget_id='MAIN-SEARCH_RESULTS-"+resultIndex+"']")).click();

    }
    public void getSearchPageTitle(){

        driver.getTitle();
    }
}
