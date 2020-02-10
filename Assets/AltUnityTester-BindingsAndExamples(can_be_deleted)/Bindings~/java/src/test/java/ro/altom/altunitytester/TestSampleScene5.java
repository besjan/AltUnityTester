package ro.altom.altunitytester;

import com.sun.javafx.geom.Vec3f;
import javafx.scene.input.KeyCode;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestSampleScene5 {


    private static AltUnityDriver altUnityDriver;

    @BeforeClass
    public static void setUp() throws Exception {
        altUnityDriver = new AltUnityDriver("127.0.0.1", 13000,";","&",true);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        altUnityDriver.stop();
        Thread.sleep(1000);
    }

    @Before
    public void loadLevel() throws Exception {
        altUnityDriver.loadScene("Scene 5 Keyboard Input");
    }


    @Test
    public void TestMovementCube() throws InterruptedException {


        AltUnityObject cube = altUnityDriver.findObject(AltUnityDriver.By.NAME,"Player1","");
        Vec3f cubeInitialPostion = new Vec3f(cube.worldX, cube.worldY, cube.worldY);
        altUnityDriver.scrollMouse(30, 20);
        altUnityDriver.pressKey("K",1, 2);
        Thread.sleep(2000);
        cube = altUnityDriver.findObject(AltUnityDriver.By.NAME,"Player1","");
        altUnityDriver.pressKeyAndWait("O", 1,1);

        Vec3f cubeFinalPosition = new Vec3f(cube.worldX, cube.worldY, cube.worldY);

        assertNotEquals(cubeInitialPostion, cubeFinalPosition);


    }

    @Test
    //Test Keyboard button press
    public void TestCameraMovement() throws InterruptedException {


        AltUnityObject cube = altUnityDriver.findObject(AltUnityDriver.By.NAME,"Player1","");
        Vec3f cubeInitialPostion = new Vec3f(cube.worldX, cube.worldY, cube.worldY);

        altUnityDriver.pressKey("W",1, 2);
        Thread.sleep(2000);
        cube = altUnityDriver.findObject(AltUnityDriver.By.NAME,"Player1","");
        Vec3f cubeFinalPosition = new Vec3f(cube.worldX, cube.worldY, cube.worldY);

        assertNotEquals(cubeInitialPostion, cubeFinalPosition);

    }

    @Test
    //Testing mouse movement and clicking
    public void TestCreatingStars() throws InterruptedException {

        AltUnityObject[] stars = altUnityDriver.findObjectsWhichContains(AltUnityDriver.By.NAME,"Star","");
        assertEquals(1, stars.length);
        AltUnityObject pressingPoint1=altUnityDriver.findElement("PressingPoint1","Player2");
        altUnityDriver.moveMouse(pressingPoint1.x, pressingPoint1.y, 1);
        Thread.sleep(1500);

        altUnityDriver.pressKey("Mouse0", 1,1);
        AltUnityObject pressingPoint2=altUnityDriver.findElement("PressingPoint2","Player2");
        altUnityDriver.moveMouseAndWait(pressingPoint2.x, pressingPoint2.y, 1);
        altUnityDriver.pressKeyAndWait("Mouse0", 1,1);


        stars = altUnityDriver.findObjectsWhichContains(AltUnityDriver.By.NAME,"Star","");
        assertEquals(3, stars.length);

    }

    @Test
    public void TestPowerJoystick()
    {
        ArrayList<String> ButtonNames = new ArrayList<String>();
        ButtonNames.add("Horizontal");
        ButtonNames.add("Vertical");
        ArrayList<String> KeyToPressForButtons = new ArrayList<>();
        KeyToPressForButtons.add("D");
        KeyToPressForButtons.add("W");
        altUnityDriver.loadScene("Scene 5 Keyboard Input");
        AltUnityObject axisName = altUnityDriver.findElement("AxisName");
        AltUnityObject axisValue = altUnityDriver.findElement("AxisValue");
        int i = 0;
        for (String key : KeyToPressForButtons)
        {
            altUnityDriver.pressKeyAndWait(key,0.5f,0.1f);
            assertEquals("0.5", axisValue.getText());
            assertEquals(ButtonNames.get(i), axisName.getText());
            i++;
        }
    }
}
