package pojo;

import dao.DAOStudent;
import dao.DAOStudentSubject;
import dao.DAOSubject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@ManagedBean
public class Studentsubject implements java.io.Serializable {

    private Integer id;
    private Student student;
    private Subject subject;
    private String tahunAjaran;
    private Integer semester;
    private Integer studentId;
    private Integer subjectId;
    private Integer credit; // Added property for credit
    private Integer idSchedule; // Added property for idSchedule

    public Studentsubject() {
        student = new Student();
        subject = new Subject();
    }

    public Studentsubject(Student student, Subject subject, String tahunAjaran, Integer semester) {
        this.student = student;
        this.subject = subject;
        this.tahunAjaran = tahunAjaran;
        this.semester = semester;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return this.subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getTahunAjaran() {
        return this.tahunAjaran;
    }

    public void setTahunAjaran(String tahunAjaran) {
        this.tahunAjaran = tahunAjaran;
    }

    public Integer getSemester() {
        return this.semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(Integer idSchedule) {
        this.idSchedule = idSchedule;
    }

    public List<SelectItem> getAllStudents() {
        List<SelectItem> items = new ArrayList<>();
        DAOStudent studentDao = new DAOStudent();
        List<Student> students = studentDao.retrieveStudent();
        for (Student student : students) {
            items.add(new SelectItem(student.getIdStudent(), student.getNama()));
        }
        return items;
    }

    public List<SelectItem> getAllSubjects() {
        List<SelectItem> items = new ArrayList<>();
        DAOSubject subjectDao = new DAOSubject();
        List<Subject> subjects = subjectDao.retrieveAllSubjects();
        for (Subject subject : subjects) {
            // Mengambil properti dari Subject
            Integer subjectId = subject.getIdSubject();
            String subjectName = subject.getSubjectName();

            // Menambahkan SelectItem dengan informasi yang diambil
            String label = subjectName;
            String value = subjectId.toString();
            items.add(new SelectItem(value, label));
        }
        return items;
    }

    public void save() {
        DAOStudentSubject dao = new DAOStudentSubject();
        dao.addStudentsubject(this);
        // Tambahkan logika lain yang sesuai, misalnya mengatur pesan sukses/gagal
    }

    public void delete() {
        DAOStudentSubject dao = new DAOStudentSubject();
        dao.deleteStudentsubject(this.id);

        // Set a success message
        FacesMessage message = new FacesMessage("Delete ID Subject Successful");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<Studentsubject> getAllRecords() {
        DAOStudentSubject dao = new DAOStudentSubject();
        return dao.retrieveStudentsubjects();
    }

    public void update() {
        DAOStudentSubject dao = new DAOStudentSubject();
        dao.updateStudentsubject(this);
        // Tambahkan logika lain yang sesuai, misalnya mengatur pesan sukses/gagal
    }

    public void getById() {
        DAOStudentSubject dao = new DAOStudentSubject();

        if (this.id != null) {
            Studentsubject studentSubject = dao.getStudentsubjectById(this.id);

            if (studentSubject != null) {
                student = studentSubject.getStudent();
                subject = studentSubject.getSubject();
                semester = studentSubject.getSemester();
                studentId = student != null ? student.getIdStudent() : null;
                subjectId = subject != null ? subject.getIdSubject() : null;
            } else {
                // Add a validation message if the student subject is not found
                FacesMessage message = new FacesMessage("Student subject not found with ID: " + this.id);
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                FacesContext.getCurrentInstance().addMessage("getStudentsubjectById:studentsubjectId", message);
            }
        } else {
            // Add a validation message if the ID is not provided
            FacesMessage message = new FacesMessage("Please enter a valid Studentsubject ID");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage("getStudentsubjectById:studentsubjectId", message);
        }
    }

    public List<Studentsubject> getAllRecordsA() {
        // Get the logged-in student's ID from the session
        Integer loggedInStudentId = (Integer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loggedInStudentId");

        if (loggedInStudentId != null) {
            // Fetch the list of studentsubject records for the logged-in student
            DAOStudentSubject daoStudentSubject = new DAOStudentSubject();
            List<Studentsubject> studentSubjects = daoStudentSubject.getStudentSubjectsByStudentId(loggedInStudentId);

            return studentSubjects;
        } else {
            // If no student is logged in, return an empty list
            return Collections.emptyList();
        }
    }

}
