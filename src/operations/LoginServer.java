// CS2212 project
// Login Server
// Author: Kyle Cheung

package operations;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import authenticatedUsers.LoggedInAuthenticatedUser;
import authenticationServer.AuthenticationToken;
import customDatatypes.NotificationTypes;
import loggedInUserFactory.LoggedInUserFactory;

import java.util.Scanner;

public class LoginServer implements IOperations {
	private String name, surname, ID;
	
	public LoggedInAuthenticatedUser login() throws FileNotFoundException, IOException, NullPointerException {
		Scanner in = new Scanner(System.in);
		
		System.out.println("What is your first name: ");
		name = in.next();
		
		System.out.println("What is your last name: ");
		surname = in.next();
		
		System.out.println("What is your ID");
		ID = in.next();
		
		BufferedReader br = new BufferedReader(new FileReader(new File("database.txt")));
		try{
			String line;
			
			while ((line = br.readLine()) != null ) {
			if (name.equals(line.split("\t")[0]) && surname.equals(line.split("\t")[1]) && ID.equals(line.split("\t")[2])) {
				AuthenticationToken userToken = new AuthenticationToken();
				userToken.setUserType(line.split("\t")[3]);
				br.close();
				
				LoggedInUserFactory factory = new LoggedInUserFactory();
				LoggedInAuthenticatedUser user = factory.createAuthenticatedUser(userToken);
				user.setAuthenticationToken(userToken);
				return user;
			}
			}
		}
		catch(IOException ioe){
			
			System.out.println(ioe.getMessage() + "exception thrown at LoggedInUserCreation"); 
			return null;
		}
		
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
