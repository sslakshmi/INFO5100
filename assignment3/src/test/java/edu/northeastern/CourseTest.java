package edu.northeastern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class CourseTest {
    @Test
    void CourseIdTest() {
        //Invalid scenario
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Course(0);
        });
        Assertions.assertTrue(exception.getMessage().contains("Not a valid course ID"));
        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Course(-1);
        });
        Assertions.assertTrue(exception.getMessage().contains("Not a valid course ID"));

        //Valid scenario
        Course withValidCourseId = new Course(1);
        Assertions.assertEquals(1, withValidCourseId.getCourseID());
    }

    @Test
    void invalidMaxCapacityTest() {
        Course course = new Course(1);
        //Invalid scenario
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            course.setMaxCapacity(1);
        });
        Assertions.assertTrue(exception.getMessage().contains("Not a valid maximum capacity"));

        //Valid scenario
        course.setMaxCapacity(12);
        Assertions.assertEquals(12, course.getMaxCapacity());
    }

    @Test
    void invalidProfessorIdTest() {
        //Invalid scenario
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Course(1, 12345);
        });
        Assertions.assertTrue(exception.getMessage().contains("Not a valid professor ID"));

        //Valid scenario
        Course course = new Course(1, 123456);
        Assertions.assertEquals(123456, course.getProfessorId());
    }

    @Test
    void invalidCourseNameTest() {
        Course course = new Course(1);
        //Invalid scenario
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            course.setCourseName("INFO5100");
        });
        Assertions.assertTrue(exception.getMessage().contains("Not a valid course name"));

        //Valid scenario
        String courseName = "Application Engineering and Development";
        course.setCourseName(courseName);
        Assertions.assertEquals(courseName, course.getCourseName());
    }

    @Test
    void invalidCreditsTest() {
        //Invalid scenario
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Course(1, 123456, -1);
        });
        Assertions.assertTrue(exception.getMessage().contains("Not a valid credit"));

        //valid scenario
        Course course = new Course(1, 123456, 1);
        Assertions.assertEquals(1, course.getCredits());
    }

    @Test
    void removeDuplicatesTest() {
        Course course = new Course(1);
        course.setMaxCapacity(11);
        course.registerStudent(1);
        course.registerStudent(2);
        course.registerStudent(1);
        course.registerStudent(3);
        course.registerStudent(4);
        course.registerStudent(5);
        course.registerStudent(6);
        course.registerStudent(7);
        course.registerStudent(4);
        course.registerStudent(5);
        course.registerStudent(8);

        //Reached maxCapacity. Initiate removeDuplicate()
        course.registerStudent(11);
        System.out.println(Arrays.toString(course.getStudentIds()));
        Assertions.assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 11, 0, 0]",Arrays.toString(course.getStudentIds()));

        course.registerStudent(12);
        course.registerStudent(13);
        //Invalid scenario
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            course.registerStudent(14);
        });
        Assertions.assertTrue(exception.getMessage().contains("Student cannot be added"));
    }

    @Test
    void groupsOfStudentsTest() {
        Course course = new Course(1);
        course.setMaxCapacity(11);
        course.registerStudent(1);
        course.registerStudent(2);
        course.registerStudent(3);
        course.registerStudent(4);
        course.registerStudent(5);
        course.registerStudent(6);
        System.out.println(course.groupsOfStudents(course.getStudentIds()));
        Assertions.assertEquals(6, course.groupsOfStudents(course.getStudentIds()));
    }
}