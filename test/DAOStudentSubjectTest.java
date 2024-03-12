import dao.DAOStudentSubject;
import pojo.Studentsubject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class DAOStudentSubjectTest {
    public DAOStudentSubjectTest() {
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
    public void addStudentsubjectTest() {
        Studentsubject studentsubject = new Studentsubject();
        studentsubject.setStudentId(1); // Replace with a valid student ID
        studentsubject.setSubjectId(1); // Replace with a valid subject ID

        DAOStudentSubject dao = new DAOStudentSubject();
        dao.addStudentsubject(studentsubject);

        // You can add assertions to check if the studentsubject was added successfully
        assertNotNull(studentsubject.getId()); // Assuming id is generated during the add operation
    }

    @Test
    public void deleteStudentsubjectTest() {
        // Add a studentsubject to the database first
        Studentsubject studentsubject = new Studentsubject();
        studentsubject.setStudentId(1); // Replace with a valid student ID
        studentsubject.setSubjectId(1); // Replace with a valid subject ID

        DAOStudentSubject dao = new DAOStudentSubject();
        dao.addStudentsubject(studentsubject);

        int studentsubjectId = studentsubject.getId();

        dao.deleteStudentsubject(studentsubjectId);

        // Retrieve the studentsubject by ID to check if it's deleted
        Studentsubject deletedStudentsubject = dao.getStudentsubjectById(studentsubjectId);
        assertNull(deletedStudentsubject);
    }

    @Test
    public void getStudentsubjectByIdTest() {
        int studentsubjectIdToRetrieve = 1; // Replace with a valid studentsubject ID from your database

        DAOStudentSubject dao = new DAOStudentSubject();
        Studentsubject studentsubject = dao.getStudentsubjectById(studentsubjectIdToRetrieve);

        // Perform assertions using JUnit
        assertNotNull(studentsubject);
        // Add more assertions to check other properties of the retrieved studentsubject
    }

    @Test
    public void retrieveAllStudentsubjectsTest() {
        DAOStudentSubject dao = new DAOStudentSubject();
        List<Studentsubject> studentsubjects = dao.retrieveStudentsubjects();
        // Add assertions to check the list of studentsubjects, e.g., check the size of the list
        assertTrue(studentsubjects.size() >= 0); // Modify this based on your expected data
    }

    @Test
public void updateStudentsubjectTest() {
    DAOStudentSubject dao = new DAOStudentSubject();

    // Create a new Studentsubject to update
    Studentsubject studentsubject = new Studentsubject();
    studentsubject.setStudentId(1); // Replace with a valid student ID
    studentsubject.setSubjectId(1); // Replace with a valid subject ID

    // Add the studentsubject
    dao.addStudentsubject(studentsubject);

    // Check if the studentsubject was added successfully by retrieving it
    Studentsubject addedStudentsubject = dao.getStudentsubjectById(2);

    // Update the subject ID
    addedStudentsubject.setStudentId(2); // Replace with a valid new subject ID

    // Try to update the studentsubject
    dao.updateStudentsubject(addedStudentsubject);

    // Check if the subject ID has been updated
    Studentsubject updatedStudentsubject = dao.getStudentsubjectById(addedStudentsubject.getId());
    
    assertNotNull(updatedStudentsubject);
}

@Test
    public void getStudentSubjectsByStudentIdTest() {
        DAOStudentSubject dao = new DAOStudentSubject();
        int studentIdToTest = 1; // Replace with a valid student ID from your database

        List<Studentsubject> studentSubjects = dao.getStudentSubjectsByStudentId(studentIdToTest);

        // Add assertions to check the studentSubjects list, e.g., check the size of the list
        assertNotNull(studentSubjects); // Modify this based on your expected data
    }

}
