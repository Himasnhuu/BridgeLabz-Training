package reviews.linkedlistimplementation;

class StudentLinkedList {

	private Student head;

	public StudentLinkedList() {
		this.head = null;
	}

	public void addAtbeg(String name, int rollNo, int age, int id, String course) {
		Student s = new Student(name, rollNo, age, id, course);
		s.next = head;
		head = s;

		System.out.println("Student information added at the begenning");

	}

	public void addAtEnd(String name, int rollNo, int age, int id, String course) {
		Student s = new Student(name, rollNo, age, id, course);
		Student temp = head;

		if (temp == null) {
			addAtbeg(name, rollNo, age, id, course);
			return;
		}

		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = s;
		System.out.println("Student information added at the end");

	}

	public void addAtPosition(String name, int rollNo, int age, int id, String course, int pos) throws InvalidPositionException {

		Student s = new Student(name, rollNo, age, id, course);

		if (pos < 1) {
			throw new InvalidPositionException("Invalid Position");
		}

		if (pos == 1) {
			addAtbeg(name, rollNo, age, id, course);
			return;
		}

		Student temp = head;
		int count = 1;

		while (temp != null && count < pos) {
			temp = temp.next;
			count++;
		}

		if (temp == null) {
			throw new InvalidPositionException("Invalid Position");
		}

		s.next = temp.next;
		temp.next = s;

		System.out.println("Student information added at position " + pos);

	}

	public void deleteByRoll(int r) throws StudentNotFoundException {

		if (head == null) {
			throw new StudentNotFoundException("Student not found List is empty.");
		}

		if (head.rollNo == r) {
			head = head.next;
			System.out.println("Student information is deleted");
			return;
		}

		Student temp = head;

		while (temp.next != null && temp.next.rollNo != r) {
			temp = temp.next;
		}

		if (temp.next == null) {
			throw new StudentNotFoundException("Student not found unable to delete");
		}

		temp.next = temp.next.next;
		System.out.println("Student information deleted");

	}
	
	public void displayStudentRecord() throws StudentNotFoundException {
		
		if(head == null) {throw new StudentNotFoundException("Student not found List is Empty.");}
		
		Student temp = head;
		
		while(temp != null) {
			System.out.println(temp);
			temp = temp.next;
		}
		
	}

}
