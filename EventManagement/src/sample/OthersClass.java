package sample;

public class OthersClass {
    private String eventName, eventTime, eventDate ;

    OthersClass (String eventName, String eventDate, String eventTime) {
        this.eventDate = eventDate ;
        this.eventName = eventName ;
        this.eventTime = eventTime ;
    }


    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }
}
