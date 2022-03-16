package gongshang;

import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.sql.*;
import java.util.regex.*;

//硕士生导师(学术型)
public class tutor2 {


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
        String document = Jsoup.connect("http://yjs.zjgsu.edu.cn/show.asp?cid=2857").timeout(3000).get().toString();


        tutor2 c=new tutor2();
        c.getCon();


        Pattern pattern = Pattern.compile("<a href=\"(\\S*)\" target=\"_blank\">");
        Matcher matcher = pattern.matcher(document);


        sql=con.prepareStatement("insert into t_expert  (name,url,avatar,introduction) values(?,?,?,?) ");

        while(matcher.find())
        {
            String url = matcher.group(1);

            Document document1 = Jsoup.connect(url).timeout(3000).get();

            String introduction= document1.text();

            String name=introduction.substring(introduction.indexOf("关闭页面")+5,introduction.indexOf("（"));

            System.out.println(name);
            introduction=introduction.substring(introduction.indexOf("次）")+2,introduction.indexOf("分享到："));



            String s = document1.toString();

            Pattern pattern1 = Pattern.compile("alt=\"\" src=\"(\\S*)\"");
            Matcher matcher1 = pattern1.matcher(s);

            String img=null;
            while(matcher1.find())
            {
                img="http://yjs.zjgsu.edu.cn/"+matcher1.group(1);

            }

            sql.setString(1,name);
            sql.setString(2,url);
            sql.setString(3,img);
            sql.setString(4,introduction);

            sql.executeUpdate();


        }
    }
}
