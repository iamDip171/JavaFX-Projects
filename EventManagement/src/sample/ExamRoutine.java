package sample;

public class ExamRoutine {
    private String subject ;
    private String time ;
    private String day ;

    ExamRoutine (String subject, String time, String day) {
        this.subject = subject ;
        this.time = time ;
        this.day = day ;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

}
