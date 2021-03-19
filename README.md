# MVC (Model View Controller) Pattern

<br />

* Model
Model represents an object carrying data. It can also have logic to update controller if its data changes.

* View
View represents the visualization of the data that model contains.

* Controller
Controller acts on both model and view. It controls the data flow into model object and updates the view whenever data changes. It keeps view and model separate.

<br />

![Diagram of Simple MVC Pattern](https://www.tutorialspoint.com/design_pattern/images/mvc_pattern_uml_diagram.jpg)

<br />

### Student.java 

```java
public class Student {
	private String rollNo;
	private String name;
   
	public String getRollNo() {
		return rollNo;
	}
   
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
   
	public String getName() {
		return name;
	}
   
	public void setName(String name) {
		this.name = name;
	}
}
```

### StudentView.java 

```java
public class StudentView {
	public void printStudentDetails(String studentName, String studentRollNo) {
		System.out.println("Student: ");
		System.out.println("Name: " + studentName);
		System.out.println("Roll No: " + studentRollNo);
	}
}
```

### StudentController.java 

```java
public class StudentController {
	private Student model;
	private StudentView view;

	public StudentController(Student model, StudentView view) {
		this.model = model;
		this.view = view;
	}

	public void setStudentName(String name) {
		model.setName(name);		
	}

	public String getStudentName() {
 		return model.getName();		
	}

	public void setStudentRollNo(String rollNo) {
 		model.setRollNo(rollNo);		
	}

	public String getStudentRollNo() {
		return model.getRollNo();		
	}

	public void updateView() {				
		view.printStudentDetails(model.getName(), model.getRollNo());
	}	
}
```

### MVCPatternDemo.java 

```java
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
```
