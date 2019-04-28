package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.android.AndroidDriver;
import utils.Actions;

public class LoginPage {
    @FindBy(id = "nameET")
    private WebElement txt_name;
    //或者
    private WebElement txt_name1(){
       return this.driver.findElementById("nameET");
    }

    @FindBy(id = "passwordET")
    private WebElement txt_pwssword;
    @FindBy(className = "android.widget.Button")
     private  WebElement btn_submit;
    @FindAll({@FindBy(id="android:id/title")})
    public List<WebElement> elementList;
    private  WebElement getTxt_name(){
        return driver.findElement(By.id(""));
    }
    AndroidDriver driver;
    Actions action;
    public LoginPage(AndroidDriver driver){
        this.driver=driver;
//        PageFactory.initElements(driver,this);与@FindBy同时出现的
        action=new Actions(driver);
    }
    public void login(String name,String password){
          action.type(txt_name,name);
          action.type(txt_pwssword,password);
          action.click(btn_submit);
    }
}
