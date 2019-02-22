package com.github.bokire.fastdfs.util;

public class PoolConfig {

	/**
	 * 当没有空闲连接时，获取一个对象的最大等待时间。
	 * 如果这个值小于0，则永不超时，一直等待，直到有空闲对象到来。
	 * 如果大于0，则等待maxWaitMillis长时间，如果没有空闲对象，将抛出NoSuchElementException异常。
	 * 默认值是-1；可以根据需要自己调整，单位是毫秒
	 */
	private long maxWaitMillis = -1L;
	/**
	 * 对象最小的空闲时间。如果为小于等于0，最Long的最大值，
	 * 如果大于0，当空闲的时间大于这个值时，执行移除这个对象操作。默认值是1000L * 60L * 30L;即30分钟。
	 * 这个参数是强制性的，只要空闲时间超过这个值，就会移除
	 */
	private long minEvictableIdleTimeMillis = 1000 * 60 * 30L;
	
	/**
	 * 对象最小的空间时间，如果小于等于0，取Long的最大值，
	 * 如果大于0，当对象的空闲时间超过这个值，并且当前空闲对象的数量大于最小空闲数量(minIdle)时，执行移除操作。
	 * 这个和上面的minEvictableIdleTimeMillis的区别是，它会保留最小的空闲对象数量。而上面的不会，是强制性移除的。
	 * 默认值是-1
	 */
	private long softMinEvictableIdleTimeMillis = -1L;
	
	/**
	 * 检测空闲对象线程每次检测的空闲对象的数量。默认值是3；如果这个值小于0,则每次检测的空闲对象数量等于当前空闲对象数量除以这个值的绝对值，并对结果向上取整
	 */
	private int numTestsPerEvictionRun = 3;
	
	/**
	 * 在创建对象时检测对象是否有效，true是，默认值是false
	 */
	private boolean testOnCreate = false;
	
	/**
	 * 在从对象池获取对象时是否检测对象有效，true是；默认值是false
	 */
	private boolean testOnBorrow = false;
	
	/**
	 * 在向对象池中归还对象时是否检测对象有效，true是，默认值是false
	 */
	private boolean testOnReturn = false;
	
	/**
	 * 在检测空闲对象线程检测到对象不需要移除时，是否检测对象的有效性。true是，默认值是false
	 */
	private boolean testWhileIdle = false;
	
	/**
	 * 空闲对象检测线程的执行周期，即多长时候执行一次空闲对象检测。单位是毫秒数。如果小于等于0，则不执行检测线程。默认值是-1
	 */
	private long timeBetweenEvictionRunsMillis = -1L;
	
	/**
	 * 当对象池没有空闲对象时，新的获取对象的请求是否阻塞。true阻塞。默认值是true
	 */
	private boolean blockWhenExhausted = true;
	
	/**
	 * 对象池中管理的最多对象个数。默认值是8
	 */
	private int maxTotal = 8;
	
	/**
	 * 对象池中最大的空闲对象个数。默认值是8
	 */
	private int maxIdle = 8;
	
	/**
	 * 对象池中最小的空闲对象个数。默认值是0
	 */
	private int minIdle = 0;

	public long getMaxWaitMillis() {
		return maxWaitMillis;
	}

	public void setMaxWaitMillis(long maxWaitMillis) {
		this.maxWaitMillis = maxWaitMillis;
	}

	public long getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}

	public void setMinEvictableIdleTimeMillis(long minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}

	public long getSoftMinEvictableIdleTimeMillis() {
		return softMinEvictableIdleTimeMillis;
	}

	public void setSoftMinEvictableIdleTimeMillis(long softMinEvictableIdleTimeMillis) {
		this.softMinEvictableIdleTimeMillis = softMinEvictableIdleTimeMillis;
	}

	public int getNumTestsPerEvictionRun() {
		return numTestsPerEvictionRun;
	}

	public void setNumTestsPerEvictionRun(int numTestsPerEvictionRun) {
		this.numTestsPerEvictionRun = numTestsPerEvictionRun;
	}

	public boolean isTestOnCreate() {
		return testOnCreate;
	}

	public void setTestOnCreate(boolean testOnCreate) {
		this.testOnCreate = testOnCreate;
	}

	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	public boolean isTestOnReturn() {
		return testOnReturn;
	}

	public void setTestOnReturn(boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}

	public boolean isTestWhileIdle() {
		return testWhileIdle;
	}

	public void setTestWhileIdle(boolean testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}

	public long getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}

	public void setTimeBetweenEvictionRunsMillis(long timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}

	public boolean isBlockWhenExhausted() {
		return blockWhenExhausted;
	}

	public void setBlockWhenExhausted(boolean blockWhenExhausted) {
		this.blockWhenExhausted = blockWhenExhausted;
	}

	public int getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}
	
}
