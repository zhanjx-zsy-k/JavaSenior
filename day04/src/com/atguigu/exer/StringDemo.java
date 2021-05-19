package com.atguigu.exer;

import org.junit.Test;

import java.util.Arrays;

/**
 * /*
 * 1.模拟一个trim方法，去除字符串两端的空格。
 * <p>
 * 2.将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
 * <p>
 * 3.获取一个字符串在另一个字符串中出现的次数。
 * 比如：获取“ab”在 “cdabkkcadkabkebfkabkskab”
 * 中出现的次数
 * <p>
 * 4.获取两个字符串中最大相同子串。比如：
 * str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"//10
 * 提示：将短的那个串进行长度依次递减的子串与较长
 * 的串比较。
 * <p>
 * 5.对字符串中字符进行自然顺序排序。"abcwerthelloyuiodef"
 * 提示：
 * 1）字符串变成字符数组。
 * 2）对数组排序，选择，冒泡，Arrays.sort(str.toCharArray());
 * 3）将排序后的数组变成字符串。
 *
 * @author k
 * @create 2021-04-14 18:05
 */
public class StringDemo {
    public static void main(String[] args) {
        StringDemo s1 = new StringDemo();
        System.out.println(s1.reverse1("abcde", 1, 3));
        System.out.println(s1.reverse2("abcde", 1, 3));
        System.out.println(s1.reverse3("abcde", 1, 3));
        System.out.println(s1.getCount("abcabababababsjdklabab", "ab"));

        System.out.println(s1.getMaxSameString("ababcabcd", "abc"));

        System.out.println(s1.mySort("gjdfklvnlasfqoajpxzcjo"));
    }


    // 第1题
    public String myTrim(String str) {
        if (str != null) {
            int start = 0;// 用于记录从前往后首次索引位置不是空格的位置的索引
            int end = str.length() - 1;// 用于记录从后往前首次索引位置不是空格的位置的索引

            while (start < end && str.charAt(start) == ' ') {
                start++;
            }

            while (start < end && str.charAt(end) == ' ') {
                end--;
            }
            if (str.charAt(start) == ' ') {
                return "";
            }

            return str.substring(start, end + 1);
        }
        return null;
    }
    @Test
    public void testMyTrim(){
        System.out.println(myTrim("   s d    "));
    }

    // 第2题
    // 方式一：
    public String reverse1(String str, int start, int end) {// start:2,end:5
        if (str != null) {
            // 1.
            char[] charArray = str.toCharArray();
            // 2.
            for (int i = start, j = end; i < j; i++, j--) {
                char temp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = temp;
            }
            // 3.
            return new String(charArray);

        }
        return null;

    }

    // 方式二：
    public String reverse2(String str, int start, int end) {
        String str1 = str.substring(0, start);
        for (int i = end; i >= start; i--) {
            str1 += str.charAt(i);
        }
        str1 += str.substring(end + 1);
        return str1;
    }

    // 方式三：
    public String reverse3(String str, int start, int end) {
        StringBuffer s = new StringBuffer(str.length());
        s.append(str.substring(0, start));
        for (int i = end; i >= start; i--) {
            s.append(str.charAt(i));
        }
        s.append(str.substring(end + 1));
        return s.toString();
    }

    // 第3题
    // 判断str2在str1中出现的次数
    public int getCount(String mainStr, String subStr) {
        if (mainStr.length() >= subStr.length()) {
            int count = 0;
            int index = 0;
            // while((index = mainStr.indexOf(subStr)) != -1){
            // count++;
            // mainStr = mainStr.substring(index + subStr.length());
            // }
            // 改进：
            while ((index = mainStr.indexOf(subStr, index)) != -1) {
                index += subStr.length();
                count++;
            }
            return count;
        } else {
            return 0;
        }

    }


    //前提：两个字符串中只有一个最大相同子串
    public String getMaxSameString(String str1, String str2) {
        if (str1 != null && str2 != null) {
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() < str2.length()) ? str1 : str2;
            int length = minStr.length();

            for (int i = 0; i < length; i++) {
                for (int x = 0, y = length - i; y <= length; x++, y++) {
                    String subStr = minStr.substring(x, y);
                    if (maxStr.contains(subStr)) {
                        return subStr;
                    }

                }
            }

        }
        return null;
    }

    //第5题
    public String mySort(String str) {

        char[] arr = str.toCharArray();
        Arrays.sort(arr);

        return new String(arr);
    }

    //第四题补充
    // 如果存在多个长度相同的最大相同子串
    // 此时先返回String[]，后面可以用集合中的ArrayList替换，较方便
    public String[] getMaxSameSubString1(String str1, String str2) {
        if (str1 != null && str2 != null) {
            StringBuffer sBuffer = new StringBuffer();
            String maxString = (str1.length() > str2.length()) ? str1 : str2;
            String minString = (str1.length() > str2.length()) ? str2 : str1;
            int len = minString.length();
            for (int i = 0; i < len; i++) {
                for (int x = 0, y = len - i; y <= len; x++, y++) {
                    String subString = minString.substring(x, y);
                    if (maxString.contains(subString)) {
                        sBuffer.append(subString + ",");
                    }
                }
                System.out.println(sBuffer);
                if (sBuffer.length() != 0) {
                    break;
                }
            }
            String[] split = sBuffer.toString().replaceAll(",$", "").split("\\,");
            return split;
        }
        return null;
    }
    // 如果存在多个长度相同的最大相同子串：使用ArrayList
//	public List<String> getMaxSameSubString1(String str1, String str2) {
//		if (str1 != null && str2 != null) {
//			List<String> list = new ArrayList<String>();
//			String maxString = (str1.length() > str2.length()) ? str1 : str2;
//			String minString = (str1.length() > str2.length()) ? str2 : str1;
//
//			int len = minString.length();
//			for (int i = 0; i < len; i++) {
//				for (int x = 0, y = len - i; y <= len; x++, y++) {
//					String subString = minString.substring(x, y);
//					if (maxString.contains(subString)) {
//						list.add(subString);
//					}
//				}
//				if (list.size() != 0) {
//					break;
//				}
//			}
//			return list;
//		}
//
//		return null;
//	}

}








