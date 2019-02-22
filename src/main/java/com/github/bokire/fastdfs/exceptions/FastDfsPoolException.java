package com.github.bokire.fastdfs.exceptions;

public class FastDfsPoolException extends RuntimeException {

	private static final long serialVersionUID = -7159162780228474729L;

	public FastDfsPoolException(String message) {
		super(message);
	}

	public FastDfsPoolException(Throwable e) {
		super(e);
	}

	public FastDfsPoolException(String message, Throwable cause) {
		super(message, cause);
	}
}
