import dao.DAOStudent;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import pojo.Student;
import pojo.Studentsubject;

public class DAOStudentTest {

    public DAOStudentTest() {
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
public void testAddStudent() {
    // Create a new student object
    Student student = new Student();
    student.setNama("John Doe");
    student.setEmail("johndoe@example.com");
    student.setPassword("password123");

    // Instantiate the DAOStudent class
    DAOStudent dao = new DAOStudent();

    // Add the student to the database
    dao.addStudent(student);

   assertNotNull(student.getIdStudent()); // Assuming idSubject is generated during the add operation

}


    @Test
    public void testDeleteStudent() {
        // Create a new student object
        Student student = new Student();
        student.setNama("Alice Smith");
        student.setEmail("alicesmith@example.com");
        student.setPassword("password123");

        // Instantiate the DAOStudent class
        DAOStudent dao = new DAOStudent();

        // Add the student to the database
        dao.addStudent(student);

        // Delete the student from the database
        dao.deleteStudent(student.getIdStudent());

        // Try to retrieve the deleted student
        Student deletedStudent = dao.getStudentByEmail("alicesmith@example.com");

        // Ensure that the deleted student is not found
        assertNull(deletedStudent);
    }

   @Test
    public void testUpdateStudent() {
        // Create a new student object
        Student student = new Student();
        student.setNama("John Doe");
        student.setEmail("rico@gmail.com");
        student.setPassword("password123");

        // Instantiate the DAOStudent class
        DAOStudent dao = new DAOStudent();

        // Add the student to the database
        dao.addStudent(student);

        // Retrieve the student from the database
        Student retrievedStudent = dao.getStudentByEmail("rico@gmail.com");

        // Update the student's information
        retrievedStudent.setNama("Updated Name");
        retrievedStudent.setPassword("newpassword");

        // Update the student in the database
        dao.updateStudent(retrievedStudent);

        // Retrieve the updated student from the database
        Student updatedStudent = dao.getStudentByEmail("rico@gmail.com");

        // Check if the name and password have been updated
        assertEquals("Updated Name", updatedStudent.getNama());
        assertEquals("newpassword", updatedStudent.getPassword());
    }
    
    @Test
    public void retrieveStudentTest() {
        DAOStudent dao = new DAOStudent();
        List<Student> students = dao.retrieveStudent();

        // Add assertions to check the list of students, e.g., check the size of the list
        assertTrue(students.size() >= 0); // Modify this based on your expected data
    }
    
     @Test
    public void loginTest() {
        DAOStudent dao = new DAOStudent();
        
        // Replace with valid email and password for testing
        String email = "dennis@gmail.com";
        String password = "123456";

        List<Student> students = dao.login(email, password);

        // Add assertions to check the list of students, e.g., check if it's not null or empty
        assertNotNull(students);
        assertFalse(students.isEmpty());
    }
    
    @Test
    public void getCourseNameByStudentEmailTest() {
        DAOStudent dao = new DAOStudent();
        
        // Replace with a valid student email for testing
        String studentEmail = "dennis@gmail.com";
        
        // Call the method to get the course name
        String courseName = dao.getCourseNameByStudentEmail(studentEmail);
        
        // Add assertions to check the courseName, e.g., check if it's not null or empty
        assertNotNull(courseName);
        assertFalse(courseName.isEmpty());
    }
    
      @Test
    public void getUserByEmailTest() {
        DAOStudent dao = new DAOStudent();
        
        // Replace with a valid student email for testing
        String studentEmail = "dennis@gmail.com";
        
        // Call the method to get the student by email
        Student student = dao.getUserByEmail(studentEmail);
        
        // Add assertions to check the student, e.g., check if it's not null and has the expected email
        assertNotNull(student);
        assertEquals(studentEmail, student.getEmail());
    }
    
    @Test
    public void getStudentSubjectsByStudentIdTest() {
        DAOStudent dao = new DAOStudent();
        
        // Replace with a valid student ID for testing
        int studentId = 1;
        
        // Call the method to get student subjects by student ID
        List<Studentsubject> student = dao.getStudentSubjectsByStudentId(studentId);
        
        // Add assertions to check the list of student subjects, e.g., check if it's not null
        assertNotNull(student);
        
        // You can add more assertions to check specific properties of the retrieved student subjects
    }   
    
    @Test
    public void getIdSubjectForStudentTest() {
        DAOStudent dao = new DAOStudent();

        // Replace with a valid student ID for testing
        int studentId = 1;

        // Call the method to get the subject ID for the student
        int subjectId = dao.getIdSubjectForStudent(studentId);

        // Add assertions to check if the subject ID is valid or if a default value is returned
        assertTrue(subjectId >= -1);
    }
    
    @Test
    public void getIdScheduleForSubjectTest() {
        DAOStudent dao = new DAOStudent();

        // Replace with a valid subject ID for testing
        int subjectId = 1;

        // Call the method to get the schedule ID for the subject
        int scheduleId = dao.getIdScheduleForSubject(subjectId);

        // Add assertions to check if the schedule ID is as expected
        // For example, if no schedule is found, you can assert that scheduleId is -1
        // If a schedule is found, assert that scheduleId is a positive integer
        assertTrue(scheduleId == -1 || scheduleId > 0);
    }
    
    @Test
    public void getStudentByIDTest() {
        DAOStudent dao = new DAOStudent();

        // Replace with a valid student ID for testing
        int studentId = 1;

        // Call the method to get the student by ID
        Student student = dao.getStudentByID(studentId);

        // Add assertions to check if the student is not null and other properties as needed
        assertNotNull(student);
        // Add more assertions to check other properties of the retrieved student
    }
    
    
    
}
