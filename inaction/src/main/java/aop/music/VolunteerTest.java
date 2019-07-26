package aop.music;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class VolunteerTest {

    Volunteer volunteer;
    Magician magician;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Volunteer.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @org.junit.Before
    public void setUp() throws Exception {
        volunteer = new Volunteer();
        magician = new Magician();
    }

    @org.junit.Test
    public void thinkOfSomething() {
        volunteer.thinkOfSomething("Queen of Hearts");
        assertEquals("Queen of Hearts", magician.getThoughts());
    }
}
