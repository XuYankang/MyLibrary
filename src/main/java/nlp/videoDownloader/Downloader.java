package nlp.videoDownloader;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import tool.WebpageUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by jacob on 14-10-11.
 */
public class Downloader {

    private static final String COURSE_HTML = "coursera.html";
    public static String savedDir = "/Users/jacob/Downloads/nlp/";
    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws IOException {
        System.out.println("联系作者Jacob Xu:xuyanakng@gmail.com");
        System.out.println("本程序具备断点下载功能，未完成的下载将会在下次启动后继续。");
        System.out.println("请输入Coursera保存的地址：");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String savedPathString = reader.readLine();

        while (savedPathString == null || savedPathString.length() == 0) {
            savedPathString = reader.readLine();
            if (savedPathString.lastIndexOf("/") == -1) {
                savedPathString += "/";
            }
        }


        File savedPath = new File(savedPathString);
        if (!savedPath.exists()) {
            savedPath.mkdirs();
            System.out.println("已创建目录：" + savedPathString);
        }


        File courseHTML = new File(savedPathString + "/" + COURSE_HTML);
        Document document = null;
        if (courseHTML.exists()) {
            document = Jsoup.parse(FileUtils.readFileToString(courseHTML));
        } else {
            System.out.println("请输入需要下载的Coursera的地址（如https://class.coursera.org/nlp/lectureElement）：");
            String url = reader.readLine();
            while (url == null || url.length() == 0 || url.indexOf("https://class.coursera.org") == -1) {
                System.out.println("Coursera地址非法，请重新输入：");
                url = reader.readLine();

            }
            String content = WebpageUtil.downloadHTML(url);
            if (content.contains("meta name=\"robots\"")) {
                System.out.println("网页下载失败，请自行保存改网址到您执行的下载目录，并将文件命名为" + COURSE_HTML);
                System.out.println("程序退出");
                return;
            }
            document = Jsoup.parse(content);
        }

        Elements lectures = document.select(".course-lectures-list .course-item-list ul li");

        int total = 0;
        int idCount = 1;
        ArrayList<Lecture> lectureArrayList = new ArrayList<Lecture>();
        for (int i = 0; i < lectures.size(); i++) {
            Element lectureElement = lectures.get(i);
            Element common = lectureElement.child(0);
            String id = String.valueOf(idCount++);
            String name = common.text();
            Lecture lecture = new Lecture();
            lecture.setId(id);
            lecture.setName(name);
            Elements resroucesChildren = lectureElement.child(1).select("a");
            for (Element resroucesChild : resroucesChildren) {
                String href = resroucesChild.attr("href");
                String title = resroucesChild.attr("title");
                LectureResource lectureResource = new LectureResource(href, title);
                lecture.addResource(lectureResource);
                total++;
            }
            lectureArrayList.add(lecture);
        }
        System.out.println("下载地址解析成功。");
        System.out.println("开始下载...");
        int count = 0;
        for (Lecture lecture : lectureArrayList) {
            for (LectureResource lr : lecture.getResources()) {
                count++;
                String fileName = lecture.getResourceFileName(lr);
                String filePath = savedPathString + lecture.getId() + "-" + lecture.getName() + "/" + fileName;
                boolean exist = checkExist(savedPathString, fileName);
                if (exist) {
                    System.out.println(String.format("[%d/%d]-%s exist!", count, total, fileName));
                    continue;
                }
                WebpageUtil.downloadFile(lr.getUrl(), filePath);
                System.out.println(String.format("[%d/%d]-%s-下载%s成功", count, total, sdf.format(new Date()), filePath));
            }
        }


        System.out.println("done");
    }

    private static boolean checkExist(String savedDir, String fileName) {
        String[] extensions = null;
        Collection<File> files = FileUtils.listFiles(new File(savedDir), extensions, true);
        for (File file : files) {
            if (fileName.equals(file.getName())) {
                return true;
            }
        }
        return false;
    }


}

class Lecture {
    String id;
    String name;
    ArrayList<LectureResource> resources;

    public void addResource(LectureResource lectureResource) {
        this.resources.add(lectureResource);
    }

    public Lecture() {
        this.resources = new ArrayList<LectureResource>();
    }

    public String getResourceFileName(LectureResource resource) {
        return String.format("%s-%s.%s", id, name, resource.getFormat());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<LectureResource> getResources() {
        return resources;
    }

    public void setResources(ArrayList<LectureResource> resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", resources=" + resources +
                '}';
    }
}

class LectureResource {
    String url;
    String title;
    String format;

    LectureResource(String url, String title) {
        this.url = url;
        this.title = title;
        titleToFormat();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void titleToFormat() {
        if (title.toLowerCase().contains("ppt")) {
            this.format = "pptx";
        }
        if (title.toLowerCase().contains("pdf")) {
            this.format = "pdf";
        }
        if (title.toLowerCase().contains("text")) {
            this.format = "txt";
        }
        if (title.toLowerCase().contains("srt")) {
            this.format = "srt";
        }
        if (title.toLowerCase().contains("mp4")) {
            this.format = "mp4";
        }

    }

    @Override
    public String toString() {
        return "LectureResource{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", format='" + format + '\'' +
                '}';
    }
}
