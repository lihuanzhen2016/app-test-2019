package com.example.uiautomatordemo;

import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiCollection;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.view.KeyEvent;


import org.junit.Test;

public class UiautomatorDemo {

    private UiDevice device;

    @Test
    public  void test1() throws UiObjectNotFoundException, RemoteException {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        device.pressHome();
//        device.pressKeyCode(KeyEvent.KEYCODE_2);
//
//    UiObject logo = device.findObject(new UiSelector().index(12));

        UiObject logo = device.findObject(new UiSelector().text("ToDoList"));
        logo.click();
        UiObject username =device.findObject(new UiSelector().resourceId("com.example.todolist:id/nameET"));
        username.setText("测试");
        UiSelector  selectorUsername= new UiSelector().className("android.widget.EditText").instance(1);
        UiObject password =device.findObject(selectorUsername);
        password.click();
        password.setText("1");
        UiObject submit=device.findObject(new UiSelector().text("登入"));
        submit.click();
        UiObject menu_add=device.findObject(new UiSelector().descriptionContains("新建"));
        menu_add.click();
        UiObject content=device.findObject(new UiSelector().className("android.widget.EditText"));
        content.setText("hello,tom!");

    }

    @Test
    public void  test2() throws UiObjectNotFoundException {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        UiCollection uc = new UiCollection
                (new UiSelector().className("android.vew.View").instance(2));
        int count=uc.getChildCount(new UiSelector().className("android.widget.TextView"));

        for(int i=0;i<count;i++){
            UiObject object=uc.getChild(new UiSelector().index(i));
            System.out.println("******************"+object.getText());

        }

    }

}
