package app;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import mdlaf.MaterialLookAndFeel;
import mdlaf.utils.MaterialColors;
import java.awt.event.ActionEvent;
import mdlaf.themes.JMarsDarkTheme;
import java.awt.event.ActionListener;
import mdlaf.themes.MaterialOceanicTheme;
import mdlaf.animation.MaterialUIMovement;

import static org.sikuli.script.Constants.FOREVER;

import org.sikuli.script.Screen;

public class App extends Identifiers {
    public static void main(String[] args) throws Exception {
        // RunPOM();
        // ShowForm();
        testUI();
    }

    public static void testUI() {
        try {
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel(new MaterialLookAndFeel(new MaterialOceanicTheme()));
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("AutoGame");
        frame.setMinimumSize(new Dimension(600, 400));

        JMenuBar bar = new JMenuBar();

        JMenu menuTheme = new JMenu("Themes");

        JMenuItem oceanicTheme = new JMenuItem();
        oceanicTheme.setAction(new AbstractAction("Material Oceanic") {
            @Override
            public void actionPerformed(ActionEvent e) {
                MaterialLookAndFeel.changeTheme(new MaterialOceanicTheme());
                SwingUtilities.updateComponentTreeUI(frame);
            }
        });

        JMenuItem darkTheme = new JMenuItem();
        darkTheme.setAction(new AbstractAction("Material JMars Dark") {
            @Override
            public void actionPerformed(ActionEvent e) {
                MaterialLookAndFeel.changeTheme(new JMarsDarkTheme());
                SwingUtilities.updateComponentTreeUI(frame);
            }
        });

        menuTheme.add(oceanicTheme);
        menuTheme.add(darkTheme);

        bar.add(menuTheme);

        // configuring a simple JButton
        JButton button = new JButton("PRESS ME");
        button.setBackground(MaterialColors.LIGHT_BLUE_400);
        button.setForeground(Color.WHITE);
        button.setMaximumSize(new Dimension(200, 200));

        JPanel content = new JPanel();
        content.add(button);

        // add everything to the frame
        frame.add(bar, BorderLayout.PAGE_START);
        // frame.add (content, BorderLayout.CENTER);

        // you can also pass in extra parameters indicating how many intermediate colors
        // to display, as well as the "frame rate" of the animation
        // there will be 5 intermediate colors displayed in the transition from the
        // original components color to the new one specified
        // the "frame rate" of the transition will be 1000 / 30, or 30 FPS
        // the animation will take 5 * 1000 / 30 = 166.666... milliseconds to complete
        MaterialUIMovement.add(button, MaterialColors.LIGHT_BLUE_500, 5, 1000 / 30);

        JToolBar tb = new JToolBar("toolbar");
        JButton button1 = new JButton("f");
        button1.setBackground(MaterialColors.LIGHT_BLUE_400);
        button1.setForeground(Color.WHITE);
        button1.addMouseListener(MaterialUIMovement.getMovement(button1, MaterialColors.LIGHT_BLUE_200));

        button1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                putValue(Action.NAME, "f");

                JDialog dialog = new JDialog();
                JPanel jPanel = new JPanel();
                jPanel.add(new JColorChooser());
                dialog.setContentPane(jPanel);
                dialog.setLocationRelativeTo(null);
                dialog.pack();
                dialog.setVisible(true);
            }
        });
        button1.setToolTipText("This is a tool tip");

        tb.add(button1);
        tb.addSeparator();
        tb.setFloatable(true);
        content.add(tb);

        JScrollPane sp = new JScrollPane(content);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JTabbedPane tp = new JTabbedPane();
        tp.addTab("bleh", sp);

        frame.add(tp, BorderLayout.CENTER);

        JPanel panel3 = new JPanel();
        tp.addTab("Panel 3", panel3);

        JButton buttonInfo = new JButton("Test INFO");
        buttonInfo.setBackground(MaterialColors.LIGHT_BLUE_500);
        buttonInfo.setForeground(MaterialColors.WHITE);
        buttonInfo.addMouseListener(MaterialUIMovement.getMovement(buttonInfo, MaterialColors.LIGHT_BLUE_200));
        class InfoMessage extends AbstractAction {

            public InfoMessage() {
                putValue(Action.NAME, "Info option panel");
            }

            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane optionPane = new JOptionPane();
                optionPane.showMessageDialog(frame, "This is message info", "Message info",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
        buttonInfo.setAction(new InfoMessage());

        panel3.add(buttonInfo);

        JButton buttonError = new JButton();
        buttonError.setBackground(MaterialColors.RED_800);
        buttonError.setForeground(MaterialColors.WHITE);
        buttonError.addMouseListener(MaterialUIMovement.getMovement(buttonError, MaterialColors.RED_400));
        class ErrorMassage extends AbstractAction {

            public ErrorMassage() {
                putValue(Action.NAME, "Error option panel");
            }

            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane optionPane = new JOptionPane();
                optionPane.showMessageDialog(frame, "This is message error", "Message error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        buttonError.setAction(new ErrorMassage());

        panel3.add(buttonError);

        JButton buttonQuestion = new JButton();
        buttonQuestion.setBackground(MaterialColors.BLUE_600);
        buttonQuestion.setForeground(MaterialColors.WHITE);
        buttonQuestion.addMouseListener(MaterialUIMovement.getMovement(buttonQuestion, MaterialColors.BLUE_300));
        class QuesuionMessage extends AbstractAction {

            public QuesuionMessage() {
                putValue(Action.NAME, "Info question panel");
            }

            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane optionPane = new JOptionPane();
                optionPane.showMessageDialog(frame, "This is message question", "Message question",
                        JOptionPane.QUESTION_MESSAGE);
            }
        }

        buttonQuestion.setAction(new QuesuionMessage());

        JButton buttonWarning = new JButton();
        buttonWarning.setOpaque(false);
        buttonWarning.setBackground(MaterialColors.YELLOW_800);
        buttonWarning.setForeground(MaterialColors.WHITE);
        buttonWarning.addMouseListener(MaterialUIMovement.getMovement(buttonWarning, MaterialColors.YELLOW_500));
        class WarningMessage extends AbstractAction {

            public WarningMessage() {
                putValue(Action.NAME, "Info warning panel");
            }

            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane optionPane = new JOptionPane();
                optionPane.showMessageDialog(frame, "This is message warning", "Message warning",
                        JOptionPane.WARNING_MESSAGE);
            }

        }

        buttonWarning.setAction(new WarningMessage());

        panel3.add(buttonQuestion);
        panel3.add(buttonWarning);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void ShowForm() {
        JFrame dForm = new JFrame();
        JButton btnA = new JButton("Monster Park");
        JButton btnB = new JButton("Maplestory M");
        JButton btnC = new JButton("Exit");
        try {
            btnA.setBounds(250 / 2, 100, 100, 35);
            btnB.setBounds(250 / 2, 200, 100, 35);
            btnC.setBounds(250 / 2, 300, 100, 35);
            dForm.add(btnA);
            dForm.add(btnB);
            dForm.add(btnC);
            btnC.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            dForm.setSize(FormWidth, FormHeight);
            dForm.setLayout(null);
            // sets form's location to center of the screen
            dForm.setLocationRelativeTo(null);
            dForm.setVisible(true);
            dForm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
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