package com.sample.util;

import java.util.Collection;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * This class is designed for common utility methods
 * 
 * @author shyam.pareek
 *
 */
@Component
public class AppUtils {

	/**
	 * Used for check string object should have non empty string If object is
	 * null or empty it gives you false otherwise returns true
	 * 
	 * @param value
	 * @return condition
	 */
	public static boolean hasValue(String value) {
		return StringUtils.hasText(value);
	}

	/**
	 * Used for check collection should have non empty. If collection is null or
	 * empty it gives you false otherwise returns true
	 * 
	 * @param value
	 * @return condition
	 */
	public static boolean hasValue(Collection value) {
		boolean flag = false;
		if (value != null && value.size() > 0) {
			flag = true;
		}
		return flag;
	}

	public static long generateUniqueId() {
		UUID idOne = UUID.randomUUID();
		String str = "" + idOne;
		int uid = str.hashCode();
		String filterStr = "" + uid;
		str = filterStr.replaceAll("-", "");
		return Long.parseLong(str);
	}
}
