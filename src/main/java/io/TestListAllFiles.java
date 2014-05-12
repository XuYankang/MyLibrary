package io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestListAllFiles {
	public static void main(String[] args) {
		ListAllFiles l = new ListAllFiles(new File("d:/SkyDrive"), new File(
				"d:/1.txt"));
		List<Long> list = new ArrayList<Long>();
		list.add(new Long(0));
		l.setList(list);
		l.setFilePrint(new ListAllFilesOperator() {

			@Override
			public String getFilePrint(File file, int deepth) {
				String in = "";
				while (deepth-- > 0)
					in += "-";
				in += file.getName();
				in += "\n";
				return in;
			}

			@Override
			public void doOperate(File file, int deepth, List list) {
				String in = "";
				while (deepth-- > 0)
					in += "-";
				in += file.getName();
				System.out.println(in);
				// file.delete();
			}
		});
		l.listAllFiles();
		System.out.println(l.getList());
		System.out.println("end");
	}

}
