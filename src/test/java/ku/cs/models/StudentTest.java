package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student s;

    @BeforeEach
    void setup(){
        s = new Student("6xxxxxxxx", "StudentTest");
    }

    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อ")
    void testChangeName(){
        s.changeName("  TEST NAME  ");
        assertEquals("TEST NAME", s.getName());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45.15 คะแนน")
    void testAddScore(){
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());

    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGrade(){
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการเช็ค id")
    void testIdCompare(){
        assertTrue(s.isId("6xxxxxxxx"));
    }

    @Test
    @DisplayName("ทดสอบ isNameContains")
    void testIsNameContains(){
        s.changeName("TEST NAME");
        assertTrue(s.isNameContains("TEST NAME"));
    }

}