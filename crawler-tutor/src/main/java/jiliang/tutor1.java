package jiliang;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.*;
import java.sql.*;

public class tutor1 {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        File f = new File("E:\\shuju.txt");//指定文件
        FileOutputStream fos = new FileOutputStream(f);//创建输出流fos并以f为参数
        OutputStreamWriter osw = new OutputStreamWriter(fos);//创建字符输出流对象osw并以fos为参数
        BufferedWriter bw = new BufferedWriter(osw);//创建一个带缓冲的输出流对象bw，并以osw为参数

        tutor1 cs = new tutor1();//创建本类对象
        con = cs.getCon();

        String collegeCode[]={"机电工程学院 ","计量测试工程学院","信息工程学院","光学与电子科技学院","材料与化学学院","质量与安全工程学院","经济与管理学院","理学院","生命科学学院","法学院","艺术与传播学院","马克思主义学院","人文与外语学院"};

        for(int i=0;i<collegeCode.length;i++)
        {
            for(int j=1;j<=11;j++) {
                parsehtml(bw, collegeCode[i],j);
            }
        }

        bw.close();


    }

    static Connection con;     //声明connection对象
    static PreparedStatement sql;     //声明statement对象
    static ResultSet res;     //声明resultset对象

    public Connection getCon() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql:"
                + "//118.195.184.200:3306/crawler", "crawler", "crawler@zstu");

        return con;
    }



    public static void parsehtml(BufferedWriter bw,String collegeCode,int idx) throws IOException, SQLException {



        JSONObject parm=new JSONObject();

        String url="https://yjsb.cjlu.edu.cn/api/teacher/list";
        parm.put( "attribute",1);
        parm.put("collegeCode",collegeCode);
        parm.put("majorCode","");
        parm.put("pageNum",idx);
        parm.put("pageSize",12);
        parm.put("recruit",0);
        parm.put("research","");
        parm.put("query","");

        System.out.println(parm);
        String a=sendPost(url,parm);

        a=a.substring(a.indexOf("["),a.indexOf("]")+1);


         JSONArray jsonArray=JSONArray.parseArray(a);






        for(int i=0;i<jsonArray.size();i++)
        {
            Object object = jsonArray.get(i);
            JSONObject jsonObject1=JSONObject.parseObject( object.toString());
            System.out.println(jsonObject1);

            String id=jsonObject1.get("id").toString();

            String undfined="/%E5%85%89%E5%AD%A6%E4%B8%8E%E7%94%B5%E5%AD%90%E7%A7%91%E6%8A%80%E5%AD%A6%E9%99%A2/0";
             url="https://yjsb.cjlu.edu.cn/api/teacher/"+id+undfined;
            String parms="";
            String b=loadGET(url,parms);
            b=b.substring(b.indexOf("\"data\":")+7,b.lastIndexOf("}"));
            System.out.println(b);

            JSONObject jsonObject2 = JSONObject.parseObject(b);



            String name=jsonObject2.getString("name");
            String title=jsonObject2.getString("title");
            String college=jsonObject2.getString("department");
            String picture=null;
            if(jsonObject2.getString("picture")!=null) {
                picture = "https://yjsb.cjlu.edu.cn/api" + jsonObject2.getString("picture");
                System.out.println(picture);
            }

            String email=jsonObject2.getString("emailAddress");
            String introduction =jsonObject2.getString("individualResume")+jsonObject2.getString("researchTopic")+jsonObject2.getString("publications")+jsonObject2.getString("researchProject");
            String specialism=jsonObject2.getString("firstDiscipline1")+"|"+jsonObject2.getString("secondaryDiscipline1")+"|"+jsonObject2.getString("firstDiscipline2")+"|"+jsonObject2.getString("secondaryDiscipline2");
            String tel=jsonObject2.getString("officePhone")+"\n"+jsonObject2.getString("mobilePhone");
            String education=jsonObject2.getString("degree");
            System.out.println(name);

//            sql=con.prepareStatement("insert into t_expert (name,title,introduction,college,avatar,email,specialism,tel,education) values (?,?,?,?,?,?,?,?,?)");
//            sql.setString(1,name);
//            sql.setString(2,title);
//            sql.setString(3,introduction);
//            sql.setString(4,college);
//            sql.setString(5,picture);
//            sql.setString(6,email);
//            sql.setString(7,specialism);
//            sql.setString(8,tel);
//            sql.setString(9,education);
//
//            sql.executeUpdate();




        }





    }



    //Get请求
    public static String loadGET(String url,String param){
        StringBuilder json = new StringBuilder();
        BufferedReader in = null;
        try {
            String getUrl = url + "?" + param;
            URL requestUrl = new URL(getUrl);
            //打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
            //请求方式
            connection.setRequestMethod("GET");
            //设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            //建立实际的连接
            connection.connect();
            //定义BufferReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
        } catch (MalformedURLException e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("status","401");
            e.printStackTrace();
            return jsonObject.toJSONString();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return json.toString();
    }


    //java实现post请求
    public static String sendPost(String url, JSONObject param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);

            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "application/json, text/plain, */*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Content-Type","application/json;charset=UTF-8");
            conn.setRequestProperty("user-agent",
                    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);

            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());


            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
}

