package javaOOP;

public class Topic_01_Class_Object_Student {
	// Property
	private int studentID;
	private String studentName;
	private Float knowledgePoint;
	private Float practicePoint;

	private int getStudentID() {
		return studentID;
	}

	private void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	private String getStudentName() {
		return studentName;
	}

	private void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	private Float getKnowledgePoint() {
		return knowledgePoint;
	}

	private void setKnowledgePoint(Float knowledgePoint) {
		this.knowledgePoint = knowledgePoint;
	}

	private Float getPracticePoint() {
		return practicePoint;
	}

	private void setPracticePoint(Float practicePoint) {
		this.practicePoint = practicePoint;
	}

	private Float getAveragePoint() {
		return (this.knowledgePoint + this.practicePoint * 2) / 3;
	}

	private void showStudentInfo() {
		System.out.println("*********************************");
		System.out.println("Student ID = " + getStudentID());
		System.out.println("Student Name = " + getStudentName());
		System.out.println("Knowledge Point = " + getKnowledgePoint());
		System.out.println("Practice Point = " + getPracticePoint());
		System.out.println("Average Point = " + getAveragePoint());
		System.out.println("*********************************");

	}

	public static void main(String[] args) {
		Topic_01_Class_Object_Student firstStudent = new Topic_01_Class_Object_Student();
		firstStudent.setStudentID(2004);
		firstStudent.setStudentName("Nguyen Van A");
		firstStudent.setKnowledgePoint(6.5f);
		firstStudent.setPracticePoint(8f);
		firstStudent.showStudentInfo();

		Topic_01_Class_Object_Student secondStudent = new Topic_01_Class_Object_Student();
		secondStudent.setStudentID(2005);
		secondStudent.setStudentName("Bui Thi B");
		secondStudent.setKnowledgePoint(7f);
		secondStudent.setPracticePoint(8.5f);
		firstStudent.showStudentInfo();

	}

}
