package edu.northeastern;

import java.util.HashSet;
import java.util.Set;

public class Course {
    private int courseID;
    private String courseName;
    private int maxCapacity;
    private int professorId;
    private int credits;
    private int[] studentIds;

    public Course(int courseID) {
        checkCourseID(courseID);
    }

    public Course(int courseID, int professorId) {
        setCourseID(courseID);
        setProfessorId(professorId);
    }

    public Course(int courseID, int professorId, int credits) {
        setCourseID(courseID);
        setProfessorId(professorId);
        setCredits(credits);
    }

    private void checkCourseID(int courseID) {
        if (courseID > 0) {
            this.courseID = courseID;
        } else {
            throw new IllegalArgumentException("Not a valid course ID. Course ID cannot be 0 or less than 0.");
        }
    }

    //getter for courseID
    public int getCourseID() {
        return courseID;
    }

    //setter for courseID
    public void setCourseID(int courseID) {
        checkCourseID(courseID);
    }

    //getter for courseName
    public String getCourseName() {
        return courseName;
    }

    //setter for courseName
    public void setCourseName(String courseName) {
        if (courseName.length() >= 10 && courseName.length() <= 60) {
            this.courseName = courseName;
        } else {
            throw new IllegalArgumentException("Not a valid course name. Course name should be within minimum length 10 and maximum 60.");
        }
    }

    //getter for maxCapacity
    public int getMaxCapacity() {
        return maxCapacity;
    }

    //setter for maxCapacity
    public void setMaxCapacity(int maxCapacity) {
        // 10 <= maxCapacity <= 100
        if (maxCapacity >= 10 && maxCapacity <= 100) {
            this.maxCapacity = maxCapacity;
        } else {
//            System.out.println("Not a valid maximum capacity. Maximum capacity should not be less than 10 greater than 100");
            throw new IllegalArgumentException("Not a valid maximum capacity. Maximum capacity should not be less than 10 and greater than 100");
        }
    }

    //getter for professorId
    public int getProfessorId() {
        return professorId;
    }

    //setter for professorId
    public void setProfessorId(int professorId) {
        if (countDigits(professorId) == 6) {
            this.professorId = professorId;
        } else {
            throw new IllegalArgumentException("Not a valid professor ID. Professor Id should have 6 digits.");
        }
    }

    //Count the digits in number
    private int countDigits(int number) {
        int count = 0;
        while (number != 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    //getter for credits
    public int getCredits() {
        return credits;
    }

    //setter for credits
    public void setCredits(int credits) {
        if (credits > 0 && credits < 10) {
            this.credits = credits;
        } else {
            throw new IllegalArgumentException("Not a valid credit. Credits should be single digit and greater than 0.");
        }
    }

    //getter for studentIds
    public int[] getStudentIds() {
        return studentIds;
    }

    //setter for studentIds
    public void setStudentIds(int[] studentIds) {
        this.studentIds = studentIds;
    }

    /**
     * registerStudent method should store all ids in studentIds array.
     *
     * @param studentId
     */
    public void registerStudent(int studentId) throws IllegalStateException {
        //If maxCapacity is set and studentIds instantiated
        if (studentIds != null) {
            if (studentsArraySize() >= maxCapacity) {
                //Invoke removeDuplicates() to remove the duplicate Ids in studentIds[]
                removeDuplicates(this.studentIds);
            }
            if (studentsArraySize() >= maxCapacity) {
                //There were no duplicates to be removed
                throw new RuntimeException("Student cannot be added because the course max capacity has already " +
                        "reached.");
            }
            //Adds the new studentId to studentIds[]
            addStudent(studentId);
        } else {
            //studentIds[] is instantiated if maxCapacity is set. Else throw exception
            if (maxCapacity != 0) {
                this.studentIds = new int[this.maxCapacity];
                addStudent(studentId);
            } else {
                throw new IllegalStateException("MaxCapacity not set");
            }
        }
    }

    //Find the actual number of student ids present in studentIds[]
    private int studentsArraySize() {
        int i;
        for (i = 0; i < studentIds.length; i++) {
            if (studentIds[i] == 0) {
                return i;
            }
        }
        return i;
    }

    //Adds new studentId to studentIds[
    private void addStudent(int studentId) {
        for (int i = 0; i < studentIds.length; i++) {
            if (studentIds[i] == 0) {
                studentIds[i] = studentId;
                return;
            }
        }
    }

    /**
     * Add a function called removeDuplicates in Course class
     * This function should be called if course has reached the maximum capacity and remove all duplicate student Ids
     * and return the new ids
     * Ex: Input :[1,6,2,3,2,4,5,6]
     * Output: [1,6,2,3,4,5]
     *
     * @param studentIds
     * @return
     */
    //Do we need studentIds as parameter? Shouldn't we directly access the class property?
    //Taking in studentIds as parameter as per the method stub provided in the assignment
    private int[] removeDuplicates(int[] studentIds) {
        int index = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < studentIds.length; i++) {
            //Add each student id to set if not already present
            //Index is a pointer used to track the emptied array index space to ease the shift-left operation without
            //an additional loop
            //If id already present in the set, that means the id now encountered is a duplicate. Overwrite it with the
            //next unique value
            if (!set.contains(studentIds[i])) {
                set.add(studentIds[i]);
                studentIds[index] = studentIds[i];
                index++;
            }
        }
        for (int i = index; i < studentIds.length; i++) {
            studentIds[i] = 0;
        }
        return studentIds;
    }

    /**
     * this method takes an array of studentIds as an argument. Find number of pairs of studentsIds whose sum is even
     * Example:
     * Input : [1,2,3,4,5,6]
     * Output : 6
     * Explanation: (1 + 3), (1 + 5), (3 + 5), (2 + 4), (2 + 6), (4 + 6)
     *
     * @param studentIds
     * @return
     */
    public int groupsOfStudents(int[] studentIds) {
        int count = 0;
        for (int i = 0; i < studentIds.length; i++) {
            for (int j = i + 1; j < studentIds.length; j++) {
                if (studentIds[i] != 0 && studentIds[j] != 0) {
                    if ((studentIds[i] + studentIds[j]) % 2 == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }


}
