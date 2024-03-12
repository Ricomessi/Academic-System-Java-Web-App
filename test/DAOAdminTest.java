import dao.DAOAdmin;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pojo.Admin;

public class DAOAdminTest {
    public DAOAdminTest() {
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
public void loginTest() {
    // Buat objek Admin baru untuk ditambahkan ke database
    Admin admin = new Admin();
    admin.setEmail("rico@gmail.com"); // Gantilah dengan data yang sesuai
    admin.setPassword("123456"); // Gantilah dengan data yang sesuai

    // Simpan objek Admin ke database
    DAOAdmin dao = new DAOAdmin();
    List<Admin> loggedInAdmins = dao.login(admin.getEmail(), admin.getPassword());

    // Lakukan pengujian sesuai kebutuhan
    assertNotNull(loggedInAdmins); // Pastikan hasil login tidak null
    assertFalse(loggedInAdmins.isEmpty()); // Pastikan hasil login mengandung setidaknya satu elemen

    Admin loggedInAdmin = loggedInAdmins.get(0); // Ambil elemen pertama (asumsi hanya satu admin dengan email yang sama)
    assertEquals(admin.getEmail(), loggedInAdmin.getEmail()); // Pastikan email sesuai
    assertNotNull(loggedInAdmin.getNama()); // Pastikan atribut 'nama' telah ditetapkan dengan benar
}


   
}
