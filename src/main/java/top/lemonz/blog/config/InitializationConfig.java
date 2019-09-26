package top.lemonz.blog.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import top.lemonz.blog.json.AuthorInfo;
import top.lemonz.blog.tool.IXlmToolKit;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 *
 * @author NingZe
 * description: Initialization Config
 * path: LEMONBLOG-top.lemonz.blog.config-InitializationConfig
 * date: 2019/9/26 0026 14:28
 * version: 02.06
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class InitializationConfig implements Serializable {

    private final static Logger log = LoggerFactory.getLogger(InitializationConfig.class);

    /**
     * application
     */
    @Autowired
    private ServletContext sc;

    /**
     * kit
     */
    @Autowired
    private IXlmToolKit kit;

    /**
     * author info
     */
    public static AuthorInfo authorInfo;

    @PostConstruct
    public void init() {

        log.error("--- 正在初始化数据 ---");

        authorInfo = AuthorInfo.getAuthorInfo();
        sc.setAttribute("authorInfo", authorInfo);

        log.error("--- 初始化数据完成 ---");

    }

}
