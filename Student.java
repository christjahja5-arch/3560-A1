package ivote;

//create a unique student ID that allows them to submit answers 

public class Student {

    private final String studentId;

    public Student(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String toString() {
        return "Student[" + studentId + "]";
    }
}