package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class ContactsPage extends BasePage {

    //since we are extending BasePage we do not  need explicit constructor for this


    //@FindBy(xpath ="//td[contains(text(),'mbrackstone9@example.com')][@data-column-label='Email']")
    //public WebElement email;

    public WebElement getContactEmail(String email) {
        String xpath="//td[contains(text(),'" + email + "')][@data-column-label='Email']";
        return Driver.get().findElement(By.xpath(xpath));
    }

}
