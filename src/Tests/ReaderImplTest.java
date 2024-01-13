import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class ReaderImplTest {

    @Test
    public void testReadUsers(){
        ReaderImpl r = new ReaderImpl();

        String[][] users = r.readUsers();

        Assertions.assertEquals(users[0][0] , "1");
        Assertions.assertEquals(users[0][1] , "Ensev");
        Assertions.assertEquals(users[0][2] , "Miraka");
        Assertions.assertEquals(users[0][3] , "ensev.miraka@fti.edu.al");
        Assertions.assertEquals(users[0][4] , "test1");

        Assertions.assertEquals(users[1][0] , "2");
        Assertions.assertEquals(users[1][1] , "Xheni");
    }

    @Test
    public void testReadCourses(){
        ReaderImpl r = new ReaderImpl();

        String[][] courses = r.readCourses();

        Assertions.assertEquals(courses[0][0] , "1");
        Assertions.assertEquals(courses[0][1] , "Elemente Elektronike");
        Assertions.assertEquals(courses[0][2] , "Kjo lende ka te beje me qarqe te ndryshme elektronike, dhe bazat mbi elektroniken. // Pedagogu: Prof. Dr. Enxhi Muhaj // Salla: 302 // Ora: 14:30.");

        Assertions.assertEquals(courses[1][0] , "2");
        Assertions.assertEquals(courses[1][1] , "Elementet e Informatikes");
    }

    @Test
    public void testReadFeedbacks(){
        ReaderImpl r = new ReaderImpl();

        String[][] feedbacks = r.readFeedbacks();

        Assertions.assertEquals(feedbacks[0][0] , "1");
        Assertions.assertEquals(feedbacks[0][1] , "Nje lende jashtezakonisht e bukur dhe interesante. Nuk eshte nje lende e veshtire dhe merr shume informacione te reja!");
        Assertions.assertEquals(feedbacks[0][2] , "2");

        Assertions.assertEquals(feedbacks[1][0] , "2");
        Assertions.assertEquals(feedbacks[1][1] , "Ja vlen te ndjekesh si kurs! Jashtezakonisht i bukur.");
    }

    @Test
    public void testReadCourseNames() throws SQLException {
        ReaderImpl r = new ReaderImpl();

        String[] courseNames = r.readCourseNames();

        Assertions.assertEquals(courseNames[0], "Elemente Elektronike");
        Assertions.assertEquals(courseNames[1], "Elementet e Informatikes");
        Assertions.assertEquals(courseNames[9], "Algoritmike");
    }

    @Test
    public void testReadCourseDescription() throws SQLException {
        ReaderImpl r = new ReaderImpl();

        String descriptionOfCourse1 = r.readCourseDescription("Elemente Elektronike");
        String descriptionOfCourse2 = r.readCourseDescription("Elementet e Informatikes");
        String descriptionOfCourse10 = r.readCourseDescription("Algoritmike");

        Assertions.assertEquals(descriptionOfCourse1, "Kjo lende ka te beje me qarqe te ndryshme elektronike, dhe bazat mbi elektroniken. // Pedagogu: Prof. Dr. Enxhi Muhaj // Salla: 302 // Ora: 14:30.");
        Assertions.assertEquals(descriptionOfCourse2, "Kjo lende ka te beje me njohurite baze mbi informatiken. Nje hyrje mbi algoritmat dhe bllokskemat. // Pedagogu: Prof. Dr. Enxhi Muhaj // Salla: 302 // Ora: 14:30.");
        Assertions.assertEquals(descriptionOfCourse10, "Kjo lende ka te beje me studimin e algoritmeve, strukturave te ndryshme te te dhenave dhe kompleksiteteve te tyre. // Pedagogu: Prof. Dr. Enxhi Muhaj // Salla: 302 // Ora: 14:30.");
    }

    @Test
    public void testReadCourseID() throws SQLException {
        ReaderImpl r = new ReaderImpl();

        int courseID1 = r.readCourseID("Elemente Elektronike");
        int courseID2 = r.readCourseID("Elementet e Informatikes");
        int courseID10 = r.readCourseID("Algoritmike");

        Assertions.assertEquals(courseID1, 1);
        Assertions.assertEquals(courseID2, 2);
        Assertions.assertEquals(courseID10, 10);
    }

    @Test
    public void testReadFeedbacksForCourse() throws SQLException {
        ReaderImpl r = new ReaderImpl();

        String[][] feedbacks = r.readFeedbacksForCourse(2);

        Assertions.assertEquals(feedbacks[0][0], "Nje lende jashtezakonisht e bukur dhe interesante. Nuk eshte nje lende e veshtire dhe merr shume informacione te reja!");
        Assertions.assertEquals(feedbacks[0][1], "5");
        Assertions.assertEquals(feedbacks[1][0], "Ja vlen te ndjekesh si kurs! Jashtezakonisht i bukur.");
        Assertions.assertEquals(feedbacks[1][1], "5");
    }

    @Test
    public void testReadCourseIDS() throws SQLException {
        ReaderImpl r = new ReaderImpl();

        int[] courseIDS = r.readCourseIDS(1);

        Assertions.assertEquals(courseIDS[0], 4);
        Assertions.assertEquals(courseIDS[1], 6);
        Assertions.assertEquals(courseIDS[5], 7);
    }


    @Test
    public void testHasLeftFeedbackForCourse() throws SQLException {
        ReaderImpl r = new ReaderImpl();

        boolean userOneHasLeftFeedback = r.hasLeftFeedbackForCourse(1,2);
        boolean userOneHasNotLeftFeedback = r.hasLeftFeedbackForCourse(1, 4);

        Assertions.assertTrue(userOneHasLeftFeedback);
        Assertions.assertFalse(userOneHasNotLeftFeedback);
    }

    @Test
    public void testAverageRatingOfCourse() throws SQLException {
        ReaderImpl r = new ReaderImpl();

        int averageOne = r.averageRatingOfCourse(1);
        int averageTwo = r.averageRatingOfCourse(2);

        Assertions.assertEquals(averageOne,4);
        Assertions.assertEquals(averageTwo,5);
    }

    @Test
    public void testCourseNameById() throws SQLException {
        ReaderImpl r = new ReaderImpl();

        String courseOne = r.courseNameById(1);
        String courseTwo = r.courseNameById(10);

        Assertions.assertEquals(courseOne,"Elemente Elektronike");
        Assertions.assertEquals(courseTwo,"Algoritmike");
    }


}