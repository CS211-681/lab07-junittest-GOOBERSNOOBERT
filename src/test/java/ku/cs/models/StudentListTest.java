package ku.cs.models;

import ku.cs.services.Datasource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ku.cs.services.StudentListFileDatasource;

class StudentListTest {

    Datasource<StudentList> datasource;
    StudentList sList;

    @BeforeEach
    void initiate(){
        datasource = new StudentListFileDatasource("data", "student-list.csv");
        sList = new StudentList();
        sList =  datasource.readData();
    }

    @Test
    @DisplayName("ทดสอบการ filter")
    void testFilerByName(){
    StudentList foundList = sList.filterByName("John McCarthy");
    Student found = foundList.findStudentById("6410450004");
    assertEquals("John McCarthy", found.getName());
    }

    @Test
    @DisplayName("ทดสอบการหาด้วย id")
    void testFindStudentById(){
        Student found = sList.findStudentById("6410450003");
        assertEquals("Alan Turing", found.getName());
    }

    @Test
    @DisplayName("ทดสอบการให้คะแนน")
    void testGiveScoreToId(){
        sList.giveScoreToId("6410450002", 20.5);
        assertEquals(81.2, sList.findStudentById("6410450002").getScore());
    }

    @Test
    @DisplayName("ทดสอบการคำนวนเกรด")
    void testViewGradeOfId(){
        assertEquals("A", sList.viewGradeOfId("6410450001"));
    }

    @Test
    @DisplayName("ทดสอบการเพิ่ม student")
    void testAddStudent(){
        sList.addNewStudent("6410450006","saddam hussein", 69 );
        ...
    }

}
