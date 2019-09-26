package top.lemonz.blog.tool.impl;

/**
 * Created by IntelliJ IDEA.
 *
 * @author NingZe
 * description: 分页
 * path: DecoSearch-manage-com.rerise.tool.impl-NzPaging
 * date: 2019/8/9 0009 11:30
 * version: 02.06
 * To change this template use File | Settings | File Templates.
 */
public class NzPaging {

    /**
     * 当前页
     */
    private Integer page = 0;

    /**
     * 每页记录数
     */
    private Integer limit = 0;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        if (page < 1) {
            return;
        }
        this.page = (page - 1) * limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

}
