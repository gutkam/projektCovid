package pl.sdacademy.json;

public class Status {
    private Status status;

    public Status(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
