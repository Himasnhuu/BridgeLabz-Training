package week9.online_doctor_consultation_scheduler;
class Doctor {
    private int id;
    private String name;
    private Specialization specialization;

    public Doctor(int id, String name, Specialization specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public String getName() {
        return name;
    }

    // Important for Map keys
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;
        Doctor d = (Doctor) o;
        return id == d.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
