package jiliang;

public class jiliang {
//    //计量测试工程学院
//    public static void main(String[] args) throws IOException, SQLException, NoSuchAlgorithmException, KeyManagementException {
//
//
//        File f = new File("E:\\shuju.txt");//指定文件
//        FileOutputStream fos = new FileOutputStream(f);//创建输出流fos并以f为参数
//        OutputStreamWriter osw = new OutputStreamWriter(fos);//创建字符输出流对象osw并以fos为参数
//        BufferedWriter bw = new BufferedWriter(osw);//创建一个带缓冲的输出流对象bw，并以osw为参数
//
//        //解析url地址,第一个参数为访问的url,第二个参数为超时时间
//        Document doc = Jsoup.connect("https://jlcs.cjlu.edu.cn/xygk/szdw.htm").timeout(5000).get();
//        //提取正文部分
//        Elements elements1 = doc.select("div.list-page");
//
//
//        //使用迭代器遍历elements
//        Iterator it = elements1.iterator();
//        int i = 0;
//        bw.write("create_time|url|avatar|name|introduction");
//        bw.newLine();
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
//                String url =element2.attr("href");
//                url=url.substring(url.indexOf("../")+3);
//                url= "https://jlcs.cjlu.edu.cn/"+url;
//                System.out.println(url);
//                String name=element2.text();
//                System.out.println(name);
//
//                String body = parsehttps(url);
//                doc = Jsoup.parse(body);
//
//                Element element3 = doc.select("div.v_news_content").first();
//
//
//              bw.write(parsedate(doc)+"|"+url+"|"+parseimg(element3,url)+"|"+name+"|"+parsetext(element3,url));
//                      bw.newLine();
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
//
//
//
//
//
//    private static String parsedate(Document doc) {
//       String date= doc.select("div.explain").first().text();
//       date=date.substring(date.indexOf("更新时间")+5,date.indexOf("日"));
//       date=date.substring(0,date.indexOf("年"))+"-"+date.substring(date.indexOf("年")+1,date.indexOf("月"))+"-"+date.substring(date.indexOf("月")+1);
//        System.out.println(date);
//        return date;
//    }
//
//    private static String parsetext(Element element3, String url) {
//        Elements elements = element3.select("div");
//        String text1 = elements.text();
//        System.out.println(text1);
//        return text1;
//
//    }
//
//    private static String parseimg(Element element3, String url) {
//        String p_img = element3.select("p img").attr("src");
//        p_img="https://jlcs.cjlu.edu.cn/"+p_img;
//        System.out.println(p_img);
//        return p_img;
//    }
//
//
//    private static String parsehttps(String url) throws IOException, NoSuchAlgorithmException, KeyManagementException {
//        //采用绕过验证的方式处理https请求
//        SSLContext sslcontext = createIgnoreVerifySSL();
//
//        //设置协议http和https对应的处理socket链接工厂的对象
//        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
//                .register("http", PlainConnectionSocketFactory.INSTANCE)
//                .register("https", new SSLConnectionSocketFactory(sslcontext))
//                .build();
//        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
//        HttpClients.custom().setConnectionManager(connManager);
//
//
//        String body=null;
//
//        //创建自定义的httpclient对象
//        CloseableHttpClient client = HttpClients.custom().setConnectionManager(connManager).build();
//        //CloseableHttpClient client = HttpClients.createDefault();
//
//        try {
//            //创建get方式请求对象
//            HttpGet get = new HttpGet(url);
//
//            //指定报文头Content-type、User-Agent
//            get.setHeader("Content-type", "application/x-www-form-urlencoded");
//            get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");
//
//            //执行请求操作，并拿到结果（同步阻塞）
//            CloseableHttpResponse response = client.execute(get);
//
//            //获取结果实体
//            HttpEntity entity = response.getEntity();
//            if (entity != null) {
//                //按指定编码转换结果实体为String类型
//                body = EntityUtils.toString(entity, "UTF-8");
//            }
//
//            EntityUtils.consume(entity);
//            //释放链接
//            response.close();
//
//        } finally {
//            client.close();
//        }
//
//        return body;
//    }
//
//    /**
//     * 绕过验证
//     *
//     * @return
//     * @throws NoSuchAlgorithmException
//     * @throws KeyManagementException
//     */
//    public static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
//        SSLContext sc = SSLContext.getInstance("SSLv3");
//
//        // 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
//        X509TrustManager trustManager = new X509TrustManager() {
//            @Override
//            public void checkClientTrusted(
//                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
//                    String paramString) throws CertificateException {
//            }
//
//            @Override
//            public void checkServerTrusted(
//                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
//                    String paramString) throws CertificateException {
//            }
//
//            @Override
//            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//                return null;
//            }
//        };
//
//        sc.init(null, new TrustManager[] { trustManager }, null);
//        return sc;
//    }

}



    //光学与电子科技学院
//    public static void main(String[] args) throws IOException, SQLException {
//
//        File f = new File("E:\\shuju.txt");//指定文件
//        FileOutputStream fos = new FileOutputStream(f);//创建输出流fos并以f为参数
//        OutputStreamWriter osw = new OutputStreamWriter(fos);//创建字符输出流对象osw并以fos为参数
//        BufferedWriter bw = new BufferedWriter(osw);//创建一个带缓冲的输出流对象bw，并以osw为参数
//
//
//        //解析url地址,第一个参数为访问的url,第二个参数为超时时间
//        Document doc = Jsoup.connect("https://gdxy.cjlu.edu.cn/szdw/jsfc/xyjs/1.htm").timeout(5000).get();
//        //提取正文部分
//        Elements elements1 = doc.select("div.ContIN_Rjstz_con");
//
//
//        //使用迭代器遍历elements
//        Iterator it = elements1.iterator();
//        int i = 0;
//        bw.write("create_time?url?avatar?name?text");
//        bw.newLine();
//        while (it.hasNext()) {
//            Element element1 = (Element) it.next();
//
//            Elements elements2 = element1.select("div ul li.pic a");
//
//
//            Iterator at = elements2.iterator();
//
//
//            while (at.hasNext()) {
//                Element element2 = (Element) at.next();
//                //取出href中的值
//                String url = element2.attr("href");
//                url="https://gdxy.cjlu.edu.cn/"+url.substring(url.indexOf("../../../")+9);
//                System.out.println(url);
//                String img="https://gdxy.cjlu.edu.cn/"+element2.select("img").attr("src");
//                System.out.println(img);
//
//                String name=element2.select("img").attr("title");
//                name=name.substring(0,name.indexOf("简介"));
//                System.out.println(name);
//
//                //判断url网页的状态码是否是200，如果是继续下一步操作
//                if (getcode(url)) {
//
//                    //解析url地址
//                    doc = Jsoup.connect(url).timeout(5000).get();
//                    Element element3 = doc.select("div.v_news_content").first();
//
//                    String text=element3.text();
//                    System.out.println(text);
//                    bw.write(parsedate(doc,url)+"?"+url+"?"+img+"?"+name+"?"+text);
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
//    private static String parsedate(Document doc,String url) {
//        String date= doc.select("div.LIST_TITBOT").text();
//        date=date.substring(date.indexOf("(")+1,date.indexOf(")"));
//        System.out.println(date);
//        return date;
//    }
//
//
//
//
//
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


//    //材料与化学学院
//    public static void main(String[] args) throws IOException, SQLException {
//
//        File f = new File("E:\\shuju.txt");//指定文件
//        FileOutputStream fos = new FileOutputStream(f);//创建输出流fos并以f为参数
//        OutputStreamWriter osw = new OutputStreamWriter(fos);//创建字符输出流对象osw并以fos为参数
//        BufferedWriter bw = new BufferedWriter(osw);//创建一个带缓冲的输出流对象bw，并以osw为参数
//
//
//        //解析url地址,第一个参数为访问的url,第二个参数为超时时间
//        Document doc = Jsoup.connect("https://clxy.cjlu.edu.cn/szdw/jsml.htm").timeout(5000).get();
//        //提取正文部分
//        Elements elements1 = doc.select("div#zwBox");
//
//
//        //使用迭代器遍历elements
//        Iterator it = elements1.iterator();
//        int i = 0;
//        bw.write("create_time?url?avatar?name?text");
//        bw.newLine();
//        while (it.hasNext()) {
//            Element element1 = (Element) it.next();
//
//            Elements elements2 = element1.select("div.clearfix.item a");
//
//
//            Iterator at = elements2.iterator();
//
//
//            while (at.hasNext()) {
//                Element element2 = (Element) at.next();
//                //取出href中的值
//                String url = element2.attr("href");
//                url="https://clxy.cjlu.edu.cn/"+url.substring(url.indexOf("../")+3);
//                System.out.println(url);
//
//                String name=element2.text();
//
//                System.out.println(name);
//
//                //判断url网页的状态码是否是200，如果是继续下一步操作
//                if (getcode(url)) {
//
//
//                    //解析url地址
//                    doc = Jsoup.connect(url).timeout(5000).get();
//                    Element element3 = doc.select("div.v_news_content").first();
//
//                    String img="https://clxy.cjlu.edu.cn/"+element3.select("p img").attr("src");
//                    System.out.println(img);
//                    String text=element3.text();
//                    System.out.println(text);
//                    bw.write(parsedate(doc,url)+"?"+url+"?"+img+"?"+name+"?"+text);
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
//    private static String parsedate(Document doc,String url) {
//        String date=doc.select("div.main_contit p").text();
//        date=date.substring(date.indexOf("时间：")+3,date.indexOf("点击数"));
//        System.out.println(date);
//        return date;
//    }
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
//}

//{
//        Element element1 = (Element) it.next();
//
//        Elements elements2 = element1.select("div#you3 div a");
//
//
//        Iterator at = elements2.iterator();
//
//
//        while (at.hasNext()) {
//        Element element2 = (Element) at.next();
//        //取出href中的值
//        String url = element2.attr("href");
//        url="https://lxy.cjlu.edu.cn/"+url.substring(url.indexOf("../")+3);
//        System.out.println(url);
//        String name=element2.text();
//        System.out.println(name);
//
//        //判断url网页的状态码是否是200，如果是继续下一步操作
//        if (getcode(url)) {
//
//        //解析url地址
//        doc = Jsoup.connect(url).timeout(5000).get();
//        Element element3 = doc.select("div.v_news_content").first();
//
//
//        String text = element3.text();
//        System.out.println(text);
//        bw.write(url + "?"  + name + "?" +text);
//        bw.newLine();
//
//
//        }
//        }
//
//        }
//
//
//        bw.close();
//        }
//
//
//private static String parsedate(String url) {
//        String date = url.substring(url.indexOf("cn/") + 3, url.indexOf("cn/") + 12);
//        date = date.substring(0, date.indexOf("/")) + "-" + date.substring(date.indexOf("/") + 1, date.indexOf("/") + 3) + "-" + date.substring(date.indexOf("/") + 3);
//        return date;
//        }
//
//private static String parsetext(Element element3, String url) {
//        Elements elements = element3.select("p");
//        String text1 = elements.text();
//        text1 = text1.substring(text1.indexOf("浏览次数") + 9);
//        return text1;
//
//        }
//
//private static String parseimg(Element element3, String url) {
//        String p_img = element3.select("p img").attr("src");
//        p_img = "http://elec.hdu.edu.cn/" + p_img;
//        return p_img;
//        }
//
//private static String parsename(Element element3, String url) throws IOException {
//        String name = element3.select("h1.arti_title").text();
//        System.out.println(name);
//        return name;
//        }
//
//
//private static boolean getcode(String url) throws IOException {
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
//        return true;
//        else return false;
//
//
//        }


//    //生命科学学院
//    public static void main(String[] args) throws IOException, SQLException {
//
//        File f = new File("E:\\shuju.txt");//指定文件
//        FileOutputStream fos = new FileOutputStream(f);//创建输出流fos并以f为参数
//        OutputStreamWriter osw = new OutputStreamWriter(fos);//创建字符输出流对象osw并以fos为参数
//        BufferedWriter bw = new BufferedWriter(osw);//创建一个带缓冲的输出流对象bw，并以osw为参数
//
//
//        //解析url地址,第一个参数为访问的url,第二个参数为超时时间
//        Document doc = Jsoup.connect("https://cls.cjlu.edu.cn/szdw/jsfc/1.htm").timeout(5000).get();
//        //提取正文部分
//        Elements elements1 = doc.select("div.HolistRcon");
//
//
//
//        //使用迭代器遍历elements
//        Iterator it = elements1.iterator();
//        int i = 0;
//        bw.write("create_time|url|name|avatar|introduction");
//        bw.newLine();
//        while (it.hasNext()) {
//            Element element1 = (Element) it.next();
//
//            Elements elements2 = element1.select("dl dt a");
//
//
//            Iterator at = elements2.iterator();
//
//
//            while (at.hasNext()) {
//                Element element2 = (Element) at.next();
//                //取出href中的值
//                String url = element2.attr("href");
//                url="https://cls.cjlu.edu.cn/"+url.substring(url.indexOf("../")+6);
//                System.out.println(url);
//                String img="https://cls.cjlu.edu.cn/"+element2.select("img").attr("src");
//                System.out.println(img);
//
//                String name=element2.attr("title");
//                System.out.println(name);
//
//
//                //判断url网页的状态码是否是200，如果是继续下一步操作
//                if (getcode(url)) {
//
//                    //解析url地址
//                    doc = Jsoup.connect(url).timeout(5000).get();
//                    Element element3 = doc.select("div.v_news_content").first();
//                    String date=   doc.select("div.condate").text();
//                    System.out.println(date);
//                    String text = element3.text();
//                    System.out.println(text);
//                    bw.write(date+"|"+url + "|"  + name + "|"+img+"|" +text);
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
//    private static String parsedate(String url) {
//        String date = url.substring(url.indexOf("cn/") + 3, url.indexOf("cn/") + 12);
//        date = date.substring(0, date.indexOf("/")) + "-" + date.substring(date.indexOf("/") + 1, date.indexOf("/") + 3) + "-" + date.substring(date.indexOf("/") + 3);
//        return date;
//    }
//
//    private static String parsetext(Element element3, String url) {
//        Elements elements = element3.select("p");
//        String text1 = elements.text();
//        text1 = text1.substring(text1.indexOf("浏览次数") + 9);
//        return text1;
//
//    }
//
//    private static String parseimg(Element element3, String url) {
//        String p_img = element3.select("p img").attr("src");
//        p_img = "http://elec.hdu.edu.cn/" + p_img;
//        return p_img;
//    }
//
//    private static String parsename(Element element3, String url) throws IOException {
//        String name = element3.select("h1.arti_title").text();
//        System.out.println(name);
//        return name;
//    }
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
//        Document doc = Jsoup.connect("https://fxy.cjlu.edu.cn/szdw1/flx/1.htm").timeout(5000).get();
//        //提取正文部分
//        Elements elements1 = doc.select("ol.a_li");
//
//
//
//        //使用迭代器遍历elements
//        Iterator it = elements1.iterator();
//        int i = 0;
//        bw.write("create_time|url|name|avatar|introduction");
//        bw.newLine();
//        while (it.hasNext()) {
//            Element element1 = (Element) it.next();
//
//            Elements elements2 = element1.select("li h4 a");
//
//
//            Iterator at = elements2.iterator();
//
//
//            while (at.hasNext()) {
//                Element element2 = (Element) at.next();
//                //取出href中的值
//                String url = element2.attr("href");
//                url="https://fxy.cjlu.edu.cn/"+url.substring(url.indexOf("../")+6);
//                System.out.println(url);
//
//
//                String name=element2.attr("title");
//                System.out.println(name);
//
//
//                //判断url网页的状态码是否是200，如果是继续下一步操作
//                if (getcode(url)) {
//
//                    //解析url地址
//                    doc = Jsoup.connect(url).timeout(5000).get();
//                    Element element3 = doc.select("div.v_news_content").first();
//                    String date=   doc.select("p.a_info").text();
//                    date= date.substring(date.indexOf("日期：")+3,date.indexOf("点击"));
//
//                    String img="https://fxy.cjlu.edu.cn/"+element3.select("tbody>tr span img").attr("src");
//                    System.out.println(img);
//                    System.out.println(date);
//                    String text = element3.text();
//                    System.out.println(text);
//                    bw.write(date+"|"+url + "|"  + name + "|"+img+"|" +text);
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
//    private static String parsedate(String url) {
//        String date = url.substring(url.indexOf("cn/") + 3, url.indexOf("cn/") + 12);
//        date = date.substring(0, date.indexOf("/")) + "-" + date.substring(date.indexOf("/") + 1, date.indexOf("/") + 3) + "-" + date.substring(date.indexOf("/") + 3);
//        return date;
//    }
//
//    private static String parsetext(Element element3, String url) {
//        Elements elements = element3.select("p");
//        String text1 = elements.text();
//        text1 = text1.substring(text1.indexOf("浏览次数") + 9);
//        return text1;
//
//    }
//
//    private static String parseimg(Element element3, String url) {
//        String p_img = element3.select("p img").attr("src");
//        p_img = "http://elec.hdu.edu.cn/" + p_img;
//        return p_img;
//    }
//
//    private static String parsename(Element element3, String url) throws IOException {
//        String name = element3.select("h1.arti_title").text();
//        System.out.println(name);
//        return name;
//    }
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

//    //标准化学院
//    public static void main(String[] args) throws IOException, SQLException {
//
//        File f = new File("E:\\shuju.txt");//指定文件
//        FileOutputStream fos = new FileOutputStream(f);//创建输出流fos并以f为参数
//        OutputStreamWriter osw = new OutputStreamWriter(fos);//创建字符输出流对象osw并以fos为参数
//        BufferedWriter bw = new BufferedWriter(osw);//创建一个带缓冲的输出流对象bw，并以osw为参数
//
//
//        //解析url地址,第一个参数为访问的url,第二个参数为超时时间
//        Document doc = Jsoup.connect("https://bzh.cjlu.edu.cn/szdw/ggjs/1.htm").timeout(5000).get();
//        System.out.println(doc);
//        //提取正文部分
//        Elements elements1 = doc.select("div.main_conRcb");
//        System.out.println(elements1);
//
//
//
//        //使用迭代器遍历elements
//        Iterator it = elements1.iterator();
//        int i = 0;
//        bw.write("create_time|url|name|avatar|introduction");
//        bw.newLine();
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
//                String url = element2.attr("href");
//                url="https://bzh.cjlu.edu.cn/"+url.substring(url.indexOf("../")+6);
//                System.out.println(url);
//
//
//                String name=element2.select("em").text();
//                System.out.println(name);
//
//
//                //判断url网页的状态码是否是200，如果是继续下一步操作
//                if (getcode(url)) {
//
//                    //解析url地址
//                    doc = Jsoup.connect(url).timeout(5000).get();
//                    Element element3 = doc.select("div.v_news_content").first();
//                    String date=   doc.select("div.main_contit p").text();
//                    date= date.substring(date.indexOf("时间")+3,date.indexOf("点击"));
//
//                    String img="https://bzh.cjlu.edu.cn/"+element3.select("p img").attr("src");
//
//                    System.out.println(img);
//                    System.out.println(date);
//                    String text = element3.text();
//                    System.out.println(text);
//                    bw.write(date+"|"+url + "|"  + name +"|"+img+"|" +text);
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