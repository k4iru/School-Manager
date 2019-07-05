// CS2212 project
// operations interface
// Author: Kyle Cheung

package operations;

import java.io.FileNotFoundException;
import java.io.IOException;

import authenticatedUsers.LoggedInAuthenticatedUser;
import customDatatypes.NotificationTypes;

public interface IOperations {

	LoggedInAuthenticatedUser login() throws FileNotFoundException, IOException;
	
	//Admin operations
	void startSystem(LoggedInAuthenticatedUser user);
	
	void stopSystem(LoggedInAuthenticatedUser user);
	
	void readCourseFile(LoggedInAuthenticatedUser user, String file) throws IOException;
	
	//Instructor operations
	//String eval is can be assignment, midterm, or final
	void addMark(LoggedInAuthenticatedUser user, String courseID, String studentID, String eval, double mark );
	
	void modifyMark(LoggedInAuthenticatedUser user, String courseID, String studentID, String eval, double mark);
	
	void calculateFinal(LoggedInAuthenticatedUser user, String courseID, String student);
	
	void printClassRecord(LoggedInAuthenticatedUser user, String classID);
	
	//Student operations 
	
	void enroll(LoggedInAuthenticatedUser user, String classID);
	
	void notificationStatus(LoggedInAuthenticatedUser user, NotificationTypes notificationType);
	
	void addNotificationPref(LoggedInAuthenticatedUser user, NotificationTypes notificationType);
	
	void printStudentRecord(LoggedInAuthenticatedUser user, String ID);
}

