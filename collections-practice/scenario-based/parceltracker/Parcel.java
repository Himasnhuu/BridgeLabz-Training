package parceltracker;

public class Parcel {
    private String trackingId;
    private String status;
    private String destination;

    public Parcel(String trackingId, String destination) {
        this.trackingId = trackingId;
        this.destination = destination;
        this.status = "Packed";
    }

    public String getTrackingId() {
        return trackingId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "Parcel[ID: " + trackingId + ", Status: " + status + ", Destination: " + destination + "]";
    }
}
