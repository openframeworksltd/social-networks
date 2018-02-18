package co.uk.openframeworks;

import co.uk.openframeworks.util.CircleLoader;
import org.junit.Before;
import org.junit.Test;


import static junit.framework.Assert.assertEquals;

public class CirclesTest {

    private Circles circle;

    @Before
    public void setUp() {
        circle = new Circles();
        CircleLoader.loadCircle(circle, "src/main/resources/gplus/100129275726588145876.circles");
    }

    @Test
    public void addVertexTest() {
        assertEquals(2, circle.exportCircle().size());
    }
}
