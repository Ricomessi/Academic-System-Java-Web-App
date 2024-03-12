import dao.DAOCourse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import pojo.Course;

public class DAOCourseTest {
    public DAOCourseTest() {
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
    public void getCourseByIdTest() {
        // Buat objek Course dengan ID yang sudah ada di database
        Integer idClass = 1; // Gantilah dengan ID yang sesuai
        DAOCourse dao = new DAOCourse();
        Course course = dao.getCourseById(idClass).get(0); // Mengambil course pertama dari daftar

        // Lakukan pengujian sesuai kebutuhan
        assertEquals("Nama Course yang Diperbarui", course.getClassName()); // Gantilah dengan data yang sesuai
        // Lakukan pengujian untuk atribut lainnya jika diperlukan
    }


    @Test
    public void retrieveAllCoursesTest() {
        DAOCourse dao = new DAOCourse();
        int expectedCourseCount = 19; // Gantilah dengan jumlah course yang diharapkan

        // Lakukan pengujian sesuai kebutuhan
        assertEquals(expectedCourseCount, dao.retrieveAllCourses().size());
    }


    @Test
    public void addCourseTest() {
        // Buat objek Course baru untuk ditambahkan ke database
        Course course = new Course();
        course.setClassName("3ISA1"); // Gantilah dengan data yang sesuai

        DAOCourse dao = new DAOCourse();
        dao.addCourse(course);

        // Lakukan pengujian sesuai kebutuhan
        assertNotNull(course.getIdClass()); // Pastikan ID telah ditetapkan oleh Hibernate
    }


    @Test
    public void deleteCourseTest() {
        // Buat objek Course dengan ID yang akan dihapus
        Integer idClassToDelete = 10; // Gantilah dengan ID yang akan dihapus

        DAOCourse dao = new DAOCourse();
        dao.deleteCourse(idClassToDelete);

        // Lakukan pengujian sesuai kebutuhan, misalnya dengan mencoba mengambil course yang sudah dihapus
        assertEquals(0, dao.getCourseById(idClassToDelete).size());
    }


    @Test
    public void updateCourseTest() {
        // Buat objek Course yang akan diupdate
        Course course = new Course();
        course.setIdClass(1); // Gantilah dengan ID yang sesuai
        course.setClassName("Nama Course yang Diperbarui"); // Gantilah dengan data yang sesuai

        DAOCourse dao = new DAOCourse();
        dao.updateCourse(course);

        // Lakukan pengujian sesuai kebutuhan, misalnya dengan mengambil course yang telah diperbarui
        Course updatedCourse = dao.getCourseById(course.getIdClass()).get(0);
        assertEquals(course.getClassName(), updatedCourse.getClassName());
        // Lakukan pengujian untuk atribut lainnya jika diperlukan
    }
}
