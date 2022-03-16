package Data_processing;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class email_find {

    static Connection con;     //声明connection对象
    static Statement sql;     //声明statement对象
    static ResultSet res;     //声明resultset对象

    public Connection getCon() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql:"
                + "//118.195.184.200:3306/crawler", "", "");

        return con;
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        email_find c=new email_find();
        c.getCon();

                sql=con.createStatement();

        res=sql.executeQuery("SELECT * from t_expert  ");

        while(res.next())
        {
            String introduction=res.getString("introduction");

            String email=res.getString("email");


            int id=res.getInt("id");


            if(introduction!=null) {
                if (email == null) {
                    String check="[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)";

                    Pattern pattern = Pattern.compile(check);

                    Matcher matcher = pattern.matcher(introduction);

                    if (matcher.find()) {

                        String e_mail=matcher.group();
                        System.out.println(e_mail);
                        PreparedStatement sql1=con.prepareStatement("update t_expert set email=? where id=?");
                        sql1.setString(1,matcher.group());
                        sql1.setInt(2,id);
//                        sql1.executeUpdate();
                    }
                }
            }
        }




    }
}
