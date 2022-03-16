package ZUFE;

import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main1 {

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

        main1 c= new main1();
        c.getCon();

        //        finance1();//财政税务学院

        //        Administration();//公共管理学院

        //        Accounting();      //会计学院

        //        Finance();       //金融学院

        //        Business_Administration(); //工商管理学院M B A 学
        //      Information();//信息管理与人工智能学院

//          Economy();//经济学院

//        Law();//法学院

//        Foreign();//外国语学院

//        DataScience();//数据科学学院

//        Humanities();//人文与传播学院

//        Marxism();//马克思主义学院


//        Goverment();//中国政府管制研究院


        Academy();//中国金融研究院



    }

    private static void Academy() throws IOException, SQLException {

        String []urls={"https://cafr.zufe.edu.cn/zjtd.htm","https://cafr.zufe.edu.cn/zjtd/2.htm","https://cafr.zufe.edu.cn/zjtd/1.htm"};

        for(int i=0;i<3;i++)
        {
            Document document = Jsoup.connect(urls[i]).timeout(3000).get();

            String text = document.toString();

            Pattern pattern = Pattern.compile("href=\"(\\S*)\"></a>");
            Matcher matcher = pattern.matcher(text);

            while(matcher.find())
            {
               String url=matcher.group(1);
               url="https://cafr.zufe.edu.cn"+url;

                Document document1 = Jsoup.connect(url).timeout(3000).get();
                Elements form = document1.select("form");
                Elements elements1 = form.select("div#vsb_content");
                String name = elements1.select("div.content-bt").text();
                System.out.println(name);
                String introduction = elements1.text();
                System.out.println(introduction);

                String avatar = elements1.select("p img").attr("src");
                System.out.println(avatar);

                sql=con.prepareStatement("insert into t_expert (name,avatar,introduction,url,college) values(?,?,?,?,?) ");

                sql.setString(1,name);
                sql.setString(2,avatar);
                sql.setString(3,introduction);
                sql.setString(4,url);
                sql.setString(5,"中国金融研究院");


            }

        }

    }

    private static void Goverment() throws IOException, SQLException {


        String[] urls = {"https://irr.zufe.edu.cn/rcpy/bssds/gzjjx.htm", "https://irr.zufe.edu.cn/rcpy/bssds/gzjjx.htm", "https://irr.zufe.edu.cn/rcpy/sssds.htm", "https://irr.zufe.edu.cn/rcpy/sssds/1.htm"};
        String[] title = {"博士生导师", "博士生导师", "硕士生导师", "硕士生导师"};

        for (int i = 0; i < 4; i++) {
            Document document = Jsoup.connect(urls[i]).timeout(3000).get();

            String text = document.toString();

            Matcher matcher = null;
            if (i < 2) {
                Pattern pattern = Pattern.compile("<a href=\"(\\S*)\" target=\"_blank\"");
                matcher = pattern.matcher(text);
            } else {
                Pattern pattern = Pattern.compile(" <div class=\"date\">\n" +
                        "         <a href=\"(\\S*)\">");
                matcher = pattern.matcher(text);
            }

            String college="中国政府管制研究院";
            while (matcher.find()) {
                String url = matcher.group(1);


                if (url.contains("info")&&!url.contains("http")) {
                    System.out.println(url);
                    while (url.contains("../")) {
                        url = url.replace("../", "");
                    }
                    url = "https://irr.zufe.edu.cn/" + url;

                    Elements document1 = Jsoup.connect(url).timeout(3000).get().select("form");
                    String name = document1.select("div.detail_head div").first().text();


                    Elements elements1 = document1.select("div.detail_main");
                    String introduction = elements1.text();
                    System.out.println(introduction);

                    String avatar = elements1.select("p img").attr("src");
                    avatar = "https://irr.zufe.edu.cn" + avatar;


                    sql = con.prepareStatement("insert into t_expert (name,url,avatar,introduction,college,title) values(?,?,?,?,?,?)");

                    sql.setString(1, name);
                    sql.setString(2, url);
                    sql.setString(3, avatar);
                    sql.setString(4, introduction);
                    sql.setString(5, "中国政府管制研究院");
                    sql.setString(6,title[i]);


//                    sql.executeUpdate();
                }
            }
        }
    }





    private static void Marxism() throws IOException, SQLException {

       String text="<div id=\"vsb_content_4_4500_u61\"><div id=\"vsb_content_4\"><p class=\"vsbcontent_start\"><strong>一、伦理学硕士点（以姓氏笔画为序）</strong></p>\n" +
               "<p><a href=\"../info/1027/3257.htm\" target=\"_self\">于江霞</a>&nbsp; <a href=\"../info/1027/3269.htm\" target=\"_self\">亓奎言</a>&nbsp; <a href=\"../info/1027/3248.htm\" target=\"_self\">冯庆旭</a>&nbsp; <a href=\"../info/1027/3268.htm\" target=\"_self\">朱巧香</a>&nbsp; <a href=\"../info/1027/3267.htm\" target=\"_self\">何历宇</a>&nbsp;&nbsp;<a href=\"../info/1027/3247.htm\" target=\"_self\">张波波</a>&nbsp; <a href=\"../info/1027/3249.htm\" target=\"_self\">李金鑫</a>&nbsp; <a href=\"../info/1027/3264.htm\" target=\"_self\">李秋华</a>&nbsp; <a href=\"../info/1027/3256.htm\" target=\"_self\">邢雁欣</a>&nbsp; <a href=\"../info/1027/3271.htm\" target=\"_self\">陈寿灿</a><span style=\"line-height: 33.6px; text-indent: 37.33px; font-size: 18.66px;\">&nbsp; <a href=\"../info/1027/3246.htm\" target=\"_self\">徐晓燕</a></span>&nbsp; <a href=\"../info/1027/3263.htm\" target=\"_self\">秦越存</a>&nbsp;&nbsp;<span style=\"line-height: 33.6px;\">&nbsp;&nbsp;</span><span style=\"line-height: 33.6px;\">&nbsp;&nbsp;</span>&nbsp;<span style=\"line-height: 33.6px; text-indent: 37.33px; font-size: 18.66px;\">&nbsp;&nbsp;</span></p>\n" +
               "<p><span style=\"line-height: 33.6px; text-indent: 37.33px; font-size: 18.66px;\">&nbsp;&nbsp;</span>&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"line-height: 33.6px; text-indent: 37.33px; font-size: 18.66px;\">&nbsp;&nbsp;</span></p>\n" +
               "<p><strong>二、马克思主义法治思想中国化研究硕士点导师（以姓氏笔画为序）</strong></p>\n" +
               "<p><a href=\"../info/1027/3257.htm\" target=\"_self\">于江霞</a>&nbsp; <a href=\"../info/1027/3251.htm\" target=\"_self\">王永胜</a>&nbsp; <a href=\"../info/1027/3253.htm\" target=\"_self\">邓太萍</a>&nbsp; <a href=\"../info/1027/3266.htm\" target=\"_self\">华正学</a>&nbsp;&nbsp;<a href=\"../info/1027/3252.htm\" target=\"_self\">刘向前</a>&nbsp; <a href=\"../info/1027/3256.htm\" target=\"_self\">邢雁欣</a>&nbsp; <a href=\"../info/1027/3259.htm\" target=\"_self\">沈鑫泉</a>&nbsp; <a href=\"../info/1027/3261.htm\" target=\"_self\">贺武华</a>&nbsp; <a href=\"../info/1027/3255.htm\" target=\"_self\">胡洪彬</a>&nbsp; <a href=\"../info/1027/3270.htm\" target=\"_self\">高 伟</a><span style=\"line-height: 33.6px;\">&nbsp; <a href=\"../info/1027/3250.htm\" target=\"_self\">贾亚君</a></span>&nbsp; <a href=\"../info/1027/3258.htm\" target=\"_self\">曾 骊</a>&nbsp; <a href=\"../info/1027/3254.htm\" target=\"_self\">韩跃民</a><span style=\"line-height: 33.6px; text-indent: 37.33px; font-size: 18.66px;\">&nbsp; <a href=\"../info/1027/3260.htm\" target=\"_self\">潘旦</a><span style=\"line-height: 33.6px; text-indent: 37.33px; font-size: 18.66px;\">&nbsp;</span>&nbsp;<span style=\"line-height: 33.6px; text-indent: 37.33px; font-size: 18.66px;\">&nbsp;&nbsp;</span>&nbsp;<span style=\"line-height: 33.6px; text-indent: 37.33px; font-size: 18.66px;\">&nbsp;</span></span></p>\n" +
               "<p><span style=\"line-height: 33.6px; text-indent: 37.33px; font-size: 18.66px;\"><span style=\"line-height: 33.6px; text-indent: 2em; font-size: 14pt;\"><span style=\"line-height: 33.6px; text-indent: 37.33px; font-size: 18.66px;\">&nbsp;&nbsp;</span></span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"line-height: 33.6px;\"><span style=\"line-height: 33.6px; text-indent: 37.33px; font-size: 18.66px;\">&nbsp;</span></span><span style=\"line-height: 33.6px;\">&nbsp;</span></p></div></div>";
        Pattern pattern = Pattern.compile("<a href=\"(\\S*)\" target=\"_self\">");
        Matcher matcher = pattern.matcher(text);

        String college="马克思主义学院";

        while(matcher.find())
        {
            String url=matcher.group(1);
            while(url.contains("../"))
            {
                url=url.replace("../","");

            }
            url="https://marx.zufe.edu.cn/"+url;
            System.out.println(url);

            Elements form = Jsoup.connect(url).timeout(1000).get().select("form");

            String name= form.select("div.show01 h5").text();
            System.out.println(name);

            String avatar = form.select("div#vsb_content p img").attr("src");
            avatar="https://marx.zufe.edu.cn"+avatar;

            System.out.println(avatar);

            String introduction = form.select("div#vsb_content").text();
            System.out.println(introduction);

            sql=con.prepareStatement("insert into t_expert (name,introduction,avatar,url,college,title) values(?,?,?,?,?,?)");

            sql.setString(1,name);
            sql.setString(2,introduction);
            sql.setString(3,avatar);
            sql.setString(4,url);
            sql.setString(5,college);
            sql.setString(6,"硕士生导师");


//            sql.executeUpdate();
        }
    }

    private static void Humanities() throws IOException, SQLException {

        Document document = Jsoup.connect("https://rwxy.zufe.edu.cn/xygk/szdw.htm").timeout(3000).get();


        String text = document.toString();
        Pattern pattern = Pattern.compile("<p style=\"text-align: center\"><a href=(\\S*)</a></p></td>");
        Matcher matcher = pattern.matcher(text);
        String college="人文与传播学院";
        while(matcher.find())
        {
            String url=matcher.group(1);
            String name=url.substring(url.indexOf(">")+1);
            url=url.substring(url.indexOf("../")+3,url.indexOf(">")-1);
            url="https://rwxy.zufe.edu.cn/"+url;


            Document document1 = Jsoup.connect(url).timeout(3000).get();

            Elements elements = document1.select("div.v_news_content");
            String avatar = elements.select("p img").attr("src");
            avatar="https://rwxy.zufe.edu.cn"+avatar;
            System.out.println(avatar);
            String introduction = elements.text();
            System.out.println(introduction);

            sql=con.prepareStatement("insert into t_expert (name,url,avatar,introduction,college) values(?,?,?,?,?)");
            sql.setString(1,name);
            sql.setString(2,url);
            sql.setString(3,avatar);
            sql.setString(4,introduction);
            sql.setString(5,college);
//            sql.executeUpdate();





        }




    }

    private static void DataScience() throws IOException, SQLException {
        String html="<div style=\"margin: 40px auto; width: 810px; overflow: hidden;\">\n" +
                "     <div class=\"dsfc-bs\">\n" +
                "        <p class=\"bs\">博士生导师</p>\n" +
                "     \n" +
                "<script language=\"javascript\" src=\"/system/resource/js/openlink.js\"></script><ul style=\"min-height:80px\">\n" +
                "    <li><a href=\"../info/1104/4936.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34356)\">李金昌</a></li>\n" +
                "\n" +
                "    <li><a href=\"../info/1104/4820.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34357)\">洪兴建</a></li>\n" +
                "\n" +
                "    <li><a href=\"../info/1104/4934.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34358)\">邱瑾</a></li>\n" +
                "\n" +
                "    <li><a href=\"../info/1104/4821.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34359)\">赵晓兵</a></li>\n" +
                "\n" +
                "    <li><a href=\"../info/1104/4822.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34360)\">罗季</a></li>\n" +
                "\n" +
                "    <li><a href=\"../info/1104/4825.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34361)\">李云霞</a></li>\n" +
                "\n" +
                "    <li><a href=\"../info/1104/5306.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 36630)\">周银香</a></li>\n" +
                "\n" +
                "    <li><a href=\"../info/1104/5307.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 36631)\">曾菊英</a></li>\n" +
                "\n" +
                " <div style=\"clear:both;\"></div>\n" +
                "</ul>\n" +
                "       \n" +
                "     </div>\n" +
                "     <div class=\"dsfc-ss\">\n" +
                "        <p class=\"ss\">硕士生导师</p>\n" +
                "        <div class=\"zyjs-jjtj\">\n" +
                "           <div class=\"jjtj\"><span>经济统计</span><span style=\"padding-left: 10px;\"><img src=\"../images/jszy-jjtj.png\" style=\"width: 89%;\"></span></div>\n" +
                "         <ul>\n" +
                "    <li><a href=\"../info/1092/4945.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34363)\">李金昌</a></li>\n" +
                "    <li><a href=\"../info/1092/4613.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34364)\">洪兴建</a></li>\n" +
                "    <li><a href=\"https://ds.zufe.edu.cn/info/1104/5306.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34365)\">周银香</a></li>\n" +
                "    <li><a href=\"../info/1092/4643.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34366)\">黄秀海</a></li>\n" +
                "    <li><a href=\"../info/1092/4633.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34367)\">曾菊英</a></li>\n" +
                "    <li><a href=\"../info/1092/4634.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34368)\">陈玉娟</a></li>\n" +
                "    <li><a href=\"../info/1092/4617.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34369)\">李时兴</a></li>\n" +
                "    <li><a href=\"../info/1092/4629.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34370)\">项　莹</a></li>\n" +
                "    <li><a href=\"../info/1092/4625.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34371)\">刘　波</a></li>\n" +
                "    <li><a href=\"../info/1092/4618.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34372)\">朱宗元</a></li>\n" +
                "    <li><a href=\"../info/1092/4619.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34373)\">郑　彦</a></li>\n" +
                "    <li><a href=\"../info/1092/4636.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34657)\">成定平</a></li>\n" +
                "    <li><a href=\"../info/1092/4626.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34658)\">张锐</a></li>\n" +
                "    <li><a href=\"../info/1092/4880.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34659)\">石薇</a></li>\n" +
                "    <li><a href=\"https://ds.zufe.edu.cn/info/1092/4930.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 74120)\">章琳云</a></li>\n" +
                "    <li><a href=\"https://info.zufedfc.edu.cn/info/1025/3601.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 74130)\">李伟</a></li>\n" +
                " <div style=\"clear:both;\"></div>\n" +
                "\n" +
                "</ul>\n" +
                "\n" +
                "\n" +
                "\n" +
                " \n" +
                "\n" +
                "      </div>\n" +
                "      <div class=\"zyjs-jjtj\">\n" +
                "           <div class=\"jjtj\"><span>应用概率统计</span><span style=\"padding-left: 10px;\"><img src=\"../images/jszy-jjtj.png\" style=\"width: 85%;\"></span></div>\n" +
                "\n" +
                "<ul>\n" +
                "    <li><a href=\"../info/1092/4641.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34374)\">邱　瑾</a></li>\n" +
                "    <li><a href=\"../info/1092/4644.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34375)\">赵晓兵</a></li>\n" +
                "    <li><a href=\"../info/1092/4646.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34376)\">罗　季</a></li>\n" +
                "    <li><a href=\"../info/1092/4642.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34377)\">李云霞</a></li>\n" +
                "    <li><a href=\"../info/1092/4630.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34378)\">胡玉琴</a></li>\n" +
                "    <li><a href=\"../info/1092/4631.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34379)\">沈银芳</a></li>\n" +
                "    <li><a href=\"../info/1092/4627.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34380)\">许　林</a></li>\n" +
                "    <li><a href=\"../info/1092/4628.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34381)\">项思佳</a></li>\n" +
                "    <li><a href=\"../info/1092/4624.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34382)\">周力凯</a></li>\n" +
                "    <li><a href=\"../info/1092/4616.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34383)\">周亭攸</a></li>\n" +
                "    <li><a href=\"https://ds.zufe.edu.cn/info/1092/4922.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 74032)\">楼芝兰</a></li>\n" +
                " <div style=\"clear:both;\"></div>\n" +
                "</ul>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "        \n" +
                "       </div>\n" +
                "       <div class=\"zyjs-jjtj\">\n" +
                "           <div class=\"jjtj\"><span>管理统计学</span><span style=\"padding-left: 10px;\"><img src=\"../images/jszy-jjtj.png\" style=\"width: 76%;\"></span></div>\n" +
                "\n" +
                "<ul>\n" +
                "    <li><a href=\"../info/1092/4637.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34385)\">陈晓雷</a></li>\n" +
                "    <li><a href=\"../info/1092/4623.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34386)\">张永全</a></li>\n" +
                "    <li><a href=\"../info/1092/4635.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34387)\">孙　洁</a></li>\n" +
                "    <li><a href=\"../info/1092/4632.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34388)\">李红霞</a></li>\n" +
                "    <li><a href=\"../info/1092/4931.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34389)\">郑　松</a></li>\n" +
                "    <li><a href=\"../info/1092/4907.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34390)\">陈国元</a></li>\n" +
                "    <li><a href=\"../info/1092/4912.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34391)\">李好好</a></li>\n" +
                "    <li><a href=\"../info/1092/4911.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34570)\">季家兵</a></li>\n" +
                "    <li><a href=\"../info/1092/4977.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34656)\">郑超</a></li>\n" +
                "    <li><a href=\"../info/1092/4620.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34660)\">王群</a></li>\n" +
                "    <li><a href=\"../info/1092/4621.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34661)\">王毅</a></li>\n" +
                " <div style=\"clear:both;\"></div>\n" +
                "</ul>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "           \n" +
                "      </div>\n" +
                "      <div class=\"zyjs-jjtj\">\n" +
                "           <div class=\"jjtj\"><span>应用统计（专业学位）</span><span style=\"padding-left: 10px;\"><img src=\"../images/jszy-jjtj.png\" style=\"width: 89%;\"></span></div>\n" +
                "           <ul>\n" +
                "    <li><a href=\"../info/1092/4614.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34392)\">李金昌</a></li>\n" +
                "    <li><a href=\"../info/1092/4613.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34393)\">洪兴建</a></li>\n" +
                "    <li><a href=\"../info/1092/4615.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34394)\">周君兴</a></li>\n" +
                "    <li><a href=\"../info/1092/4646.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34395)\">罗　季</a></li>\n" +
                "    <li><a href=\"../info/1092/4645.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34396)\">周银香</a></li>\n" +
                "    <li><a href=\"../info/1092/4641.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34397)\">邱　瑾</a></li>\n" +
                "    <li><a href=\"../info/1092/4644.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34398)\">赵晓兵</a></li>\n" +
                "    <li><a href=\"../info/1092/4642.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34399)\">李云霞</a></li>\n" +
                "    <li><a href=\"../info/1092/4643.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34400)\">黄秀海</a></li>\n" +
                "    <li><a href=\"../info/1092/4633.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34401)\">曾菊英</a></li>\n" +
                "    <li><a href=\"../info/1092/4623.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34402)\">张永全</a></li>\n" +
                "    <li><a href=\"../info/1092/4630.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34403)\">胡玉琴</a></li>\n" +
                "    <li><a href=\"../info/1092/4635.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34404)\">孙　洁</a></li>\n" +
                "    <li><a href=\"../info/1092/4634.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34405)\">陈玉娟</a></li>\n" +
                "    <li><a href=\"../info/1092/4617.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34406)\">李时兴</a></li>\n" +
                "    <li><a href=\"../info/1092/4621.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34407)\">王　毅</a></li>\n" +
                "    <li><a href=\"../info/1092/4631.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34408)\">沈银芳</a></li>\n" +
                "    <li><a href=\"../info/1092/4627.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34409)\">许　林</a></li>\n" +
                "    <li><a href=\"../info/1092/4628.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34410)\">项思佳</a></li>\n" +
                "    <li><a href=\"../info/1092/4629.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34411)\">项　莹</a></li>\n" +
                "    <li><a href=\"../info/1092/4625.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34412)\">刘　波</a></li>\n" +
                "    <li><a href=\"../info/1092/4618.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34413)\">朱宗元</a></li>\n" +
                "    <li><a href=\"../info/1092/4624.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34414)\">周力凯</a></li>\n" +
                "    <li><a href=\"../info/1092/4619.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34415)\">郑　彦</a></li>\n" +
                "    <li><a href=\"../info/1092/4620.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34416)\">王　群</a></li>\n" +
                "    <li><a href=\"../info/1092/4626.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34665)\">张 锐</a></li>\n" +
                "    <li><a href=\"../info/1092/4880.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34666)\">石 薇</a></li>\n" +
                "    <li><a href=\"../info/1092/4977.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34667)\">郑 超</a></li>\n" +
                "    <li><a href=\"../info/1092/4911.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34668)\">季家兵</a></li>\n" +
                "    <li><a href=\"../info/1092/4616.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34669)\">周亭攸</a></li>\n" +
                "    <li><a href=\"../info/1092/4931.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34670)\">郑 松</a></li>\n" +
                "    <li><a href=\"../info/1092/4907.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 34671)\">陈国元</a></li>\n" +
                "    <li><a href=\"https://ds.zufe.edu.cn/info/1092/4910.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 74031)\">方  成</a></li>\n" +
                "    <li><a href=\"https://ds.zufe.edu.cn/info/1092/4922.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 74041)\">楼芝兰</a></li>\n" +
                "    <li><a href=\"https://ds.zufe.edu.cn/info/1092/4930.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 74121)\">章琳云</a></li>\n" +
                "    <li><a href=\"https://info.zufedfc.edu.cn/info/1025/3601.htm\" target=\"_blank\" title=\"\" onclick=\"_addDynClicks(&quot;wburl&quot;, 1445295585, 74131)\">李伟</a></li>\n" +
                " <div style=\"clear:both;\"></div>\n" +
                "</ul>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "      </div>\n" +
                "     </div>\n" +
                "<div class=\"dsfc-shss\">\n" +
                "        <p class=\"bs\">硕士生社会导师</p>\n" +
                "        <ul style=\"min-height:80px\">\n" +
                " <div style=\"clear:both;\"></div>\n" +
                "</ul>\n" +
                "\n" +
                "\n" +
                "      </div>\n" +
                "\n" +
                "       \n" +
                "     </div>";


        Pattern pattern= Pattern.compile("<a href=\"(\\S*)\"");
        Matcher matcher = pattern.matcher(html);
        String college="数据科学学院";

        while(matcher.find())
        {
            String url=matcher.group(1);
            if(url.contains("../"))
            {
                url=url.replace("../","");
                url="https://ds.zufe.edu.cn/"+url;
            }
            Document document = Jsoup.connect(url).timeout(3000).get();
            Elements form = document.select("form");
            String name= form.select("div.jsxq-t div.jsxq-tr h2").text();
            String avatar = form.select("div.jsxq-t p img").attr("src");

            name=name.replace("姓名：","");

            System.out.println(name);
            avatar="https://ds.zufe.edu.cn"+avatar;

            System.out.println(avatar);

            String introduction = form.select("div.jsxq-b-all").text();
            System.out.println(introduction);

            sql=con.prepareStatement("insert into t_expert (name,avatar,introduction,url,college) values(?,?,?,?,?)");
            sql.setString(1,name);
            sql.setString(2,avatar);
            sql.setString(3,introduction);
            sql.setString(4,url);
            sql.setString(5,college);
//            sql.executeUpdate();

        }


    }

    private static void Foreign() throws IOException, SQLException {

        String []urls={"dsfc.htm","dsfc/5.htm","dsfc/4.htm","dsfc/3.htm","dsfc/2.htm","dsfc/1.htm"};

        for(int i=0;i<6;i++) {

            String html = "https://wgy.zufe.edu.cn/szdw1/" + urls[i];
            Document document = Jsoup.connect(html).timeout(3000).get();


            String text = document.toString();
            Pattern pattern = Pattern.compile("<a href=\"(\\S*)\" target=\"_blank\"");
            Matcher matcher = pattern.matcher(text);

            String college = "外国语学院";

            while (matcher.find()) {
                String url = matcher.group(1);
                while (url.contains("../"))
                    url = url.replace("../", "");
                if (!url.contains("http")) {
                    url = "https://wgy.zufe.edu.cn/" + url;


                    System.out.println(url);

                    Document document1 = Jsoup.connect(url).timeout(3000).get();
                    String name = document1.select("div.top_box div.w1200 h3").text();
                    System.out.println(name);
                    String title = "";
                    if (name.contains("副教授")) {
                        title = "副教授";
                        name = name.replace("副教授", "");
                    } else if (name.contains("教授")) {
                        title = "教授";
                        name = name.replace("教授", "");
                    }

                    System.out.println(title);
                    String introduction = document1.select("div.bottom_box").text();
                    System.out.println(introduction);

                    String avatar = document1.select("div.bottom_box p img").attr("src");
                    avatar = "https://wgy.zufe.edu.cn/" + avatar;
                    System.out.println(avatar);


                    sql = con.prepareStatement("insert into t_expert (name,url,avatar,college,introduction,title) values (?,?,?,?,?,?)");
                    sql.setString(1, name);
                    sql.setString(2, url);
                    sql.setString(3, avatar);
                    sql.setString(4, college);
                    sql.setString(5, introduction);
                    sql.setString(6, title);

//                    sql.executeUpdate();
                }


            }
        }




    }

    private static void Law() throws IOException, SQLException {

        //https://law.zufe.edu.cn/szdw/jsfc1/js2.htm
        //https://law.zufe.edu.cn/szdw/jsfc1/js2/1.htm
        //https://law.zufe.edu.cn/szdw/jsfc1/fjs1.htm
        //https://law.zufe.edu.cn/szdw/jsfc1/fjs1/1.htm

        String []urls={"jsfc1/js2.htm","jsfc1/js2/1.htm","jsfc1/fjs1.htm","jsfc1/fjs1/1.htm"};
        String []title={"教授","教授","副教授","副教授"};
        for(int i=3;i<4;i++)
        {
            String html="https://law.zufe.edu.cn/szdw/"+urls[i];
        Document document = Jsoup.connect(html).timeout(1000).get();

        String text= document.toString();

        Pattern pattern = Pattern.compile("<a href=\"(\\S*)\" target=\"_blank\"");
        Matcher matcher = pattern.matcher(text);


        String college="法学院";

        while(matcher.find()) {
            String url = matcher.group(1);
            while (url.contains("../"))
                url = url.replace("../", "");

            url = "https://law.zufe.edu.cn/" + url;

            Document document1 = Jsoup.connect(url).timeout(1000).get();
            Elements form = document1.select("form");
            String name = form.select("div.ar_title h3").text();
            System.out.println(name);

            Elements elements1 = form.select("div.v_news_content");
            String introduction = elements1.text();
            System.out.println(introduction);
            String team = elements1.select("p").first().text();
            String avatar = elements1.select("p img").attr("src");
            avatar = "https://law.zufe.edu.cn" + avatar;
            System.out.println(avatar);

            sql = con.prepareStatement("insert into t_expert (name,url,avatar,introduction,title,college,team) values(?,?,?,?,?,?,?)");
            sql.setString(1, name);
            sql.setString(2, url);
            sql.setString(3, avatar);
            sql.setString(4, introduction);
            sql.setString(5, title[i]);
            sql.setString(6, college);
            sql.setString(7, team);


//            sql.executeUpdate();
        }
        }

    }

    private static void Economy() throws IOException, SQLException {

        //应用经济学导师名录https://jm.zufe.edu.cn/info/1300/19435.htm
        //理论经济学导师名录 https://jm.zufe.edu.cn/info/1301/19436.htm
        Document document = Jsoup.connect("https://jm.zufe.edu.cn/info/1301/19436.htm").timeout(1000).get();
        String text = document.toString();


        Pattern pattern = Pattern.compile("a href=\"(\\S*)\" target=\"_blank\"");
        Matcher matcher = pattern.matcher(text);

        String title="硕士生导师";
        String subject="理论经济学";
        String college="经济学院";

        while(matcher.find())
        {
            String url=matcher.group(1);
            System.out.println(url);
            if(url.contains("info")&&!url.equals("http://jm.zufe.edu.cn/info/1237/11831.htm")) {
            Document document1 = Jsoup.connect(url).timeout(1000).get();

                if(document1.select("div.v_news_content").first()!=null) {
                    Element element1 = document1.select("div.v_news_content").first();
                    System.out.println(element1);
                    String introduction = element1.text();
                    System.out.println(introduction);
                    String avatar = element1.select("p img").attr("src");
                    avatar = "https://jm.zufe.edu.cn" + avatar;
                    System.out.println(avatar);
                    String name = document1.select("div.content div.con-h").text();
                    System.out.println(name);


                    sql = con.prepareStatement("insert into t_expert (name,url,avatar,introduction,college,subject,title) values(?,?,?,?,?,?,?)");

                    sql.setString(1, name);
                    sql.setString(2, url);
                    sql.setString(3, avatar);
                    sql.setString(4, introduction);
                    sql.setString(5, college);
                    sql.setString(6, subject);
                    sql.setString(7, title);

//                    sql.executeUpdate();

                }
            }
        }

    }

    private static void Information() throws IOException, SQLException {

        String []urls={"https://info.zufe.edu.cn/yjsjy/bssds.htm","https://info.zufe.edu.cn/yjsjy/sssds.htm"};
        String []tit={"博士生导师","硕士生导师"};
        String college="信息管理与人工智能学院";


        for(int i=0;i<2;i++) {

            Document document = Jsoup.connect(urls[i]).timeout(3000).get();

            String text = document.toString();

            Pattern pattern = Pattern.compile("<li><a href=\"(\\S*)\" title=");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                String url = matcher.group(1);

                if (url.contains("../")) {
                    url = url.replace("../", "");
                    url = "https://info.zufe.edu.cn/" + url;
                    System.out.println(url);

                    if (!url.equals("https://info.zufe.edu.cn/szdw/js/wzj/grjj1.htm")) {
                        Document document1 = Jsoup.connect(url).timeout(3000).get();

                        Element element1 = document1.select("div.szdw_content").first();

                        Element element2 = element1.select("div.szdw_txt.fl").first();

                        String name = element1.select("div.szdw_name.fl").text();

                        System.out.println(name);
                        String title = tit[i] + ",";

                       String avatar= element1.select("div.pic.fl img").attr("src");
                        avatar="https://info.zufe.edu.cn"+avatar;
                        System.out.println(avatar);
                        title += element2.select("div.title span.zc").text();


                        String text1 = element2.select("div.szdw_sx span.xw").text();


                        String education = text1.substring(text1.indexOf("学位") + 3, text1.indexOf("联系方式"));


                        String email = text1.substring(text1.indexOf("联系方式") + 5, text1.indexOf("办公"));


                        String text2 = document1.select("div#vsb_content").text();
                        if (text2.equals(""))
                            text2 = document1.select("div#vsb_content_2").text();
                        if(text2.equals(""))
                            text2=document1.select("div#vsb_content_501").text();

                        System.out.println(text2);

                        sql=con.prepareStatement("insert into t_expert (name,introduction,email,education,title,url,college,avatar) values(?,?,?,?,?,?,?,?)");

                        sql.setString(1,name);
                        sql.setString(2,text2);
                        sql.setString(3,email);
                        sql.setString(4,education);
                        sql.setString(5,title);
                        sql.setString(6,url);
                        sql.setString(7,college);
                        sql.setString(8,avatar);
                        sql.executeUpdate();
                    }
                }


                }

            }



    }

    private static void Business_Administration() throws IOException, SQLException {

        String []urls={"qyglx.htm","qyglx/1.htm","scyxx.htm","scyxx/1.htm","rlzyglx.htm","yyygylglx.htm"};
        String []team={"企业管理系","企业管理系","市场营销系","市场营销系","人力资源管理系","运营与供应链管理系"};
        String college="工商管理学院MBA学院";



        for(int i=0;i<6;i++) {

            String html="https://cba.zufe.edu.cn/jsdw/jsfc/"+urls[i];
            Document document = Jsoup.connect(html).timeout(1000).get();

            String text = document.toString();

            Pattern pattern1 = Pattern.compile("a\" href=\"(\\S*)\"></a>");
            Matcher matcher = pattern1.matcher(text);

            while (matcher.find()) {
                String url = matcher.group(1);

                while (url.indexOf("../") != -1) {
                    url = url.replace("../", "");
                }

                url = "https://cba.zufe.edu.cn/" + url;
                System.out.println(url);

                Document document1 = Jsoup.connect(url).timeout(1000).get();
                Elements form = document1.select("form");

                String name = form.select("div h2").text();

                String avatar = form.select("p img").attr("src");

                avatar = "https://cba.zufe.edu.cn/" + avatar;

                String introduction = form.select("div#vsb_content_2").text();
                System.out.println(introduction);
                System.out.println(name);
                System.out.println(avatar);


                sql=con.prepareStatement("insert into t_expert (name,url,introduction,avatar,team,college) values(?,?,?,?,?,?)");
                sql.setString(1,name);
                sql.setString(2,url);
                sql.setString(3,introduction);
                sql.setString(4,avatar);
                sql.setString(5,team[i]);
                sql.setString(6,college);
//                sql.executeUpdate();
            }
        }


    }

    private static void Finance() throws IOException, SQLException {

        String []urls={"bssds.htm","sssds.htm"};
        String []title={"博士生导师","硕士生导师"};
        String college="金融学院";
        for(int i=0;i<2;i++) {
            String html="https://jrxy.zufe.edu.cn/szdw/"+urls[i];
            Document document = Jsoup.connect(html).timeout(1000).get();
            String doc = document.toString();


            Pattern pattern1 = Pattern.compile("_a\" href=\"(\\S*)\"></a>");
            Matcher matcher = pattern1.matcher(doc);

            while (matcher.find()) {
                String url = matcher.group(1);

                while (url.indexOf("../") != -1) {
                    url = url.replace("../", "");

                }
                url = "https://jrxy.zufe.edu.cn/" + url;
                Document document1 = Jsoup.connect(url).timeout(1000).get();

                Elements form = document1.select("form");

                String name = form.select("div h1").text();


                String tit=title[i];


                if (name.indexOf("副教授") != -1) {
                    tit += ",副教授";
                   name= name.replace("副教授", "");
                }

                if (name.indexOf("教授") != -1) {
                    tit += ",教授";
                    name=name.replace("教授", "");
                }

                if(name.indexOf("讲师")!=-1)
                {
                    tit+=",讲师";
                    name=name.replace("讲师","");
                }


                String avatar = form.select("p img").attr("src");
                avatar = "https://jrxy.zufe.edu.cn" + avatar;

                String introduction = form.select("div.v_news_content").text();

                System.out.println(name);
                System.out.println(avatar);
                System.out.println(introduction);
                System.out.println(tit);


                sql=con.prepareStatement("insert into t_expert (name,url,avatar,introduction,title,college) values(?,?,?,?,?,?)");
                sql.setString(1,name);
                sql.setString(2,url);
                sql.setString(3,avatar);
                sql.setString(4,introduction);
                sql.setString(5,tit);
                sql.setString(6,college);

//                sql.executeUpdate();
            }
        }


    }

    private static void Accounting() throws IOException, SQLException {

        String []urls={"cwhjx1.htm","cwhjx1/1.htm","gjhjx1.htm","gjhjx1/1.htm","cwglx1.htm","cwglx1/1.htm","sjx1.htm","sjx1/1.htm","zcpgx1.htm"};
        String []team={"财务会计系","财务会计系","国际会计系","国际会计系","财务管理系","财务管理系","审计系","审计系","资产评估系"};
        String college="会计学院";
        for(int i=0;i<9;i++) {

            String html="https://zjacc.zufe.edu.cn/szdw/"+urls[i];
            Document document = Jsoup.connect(html).timeout(1000).get();

            Elements elements = document.select("section.n_tulist ul");

            Elements elements1 = elements.select("li");

            Iterator at = elements1.iterator();
            while (at.hasNext()) {
                Element element1 = (Element) at.next();

                String url = element1.select("a").attr("href");
                while(url.indexOf("../")!=-1)
                {
                    url=url.replace("../","");

                }
                url = "https://zjacc.zufe.edu.cn/" + url;

                String avatar = "https://zjacc.zufe.edu.cn/" + element1.select("img").attr("src");

                String name = element1.text();

                Document document1 = Jsoup.connect(url).timeout(1000).get();
                String introduction = document1.select("div#vsb_content").text();

                System.out.println(name);
                System.out.println(avatar);
                System.out.println(url);
                System.out.println(introduction);

                sql=con.prepareStatement("insert into t_expert (name,url,college,avatar,introduction,team) values(?,?,?,?,?,?)" );

                sql.setString(1,name);
                sql.setString(2,url);
                sql.setString(3,college);
                sql.setString(4,avatar);
                sql.setString(5,introduction);
                sql.setString(6,team[i]);

//                sql.executeUpdate();



            }
        }



    }

    private static void Administration() throws IOException, SQLException {

        String []urls={"xzgl.htm","xzgl/1.htm","ldyshbz.htm","gcgl.htm","csgl.htm","cxgh.htm","tdzygl.htm"};
        String []subject2={"行政管理","行政管理","劳动与社会保障","工程管理","城市管理","城市规划","土地资源管理"};

        String college="公共管理学院(MPA学院)";

        for(int i=0;i<7;i++) {
            String s="https://ggxy.zufe.edu.cn/szdw/jsfc/"+urls[i];
            Document document = Jsoup.connect(s).timeout(1000).get();

            String s1 = document.toString();

            Pattern pattern1 = Pattern.compile("href=\"(\\S*)\"></a>");
            Matcher matcher = pattern1.matcher(s1);

            while(matcher.find())
            {
               String url= matcher.group(1);

               while(url.indexOf("../")!=-1)
               {
                   url=url.replace("../","");

               }
               url="https://ggxy.zufe.edu.cn/"+url;


                 Document document1 = Jsoup.connect(url).timeout(1000).get();
                Elements form = document1.select("form");

                String name = form.select("div").first().text();
                System.out.println(name);

                String img= form.select("p img").attr("src");
                img="https://ggxy.zufe.edu.cn/"+img;
                System.out.println(img);


                String introduction=form.select("p").text();
                System.out.println(introduction);

                sql=con.prepareStatement("insert into t_expert (name,subject,subject2,url,college,avatar,introduction) values (?,?,?,?,?,?,?)");

                sql.setString(1,name);
                sql.setString(2,"公共管理");
                sql.setString(3,subject2[i]);
                sql.setString(4,url);
                sql.setString(5,college);
                sql.setString(6,img);
                sql.setString(7,introduction);

//                sql.executeUpdate();

            }


        }

    }


    //财政税务学院财政系
    private static void finance1() throws IOException, SQLException {

        File file =new File("E:\\new 2.txt");
        String html= FileUtils.readFileToString(file,"utf-8");

        Document document= Jsoup.parse(html);

        Elements elements1 = document.select("a");
        Elements elements2 = document.select("span");
        Iterator it=elements2.iterator();
        String []title=new String[100];

        int i=0;
        while(it.hasNext())
        {
          Element element1 = (Element) it.next();
            title[i]= element1.text();
            i++;
        }

        Iterator at=elements1.iterator();

        i=0;
        while(at.hasNext())
        {
            Element element2=(Element)at.next();
            String url= element2.attr("href");

            url="https://cz.zufe.edu.cn/"+url.substring(url.indexOf("../")+3);
            System.out.println(url);
            String name=element2.text();

            Document document1 = Jsoup.connect(url).timeout(3000).get();

            String text = document1.text();

            if(text.indexOf("一篇")!=-1)
            text=text.substring(text.indexOf("正文")+2,text.indexOf("一篇")-1);

            else
                text=text.substring(text.indexOf("正文")+2);

            if(text.indexOf("出生年月")!=-1)
            text=text.substring(0,text.indexOf("2"))+text.substring(text.indexOf("出生年月"));





          sql=con.prepareStatement("insert into t_expert (name,introduction,title,url,college) values (?,?,?,?,?)");

          sql.setString(1,name);
          sql.setString(2,text);
          sql.setString(3,title[i]);
          sql.setString(4,url);
          sql.setString(5,"财政税务学院");

//          sql.executeUpdate();


        }




    }




}
