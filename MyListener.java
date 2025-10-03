package Company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class MyListener implements WebDriverListener {

    @Override
    public void beforeClick(WebElement element) {
        System.out.println("🔵 Click hone wala hai on: " + element);
    }

    @Override
    public void afterClick(WebElement element) {
        System.out.println("🟢 Click ho gaya on: " + element);
    }

    @Override
    public void beforeGet(WebDriver driver, String url) {
        System.out.println("🔵 Navigating to: " + url);
    }

    @Override
    public void afterGet(WebDriver driver, String url) {
        System.out.println("🟢 Navigated to: " + url);
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        System.out.println("🔵 Typing: " + String.join("", keysToSend));
    }

    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        System.out.println("🟢 Typed: " + String.join("", keysToSend));
    }
}