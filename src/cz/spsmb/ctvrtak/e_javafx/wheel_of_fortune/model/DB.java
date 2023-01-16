package cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DB {
    private static String url = "jdbc:sqlite:Y:\\stemberk\\verejne_zaci\\wofa.db";
    //private static String url = "jdbc:sqlite:wofa.db";
    private static Connection conn = null;
    static{
        String sql = "CREATE TABLE IF NOT EXISTS S_Student " +
                "(S_Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " S_FirstName VARCHAR(25) NOT NULL," +
                " S_LastName VARCHAR(25) NOT NULL);" +
                " CREATE TABLE IF NOT EXISTS M_Marking " +
                "(M_Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " M_S_Id INTEGER NOT NULL," +
                " M_GT_Id INTEGER NOT NULL," +
                " M_Mark DECIMAL(2,1) NOT NULL," +
                " M_Date DATE NOT NULL," +
                " M_Weight DECIMAL(3,2) NOT NULL);" +
                "CREATE TABLE IF NOT EXISTS GT_GraduateTopic " +
                "(GT_Id INTEGER PRIMARY KEY," +
                " GT_Topic VARCHAR(25) NOT NULL," +
                " GT_Description VARCHAR(1024)," +
                " GT_Difficulty DECIMAL(3,2));";
        // vytvoření tabulky ((C)RUD - Create)
        Statement stmt = null;
        try {
            cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune.model.DB.conn = DriverManager.getConnection(cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune.model.DB.url);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.format("Problém s připojením do db %s:%s", cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune.model.DB.url, e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void fillStudents() throws SQLException {
        int N = 15;
        for(int i=0; i<N; i++) {
            PreparedStatement pstmt = cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune.model.DB.conn.prepareStatement(
                    "INSERT INTO S_Student (S_FirstName, S_LastName) VALUES (?, ?)");
            pstmt.setString(1, String.format("A%02d", i));
            pstmt.setString(2, String.format("B%02d", i));
            pstmt.executeUpdate();
        }
    }

    public static void fillBStudents() throws SQLException {
        String sql =
                "INSERT INTO S_Student (S_FirstName, S_LastName) VALUES ('Lukáš', 'Haken')," +
                        "('Vojtěch', 'Černý')," +
                        "('Michal', 'Kraušner')," +
                        "('Ondřej', 'Merhaut')," +
                        "('Ondřej', 'Žárský')," +
                        "('Jakub', 'Chomanič')," +
                        "('Robin', 'Krouský')," +
                        "('Michal', 'Skalický')," +
                        "('Vojtěch', 'Zajíček')," +
                        "('Pavel', 'Šípek')," +
                        "('Tadeáš', 'Karban')," +
                        "('Ondřej', 'Janošík')," +
                        "('Zdenek', 'Stanke')," +
                        "('Pavel', 'Štemberk')," +
                        "('Josef', 'Matoušek');";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);

    }

    public static void fillBStudentsOfEvil() throws SQLException {
        String sql =
                "INSERT INTO S_Student (S_FirstName, S_LastName) VALUES " +
                        "('Vít', 'Štemberk'),"+
                        "('Ondřej', 'Merhaut');";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);

    }
    public static void fillAStudentsOfEvil() throws SQLException {
        String sql =
                "INSERT INTO S_Student (S_FirstName, S_LastName) VALUES " +
                        "('Lukáš', 'Škrabánek'),"+
                        "('Adam', 'Novák');";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);

    }
    public static void fillAStudents() throws SQLException {
        String sql =
                "INSERT INTO S_Student (S_FirstName, S_LastName) VALUES ('Martin', 'Hojný')," +
                        "('Jan', 'Vítek')," +
                        "('Štěpán', 'Novák')," +
                        "('Lukáš', 'Škrabánek')," +
                        "('Adam', 'Novák')," +
                        "('Vojtěch', 'Odstrčil')," +
                        "('Marek', 'Fiala')," +
                        "('Daniel', 'Bílek')," +
                        "('Jiří', 'Jiránek')," +
                        "('Tomáš', 'Kargl')," +
                        "('Tadeáš', 'Tondl')," +
                        "('Honza', 'Hofman')," +
                        "('Matěj', 'Zralý');";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }
    public static void fillTopics() throws SQLException {
        String sql =
                "INSERT INTO GT_GraduateTopic (GT_Id, GT_Topic) VALUES ('1','Algoritmizace a programování')," +
                        "('2','Vývojové prostředí a obecná znalost')," +
                        "('3', 'Rozdíly mezi Javou a JavaScriptem')," +
                        "('4', 'Proměnné a paměťové oblasti')," +
                        "('5', 'Operátory')," +
                        "('6', 'Podmíněné větvení')," +
                        "('7', 'Cykly')," +
                        "('8', 'Pole')," +
                        "('9', 'OOP')," +
                        "('10', 'Interface a anotace')," +
                        "('11', 'Enum')," +
                        "('12', 'Návrhové vzory')," +
                        "('13', 'Datum a čas')," +
                        "('14', 'Práce se soubory')," +
                        "('15', 'Kolekce'),"+
                        "('16', 'Výjimky a ladění'),"+
                        "('17', 'Komentáře, konvence'),"+
                        "('18', 'JavaFX'),"+
                        "('19', 'Vstupy'),"+
                        "('20', 'Práce s grafikou'),"+
                        "('21', 'Animace'),"+
                        "('22', 'Práce s databází'),"+
                        "('23', 'Základy 2D her'),"+
                        "('24', 'Build systémy'),"+
                        "('25', 'Vlákna');";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);

    }
    public static Map<Integer, String> getAllStudents() throws SQLException {
        HashMap<Integer, String> students = new HashMap<>();
        Statement stmt = DB.conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM S_Student;");

        //String format = "%3s|%20s\n";
        //System.out.format(format, "id", "name");
        while(rs.next()){
            students.put(rs.getInt("S_Id"),
                    String.format("%s %s",rs.getString("S_FirstName"),
                            rs.getString("S_LastName")));
        }
        return students;
    }

    public static Map<Integer, String> getAllTopics() throws SQLException {
        HashMap<Integer, String> topics = new HashMap<>();
        Statement stmt = DB.conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM GT_GraduateTopic;");
        //String format = "%3s|%20s\n";
        //System.out.format(format, "id", "name");
        while(rs.next()){
            topics.put(rs.getInt("GT_Id"), rs.getString("GT_Topic"));
        }
        return topics;
    }
    public static ObservableList<Mark> getMarks(int studentId) {
        /*
        "(M_Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " M_S_Id INTEGER NOT NULL," +
                " M_Mark TINYINT NOT NULL," +
                " M_Date DATE NOT NULL," +
                " M_Weight DECIMAL(3,2) NOT NULL);" +
         */
        ObservableList<Mark> out = FXCollections.<Mark>observableArrayList();
        try {
            PreparedStatement pstmt = DB.conn.prepareStatement(
                    "SELECT M_Id, M_GT_Id,  M_Mark, M_Date, M_Weight FROM M_Marking WHERE M_S_Id = ?");
            pstmt.setInt(1, studentId);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt("M_Id"));
                System.out.println(rs.getFloat("M_Mark"));
                System.out.println(rs.getFloat("M_Weight"));
                out.add(new Mark(
                                rs.getInt("M_Id"), rs.getInt("M_GT_Id"),
                                rs.getFloat("M_Mark"),
                                LocalDate.parse(rs.getString("M_Date")), rs.getFloat("M_Weight")
                        )
                );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return out;
    }
    public static void addMark(int studentId, Mark mark){
        try {
            PreparedStatement pstmt = DB.conn.prepareStatement(
                    "INSERT INTO M_Marking (M_S_Id, M_GT_Id, M_Mark, M_Date, M_Weight) VALUES (?, ?, ?, ?, ?)");
            pstmt.setInt(1, studentId);
            pstmt.setInt(2, mark.getGraduateTopicId());
            pstmt.setFloat(3, mark.getMark());
            pstmt.setString(4, mark.getDate());
            pstmt.setFloat(5, mark.getWeight());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void removeMark(int markId){
        try {
            PreparedStatement pstmt = DB.conn.prepareStatement(
                    "DELETE FROM M_Marking WHERE M_Id=?");
            pstmt.setInt(1, markId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void customStmt(String sql){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List getAlreadyTestedIdList(boolean studentTopic, int nDays, float weightFrom, float weightTo){
        PreparedStatement pstmt = null;
        List<Integer> out = new ArrayList<>();
        try {
//            pstmt = DB.conn.prepareStatement(
//                    "SELECT S_Id FROM S_Student JOIN M_Marking ON M_S_Id = S_Id " +
//                            "WHERE M_Date > CURDATE() - INTERVAL ? DAY;");

            //SQLite nepodporuje mat. operace nad typem DECIMAL, je potřeba použít CAST
            pstmt = DB.conn.prepareStatement(
                    "SELECT S_Id, M_GT_Id FROM S_Student JOIN M_Marking ON M_S_Id = S_Id " +
                            "WHERE M_Date > DATE('now', ?) AND CAST(M_Weight AS REAL) BETWEEN ? AND  ? ;");
            pstmt.setString(1, String.format("-%d days", nDays));
            pstmt.setFloat(2, weightFrom);
            pstmt.setFloat(3, weightTo);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                    if(studentTopic) {
                        out.add(rs.getInt("S_Id"));
                    } else {
                        out.add(rs.getInt("M_GT_Id"));
                    }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return out;
    }
}
