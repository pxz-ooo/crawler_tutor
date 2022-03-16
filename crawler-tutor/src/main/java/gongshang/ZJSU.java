package gongshang;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.sql.SQLException;
import java.util.Iterator;

public class ZJSU {
    //会计学院
//    public static void main(String[] args) throws IOException, SQLException {
//
//        File f = new File("E:\\shuju.txt");//指定文件
//        FileOutputStream fos = new FileOutputStream(f);//创建输出流fos并以f为参数
//        OutputStreamWriter osw = new OutputStreamWriter(fos);//创建字符输出流对象osw并以fos为参数
//        BufferedWriter bw = new BufferedWriter(osw);//创建一个带缓冲的输出流对象bw，并以osw为参数
//
//
//        //解析url地址,第一个参数为访问的url,第二个参数为超时时间
//        Document doc = Jsoup.connect("http://econet.zjgsu.edu.cn/List-20-Page-1.html").timeout(5000).get();
//
//        //提取正文部分
//        Elements elements1 = doc.select("li div");
//
//
//
//
//        //使用迭代器遍历elements
//        Iterator it = elements1.iterator();
//
//        bw.write("create_time|avatar|url|name|introduction");
//        bw.newLine();
//        while (it.hasNext()) {
//            Element element1 = (Element) it.next();
//
//            Elements elements2 = element1.select("a");
//            System.out.println(elements2);
//
//            Iterator at = elements2.iterator();
//
//
//            while (at.hasNext()) {
//                Element element2 = (Element) at.next();
//                //取出href中的值
//                String url ="http://econet.zjgsu.edu.cn/"+ element2.attr("href");
//
//                System.out.println(url);
//                String name=element2.text();
//                System.out.println(name);
//
//                String img="http://econet.zjgsu.edu.cn/"+element1.select("img").attr("src");
//                System.out.println(img);
//                if(getcode(url))
//                {
//                    doc=Jsoup.connect(url).timeout(5000).get();
//                    Element element = doc.select("div.wp_articlecontent").first();
//                    String text=element.text();
//                    System.out.println(text);
//
//
//
//                    String create_time=doc.select("div.clear.r_content.fz16 div").first().text();
//                    create_time=create_time.substring(create_time.indexOf("发布日期：")+5,create_time.indexOf("阅读"));
//                    System.out.println(create_time);
//
//                    bw.write(create_time+"|"+img+"|"+url+"|"+name+"|"+text);
//                    bw.newLine();
//                }
//
//            }
//
//        }
//
//
//        bw.close();
//    }
//
//
//
//
//
//    private static boolean getcode(String url) throws IOException {
//        // 1. 打开浏览器, 创建 HttpClient 对象
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//
//        // 2. 输入网址, 发起get请求创建HttpGet对象
//        HttpGet httpGet = new HttpGet(url);
//
//        // 3. 按回车, 发起请求, 返回响应
//        CloseableHttpResponse response = httpClient.execute(httpGet);
//
//        // 4. 解析响应, 获取数据
//        // 判断状态码是否是 200
//        if (response.getStatusLine().getStatusCode() == 200)
//            return true;
//        else return false;
//
//
//    }
}



    //经济学院
//    public static void main(String[] args) throws IOException, SQLException {
//
//        File f = new File("E:\\shuju.txt");//指定文件
//        FileOutputStream fos = new FileOutputStream(f);//创建输出流fos并以f为参数
//        OutputStreamWriter osw = new OutputStreamWriter(fos);//创建字符输出流对象osw并以fos为参数
//        BufferedWriter bw = new BufferedWriter(osw);//创建一个带缓冲的输出流对象bw，并以osw为参数
//
//
//        //解析url地址,第一个参数为访问的url,第二个参数为超时时间
//        Document doc = Jsoup.connect("http://econet.zjgsu.edu.cn/List-78.html").timeout(5000).get();
//
//        //提取正文部分
//        Elements elements1 = doc.select("ul.tw-list");
//
//
//
//
//
//        //使用迭代器遍历elements
//        Iterator it = elements1.iterator();
//
//        bw.write("create_time|avatar|url|name|introduction|title");
//        bw.newLine();
//        String title="副教授";
//        while (it.hasNext()) {
//            Element element1 = (Element) it.next();
//
//            Elements elements2 = element1.select("a");
//            System.out.println(elements2);
//
//            Iterator at = elements2.iterator();
//
//
//            while (at.hasNext()) {
//                Element element2 = (Element) at.next();
//                //取出href中的值
//                String url ="http://econet.zjgsu.edu.cn/"+ element2.attr("href");
//
//                System.out.println(url);
//                String name=element2.text();
//                System.out.println(name);
//
//                String img="http://econet.zjgsu.edu.cn/"+element1.select("img").attr("src");
//                System.out.println(img);
//                if(getcode(url))
//                {
//                    doc=Jsoup.connect(url).timeout(5000).get();
//                    Elements elements = doc.select("div.clear div.fl");
//                    String text=elements.text();
//                    text= text.substring(text.indexOf("专业教师")+6);
//                    System.out.println(text);
//
//
//
//                    String create_time=doc.select("div.clear.r_content.fz16 div").first().text();
//                    create_time=create_time.substring(create_time.indexOf("发布日期：")+5,create_time.indexOf("阅读"));
//                    System.out.println(create_time);
//
//                    bw.write(create_time+"|"+img+"|"+url+"|"+name+"|"+text+"|"+title);
//                    bw.newLine();
//                }
//
//            }
//
//        }
//
//
//        bw.close();
//    }
//
//
//
//
//
//    private static boolean getcode(String url) throws IOException {
//        // 1. 打开浏览器, 创建 HttpClient 对象
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//
//        // 2. 输入网址, 发起get请求创建HttpGet对象
//        HttpGet httpGet = new HttpGet(url);
//
//        // 3. 按回车, 发起请求, 返回响应
//        CloseableHttpResponse response = httpClient.execute(httpGet);
//
//        // 4. 解析响应, 获取数据
//        // 判断状态码是否是 200
//        if (response.getStatusLine().getStatusCode() == 200)
//            return true;
//        else return false;
//
//
//    }


    //金融学院
//    public static void main(String[] args) throws IOException, SQLException {
//
//        File f = new File("E:\\shuju.txt");//指定文件
//        FileOutputStream fos = new FileOutputStream(f);//创建输出流fos并以f为参数
//        OutputStreamWriter osw = new OutputStreamWriter(fos);//创建字符输出流对象osw并以fos为参数
//        BufferedWriter bw = new BufferedWriter(osw);//创建一个带缓冲的输出流对象bw，并以osw为参数
//
//
//        //解析url地址,第一个参数为访问的url,第二个参数为超时时间
//        Document doc = Jsoup.connect("http://jrxy.zjgsu.edu.cn/jrweb/teacher_1_1_2.htm").timeout(5000).get();
//
//        //提取正文部分
//        Elements elements1 = doc.select("div.r_content.fz16");
//        System.out.println(elements1);
//
//
//
//
//        //使用迭代器遍历elements
//        Iterator it = elements1.iterator();
//
//        bw.write("avatar|url|name|introduction");
//        bw.newLine();
//        String title="副教授";
//        while (it.hasNext()) {
//            Element element1 = (Element) it.next();
//
//            Elements elements2 = element1.select("a");
//            System.out.println(elements2);
//
//            Iterator at = elements2.iterator();
//
//
//            while (at.hasNext()) {
//                Element element2 = (Element) at.next();
//                //取出href中的值
//                String url ="http://jrxy.zjgsu.edu.cn"+ element2.attr("href");
//
//                System.out.println(url);
//                String name=element2.text();
//                System.out.println(name);
//
//                String img="http://jrxy.zjgsu.edu.cn"+element1.select("img").attr("src");
//                System.out.println(img);
//                if(getcode(url))
//                {
//                    doc=Jsoup.connect(url).timeout(5000).get();
//                    Elements elements = doc.select("div.t-right");
//                    String text=elements.text();
//                    System.out.println(text);
//
//                    bw.write(img+"|"+url+"|"+name+"|"+text);
//                    bw.newLine();
//                }
//
//            }
//
//        }
//
//
//        bw.close();
//    }
//
//
//
//
//
//    private static boolean getcode(String url) throws IOException {
//        // 1. 打开浏览器, 创建 HttpClient 对象
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//
//        // 2. 输入网址, 发起get请求创建HttpGet对象
//        HttpGet httpGet = new HttpGet(url);
//
//        // 3. 按回车, 发起请求, 返回响应
//        CloseableHttpResponse response = httpClient.execute(httpGet);
//
//        // 4. 解析响应, 获取数据
//        // 判断状态码是否是 200
//        if (response.getStatusLine().getStatusCode() == 200)
//            return true;
//        else return false;
//
//
//    }




    //信息与电子学院
//    public static void main(String[] args) throws IOException, SQLException {
//
//        File f = new File("E:\\shuju.txt");//指定文件
//        FileOutputStream fos = new FileOutputStream(f);//创建输出流fos并以f为参数
//        OutputStreamWriter osw = new OutputStreamWriter(fos);//创建字符输出流对象osw并以fos为参数
//        BufferedWriter bw = new BufferedWriter(osw);//创建一个带缓冲的输出流对象bw，并以osw为参数
//
//
//        //解析url地址,第一个参数为访问的url,第二个参数为超时时间
//        Document doc = Jsoup.connect("http://iee.zjgsu.edu.cn/list/?33_2.html").timeout(5000).get();
//
//        //提取正文部分
//        Elements elements1 = doc.select("div.col-main");
//        System.out.println(elements1);
//
//
//
//
//        //使用迭代器遍历elements
//        Iterator it = elements1.iterator();
//
//        bw.write("avatar|url|name|introduction");
//        bw.newLine();
//
//        while (it.hasNext()) {
//            Element element1 = (Element) it.next();
//
//            Elements elements2 = element1.select("div.col-list a");
//
//
//            Iterator at = elements2.iterator();
//
//
//            while (at.hasNext()) {
//                Element element2 = (Element) at.next();
//                //取出href中的值
//                String url =element2.attr("onclick");
//                url=url.substring(url.indexOf("(")+2,url.indexOf(")")-1);
//                url="http://iee.zjgsu.edu.cn"+url;
//                System.out.println(url);
//
//
//                String name=element2.text();
//                System.out.println(name);
//
//                String img=element2.select("img").attr("src");
//                System.out.println(img);
//
//
//                doc = Jsoup.connect(url).timeout(5000).get();
//                Elements elements = doc.select("div.sn_text");
//                String text = elements.text();
//                System.out.println(text);
//
//
//
//                bw.write(img+"|"+url + "|" + name + "|" + text );
//                bw.newLine();
//
//
//
//
//            }
//
//        }
//
//
//        bw.close();
//    }


    //计算机与信息工程学院
//    public static void main(String[] args) throws IOException, SQLException {
//
//        File f = new File("E:\\shuju.txt");//指定文件
//        FileOutputStream fos = new FileOutputStream(f);//创建输出流fos并以f为参数
//        OutputStreamWriter osw = new OutputStreamWriter(fos);//创建字符输出流对象osw并以fos为参数
//        BufferedWriter bw = new BufferedWriter(osw);//创建一个带缓冲的输出流对象bw，并以osw为参数
//
//
//        //解析url地址,第一个参数为访问的url,第二个参数为超时时间
//        Document doc = Jsoup.connect("http://scie.zjgsu.edu.cn/zh-hans/%E7%A1%95%E5%AF%BC%E5%90%8D%E5%BD%95").timeout(5000).get();
//
//        //提取正文部分
//        Elements elements1 = doc.select("div.views-view-grid.horizontal.cols-4.clearfix");
//
//
//        //使用迭代器遍历elements
//        Iterator it = elements1.iterator();
//
//        bw.write("avatar|url|introduction");
//        bw.newLine();
//
//        while (it.hasNext()) {
//            Element element1 = (Element) it.next();
//
//            Elements elements2 = element1.select("div.field-content a");
//
//
//            Iterator at = elements2.iterator();
//
//
//            while (at.hasNext()) {
//                Element element2 = (Element) at.next();
//                //取出href中的值
//                String url =element2.attr("href");
//                url="http://scie.zjgsu.edu.cn"+url;
//                System.out.println(url);
//
//
//
//
//                String img=element2.select("img").attr("src");
//                img="http://scie.zjgsu.edu.cn"+img;
//                System.out.println(img);
//
//
//                doc = Jsoup.connect(url).timeout(5000).get();
//                Elements elements = doc.select("div.node__content");
//                String text = elements.text();
//                System.out.println(text);
//
//
//
//                bw.write(img+"|"+url + "|"  + text );
//                bw.newLine();
//
//
//
//
//            }
//
//        }
//
//
//        bw.close();
//    }


//    //管理工程与电子商务学院
//    public static void main(String[] args) throws IOException, SQLException {
//
//        File f = new File("E:\\shuju.txt");//指定文件
//        FileOutputStream fos = new FileOutputStream(f);//创建输出流fos并以f为参数
//        OutputStreamWriter osw = new OutputStreamWriter(fos);//创建字符输出流对象osw并以fos为参数
//        BufferedWriter bw = new BufferedWriter(osw);//创建一个带缓冲的输出流对象bw，并以osw为参数
//
//
//        //解析url地址,第一个参数为访问的url,第二个参数为超时时间
//        Document doc = Jsoup.connect("https://sme.zjgsu.edu.cn/292/list.htm").timeout(5000).get();
//
//        //提取正文部分
//        Elements elements1 = doc.select("div#wp_news_w9");
//
//
//        //使用迭代器遍历elements
//        Iterator it = elements1.iterator();
//
//        bw.write("date|name|avatar|url|introduction");
//        bw.newLine();
//
//        while (it.hasNext()) {
//            Element element1 = (Element) it.next();
//
//            Elements elements2 = element1.select("tr td span.Article_MicroImage a");
//
//
//            Iterator at = elements2.iterator();
//
//
//            while (at.hasNext()) {
//                Element element2 = (Element) at.next();
//                //取出href中的值
//                String url =element2.attr("href");
//                url="https://sme.zjgsu.edu.cn"+url;
//                System.out.println(url);
//
//
//
//
//                String img=element2.select("img").attr("src");
//                img="https://sme.zjgsu.edu.cn"+img;
//                System.out.println(img);
//
//                String name=element2.attr("title");
//                System.out.println(name);
//
//
//                doc = Jsoup.connect(url).timeout(5000).get();
//
//                String date=doc.select("p.arti-metas").text();
//                date=date.substring(date.indexOf("发布时间：")+5,date.indexOf("浏览次数"));
//                System.out.println(date);
//
//                Elements elements = doc.select("div.wp_articlecontent");
//                String text = elements.text();
//                System.out.println(text);
//
//
//
//                bw.write(date+"|"+name+"|"+img+"|"+url + "|"  + text );
//                bw.newLine();
//
//
//
//
//            }
//
//        }
//
//
//        bw.close();
//    }


//    //法学院
//    public static void main(String[] args) throws IOException, SQLException {
//
//        File f = new File("E:\\shuju.txt");//指定文件
//        FileOutputStream fos = new FileOutputStream(f);//创建输出流fos并以f为参数
//        OutputStreamWriter osw = new OutputStreamWriter(fos);//创建字符输出流对象osw并以fos为参数
//        BufferedWriter bw = new BufferedWriter(osw);//创建一个带缓冲的输出流对象bw，并以osw为参数
//
//
//        //解析url地址,第一个参数为访问的url,第二个参数为超时时间
//        Document doc = Jsoup.connect("http://law.zjgsu.edu.cn/List-25.html").timeout(5000).get();
//
//        //提取正文部分
//        Elements elements1 = doc.select("ul li");
//
//
//        //使用迭代器遍历elements
//        Iterator it = elements1.iterator();
//
//        bw.write("create_time|name|avatar|url|introduction|subject2|college");
//        bw.newLine();
//
//        String subject2="知识产权法学";
//        String college="法学院(知识产权学院)";
//        while (it.hasNext()) {
//            Element element1 = (Element) it.next();
//
//            Elements elements2 = element1.select("span.fl a");
//
//
//            Iterator at = elements2.iterator();
//
//
//            while (at.hasNext()) {
//                Element element2 = (Element) at.next();
//                //取出href中的值
//                String url =element2.attr("href");
//                url="http://law.zjgsu.edu.cn/"+url;
//                System.out.println(url);
//
//
//                String name=element2.text();
//                System.out.println(name);
//                String date=element1.select("span.fr").text();
//                System.out.println(date);
//
//                doc = Jsoup.connect(url).timeout(5000).get();
//
//                Elements elements = doc.select("div.clear.p30");
//                String text = elements.text();
//                System.out.println(text);
//
//                String img=elements.select("p img").attr("src");
//                System.out.println(img);
//
//                bw.write(date+"|"+name+"|"+img+"|"+url + "|"  + text+"|"+subject2+"|"+college );
//                bw.newLine();
//
//
//
//
//            }
//
//        }
//
//
//        bw.close();
//    }

    //外国语学院
//    public static void main(String[] args) throws IOException, SQLException {
//
//        File f = new File("E:\\shuju.txt");//指定文件
//        FileOutputStream fos = new FileOutputStream(f);//创建输出流fos并以f为参数
//        OutputStreamWriter osw = new OutputStreamWriter(fos);//创建字符输出流对象osw并以fos为参数
//        BufferedWriter bw = new BufferedWriter(osw);//创建一个带缓冲的输出流对象bw，并以osw为参数
//
//
//        //解析url地址,第一个参数为访问的url,第二个参数为超时时间
//        Document doc = Jsoup.connect("http://flc.zjgsu.edu.cn/list/?37_4.html").timeout(5000).get();
//
//        //提取正文部分
//        Elements elements1 = doc.select("div.col-list");
//        System.out.println(elements1);
//
//        //使用迭代器遍历elements
//        Iterator it = elements1.iterator();
//
//        bw.write("name|avatar|url|introduction|college|email");
//        bw.newLine();
//
//
//        String college="外国语学院";
//        while (it.hasNext()) {
//            Element element1 = (Element) it.next();
//
//            Elements elements2 = element1.select("ul li a");
//
//
//            Iterator at = elements2.iterator();
//
//
//            while (at.hasNext()) {
//                Element element2 = (Element) at.next();
//                //取出href中的值
//                String url =element2.attr("onclick");
//                url=url.substring(url.indexOf("(")+2,url.indexOf(")")-2);
//                url="http://flc.zjgsu.edu.cn"+url;
//                System.out.println(url);
//
//                String img=element2.select("img").attr("src");
//                img="http://flc.zjgsu.edu.cn/"+img;
//                System.out.println(img);
//                String name=element2.text();
//
//
//
//                doc = Jsoup.connect(url).timeout(5000).get();
//
//                Elements elements = doc.select("div.sn_text");
//                String text = elements.text();
//                System.out.println(text);
//                String email=null;
//                if(text.indexOf("电子邮箱")!=-1)
//                {
//                    email=text.substring(text.indexOf("电子邮箱：")+5);
//                }
//                System.out.println(email);
//
//
//
//                bw.write(name+"|"+img+"|"+url + "|"  + text+"|"+college+"|"+email );
//                bw.newLine();
//
//
//
//
//            }
//
//        }
//
//
//        bw.close();
//    }