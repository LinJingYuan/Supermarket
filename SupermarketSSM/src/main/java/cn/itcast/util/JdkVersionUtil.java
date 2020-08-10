package cn.itcast.util;

public class JdkVersionUtil {
	private static final String javaVersion;
	private static boolean isJava8;

	static {
		javaVersion = System.getProperty("java.version");
		System.out.println("javaVersion=" + javaVersion);
		if (javaVersion.contains("1.8.")) {
			isJava8 = true;
		}
	}

	public static String getJavaVersion() {
		return javaVersion;
	}

	public static boolean isJava8() {
		return isJava8;
	}
}