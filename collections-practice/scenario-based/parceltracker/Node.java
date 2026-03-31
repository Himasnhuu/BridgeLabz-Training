package parceltracker;

public class Node {
    Parcel parcel;
    Node next;

    public Node(Parcel parcel) {
        this.parcel = parcel;
        this.next = null;
    }
}
