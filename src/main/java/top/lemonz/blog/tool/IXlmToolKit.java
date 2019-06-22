package top.lemonz.blog.tool;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @intro Xlm工具包 接口
 * @path XlmQuery/cn.kaxlm6.publics.tool.IXlmToolKit
 * @author 小柠萌
 * @date 2018年6月10日 下午3:13:30
 * @versions 5.20
 */

public interface IXlmToolKit {

	/**
	 * 将一串字符更改格式,可间隔模糊查询 - ABC -> %A%B%C%
	 */
	String toMysqlLike(String nickName);

	/**
	 * 随机指定位数的一串数字 - 首尾不会为0
	 */
	String randomTo(int place);

	/**
	 * 拆解str字符串 - "ABC" -> A B AB C AC BC ABC
	 */
	String disassembleStr(String str);

	/**
	 * 将字符数字转换为int类型
	 */
	Integer parseInt(String number);

	/**
	 * 将字符数字转换为double类型
	 */
	Double parseDouble(String number);

	/**
	 * 将对象转换为json对象
	 */
	JSONObject parseJSONObject(Object obj);

	/**
	 * 格式化string为Date
	 */
	Date parseDate(String datestr);

	/**
	 * 保留两位小数(四舍五入)
	 */
	Double fnum(Double number);

	/**
	 * 将百分比转换为小数 - %10
	 */
	Double parseNf(String number);

	/**
	 * 将金额转换为千分位 - 3,600,000
	 */
	String parseDf(Object number);

	/**
	 * 将金额转换为千分位 - 3,600,000.00
	 */
	String parseDfs(Object number);

	/**
	 * 毫秒数转换为String类型的日期
	 */
	String ftime(Long time);

	/**
	 * 判断字符为空或者空字符或Empty{name='chars'} return 不为空返回true
	 */
	boolean isStrNull(String chars);

	/**
	 * 判断lsit集合为空或者长度为0 return 不为空返回true
	 */
	boolean isListNull(List<?> list);

	/**
	 * 判断Set集合为空或者长度为0 return 不为空返回true
	 */
	boolean isSetNull(Set<?> set);

	/**
	 * 判断map集合为空或者长度为0 return 不为空返回true
	 */
	boolean isMapNull(Map<?, ?> map);

	/**
	 * 判断是否为汉字(有一个就为true)
	 */
	boolean isChinese(String chars);

	/**
	 * 将请求参数转换为json对象 --> (将form表单参数转换为json对象，这样就不需要对应的实体类了)
	 */
	JSONObject formParseJsonObject(HttpServletRequest request);

	/**
	 * 获得请求头地址 - 从项目名-->请求的页面
	 */
	String getHeader(HttpServletRequest request);

	/**
	 * MD5加密(32位)
	 */
	String parseMD5(String chars);

	/**
	 * 英语-汉字-->语音朗读
	 */
	void voiceRead(String content);

	/**
	 * 转换Object为json字符串 jackson
	 */
	String parseJackson(Object object);

	/**
	 * 转换Object为json字符串 fastJson
	 */
	String parseFastJson(Object object);

	/**
	 * 获得归属地及运营商
	 */
	String getIpOperator(String ip);

	/**
	 * 获得足迹/信息
	 */
	Map<String, String> getNzInfo(HttpServletRequest request);

	/**
	 * 处理JSON数据的特殊字符 - 比如：' / \ \t \f \\ ......
	 */
	String stringJson(String strJson);

}
