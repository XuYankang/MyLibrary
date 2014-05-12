package io;

import java.io.File;
import java.util.List;

public interface ListAllFilesOperator {

	/**
	 * generate the String depends on given file and the file lever <br>
	 * lever = deepth <br>
	 * <b> use preorder traversal</b>
	 * 
	 * @param file
	 * @param lever
	 * @return
	 */
	String getFilePrint(File file, int deepth);

	/**
	 * you can do customer operations according to the given arguments,such as
	 * calculate the file size <br>
	 * <b> use postorder traversal</b>
	 * 
	 * @param file
	 * @param list
	 */
	void doOperate(File file, int deepth, List list);
}
