import dao.DAOSubject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import pojo.Subject;
import java.util.List;
import org.junit.Assert;

public class DAOSubjectTest {
    public DAOSubjectTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }


    @Test
    public void addSubjectTest() {
        Subject subject = new Subject();
        subject.setSubjectName("TestSubject");
        subject.setCredit(3);

        DAOSubject dao = new DAOSubject();
        dao.addSubject(subject);

        // You can add assertions to check if the subject was added successfully
        assertNotNull(subject.getIdSubject()); // Assuming idSubject is generated during the add operation
    }


    @Test
    public void deleteSubjectTest() {
        // Add a subject to the database first
        Subject subject = new Subject();
        subject.setSubjectName("TestSubject");
        subject.setCredit(3);

        DAOSubject dao = new DAOSubject();
        dao.addSubject(subject);

        int subjectId = subject.getIdSubject();

        dao.deleteSubject(subjectId);

        // Retrieve the subject by ID to check if it's deleted
        Subject deletedSubject = dao.getSubjectByID(subjectId);
        assertNull(deletedSubject);
    }


    
     
    
    @Test
public void getSubjectByIDTest() {
    int subjectIdToRetrieve = 4; // Replace with a valid subject ID from your database

    DAOSubject dao = new DAOSubject();
    Subject subject = dao.getSubjectByID(subjectIdToRetrieve);

    // Perform assertions using JUnit 4's Assert.assertEquals
    assertNotNull(subject);
    // Add more assertions to check other properties of the retrieved subject
}




    @Test
    public void retrieveAllSubjectsTest() {
        DAOSubject dao = new DAOSubject();
        List<Subject> subjects = dao.retrieveAllSubjects();
        // Add assertions to check the list of subjects, e.g., check the size of the list
        assertTrue(subjects.size() >= 0); // Modify this based on your expected data
    }

    
 @Test
    public void updateSubjectTest() {
        DAOSubject dao = new DAOSubject();

        // Create a new Subject to update
        Subject subject = new Subject();
        subject.setIdSubject(4);
        subject.setSubjectName("Original Subject Name");

        // Add the subject
        dao.addSubject(subject);

        // Check if the subject was added successfully by retrieving it
        Subject addedSubject = dao.getSubjectByID(4);

        // Update the subject name
        addedSubject.setSubjectName("Updated Subject Name");

        // Try to update the subject
        dao.updateSubject(addedSubject);

        // Check if the subject's name has been updated
        Subject updatedSubject = dao.getSubjectByID(addedSubject.getIdSubject());
        Assert.assertNotNull(updatedSubject);
        Assert.assertEquals("Updated Subject Name", updatedSubject.getSubjectName());
    }
     @Test
    public void getAllSubjectsForLecturerTest() {
        DAOSubject dao = new DAOSubject();
        int idSubjectToTest = 1; // Replace with a valid subject ID from your database

        List<Subject> subjects = dao.getAllSubjectsForLecturer(idSubjectToTest);

        // Add assertions to check the subjects list, e.g., check the size of the list
        assertNotNull(subjects); // Modify this based on your expected data
    }
    
    
}







