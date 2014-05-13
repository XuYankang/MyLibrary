package net;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.List;
import java.util.Map;

public class Url {

	public static void getUrlContent(String url) {
		String fileName = "d:/out.txt";
		try {
			URL u = new URL(url);
			fileName = u.getHost() + u.getFile();
			fileName = fileName.replace(".", "_").replace("?", "？")
					.replace("*", "").replace("|", "");
			fileName = fileName.replace("/", "");
			fileName = fileName.replace("\\", "");
			fileName = "d:/2/" + fileName + ".txt";

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		getUrlContent(url, new File(fileName), "gbk");
		System.out.println("ok");
	}

	public static void getUrlContent(String url, File out) {
		getUrlContent(url, out, "gbk");
	}

	public static void getUrlContent(String url, File out, String charset) {
		// File out = new File("d:/out.html");
		try {
			OutputStreamWriter writer = new OutputStreamWriter(
					new FileOutputStream(out), charset);
			writer.write(getUrlContent(url, ""));
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String getUrlContent(String url, String param) {

		BufferedReader in = null;
		String urlName = url + "?" + param;
		String charset = "utf-8";
		String result = "";
		try {
			URL realUrl = new URL(urlName);
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "keep-alive");
			conn.setRequestProperty(
					"user-agent",
					"Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			conn.getContent();
			Map<String, List<String>> map = conn.getHeaderFields();
			// get charset
			for (String key : map.keySet()) {
				if (key != null
						&& key.trim().toLowerCase()
								.equals("Content-Type".toLowerCase())) {
					String value = map.get(key).toString().toLowerCase();
					int start = value.indexOf("charset=");
					int end = value.indexOf("]", start);
					charset = value.substring(start + 8, end);
					break;
				}

			}
			try {
				Charset.forName(charset);
			} catch (Exception e) {
				charset = "utf-8";
			}

			in = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), charset));
			String line;

			while ((line = in.readLine()) != null) {
				result += "\n" + line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {

//		getUrlContent("http://weibo.com/xuyankang");
//		getUrlContent("http://www.douban.com/update/");
//		getUrlContent("https://www.google.com/reader/view/#overview-page");
//		getUrlContent("https://mail.google.com/mail/?shva=1#inbox");
//		getUrlContent("http://www.zoulang.com/");
//		getUrlContent("http://www.taobao.com/");
//		getUrlContent("http://www.tianya.cn/bbs/index.shtml");
//		getUrlContent("http://bbs.xiaomi.cn/forum.php");
//		getUrlContent("http://www.zhihu.com/");
//		getUrlContent("http://www.renren.com/249023321");
//		getUrlContent("http://www.hi-pda.com/forum/index.php");
//		getUrlContent("http://www.civclub.net/BBS/");
//		getUrlContent("http://www.iteye.com/");
//		getUrlContent("http://yyets.com/");
//		getUrlContent("http://xuyankang.info/");
//		getUrlContent("http://www.cnblogs.com/");
//		getUrlContent("http://www.icili.com/emule");
//		getUrlContent("http://dynamic.cloud.vip.xunlei.com/user_task?userid=168236286&st=0");
//		getUrlContent("http://www.economist.com/");
//		getUrlContent("https://app.yinxiang.com/Home.action#b=e318298d-28e1-4195-9e5e-eb990934b199&n=643764c6-1c6d-41a6-854d-f77fc5ba06b8");
//		getUrlContent("http://www.verycd.com/");
//		getUrlContent("http://getpocket.com/a/queue/");
		getUrlContent("http://www.cskaoyan.com/");
//		getUrlContent("http://bbs.pcbeta.com/");
//		getUrlContent("http://www.mtime.com/");
//		getUrlContent("http://bbs.3dmgame.com/");
//		getUrlContent("http://www.colorschemer.com/online.html");
//		getUrlContent("http://www.converthub.com/");
//		getUrlContent("https://www.labi.com/main.jsp");
//		getUrlContent("http://www.google.com/calendar/renderOnline?settings=3#");
//		getUrlContent("http://www.coderun.com/ide/");
//		getUrlContent("http://bbs.greenday.gd/index.php");
//		getUrlContent("http://snipbin.appspot.com/extlogin");
//		getUrlContent("http://ishare.iask.sina.com.cn/");
//		getUrlContent("http://www.inien.com/w/#/Index");
//		getUrlContent("http://10.137.252.101:8080/transmission/web/");
//		getUrlContent("http://www.ecocn.org/");
//		getUrlContent("http://www.google.com/cse/home?cx=004798099194550741737%3Aqvcmshog6v4");
//		getUrlContent("http://open.163.com/");
//		getUrlContent("http://jsonlint.com/");
//		getUrlContent("http://torrentproject.com/");
//		getUrlContent("http://nyglzx.tongji.edu.cn/web/datastat.aspx");
//		getUrlContent("http://sae.sina.com.cn/");
//		getUrlContent("http://wangshou.ctnz.net/");
//		getUrlContent("http://www.jslint.com/");
//		getUrlContent("http://www.tof2k.com/ext/formbuilder/");
//		getUrlContent("http://scz-bbs.com/forum.php");
//		getUrlContent("http://localhost:8080/DatabaseWeb/frame.jsp");
//		getUrlContent("http://kat.ph/");
//		getUrlContent("http://www.bttiantang.com/");
//		getUrlContent("http://kat.ph/");
//		getUrlContent("http://www.bttiantang.com/");
//		getUrlContent("http://2cyr.com/decode/?lang=en");
//		getUrlContent("http://www.xiami.com/");
//		getUrlContent("http://www.google.cn/music/homepage");
//		getUrlContent("http://www.my1510.cn/");
//		getUrlContent("https://www.google.com/");
//		getUrlContent("http://www.chinahdtv.org/index.php");
//		getUrlContent("http://douban.fm/radio");
//		getUrlContent("http://bbs.kaoyan.com/");
//		getUrlContent("http://index.tv.sohu.com/");
//		getUrlContent("http://www.downg.com/default.html?g");
//		getUrlContent("http://home.pengyou.com/index.php?mod=home");
//		getUrlContent("http://hd.cnscg.com/forum.php");
//		getUrlContent("http://www.guokr.com/");
//		getUrlContent("https://cp.freehostia.com/");
//		getUrlContent("http://www.51fanli.com/");
//		getUrlContent("https://wlan.ct10000.com/portal2/login_zp.jsp");
//		getUrlContent("https://www.google.com/reader/view/#overview-page");
//		getUrlContent("http://www.cnblogs.com/fish-li/");
//		getUrlContent("http://www.yihaodian.com/promotion/detail.do?promotionId=28142&promotionLevelId=26639");
//		getUrlContent("http://www.hi-pda.com/forum/viewthread.php?tid=1091209&extra=page%3D1");
//		getUrlContent("http://www.hi-pda.com/forum/viewthread.php?tid=1091160&extra=page%3D1");
//		getUrlContent("http://www.zhihu.com/question/20609538");
//		getUrlContent("http://www.zhihu.com/question/20573602/answer/15522795");
//		getUrlContent("http://i.imgur.com/lPC2B.png");
//		getUrlContent("http://wiki.apache.org/nutch/FAQ");
//		getUrlContent("http://www.simplecd.org/");
//		getUrlContent("http://waitforsorrow.blogbus.com/");
//		getUrlContent("http://e-learning.wzu.edu.cn/homepage/common/opencourse/");
//		getUrlContent("http://jwc2.wzu.edu.cn/");
//		getUrlContent("http://web.qq.com/");
//		getUrlContent("http://cn.opensuse.org/%E6%AC%A2%E8%BF%8E%E6%9D%A5%E5%88%B0openSUSE.org%E7%A4%BE%E5%8C%BA");
//		getUrlContent("http://www.drip-music.com/");
//		getUrlContent("http://www.foobar2000.com.cn/");
//		getUrlContent("http://twitter.fishnote.net/login.php");
//		getUrlContent("http://www.androidin.net/bbs/index.php");
//		getUrlContent("http://www.hiapk.com/bbs/index.php");
//		getUrlContent("http://www.m8fans.com/");
//		getUrlContent("http://blog.sina.com.cn/u/1364596875");
//		getUrlContent("http://www.ali213.net/");
//		getUrlContent("http://60.190.84.214:100/");
//		getUrlContent("http://www.vim.org/");
//		getUrlContent("https://www.google.com/bookmarks/?hl=zh-CN");
//		getUrlContent("http://www.cuijian.com/bbs/index.asp");
//		getUrlContent("http://www.zhujiwu.com/UC_HostList.asp");
//		getUrlContent("http://www.uspcat.com/myapi/extjs4/docs/index.html#/guide/getting_started");
//		getUrlContent("http://www.youku.com/v_olist/c_96_a_%E5%A4%A7%E9%99%86_s__g__r_2010_lg__im__st__mt__d_1_et_0_fv_0_fl__fc__fe__o_7.html");
//		getUrlContent("http://support.acer.com/us/en/product/default.aspx?tab=1&modelId=3801");
//		getUrlContent("http://gonghui.tongji.edu.cn/tuc/index.aspx");
//		getUrlContent("http://www.easyicon.cn/");
//		getUrlContent("http://codepad.org/");
//		getUrlContent("http://woodpecker.org.cn/diveintopython/");
//		getUrlContent("http://cl.eye.rs/index.php");
//		getUrlContent("http://www.torrentkitty.com/search/");
//		getUrlContent("http://www.chm-pdf.com/");
//		getUrlContent("http://www.appletuan.com/");
//		getUrlContent("http://blog.sina.com.cn/s/articlelist_1924345884_0_1.html");
//		getUrlContent("http://caoliuv5.pen.io/");
//		getUrlContent("http://www.ziyuanhai.com/");
//		getUrlContent("http://linux.sheup.com/");
//		getUrlContent("http://www.harding.edu/fmccown/java_csharp_comparison.html");
//		getUrlContent("http://www.tuyansuo.com/");
//		getUrlContent("http://www.huangwu.com/");
//		getUrlContent("https://webim.feixin.10086.cn/");
//		getUrlContent("http://localhost:8080/ext-3.4.0/docs/");
//		getUrlContent("http://localhost:8080/kp2012_zju/");
//		getUrlContent("https://10.60.148.136/svn/");
//		getUrlContent("http://dribbble.com/");
//		getUrlContent("http://www.veryicon.com/");
//		getUrlContent("http://www.simplecd.me/");
//		getUrlContent("http://www.mytju.com/classcode/tools/urldecode_utf8.asp");
//		getUrlContent("http://www.51voa.com/");
//		getUrlContent("http://xartfan.com/");
//		getUrlContent("http://figator.co.uk/");
//		getUrlContent("http://btdigg.org/");
//		getUrlContent("https://docs.google.com/document/d/1HsbCyMl_e7q07J3lpCw9gawERxq0-j87isWtG_GNJ8o/edit#");
//		getUrlContent("http://vod.xunlei.com/");
//		getUrlContent("http://www.bysj.net/wzu/student/index.do");
//		getUrlContent("http://www.mininova.org/");
//		getUrlContent("http://ikindle.mobi/");
//		getUrlContent("http://10.132.252.2:5560/isqlplus/workspace.uix");
//		getUrlContent("http://www.askform.cn/Default.aspx");
//		getUrlContent("http://book.zi5.me/");
//		getUrlContent("http://pmlc.cnki.net/user/StuUserInfo.aspx");
//		getUrlContent("http://www.epubbud.com/");
//		getUrlContent("http://www.uspcat.com/forum.php?mod=forumdisplay&fid=108");
//		getUrlContent("http://www.phpchina.com/archives/view-40900-1.html");
//		getUrlContent("http://www.90qh.com/user/logininfo.asp");
//		getUrlContent("http://www.d5yuansu.com/");
//		getUrlContent("https://www.onx.ms/#!landingPage");
//		getUrlContent("http://www.techsupportalert.com/");
//		getUrlContent("http://www.readcola.com/");
//		getUrlContent("https://www.coursera.org/");
//		getUrlContent("http://127.0.0.1/");
//		getUrlContent("http://www.w3school.com.cn/index.html");
//		getUrlContent("http://www.songtaste.com/");
//		getUrlContent("http://www.pconline.com.cn/");
//		getUrlContent("http://www.downg.com/default.html");
//		getUrlContent("http://bbs.pcbeta.com/");
//		getUrlContent("http://www.flash8.net/");
//		getUrlContent("http://mp3.sogou.com/");
//		getUrlContent("http://bbs.cnscg.com/");
//		getUrlContent("http://bbs.wofei.net/index.php");
//		getUrlContent("http://www.yinyuetai.com/home");
//		getUrlContent("http://www.google.com/cse/home?cx=004798099194550741737%3Azyzf5nvtjne");
//		getUrlContent("http://bbs.greenday.gd/");
//		getUrlContent("http://bbs.breezecn.com/");
//		getUrlContent("http://bbs.besgold.com/");
//		getUrlContent("http://bbs.imp3.net/");
//		getUrlContent("http://greggordon.org/java/tij4/solutions.htm");
//		getUrlContent("http://www.codeskulptor.org/");
//		getUrlContent("https://class.coursera.org/interactivepython-2012-001/class/index");
//		getUrlContent("http://m.yeeyan.org/#");
//		getUrlContent("http://www.quora.com/");
//		getUrlContent("http://m.douban.com/?session=761ec6d1?session=5387fbc8");
//		getUrlContent("http://3g.163.com/");
//		getUrlContent("http://3g.qq.com/");
//		getUrlContent("http://3g.sina.com.cn/");
//		getUrlContent("http://www.google.com.hk/");
//		getUrlContent("http://m.baidu.com/?from=1269a/");
//		getUrlContent("http://bbs.xiaomi.com/");

		System.out.println("end");

	}
}
