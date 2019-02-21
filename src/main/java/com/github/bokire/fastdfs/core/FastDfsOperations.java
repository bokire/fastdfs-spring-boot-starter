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
	 * �ϴ��ļ�
	 *
	 * @param local_filename
	 *            -- ������Ҫ�ϴ����ļ���
	 * @return -- ����fileId��success��null��false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_file(String local_filename);

	/**
	 * �ϴ��ļ�
	 *
	 * @param local_filename
	 *            -- ������Ҫ�ϴ����ļ���
	 * @param file_ext_name
	 *            -- �ļ���չ����������(.),nullʱȥlocal_filename����չ��
	 * @return -- ����fileId��success��null��false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_file(String local_filename, String file_ext_name);

	/**
	 * �ϴ��ļ�
	 *
	 * @param local_filename
	 *            -- ������Ҫ�ϴ����ļ���
	 * @param meta_list
	 *            -- �ļ������б�
	 * @return -- ����fileId��success��null��false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_file(String local_filename, NameValuePair[] meta_list);

	/**
	 * �ϴ��ļ�
	 *
	 * @param local_filename
	 *            -- ������Ҫ�ϴ����ļ���
	 * @param file_ext_name
	 *            -- �ļ���չ����������(.),nullʱȥlocal_filename����չ��
	 * @param meta_list
	 *            -- �ļ������б�
	 * @return -- ����fileId��success��null��false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_file(String local_filename, String file_ext_name, NameValuePair[] meta_list);

	/**
	 * �ϴ��ļ�
	 *
	 * @param group_name
	 *            -- ָ��storageServer����
	 * @param local_filename
	 *            -- ������Ҫ�ϴ����ļ���
	 * @param file_ext_name
	 *            -- �ļ���չ����������(.),nullʱȡlocal_filename����չ��
	 * @param meta_list
	 *            -- �ļ������б�
	 * @return -- ����fileId��success��null��false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_file(String group_name, String local_filename, String file_ext_name, NameValuePair[] meta_list);

	/**
	 * �ϴ��ļ�
	 *
	 * @param --
	 *            file_buff �ļ�����
	 * @param --
	 *            file_ext_name �ļ���չ����������(.)
	 * @return -- ����fileId��success��null��false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_file(byte[] file_buff, String file_ext_name);

	/**
	 * �ϴ��ļ�
	 *
	 * @param --
	 *            file_buff �ļ�����
	 * @param --
	 *            file_ext_name �ļ���չ����������(.)
	 * @param meta_list
	 *            -- �ļ������б�
	 * @return -- ����fileId��success��null��false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_file(byte[] file_buff, String file_ext_name, NameValuePair[] meta_list);

	/**
	 * �ϴ��ļ�
	 *
	 * @param group_name
	 *            -- ָ��storageServer����
	 * @param file_buff
	 *            -- �ļ�����
	 * @param file_ext_name
	 *            -- �ļ���չ����������(.)
	 * @param meta_list
	 *            -- �ļ������б�
	 * @return -- ����fileId��success��null��false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_file(String group_name, byte[] file_buff, String file_ext_name, NameValuePair[] meta_list);

	/**
	 * �ϴ��ļ�
	 *
	 * @param group_name
	 *            -- ָ��storageServer����
	 * @param file_size
	 *            -- �ļ���С
	 * @param callback
	 *            -- callback�������ݵ���ʱ�����callback.recv()����ٷ�API
	 * @param file_ext_name
	 *            -- �ļ���չ����������(.)
	 * @param meta_list
	 *            -- �ļ������б�
	 * @return -- ����fileId��success��null��false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_file(String group_name, long file_size, UploadCallback callback, String file_ext_name,
			NameValuePair[] meta_list);

	/**
	 * �ϴ�appender�ļ�
	 *
	 * @param local_filename
	 *            -- ������Ҫ�ϴ����ļ���
	 * @param file_ext_name
	 *            -- �ļ���չ����������(.),nullʱȡlocal_filename����չ��
	 * @param meta_list
	 *            �ļ������б�
	 * @return -- ����fileId��success��null��false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_appender_file(String local_filename, String file_ext_name, NameValuePair[] meta_list);

	/**
	 * �ϴ�appender�ļ�
	 *
	 * @param group_name
	 *            -- ָ��storageServer����
	 * @param local_filename
	 *            -- ������Ҫ�ϴ����ļ���
	 * @param file_ext_name
	 *            -- �ļ���չ����������(.),nullʱȡlocal_filename����չ��
	 * @param meta_list
	 *            -- �ļ������б�
	 * @return -- ����fileId��success��null��false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_appender_file(String group_name, String local_filename, String file_ext_name,
			NameValuePair[] meta_list);

	/**
	 * �ϴ�appender�ļ�
	 *
	 * @param file_buff
	 *            -- �ļ�����
	 * @param file_ext_name
	 *            -- �ļ���չ����������(.)
	 * @param meta_list
	 *            -- �ļ������б�
	 * @return -- ����fileId��success��null��false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_appender_file(byte[] file_buff, String file_ext_name, NameValuePair[] meta_list);

	/**
	 * �ϴ�appender�ļ�
	 *
	 * @param group_name
	 *            -- ָ��storageServer����
	 * @param file_buff
	 *            �ļ�����
	 * @param file_ext_name
	 *            -- �ļ���չ����������(.)
	 * @param meta_list
	 *            �ļ������б�
	 * @return -- ����fileId��success��null��false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_appender_file(String group_name, byte[] file_buff, String file_ext_name, NameValuePair[] meta_list);

	/**
	 * �ϴ�appender�ļ�
	 *
	 * @param group_name
	 *            -- ָ��storageServer����
	 * @param file_size
	 *            -- �ļ���С
	 * @param callback
	 *            -- callback�������ݵ���ʱ�����callback.recv()����ٷ�API
	 * @param file_ext_name
	 *            -- �ļ���չ����������(.)
	 * @param meta_list
	 * @return -- ����fileId��success��null��false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_appender_file(String group_name, long file_size, UploadCallback callback, String file_ext_name,
			NameValuePair[] meta_list);

	/**
	 * �ϴ����ļ�
	 *
	 * @param master_file_id
	 *            -- ���ļ�fileId
	 * @param prefix_name
	 *            -- ���ļ���
	 * @param local_filename
	 *            -- ������Ҫ�ϴ��Ĵ��ļ���
	 * @param file_ext_name
	 *            -- �ļ���չ������������.��,nullʱȡlocal_filename����չ��
	 * @param meta_list
	 *            �ļ������б�
	 * @return -- ����fileId��success��null��false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_file(String master_file_id, String prefix_name, String local_filename, String file_ext_name,
			NameValuePair[] meta_list);

	/**
	 * �ϴ����ļ�
	 *
	 * @param master_file_id
	 *            -- ���ļ�fileId
	 * @param prefix_name
	 *            -- ���ļ���
	 * @param file_buff
	 *            -- ���ļ�����
	 * @param file_ext_name
	 *            -- �ļ���չ������������.��,nullʱȡlocal_filename����չ��
	 * @param meta_list
	 *            �ļ������б�
	 * @return -- ����fileId��success��null��false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_file(String master_file_id, String prefix_name, byte[] file_buff, String file_ext_name,
			NameValuePair[] meta_list);

	/**
	 * �ϴ����ļ�
	 *
	 * @param master_file_id
	 *            -- ���ļ�fileId
	 * @param prefix_name
	 *            -- ���ļ���
	 * @param file_buff
	 *            -- ���ļ�����
	 * @param offset
	 *            -- start offset of the buffer
	 * @param length
	 *            -- the length of the buffer to append
	 * @param file_ext_name
	 *            -- �ļ���չ����������(.)
	 * @param meta_list
	 *            -- �ļ������б�
	 * @return -- ����fileId��success��null��false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_file(String master_file_id, String prefix_name, byte[] file_buff, int offset, int length,
			String file_ext_name, NameValuePair[] meta_list);

	/**
	 * �ϴ����ļ�
	 *
	 * @param master_file_id
	 *            -- ���ļ�fileId
	 * @param prefix_name
	 *            -- ���ļ���
	 * @param file_size
	 *            -- ���ļ���С
	 * @param callback
	 *            -- callback�������ݵ���ʱ�����callback.recv()����ٷ�API
	 * @param file_ext_name
	 *            -- �ļ���չ����������(.)
	 * @param meta_list
	 *            -- �ļ������б�
	 * @return -- ����fileId��success��null��false
	 * @throws IOException
	 * @throws MyException
	 */
	String upload_file(String master_file_id, String prefix_name, long file_size, UploadCallback callback,
			String file_ext_name, NameValuePair[] meta_list);

	/**
	 * ׷���ϴ��ļ�
	 *
	 * @param appender_file_id
	 *            -- appender�ļ�fileId
	 * @param local_filename
	 *            -- ׷���ϴ��ļ����ļ���
	 * @return -- ����0��success��!=0��false
	 * @throws IOException
	 * @throws MyException
	 */
	int append_file(String appender_file_id, String local_filename);

	/**
	 * ׷���ϴ��ļ�
	 *
	 * @param appender_file_id
	 *            -- appender�ļ�fileId
	 * @param file_buff
	 *            -- ׷���ϴ�������
	 * @return -- ����0��success��!=0��false
	 * @throws IOException
	 * @throws MyException
	 */
	int append_file(String appender_file_id, byte[] file_buff);

	/**
	 * ׷���ϴ��ļ�
	 *
	 * @param appender_file_id
	 *            -- appender�ļ�fileId
	 * @param file_buff
	 *            -- ׷���ϴ�������
	 * @param offset
	 *            -- start offset of the buffer
	 * @param length
	 *            -- the length of the buffer to append
	 * @return -- ����0��success��!=0��false
	 * @throws IOException
	 * @throws MyException
	 */
	int append_file(String appender_file_id, byte[] file_buff, int offset, int length);

	/**
	 * ׷���ϴ��ļ�����
	 *
	 * @param appender_file_id
	 *            appender�ļ�fileId
	 * @param file_size
	 *            --�ļ���С
	 * @param callback
	 *            -- callback�������ݵ���ʱ�����callback.recv()����ٷ�API
	 * @return ����0��success��!=0��false
	 * @throws IOException
	 * @throws MyException
	 */
	int append_file(String appender_file_id, long file_size, UploadCallback callback);

	/**
	 *
	 *
	 * @param appender_file_id
	 *            -- appender�ļ�fileId
	 * @param file_offset
	 *            -- appender�ļ���ʼ�޸ĵ�λ��
	 * @param local_filename
	 *            -- �����ļ���
	 * @return ����fileId��success��null��false
	 * @throws IOException
	 * @throws MyException
	 */
	int modify_file(String appender_file_id, long file_offset, String local_filename);

	/**
	 *
	 *
	 * @param appender_file_id
	 *            -- appender�ļ�fileId
	 * @param file_offset
	 *            -- appender�ļ���ʼ�޸ĵ�λ��
	 * @param file_buff
	 *            -- �޸ĵ��ļ�����
	 * @return ����0��success��!=0��false
	 * @throws IOException
	 * @throws MyException
	 */
	int modify_file(String appender_file_id, long file_offset, byte[] file_buff);

	/**
	 *
	 *
	 * @param appender_file_id
	 *            -- appender�ļ�fileId
	 * @param file_offset
	 *            -- appender�ļ���ʼ�޸ĵ�λ��
	 * @param file_buff
	 *            -- �޸ĵ��ļ�����
	 * @param buffer_offset
	 *            -- �޸����ݿ�ʼλ��
	 * @param buffer_length
	 *            -- �޸����ݳ���
	 * @return -- ����0��success��!=0��false
	 * @throws IOException
	 * @throws MyException
	 */
	int modify_file(String appender_file_id, long file_offset, byte[] file_buff, int buffer_offset, int buffer_length);

	/**
	 * �޸��ļ�
	 *
	 * @param appender_file_id
	 *            -- appender�ļ�fileId
	 * @param file_offset
	 *            -- appender�ļ���ʼ�޸ĵ�λ��
	 * @param modify_size
	 *            -- �޸Ĵ�С
	 * @param callback
	 *            -- callback�������ݵ���ʱ�����callback.recv()����ٷ�API
	 * @return ����0��success��!=0��false
	 * @throws IOException
	 * @throws MyException
	 */
	int modify_file(String appender_file_id, long file_offset, long modify_size, UploadCallback callback);

	/**
	 * ɾ���ļ�
	 *
	 * @param file_id
	 *            ɾ���ļ���fileId
	 * @return -- ����0��success��!=0��false
	 * @throws IOException
	 * @throws MyException
	 */
	int delete_file(String file_id);

	/**
	 *
	 *
	 * @param appender_file_id
	 * @return --����0��success��!=0��false
	 * @throws IOException
	 * @throws MyException
	 */
	int truncate_file(String appender_file_id);

	/**
	 * 
	 *
	 * @param appender_file_id
	 * @param truncated_file_size
	 * @return -- ����0��success��!=0��false
	 * @throws IOException
	 * @throws MyException
	 */
	int truncate_file(String appender_file_id, long truncated_file_size);

	/**
	 * �����ļ�
	 *
	 * @param file_id
	 *            -- �ļ�fileId
	 * @return
	 * @throws IOException
	 * @throws MyException
	 */
	byte[] download_file(String file_id);

	/**
	 * �����ļ�
	 *
	 * @param file_id
	 *            -- �ļ�fileId
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
	 * �����ļ�
	 *
	 * @param file_id
	 *            -- �ļ�fileId
	 * @param local_filename
	 *            -- ���ص����ص�����
	 * @return -- ����0��success��!=0��false
	 * @throws IOException
	 * @throws MyException
	 */
	int download_file(String file_id, String local_filename);

	/**
	 * �����ļ�
	 *
	 * @param file_id
	 *            -- �ļ�fileId
	 * @param file_offset
	 *            -- the start offset of the file
	 * @param download_bytes
	 *            -- download bytes, 0 for remain bytes from offset
	 * @param local_filename
	 *            -- ���ص����ص�����
	 * @return ����0��success��!=0��false
	 * @throws IOException
	 * @throws MyException
	 */
	int download_file(String file_id, long file_offset, long download_bytes, String local_filename);

	/**
	 * �����ļ�
	 *
	 * @param file_id
	 *            -- �ļ�fileId
	 * @param callback
	 *            -- callback�������ݵ���ʱ�����callback.recv()����ٷ�API
	 * @return -- ����0��success��!=0��false
	 * @throws IOException
	 * @throws MyException
	 */
	int download_file(String file_id, DownloadCallback callback);

	/**
	 * �����ļ�
	 *
	 * @param file_id
	 *            -- �ļ�fileId
	 * @param file_offset
	 *            -- the start offset of the file
	 * @param download_bytes
	 *            -- download bytes, 0 for remain bytes from offset
	 * @param callback
	 *            -- callback�������ݵ���ʱ�����callback.recv()����ٷ�API
	 * @return -- ����0��success��!=0��false
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
