package operations;

import authenticatedUsers.LoggedInAuthenticatedUser;
import customDatatypes.NotificationTypes;
import offerings.CourseOffering;
import registrar.ModelRegister;
import systemUsers.InstructorModel;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by darrenpankoff on 7/4/2018.
 */
public class CalculateFinal implements IOperations {
    @Override
    public LoggedInAuthenticatedUser login() throws FileNotFoundException, IOException {
        return null;
    }

    @Override
    public void startSystem(LoggedInAuthenticatedUser user) {

    }

    @Override
    public void stopSystem(LoggedInAuthenticatedUser user) {

    }

    @Override
    public void readCourseFile(LoggedInAuthenticatedUser user, String file) throws IOException {

    }

    @Override
    public void addMark(LoggedInAuthenticatedUser user, String courseID, String studentID, String eval, double mark) {

    }

    @Override
    public void modifyMark(LoggedInAuthenticatedUser user, String courseID, String studentID, String eval, double mark) {

    }

    @Override
    public void calculateFinal(LoggedInAuthenticatedUser user, String courseID, String studentID) {
        if (SystemStatus.getInstance().systemRunning()) {
            if (user.getAuthenticationToken().getUserType().equals("Instructor")) {
                InstructorModel inst = (InstructorModel) ModelRegister.getInstance().getRegisteredUser(user.getID());
                if(!ModelRegister.getInstance().checkIfCourseHasAlreadyBeenCreated(courseID)){
                    System.out.println("Invalid courseID: This course does not exist within the system");
                    return;
                }
                CourseOffering course = ModelRegister.getInstance().getRegisteredCourse(courseID);
                if (!course.getInstructor().contains(inst)) {
                    System.out.println("Mark not updated: You must be a registered instructor for this course to calculate final marks ");
                    return;
                }

                course.calculateFinalGrade(studentID);

            } else {
                System.out.println("Sorry, you must be an Instructor to perform this operation 'CalculateFinal'");
            }
        }
            System.out.println("Unable to perform operation CalculateFinalGrade - System not running: Contact SystemAdmin");

    }

    @Override
    public void printClassRecord(LoggedInAuthenticatedUser user, String classID) {

    }

    @Override
    public void enroll(LoggedInAuthenticatedUser user, String classID) {

    }

    @Override
    public void notificationStatus(LoggedInAuthenticatedUser user, NotificationTypes notificationType) {

    }

    @Override
    public void addNotificationPref(LoggedInAuthenticatedUser user, NotificationTypes notificationType) {

    }
    @Override
    public void printStudentRecord(LoggedInAuthenticatedUser user, String ID){

    }
}
