package com.sdet.auto;

import com.sdet.auto.PageObjects.*;
import com.sdet.auto.TestHelper.AccessHelper;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SeleniumTest extends TestBaseClass{

    @Test
    public void TC0001_SmokeTest() {

        GuiHelper.openWebBrowser();
        Navigation.navToWebPageUnderTest();
        HomePage.VerifyOnHomePage(testAssert);
        GuiHelper.closeWebBrowser();
    }

    @Test
    public void TC0002_ForgetPasswordTest() {

        final String email = "dumpingdoit@gmail.com";
        final String expectedMsg = "Your e-mail's been sent!";

        GuiHelper.openWebBrowser();
        Navigation.navToWebPageUnderTest();
        HomePage.ClickForgetPassword();
        ForgetPasswordPage.EnterEmail(email);
        ForgetPasswordPage.ClickRetrieveButton();
        EmailSentPage.VerifyEmailSent(testAssert, expectedMsg);
        GuiHelper.closeWebBrowser();
    }

    @Test
    public void TC0003_FormAuthentication() {

        final String userId = "1234user";
        final String password = "SuperSecretPassword!";
        final String expectedLoginMsg = "You logged into a secure area!";
        final String expectedLogoutMsg = "You logged out of the secure area!";

        GuiHelper.openWebBrowser();
        Navigation.navToWebPageUnderTest();
        HomePage.clickFormAuthentication();
        LoginPage.enterCredentials(userId, password);
        SecureAreaPage.verifyMessage(testAssert, expectedLoginMsg);
        SecureAreaPage.clickLogoutButton();
        LoginPage.verifyMessage(testAssert, expectedLogoutMsg);
        GuiHelper.closeWebBrowser();
    }

    @Test
    public void TC0004_FormAuthenticationBadInfo() {

        final String userId = "1234user";
        final String password = "pass@word1234user";
        final String expectedMsg = "Your username is invalid!";

        GuiHelper.openWebBrowser();
        Navigation.navToWebPageUnderTest();
        HomePage.clickFormAuthentication();
        LoginPage.enterCredentials(userId, password);
        LoginPage.verifyMessage(testAssert, expectedMsg);
        GuiHelper.closeWebBrowser();
    }

    @Test
    public void TC0005_A11y_Accessibility() {

        GuiHelper.openWebBrowser();
        Navigation.navToWebPageUnderTest();

        AccessHelper.basicAccessibilityCheck(testAssert);

        GuiHelper.closeWebBrowser();
    }
}
