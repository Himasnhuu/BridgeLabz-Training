package reviews.linkedlistimplementation;

class Student {
	
	String name;
	int rollNo;
	int age;
	int id;
	String course;
	
	Student next;
	
	public Student(String name, int rollNo, int age, int id, String course) {

		this.name = name;
		this.rollNo = rollNo;
		this.age = age;
		this.id = id;
		this.course = course;
		
		this.next = null;
	}
	
	public String toString() {
		return String.format("Student Id: %d , Student name: %s , Student Roll No.: %d ,"
				+ " Student Age: %d , Student Course: %s",id, name, rollNo, age, course);
	}
	
	
	
}
