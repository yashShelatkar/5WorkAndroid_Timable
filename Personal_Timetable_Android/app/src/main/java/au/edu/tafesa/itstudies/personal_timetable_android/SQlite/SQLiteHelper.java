package au.edu.tafesa.itstudies.personal_timetable_android.SQlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;
import android.util.Log;

public class SQLiteHelper extends SQLiteOpenHelper {

    public static final String CLASS_TAG = "SQLiteHelper";
    public static final String passowrd = "5work";
    public SQLiteDatabase database = null;

    public SQLiteHelper(Context context)
    {
        super(context, "Timetable.db", null,1);
    }

    public void onCreate(SQLiteDatabase database)
    {
        //create table
        database.execSQL("CREATE TABLE IF NOT EXISTS Student (\n" +
                "  studentID INT NOT NULL,\n" +
                "  studentName VARCHAR(45) ,\n" +
                "  loginPassword VARCHAR(45) ,\n" +
                "  PRIMARY KEY (studentID))");

//        database.execSQL("CREATE TABLE IF NOT EXISTS Lecture (\n" +
//                "  lectureID INT NOT NULL,\n" +
//                "  lectureName VARCHAR(45),\n" +
//                "  PRIMARY KEY (lectureID))");
//
//        database.execSQL("CREATE TABLE IF NOT EXISTS Course (\n" +
//                "  courseID INT NOT NULL,\n" +
//                "  courseName VARCHAR(45),\n" +
//                "  courseCode VARCHAR(45),\n" +
//                "  startDate DATETIME,\n" +
//                "  endDate DATETIME,\n" +
//                "  startTime DATETIME,\n" +
//                "  endTime DATETIME,\n" +
//                "  room VARCHAR(5),\n" +
//                "  Lecture_lectureID INT NOT NULL,\n" +
//                "  PRIMARY KEY (courseID),\n" +
//                "  CONSTRAINT fk_Course_Lecture1\n" +
//                "    FOREIGN KEY (Lecture_lectureID)\n" +
//                "    REFERENCES Lecture (lectureID)\n" +
//                "    ON DELETE NO ACTION\n" +
//                "    ON UPDATE NO ACTION)");
//
//        database.execSQL("CREATE TABLE IF NOT EXISTS Assignment (\n" +
//                "  assignmentID INT NOT NULL,\n" +
//                "  name VARCHAR(45),\n" +
//                "  dueDate DATETIME,\n" +
//                "  Course_courseID INT NOT NULL,\n" +
//                "  PRIMARY KEY (assignmentID, Course_courseID),\n" +
//                "  CONSTRAINT fk_Assignment_Course1\n" +
//                "    FOREIGN KEY (Course_courseID)\n" +
//                "    REFERENCES Course (courseID)\n" +
//                "    ON DELETE NO ACTION\n" +
//                "    ON UPDATE NO ACTION)");
//
//        database.execSQL("CREATE TABLE IF NOT EXISTS Test (\n" +
//                "  testID INT NOT NULL,\n" +
//                "  testName VARCHAR(45) ,\n" +
//                "  testDate DATETIME ,\n" +
//                "  Course_courseID INT NOT NULL,\n" +
//                "  PRIMARY KEY (testID, Course_courseID),\n" +
//                "  CONSTRAINT fk_Test_Course\n" +
//                "    FOREIGN KEY (Course_courseID)\n" +
//                "    REFERENCES Course (courseID)\n" +
//                "    ON DELETE NO ACTION\n" +
//                "    ON UPDATE NO ACTION)");
//
//        database.execSQL("CREATE TABLE IF NOT EXISTS Campus (\n" +
//                "  CampusID INT NOT NULL,\n" +
//                "  campusName VARCHAR(45) ,\n" +
//                "  campusCode VARCHAR(5),\n" +
//                "  address VARCHAR(45) ,\n" +
//                "  PRIMARY KEY (CampusID))");
//
//        database.execSQL("CREATE TABLE IF NOT EXISTS Session (\n" +
//                "  sessionID INT NOT NULL,\n" +
//                "  subject VARCHAR(45) ,\n" +
//                "  topic VARCHAR(45) ,\n" +
//                "  sessioncNO VARCHAR(45) ,\n" +
//                "  sessionDate VARCHAR(45) ,\n" +
//                "  Course_courseID INT NOT NULL,\n" +
//                "  PRIMARY KEY (sessionID, Course_courseID),\n" +
//                "  CONSTRAINT fk_Session_Course1\n" +
//                "    FOREIGN KEY (Course_courseID)\n" +
//                "    REFERENCES Course (courseID)\n" +
//                "    ON DELETE NO ACTION\n" +
//                "    ON UPDATE NO ACTION)");
//
//        database.execSQL("CREATE TABLE IF NOT EXISTS Campus_has_Course (\n" +
//                "  Campus_CampusID INT NOT NULL,\n" +
//                "  Course_courseID INT NOT NULL,\n" +
//                "  PRIMARY KEY (Campus_CampusID, Course_courseID),\n" +
//                "  CONSTRAINT fk_Campus_has_Course_Campus1\n" +
//                "    FOREIGN KEY (Campus_CampusID)\n" +
//                "    REFERENCES Campus (CampusID)\n" +
//                "    ON DELETE NO ACTION\n" +
//                "    ON UPDATE NO ACTION,\n" +
//                "  CONSTRAINT fk_Campus_has_Course_Course1\n" +
//                "    FOREIGN KEY (Course_courseID)\n" +
//                "    REFERENCES Course (courseID)\n" +
//                "    ON DELETE NO ACTION\n" +
//                "    ON UPDATE NO ACTION)");
//
//        database.execSQL("CREATE TABLE IF NOT EXISTS Course_has_Student (\n" +
//                "  Course_courseID INT NOT NULL,\n" +
//                "  Student_studentID INT NOT NULL,\n" +
//                "  PRIMARY KEY (Course_courseID, Student_studentID),\n" +
//                "  CONSTRAINT fk_Course_has_Student_Course1\n" +
//                "    FOREIGN KEY (Course_courseID)\n" +
//                "    REFERENCES Course (courseID)\n" +
//                "    ON DELETE NO ACTION\n" +
//                "    ON UPDATE NO ACTION,\n" +
//                "  CONSTRAINT fk_Course_has_Student_Student1\n" +
//                "    FOREIGN KEY (Student_studentID)\n" +
//                "    REFERENCES Student (studentID)\n" +
//                "    ON DELETE NO ACTION\n" +
//                "    ON UPDATE NO ACTION)");
//
//        //create index
//        database.execSQL("CREATE INDEX fk_Course_Lecture1_idx on Course(Lecture_lectureID)");
//
//        database.execSQL("CREATE INDEX fk_Assignment_Course1_idx on Assignment(Course_courseID)");
//
//        database.execSQL("CREATE INDEX fk_Test_Course_idx on Test(Course_courseID)");
//
//        database.execSQL("CREATE INDEX fk_Session_Course1_idx on Session(Course_courseID)");
//
//        database.execSQL("CREATE INDEX fk_Campus_has_Course_Course1_idx on Campus_has_Course(Course_courseID)");
//        database.execSQL("CREATE INDEX fk_Campus_has_Course_Campus1_idx on Campus_has_Course(Campus_CampusID)");
//
//        database.execSQL("CREATE INDEX fk_Course_has_Student_Student1_idx on Test(Student_studentID)");
//        database.execSQL("CREATE INDEX fk_Course_has_Student_Course1_idx on Course_has_Student(Course_courseID)");


         //insert
        database.execSQL("INSERT INTO student values(103500,'Eric','5work')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Student");
        onCreate(db);
    }

    public void onInsert(SQLiteDatabase db)
    {
        db.execSQL("INSERT INTO student values (103500, 'Eric Cheng','5work')");
    }

    public int getStudentID( int id) {

        onCreate(database);
        String table = "Student";
        String[] columns = {"studentID"};
        String selection = " 'studentID' =?";
        String[] selectionArgs = {String.valueOf(id)};
        String groupBy = null;
        String having = null;
        String orderBy = null;
        String limit = null;
        Cursor c = this.database.query(table,columns,selection,selectionArgs,groupBy,having,orderBy,limit);

        if(c!= null)
        {
            return id;
        }
        else
        {
            return 0;
        }

    }

}
