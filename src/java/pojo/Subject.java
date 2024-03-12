package pojo;

import dao.DAOSubject;
import dao.DAOSchedule;
import pojo.Course;
import pojo.Schedule;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class Subject implements java.io.Serializable {

    private Integer idSubject;
    private Schedule schedule;
    private String subjectName;
    private Integer credit;
    private Schedule selectedSchedule; // Tambahkan variabel untuk menyimpan schedule yang dipilih
    private String startDate; // Tambahkan variabel untuk start date
    private String dueDate; // Tambahkan variabel untuk due date
    private String selectedClass; // Tambahkan variabel untuk class yang dipilih
    private Set studentsubjects = new HashSet(0);
    private Set lecturersubjects = new HashSet(0);
    private Course course;
    private Integer scheduleId;

    public Subject() {
        this.schedule = new Schedule();
        this.course = new Course();
    }

    public Subject(Schedule schedule, String subjectName, Integer credit, Set studentsubjects, Set lecturersubjects) {
        this.schedule = schedule;
        this.subjectName = subjectName;
        this.credit = credit;
        this.studentsubjects = studentsubjects;
        this.lecturersubjects = lecturersubjects;
    }
    
    
    public Integer getScheduleId() {
    return scheduleId;
}

public void setScheduleId(Integer scheduleId) {
    this.scheduleId = scheduleId;
}

    public Course getCourse() {
    return this.course;
}

    public Integer getIdSubject() {
        return this.idSubject;
    }

    public void setIdSubject(Integer idSubject) {
        this.idSubject = idSubject;
    }

    public Schedule getSchedule() {
        return this.schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getSubjectName() {
        return this.subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getCredit() {
        return this.credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }
    
    

    public Set getStudentsubjects() {
        return this.studentsubjects;
    }

    public void setStudentsubjects(Set studentsubjects) {
        this.studentsubjects = studentsubjects;
    }

    public Set getLecturersubjects() {
        return this.lecturersubjects;
    }

    public void setLecturersubjects(Set lecturersubjects) {
        this.lecturersubjects = lecturersubjects;
    }

    public Schedule getSelectedSchedule() {
        return selectedSchedule;
    }

    // Tambahkan getter untuk startDate
    public String getStartDate() {
        return startDate;
    }

    // Tambahkan getter untuk dueDate
    public String getDueDate() {
        return dueDate;
    }

    // Tambahkan getter untuk selectedClass
    public String getSelectedClass() {
        return selectedClass;
    }

    public void addSubject() {
        DAOSubject subjectDao = new DAOSubject();
        try {
            // Implement your add subject logic here
            // Example:
            subjectDao.addSubject(this);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions, e.g., display an error message
        }
    }

    public void deleteSubject() {
        DAOSubject subjectDao = new DAOSubject();
        try {
            // Implement your delete subject logic here
            // Example:
            subjectDao.deleteSubject(this.idSubject);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions, e.g., display an error message
        }
    }

    public Subject getSubjectById() {
    DAOSubject subjectDao = new DAOSubject();
    try {
        // Implement your get subject by ID logic here
        // Example:
        Subject foundSubject = subjectDao.getSubjectByID(idSubject);
        
        if (foundSubject != null) {
            // Jika subjek ditemukan, set properti subjek dengan hasil pencarian
            this.idSubject = foundSubject.getIdSubject();
            this.subjectName = foundSubject.getSubjectName();
            this.credit = foundSubject.getCredit();
            this.scheduleId = foundSubject.getSchedule().getIdSchedule();
        } else {
            // Jika subjek tidak ditemukan, bersihkan properti subjek
            this.idSubject = null;
            this.subjectName = null;
            this.credit = null;
            this.scheduleId = null;
        }
        
        return foundSubject;
    } catch (Exception e) {
        e.printStackTrace();
        // Handle exceptions, e.g., display an error message
        return null;
    }
}


    public List<Subject> getAllSubjects() {
        DAOSubject subjectDao = new DAOSubject();
        try {
            // Implement your get all subjects logic here
            // Example:
            return subjectDao.retrieveAllSubjects();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions, e.g., display an error message
            return new ArrayList<>();
        }
    }

    public void updateSubject() {
        DAOSubject subjectDao = new DAOSubject();
        try {
            // Implement your update subject logic here
            // Example:
            subjectDao.updateSubject(this);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions, e.g., display an error message
        }
    }

    public void selectSchedule(int scheduleId) {
        DAOSchedule scheduleDao = new DAOSchedule(); // Ganti dengan DAO Schedule yang sesuai
        try {
            // Implementasi untuk mengambil detail schedule berdasarkan scheduleId
            Schedule selectedSchedule = scheduleDao.getScheduleByID(scheduleId);

            // Set nilai start date, due date, dan class pada form
            if (selectedSchedule != null) {
                this.selectedSchedule = selectedSchedule;
                // Atur nilai start date, due date, dan class ke form
                this.startDate = selectedSchedule.getStartDate();
                this.dueDate = selectedSchedule.getDueDate();
                this.selectedClass = selectedSchedule.getCourse().getClassName();
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions, e.g., display an error message
        }
    }
    
    public List<Schedule> getAllSchedules() {
    DAOSchedule scheduleDao = new DAOSchedule(); // Ganti dengan DAO Schedule yang sesuai
    try {
        // Implementasi untuk mendapatkan semua jadwal
        return scheduleDao.retrieveAllSchedules();
    } catch (Exception e) {
        e.printStackTrace();
        // Handle exceptions, e.g., display an error message
        return new ArrayList<>();
    }
}
    public void saveSubject() {
    DAOSubject subjectDao = new DAOSubject();
    try {
        // Implement your save subject logic here
        // Contoh:
        subjectDao.addSubject(this);
    } catch (Exception e) {
        e.printStackTrace();
        // Tangani eksepsi, misalnya tampilkan pesan kesalahan
    }
}
    
    public List<Subject> getAllSubjectsForLoggedInLecturer() {
    try {
        // Get idSubject from the lecturer's login session
        int idSubject = (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loggedInLecturerSubject");

        if (idSubject <= 0) {
            throw new NullPointerException("idSubject is null or invalid"); // Simulate a NullPointerException
        }

        DAOSubject subjectDao = new DAOSubject(); // Replace with the appropriate Subject DAO
        List<Subject> allSubjects = subjectDao.retrieveAllSubjects(); // Get all subjects

        List<Subject> subjectsForLoggedInLecturer = new ArrayList<>();

        // Filter subjects based on idSubject
        for (Subject subject : allSubjects) {
            if (subject.getIdSubject() == idSubject) {
                subjectsForLoggedInLecturer.add(subject);
            }
        }

        return subjectsForLoggedInLecturer;
    } catch (NullPointerException e) {
        // Handle the NullPointerException, log it, and provide a user-friendly message
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("ACCESS DENIED!!!"));
        e.printStackTrace(); // Log the exception (you can replace this with proper logging)
        return new ArrayList<>(); // Return an empty list or another appropriate default value
    }
}

    
   public List<Subject> getAllSubjectsForLoggedInStudent() {
    try {
        // Dapatkan idSubject dari sesi login mahasiswa
        int idSubject = (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loggedInStudentSubject");

        if (idSubject <= 0) {
            throw new NullPointerException("idSubject is null or invalid"); // Simulasikan NullPointerException
        }

        DAOSubject subjectDao = new DAOSubject(); // Gantilah dengan DAO Subject yang sesuai
        List<Subject> allSubjects = subjectDao.retrieveAllSubjects(); // Dapatkan semua subjek

        List<Subject> subjectsForLoggedInStudent = new ArrayList<>();

        // Filter subjek sesuai dengan idSubject
        for (Subject subject : allSubjects) {
            if (subject.getIdSubject() == idSubject) {
                subjectsForLoggedInStudent.add(subject);
            }
        }

        return subjectsForLoggedInStudent;
    } catch (NullPointerException e) {
        // Tangani NullPointerException, catat, dan berikan pesan yang ramah pengguna
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("ACCESS DENIED!!!"));
        e.printStackTrace(); // Catat exception (Anda dapat menggantinya dengan logging yang sesuai)
        return new ArrayList<>(); // Kembalikan daftar kosong atau nilai default yang sesuai
    }
}


   


}