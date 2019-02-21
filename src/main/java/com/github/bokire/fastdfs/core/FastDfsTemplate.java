package com.github.bokire.fastdfs.core;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.DownloadCallback;
import org.csource.fastdfs.FileInfo;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerServer;
import org.csource.fastdfs.UploadCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FastDfsTemplate implements FastDfsOperations {
	
	private  Logger logger = LoggerFactory.getLogger(FastDfsTemplate.class);
	
	private GenericObjectPool<TrackerServer> genericObjectPool;

	public FastDfsTemplate(GenericObjectPool<TrackerServer> genericObjectPool) {
		this.genericObjectPool = genericObjectPool;
	}

	private StorageClient1 getStorageClient(TrackerServer trackerServer) {
		return getStorageClient(trackerServer, null);
	}

	private StorageClient1 getStorageClient(TrackerServer trackerServer, StorageServer storageServer) {
		return new StorageClient1(trackerServer, storageServer);
	}

	@Override
	public TrackerServer borrowTrackerServer() throws Exception {
		return borrowTrackerServer(genericObjectPool.getMaxWaitMillis());
	}

	@Override
	public TrackerServer borrowTrackerServer(Long borrowMaxWaitMillis) throws Exception {
		return genericObjectPool.borrowObject(borrowMaxWaitMillis);
	}

	@Override
	public void returnTrackerServer(TrackerServer trackerServer) {
		genericObjectPool.returnObject(trackerServer);
	}

	@Override
	public String upload_file(String local_filename) {
		return upload_file(local_filename, null, null);
	}

	@Override
	public String upload_file(String local_filename, String file_ext_name) {
		return upload_file(local_filename, file_ext_name, null);
	}

	@Override
	public String upload_file(String local_filename, NameValuePair[] meta_list) {
		return upload_file(local_filename, null, meta_list);
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
	public String upload_file(byte[] file_buff, String file_ext_name) {
		return upload_file(null, file_buff, file_ext_name, null);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String upload_appender_file(String group_name, String local_filename, String file_ext_name,
			NameValuePair[] meta_list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String upload_appender_file(byte[] file_buff, String file_ext_name, NameValuePair[] meta_list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String upload_appender_file(String group_name, byte[] file_buff, String file_ext_name,
			NameValuePair[] meta_list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String upload_appender_file(String group_name, long file_size, UploadCallback callback, String file_ext_name,
			NameValuePair[] meta_list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String upload_file(String master_file_id, String prefix_name, String local_filename, String file_ext_name,
			NameValuePair[] meta_list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String upload_file(String master_file_id, String prefix_name, byte[] file_buff, String file_ext_name,
			NameValuePair[] meta_list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String upload_file(String master_file_id, String prefix_name, byte[] file_buff, int offset, int length,
			String file_ext_name, NameValuePair[] meta_list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String upload_file(String master_file_id, String prefix_name, long file_size, UploadCallback callback,
			String file_ext_name, NameValuePair[] meta_list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int append_file(String appender_file_id, String local_filename) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int append_file(String appender_file_id, byte[] file_buff) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int append_file(String appender_file_id, byte[] file_buff, int offset, int length) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int append_file(String appender_file_id, long file_size, UploadCallback callback) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modify_file(String appender_file_id, long file_offset, String local_filename) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modify_file(String appender_file_id, long file_offset, byte[] file_buff) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modify_file(String appender_file_id, long file_offset, byte[] file_buff, int buffer_offset,
			int buffer_length) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modify_file(String appender_file_id, long file_offset, long modify_size, UploadCallback callback) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete_file(String file_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int truncate_file(String appender_file_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int truncate_file(String appender_file_id, long truncated_file_size) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public byte[] download_file(String file_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] download_file(String file_id, long file_offset, long download_bytes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int download_file(String file_id, String local_filename) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int download_file(String file_id, long file_offset, long download_bytes, String local_filename) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int download_file(String file_id, DownloadCallback callback) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int download_file(String file_id, long file_offset, long download_bytes, DownloadCallback callback) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NameValuePair[] get_metadata(String file_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int set_metadata(String file_id, NameValuePair[] meta_list, byte op_flag) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FileInfo query_file_info(String file_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileInfo get_file_info(String file_id) {
		// TODO Auto-generated method stub
		return null;
	}


}
