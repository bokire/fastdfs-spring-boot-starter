package com.github.bokire.fastdfs.core;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.DownloadCallback;
import org.csource.fastdfs.FileInfo;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerServer;
import org.csource.fastdfs.UploadCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.bokire.fastdfs.pool.FastDfsPool;


public class FastDfsTemplate implements FastDfsOperations {
	
	private  Logger logger = LoggerFactory.getLogger(FastDfsTemplate.class);
	
	private FastDfsPool fastDfsPool;

	public FastDfsTemplate(FastDfsPool fastDfsPool) {
		this.fastDfsPool = fastDfsPool;
	}

	private StorageClient1 getStorageClient(TrackerServer trackerServer) {
		return getStorageClient(trackerServer, null);
	}

	private StorageClient1 getStorageClient(TrackerServer trackerServer, StorageServer storageServer) {
		return new StorageClient1(trackerServer, storageServer);
	}

	@Override
	public TrackerServer borrowTrackerServer() throws Exception {
		return fastDfsPool.getResource();
	}

	@Override
	public void returnTrackerServer(TrackerServer trackerServer) {
		fastDfsPool.returnResource(trackerServer);
	}

	
	@Override
	public String upload_file(String local_filename, String file_ext_name, NameValuePair[] meta_list) {
		return upload_file(null, local_filename, file_ext_name, meta_list);
	}

	@Override
	public String upload_file(String group_name, String local_filename, String file_ext_name,
			NameValuePair[] meta_list) {
		String fileId = null;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			fileId = storageClient1.upload_file1(group_name, local_filename, file_ext_name, meta_list);
		} catch (Exception e) {
			logger.error("upload file error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return fileId;
	}

	@Override
	public String upload_file(byte[] file_buff, String file_ext_name, NameValuePair[] meta_list) {
		return upload_file(null, file_buff, file_ext_name, meta_list);
	}

	@Override
	public String upload_file(String group_name, byte[] file_buff, String file_ext_name, NameValuePair[] meta_list) {
		String fileId = null;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			fileId = storageClient1.upload_file1(group_name, file_buff, file_ext_name, meta_list);
		} catch (Exception e) {
			logger.error("upload file error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return fileId;
	}

	@Override
	public String upload_file(String group_name, long file_size, UploadCallback callback, String file_ext_name,
			NameValuePair[] meta_list) {
		String fileId = null;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			fileId = storageClient1.upload_file1(group_name, file_size, callback, file_ext_name, meta_list);
		} catch (Exception e) {
			logger.error("upload file error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return fileId;
	}

	
	@Override
	public String upload_appender_file(String local_filename, String file_ext_name, NameValuePair[] meta_list) {
		return upload_appender_file(null, local_filename, file_ext_name, meta_list);
	}

	@Override
	public String upload_appender_file(String group_name, String local_filename, String file_ext_name,
			NameValuePair[] meta_list) {
		String fileId = null;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			fileId = storageClient1.upload_appender_file1(group_name, local_filename, file_ext_name, meta_list);
		} catch (Exception e) {
			logger.error("upload appender file error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return fileId;
	}

	@Override
	public String upload_appender_file(byte[] file_buff, String file_ext_name, NameValuePair[] meta_list) {
		return upload_appender_file(null, file_buff, file_ext_name, meta_list);
	}

	@Override
	public String upload_appender_file(String group_name, byte[] file_buff, String file_ext_name,
			NameValuePair[] meta_list) {
		String fileId = null;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			fileId = storageClient1.upload_appender_file1(group_name, file_buff, file_ext_name, meta_list);
		} catch (Exception e) {
			logger.error("upload file error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return fileId;
	}

	
	@Override
	public String upload_appender_file(String group_name, long file_size, UploadCallback callback, String file_ext_name,
			NameValuePair[] meta_list) {
		String fileId = null;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			fileId = storageClient1.upload_appender_file1(group_name, file_size, callback, file_ext_name, meta_list);
		} catch (Exception e) {
			logger.error("upload file error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return fileId;
	}

	@Override
	public String upload_file(String master_file_id, String prefix_name, String local_filename, String file_ext_name,
			NameValuePair[] meta_list) {
		String fileId = null;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			fileId = storageClient1.upload_file1(master_file_id, prefix_name, local_filename, file_ext_name, meta_list);
		} catch (Exception e) {
			logger.error("upload file error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return fileId;
	}

	@Override
	public String upload_file(String master_file_id, String prefix_name, byte[] file_buff, String file_ext_name,
			NameValuePair[] meta_list) {
		String fileId = null;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			fileId = storageClient1.upload_file1(master_file_id, prefix_name, file_buff, file_ext_name, meta_list);
		} catch (Exception e) {
			logger.error("upload file error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return fileId;
	}

	@Override
	public String upload_file(String master_file_id, String prefix_name, byte[] file_buff, int offset, int length,
			String file_ext_name, NameValuePair[] meta_list) {
		String fileId = null;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			fileId = storageClient1.upload_file1(master_file_id, prefix_name, file_buff, offset, length, file_ext_name, meta_list);
		} catch (Exception e) {
			logger.error("upload file error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return fileId;
	}

	@Override
	public String upload_file(String master_file_id, String prefix_name, long file_size, UploadCallback callback,
			String file_ext_name, NameValuePair[] meta_list) {
		String fileId = null;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			fileId = storageClient1.upload_file1(master_file_id, prefix_name, file_size, callback, file_ext_name, meta_list);
		} catch (Exception e) {
			logger.error("upload file error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return fileId;
	}

	@Override
	public int append_file(String appender_file_id, String local_filename) {
		int result = 0;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			result = storageClient1.append_file1(appender_file_id, local_filename);
		} catch (Exception e) {
			logger.error("append file error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return result;
	}

	@Override
	public int append_file(String appender_file_id, byte[] file_buff) {
		int result = 0;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			result = storageClient1.append_file1(appender_file_id, file_buff);
		} catch (Exception e) {
			logger.error("append file error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return result;
	}

	@Override
	public int append_file(String appender_file_id, byte[] file_buff, int offset, int length) {
		int result = 0;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			result = storageClient1.append_file1(appender_file_id, file_buff, offset, length);
		} catch (Exception e) {
			logger.error("append file error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return result;
	}

	@Override
	public int append_file(String appender_file_id, long file_size, UploadCallback callback) {
		int result = 0;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			result = storageClient1.append_file1(appender_file_id, file_size, callback);
		} catch (Exception e) {
			logger.error("append file error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return result;
	}

	@Override
	public int modify_file(String appender_file_id, long file_offset, String local_filename) {
		int result = 0;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			result = storageClient1.modify_file1(appender_file_id, file_offset, local_filename);
		} catch (Exception e) {
			logger.error("modify file error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return result;
	}

	@Override
	public int modify_file(String appender_file_id, long file_offset, byte[] file_buff) {
		int result = 0;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			result = storageClient1.modify_file1(appender_file_id, file_offset, file_buff);
		} catch (Exception e) {
			logger.error("modify file error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return result;
	}

	@Override
	public int modify_file(String appender_file_id, long file_offset, byte[] file_buff, int buffer_offset,
			int buffer_length) {
		int result = 0;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			result = storageClient1.modify_file1(appender_file_id, file_offset, file_buff, buffer_offset, buffer_length);
		} catch (Exception e) {
			logger.error("modify file error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return result;
	}

	@Override
	public int modify_file(String appender_file_id, long file_offset, long modify_size, UploadCallback callback) {
		int result = 0;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			result = storageClient1.modify_file1(appender_file_id, file_offset, modify_size, callback);
		} catch (Exception e) {
			logger.error("modify file error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return result;
	}

	@Override
	public int delete_file(String file_id) {
		int result = 0;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			result = storageClient1.delete_file1(file_id);
		} catch (Exception e) {
			logger.error("delete file error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return result;
	}

	@Override
	public int truncate_file(String appender_file_id) {
		int result = 0;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			result = storageClient1.truncate_file1(appender_file_id);
		} catch (Exception e) {
			logger.error("truncate file error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return result;
	}

	@Override
	public int truncate_file(String appender_file_id, long truncated_file_size) {
		int result = 0;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			result = storageClient1.truncate_file1(appender_file_id, truncated_file_size);
		} catch (Exception e) {
			logger.error("truncate file error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return result;
	}

	@Override
	public byte[] download_file(String file_id) {
		byte[] file = null;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			file = storageClient1.download_file1(file_id);
		} catch (Exception e) {
			logger.error("download file error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return file;
	}

	@Override
	public byte[] download_file(String file_id, long file_offset, long download_bytes) {
		byte[] file = null;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			file = storageClient1.download_file1(file_id, file_offset, download_bytes);
		} catch (Exception e) {
			logger.error("download file error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return file;
	}

	@Override
	public int download_file(String file_id, String local_filename) {
		int result = 0;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			result = storageClient1.download_file1(file_id, local_filename);
		} catch (Exception e) {
			logger.error("download file error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return result;
	}

	@Override
	public int download_file(String file_id, long file_offset, long download_bytes, String local_filename) {
		int result = 0;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			result = storageClient1.download_file1(file_id, file_offset, download_bytes, local_filename);
		} catch (Exception e) {
			logger.error("download file error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return result;
	}

	@Override
	public int download_file(String file_id, DownloadCallback callback) {
		int result = 0;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			result = storageClient1.download_file1(file_id, callback);
		} catch (Exception e) {
			logger.error("download file error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return result;
	}

	@Override
	public int download_file(String file_id, long file_offset, long download_bytes, DownloadCallback callback) {
		int result = 0;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			result = storageClient1.download_file1(file_id, file_offset, download_bytes, callback);
		} catch (Exception e) {
			logger.error("download file error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return result;
	}

	@Override
	public NameValuePair[] get_metadata(String file_id) {
		NameValuePair[] nvp = null;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			nvp = storageClient1.get_metadata1(file_id);
		} catch (Exception e) {
			logger.error("get metadata error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return nvp;
	}

	@Override
	public int set_metadata(String file_id, NameValuePair[] meta_list, byte op_flag) {
		int result = 0;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			result = storageClient1.set_metadata1(file_id, meta_list, op_flag);
		} catch (Exception e) {
			logger.error("set metadata error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return result;
	}

	@Override
	public FileInfo query_file_info(String file_id) {
		FileInfo fileInfo = null;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();

			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			fileInfo = storageClient1.query_file_info1(file_id);
		} catch (Exception e) {
			logger.error("query file info error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return fileInfo;
	}

	@Override
	public FileInfo get_file_info(String file_id) {
		FileInfo fileInfo = null;
		TrackerServer trackerServer = null;
		try {
			trackerServer = borrowTrackerServer();
			StorageClient1 storageClient1 = getStorageClient(trackerServer);
			fileInfo = storageClient1.get_file_info1(file_id);
		} catch (Exception e) {
			logger.error("get file info error", e);
		} finally {
			returnTrackerServer(trackerServer);
		}
		return fileInfo;
	}


}
