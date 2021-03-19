public class MVCPatternDemo {
	public static void main(String[] args) {

		// Fetch student record based on his roll no from the database
		Student model  = retriveStudentFromDatabase();

		// Create a view : to write student details on console
		StudentView view = new StudentView();

		StudentController controller = new StudentController(model, view);

		controller.updateView();

		// Update model data
		controller.setStudentName("Shyam");

		controller.updateView();
	}

	private static Student retriveStudentFromDatabase(){
		Student student = new Student();
 		student.setName("Sunil");
		student.setRollNo("42");
		return student;
	}
}
