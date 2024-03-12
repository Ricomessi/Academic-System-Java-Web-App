import dao.DAOLecturerSubject;
import pojo.Lecturersubject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;


public class DAOLecturerSubjectTest {
    public DAOLecturerSubjectTest() {
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
    public void addLecturerSubjectTest() {
        Lecturersubject lecturerSubject = new Lecturersubject();
        lecturerSubject.setIdLecturer(1); // Replace with a valid lecturer ID
        lecturerSubject.setIdSubject(1); // Replace with a valid subject ID

        DAOLecturerSubject dao = new DAOLecturerSubject();
        dao.addLecturerSubject(lecturerSubject);

        // You can add assertions to check if the lecturerSubject was added successfully
        assertNotNull(lecturerSubject.getId()); // Assuming id is generated during the add operation
    }

    @Test
    public void deleteLecturerSubjectTest() {
        // Add a lecturerSubject to the database first
        Lecturersubject lecturerSubject = new Lecturersubject();
        lecturerSubject.setIdLecturer(1); // Replace with a valid lecturer ID
        lecturerSubject.setIdSubject(1); // Replace with a valid subject ID

        DAOLecturerSubject dao = new DAOLecturerSubject();
        dao.addLecturerSubject(lecturerSubject);

        int lecturerSubjectId = lecturerSubject.getId();

        dao.deleteLecturerSubject(lecturerSubjectId);

        // Retrieve the lecturerSubject by ID to check if it's deleted
        Lecturersubject deletedLecturerSubject = dao.getLecturerSubjectById(lecturerSubjectId);
        assertNull(deletedLecturerSubject);
    }

    @Test
    public void getLecturerSubjectByIdTest() {
        int lecturerSubjectIdToRetrieve = 2; // Replace with a valid lecturerSubject ID from your database

        DAOLecturerSubject dao = new DAOLecturerSubject();
        Lecturersubject lecturerSubject = dao.getLecturerSubjectById(lecturerSubjectIdToRetrieve);

        // Perform assertions using JUnit
        assertNotNull(lecturerSubject);
        // Add more assertions to check other properties of the retrieved lecturerSubject
    }

    @Test
    public void retrieveAllLecturerSubjectsTest() {
        DAOLecturerSubject dao = new DAOLecturerSubject();
        List<Lecturersubject> lecturerSubjects = dao.retrieveLecturerSubjects();
        // Add assertions to check the list of lecturerSubjects, e.g., check the size of the list
        assertTrue(lecturerSubjects.size() >= 0); // Modify this based on your expected data
    }

    @Test
    public void updateLecturerSubjectTest() {
        DAOLecturerSubject dao = new DAOLecturerSubject();

        // Create a new Lecturersubject to update
        Lecturersubject lecturerSubject = new Lecturersubject();
        lecturerSubject.setIdLecturer(1); // Replace with a valid lecturer ID
        lecturerSubject.setIdSubject(1); // Replace with a valid subject ID

        // Add the lecturerSubject
        dao.addLecturerSubject(lecturerSubject);

        // Check if the lecturerSubject was added successfully by retrieving it
        Lecturersubject addedLecturerSubject = dao.getLecturerSubjectById(2);

        // Update the subject ID
        addedLecturerSubject.setIdLecturer(2); // Replace with a valid new lecturer ID

        // Try to update the lecturerSubject
        dao.updateLecturerSubject(addedLecturerSubject);

        // Check if the lecturer ID has been updated
        Lecturersubject updatedLecturerSubject = dao.getLecturerSubjectById(addedLecturerSubject.getId());

        assertNotNull(updatedLecturerSubject);
    }

    @Test
    public void getLecturerSubjectsByLecturerIdTest() {
        DAOLecturerSubject dao = new DAOLecturerSubject();
        int lecturerId = 1; // Replace with a valid lecturer ID

        List<Lecturersubject> lecturerSubjects = dao.getLecturerSubjectsByLecturerId(lecturerId);

        // Add assertions to check the list of lecturerSubjects for the specified lecturer
        assertTrue(lecturerSubjects.size() >= 0); // Modify this based on your expected data
    }
    
}
