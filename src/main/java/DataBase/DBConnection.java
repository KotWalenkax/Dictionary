package DataBase;

import Model.Word;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.sql.Types.NULL;

public class DBConnection {

    private static String URL = "jdbc:postgresql:Dictionary";
    private static String USER = "postgres";
    private static String PASSWORD = "5878041";

    Connection c = null;
    PreparedStatement st = null;
    Statement stmt = null;

    public DBConnection() throws SQLException {

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection(URL, USER, PASSWORD);
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    public void insert(int id, String word, String trans) {

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/Dictionary",
                            "postgres", "5878041");
            System.out.println("Opened database successfully");
            c.setAutoCommit(false);

            st = c.prepareStatement("INSERT INTO word VALUES(?, ?, ?, ?)");
            st.setInt(1, id);
            st.setString(2, word);
            st.setString(3, trans);
            st.setString(4, "Null");
            st.addBatch();

            int[] updateCount = st.executeBatch();
            c.commit();
            c.setAutoCommit(true);
            st.close();
            c.close();

        } catch (Exception e) {
                e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

        System.out.println("Records created successfully");
    }

    public ObservableList<Word> select () {

        ObservableList<Word> wordList = FXCollections.observableArrayList();

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/Dictionary",
                            "postgres", "5878041");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM word;" );
            while ( rs.next() ) {
                wordList.add(new Word(rs.getInt("id"),
                                        rs.getString("word"),
                                        rs.getString("translation")));
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");

        return wordList;

    }

}
