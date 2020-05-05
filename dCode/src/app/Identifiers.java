package app;

import org.sikuli.script.*;

public class Identifiers {
    final static String BtnOpenUI = System.getProperty("user.dir") + "\\dCode\\resources\\images\\btnA.PNG";
    final static String UiLogo = System.getProperty("user.dir") + "\\dCode\\resources\\images\\sword.PNG";
    final static String AttackBtn = System.getProperty("user.dir") + "\\dCode\\resources\\images\\attackBtn.PNG";
    final static String WarButton = System.getProperty("user.dir") + "\\dCode\\resources\\images\\warButton.PNG";
    final static String OkayBtn = System.getProperty("user.dir") + "\\dCode\\resources\\images\\okayButton.PNG";
    public static Region leftScreen = new Screen(0).newRegion(90, 177, 1040, 584);
}