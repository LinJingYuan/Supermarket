package cn.itcast.util;
/**
 * 开发常用工具类
 * @author 方坚
 *
 */
public class Tools {
	/**
	 * 
	 * @param value
	 * @return 如果字符串不为空或者长度不为零返回true
	 */
	public static boolean isNotNull( String value ) {
		if( value == null || "".equals( value.trim()) || "null".equalsIgnoreCase(value) ) {
			return false;
		}
		return true;
	}
	
	/**
	 * ISO编码转换成UTF8编码
	 * @param s
	 * @return
	 */
	public static String ISOtoUTF8(String s) { 
		try { 
			s = new String(s.getBytes("iso-8859-1"), "utf-8"); 
		} catch (Exception e) { 
			
		} 
		return s; 
	}
	
	/**
	 * 是否为num
	 * @param str
	 * @return boolean
	 */
	public static boolean isNum(String str){	
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");	
	}
}
