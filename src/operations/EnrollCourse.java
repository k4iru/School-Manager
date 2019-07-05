package operations;

import offerings.*;
import registrar.ModelRegister;
import systemUsers.StudentModel;
import systemUsers.SystemUserModel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import authenticatedUsers.LoggedInAuthenticatedUser;
import customDatatypes.NotificationTypes;

public class EnrollCourse implements IOperations {
	/**
	 * 
	 * @param ID - the course ID the student uses to enroll
	 * @param user - the user obj currently trying to perform an operation
	 */
	public void enroll(LoggedInAuthenticatedUser user, String ID) {
		
		if (!ModelRegister.getInstance().checkIfCourseHasAlreadyBeenCreated(ID)) //if the course does not exist
			return;
		if (!SystemStatus.getInstance().systemRunning()) 
			return;
		CourseOffering course = ModelRegister.getInstance().getRegisteredCourse(ID); //get the course in the system
		List<StudentModel> allowedList = course.getStudentsAllowedToEnroll(); //the students allowed to register in the course
		List<StudentModel> enrolledList = course.getStudentsEnrolled();		//gets the list of students that are enrolled
		boolean isAStudent = false;		//checks to see if the user enrolling into the course is a student.
		if (user.getAuthenticationToken().getUserType() == "student" || user.getAuthenticationToken().getUserType() == "Student") {
			isAStudent = true;
		}
		String userID = user.getID();	//gets the user's ID from the user obj
		SystemUserModel currentStudent = ModelRegister.getInstance().getRegisteredUser(userID);
		
		Iterator<StudentModel> iter = allowedList.iterator();	//to iterate through the elements of students allowed to enroll
		if (isAStudent) {
			while (iter.hasNext()) {
				StudentModel allowedStudent = iter.next();
				if (allowedStudent.getID().equals(currentStudent.getID())) { //if the student is in the list of people that can enroll
					enrolledList.add(allowedStudent); 	//add the student that's allowed on the allowed list into the enrolled list (for course side)
					List<ICourseOffering> studentList = allowedStudent.getCoursesEnrolled();	//take the logged in student's list of courses they are enrolled into
					studentList.add(course); //add the new course to the student's list (for student side)
					System.out.println("Student " + allowedStudent.getID() + " has successfully enrolled in the course");
					
				//StudentModel newStudent = new StudentModel(); //new student obj to put into the enrolled list
				//this might need the new student to implement the courses they're enrolled in, courses they're eligible to enroll into
				//and the evaluation schemes of those courses
				//newStudent.setSurname(currentStudent.getSurname());
				//newStudent.setID(currentStudent.getID());
				//newStudent.setName(currentStudent.getName());
				
				//add student to enrolledList
				//enrolledList.add(newStudent);
				
				//course.setStudentsEnrolled(enrolledList);	//update the list of enrolled students
				//update the list of enrolled students for both course objs and student objs
				}
			}
		}
		System.out.println("Student is unable to enroll in this course.");	
		
	}

	@Override
	public LoggedInAuthenticatedUser login() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void startSystem(LoggedInAuthenticatedUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopSystem(LoggedInAuthenticatedUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readCourseFile(LoggedInAuthenticatedUser user, String file) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addMark(LoggedInAuthenticatedUser user, String courseID, String studentID, String eval, double mark) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyMark(LoggedInAuthenticatedUser user, String courseID, String studentID, String eval,
			double mark) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calculateFinal(LoggedInAuthenticatedUser user, String courseID, String student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printClassRecord(LoggedInAuthenticatedUser user, String classID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notificationStatus(LoggedInAuthenticatedUser user, NotificationTypes notificationType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNotificationPref(LoggedInAuthenticatedUser user, NotificationTypes notificationType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printStudentRecord(LoggedInAuthenticatedUser user, String ID) {
		// TODO Auto-generated method stub
		
	}
}
