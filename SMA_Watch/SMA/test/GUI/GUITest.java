package GUI;

import org.junit.Test;

import static org.junit.Assert.*;

public class GUITest {

    @Test
    public void GUI_btn() {
        GUI test=new GUI();
        assertNotNull(test.GUI_btn());
    }
}