package pojo;

import dao.DAOStudent;
import dao.DAOCourse;
import dao.DAOSchedule;
import dao.DAOStudentSubject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


/**
 * Student generated by hbm2java
 */
@ManagedBean
public class Student implements java.io.Serializable {

    private Integer idStudent;
    private Course course;
    private String nama;
    private String email;
    private String password;
    private Student loggedInUser;
    private String nameMessage;
    private Set studentsubjects = new HashSet(0);

    public Student() {
        course = new Course();
    }

    public Student(Course course, String nama, String email, String password, Set studentsubjects) {
        this.course = course;
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.studentsubjects = studentsubjects;
        
    }

    public Integer getIdStudent() {
        return this.idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set getStudentsubjects() {
        return this.studentsubjects;
    }

    public void setStudentsubjects(Set studentsubjects) {
        this.studentsubjects = studentsubjects;
    }
    
    public Student getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(Student loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

   public void save() {
    DAOStudent studentDao = new DAOStudent();
 
    try {
        // Periksa apakah email sudah ada di database
        Student existingStudent = studentDao.getStudentByEmail(email);
        if (existingStudent != null) {
            // Email sudah ada di database, berikan pesan kesalahan
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Email sudah digunakan. Silakan pilih email lain."));
        } else {
            // Email belum ada di database, lakukan penyimpanan
            studentDao.addStudent(this);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Mahasiswa berhasil disimpan."));
        }
    } catch (Exception e) {
        // Tangani eksepsi, misalnya tampilkan pesan kesalahan
        e.printStackTrace();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Terjadi kesalahan saat menyimpan data."));
    }
}




    public void delete() {
        DAOStudent studentDao = new DAOStudent();
        studentDao.deleteStudent(idStudent);
    }
    
    public String getNameMessage() {
    return nameMessage;
}

public void setNameMessage(String nameMessage) {
    this.nameMessage = nameMessage;
}

    public Student getbyid() {
        DAOStudent studentDao = new DAOStudent();
        Student student = studentDao.getStudentByID(idStudent);
        if (student != null) {
            nama = student.getNama();
            email = student.getEmail();
            password = student.getPassword();
        }
        return student;
    }

    public List<Student> getallrecords() {
        DAOStudent studentDao = new DAOStudent();
        List<Student> students = studentDao.retrieveStudent();
        return students;
    }

    public void update() {
        DAOStudent studentDao = new DAOStudent();
        studentDao.updateStudent(this);
    }

    public List<SelectItem> getAllCourses() {
        List<SelectItem> items = new ArrayList<>();
        DAOCourse courseDao = new DAOCourse();
        List<Course> courses = courseDao.retrieveAllCourses();
        for (Course course : courses) {
            items.add(new SelectItem(course.getIdClass(), course.getClassName()));
        }
        return items;
    }

    
   public String login() {
    if (email == null || email.trim().isEmpty() || password == null || password.trim().isEmpty()) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Email and password must be filled in."));
        return "loginerror"; // Redirect to the login error page
    }

    DAOStudent sdao = new DAOStudent();
    List<Student> lecturerList = sdao.login(email, password);
    FacesContext context = FacesContext.getCurrentInstance();

    if (lecturerList != null && !lecturerList.isEmpty()) {
        Student loggedInStudent = lecturerList.get(0);

        // Store the loggedInLecturer in the session
        context.getExternalContext().getSessionMap().put("email", email);

        int idStudent = loggedInStudent.getIdStudent();

        // Fetch the idSubject for the lecturer
     int idSubject = sdao.getIdSubjectForStudent(idStudent);

        // Store the idSubject in the session
        context.getExternalContext().getSessionMap().put("loggedInStudentSubject", idSubject);

        // Fetch the idSchedule for the subject
        int idSchedule = sdao.getIdScheduleForSubject(idSubject);

        // Store the idSchedule in the session
        context.getExternalContext().getSessionMap().put("loggedInLecturerSchedule", idSchedule);

        return "loginsuccess"; // Redirect to the loginsuccess.xhtml page
    } else {
        context.addMessage(null, new FacesMessage("Login failed. Please check your email and password."));
        return null; // Redirect to the login error page
    }
}





    
   public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index";
    }
    
   
    public String getCourseNameByStudentEmail(String email) {
        DAOStudent studentDao = new DAOStudent();
        return studentDao.getCourseNameByStudentEmail(email);
    }
    
    public void validateName() {
    if (nama == null || nama.trim().isEmpty()) {
        nameMessage = "Nama tidak boleh kosong.";
    } else if (!nama.matches("^[A-Za-z ]+$")) {
        nameMessage = "Nama hanya boleh mengandung huruf dan spasi.";
    } else {
        nameMessage = "";
    }
}
    
     

}
