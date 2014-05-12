package io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
/**
 * 添加了对一个文件夹所有文件处理的类。可以自定义方法。
 * 遍历一个文件夹所有类。实现getFilePrint接口，可以先序遍历并输出到一个文件。
 * 实现doOperate可以对文件进行一些操作，例如统计大小等。变量可以通过List传入。也可以实现删除文件夹功能。
 * @author Jacob
 *
 */
public class ListAllFiles {
	int writeBufferSize = 530000;
	private StringBuilder writeTofile = new StringBuilder(writeBufferSize);
	File outfile;
	File file;
	ListAllFilesOperator fileOperator;
	List list;

	/**
	 * This class can list all files in a directory in an organised layout
	 * 
	 * <b>not support the file which name contains space</b>
	 * 
	 * @param file
	 *            the file you want to list, both file or directory is ok
	 * @param outfile
	 *            the destination you put the output txt file. Better to use txt
	 *            format
	 */
	public ListAllFiles(File file, File outfile) {
		this.file = file;
		this.outfile = outfile;
	}

	/**
	 * trigger the list operation
	 */
	public void listAllFiles() {
		if (fileOperator == null) {
			fileOperator = new ListAllFilesOperator() {

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
				}
			};
		}
		listFiles(file, 0);
		// if the whole length less than the writeBufferSize, then write to file
		// here
		WriteToFile.appendStringToFile(writeTofile.toString(), outfile);
	}

	private void listFiles(File file, int deepth) {
		writeTofile.append(fileOperator.getFilePrint(file, deepth));
		if (writeTofile.length() > writeBufferSize) {
			WriteToFile.appendStringToFile(writeTofile.toString(), outfile);
			writeTofile = null;
			writeTofile = new StringBuilder(writeBufferSize);
		}

		if (file.isDirectory()) {

			deepth++;
			File[] files = file.listFiles();
			for (File f : files) {
				this.listFiles(f, deepth);
			}
			deepth--;
		}
		fileOperator.doOperate(file, deepth, list);
	}

	public File getOutfile() {
		return outfile;
	}

	public void setOutfile(File outfile) {
		this.outfile = outfile;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public int getWriteBufferSize() {
		return writeBufferSize;
	}

	/**
	 * set a proper size of the buffer in writting file
	 * 
	 * @param writeBufferSize
	 */
	public void setWriteBufferSize(int writeBufferSize) {
		this.writeBufferSize = writeBufferSize;
	}

	public ListAllFilesOperator getFilePrint() {
		return fileOperator;
	}

	/**
	 * use the customer print style, implement the interface ListAllFilesPrint
	 * if not set, use the default one
	 * 
	 * @param filePrint
	 */
	public void setFilePrint(ListAllFilesOperator filePrint) {
		this.fileOperator = filePrint;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

}
