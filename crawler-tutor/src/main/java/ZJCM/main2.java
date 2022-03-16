package ZJCM;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.*;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main2 {

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

        main2 c=new main2();
        c.getCon();
//       SBAA();//播音主持艺术学院

//        Jxsj();//电视艺术学院

//        Dhxy();//动画与数字艺术学院

//        JSCO();//新闻与传播学院

//         Makesi();//马克思主义学院

//        SCCM();//文化与传播学院

        Design_art();//设计艺术学院

    }

    private static void Design_art() throws IOException, SQLException {

        String college="设计艺术学院";

        String []urls={"http://sjysxy.cuz.edu.cn/sz/jsfc.htm","http://sjysxy.cuz.edu.cn/sz/jsfc/1.htm"};

        for(int i=0;i<2;i++) {


            Document document = Jsoup.connect(urls[i]).timeout(1000).get();


            Elements elements1 = document.select("div.ny_right_con ul li");
            Iterator at = elements1.iterator();
            while (at.hasNext()) {
                Element element = (Element) at.next();
                String url = element.select("a").attr("href");
                while (url.contains("../"))
                    url = url.replace("../", "");
                url = "http://sjysxy.cuz.edu.cn/" + url;
                System.out.println(url);


                String name = element.select("a").attr("title");
                System.out.println(name);

                String avatar = element.select("img").attr("src");
                if(!avatar.equals(""))
                avatar = "http://sjysxy.cuz.edu.cn" + avatar;
                System.out.println(avatar);

                Document document1 = Jsoup.connect(url).timeout(1000).get();
                String introduction = document1.select("div.v_news_content").text();
                System.out.println(introduction);

                sql=con.prepareStatement("insert into t_expert (name,url,avatar,introduction,college) values(?,?,?,?,?)");

                sql.setString(1,name);
                sql.setString(2,url);
                sql.setString(3,avatar);
                sql.setString(4,introduction);
                sql.setString(5,college);

                sql.executeUpdate();
            }

        }

    }

    private static void SCCM() throws IOException, SQLException {

        String []urls={"http://wgxy.cuz.edu.cn/xygk/szdw/js.htm","http://wgxy.cuz.edu.cn/xygk/szdw/fjs.htm"};
        String []title={"教授","副教授"};
        String college="文化与传播学院";
        for(int i=0;i<2;i++) {
            Document document = Jsoup.connect(urls[i]).timeout(1000).get();


            String text = document.toString();
            Pattern pattern = Pattern.compile("<a href=\"(\\S*)\" target=\"_blank\" title=");
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                String url = matcher.group(1);
                while (url.contains("../"))
                    url = url.replace("../", "");
                url = "http://wgxy.cuz.edu.cn/" + url;

                Elements form = Jsoup.connect(url).timeout(1000).get().select("form");


                String name = form.select("div.content-title h3").text();
                System.out.println(name);

                String introduction = form.select("div.v_news_content").text();
                System.out.println(introduction);

                String avatar = form.select("p img").attr("src");
                avatar = "http://wgxy.cuz.edu.cn" + avatar;
                System.out.println(avatar);


                sql=con.prepareStatement("insert into t_expert (name,url,avatar,introduction,college,title) values(?,?,?,?,?,?)");

                sql.setString(1,name);
                sql.setString(2,url);
                sql.setString(3,avatar);
                sql.setString(4,introduction);
                sql.setString(5,college);
                sql.setString(6,title[i]);

//                sql.executeUpdate();

            }
        }

    }


    private static void Makesi() throws IOException, SQLException {

     // String text="[{\"id\":\"85\",\"createTime\":\"2021-05-18 09:54:53\",\"title\":\"刘福州\",\"image\":\"file/20210518/69079eae950949679145bf641a0dc2a8.png\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">刘福州，男，1964年12月生，教授。清华大学思想政治教育专业研究生毕业，现任浙江传媒学院马克思主义学院党总支书记、常务副院长，社会科学部主任。主要从事马克思主义理论与思想政治教育教学和研究工作，研究方向为社会思潮与青年教育。曾主持浙江省社会科学规划项目研究1项、省教育厅研究项目2项，参与国家社科基金项目、教育部规划课题、国家广电总局课题研究10多项。先后在《中国教育报》、《光明日报》、《学术界》、《思想理论教育导刊》、《理论前沿》等报刊杂志发表论文40多篇，出版《我国社会转型期拜金主义现象透视》、《网络信息化与社会思潮引领机制构建研究》、《当代中国社会思潮评析》、《向生命中的美好遇见致敬》等著作4部。现兼任浙江省媒介素养教育研究会副会长，浙江省马克思主义学会、科学社会主义学会理事，浙江省中国特色社会主义理论研究中心特邀研究员、浙江省高校党建研究会特邀研究员。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"84\",\"createTime\":\"2021-05-18 09:53:09\",\"title\":\"许志红\",\"image\":\"file/20210518/d22e94ed8ad64a94a8aaa0790915f47a.jpg\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">许志红，教授，心理学博士。浙江传媒学院马克思主义学院副院长，教育部学位中心论文评审专家，浙江青年研究会理事，浙江省媒介素养研究会理事，浙江心理卫生协会会员。在学术期刊发表论文近40篇，主持省部级等各类课题30余项。在权威出版社出版3部专著，编写3部教材。曾获得 “全国思想政治理论课教学骨干”称号，入选浙江省优秀中青年资助计划，曾在全省教学竞赛中获得第一名的好成绩，在长三角高校思政课教学比赛中获得优异成绩。研究方向为青年群体心理，心理健康教育。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"83\",\"createTime\":\"2021-05-18 09:52:25\",\"title\":\"王国雨\",\"image\":\"file/20210518/39b68813446a4ba1a86189669f733166.png\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">王国雨，浙江传媒学院马克思主义学院副教授、哲学博士。主要从事优秀传统文化教育及思政课的教学和研究工作。研究领域为儒家哲学、优秀传统文化教育。</span></p><p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">在学术研究上，围绕早期儒家经学与哲学的核心话题，先后发表学术论文20余篇，其中关于早期儒家礼学的研究论文获得多家学术期刊转载。出版代表作《早期儒家&lt;诗&gt;论及其哲学意义》（人民出版社，2017）1部。主持国家社科基金项目两项（2020年度和2013年度）；主持完成教育部人文社科项目和浙江省哲社规划项目各1项（2012年度和2011年度）。目前致力于儒家诗教、生命礼仪等话题的思考和文化经典的教学实践。</span></p><p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">在教学方面，主要讲授《马克思主义基本原理》《传统文化与大学生道德修养》等课程。2013年1月，本人主持的课程入选首届“浙江省高校德育精品选修课程”，该课程于2014年4月被中国高教学会评选为大学素质通识课优秀课程。2013年6月主持浙江省课堂教改建设项目《高校优秀传统文化教育的改革与探索》。2021年，获课程思政微课比赛校级一等奖。</span></p><p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">目前为中华孔子学会理事、浙江省儒学学会理事、浙江省哲学学会理事，曾任中国高教学会大学素质教育分会理事。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"82\",\"createTime\":\"2021-05-18 09:50:49\",\"title\":\"戴月华\",\"image\":\"file/20210518/1f78d0ac3f72414abcd9476c2bed4308.jpg\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">戴月华，男，浙江海盐县人，哲学博士，硕士生导师，教授，省哲学学会常务理事。先后任教于浙江师范大学、江南大学、浙江传媒学院。曾任浙江传媒学院马克思主义学院（社会科学部）副院长、副主任（2013.6-2019.6），现为马克思主义学院（社会科学部）思想与传播研究所负责人。主要从事马克思主义哲学与西方人文思潮的教学与研究工作。主讲《马克思主义与社会科学方法论》、《西方哲学经典导读》、《马克思主义基本原理概论》、《电影与哲学》等课程，多次获校教学成果一、二等奖（参与、主持）、教学十佳等荣誉称号。主持及实质参与国家级、省部级课题8项，合作出版著作、教材多部，在《哲学动态》、《国外社会科学》等独立发表论译文30余篇，其中人大复印等9篇转载。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"81\",\"createTime\":\"2021-05-18 09:49:06\",\"title\":\"罗群\",\"image\":\"file/20210518/2dbbb08ed59f4499bc86975e65cb2470.jpg\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">罗群，副教授。古典文献学博士，毕业于浙江大学人文学院古籍研究所，中国思想史方向。曾作为交流学者在波士顿大学历史系进修。主要从事中外文化交流与关系史，以及地方文化相关人文历史领域的研究，已出版专著两本，主持或参与国家级或省级课题若干。长期担任《马克思主义基本原理概论》和《逻辑学》课程的教学工作，还曾开设人文类选修课多门。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"80\",\"createTime\":\"2021-05-18 09:48:11\",\"title\":\"魏新龙\",\"image\":\"file/20210518/719a11079f11416b97b847b46625ee03.png\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">魏新龙，1964年5月出生，博士，副教授。</span></p><p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">先后就学于兰州大学哲学系(1981--1985)、中共中央党校国际战略研究所(2000--2003)、复旦大学哲学学院(2006--2009)，分别获得哲学学士、法学硕士、哲学博士学位。所学专业涵盖哲学、国际政治学、经济哲学等；主要从事马克思主义理论、经济政治学、现代文化学等领域的研究与教学工作。</span></p><p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">担任多届浙江省哲学学会理事、经济学会理事；浙江省当代国际问题研究会常务理事。相关学术兴趣集中在近现代文化、知识、科技与现代化相关问题，发表过相关论文多篇，曾主持并完成浙江省教育厅课题《论文化发展的演进模型》，主持并完成浙江省社科规划后期资助课题《国家、生产力、经济发展阶段—弗·李斯特经济哲学思想研究》。在省以上核心期刊等发表论文三十多篇，在浙江大学出版社、浙江人民出版社、广电出版社等出版或参与出版著作、教材多部。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"79\",\"createTime\":\"2021-05-18 09:46:45\",\"title\":\"乔丽英\",\"image\":\"file/20210518/3eaf0d06249949c484224be2a53d8d52.png\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">乔丽英，马克思主义学院教师，哲学博士，副教授。主讲《马克思主义基本原理概论》和《西方哲学智慧》课程。获评浙江省思想政治理论课优秀教师荣誉称号。主持厅局级课题5项，在《社会主义研究》等刊物发表学术论文16篇。学术兴趣致力于马克思主义哲学、马克思主义基本理论研究。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"78\",\"createTime\":\"2021-05-18 09:43:22\",\"title\":\"朱广龙\",\"image\":\"file/20210518/119229c810d64379b3de8c6400f97740.jpg\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">朱广龙，生于1982年2月，祖籍山东烟台，浙江大学哲学博士，研究方向为宋代思想史。2014年进入浙江传媒学院社会科学教学部（现马克思主义学院）任教，主讲课程《马克思主义基本原理概论》、《马克思主义政治经济学》、《马克思主义宗教观》等。任职期间，发表论文多篇，并积极参与各级课题申报。获2019年浙江传媒学院第十一届青年教师教学技能比赛二等奖。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"77\",\"createTime\":\"2021-05-18 09:42:27\",\"title\":\"杜刚\",\"image\":\"file/20210518/53f9c8e021f1430c8710440d5df503b5.png\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">杜刚，毕业于浙江大学，获法学博士学位。《毛泽东思想和中国特色社会主义理论体系概论》课专业教师，副教授职称，担任马克思主义中国化教研室主任，兼任浙江省青年讲师团讲师、浙江省统一战线理论研究会理事、浙江延安精神研究会会员。主持国家社会科学基金后期资助项目1项（在研），完成省级课题1项、厅级课题3项。主要研究方向为政治传播学、政务新媒体理论与实践、媒体与执政党关系研究。近年来，在《中国特色社会主义研究》、《当代青年研究》、《毛泽东思想研究》、《湖北社会科学》、《理论月刊》、《观察与思考》等期刊发表论文20余篇。《论大众传媒与党的执政形象》一文被人大复印资料全文转载（2016）。发表的其他学术论文先后获中国广播电视协会‘宁波广电杯’媒体与执政党关系研究征文评选二等奖（2010）、浙江省高校思想政治教育研究会2011年专题研讨会二等奖（2011）、浙江省高等学校思想政治教育研究会第八届代表大会优秀论文一等奖（2014）、浙江省马克思主义学会理论研讨会三等奖（2017）。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"76\",\"createTime\":\"2021-05-18 09:40:12\",\"title\":\"常楷\",\"image\":\"file/20210518/44449bbb35a1405d8b89687de5a07a3c.jpg\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">常楷，法学博士，副教授。从事马克思主义中国化研究，主讲《毛泽东思想和中国特色社会主义理论体系概论》《中国特色社会主义理论与实践研究》等课程。浙江省教坛新秀，新时代浙江省“万名好党员”，浙江传媒学院“学生心目中的好老师”、“教学十佳”。浙江传媒学院科普志愿服务队指导教师，浙江传媒学院心理健康与生命教育中心兼职心理咨询师。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"75\",\"createTime\":\"2021-05-18 09:39:12\",\"title\":\"丁友文\",\"image\":\"file/20210518/3fa9f7730a3f4a0ab8c7bc0f86c7ab31.jpg\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">丁友文，法学博士，副教授。主要从事马克思主义中国化教学与研究，为本科生和研究生主讲《毛泽东思想和中国特色社会主义理论体系概论》、《形势政策》和《中国特色社会主义理论与实践研究》等主干课程。主持、参与多项省部级科研项目，在《浙江社会科学》、《江西社会科学》、《浙江学刊》、《求实》等发表论文20余篇，并被《人大复印资料》、《中国高校社会科学文摘》等全文转载。先后被评为浙江传媒学院三育人先进个人和社会实践优秀先进个人。担任浙江传媒学院科普志愿服务队指导教师。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"74\",\"createTime\":\"2021-05-18 09:35:58\",\"title\":\"宋红岩\",\"image\":\"file/20210518/e2ed71f3fa484113b3c22f6904de3c0b.jpg\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">宋红岩，教授，硕导，英国剑桥大学访问学者。现为中国广播电视社会组织联合会媒介素养学术研究基地秘书长、浙江省媒介素养教育研究会副会长、浙江传媒学院媒介素养研究所常务副所长、浙江省青年教育研究会理事。先后主持参与多项国家级、省部级课题，发表30余篇论文，出版《长三角农民工网络使用与社会认同》等著作。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"73\",\"createTime\":\"2021-05-18 09:35:03\",\"title\":\"谢晖\",\"image\":\"file/20210518/9d87c382f4764c0d8460dbf9890c0941.jpg\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">谢晖，浙江大学法学博士。现任马克思主义学院党总支委员，浙江基层社会治理学院执行院长，《形势与政策》教研室主任，《红·传》宣讲团导师。研究方向为国际关系，全球治理。主持并参与多项国家级、省部级以上项目，多篇论文获得省级奖项。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"72\",\"createTime\":\"2021-05-18 09:34:11\",\"title\":\"赫飞\",\"image\":\"file/20210518/c57c8ed140054c82bc403e91fb883f28.jpg\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">赫飞，1980年出生，辽宁沈阳人。先后就读于西北师范大学、上海师范大学，学习中国中古史，获历史学博士学位。目前主讲《中国近现代史纲要》、《形势与政策》、《资治通鉴选读》等课程。日常关注中国中古史、中国近代史研究。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"71\",\"createTime\":\"2021-05-18 09:33:02\",\"title\":\"陈一平\",\"image\":\"file/20210518/243202bb6c2c4ee6894fadce6bf8f24e.jpg\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">陈一平，女，籍贯：浙江缙云。先后就读于杭州大学、南京大学，1994年获法学硕士学位。1994年8月入职中国药科大学。2005年7月调入浙江传媒学院至今。长期从事大学公共课的教学科研工作。先后开设中国革命史、中国传统文化概论、中国旅游景观概论、毛泽东思想概论、中国近现代史纲要、西方文明史等课程的教学工作。</span></p><p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">近年来关注历史文化的学习和研究，对杭州地区的非物质文化遗产以及杭州地区的公共文化设施进行了调查研究，形成了一些科研成果。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"70\",\"createTime\":\"2021-05-18 09:32:12\",\"title\":\"任李明\",\"image\":\"file/20210518/3ad8d9b8aa984bfbafbeddcde5fad8e4.jpg\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">任李明，男，浙江海盐人，2002年毕业于南京大学历史系，获世界史专业博士学位，现为浙江传媒学院马克思主义学院副教授，主要从事国际关系和美国外交研究，曾出版专著《美国外交传统及其缔造者》（合著，商务印书馆，2010年）和《威尔逊主义研究》（独著，中国社会科学出版社，2013年），主持国家社科基金项目《意识形态与美国早期外交战略研究》（2020—2023年）。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"69\",\"createTime\":\"2021-05-18 09:31:18\",\"title\":\"韩金玲\",\"image\":\"file/20210518/11c2070587c14bdd8af19e7c9c02442e.jpg\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">韩金玲，女，祖籍山东章丘，毕业于山东师范大学历史与社会发展学院中国近现代史专业，历史学硕士，副教授。主讲《中国近现代史纲要》《毛泽东思想和中国特色社会主义理论体系概论》《民法学》《知识产权法学》等。发表论文40多篇，出版著作《中国当代大陆汉诗的文化镜像》（合著）。主持完成校级课题《中国近现代史纲要》重点课程建设，参与国家级课题《新诗作家旧体诗词创作现象的发生学研究》，省级、校级课题多项。曾获浙江省高等学校科研成果奖三等奖、山东省菏泽市社会科学优秀成果奖二等奖、三等奖。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"68\",\"createTime\":\"2021-05-18 09:27:34\",\"title\":\"王妍红\",\"image\":\"file/20210518/96d371cffd79444795ccc347c9a5c5a3.jpg\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">王妍红，女，山东平度人，华中师范大学中国近现代史博士，现任浙江传媒学院马克思主义学院讲师，主要讲授《中国近现代史纲要》、《中国古代货币史》等课程。主持厅局级项目1项，在《福建论坛》、《中国社会科学报》等刊物发表多篇论文。获浙江传媒学院2019年“智慧精彩一堂课”三等奖，获浙江传媒学院第十届“教学十佳”。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"}]";

        String text="[{\"id\":\"67\",\"createTime\":\"2021-05-18 09:26:46\",\"title\":\"李耀锋\",\"image\":\"file/20210518/1df6e7f91a45453994120109607f796a.jpg\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">李耀锋，男，工程师，博士，浙江传媒学院马克思主义学院副教授，主要研究方向为哲学、伦理学。先后在华北水利水电学院、上海交通大学和上海师范大学求学，分别获得工学学士、哲学硕士和法学博士学位。美国詹姆斯·麦迪逊大学政治学系访问学者。承担国家哲学社会科学基金项目一项，出版学术专著一部，有多篇论文公开发表。中国伦理学会教育伦理专业委员会理事、浙江伦理学会理事。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"66\",\"createTime\":\"2021-05-18 09:24:18\",\"title\":\"何仁富\",\"image\":\"file/20210518/58fb785166424d91bbf13ed3bea65df0.jpg\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">何仁富，男，四川平昌人，清华大学哲学博士，浙江传媒学院马克思主义学院教授，生命学与生命教育研究所所长，浙江省高校思政名师工作室负责人，浙江省教学名师，浙江省151第二层次人选。创建大陆高校首家生命教育研究机构“生命学与生命教育研究所”、华夏生命教育网，创设并主办“海峡两岸大学生命教育高峰论坛”，长期从事生命教育融入思想政治教育的研究与教学实践，《生命教育理念下的高校思政工作创新研究》入选教育部首批高校思政工作创新研究文库，由人民出版社出版。兼任中国陶行知研究会生命教育专业委员会副理事长、大学生命教育联盟召集人、浙江省儒学会常务理事、北京抗癌协会生死学与生死教育专业委员会常务理事。开发《爱与生命》《西湖生死学》《论语生命学》等生命教育特色课程。主要从事现代新儒家唐君毅、生死哲学与生命教育的研究。主编39卷大陆简体字版《唐君毅全集》，出版《爱与生死》、《唐君毅与宋明理学》、《唐君毅说儒》、《生命教育引论》、《生命教育演讲录》、《生命教育的思与行》，《生命教育十五讲》、《道德与生命》等专著十余部。受邀到不同高校、中小学、党政机关、监狱、社会办学机构等开展生命教育和国学讲座上百场。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"65\",\"createTime\":\"2021-05-17 15:59:08\",\"title\":\"李远煦\",\"image\":\"file/20210517/98e35568cf27469092544634caa32155.jpg\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">李远煦，湖北荆州人，教育学博士，浙江传媒学院副教授，主要从事大学生思想政治教育、创新创业教育研究。主持或作为主要成员参与国家社科基金项目、教育部“十二五”教科规划重点项目、教育部人文社会科学研究专项任务项目等国家级、省部级课题。在《教育研究》、《高等教育研究》等核心期刊发表论文20余篇。研究成果获浙江省第十五届哲学社会科学优秀成果奖应用理论与对策研究类二等奖、浙江省科学技术进步奖二等奖等奖项。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"64\",\"createTime\":\"2021-05-17 15:58:26\",\"title\":\"李琼瑶\",\"image\":\"file/20210518/00162ff56ebf49298a2b6ac18f659128.jpg\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">李琼瑶，女，中共党员，法学硕士，副教授。1994年毕业于浙江师范大学，同年到浙江传媒学院任教至今。其间承担《思想道德修养与法律基础》、《法律基础》、《新闻法规与专业法律》、《知识产权法》、《形势与政策》等课程的教学工作，曾被评为校“师德标兵”和校“教学十佳”。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"63\",\"createTime\":\"2021-05-17 15:55:07\",\"title\":\"陶婷\",\"image\":\"file/20210517/97b40b9fcaf7457a90318d547d625dd5.png\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">陶婷，中共党员，华东政法大学法学博士，浙江大学光华法学院法学硕士，2009年起就职于浙江传媒学院，承担《思想道德修养与法律基础》、《娱乐法》、《创业法律指导》等课程。2019年度浙江省高校优秀党员，曾作为优秀教师代表被学习强国、浙江卫视、新蓝网、杭州网、浙江在线、浙江文明网等媒体报道。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"62\",\"createTime\":\"2021-05-17 15:50:00\",\"title\":\"杨英文\",\"image\":\"file/20210517/63ad3595ff7c4a94becd30fba5e33412.jpg\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">杨英文，2019年毕业于吉林大学，取得法理学博士学位。研究方向为住房权、信息权利、媒介法。</span></p><p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">工作经历：2010.3----浙江传媒学院。2016.7----2017.1杭州经济开发区人民法院实践锻炼。2017.2---2017.7四川大学俄语培训。2017.8--2018.8俄罗斯克拉斯诺达尔国立大学访问学者。</span></p><p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">学术成果：</span></p><p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">著作《城镇化视域下公民主债权研究》、合著《马克思主义生态哲学综论》。</span></p><p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">课题有“经济发达地区城市居民住房权研究”、“权利的贫困---农民住房权研究”、“新媒体环境下个人信息保护研究”、“信息疫情下网民信息素养及其法律规制”等。</span></p><p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">教改项目有“走进法庭在生命教育中的应用”等</span></p><p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">开设课程：</span></p><p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">《思想道德修养与法律基础》、《影视作品的法与情》</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"61\",\"createTime\":\"2021-05-17 15:46:10\",\"title\":\"王满荣\",\"image\":\"file/20210517/d6cd3c229d9c42b69ac4ca59e36e4709.jpg\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">王满荣，2007年博士研究生毕业于浙江大学，获法学博士学位。现为马克思主义学院副教授，硕士生导师，主要从事媒介法、数字媒体与智能传播、网络空间治理及政治哲学的研究。兼任浙江省青年研究会理事、浙江省媒介素养教育研究会会员。主持国家社科基金项目《网络空间命运共同体研究》、浙江省哲学社会科学规划课题：《冲突与和谐：基于人的主体视角的理论研究》、厅级项目：《网络暴力的形成机制及治理对策的研究》等项目。参与国家级、省部级项目多项。出版专著《冲突与和谐：基于人的主体视角的理论研究》（中国社会科学出版社，2013年）。发表论文与研究报告数篇。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"60\",\"createTime\":\"2021-05-17 15:41:01\",\"title\":\"彭毅力\",\"image\":\"file/20210517/b814ecbe96b44ca595994e55f4f378d2.png\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">彭毅力，女，副教授，武汉大学软件工程硕士，九三学社成员，从教39年。主要从事基础数学、科学技术史、中国传统文化研究。先任教于浙江传媒学院电子信息学院，主讲《线性代数》、《高等数学》、《数学文化》、《概率论与数理统计》等课程。后调入马克思主义学院，主讲《自然科学概论》、《科学技术史》、《思想道德修养与法律基础》等课程。参与完成过一项全国教育规划九·五重点项目，一项国家社科基金项目；主持完成三项省教育厅课题；编著教材、词典各一部；发表学术论文三十余篇；其中四篇被新华文摘或中国人民大学报刊复印资料转载。积极参与扶贫工作，其所发起、主持的“暖冬行动”，十年总计募集捐赠衣物十八吨送往贫困乡村，并向农家书屋和乡村小学捐献书籍两千多本。先后获得过浙江省暑期文化科技卫生三下乡先进个人、浙江传媒学院师德标兵、三育人先进个人、优秀班主任、优秀工会干部等称号和奖励。 </span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"59\",\"createTime\":\"2021-05-17 15:36:28\",\"title\":\"张薇\",\"image\":\"file/20210517/9c6b560aae484074884d9c201e678cdf.jpg\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">张薇，女，1982年10月生，浙江传媒学院马克思主义学院讲师，香港科技大学社会科学系硕士研究生，南京大学法学院博士研究生，主授课程为社会学概论、思想道德修养与法律基础，主攻科研方向为法社会学、刑事诉讼法学，发表博士论文一篇，CSSCI著作两篇，科研项目若干。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"58\",\"createTime\":\"2021-05-17 15:31:48\",\"title\":\"李清\",\"image\":\"file/20210517/f58e2b15b99b4df9abe2b9f2feb950ac.jpg\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">李清，毕业于华东师范大学心理学院，心理学博士，副教授，主讲《大学生心理健康教育》，主要研究方向心理健康教育和生命教育。主持国家社科基金、教育部人文社科青年项目和浙江省哲学社会科学项目各一项，以及省教育规划项目和教育厅一般项目；主持浙江省线上线下混合式一流课程，获得浙江省“互联网+教学”优秀案例一等奖，获得浙江省高校优秀青年教师资助计划。在国外SSCI和国内核心期刊发表论文20余篇，出版译著3本。近年来，累计为浙江省内外政府机构、教育机构和多家大型企业提供心理培训服务（譬如领导力提升、创新思维提升、压力管理课程及情绪管理课程等）共计数百余场。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"57\",\"createTime\":\"2021-05-17 15:27:43\",\"title\":\"汪丽华\",\"image\":\"file/20210517/d803428ae3f04c9dafd11f8a08444785.jpg\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">汪丽华，女，1963年09月生，汉族，四川省绵竹县人。1986年本科毕业于四川大学哲学系，获哲学学士学位。2006年获得国家二级心理咨询师资格。现任浙江传媒学院马克思主义学院教授，生命学与生命教育研究所研究人员。主要从事哲学心理学、生命教育及新儒家研究。自独立工作以来已发表论文近40篇，其中核心期刊论文10余篇；出版专著《身心灵全人生命教育》《爱与生死》《爱，从生命里流出》等5部；主编《大学生心理健康与生命教育》特色教材。创建国内高校第一家融生命辅导与心理咨询于一体的学生辅导实务机构“浙江传媒学院大学生心理健康与生命教育中心”。曾获得学校三育人优秀个人、师德标兵、学生心目中的好老师；多次荣获优秀班主任。2013年获浙江省教书育人典型案例。2015年获浙江省三八红旗手称号。2008年汶川地震后曾经先后多次到灾区做心理与生命辅导。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"56\",\"createTime\":\"2021-05-17 15:26:49\",\"title\":\"马九福\",\"image\":\"file/20210517/e82189989f9a47168718e4760137803b.jpg\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">马九福，女，1969年4月出生，江西省南昌市人，副教授，博士。浙江传媒学院马克思主义学院教师，生命教育研究所，名师工作室成员，学校兼职心理咨询师，连续从事咨询时间7年多。陶行知研究会会员，奉行陶行知先生的“捧得一颗心来，不带半根草去”的教育理念。2011年宋庆龄基金会生命彩虹奖获得者。主要研究领域为大学生心理健康。发表学术论文10余篇，两篇被人大复印资料全文复印。参与多部著作的写作，多为国家一级出版社出版。主持教学研究项目多项，科研项目多项，参与国家级重点社科规划项目一项。教学风格亲切自然。咨询理念：相信每个人都是自己生命的主人。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"55\",\"createTime\":\"2021-05-17 15:26:01\",\"title\":\"胡芸\",\"image\":\"file/20210517/883a8524bd2c48818c46e982df047978.jpg\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">胡芸，浙江传媒学院马克思主义学院专任教师，隶属大学生心理健康教研室，承担全校公共课《大学生心理健康教育》的教学工作，并开设公选课《心理健康与舞动治疗》和《心理成长训练课》，均为心理类的团体辅导课程。此外，还开设艺术类公选课《昆曲经典赏析》。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"54\",\"createTime\":\"2021-05-17 15:21:24\",\"title\":\"张方圆\",\"image\":\"file/20210517/4f1f09facfdd4fb7a8f829b1f39b541f.jpg\",\"content\":\"<p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\">张方圆，浙江传媒学院马克思主义学院心理教研室讲师。研究领域：心理健康教育、生命教育。国家二级心理咨询师、国家二级职业指导师，全球职业规划师。曾任浙江传媒学院心理健康与生命教育中心主任。现任中国陶行知研究会生命教育专业委员会副秘书长、浙江省高校心理健康教育研究会理事、北京市癌症防治学会生死学与生死教育专业委员会委员、下沙高教园区心理健康教育协作中心专家委员会副秘书长。参与主持国家级、省部级课题多项，发表论文多篇。曾获全国大学生心理健康教育工作优秀青年工作者称号。接受过精神分析、行为治疗、沙盘游戏、家庭治疗等系统性的心理咨询技能训练，并受训于联合国国际劳工组织残障平等培训项目。善于在生命教育中融入艺术治疗、团体辅导的技术与方法。曾在企业单位、养老机构、肿瘤医院、智障服务机构、监狱系统开展团体心理辅导、安宁疗护与生命辅导。</span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"},{\"id\":\"53\",\"createTime\":\"2021-05-17 15:20:26\",\"title\":\"简婷\",\"image\":\"file/20210517/087fb60adc13471088e6a323fd73d1ae.jpg\",\"content\":\"<p></p><p></p><p></p><p class=\\\"media-wrap image-wrap align-center\\\"></p><p></p><p></p><p style=\\\"text-indent:2em;\\\"><span style=\\\"line-height:2\\\"><span style=\\\"font-size:16px\\\">简婷，湖南岳阳人，先后获得湖南师范大学史学博士学位、中国社会科学院法学博士学位。致力于中国近现代史、中共党史研究，参与国家社会科学基金项目1项、主持省部级等课题3项、公开发表论文30余篇、获得“林增平史学奖”等奖项。2019年底入职浙江传媒学院，担任《毛泽东思想和中国特色社会主义理论体系概论》课程教师，立足于三尺讲台，努力在学生已有的认知上推进高校思政课教学。</span></span></p>\",\"type\":2,\"categoryId\":\"148\",\"categoryName\":\"专职教师\"}]";
        JSONArray jsonArray = JSONArray.parseArray(text);

        String college="马克思主义学院";

        for(int i=0;i<jsonArray.size();i++)
        {
            Object object = jsonArray.get(i);
            JSONObject jsonObject1 = JSONObject.parseObject(object.toString());
            System.out.println(jsonObject1);

            String avatar = jsonObject1.getString("image");
            avatar="http://skb.cuz.edu.cn/mksxy/api/v1/"+avatar;
            System.out.println(avatar);

            String name = jsonObject1.getString("title");
            System.out.println(name);

            String id = jsonObject1.getString("id");
            String url="http://skb.cuz.edu.cn/#/mkszy/article?type=2&categoryId=148&navIdx=0&id="+id;
            System.out.println(url);

            String introduction = jsonObject1.getString("content");
            introduction=introduction.substring(introduction.indexOf("\"line-height:2\">")+16,introduction.indexOf("</span></p>"));
            System.out.println(introduction);


            sql=con.prepareStatement("insert into t_expert (name,introduction,url,college,avatar) values(?,?,?,?,?)");

            sql.setString(1,name);
            sql.setString(2,introduction);
            sql.setString(3,url);
            sql.setString(4,college);
            sql.setString(5,avatar);

            sql.executeUpdate();
        }



    }


    private static void JSCO() throws IOException, SQLException {
        Document document = Jsoup.connect("http://cmxw.cuz.edu.cn/yjsjy/yjsds.htm").timeout(1000).get();
        System.out.println(document);

        String text = document.toString();
        Pattern pattern = Pattern.compile("<span><a href=\"(\\S*)\" target=\"_blank\" title=");
        Matcher matcher = pattern.matcher(text);

        while(matcher.find())
        {
            String url = matcher.group(1);
            while(url.contains("../"))
                url=url.replace("../","");

            url="http://cmxw.cuz.edu.cn/"+url;
            Document document1 = Jsoup.connect(url).timeout(1000).get();

            Elements form = document1.select("form");
            String name = form.select("dt").first().text();
            System.out.println(name);

            Elements content = form.select("div#vsb_content");
            String avatar = content.select("p img").attr("src");
            avatar="http://cmxw.cuz.edu.cn"+avatar;
            System.out.println(avatar);

            String introduction = content.text();
            System.out.println(introduction);

            sql=con.prepareStatement("insert into t_expert (name,avatar,introduction,url,college) values(?,?,?,?,?)");

            sql.setString(1,name);
            sql.setString(2,avatar);
            sql.setString(3,introduction);
            sql.setString(4,url);
            sql.setString(5,"新闻与传播学院");

            sql.executeUpdate();
        }

    }


    private static void Dhxy() throws IOException, SQLException {


        String []urls={"?page=1","?page=2","?page=3"};

        for(int i=0;i<3;i++) {

            String html="http://dhxy.cuz.edu.cn/major/teacher"+urls[i];

            Document document = Jsoup.connect(html).timeout(1000).get();


            String text = document.toString();


            Pattern pattern = Pattern.compile(" <!-- <a href=\"(\\S*)\"> --> \n" +
                    "        <img class=\"img\"");
            Matcher matcher = pattern.matcher(text);

            String college = "动画与数字艺术学院";

            while (matcher.find()) {
                String url = matcher.group(1);

                System.out.println(url);

                Document document1 = Jsoup.connect(url).timeout(1000).get();
                String avatar = document1.select("div.img.left img").attr("src");
                System.out.println(avatar);

                String name = document1.select("div.ry.left h4").text();
                System.out.println(name);

                String introduction = document1.select("div.bottom").text();
                System.out.println(introduction);

                sql = con.prepareStatement("insert into t_expert (name,college,introduction,avatar,url) values(?,?,?,?,?)");

                sql.setString(1, name);
                sql.setString(2, college);
                sql.setString(3, introduction);
                sql.setString(4, avatar);
                sql.setString(5, url);


//                sql.executeUpdate();
            }
        }
    }

    private static void Jxsj() throws IOException, SQLException {
        Document document = Jsoup.connect("http://ysys.cuz.edu.cn/jxsj/szdw.htm").timeout(1000).get();


        String text = document.toString();
        Pattern pattern = Pattern.compile("<span class=\"right\"></span> <a href=\"(\\S*)\" target=\"_blank\"");
        Matcher matcher = pattern.matcher(text);

        String college="电视艺术学院";
        while(matcher.find())
        {
            String url=matcher.group(1);

            while(url.contains("../"))
                url=url.replace("../","");

            url="http://ysys.cuz.edu.cn/"+url;

            Document document1 = Jsoup.connect(url).timeout(1000).get();

            Elements form = document1.select("form");


            String name = form.select("div.biaoti.lanse h1").text();
            System.out.println(name);

           String introduction  = form.select("div.wenzi").text();
            System.out.println(introduction);


            sql=con.prepareStatement("insert into t_expert (name,introduction,college,url) values(?,?,?,?)");

            sql.setString(1,name);
            sql.setString(2,introduction);
            sql.setString(3,college);
            sql.setString(4,url);

//            sql.executeUpdate();

        }



    }

    private static void SBAA() throws IOException, SQLException {

        String []urls={"szdw.htm","szdw/5.htm","szdw/4.htm","szdw/3.htm","szdw/2.htm","szdw/1.htm"};

        String college="播音主持艺术学院";
        for(int i=0;i<6;i++) {
            String html = "http://byzc.cuz.edu.cn/xygk/" + urls[i];
            Document document = Jsoup.connect(html).timeout(1000).get();
            String text = document.toString();
            Pattern pattern = Pattern.compile("<h1><a href=\"(\\S*)\">");
            Matcher matcher = pattern.matcher(text);

            while (matcher.find())
            {
                String url=matcher.group(1);
                while(url.contains("../"))
                {
                    url=url.replace("../","");
                }

                url="http://byzc.cuz.edu.cn/"+url;

                Document document1 = Jsoup.connect(url).timeout(1000).get();
                Elements form = document1.select("form");

                String name = form.select("div.content-title h3").text();
                System.out.println(name);
                Elements elements1 = form.select("div.content-con");
                String introduction = elements1.text();
                System.out.println(introduction);

                String avatar = elements1.select("p img").attr("src");
                avatar="http://byzc.cuz.edu.cn"+avatar;
                System.out.println(avatar);

                sql=con.prepareStatement("insert into t_expert (name,url,avatar,introduction,college) values(?,?,?,?,?)");

                sql.setString(1,name);
                sql.setString(2,url);
                sql.setString(3,avatar);
                sql.setString(4,introduction);
                sql.setString(5,college);

//                sql.executeUpdate();
            }


        }
    }
}
