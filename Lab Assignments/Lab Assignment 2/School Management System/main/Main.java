package main;
import schoolObjects.*;

public class Main{

	public static void main(String args[]){

		Teacher teachers[] = new Teacher[2];
		teachers[0] = new Teacher("Ahmad", 25, "T01", "Mathematics");
		teachers[1] = new Teacher("Javeria", 23, "T02", "English");

		Student students1[] = new Student[5];
		students1[0] = new Student("Ali", 14, "FA01");
		students1[1] = new Student("Haider", 15, "FA02");
		students1[2] = new Student("Hammad", 25, "FA03");
		students1[3] = new Student("Maheen", 14, "FA04");
		students1[4] = new Student("Anas", 13, "FA05");

		Student students2[] = new Student[5];
		students2[0] = new Student("Anas", 14, "FA06");
		students2[1] = new Student("Farhan", 15, "FA07");
		students2[2] = new Student("Hammad", 25, "FA08");
		students2[3] = new Student("Ansar", 14, "FA09");
		students2[4] = new Student("Anas", 15, "FA010");

		School school = new School("Allied School", "182-A Pak Block, Lahore", new Principal("Ahmad Ali", 25, 5), 2, teachers, students1, students2);
		System.out.println(school);

		System.out.println("Comparing teachers:");
		System.out.println("Teacher 1: " + teachers[0].getName() + "\nTeacher 2: " + teachers[1].getName());
		System.out.println("Are equal: " + teachers[0].equals(teachers[1]));

		System.out.println("\nComparing students:");
		System.out.println("Student 1: " + students1[0].getName() + "\nStudent 2: " + students1[1].getName());
		System.out.println("Are equal: " + students1[0].equals(students1[1]));
	}
}