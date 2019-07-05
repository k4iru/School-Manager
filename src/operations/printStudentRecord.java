package operations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import authenticatedUsers.LoggedInAuthenticatedUser;
import customDatatypes.NotificationTypes;
import offerings.CourseOffering;
import registrar.ModelRegister;
import systemUsers.StudentModel;
import systemUsers.SystemUser;

public class printStudentRecord implements IOperations {
	/**
	 * 
	 * @param user	-	the user obj trying to print records
	 * @param courseID - the course's ID
	 */
	public void printStudentRecords (LoggedInAuthenticatedUser user, String courseID) {
		if (!ModelRegister.getInstance().checkIfCourseHasAlreadyBeenCreated(courseID)) {
			//if the course does not exist
			System.out.println("The course does not exist");
			return;
		}

		if (!SystemStatus.getInstance().systemRunning()) {
			System.out.println("The system is not running.");
			return;
		}
		CourseOffering course = ModelRegister.getInstance().getRegisteredCourse(courseID);
		List<StudentModel> enrolledList = course.getStudentsEnrolled();
		StudentModel studentObj = null;
		boolean isAStudent = false;
		if (user.getAuthenticationToken().getUserType() == "student" || user.getAuthenticationToken().getUserType() == "Student") {
			isAStudent = true;
		}
		SystemUser student = ModelRegister.getInstance().getRegisteredUser(user.getID());
		
		int i = 0;
		if (isAStudent) {
			while (i < enrolledList.size()) {
				if (student.getID().equals(enrolledList.get(i).getID())) { //if the student in the session matches the student in the enrolled list
					studentObj = enrolledList.get(i);	//get the student obj
				}
				i++;
			}
	
			System.out.println("Course name: " + course.getCourseName() + " ");
			System.out.println("Course ID: " + course.getCourseID() + " ");
			System.out.println("Course evaluation strategies: " + course.getEvaluationStrategies() + " ");
			System.out.println("Course instructor(s): " + course.getInstructor() + " ");
			System.out.println("Semester: " + course.getSemester() + " ");
			System.out.println("Course marks: " + studentObj.getPerCourseMarks().get(course) + " ");
		}
		System.out.println("The user is not a student. Print cannot be completed.");
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
	public void enroll(LoggedInAuthenticatedUser user, String classID) {
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
