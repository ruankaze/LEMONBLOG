package top.lemonz.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.lemonz.blog.tool.IXlmToolKit;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author xlm
 * description: 视图跳转
 * path: LemonzBlog-top.lemonz.blog.controller-ViewSkip
 * date: 2019/6/22 21:56
 * version: 02.06
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("vs")
public class ViewSkip {

    /**
     * kit
     */
    @Autowired
    private IXlmToolKit kit;

    /**
     * 日志
     */
    private final static Logger log = LoggerFactory.getLogger(ViewSkip.class);

    /**
     * 存放视图地址
     */
    private final static Map<String, String> vsmap = new HashMap(16);

    /**
     * 初始化视图地址
     */
    static {

        // 首页
        vsmap.put("index", "index");

        // editormd 编辑器
        vsmap.put("simple", "simple");

        // 测试视图页
        vsmap.put("test", "test");

        // 信息查询
        vsmap.put("findinfo", "interface/findInfo");

    }

    /**
     * articles 文章
     */
    static {

        // mask
        vsmap.put("mask", "articles/mask");

    }

    /**
     * 视图跳转 - Rest 风格
     *
     * @param view,modelMap
     * @return
     */
    @RequestMapping("{view}")
    public String ViewSkip(@PathVariable(value = "view") String view, ModelMap modelMap) {
        viewModel(modelMap);
        return vsmap.get(view);
    }

    /**
     * 自定义处理方法
     *
     * @param modelMap
     */
    private void viewModel(ModelMap modelMap) {


    }

}
