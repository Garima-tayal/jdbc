import java.sql.*;
public class insert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String passward = "garima";
        String query = "insert into employees(id, name,job_title,salary) values (3,'harsh','full stack',345000);";
       //delete from employees where id = 3;
       //update employees + set salary=5000000 + where id =2;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded successfully");
        }
        catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
         Connection con = DriverManager.getConnection(url,username,passward);
         System.out.println("connection established successfully");
         Statement stmt = con.createStatement();
         int rowsaffected = stmt.executeUpdate(query);     //to put data to database use executeUpdate and to get data use executeQuery

         if(rowsaffected > 0){
            System.out.println("insert successfull" +rowsaffected+ "rows affected");
         }
         else{
            System.out.println("insertion failed");
         }

         stmt.close();
         con.close();
         System.out.println();
         System.out.println("connection closed successfully");
}
catch(SQLException e){
    System.out.println(e.getMessage());
}
    
}
}
