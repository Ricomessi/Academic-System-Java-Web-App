import dao.DAOSchedule;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import pojo.Course;
import pojo.Schedule;

public class DAOScheduleTest {
    public DAOScheduleTest() {
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
    public void addScheduleTest() {
        // Buat objek Schedule baru untuk ditambahkan ke database
        Schedule schedule = new Schedule();
        schedule.setCourse(new Course()); // Set objek Course sesuai kebutuhan
        schedule.setDueTime("2023-10-23 08:00:00"); // Gantilah dengan data yang sesuai
        schedule.setStartTime("2023-10-23 10:00:00"); // Gantilah dengan data yang sesuai

        DAOSchedule dao = new DAOSchedule();
        dao.addSchedule(schedule);

        // Lakukan pengujian sesuai kebutuhan
        assertNotNull(schedule.getIdSchedule()); // Pastikan ID telah ditetapkan oleh Hibernate
    }

    @Test
    public void deleteScheduleTest() {
        // Buat objek Schedule dengan ID yang akan dihapus
        Integer idScheduleToDelete = 4; // Gantilah dengan ID yang akan dihapus

        DAOSchedule dao = new DAOSchedule();
        dao.deleteSchedule(idScheduleToDelete);

        // Lakukan pengujian sesuai kebutuhan, misalnya dengan mencoba mengambil schedule yang sudah dihapus
        assertNull(dao.getScheduleByID(idScheduleToDelete));
    }


    @Test
public void updateScheduleTest() {
    // Create a new Schedule
    Schedule schedule = new Schedule();
    schedule.setDueTime("Tuesday, 12:59"); // Replace with valid due time

    // Instantiate the DAOSchedule class
    DAOSchedule dao = new DAOSchedule();

    // Add the schedule to the database
    dao.addSchedule(schedule);

    // Retrieve the schedule from the database
    Schedule retrievedSchedule = dao.getScheduleByID(24);

    // Update the due time
    retrievedSchedule.setDueTime("Wednesday, 14:00"); // Replace with a valid new due time

    // Try to update the schedule
    dao.updateSchedule(retrievedSchedule);

    // Retrieve the updated schedule from the database
    Schedule updatedSchedule = dao.getScheduleByID(retrievedSchedule.getIdSchedule());

    // Check if the due time has been updated
    assertEquals("Wednesday, 14:00", updatedSchedule.getDueTime()); // Replace with the expected updated due time
}


    @Test
    public void getCourseNameByScheduleIdTest() {
        Integer scheduleId = 21; // Gantilah dengan ID jadwal yang ada di database

        DAOSchedule dao = new DAOSchedule();
        String courseName = dao.getCourseNameByScheduleId(scheduleId);

        // Lakukan pengujian sesuai kebutuhan
        assertNotNull(courseName);
        
    }
    
    @Test
    public void testGetAllSchedules() {
        DAOSchedule dao = new DAOSchedule();
        
        // Lakukan pengujian untuk mendapatkan semua jadwal
        List<Schedule> schedules = dao.getAllSchedules();

        // Periksa apakah daftar jadwal tidak kosong
        assertFalse(schedules.isEmpty());

        // Lakukan pengujian sesuai kebutuhan
        for (Schedule schedule : schedules) {
            assertNotNull(schedule.getIdSchedule());
            assertNotNull(schedule.getCourse());
            assertNotNull(schedule.getDueTime());
            assertNotNull(schedule.getStartTime());
            // Periksa atribut-atribut lainnya jika diperlukan
        }
    }
    
     @Test
    public void getScheduleByIdTest() {
        DAOSchedule dao = new DAOSchedule();
        int scheduleId = 22; // Ganti dengan ID jadwal yang sesuai untuk pengujian

       
        Schedule schedule = dao.getScheduleById(scheduleId);

      
        assertNotNull(schedule);

       
    }
    @Test
    public void retrieveAllSchedulesTest() {
        DAOSchedule dao = new DAOSchedule();

        // Call the retrieveAllSchedules method to retrieve a list of schedules
        List<Schedule> schedules = dao.retrieveAllSchedules();

        // Add assertions to check if the list of schedules is not null and not empty
        assertNotNull(schedules);
        assertFalse(schedules.isEmpty());
        // You can add more assertions to further validate the retrieved schedules if needed
    }
    
    @Test
    public void getIdScheduleForSubjectTest() {
        DAOSchedule dao = new DAOSchedule();
        int idSubjectToTest = 1; // Replace with a valid subject ID from your database

        int idSchedule = dao.getIdScheduleForSubject(idSubjectToTest);

        // Add assertions to check the idSchedule value
        assertTrue(idSchedule >= -1); // Modify this based on your expected data
    }
    
}
