package operations;

import authenticatedUsers.LoggedInAuthenticatedUser;
import customDatatypes.Marks;
import customDatatypes.NotificationTypes;

import java.io.FileNotFoundException;
import java.io.IOException;

import offerings.*;
import registrar.ModelRegister;
import systemUsers.InstructorModel;
import systemUsers.StudentModel;

/**
 * Created by darrenpankoff on 7/4/2018.
 */
public class AddMark implements IOperations {
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


        if (SystemStatus.getInstance().systemRunning()) {
            if (user.getAuthenticationToken().getUserType().equals("Instructor")) {

                if(ModelRegister.getInstance().getRegisteredUser(user.getID()) == null){
                    System.out.println("Mark not updated: You must be a registered instructor");

                    return;

                }
                InstructorModel inst = (InstructorModel)ModelRegister.getInstance().getRegisteredUser(user.getID());

                if(!ModelRegister.getInstance().checkIfCourseHasAlreadyBeenCreated(courseID)){
                    System.out.println("Invalid courseID: This course does not exist within the system");
                    return;
                }
                CourseOffering course = ModelRegister.getInstance().getRegisteredCourse(courseID);

                if(!course.getInstructor().contains(inst)){
                    System.out.println("Mark not added: You must be a registered instructor for this course to add marks ");
                    return;
                }
                StudentModel student = (StudentModel) ModelRegister.getInstance().getRegisteredUser(studentID);
                if(!course.getStudentsEnrolled().contains(student)){
                    System.out.println("Mark not added: Student not found in class");
                    return;
                }
                Marks marks = student.getPerCourseMarks().get(course);
                marks.addToEvalStrategy(eval, mark);
                System.out.println("Mark for " + courseID + " successfully added");
                System.out.println("This change is confirmed via " + student.getNotificationType());
            }else{
                System.out.println("Sorry, you must be an Instructor to perform this operation 'AddMark'");
                return;
            }


        }System.out.println("Unable to perform operation AddMark - System not running: Contact SystemAdmin");
    }


    @Override
    public void modifyMark(LoggedInAuthenticatedUser user, String courseID, String studentID, String eval, double mark) {

    }

    @Override
    public void calculateFinal(LoggedInAuthenticatedUser user, String courseID, String student){
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
