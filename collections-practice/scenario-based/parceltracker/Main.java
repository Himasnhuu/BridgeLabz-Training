package parceltracker;

public class Main {
    public static void main(String[] args) {
        ParcelTracker tracker = new ParcelTracker();

        // Add parcels
        tracker.addParcel(new Parcel("PKG001", "New York"));
        tracker.addParcel(new Parcel("PKG002", "Los Angeles"));
        tracker.addParcel(new Parcel("PKG003", "Chicago"));

        // Display all parcels
        tracker.displayAllParcels();

        // Update statuses to move through stages
        tracker.updateStatus("PKG001", "Shipped");
        tracker.updateStatus("PKG002", "Shipped");
        tracker.updateStatus("PKG001", "In Transit");

        // Add custom checkpoints
        tracker.addCheckpoint("PKG001", "Customs Clearance");
        tracker.addCheckpoint("PKG002", "Distribution Center");

        // Track specific parcel
        tracker.trackParcel("PKG001");

        // Mark a parcel as lost
        tracker.markAsLost("PKG003");

        // Display final status of all parcels
        tracker.displayAllParcels();

        // Update to delivered
        tracker.updateStatus("PKG001", "Delivered");
        tracker.trackParcel("PKG001");
    }
}
