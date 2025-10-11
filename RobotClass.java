package Company;

import java.awt.*; // this package give related classes for mouse, keyboard and screen.
import java.awt.event.KeyEvent; // this is for key codes of keyboard ex:A,enter.
import java.awt.image.BufferedImage; //for storing image in memory.
import javax.imageio.ImageIO; // for saving image in file (ex: png,jpg)
import java.io.File; // for making file and putting image in that.

public class RobotClass {
    public static void main(String[] args) throws Exception{
        /*
        Robot Class: The Robot class generates native system input events for the purposes of test automation,
                     self-running demos, and other applications where control of the mouse and keyboard is needed.

        Package: java.awt
        Class: Robot

        --------------------------------------------------------

        --⚙️ Common Uses:
        --Mouse control
        Move the cursor
        Perform clicks or drags
        --Keyboard control
        Press or release keys
        Type text automatically
        --Screen capture
        Take screenshots
        --Automated testing
        Used with tools like Selenium for automating tasks not handled by browser drivers (like OS-level popups)

        --------------------------------------------------

        ⚠️ Note:
        It executes OS-level commands, so it can’t be used on headless servers (no display).
        It can behave unpredictably if the system focus changes during execution.
        Requires proper exception handling (AWTException).

        ----------------------------------------------------

        🧾 Important Methods
        Method	                                Description
        mouseMove(int x, int y)	                Moves the mouse pointer to given screen coordinates.
        mousePress(int buttons)	                Presses one or more mouse buttons.
        mouseRelease(int buttons)	            Releases the mouse button(s).
        keyPress(int keycode)	                Presses a given key on the keyboard.
        keyRelease(int keycode)	                Releases a given key.
        delay(int ms)	                        Delays execution for a specified time (in milliseconds).
        createScreenCapture(Rectangle rect)	    Captures the screen image of a given area.

       -----------------------------------------------------------

        Methods under the Robot Class:
        -KeyPress()      :robot.keyPress(KeyEvent.VK_DOWN)
        -KeyRelease()    :robot.keyEvent(KeyEvent.VK_DOWN)
        -MousePress()    :robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK)
        -MouseRelease()  :robot.mouseRelease(KeyEvent.BUTTON3_DOWN_MASK)
        -MouseMove()     :robot.mouseMove(point.getX(),point.getY())

         */

        Robot robot = new Robot();

        // Wait for 2 seconds before starting
        robot.delay(2000);

        // Move mouse to coordinates (300, 200)
        robot.mouseMove(300, 200);

        // Perform a left-click
        robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);

        // Type "HELLO"
        robot.keyPress(KeyEvent.VK_H);
        robot.keyRelease(KeyEvent.VK_H);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyRelease(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_O);
        robot.keyRelease(KeyEvent.VK_O);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_G);

        robot.delay(4000);

        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage image = robot.createScreenCapture(screenRect);
        ImageIO.write(image,"png",new File("Screenshot.png"));
        System.out.println("\nScreenshot saved!");
    }
}