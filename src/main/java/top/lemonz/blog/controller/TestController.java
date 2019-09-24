package top.lemonz.blog.controller;

import top.lemonz.blog.json.AuthorInfo;

/**
 * Created by IntelliJ IDEA.
 *
 * @author NingZe
 * description: 测试
 * path: LEMONBLOG-top.lemonz.blog.controller-TestController
 * date: 2019/9/16 0016 17:55
 * version: 02.06
 * To change this template use File | Settings | File Templates.
 */
public class TestController {

    public static void main(String[] args) {

        System.err.println(AuthorInfo.getAuthorInfo().getAuthorname());

    }

}