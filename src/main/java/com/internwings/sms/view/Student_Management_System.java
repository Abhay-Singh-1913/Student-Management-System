package com.internwings.sms.view;

public class Student_Management_System {
	static Scanner myInput = new Scanner(System.in);
	static StudentController controller = new StudentController();

	static {
		System.out.println("//////////////////////////////////////////////////////////");
		System.out.println("/////                                                /////");
		System.out.println("/////----- WELCOME TO STUDENT MANAGEMENT SYSTEM -----/////");
		System.out.println("/////                                                /////");
		System.out.println("//////////////////////////////////////////////////////////");
	}
	public static void main(String[] args) {
		final String red = "\u001b[31;1m";
		final String white = "\u001b[37;1m";
		final String green = "\u001b[32;1m";
		final String reset = "\u001b[0m";
		final String yellow = "\u001b[33m";

		boolean Flag = true;
		while (Flag) {
			System.out.println(yellow);
			System.out.println(" ___________________________________ ");
			System.out.println("|                                   |");
			System.out.println("|     ==== Welcome To MENU ====     |");
			System.out.println("|___________________________________|");
			System.out.println("|                                   |");
			System.out.println("|  1. Add new Student               |");
			System.out.println("|                                   |");
			System.out.println("|  2. Update Student Details        |");
			System.out.println("|                                   |");
			System.out.println("|  3. Search Student by Rollno.     |");
			System.out.println("|                                   |");
			System.out.println("|  4. Display all the Student       |");
			System.out.println("|                                   |");
			System.out.println("|  0. Exit                          |");
			System.out.println("|___________________________________|" + reset);
			System.out.println(white);
			System.out.println(" =================================== ");
			System.out.print("| Enter Your Choice : ");
			byte choice = myInput.nextByte();
			myInput.nextLine();
			System.out.println(" =================================== ");
			System.out.println();

			switch (choice) {

			case 0:
				myInput.close();
				Flag = false;
				break;
			case 1:
				System.out.println(green);
				System.out.println(" ============================================ ");
				System.out.println("| Enter all the details of Student carefully |");
				System.out.println("| in order of rollno 1 to last rollno        |");
				System.out.println("|    ( Rollno is auto generating)            |");
				System.out.println(" ============================================ ");
				System.out.println(white);
				System.out.println(" ============================================ ");
				System.out.print("| Enter the fullname of Student : ");
				String fullname = myInput.nextLine();
				System.out.println(" ============================================ ");
				System.out.print("| Enter the Grade of Student(in percentage): ");
				double percentage = myInput.nextDouble();
				myInput.nextLine();
				System.out.println(" ============================================ ");
				Student newStudent = new Student();
				newStudent.setName(fullname);
				newStudent.setGrade(percentage);

				if (controller.addStudent(newStudent)) {
					System.out.println(green);
					System.out.println(" =================================== ");
					System.out.println("|    Student Added Successfully     |");
					System.out.println(" =================================== ");
					System.out.println(reset);
				} else {
					System.out.println(red);
					System.out.println(" =================================== ");
					System.out.println("|      Failed to Add Student        |");
					System.out.println(" =================================== ");
					System.out.println(reset);
				}
				break;
	}

}
