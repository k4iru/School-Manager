// Test Harness CS2212 School Management Project
// 
//
package testHarness;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import authenticatedUsers.LoggedInAuthenticatedUser;
import authenticatedUsers.LoggedInInstructor;
import authenticationServer.AuthenticationToken;
import offerings.CourseOffering;
import offerings.OfferingFactory;
import operations.*;


public class TestHarness {

	public static void main(String[] args) throws IOException{
		//		Create an instance of an OfferingFactory
		OfferingFactory factory = new OfferingFactory();
		BufferedReader br = new BufferedReader(new FileReader(new File("note_1.txt")));
		//		Use the factory to populate as many instances of courses as many files we've got.
		CourseOffering courseOffering = factory.createCourseOffering(br);
		br.close();
		//		Loading 1 file at a timeKo
		br = new BufferedReader(new FileReader(new File("note_2.txt")));
		//		here we have only two files
		courseOffering = factory.createCourseOffering(br);
		br.close();



		//Test Login Operations 
		//creates a login server
		System.out.println("Testing Login Operations..");
		LoginServer authenticationServer = new LoginServer();
		LoggedInAuthenticatedUser user = authenticationServer.login();

		try {
			System.out.println("User type is: " + user.getAuthenticationToken().getUserType());
			System.out.println("Login Test Success!\n");
		} catch(NullPointerException e) {
			System.out.println("User not in database");
			System.out.println("Login Test Failed\n");
		}

		//Test start server operation
		System.out.println("Start System Test..");
		try {
			StartSystem startSystem = new StartSystem();
			startSystem.startSystem(user);
			if (SystemStatus.getInstance().systemRunning() == true) {
				System.out.println("Start Test Success!\n");
			}
			else {
				System.out.println("User not Admin");
				System.out.println("Start Test Failed\n");
			}
		} 
		catch (Exception e) {
			System.out.println("Start Test Failed\n");
		}

		
		AuthenticationToken a = new AuthenticationToken();
		a.setUserType("Instructor");

		AuthenticationToken b = new AuthenticationToken();
		b.setUserType("Student");

		AuthenticationToken c = new AuthenticationToken();
		c.setUserType("Instructor");

		AddMark addMark = new AddMark();
		ModifyMark modMark = new ModifyMark();
		CalculateFinal calFinal = new CalculateFinal();
		PrintClassRecord prntRec = new PrintClassRecord();



		LoggedInAuthenticatedUser inst = new LoggedInInstructor();
		inst.setID("1234");
		inst.setName("Kostas");
		inst.setSurname("Kontogiannis");
		inst.setAuthenticationToken(a);
		inst.getAuthenticationToken().setUserType("Instructor");



		LoggedInAuthenticatedUser phonyInst = new LoggedInInstructor();
		phonyInst.setID("1264");
		phonyInst.setName("John");
		phonyInst.setSurname("Smith");
		phonyInst.setAuthenticationToken(b);
		inst.getAuthenticationToken().setUserType("Student");

		LoggedInAuthenticatedUser phonyInst2 = new LoggedInInstructor();
		phonyInst2.setID("5675");
		phonyInst2.setName("Robert");
		phonyInst2.setSurname("Weber");
		phonyInst2.setAuthenticationToken(c);
		inst.getAuthenticationToken().setUserType("Instructor");




		addMark.addMark(phonyInst, "CS2212B", "1264", "Final", 50.00); // Not instructor token
		addMark.addMark(inst, "dankMemes101", "1264", "Final", 50.00); // course not registered
		addMark.addMark(phonyInst2, "CS2212B", "1264", "Final", 50.00); // Not instructor
		addMark.addMark(inst, "CS2212B", "12345737272", "Final", 50.00); // Not Student in Course
		addMark.addMark(inst, "CS2212B", "1264", "Final", 50.00); // goodMethod
		//addMark.addMark(inst, "CS2212B", "1264", "Final", 50.00); // system not on

		modMark.modifyMark(phonyInst, "CS2212B", "1264", "Final", 55.00); // not instructor token
		modMark.modifyMark(inst, "DankMemes101", "1264", "Final", 55.00); // course not registered
		modMark.modifyMark(phonyInst2, "CS2212B", "1264", "Final", 55.00); // not instructor for course
		modMark.modifyMark(inst, "CS2212B", "1873", "Final", 55.00); // not student in course
		modMark.modifyMark(inst, "CS2212B", "1264", "Final", 55.00); // good but NO NOTIFICATION
		modMark.modifyMark(inst, "CS2212B", "1264", "Final", 55.00); // good NOTIFICATION
		//modMark.modifyMark(inst, "CS2212B", "1264", "Final", 55.00); // system not on

		calFinal.calculateFinal(phonyInst, "CS2212B", "1264"); // not instructor
		calFinal.calculateFinal(inst, "DankMemes101", "1264"); // not course
		calFinal.calculateFinal(phonyInst2, "CS2212B", "1726"); //not registered instructor
		calFinal.calculateFinal(inst, "CS2212B", "1264"); // good
		//calFinal.calculateFinal(inst, "CS2212B", "1264"); // system not on


		prntRec.printClassRecord(phonyInst, "CS2212B"); // not instructor
		prntRec.printClassRecord(inst, "DankMemes101"); //not correct course
		prntRec.printClassRecord(phonyInst2, "CS2212B"); //not instructor in course
		prntRec.printClassRecord(inst, "CS2212B"); //good
		//prntRec.printClassRecord(inst, "CS2212B"); // system not on


		//Test stop server operation
		System.out.println("Stop System Test..");
		try {
			StopSystem stopSystem = new StopSystem();
			if (SystemStatus.getInstance().systemRunning() == true) {

				stopSystem.stopSystem(user);
				if (SystemStatus.getInstance().systemRunning() == false) {
					System.out.println("Stop Test Successful!\n");
				}
			}
			else {
				System.out.println("User not Admin");
				System.out.println("Stop Test Failed\n");
			}
		} catch (Exception e) {
			System.out.println("Stop Test Failed\n");
		}
	}

}
