package cn.itcast.util;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MD5Util {
	private static final char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
			'e', 'f' };

	public final static String getMD5(String s) {
		try {
			byte[] btInput = s.getBytes();
			// 获得 MD5 摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取加盐的MD5
	 *
	 * @author: 	en
	 * @date:   	2018年11月23日 下午2:42:30
	 *   
	 * @param s
	 * @return
	 */
	public final static String getMD5WithSalt(String s) {
		/**
		 * 计算方法
		 * 求出小于32的素数 排序
		 * 序号	素数		素数÷序号=商...余数
		 * 1	2		2÷1=2...0
		 * 2	3		3÷2=1...1
		 * 3	5		5÷3=1...2
		 * 4	7		7÷4=1...3
		 * 5	11		11÷5=2...1
		 * 6	13		13÷6=2...1
		 * 7	17		17÷7=2...3
		 * 8	19		19÷8=2...3
		 * 9	23		23÷9=2...5
		 * 10	29		29÷10=2...9
		 * 11	31		31÷11=2...7
		 * 
		 * 排除掉整除 以及 商和余数相等的情况 (素数2和3)
		 * 其他的在 （素数-1） 作为插入点插入 商 数个盐值
		 */
		
		// 生成16位的随机字符串
		char[] tempChars = new char[16];
		Random r = new Random();
		for (int i = 0; i < tempChars.length; i++) {
			int ix = r.nextInt(16);
			tempChars[i] = hexDigits[ix];
		}
		String salt = new String(tempChars);
		// 计算传入的 字符串+salt的MD5值
		String password = MD5Util.getMD5(s + salt);
		// ===向生成的MD5中插入 盐值
		StringBuilder sbBuilder = new StringBuilder(password);
		int saltIndex = 0;
		int lenInserted = 0;
		List<Integer> sList = MD5Util.getPrimeNumber();
		for (int i = 1, len = sList.size(); i <= len; i++) {
			int v = sList.get(i - 1);
			if ((v % i == 0) || (v / i == v % i)) {
				continue;
			}
			int iLen = v / i;// 要插入的长度 -(素数/序号（该序号从1开始计算）)
			int endIndex = saltIndex + iLen;// 要从
											// “盐”中裁剪字符串的结束位置--开始位置+截取的长度（=要插入的长度
			String iValue = salt.substring(saltIndex, endIndex);// 截取要插入的字符串
			saltIndex = endIndex;// 更新“盐”下次截取的开始位置
			int iIndex = v - 1 + lenInserted;// 计算要插入的位置=素数的值-1+已经插入的长度
			sbBuilder.insert(iIndex, iValue);// 插入盐值
			lenInserted += iLen;// 更新已经插入的长度
		}
		return sbBuilder.toString();
	}

	/**
	 * 校验加盐的MD5
	 *
	 * @author: 	en
	 * @date:   	2018年11月23日 下午2:43:03
	 *   
	 * @param password 	需要校验的密码
	 * @param md5 	 原来的MD5密码
	 * @return
	 */
	public static boolean verify(String password, String md5) {
		// 创建一个 StringBuilder 用于获取去掉盐值后的字符串 即 （password+salt）的md5值
		StringBuilder sBuilder = new StringBuilder(md5);
		// 用于存放提出的盐值
		StringBuilder sbSalt = new StringBuilder();
		// 获取32以内的素数
		List<Integer> sList = MD5Util.getPrimeNumber();
		int lenInserted = 0;
		for (int i = 1, len = sList.size(); i <= len; i++) {
			int v = sList.get(i - 1);
			if ((v % i == 0) || (v / i == v % i)) {
				continue;
			}
			int iLen = v / i;// 原来插入的长度 -(素数/序号（该序号从1开始计算）)
			int iIndex = v - 1 + lenInserted;// 计算原来插入的位置=素数的值-1+已经插入的长度
			lenInserted += iLen;// 更新已经插入的长度
			String string = md5.substring(iIndex, iIndex + iLen);
			sbSalt.append(string);// 保存提出的盐值
			sBuilder.delete(v - 1, v - 1 + iLen);// 剔除对应位置的盐值
		}
		return getMD5(password + sbSalt.toString()).equals(sBuilder.toString());
	}

	private static List<Integer> getPrimeNumber() {
		List<Integer> sList = new ArrayList<Integer>();
		// 求出32以内的素数
		int i, j, k;
		for (i = 2; i < 32; i++) {
			k = (int) Math.sqrt(i);
			for (j = 2; j <= k; j++) {

				if (i % j == 0)
					break;

			}
			if (j > k) {
				sList.add(i);
			}
		}
		return sList;
	}

	public static void main(String[] args) {

		String pString = "werfghjgsxacdfgdf";

		for (int i = 0; i < 5; i++) {
			String md5 = getMD5WithSalt(pString);
			System.out.println(md5);
			System.out.println(verify(pString, md5));
		}

	}
}
