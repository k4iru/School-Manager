// CS2212 project
// Read Course Files
// Author: Kyle Cheung

package operations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import authenticatedUsers.LoggedInAuthenticatedUser;
import customDatatypes.NotificationTypes;
import offerings.OfferingFactory;

public class ReadCourseFile implements IOperations {

	@Override
	public LoggedInAuthenticatedUser login() {
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


	public void readCourseFile(LoggedInAuthenticatedUser user, String file) throws IOException {
		if (user.getAuthenticationToken().getUserType() == "Admin") {
			try {
				OfferingFactory factory = new OfferingFactory();
				BufferedReader br = new BufferedReader(new FileReader(file));
				factory.createCourseOffering(br);
				br.close();
			}
			catch(IOException e) {
				System.out.println("File read Error");
			}
		}


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
