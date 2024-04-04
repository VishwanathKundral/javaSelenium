package com.sdet.auto.TestHelper;

import com.deque.axe.AXE;
import com.sdet.auto.SeleniumExtensions.WebDriverBase;
import org.json.JSONArray;
import org.json.JSONObject;
import java.net.URL;

public class AccessHelper {

    public static void basicAccessibilityCheck(TestAssert testAssert){

        URL scriptUrl = AccessHelper.class.getResource("/axe.min.js");

        JSONObject responseJSON = new AXE.Builder(WebDriverBase.driver, scriptUrl).analyze();
        JSONArray violations = responseJSON.getJSONArray("violations");

        if (violations.length() == 0) {
            InOutLibrary.writeLine("PASS: basicAccessibilityCheck | No violations found.");
        } else {
            AXE.writeResults("FAIL: " + InOutLibrary.getTestName(), responseJSON);
            testAssert.setPass(false);
            InOutLibrary.writeLine("FAIL: " + InOutLibrary.getTestName() + " " + AXE.report(violations));
        }
    }
}
