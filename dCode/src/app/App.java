package app;

import static org.sikuli.script.Constants.FOREVER;

import org.sikuli.script.Screen;

public class App extends Identifiers {
    public static void main(String[] args) throws Exception {
        RunPOM();
    }

    public static void RunPOM() {
        int amtRan = 0;
        try {
            leftScreen.find(BtnOpenUI).click();
            while (true) {
                leftScreen.wait(UiLogo, FOREVER);
                leftScreen.wait(UiLogo, FOREVER);
                leftScreen.find(AttackBtn).click();
                leftScreen.wait(WarButton, FOREVER);
                Thread.sleep(1000);
                leftScreen.offset(-245, 245).click();
                leftScreen.offset(-85, 245).click();
                leftScreen.offset(0, 245).click();
                leftScreen.offset(85, 245).click();
                leftScreen.offset(170, 245).click();
                leftScreen.getCenter().click();
                leftScreen.wait(OkayBtn, FOREVER);
                Thread.sleep(1500);
                leftScreen.getCenter().click();
                Thread.sleep(1500);
                leftScreen.find(OkayBtn).click();
                amtRan = amtRan + 1;
                System.out.println("Completed attack: " + amtRan);
                Thread.sleep(1000);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void TestScreenRegion() {
        try {
            Screen dScreen = new Screen();
            System.out.println(dScreen.selectRegion());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}