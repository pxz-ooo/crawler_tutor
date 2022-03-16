package bao;





import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.sql.SQLException;
import java.util.Iterator;



public class main {

    //外国语学院
    public static void main(String[] args) throws IOException, SQLException {

        Document document = Jsoup.connect("https://yjsb.cjlu.edu.cn/tutor/#/listPage").timeout(1000).get();
        System.out.println(document);

    }
}



