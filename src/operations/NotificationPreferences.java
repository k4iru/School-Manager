package operations;
import java.io.FileNotFoundException;
import java.io.IOException;

import authenticatedUsers.LoggedInAuthenticatedUser;
import customDatatypes.NotificationTypes;
import systemUsers.StudentModel;
import registrar.ModelRegister;
public class NotificationPreferences implements IOperations {
	/**
	 * 
	 * @param ID - one of the courses the student is in
	 * @param type - the type of notification they wish to change it to
	 * @param userID - the student's user ID
	 */
	public void NotificationPreference(LoggedInAuthenticatedUser user, NotificationTypes type) {
		//CourseOffering course = ModelRegister.getInstance().getRegisteredCourse(ID);
		//List<StudentModel> enrolledList = course.getStudentsEnrolled();
		if (!SystemStatus.getInstance().systemRunning()) 
			return;
		if (user.getAuthenticationToken().getUserType() == "student" || user.getAuthenticationToken().getUserType() == "Student") {
			StudentModel currentStudent = (StudentModel) ModelRegister.getInstance().getRegisteredUser(user.getID());
			currentStudent.setNotificationType(type);
		}
		System.out.println("The user is not a student so notification preferences cannot be changed.");
		//LoggedInStudent currentStudent = new LoggedInStudent();
		/*int i = 0;
		StudentModel student = null;
		while (i < enrolledList.size()) {
			if ((enrolledList.get(i)).getID().equals(currentStudent.getID())) {
				 student = enrolledList.get(i);
			}
			i++;
		}
		
		student.setNotificationType(type);*/
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
