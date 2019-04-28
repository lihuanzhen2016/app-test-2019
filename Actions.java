package utils;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidBatteryInfo;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.from;
import static java.time.Duration.ofSeconds;

public class Actions {
    AndroidDriver<WebElement> driver;
    AndroidTouchAction aca;
    TouchAction ta;
    public Actions(AndroidDriver<WebElement> driver){
        this.driver=driver;
         aca= new AndroidTouchAction(driver);
         ta = new TouchAction(driver);
    }

    public void type(WebElement element,String context){
             element.sendKeys(context);
    }

    public void click(WebElement element){
        element.click();
    }
//长按
    public void longPress(WebElement ele){
        ta.longPress(element(ele)).perform();
    }
//坐标点的滑动
    public void swip(PointOption fromOption, PointOption toOption, long time){
        aca.press(fromOption).waitAction(waitOptions(ofSeconds(time))).
                moveTo(toOption).perform();
    }
    //元素间的滑动
    public void swip(WebElement fromEle, WebElement toEle, long time){

        aca.press(element(fromEle)).waitAction(waitOptions(ofSeconds(time))).
                moveTo(element(toEle)).perform();
    }

    public void drop(WebElement fromEle, WebElement toEle){
              ta.longPress(element(fromEle))
                .moveTo(element(toEle))
                .perform();
    }

    public void drop(WebElement fromEle, WebElement toEle,Long time){
        ta.longPress(longPressOptions()
                .withElement(element(fromEle))
                .withDuration(ofSeconds(2)))
                .moveTo(element(toEle))
                .perform();
    }

    //点到点之间的拖动
    public void drop(Point fromPoint , Point toPoint){
               ta.longPress(point(fromPoint.x, fromPoint.y))
                .moveTo(point(toPoint.x, toPoint.y))
               .perform();
    }
}
