package dzholdoshbaev.jobsearch.model;

import java.time.LocalDateTime;

public class Messages {
    private int id;
    private int responded_applicants;
    private String content;
    private LocalDateTime timestamp;

    public Messages(int responded_applicants, int id, String content, LocalDateTime timestamp) {
        this.responded_applicants = responded_applicants;
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResponded_applicants() {
        return responded_applicants;
    }

    public void setResponded_applicants(int responded_applicants) {
        this.responded_applicants = responded_applicants;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "id=" + id +
                ", responded_applicants=" + responded_applicants +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
