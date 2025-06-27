import java.sql.*;
public class App {
    public static void main(String[] args) throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded successfully");
        }
        catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","garima");
            System.out.println("connection established successfully");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from employees;");
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                double salary = rs.getDouble("salary");
                System.out.println();
                System.out.println("===========================");
                System.out.println("id:"+id);
                System.out.println("name:"+name);
                System.out.println("job_title:"+job_title);
                System.out.println("salary:"+salary);

            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
   
