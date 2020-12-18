/*
package top.lemonz.blog.tool.impl;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

*//**
 * Created by IntelliJ IDEA.
 *
 * @author NingZe
 * description: 短信发送
 * path: DecoSearch-manage-com.rerise.tool.impl-XlmSendMsg
 * date: 2020/12/18 0012 13:19
 * version: 02.06
 * To change this template use File | Settings | File Templates.
 *//*
public class XlmSendMsg {

    *//**
     * 产品名称:云通信短信API产品,开发者无需替换
     *//*
    private static final String product = "";

    *//**
     * 产品域名,开发者无需替换
     *//*
    private static final String domain = "";

    *//**
     * TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
     *//*
    private static final String accessKeyId = "";

    private static final String accessKeySecret = "";

    *//**
     * 组装请求对象-具体描述见控制台-文档部分内容
     *//*
    private static SendSmsRequest request = new SendSmsRequest();

    *//**
     * 初始化acsClient,暂不支持region化
     *//*
    private static IClientProfile profile = DefaultProfile.getProfile("", accessKeyId, accessKeySecret);
    static {
        try {
            DefaultProfile.addEndpoint("", "", product, domain);
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
    private static IAcsClient acsClient = new DefaultAcsClient(profile);

    private static SendSmsResponse sendSmsResponse = null;

    static {
        // 可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
    }


    *//**
     * 发送短信
     * @param phone - 手机号
     * @param signName - 短信签名
     * @param templateCode - 短信模板
     * @param templatePars - JSON格式参数
     * @return
     *//*
    public static SendSmsResponse sendSmsResponse(String phone, String signName, String templateCode, Map<String, String> templatePars) {
        try {
            //必填:待发送手机号 - 15000000000
            request.setPhoneNumbers(phone);
            //必填:短信签名-可在短信控制台中找到 - 云通信
            request.setSignName(signName);
            request.putQueryParameter("SignName", signName);
            //必填:短信模板-可在短信控制台中找到 - SMS_1000000
            request.setTemplateCode(templateCode);
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为 - "{\"name\":\"Tom\", \"code\":\"123\"}"
            request.setTemplateParam(new ObjectMapper().writeValueAsString(templatePars));
            //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
            request.setOutId("yourOutId");
            //hint 此处可能会抛出异常，注意catch
            sendSmsResponse = acsClient.getAcsResponse(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sendSmsResponse;
    }
    
}
*/
