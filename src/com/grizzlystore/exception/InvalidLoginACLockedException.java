package com.grizzlystore.exception;

public class InvalidLoginACLockedException extends Exception {
	
	private static int invalidLoginCount;
	public static int getInvalidLoginCount() {
		return invalidLoginCount;
	}

	public static void setInvalidLoginCount(int invalidLoginCount) {
		InvalidLoginACLockedException.invalidLoginCount = invalidLoginCount;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String str;
	
	InvalidLoginACLockedException(String str)
	{
	this.str=str;
	}
}
