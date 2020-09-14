package com.backbase.cs_appiumtestcase;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.MobileCapabilityType;

public class Helper
{

    public static DesiredCapabilities getCapabilities()
    {
        DesiredCapabilities cap = new DesiredCapabilities();

        // Set your device name here on which you are testing your APK
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Sara");
        // Android OS version of your test device
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        // Platform of your device
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "10000"); // 10 Seconds
        //Path of your test APK on your local machine
        cap.setCapability(MobileCapabilityType.APP, "D:/BackbaseAppiumTest/BackbaseAssignment.apk");

        return cap;
    }
}
