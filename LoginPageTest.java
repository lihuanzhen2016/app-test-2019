package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {

    @Test(dataProvider = "")
    public void loginSuccessful(){
        LoginPage loginPage =new LoginPage(getDriver());
        loginPage.login("1","1");
        System.out.print(getDriver().currentActivity());
        Assert.assertEquals(".MainActivity",getDriver().currentActivity());
    }
}
