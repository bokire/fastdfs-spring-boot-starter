package com.github.bokire.fastdfs.core;

import java.io.IOException;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.DownloadCallback;
import org.csource.fastdfs.FileInfo;
import org.csource.fastdfs.TrackerServer;
import org.csource.fastdfs.UploadCallback;

public interface FastDfsOperations {

	TrackerServer borrowTrackerServer() throws Exception;

	TrackerServer borrowTrackerServer(Long borrowMaxWaitMillis) throws Exception;

	void returnTrackerServer(TrackerServer trackerServer);

	/**
	 * 上传文件
	 *
	 * @param local_filename
	 *            -- 本地需要上传的文件名
	 * @return -- 返回fileId则success，null则false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_file(String local_filename);

	/**
	 * 上传文件
	 *
	 * @param local_filename
	 *            -- 本地需要上传的文件名
	 * @param file_ext_name
	 *            -- 文件扩展名，不包括(.),null时去local_filename的扩展名
	 * @return -- 返回fileId则success，null则false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_file(String local_filename, String file_ext_name);

	/**
	 * 上传文件
	 *
	 * @param local_filename
	 *            -- 本地需要上传的文件名
	 * @param meta_list
	 *            -- 文件属性列表
	 * @return -- 返回fileId则success，null则false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_file(String local_filename, NameValuePair[] meta_list);

	/**
	 * 上传文件
	 *
	 * @param local_filename
	 *            -- 本地需要上传的文件名
	 * @param file_ext_name
	 *            -- 文件扩展名，不包括(.),null时去local_filename的扩展名
	 * @param meta_list
	 *            -- 文件属性列表
	 * @return -- 返回fileId则success，null则false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_file(String local_filename, String file_ext_name, NameValuePair[] meta_list);

	/**
	 * 上传文件
	 *
	 * @param group_name
	 *            -- 指定storageServer组名
	 * @param local_filename
	 *            -- 本地需要上传的文件名
	 * @param file_ext_name
	 *            -- 文件扩展名，不包括(.),null时取local_filename的扩展名
	 * @param meta_list
	 *            -- 文件属性列表
	 * @return -- 返回fileId则success，null则false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_file(String group_name, String local_filename, String file_ext_name, NameValuePair[] meta_list);

	/**
	 * 上传文件
	 *
	 * @param --
	 *            file_buff 文件内容
	 * @param --
	 *            file_ext_name 文件扩展名，不包括(.)
	 * @return -- 返回fileId则success，null则false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_file(byte[] file_buff, String file_ext_name);

	/**
	 * 上传文件
	 *
	 * @param --
	 *            file_buff 文件内容
	 * @param --
	 *            file_ext_name 文件扩展名，不包括(.)
	 * @param meta_list
	 *            -- 文件属性列表
	 * @return -- 返回fileId则success，null则false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_file(byte[] file_buff, String file_ext_name, NameValuePair[] meta_list);

	/**
	 * 上传文件
	 *
	 * @param group_name
	 *            -- 指定storageServer组名
	 * @param file_buff
	 *            -- 文件内容
	 * @param file_ext_name
	 *            -- 文件扩展名，不包括(.)
	 * @param meta_list
	 *            -- 文件属性列表
	 * @return -- 返回fileId则success，null则false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_file(String group_name, byte[] file_buff, String file_ext_name, NameValuePair[] meta_list);

	/**
	 * 上传文件
	 *
	 * @param group_name
	 *            -- 指定storageServer组名
	 * @param file_size
	 *            -- 文件大小
	 * @param callback
	 *            -- callback对象，数据到达时会调用callback.recv()详见官方API
	 * @param file_ext_name
	 *            -- 文件扩展名，不包括(.)
	 * @param meta_list
	 *            -- 文件属性列表
	 * @return -- 返回fileId则success，null则false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_file(String group_name, long file_size, UploadCallback callback, String file_ext_name,
			NameValuePair[] meta_list);

	/**
	 * 上传appender文件
	 *
	 * @param local_filename
	 *            -- 本地需要上传的文件名
	 * @param file_ext_name
	 *            -- 文件扩展名，不包括(.),null时取local_filename的扩展名
	 * @param meta_list
	 *            文件属性列表
	 * @return -- 返回fileId则success，null则false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_appender_file(String local_filename, String file_ext_name, NameValuePair[] meta_list);

	/**
	 * 上传appender文件
	 *
	 * @param group_name
	 *            -- 指定storageServer组名
	 * @param local_filename
	 *            -- 本地需要上传的文件名
	 * @param file_ext_name
	 *            -- 文件扩展名，不包括(.),null时取local_filename的扩展名
	 * @param meta_list
	 *            -- 文件属性列表
	 * @return -- 返回fileId则success，null则false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_appender_file(String group_name, String local_filename, String file_ext_name,
			NameValuePair[] meta_list);

	/**
	 * 上传appender文件
	 *
	 * @param file_buff
	 *            -- 文件内容
	 * @param file_ext_name
	 *            -- 文件扩展名，不包括(.)
	 * @param meta_list
	 *            -- 文件属性列表
	 * @return -- 返回fileId则success，null则false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_appender_file(byte[] file_buff, String file_ext_name, NameValuePair[] meta_list);

	/**
	 * 上传appender文件
	 *
	 * @param group_name
	 *            -- 指定storageServer组名
	 * @param file_buff
	 *            文件内容
	 * @param file_ext_name
	 *            -- 文件扩展名，不包括(.)
	 * @param meta_list
	 *            文件属性列表
	 * @return -- 返回fileId则success，null则false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_appender_file(String group_name, byte[] file_buff, String file_ext_name, NameValuePair[] meta_list);

	/**
	 * 上传appender文件
	 *
	 * @param group_name
	 *            -- 指定storageServer组名
	 * @param file_size
	 *            -- 文件大小
	 * @param callback
	 *            -- callback对象，数据到达时会调用callback.recv()详见官方API
	 * @param file_ext_name
	 *            -- 文件扩展名，不包括(.)
	 * @param meta_list
	 * @return -- 返回fileId则success，null则false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_appender_file(String group_name, long file_size, UploadCallback callback, String file_ext_name,
			NameValuePair[] meta_list);

	/**
	 * 上传从文件
	 *
	 * @param master_file_id
	 *            -- 主文件fileId
	 * @param prefix_name
	 *            -- 从文件名
	 * @param local_filename
	 *            -- 本地需要上传的从文件名
	 * @param file_ext_name
	 *            -- 文件扩展名，不包括（.）,null时取local_filename的扩展名
	 * @param meta_list
	 *            文件属性列表
	 * @return -- 返回fileId则success，null则false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_file(String master_file_id, String prefix_name, String local_filename, String file_ext_name,
			NameValuePair[] meta_list);

	/**
	 * 上传从文件
	 *
	 * @param master_file_id
	 *            -- 主文件fileId
	 * @param prefix_name
	 *            -- 从文件名
	 * @param file_buff
	 *            -- 从文件内容
	 * @param file_ext_name
	 *            -- 文件扩展名，不包括（.）,null时取local_filename的扩展名
	 * @param meta_list
	 *            文件属性列表
	 * @return -- 返回fileId则success，null则false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_file(String master_file_id, String prefix_name, byte[] file_buff, String file_ext_name,
			NameValuePair[] meta_list);

	/**
	 * 上传从文件
	 *
	 * @param master_file_id
	 *            -- 主文件fileId
	 * @param prefix_name
	 *            -- 从文件名
	 * @param file_buff
	 *            -- 从文件内容
	 * @param offset
	 *            -- start offset of the buffer
	 * @param length
	 *            -- the length of the buffer to append
	 * @param file_ext_name
	 *            -- 文件扩展名，不包括(.)
	 * @param meta_list
	 *            -- 文件属性列表
	 * @return -- 返回fileId则success，null则false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_file(String master_file_id, String prefix_name, byte[] file_buff, int offset, int length,
			String file_ext_name, NameValuePair[] meta_list);

	/**
	 * 上传从文件
	 *
	 * @param master_file_id
	 *            -- 主文件fileId
	 * @param prefix_name
	 *            -- 从文件名
	 * @param file_size
	 *            -- 从文件大小
	 * @param callback
	 *            -- callback对象，数据到达时会调用callback.recv()详见官方API
	 * @param file_ext_name
	 *            -- 文件扩展名，不包括(.)
	 * @param meta_list
	 *            -- 文件属性列表
	 * @return -- 返回fileId则success，null则false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_file(String master_file_id, String prefix_name, long file_size, UploadCallback callback,
			String file_ext_name, NameValuePair[] meta_list);

	/**
	 * 追加上传文件
	 *
	 * @param appender_file_id
	 *            -- appender文件fileId
	 * @param local_filename
	 *            -- 追加上传文件的文件名
	 * @return -- 返回0则success，!=0则false
	 * @throws IOException
	 * @throws MyException
	 */
	int append_file(String appender_file_id, String local_filename);

	/**
	 * 追加上传文件
	 *
	 * @param appender_file_id
	 *            -- appender文件fileId
	 * @param file_buff
	 *            -- 追加上传的内容
	 * @return -- 返回0则success，!=0则false
	 * @throws IOException
	 * @throws MyException
	 */
	int append_file(String appender_file_id, byte[] file_buff);

	/**
	 * 追加上传文件
	 *
	 * @param appender_file_id
	 *            -- appender文件fileId
	 * @param file_buff
	 *            -- 追加上传的内容
	 * @param offset
	 *            -- start offset of the buffer
	 * @param length
	 *            -- the length of the buffer to append
	 * @return -- 返回0则success，!=0则false
	 * @throws IOException
	 * @throws MyException
	 */
	int append_file(String appender_file_id, byte[] file_buff, int offset, int length);

	/**
	 * 追加上传文件内容
	 *
	 * @param appender_file_id
	 *            appender文件fileId
	 * @param file_size
	 *            --文件大小
	 * @param callback
	 *            -- callback对象，数据到达时会调用callback.recv()详见官方API
	 * @return 返回0则success，!=0则false
	 * @throws IOException
	 * @throws MyException
	 */
	int append_file(String appender_file_id, long file_size, UploadCallback callback);

	/**
	 *
	 *
	 * @param appender_file_id
	 *            -- appender文件fileId
	 * @param file_offset
	 *            -- appender文件开始修改的位置
	 * @param local_filename
	 *            -- 本地文件名
	 * @return 返回fileId则success，null则false
	 * @throws IOException
	 * @throws MyException
	 */
	int modify_file(String appender_file_id, long file_offset, String local_filename);

	/**
	 *
	 *
	 * @param appender_file_id
	 *            -- appender文件fileId
	 * @param file_offset
	 *            -- appender文件开始修改的位置
	 * @param file_buff
	 *            -- 修改的文件内容
	 * @return 返回0则success，!=0则false
	 * @throws IOException
	 * @throws MyException
	 */
	int modify_file(String appender_file_id, long file_offset, byte[] file_buff);

	/**
	 *
	 *
	 * @param appender_file_id
	 *            -- appender文件fileId
	 * @param file_offset
	 *            -- appender文件开始修改的位置
	 * @param file_buff
	 *            -- 修改的文件内容
	 * @param buffer_offset
	 *            -- 修改内容开始位置
	 * @param buffer_length
	 *            -- 修改内容长度
	 * @return -- 返回0则success，!=0则false
	 * @throws IOException
	 * @throws MyException
	 */
	int modify_file(String appender_file_id, long file_offset, byte[] file_buff, int buffer_offset, int buffer_length);

	/**
	 * 修改文件
	 *
	 * @param appender_file_id
	 *            -- appender文件fileId
	 * @param file_offset
	 *            -- appender文件开始修改的位置
	 * @param modify_size
	 *            -- 修改大小
	 * @param callback
	 *            -- callback对象，数据到达时会调用callback.recv()详见官方API
	 * @return 返回0则success，!=0则false
	 * @throws IOException
	 * @throws MyException
	 */
	int modify_file(String appender_file_id, long file_offset, long modify_size, UploadCallback callback);

	/**
	 * 删除文件
	 *
	 * @param file_id
	 *            删除文件的fileId
	 * @return -- 返回0则success，!=0则false
	 * @throws IOException
	 * @throws MyException
	 */
	int delete_file(String file_id);

	/**
	 *
	 *
	 * @param appender_file_id
	 * @return --返回0则success，!=0则false
	 * @throws IOException
	 * @throws MyException
	 */
	int truncate_file(String appender_file_id);

	/**
	 * 
	 *
	 * @param appender_file_id
	 * @param truncated_file_size
	 * @return -- 返回0则success，!=0则false
	 * @throws IOException
	 * @throws MyException
	 */
	int truncate_file(String appender_file_id, long truncated_file_size);

	/**
	 * 下载文件
	 *
	 * @param file_id
	 *            -- 文件fileId
	 * @return
	 * @throws IOException
	 * @throws MyException
	 */
	byte[] download_file(String file_id);

	/**
	 * 下载文件
	 *
	 * @param file_id
	 *            -- 文件fileId
	 * @param file_offset
	 *            -- the start offset of the file
	 * @param download_bytes
	 *            -- download bytes, 0 for remain bytes from offset
	 * @return
	 * @throws IOException
	 * @throws MyException
	 */
	byte[] download_file(String file_id, long file_offset, long download_bytes);

	/**
	 * 下载文件
	 *
	 * @param file_id
	 *            -- 文件fileId
	 * @param local_filename
	 *            -- 下载到本地的名字
	 * @return -- 返回0则success，!=0则false
	 * @throws IOException
	 * @throws MyException
	 */
	int download_file(String file_id, String local_filename);

	/**
	 * 下载文件
	 *
	 * @param file_id
	 *            -- 文件fileId
	 * @param file_offset
	 *            -- the start offset of the file
	 * @param download_bytes
	 *            -- download bytes, 0 for remain bytes from offset
	 * @param local_filename
	 *            -- 下载到本地的名字
	 * @return 返回0则success，!=0则false
	 * @throws IOException
	 * @throws MyException
	 */
	int download_file(String file_id, long file_offset, long download_bytes, String local_filename);

	/**
	 * 下载文件
	 *
	 * @param file_id
	 *            -- 文件fileId
	 * @param callback
	 *            -- callback对象，数据到达时会调用callback.recv()详见官方API
	 * @return -- 返回0则success，!=0则false
	 * @throws IOException
	 * @throws MyException
	 */
	int download_file(String file_id, DownloadCallback callback);

	/**
	 * 下载文件
	 *
	 * @param file_id
	 *            -- 文件fileId
	 * @param file_offset
	 *            -- the start offset of the file
	 * @param download_bytes
	 *            -- download bytes, 0 for remain bytes from offset
	 * @param callback
	 *            -- callback对象，数据到达时会调用callback.recv()详见官方API
	 * @return -- 返回0则success，!=0则false
	 * @throws IOException
	 * @throws MyException
	 */
	int download_file(String file_id, long file_offset, long download_bytes, DownloadCallback callback);

	/**
	 * 
	 *
	 * @param file_id
	 * @return
	 * @throws IOException
	 * @throws MyException
	 */
	NameValuePair[] get_metadata(String file_id);

	/**
	 *
	 *
	 * @param file_id
	 * @param meta_list
	 * @param op_flag
	 * @return
	 * @throws IOException
	 * @throws MyException
	 */
	int set_metadata(String file_id, NameValuePair[] meta_list, byte op_flag);

	/**
	 *
	 *
	 * @param file_id
	 * @return
	 * @throws IOException
	 * @throws MyException
	 */
	FileInfo query_file_info(String file_id);

	/**
	 * 
	 *
	 * @param file_id
	 * @return
	 * @throws IOException
	 * @throws MyException
	 */
	FileInfo get_file_info(String file_id);
}
