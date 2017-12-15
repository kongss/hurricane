package com.hurricane.coupon.utils.page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Pager implements Serializable {
    /** 当前页 */
    private int currentPage = 1;
    /** 每页大小 */
    private int pageSize = 10;
    /** 总页数 */
    private int pageTotal;
    /** 总条数 */
    private int recordTotal = 0;
    /** 上一页 */
    private int previousPage;
    /** 下一页 */
    private int nextPage;
    /** 首页 */
    private int firstPage = 1;
    /** 尾页 */
    private int lastPage;
    /** 每页内容 */
    private List<Map<String, Object>> content;

    public Pager(int currentPage, int pageSize, int recordTotal) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.recordTotal = recordTotal;
        otherAttr();
    }
    /** 给其他参数赋值 */
    public void otherAttr() {
        // 总页数
        this.pageTotal = this.recordTotal % this.pageSize > 0 ? this.recordTotal / this.pageSize + 1 : this.recordTotal / this.pageSize;
        // 首页
        this.firstPage = 1;
        // 尾页
        this.lastPage = this.pageTotal;
        // 上一页
        if (this.currentPage > 1) {
            this.previousPage = this.currentPage - 1;
        } else {
            this.previousPage = this.firstPage;
        }
        // 下一页
        if (this.currentPage < this.lastPage) {
            this.nextPage = this.currentPage + 1;
        } else {
            this.nextPage = this.lastPage;
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public int getRecordTotal() {
        return recordTotal;
    }

    public void setRecordTotal(int recordTotal) {
        this.recordTotal = recordTotal;
    }

    public int getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(int previousPage) {
        this.previousPage = previousPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public List<Map<String, Object>> getContent() {
        return content;
    }

    public void setContent(List<Map<String, Object>> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Pager{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", pageTotal=" + pageTotal +
                ", recordTotal=" + recordTotal +
                ", previousPage=" + previousPage +
                ", nextPage=" + nextPage +
                ", firstPage=" + firstPage +
                ", lastPage=" + lastPage +
                ", content=" + content +
                '}';
    }
}
