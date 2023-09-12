package org.launchcode.techjobs.oo;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.Test;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void emptyTest() {
        assertEquals(10, 10, .001);
    }
    @Test
    public void testSettingJobId() {
        Job test1_job = new Job();
        Job test2_job = new Job();
        assertNotEquals(test1_job.getId(), test2_job.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        Job test_job = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertEquals("Product tester", test_job.getName());
        assertTrue(test_job.getName() instanceof String);
        assertEquals("ACME", test_job.getEmployer().getValue());
        assertTrue(test_job.getEmployer() instanceof Employer);
        assertEquals("Desert", test_job.getLocation().getValue());
        assertTrue(test_job.getLocation() instanceof Location);
        assertEquals("Quality control", test_job.getPositionType().getValue());
        assertTrue(test_job.getPositionType() instanceof PositionType);
        assertEquals("Persistence", test_job.getCoreCompetency().getValue());
        assertTrue(test_job.getCoreCompetency() instanceof CoreCompetency);
    }
    @Test
    public void testJobsForEquality() {
        Job test1_job = new Job("test name", new Employer("test employer"),
                new Location("test location"), new PositionType("test type"),
                new CoreCompetency("test competency"));
        Job test2_job = new Job("test name", new Employer("test employer"),
                new Location("test location"), new PositionType("test type"),
                new CoreCompetency("test competency"));
        assertFalse(test1_job.equals(test2_job));

    }
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job test_job = new Job("test name", new Employer("test employer"),
                new Location("test location"), new PositionType("test type"),
                new CoreCompetency("test competency"));
        assertEquals('\n', test_job.toString().charAt(0));
        assertEquals('\n', test_job.toString().charAt(test_job.toString().length()-1));
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job test_job = new Job("test name", new Employer("test employer"),
                new Location("test location"), new PositionType("test type"),
                new CoreCompetency("test competency"));
        String jobToString = System.lineSeparator()
                + "ID: " + test_job.getId()
                + System.lineSeparator()
                + "Name: " + test_job.getName()
                + System.lineSeparator()
                + "Employer: " + test_job.getEmployer().getValue()
                + System.lineSeparator()
                + "Location: " + test_job.getLocation().getValue()
                + System.lineSeparator()
                + "Position Type: " + test_job.getPositionType().getValue()
                + System.lineSeparator()
                + "Core Competency: " + test_job.getCoreCompetency().getValue()
                + System.lineSeparator();

        assertEquals(jobToString, test_job.toString());
    }
}
