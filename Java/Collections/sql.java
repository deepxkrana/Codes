import java.sql.*;

class sql {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "rajmeeroo1D");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement st = con.createStatement();
            st.executeUpdate("CREATE TABLE CUSTOMERS (ID INT NOT NULL,NAME VARCHAR(20) NOT NULL,AGE INT NOT NULL, ADDRESS CHAR(25),SALARY DECIMAL(18,2),PRIMARY KEY(ID))");
            System.out.println("table craeted");
            st.executeUpdate("INSERT INTO CUSTOMERS VALUES(1,'Ramesh',32,'Ahmedabad',2000.00),(2,'Khilan',25,'Delhi',1500.00),(3,'Kaushik',23,'Kota',2000.00),(4,'chaitali',25,'Mumbai',6500.00)");
            System.out.println("Record Updated");
            ResultSet rs=st.executeQuery("SELECT * FROM CUSTOMERS");
            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt("AGE"));
            }
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
