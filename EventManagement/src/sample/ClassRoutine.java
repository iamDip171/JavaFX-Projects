package sample;

public class ClassRoutine {
    private String subject, day, time ;

    ClassRoutine(String subject, String day, String time) {
        this.subject = subject ;
        this.day =  day ;
        this.time = time ;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
