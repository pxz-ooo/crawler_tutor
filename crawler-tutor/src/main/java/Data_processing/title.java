package Data_processing;

import java.sql.*;

public class title {
    static Connection con;     //声明connection对象
    static Statement sql;     //声明statement对象
    static ResultSet res;     //声明resultset对象

    public Connection getCon() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql:"
                + "//118.195.184.200:3306/crawler", "crawler", "crawler@zstu");

        return con;
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       title c=new title();
       c.getCon();

       sql=con.createStatement();

       res=sql.executeQuery("select * from t_expert where id<=234");

       while(res.next())
       {
           String avatar=res.getString("avatar");
           if(avatar.contains("http://elec.hdu.edu.cn/"))
           {
               int a=avatar.indexOf("http://elec.hdu.edu.cn/");
               System.out.println(avatar);
               avatar=avatar.substring(0,a+23)+avatar.substring(a+24);
               System.out.println(avatar);
           }



//    学历信息
//           String edu=null;
//           if(text!=null) {
//               if (text.contains("博士"))
//                   edu = "博士";
//               else if (text.contains("硕士"))
//                   edu = "硕士";
//
//           }
//           if(edu==null)
//               System.out.println(id);
//
//           PreparedStatement sql1=con.prepareStatement("update t_expert set education=? where id=?");
//           sql1.setString(1,edu);
//           sql1.setInt(2,id);
//           sql1.executeUpdate();

       }


    }
}
