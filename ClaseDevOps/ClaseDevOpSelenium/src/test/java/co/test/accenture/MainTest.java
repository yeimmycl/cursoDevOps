/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.test.accenture;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author diego.tapia
 */
public class MainTest {

    private WebDriver driver;
    private static final String AMBIENTE = "LOCAL";
    private static final String BASE_URL = "http://clarognc.azurewebsites.net/";
    

    public MainTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
        if(this.driver != null){
            this.driver.get(BASE_URL);
        }
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        switch (AMBIENTE) {
            case "LOCAL":
                initLocalSelenium();
                System.out.println("HOLA MUNDO!!");
                break;
            case "REMOTO":
                initRemoteSelenium();
                break;
            default:
                break;
        }
        if(this.driver != null){
            this.driver.manage().window().maximize();
        }
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    private void initLocalSelenium() {

        this.driver = new FirefoxDriver();
    }

    private void initRemoteSelenium() {
        try {
            DesiredCapabilities dc = new DesiredCapabilities().firefox();

            dc.setPlatform(Platform.WINDOWS);

            this.driver = new RemoteWebDriver(new URL(BASE_URL), dc);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }

    }
}
