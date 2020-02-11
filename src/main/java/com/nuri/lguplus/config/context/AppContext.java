package com.nuri.lguplus.config.context;

import com.nuri.lguplus.domain.SampleDomain;

public class AppContext {
	private static final ThreadLocal<SampleDomain> currentUser = new ThreadLocal<>();

	public static void setCurrentUser(SampleDomain tenant) {
	    currentUser.set(tenant);
	}

	public static SampleDomain getCurrentUser() {
	    return currentUser.get();
	}

	public static void clear() {
	    currentUser.remove();
	}
}
