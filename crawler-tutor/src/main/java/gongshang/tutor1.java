package gongshang;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.sql.*;
import java.util.regex.*;

public class tutor1 {


    static Connection con;     //声明connection对象
    static PreparedStatement sql;     //声明statement对象
    static ResultSet res;     //声明resultset对象

    public Connection getCon() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql:"
                + "//118.195.184.200:3306/crawler", "crawler", "crawler@zstu");

        return con;
    }


    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {


         tutor1 c=new tutor1();
         con=c.getCon();

        String document = Jsoup.connect("http://yjs.zjgsu.edu.cn/show.asp?cid=1365").timeout(3000).get().toString();




        Pattern pattern = Pattern.compile("<a href=\"(\\S*)\" target=\"_blank\">");
        Matcher matcher = pattern.matcher(document);


        sql=con.prepareStatement("insert into t_expert (name,url,avatar,introduction) values (?,?,?,?)");

        while(matcher.find()) {
            String url = matcher.group(1);


            if (url.indexOf("http://yjs.zjgsu.edu.cn/") == -1) {
                url = "http://yjs.zjgsu.edu.cn/" + url;
            }

            if (url.indexOf("http://10.11.99.103:8001/") == -1) {
                System.out.println(url);
                Document document1 = Jsoup.connect(url).timeout(3000).get();

                String introduction = document1.text();


                introduction = introduction.substring(introduction.indexOf("次）") + 2, introduction.indexOf("分享到"));
                System.out.println(introduction);

                if (!introduction.equals(" ")) {
                    String name = introduction.substring(0, introduction.indexOf("，"));
                    if (name.indexOf("（") != -1)
                        name = name.substring(0, name.indexOf("（"));

                    if (name.indexOf("李建强") != -1)
                        name = "李建强";

                    System.out.println(name);

                    String s = document1.toString();
                    Pattern pattern1 = Pattern.compile("alt=\"\" src=\"(\\S*)\"");
                    Matcher matcher1 = pattern1.matcher(s);
                    String jpg = null;
                    if (matcher1.find())
                        jpg = "http://yjs.zjgsu.edu.cn" + matcher1.group(1);
                    System.out.println(jpg);

                }
                //                sql.setString(1,name);
//                sql.setString(2,url);
//                sql.setString(3,jpg);
//                sql.setString(4,introduction);
//
//                sql.executeUpdate();


            }

        }
    }
}
