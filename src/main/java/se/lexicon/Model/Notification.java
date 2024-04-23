package se.lexicon.model;

import java.time.LocalDateTime;

public abstract class Notification {
    private String id;
    private LocalDateTime createDateTime;
    private boolean status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public abstract String summary();

    @Override
    public String toString() {
        return "Notification{" +
                "id='" + id + '\'' +
                ", createDateTime=" + createDateTime +
                ", status=" + status +
                '}';
    }

}