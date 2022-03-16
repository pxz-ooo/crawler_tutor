package hdun;

import org.apache.http.client.ClientProtocolException;
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

public class hdu {



    //电子信息学院
//    public static void main(String[] args) throws IOException, SQLException {
//
//        File f = new File("E:\\shuju.txt");//指定文件
//        FileOutputStream fos = new FileOutputStream(f);//创建输出流fos并以f为参数
//        OutputStreamWriter osw = new OutputStreamWriter(fos);//创建字符输出流对象osw并以fos为参数
//        BufferedWriter bw = new BufferedWriter(osw);//创建一个带缓冲的输出流对象bw，并以osw为参数
//
//
//        //解析url地址,第一个参数为访问的url,第二个参数为超时时间
//        Document doc = Jsoup.connect("http://elec.hdu.edu.cn/sdjj/list.htm").timeout(5000).get();
//        //提取正文部分
//        Elements elements1 = doc.select(" table.wp_editor_art_table");
//
//
//        //使用迭代器遍历elements
//        Iterator it = elements1.iterator();
//        int i = 0;
//      bw.write("create_time?url?avatar?name?text");
//        bw.newLine();
//        while (it.hasNext()) {
//            Element element1 = (Element) it.next();
//
//            Elements elements2 = element1.select("tbody>tr a");
//
//
//            Iterator at = elements2.iterator();
//
//
//            while (at.hasNext()) {
//                Element element2 = (Element) at.next();
//                //取出href中的值
//                String url = element2.attr("href");
//
//
//                //判断url网页的状态码是否是200，如果是继续下一步操作
//                if (getcode(url)) {
//
//                    //解析url地址
//                     doc = Jsoup.connect(url).timeout(5000).get();
//                    Element element3 = doc.select("div.article").first();
//
//
//
//
//
//                    String text=parsetext(element3,url);
//
//                     bw.write(parsedate(url)+"?"+url+"?"+parseimg(element3,url)+"?"+parsename(element3,url)+"?"+parsetext(element3,url));
//                      bw.newLine();
//
//
//                }
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
//    private static String parsedate(String url) {
//        String date= url.substring(url.indexOf("cn/")+3,url.indexOf("cn/")+12);
//         date=date.substring(0,date.indexOf("/"))+"-"+date.substring(date.indexOf("/")+1,date.indexOf("/")+3)+"-"+date.substring(date.indexOf("/")+3);
//        return date;
//    }
//
//    private static String parsetext(Element element3, String url) {
//        Elements elements = element3.select("p");
//        String text1 = elements.text();
//        text1= text1.substring(text1.indexOf("浏览次数")+9);
//        return text1;
//
//    }
//
//    private static String parseimg(Element element3, String url) {
//        String p_img = element3.select("p img").attr("src");
//        p_img="http://elec.hdu.edu.cn/"+p_img;
//        return p_img;
//    }
//
//    private static String parsename(Element element3,String url) throws IOException {
//             String name = element3.select("h1.arti_title").text();
//        System.out.println(name);
//             return name;
//        }
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


    //机械工程学院
//    public static void main(String[] args) throws IOException, SQLException {
//
//        File f = new File("E:\\shuju.txt");//指定文件
//        FileOutputStream fos = new FileOutputStream(f);//创建输出流fos并以f为参数
//        OutputStreamWriter osw = new OutputStreamWriter(fos);//创建字符输出流对象osw并以fos为参数
//        BufferedWriter bw = new BufferedWriter(osw);//创建一个带缓冲的输出流对象bw，并以osw为参数
//
//
//        //解析url地址,第一个参数为访问的url,第二个参数为超时时间
//        Document doc = Jsoup.connect("http://mechanical.hdu.edu.cn/dsjj/list.htm").timeout(5000).get();
//        //提取正文部分
//        Elements elements1 = doc.select("div#wp_content_w6_0.paging_content");
//
//
//        //使用迭代器遍历elements
//        Iterator it = elements1.iterator();
//        int i = 0;
//        bw.write("create_time?url?avatar?name?introduction?work");
//        bw.newLine();
//        while (it.hasNext()) {
//            Element element1 = (Element) it.next();
//
//            Elements elements2 = element1.select("p a");
//
//
//            Iterator at = elements2.iterator();
//
//
//            while (at.hasNext()) {
//                Element element2 = (Element) at.next();
//                //取出href中的值
//                String url = element2.attr("href");
//
//
//                //判断url网页的状态码是否是200，如果是继续下一步操作
//                if (getcode(url)) {
//
//                    //解析url地址
//                    doc = Jsoup.connect(url).timeout(5000).get();
//                    Element element3 = doc.select("div.article").first();
//
//
//                    String text=parsetext(element3,url);
//
//                      String introduce =null;
//                      String work=null;
//
//                    if(text.indexOf("学术")!=-1) {
//                        introduce = text.substring(text.indexOf("个人") + 4, text.indexOf("学术") - 2);
//                        work=text.substring(text.indexOf("学术")+4);
//
//                    }
//                    bw.write(parsedate(url)+"?"+url+"?"+parseimg(element3,url)+"?"+parsename(element3,url)+"?"+introduce+"?"+work);
//                    bw.newLine();
//
//
//                }
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
//    private static String parsedate(String url) {
//        String date= url.substring(url.indexOf("cn/")+3,url.indexOf("cn/")+12);
//        date=date.substring(0,date.indexOf("/"))+"-"+date.substring(date.indexOf("/")+1,date.indexOf("/")+3)+"-"+date.substring(date.indexOf("/")+3);
//        return date;
//    }
//
//    private static String parsetext(Element element3, String url) {
//        Elements elements = element3.select("p");
//        String text1 = elements.text();
//        text1= text1.substring(text1.indexOf("浏览次数")+9);
//        return text1;
//
//    }
//
//    private static String parseimg(Element element3, String url) {
//        String p_img = element3.select("p img").attr("src");
//        p_img="http://elec.hdu.edu.cn/"+p_img;
//        return p_img;
//    }
//
//    private static String parsename(Element element3,String url) throws IOException {
//        String name = element3.select("h1.arti_title").text();
//        return name;
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


    //计算机学院
//    public static void main(String[] args) throws IOException, SQLException {
//
//        File f = new File("E:\\shuju.txt");//指定文件
//        FileOutputStream fos = new FileOutputStream(f);//创建输出流fos并以f为参数
//        OutputStreamWriter osw = new OutputStreamWriter(fos);//创建字符输出流对象osw并以fos为参数
//        BufferedWriter bw = new BufferedWriter(osw);//创建一个带缓冲的输出流对象bw，并以osw为参数
//
//
//        //解析url地址,第一个参数为访问的url,第二个参数为超时时间
//        Document doc = Jsoup.connect("http://computer.hdu.edu.cn/6757/list2.htm").timeout(5000).get();
//
//        //提取正文部分
//        Elements elements1 = doc.select(" table.wp_article_list_table>tbody");
//
//
//        //使用迭代器遍历elements
//        Iterator it = elements1.iterator();
//        int i = 0;
//        bw.write("create_time?url?avatar?name?introduction?subject?specialism");
//        bw.newLine();
//        while (it.hasNext()) {
//            Element element1 = (Element) it.next();
//
//            Elements elements2 = element1.select("span.Article_MicroImage a");
//
//            Iterator at = elements2.iterator();
//
//            while (at.hasNext()) {
//                Element element2 = (Element) at.next();
//
//
//                //取出href中的值
//                String url = "http://computer.hdu.edu.cn/"+element2.attr("href");
//                String name=element2.attr("title");
//                String img="http://computer.hdu.edu.cn/"+element2.select("img").attr("src");
//
//
//                System.out.println(url);
//                //判断url网页的状态码是否是200，如果是继续下一步操作
//                if (getcode(url)) {
//
//                    //解析url地址
//                    doc = Jsoup.connect(url).timeout(5000).get();
//                    Element element3 = doc.select("div.article").first();
//
//
//                    String text=parsetext(element3,url);
//                    String subject=null;
//                    String specialism=null;
//
//                    subject=text.substring(0,text.indexOf(" "));
//                    text=text.substring(subject.length()+1);
//
//                    if(text.indexOf(" ")!=-1) {
//                        specialism = text.substring(0, text.indexOf(" "));
//                        text = text.substring(specialism.length() + 1);
//                        System.out.println(text);
//                    }
//
//                    bw.write(parsedate(url)+"?"+url+"?"+img+"?"+name+"?"+text+"?"+subject+"?"+specialism);
//                    bw.newLine();
//
//
//                }
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
//    private static String parsedate(String url) {
//        String date= url.substring(url.indexOf("cn/")+4,url.indexOf("cn/")+13);
//        date=date.substring(0,date.indexOf("/"))+"-"+date.substring(date.indexOf("/")+1,date.indexOf("/")+3)+"-"+date.substring(date.indexOf("/")+3);
//        System.out.println(date);
//        return date;
//    }
//
//    private static String parsetext(Element element3, String url) {
//        Elements elements = element3.select("div.wp_articlecontent");
//
//        String text1 = elements.text();
//
//        return text1;
//
//    }
//
//    private static String parseimg(Element element3, String url) {
//        String p_img = element3.select("p img").attr("src");
//        p_img="http://elec.hdu.edu.cn/"+p_img;
//        return p_img;
//    }
//
//    private static String parsename(Element element3,String url) throws IOException {
//        String name = element3.select("h1.arti_title").text();
//        return name;
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


   //通信工程学院
//    public static void main(String[] args) throws IOException, SQLException , ClientProtocolException {
//
//        File f = new File("E:\\shuju.txt");//指定文件
//        FileOutputStream fos = new FileOutputStream(f);//创建输出流fos并以f为参数
//        OutputStreamWriter osw = new OutputStreamWriter(fos);//创建字符输出流对象osw并以fos为参数
//        BufferedWriter bw = new BufferedWriter(osw);//创建一个带缓冲的输出流对象bw，并以osw为参数
//
//
//        //硕士生导师http://comm.hdu.edu.cn/2018/0528/c2749a71800/page.htm
//        //博士生导师http://comm.hdu.edu.cn/2021/1108/c2749a138051/page.htm
//        //解析url地址,第一个参数为访问的url,第二个参数为超时时间
//        Document doc = Jsoup.connect("http://comm.hdu.edu.cn/2018/0528/c2749a71800/page.htm").timeout(5000).get();
//        //提取正文部分
//        Elements elements1 = doc.select(" tbody>tr");
//
//
//        //使用迭代器遍历elements
//        Iterator it = elements1.iterator();
//        int i = 0;
//        bw.write("create_time?url?avatar?name?introduction");
//        bw.newLine();
//        while (it.hasNext()) {
//            Element element1 = (Element) it.next();
//
//            Elements elements2 = element1.select("tr a");
//
//            Iterator at = elements2.iterator();
//
//            while (at.hasNext()) {
//                Element element2 = (Element) at.next();
//                //取出href中的值
//                String url = element2.attr("href");
//                System.out.println(element2);
//
//                String name=element2.attr("title");
//                System.out.println(name);
//
//                //判断url网页的状态码是否是200，如果是继续下一步操作
//                if(!url.equals("http://zhanqun.hdu.edu.cn/_s70/2021/1109/c2866a138085/page.psp")&&!url.equals("http://comm.hdu.edu.cn/comm.hdu.edu.cn/_s70/2021/1202/c2866a138876/page.psp")) {
//                    if (getcode(url)) {
//
//                        //解析url地址
//                        doc = Jsoup.connect(url).timeout(5000).get();
//                        Element element3 = doc.select("div.wp_articlecontent").first();
//
//
//                        String text = parsetext(element3, url);
//
//                        bw.write(parsedate(url) + "?" + url + "?" + parseimg(element3, url) + "?" + name+ "?" + parsetext(element3, url));
//                        bw.newLine();
//
//
//                    }
//                }
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
//    private static String parsedate(String url) {
//        String date= url.substring(url.indexOf("cn/")+3,url.indexOf("cn/")+12);
//        date=date.substring(0,date.indexOf("/"))+"-"+date.substring(date.indexOf("/")+1,date.indexOf("/")+3)+"-"+date.substring(date.indexOf("/")+3);
//
//        return date;
//    }
//
//    private static String parsetext(Element element3, String url) {
//        Elements elements = element3.select("p");
//        String text1 = elements.text();
//
//        return text1;
//
//    }
//
//    private static String parseimg(Element element3, String url) {
//        String p_img = element3.select("p img").attr("src");
//        p_img="http://elec.hdu.edu.cn/"+p_img;
//
//        return p_img;
//    }
//
//    private static String parsename(Element element3,String url) throws IOException {
//        String name = element3.select("h1.arti_title").text();
//
//        return name;
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


    //自动化学院
//    public static void main(String[] args) throws IOException, SQLException , ClientProtocolException {
//
//        File f = new File("E:\\shuju.txt");//指定文件
//        FileOutputStream fos = new FileOutputStream(f);//创建输出流fos并以f为参数
//        OutputStreamWriter osw = new OutputStreamWriter(fos);//创建字符输出流对象osw并以fos为参数
//        BufferedWriter bw = new BufferedWriter(osw);//创建一个带缓冲的输出流对象bw，并以osw为参数
//
//
//
//        //解析url地址,第一个参数为访问的url,第二个参数为超时时间
//        Document doc = Jsoup.connect("http://auto.hdu.edu.cn/3752/list.htm").timeout(5000).get();
//        //提取正文部分
//        Elements elements1 = doc.select("div.wp_articlecontent");
//
//
//
//        //使用迭代器遍历elements
//        Iterator it = elements1.iterator();
//        int i = 0;
//        bw.write("create_time?url?avatar?name?introduction");
//        bw.newLine();
//        while (it.hasNext()) {
//            Element element1 = (Element) it.next();
//
//            Elements elements2 = element1.select("table>tbody>tr>td>a");
//
//            Iterator at = elements2.iterator();
//
//            while (at.hasNext()) {
//                Element element2 = (Element) at.next();
//                //取出href中的值
//                String url = element2.attr("href");
//                String name=element2.text();
//                System.out.println(name);
//                //判断url网页的状态码是否是200，如果是继续下一步操作
//
//                if (getcode(url)) {
//
//                    //解析url地址
//                    doc = Jsoup.connect(url).timeout(5000).get();
//                    Element element3 = doc.select("div.wp_articlecontent").first();
//
//
//                    bw.write(parsedate(url) + "?" + url + "?" + parseimg(element3, url) + "?" + name + "?" + parsetext(element3, url));
//                    bw.newLine();
//
//
//
//
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
//    private static String parsedate(String url) {
//        String date= url.substring(url.indexOf("cn/")+3,url.indexOf("cn/")+12);
//        date=date.substring(0,date.indexOf("/"))+"-"+date.substring(date.indexOf("/")+1,date.indexOf("/")+3)+"-"+date.substring(date.indexOf("/")+3);
//
//        return date;
//    }
//
//    private static String parsetext(Element element3, String url) {
//        Elements elements = element3.select("p");
//        String text1 = elements.text();
//
//        return text1;
//
//    }
//
//    private static String parseimg(Element element3, String url) {
//        String p_img = element3.select("p img").attr("src");
//        p_img="http://auto.hdu.edu.cn/"+p_img;
//
//
//        return p_img;
//    }
//
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


    //材料与环境工程学院
//    public static void main(String[] args) throws IOException, SQLException , ClientProtocolException {
//
//        File f = new File("E:\\shuju.txt");//指定文件
//        FileOutputStream fos = new FileOutputStream(f);//创建输出流fos并以f为参数
//        OutputStreamWriter osw = new OutputStreamWriter(fos);//创建字符输出流对象osw并以fos为参数
//        BufferedWriter bw = new BufferedWriter(osw);//创建一个带缓冲的输出流对象bw，并以osw为参数
//
//
//
//        //解析url地址,第一个参数为访问的url,第二个参数为超时时间
//        Document doc = Jsoup.connect("http://cmee.hdu.edu.cn/4759/list.htm").timeout(5000).get();
//        //提取正文部分
//        Elements elements1 = doc.select("ul.news_list.list2");
//        System.out.println(elements1);
//
//
//        //使用迭代器遍历elements
//        Iterator it = elements1.iterator();
//        int i = 0;
//        bw.write("create_time?url?avatar?name?introduction");
//        bw.newLine();
//        while (it.hasNext()) {
//            Element element1 = (Element) it.next();
//
//            Elements elements2 = element1.select("a");
//
//            Iterator at = elements2.iterator();
//
//            while (at.hasNext()) {
//                Element element2 = (Element) at.next();
//                //取出href中的值
//                String url = "http://cmee.hdu.edu.cn/"+element2.attr("href");
//                String name=element2.attr("title");
//                System.out.println(url);
//                System.out.println(name);
//                //判断url网页的状态码是否是200，如果是继续下一步操作
//
//                if (getcode(url)) {
//
//                    //解析url地址
//                    doc = Jsoup.connect(url).timeout(5000).get();
//                    Element element3 = doc.select("div.wp_articlecontent").first();
//
//
//                    bw.write(parsedate(url) + "?" + url + "?" + parseimg(element3, url) + "?" + name + "?" + parsetext(element3, url));
//                    bw.newLine();
//
//
//
//
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
//    private static String parsedate(String url) {
//        String date= url.substring(url.indexOf("cn/")+4,url.indexOf("cn/")+13);
//        date=date.substring(0,date.indexOf("/"))+"-"+date.substring(date.indexOf("/")+1,date.indexOf("/")+3)+"-"+date.substring(date.indexOf("/")+3);
//        System.out.println(date);
//        return date;
//    }
//
//    private static String parsetext(Element element3, String url) {
//        Elements elements = element3.select("p");
//        String text1 = elements.text();
//
//        return text1;
//
//    }
//
//    private static String parseimg(Element element3, String url) {
//        String p_img = element3.select("p img").attr("src");
//        p_img="http://cmee.hdu.edu.cn/"+p_img;
//
//
//        return p_img;
//    }
//
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


    //经济学院
//    public static void main(String[] args) throws IOException, SQLException , ClientProtocolException {
//
//        File f = new File("E:\\shuju.txt");//指定文件
//        FileOutputStream fos = new FileOutputStream(f);//创建输出流fos并以f为参数
//        OutputStreamWriter osw = new OutputStreamWriter(fos);//创建字符输出流对象osw并以fos为参数
//        BufferedWriter bw = new BufferedWriter(osw);//创建一个带缓冲的输出流对象bw，并以osw为参数
//
//
//
//        //解析url地址,第一个参数为访问的url,第二个参数为超时时间
//        Document doc = Jsoup.connect("http://economics.hdu.edu.cn/2470/list.htm").timeout(5000).get();
//        //提取正文部分
//        Elements elements1 = doc.select("div#wp_news_w24");
//
//
//
//        //使用迭代器遍历elements
//        Iterator it = elements1.iterator();
//        int i = 0;
//        bw.write("create_time?url?avatar?name?introduction");
//        bw.newLine();
//        while (it.hasNext()) {
//            Element element1 = (Element) it.next();
//
//            Elements elements2 = element1.select("li ul a");
//
//            Iterator at = elements2.iterator();
//
//            while (at.hasNext()) {
//                Element element2 = (Element) at.next();
//                //取出href中的值
//                String url = "http://economics.hdu.edu.cn/"+element2.attr("href");
//                String name=element2.text();
//                System.out.println(name);
//                System.out.println(url);
//
//                //判断url网页的状态码是否是200，如果是继续下一步操作
//
//                if (getcode(url)) {
//
//                    //解析url地址
//                    doc = Jsoup.connect(url).timeout(5000).get();
//                    Element element3 = doc.select("div.wp_articlecontent").first();
//
//
//                    bw.write(parsedate(url) + "?" + url +"?" +parseimg(element3,url)+"?" + name+"?"+parsetext(element3,url));
//                    bw.newLine();
//
//
//
//
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
//    private static String parsedate(String url) {
//        String date= url.substring(url.indexOf("cn/")+4,url.indexOf("cn/")+13);
//        date=date.substring(0,date.indexOf("/"))+"-"+date.substring(date.indexOf("/")+1,date.indexOf("/")+3)+"-"+date.substring(date.indexOf("/")+3);
//        System.out.println(date);
//        return date;
//    }
//
//    private static String parsetext(Element element3, String url) {
//        Elements elements = element3.select("p");
//        String text1 = elements.text();
//        System.out.println(text1);
//        return text1;
//
//    }
//
//    private static String parseimg(Element element3, String url) {
//        String p_img = element3.select("p img").attr("src");
//        p_img="http://economics.hdu.edu.cn/"+p_img;
//        System.out.println(p_img);
//
//
//        return p_img;
//    }
//
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


    //管理学院
//    public static void main(String[] args) throws IOException, SQLException , ClientProtocolException {
//
//        File f = new File("E:\\shuju.txt");//指定文件
//        FileOutputStream fos = new FileOutputStream(f);//创建输出流fos并以f为参数
//        OutputStreamWriter osw = new OutputStreamWriter(fos);//创建字符输出流对象osw并以fos为参数
//        BufferedWriter bw = new BufferedWriter(osw);//创建一个带缓冲的输出流对象bw，并以osw为参数
//
//
//
//        //解析url地址,第一个参数为访问的url,第二个参数为超时时间
//        Document doc = Jsoup.connect("http://management.hdu.edu.cn/1007/list.htm").timeout(5000).get();
//        //提取正文部分
//        Elements elements1 = doc.select("div.techer_1");
//        System.out.println(elements1);
//
//
//        //使用迭代器遍历elements
//        Iterator it = elements1.iterator();
//        int i = 0;
//        bw.write("create_time?url?name?introduction");
//        bw.newLine();
//        while (it.hasNext()) {
//            Element element1 = (Element) it.next();
//
//            Elements elements2 = element1.select("ul a");
//
//            Iterator at = elements2.iterator();
//
//            while (at.hasNext()) {
//                Element element2 = (Element) at.next();
//                //取出href中的值
//                String url = "http://management.hdu.edu.cn/"+element2.attr("href");
//                String name=element2.text();
//                System.out.println(name);
//                System.out.println(url);
//
//                //判断url网页的状态码是否是200，如果是继续下一步操作
//
//                if (getcode(url)&&!name.equals("")) {
//
//                    //解析url地址
//                    doc = Jsoup.connect(url).timeout(5000).get();
//                    Element element3 = doc.select("div.wp_articlecontent").first();
//
//
//                    bw.write(parsedate(url) + "?" + url +"?" + name+"?"+parsetext(element3,url));
//                    bw.newLine();
//
//
//
//
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
//    private static String parsedate(String url) {
//        String date= url.substring(url.indexOf("cn/")+4,url.indexOf("cn/")+13);
//        date=date.substring(0,date.indexOf("/"))+"-"+date.substring(date.indexOf("/")+1,date.indexOf("/")+3)+"-"+date.substring(date.indexOf("/")+3);
//        System.out.println(date);
//        return date;
//    }
//
//    private static String parsetext(Element element3, String url) {
//        Elements elements = element3.select("p");
//        String text1 = elements.text();
//        System.out.println(text1);
//        return text1;
//
//    }
//
//    private static String parseimg(Element element3, String url) {
//        String p_img = element3.select("p img").attr("src");
//        p_img="http://economics.hdu.edu.cn/"+p_img;
//        System.out.println(p_img);
//
//
//        return p_img;
//    }
//
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


//外国语学院
//public static void main(String[] args) throws IOException {
//    File f = new File("E:\\shuju.txt");//指定文件
//    FileOutputStream fos = new FileOutputStream(f);//创建输出流fos并以f为参数
//    OutputStreamWriter osw = new OutputStreamWriter(fos);//创建字符输出流对象osw并以fos为参数
//    BufferedWriter bw = new BufferedWriter(osw);//创建一个带缓冲的输出流对象bw，并以osw为参数
//
//
//    bw.write("create_time?url?name?introduction");
//    bw.newLine();
//    for(int i=1;i<=7;i++) {
//        String urls = "http://foreignedu.hdu.edu.cn/1278/list" + i + ".htm";
//        praehtml(urls,bw);
//    }
//
//    bw.close();
//}
//
//    private static void praehtml(String urls,BufferedWriter bw) throws IOException {
//
//
//        //解析url地址,第一个参数为访问的url,第二个参数为超时时间
//        Document doc = Jsoup.connect(urls).timeout(5000).get();
//        //提取正文部分
//        Elements elements1 = doc.select("div.idx1-right");
//        System.out.println(elements1);
//
//
//        //使用迭代器遍历elements
//        Iterator it = elements1.iterator();
//        int i = 0;
//
//        while (it.hasNext()) {
//            Element element1 = (Element) it.next();
//
//            Elements elements2 = element1.select("div#wp_news_w7 li a");
//
//            Iterator at = elements2.iterator();
//
//            while (at.hasNext()) {
//                Element element2 = (Element) at.next();
//                //取出href中的值
//                String url = "http://foreignedu.hdu.edu.cn/" + element2.attr("href");
//                String name = element2.text();
//                name=name.substring(0,name.indexOf("简历"));
//                System.out.println(name);
//                System.out.println(url);
//
//                //判断url网页的状态码是否是200，如果是继续下一步操作
//
//                if (getcode(url) && !name.equals("")) {
//
//                    //解析url地址
//                    doc = Jsoup.connect(url).timeout(5000).get();
//                    Element element3 = doc.select("div.wp_articlecontent").first();
//
//
//                    bw.write(parsedate(url) + "?" + url + "?" + name + "?" + parsetext(element3, url));
//                    bw.newLine();
//
//
//                }
//
//            }
//
//        }
//
//
//
//    }
//
//
//    private static String parsedate(String url) {
//        String date = url.substring(url.indexOf("cn/") + 4, url.indexOf("cn/") + 13);
//        date = date.substring(0, date.indexOf("/")) + "-" + date.substring(date.indexOf("/") + 1, date.indexOf("/") + 3) + "-" + date.substring(date.indexOf("/") + 3);
//        System.out.println(date);
//        return date;
//    }
//
//    private static String parsetext(Element element3, String url) {
//        Elements elements = element3.select("p");
//        String text1 = elements.text();
//        System.out.println(text1);
//        return text1;
//
//    }
//
//    private static String parseimg(Element element3, String url) {
//        String p_img = element3.select("p img").attr("src");
//        p_img = "http://economics.hdu.edu.cn/" + p_img;
//        System.out.println(p_img);
//
//
//        return p_img;
//    }

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

//法学院
//
//    public static void main(String[] args) throws IOException, SQLException , ClientProtocolException {
//
//        File f = new File("E:\\shuju.txt");//指定文件
//        FileOutputStream fos = new FileOutputStream(f);//创建输出流fos并以f为参数
//        OutputStreamWriter osw = new OutputStreamWriter(fos);//创建字符输出流对象osw并以fos为参数
//        BufferedWriter bw = new BufferedWriter(osw);//创建一个带缓冲的输出流对象bw，并以osw为参数
//
//
//
//        //解析url地址,第一个参数为访问的url,第二个参数为超时时间
//        Document doc = Jsoup.connect("http://rwxy.hdu.edu.cn/1185/list2.htm").timeout(5000).get();
//        //提取正文部分
//        Elements elements1 = doc.select("div#wp_news_w6");
//        System.out.println(elements1);
//
//
//        //使用迭代器遍历elements
//        Iterator it = elements1.iterator();
//        int i = 0;
//        bw.write("create_time?url?avatar?name?introduction");
//        bw.newLine();
//        while (it.hasNext()) {
//            Element element1 = (Element) it.next();
//
//            Elements elements2 = element1.select("span.Article_Title a");
//
//            Iterator at = elements2.iterator();
//
//            while (at.hasNext()) {
//                Element element2 = (Element) at.next();
//                //取出href中的值
//                String url = "http://rwxy.hdu.edu.cn/"+element2.attr("href");
//                String name=element2.text();
//                System.out.println(name);
//                System.out.println(url);
//
//                //判断url网页的状态码是否是200，如果是继续下一步操作
//
//                if (getcode(url)) {
//
//                    //解析url地址
//                    doc = Jsoup.connect(url).timeout(5000).get();
//                    Element element3 = doc.select("div.wp_articlecontent").first();
//
//
//                    bw.write(parsedate(url) + "?" + url +"?" +parseimg(element3,url)+"?" + name+"?"+parsetext(element3,url));
//                    bw.newLine();
//
//
//
//
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
//    private static String parsedate(String url) {
//        String date= url.substring(url.indexOf("cn/")+4,url.indexOf("cn/")+13);
//        date=date.substring(0,date.indexOf("/"))+"-"+date.substring(date.indexOf("/")+1,date.indexOf("/")+3)+"-"+date.substring(date.indexOf("/")+3);
//        System.out.println(date);
//        return date;
//    }
//
//    private static String parsetext(Element element3, String url) {
//        Elements elements = element3.select("p");
//        String text1 = elements.text();
//        System.out.println(text1);
//        return text1;
//
//    }
//
//    private static String parseimg(Element element3, String url) {
//        String p_img = element3.select("p img").attr("src");
//        p_img="http://rwxy.hdu.edu.cn/"+p_img;
//        System.out.println(p_img);
//
//
//        return p_img;
//    }
//
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

//马院
//public static void main(String[] args) throws IOException, SQLException , ClientProtocolException {
//
//    File f = new File("E:\\shuju.txt");//指定文件
//    FileOutputStream fos = new FileOutputStream(f);//创建输出流fos并以f为参数
//    OutputStreamWriter osw = new OutputStreamWriter(fos);//创建字符输出流对象osw并以fos为参数
//    BufferedWriter bw = new BufferedWriter(osw);//创建一个带缓冲的输出流对象bw，并以osw为参数
//
//
//
//    //解析url地址,第一个参数为访问的url,第二个参数为超时时间
//    Document doc = Jsoup.connect("http://marxnew.hdu.edu.cn/3227/list.htm").timeout(5000).get();
//    //提取正文部分
//    Elements elements1 = doc.select("div.fac_list");
//
//
//
//    //使用迭代器遍历elements
//    Iterator it = elements1.iterator();
//    int i = 0;
//    bw.write("create_time?url?avatar?name?introduction");
//    bw.newLine();
//    while (it.hasNext()) {
//        Element element1 = (Element) it.next();
//
//        Elements elements2 = element1.select("div#wp_news_w23 ul li a");
//        System.out.println(elements2);
//        Iterator at = elements2.iterator();
//
//        while (at.hasNext()) {
//            Element element2 = (Element) at.next();
//            //取出href中的值
//            String url = "http://marxnew.hdu.edu.cn/"+element2.attr("href");
//            String name=element2.text();
//            System.out.println(name);
//
//
//            //判断url网页的状态码是否是200，如果是继续下一步操作
//
//            if (getcode(url)&&!name.equals("")) {
//
//                System.out.println(url);
//                //解析url地址
//                doc = Jsoup.connect(url).timeout(5000).get();
//                Element element3 = doc.select("div.wp_articlecontent").first();
//
//
//                bw.write(parsedate(url) + "?" + url +"?" +parseimg(element3,url)+"?" + name+"?"+parsetext(element3,url));
//                bw.newLine();
//
//
//
//
//            }
//
//        }
//
//    }
//
//
//    bw.close();
//}
//
//
//
//    private static String parsedate(String url) {
//        String date= url.substring(url.indexOf("cn/")+4,url.indexOf("cn/")+13);
//        date=date.substring(0,date.indexOf("/"))+"-"+date.substring(date.indexOf("/")+1,date.indexOf("/")+3)+"-"+date.substring(date.indexOf("/")+3);
//        System.out.println(date);
//        return date;
//    }
//
//    private static String parsetext(Element element3, String url) {
//        Elements elements = element3.select("p");
//        String text1 = elements.text();
//        System.out.println(text1);
//        return text1;
//
//    }
//
//    private static String parseimg(Element element3, String url) {
//        String p_img = element3.select("img").attr("src");
//        p_img="http://marxnew.hdu.edu.cn/"+p_img;
//        System.out.println(p_img);
//
//
//        return p_img;
//    }
//
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


    //网络安全学院
//    public static void main(String[] args) throws IOException {
//        File f = new File("E:\\shuju.txt");//指定文件
//        FileOutputStream fos = new FileOutputStream(f);//创建输出流fos并以f为参数
//        OutputStreamWriter osw = new OutputStreamWriter(fos);//创建字符输出流对象osw并以fos为参数
//        BufferedWriter bw = new BufferedWriter(osw);//创建一个带缓冲的输出流对象bw，并以osw为参数
//
//
//        bw.write("create_time?url?name?introduction");
//        bw.newLine();
//        for(int i=1;i<=2;i++) {
//            String urls = "http://cbs.hdu.edu.cn/3445/list" + i + ".htm";
//            praehtml(urls,bw);
//        }
//
//        bw.close();
//    }
//
//    private static void praehtml(String urls,BufferedWriter bw) throws IOException {
//
//
//        //解析url地址,第一个参数为访问的url,第二个参数为超时时间
//        Document doc = Jsoup.connect(urls).timeout(5000).get();
//        //提取正文部分
//        Elements elements1 = doc.select("div#wp_news_w6");
//        System.out.println(elements1);
//
//
//        //使用迭代器遍历elements
//        Iterator it = elements1.iterator();
//
//
//        while (it.hasNext()) {
//            Element element1 = (Element) it.next();
//
//            Elements elements2 = element1.select("dl>dd a");
//
//            Iterator at = elements2.iterator();
//
//            while (at.hasNext()) {
//                Element element2 = (Element) at.next();
//                //取出href中的值
//                String url = "http://cbs.hdu.edu.cn/" + element2.attr("href");
//                String name = element2.text();
//                name=name.substring(name.indexOf("——")+2);
//                System.out.println(name);
//                System.out.println(url);
//
//                //判断url网页的状态码是否是200，如果是继续下一步操作
//
//                if (getcode(url) && !name.equals("")) {
//
//                    //解析url地址
//                    doc = Jsoup.connect(url).timeout(5000).get();
//                    Element element3 = doc.select("div.wp_articlecontent").first();
//
//
//                    bw.write(parsedate(url) + "?" + url + "?" + name + "?" + parsetext(element3, url));
//                    bw.newLine();
//
//
//                }
//
//            }
//
//        }
//
//
//
//    }
//
//
//    private static String parsedate(String url) {
//        String date = url.substring(url.indexOf("cn/") + 4, url.indexOf("cn/") + 13);
//        date = date.substring(0, date.indexOf("/")) + "-" + date.substring(date.indexOf("/") + 1, date.indexOf("/") + 3) + "-" + date.substring(date.indexOf("/") + 3);
//        System.out.println(date);
//        return date;
//    }
//
//    private static String parsetext(Element element3, String url) {
//        Elements elements = element3.select("p");
//        String text1 = elements.text();
//        System.out.println(text1);
//        return text1;
//
//    }
//
//    private static String parseimg(Element element3, String url) {
//        String p_img = element3.select("p img").attr("src");
//        p_img = "http://economics.hdu.edu.cn/" + p_img;
//        System.out.println(p_img);
//
//
//        return p_img;
//    }
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
