package operations;

import java.io.FileNotFoundException;
import java.io.IOException;

import authenticatedUsers.LoggedInAuthenticatedUser;
import customDatatypes.NotificationTypes;
import registrar.ModelRegister;
import systemUsers.StudentModel;

public class NotificationStatus implements IOperations {
	/**
	 * 
	 * @param userID - student's ID
	 * @param courseID - ID of the course
	 * @param status - if they want notifications to be on or off
	 * @param type - the form of notification they have
	 */
	public void notificationStatus(LoggedInAuthenticatedUser user, boolean status) {
		if (!SystemStatus.getInstance().systemRunning()) 
			return;
		StudentModel student = (StudentModel) ModelRegister.getInstance().getRegisteredUser(user.getID());
		if (user.getAuthenticationToken().getUserType() == "student" || user.getAuthenticationToken().getUserType() == "Student") {
			if (status == true) {
				student.setNotificationStatus(true);
				System.out.println("Notifications are now on.");
				return;
			}else{ //if they want it to be off
				student.setNotificationStatus(false);
				System.out.println("Notifications are now off.");
				return;
			}
		}
		System.out.println("notification status could not be changed. The user is not a student");
		/*CourseOffering course = ModelRegister.getInstance().getRegisteredCourse(courseID);
		int i = 0;
		while (i < course.getStudentsEnrolled().size()) {
			if (course.getStudentsEnrolled().get(i).getID().equals(student.getID())) {
				StudentModel enrolledStudent = course.getStudentsEnrolled().get(i);
				NotificationTypes notifType = type;
				if (status == true) { //on
					enrolledStudent.setNotificationType(notifType);
				}else{ //off
					enrolledStudent.setNotificationType(null);
				}
			}
			i++;
		}*/
		
			
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
	

