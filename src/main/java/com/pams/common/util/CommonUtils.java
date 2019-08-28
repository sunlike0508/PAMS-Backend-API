package com.pams.common.util;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;


public final class CommonUtils {
    public static final String DF_YYYYMMDD = "yyyyMMdd";
    public static final String DF_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String DF_YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
    
    private CommonUtils() {
        throw new AssertionError();
    }
        
    /**
     * 오브젝트 NULL 검사
     */
	public static boolean isNull(Object obj) {
        return obj==null ? true : false;
    }
    
    /**
     * 오브젝트 NOT NULL 검사
     */
	public static boolean isNotNull(Object obj) {
        return obj!=null ? true : false;
    }
    
    /**
     * 문자열 타입 검사
     */
	public static boolean isString(Object obj) {
        if (isNotNull(obj)) {
            return (obj instanceof String) ? true : false;            
        }
        return false;
    }
    
    /**
     * Collection 타입 검사
     */
    public static boolean isCollection(Object obj) {
        if (isNotNull(obj)) {
            return (obj instanceof Collection<?>) ? true : false;
        }
        return false;
    }
    
    /**
     * 객체 유효성 체크
     * < 오브젝트가 아래 사항인 경우 TRUE >
     * - Null
     * - String Empty
     * - Collection Empty
     */
	public static boolean isEmpty(Object obj) {
		if (isNull(obj)) {
			return true;
		} else {
			if (isString(obj)) {
				if (((String) obj).isEmpty()) {
					return true;
				}
			} else if (isCollection(obj)) {
                if (((Collection<?>) obj).isEmpty()) {
                    return true;
                }
            }
		}

		return false;
	}
    
    /**
     * 객체 유효성 체크
     * < 오브젝트가 아래 사항인 경우 FALSE >
     * - Null
     * - String Empty
     * - Collection Empty
     */
	public static boolean isNotEmpty(Object obj) {
		if (isNull(obj)) {
			return false;
		} else {
			if (isString(obj)) {
				if (((String) obj).isEmpty()) {
					return false;
				}
			} else if (isCollection(obj)) {
				if (((Collection<?>) obj).isEmpty()) {
					return false;
				}
			}
		}

		return true;
	}
    
    /**
     * 안전한 문자열을 반환
     * @return null 인 경우 빈문자열("") 을 반환
     */
	public static String getSafeString(String value) {
        return getStringValue(value, "");
    }

    /**
     * 문자열 값 반환
     * @param obj 대상 인스턴스
     * @param defaultValue 기본값 
     * @return
     */
	public static String getStringValue(Object obj, String defaultValue) {
        if (!isEmpty(obj)) {
            return (String) obj;
        } else {
            return defaultValue;
        }
    }
	
	/**
	 * 숫자 값 반환 
	 * @param obj
	 * @param defaultValue
	 * @return
	 * 2016. 12. 12.
	 */
	public static int getNumericValue(Object obj, int defaultValue) {
        if (!isEmpty(obj)) {
            return (int) obj;
        } else {
            return defaultValue;
        }
    }
	

	public static Long getLongValue(Object obj, Long defaultValue) {
        if (!isEmpty(obj)) {
            return Long.parseLong(obj.toString());
        } else {
            return defaultValue;
        }
    }

	/**
	 * 현재 날짜 반환
	 */
	public static String getCurrentDate() {
		return getCurrentDate(null);
	}

	/**
	 * 현재 날짜 반환 : 기본 형식(yyyyMMdd)
	 */
	public static String getCurrentDate(String dateFormatStr) {
		if (isNull(dateFormatStr)) {
		    dateFormatStr = "yyyyMMdd";		    
		}

		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(dateFormatStr, Locale.getDefault());
		Date currentTime = new Date();
		return mSimpleDateFormat.format(currentTime);
	}
	
}