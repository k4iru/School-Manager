package operations;

import authenticatedUsers.LoggedInAuthenticatedUser;
import customDatatypes.NotificationTypes;
import offerings.CourseOffering;
import registrar.ModelRegister;
import systemUsers.InstructorModel;
import systemUsers.StudentModel;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by darrenpankoff on 7/4/2018.
 */
public class PrintClassRecord implements IOperations {

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
    public void addMark(LoggedInAuthenticatedUser user,String courseID, String studentID, String eval, double mark) {

    }

    @Override
    public void modifyMark(LoggedInAuthenticatedUser user, String courseID, String studentID, String eval, double mark) {

    }

    @Override
    public void calculateFinal(LoggedInAuthenticatedUser user, String courseID, String student) {

    }

    @Override
    public void printClassRecord(LoggedInAuthenticatedUser user, String classID) {
        if (SystemStatus.getInstance().systemRunning()) {
            if (user.getAuthenticationToken().getUserType().equals("Instructor")) {
                InstructorModel inst = (InstructorModel) ModelRegister.getInstance().getRegisteredUser(user.getID());
                if(!ModelRegister.getInstance().checkIfCourseHasAlreadyBeenCreated(classID)){
                    System.out.println("Invalid courseID: This course does not exist within the system");
                    return;
                }
                CourseOffering course = ModelRegister.getInstance().getRegisteredCourse(classID);
                if(!course.getInstructor().contains(inst)){
                    System.out.println("Mark not updated: You must be a registered instructor for this course to print class record ");
                    return;
                }
                System.out.print("Course Name: " + course.getCourseName() + "\t" + "Course ID: " + classID + "\t" + " Semester: " + course.getSemester() + "\n" );
                System.out.println("INSTRUCTORS");
                for (InstructorModel instructorModel: course.getInstructor()){
                    System.out.print(instructorModel.getName() + "\n");
                }
                System.out.println("STUDENTS");
                for(StudentModel studentModel: course.getStudentsEnrolled()){
                    System.out.print(studentModel.getName() + "\n");
                }



            } else {
                System.out.println("Sorry, you must be an Instructor to perform this operation 'PrintClassRecord'");
            }


        }else{
            System.out.println("Unable to perform operation PrintClassRecord - System not running: Contact SystemAdmin");
        }

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
