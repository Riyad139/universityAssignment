import java.sql.*;

public class DataModel {

    private String [][]data=new String[15][5];
      DataModel(){
          String url = "jdbc:sqlite:src/studentDatabase.db";
          String query = "INSERT INTO student_data(ID,NAME,DEPT,TYPE,EMAIL) VALUES(?,?,?,?,?)";
          String create = "CREATE TABLE student_data(ID TEXT,NAME TEXT,DEPT TEXT,TYPE TEXT,EMAIL TEXT)";
          String Drop = "DROP TABLE student_data1";
          try {
              Connection connection = DriverManager.getConnection(url);
              if(connection==null){
                  System.out.println("wow you have failed");
                  return;
              }
             String sql = "SELECT * FROM student_data";
              Statement statement = null;
                  statement = connection.createStatement();



              ResultSet rs = statement.executeQuery(sql);
             int i = 0;
             while(rs.next()){
                data[i] = new String[]{rs.getString("ID"), rs.getString("NAME"), rs.getString("DEPT"), rs.getString("TYPE"), rs.getString("EMAIL")};
                i++;
             }



          }catch (SQLException e){
              System.out.println("Error");
              System.out.println(e);
          }
      }

      public String[][] getData(){
          return data;
      }


}
