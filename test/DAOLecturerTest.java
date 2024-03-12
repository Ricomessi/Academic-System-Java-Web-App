import dao.DAOLecturer;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import pojo.Lecturer;

public class DAOLecturerTest {
    public DAOLecturerTest() {
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
    public void addLecturerTest() {
        // Buat objek Lecturer baru untuk ditambahkan ke database
        Lecturer lecturer = new Lecturer();
        lecturer.setName("RZ"); // Gantilah dengan data yang sesuai
        lecturer.setEmail("RZ@gmail.com"); // Gantilah dengan data yang sesuai
        lecturer.setPassword("1234"); // Gantilah dengan data yang sesuai

        DAOLecturer dao = new DAOLecturer();
        dao.addLecturer(lecturer);

        // Lakukan pengujian sesuai kebutuhan
        assertNotNull(lecturer.getIdLecturer()); // Pastikan ID telah ditetapkan oleh Hibernate
    }


    @Test
    public void deleteLecturerTest() {
        // Buat objek Lecturer dengan ID yang akan dihapus
        Integer idLecturerToDelete = 19; // Gantilah dengan ID yang akan dihapus

        DAOLecturer dao = new DAOLecturer();
        dao.deleteLecturer(idLecturerToDelete);

        // Lakukan pengujian sesuai kebutuhan, misalnya dengan mencoba mengambil lecturer yang sudah dihapus
        assertNull(dao.getLecturerById(idLecturerToDelete));
    }


    @Test
    public void updateLecturerTest() {
        // Buat objek Lecturer yang akan diupdate
        Lecturer lecturer = new Lecturer();
        lecturer.setIdLecturer(16); // Gantilah dengan ID yang sesuai
        lecturer.setName("RMN"); // Gantilah dengan data yang sesuai

        DAOLecturer dao = new DAOLecturer();
        dao.updateLecturer(lecturer);

        // Lakukan pengujian sesuai kebutuhan, misalnya dengan mengambil lecturer yang telah diperbarui
        Lecturer updatedLecturer = dao.getLecturerById(lecturer.getIdLecturer());
        assertEquals(lecturer.getName(), updatedLecturer.getName());
        // Lakukan pengujian untuk atribut lainnya jika diperlukan
    }


    @Test
    public void getLecturerByEmailTest() {
        String emailToRetrieve = "rricomesias@gmail.com"; // Gantilah dengan email yang ada di database

        DAOLecturer dao = new DAOLecturer();
        Lecturer lecturer = dao.getLecturerByEmail(emailToRetrieve);

        // Lakukan pengujian sesuai kebutuhan
        assertNotNull(lecturer);
        assertEquals(emailToRetrieve, lecturer.getEmail());
    }
    
     @Test
    public void retrieveLecturersTest() {
        DAOLecturer dao = new DAOLecturer();

        // Call the method to retrieve a list of lecturers
        List<Lecturer> lecturers = dao.retrieveLecturers();

        // Add assertions to check if the list of lecturers is not null and has at least one lecturer
        assertNotNull(lecturers);
        assertTrue(lecturers.size() > 0);
    }
    
    @Test
    public void loginTest() {
        DAOLecturer dao = new DAOLecturer();

        // Replace with valid email and password for testing
        String email = "test@example.com";
        String password = "password123";

        // Call the login method to retrieve a list of lecturers
        List<Lecturer> lecturers = dao.login(email, password);

        // Add assertions to check if the list of lecturers is not null
        assertNotNull(lecturers);
        // You can add more assertions to check the number of lecturers or other properties if needed
    }
    
    @Test
    public void getUserByEmailTest() {
        DAOLecturer dao = new DAOLecturer();

        // Replace with a valid email for testing
        String email = "rricomesias@gmail.com";

        // Call the getUserByEmail method to retrieve a lecturer by email
        Lecturer lecturer = dao.getUserByEmail(email);

        // Add assertions to check if the returned lecturer is not null
        assertNotNull(lecturer);
        // You can add more assertions to check other properties of the retrieved lecturer if needed
    }
    
    @Test
    public void getIdSubjectForLecturerTest() {
        DAOLecturer dao = new DAOLecturer();

        // Replace with a valid lecturer ID for testing
        int lecturerId = 16;

        // Call the getIdSubjectForLecturer method to retrieve the subject ID for the lecturer
        int subjectId = dao.getIdSubjectForLecturer(lecturerId);

        // Add assertions to check if the subject ID is not -1 or another default value
        assertNotEquals(-1, subjectId);
        // You can add more assertions to further validate the subject ID if needed
    }
    
    @Test
    public void getIdScheduleForSubjectTest() {
        DAOLecturer dao = new DAOLecturer();

        // Replace with a valid subject ID for testing
        int subjectId = 2;

        // Call the getIdScheduleForSubject method to retrieve the schedule ID for the subject
        int scheduleId = dao.getIdScheduleForSubject(subjectId);

        // Add assertions to check if the schedule ID is not -1 or another default value
        assertNotEquals(1, scheduleId);
        // You can add more assertions to further validate the schedule ID if needed
    }
}
