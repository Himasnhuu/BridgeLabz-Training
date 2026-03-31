package parceltracker;

public class ParcelTracker {
    private Node head;

    public ParcelTracker() {
        this.head = null;
    }

    // Add parcel at the beginning (new parcel starts at Packed stage)
    public void addParcel(Parcel parcel) {
        Node newNode = new Node(parcel);
        newNode.next = head;
        head = newNode;
        System.out.println("Added: " + parcel);
    }

    // Move parcel to next stage
    public void updateStatus(String trackingId, String newStatus) {
        Node current = head;
        while (current != null) {
            if (current.parcel.getTrackingId().equals(trackingId)) {
                current.parcel.setStatus(newStatus);
                System.out.println("Updated " + trackingId + " to " + newStatus);
                return;
            }
            current = current.next;
        }
        System.out.println("Parcel not found: " + trackingId);
    }

    // Add checkpoint at a specific position in the chain
    public void addCheckpoint(String trackingId, String checkpoint) {
        Node current = head;
        while (current != null) {
            if (current.parcel.getTrackingId().equals(trackingId)) {
                String currentStatus = current.parcel.getStatus();
                current.parcel.setStatus(currentStatus + " -> " + checkpoint);
                System.out.println("Added checkpoint for " + trackingId + ": " + checkpoint);
                return;
            }
            current = current.next;
        }
    }

    // Handle lost/missing parcels (set to null or remove)
    public void markAsLost(String trackingId) {
        if (head == null) {
            return;
        }

        // If head is the lost parcel
        if (head.parcel.getTrackingId().equals(trackingId)) {
            head.parcel.setStatus("Lost");
            System.out.println("Marked as lost: " + trackingId);
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.parcel.getTrackingId().equals(trackingId)) {
                current.next.parcel.setStatus("Lost");
                System.out.println("Marked as lost: " + trackingId);
                return;
            }
            current = current.next;
        }
    }

    // Display all parcels in the chain
    public void displayAllParcels() {
        System.out.println("\n===== Parcel Tracking Chain =====");
        if (head == null) {
            System.out.println("No parcels in system");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.println(current.parcel);
            current = current.next;
        }
    }

    // Track a specific parcel
    public void trackParcel(String trackingId) {
        Node current = head;
        while (current != null) {
            if (current.parcel.getTrackingId().equals(trackingId)) {
                System.out.println("\nTracking: " + current.parcel);
                return;
            }
            current = current.next;
        }
        System.out.println("Parcel not found: " + trackingId);
    }
}
