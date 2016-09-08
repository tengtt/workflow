package org.seckill.study.mybatis;

/**
 * Created by teng on 2016/6/1.
 */
public class Page {

    private int totalNumber;

    private int currentPage;

    private int totalPage;

    /*
    * 每页显示多少条
    * */
    private int pageNumber = 5;

    /*
    * 数据库中limit的参数，从第几条开始取
    * */
    private int dbIndex;

    /*
    * 数据库中limit的参数，一共取多少条
    * */
    private int dbNumber;

    public void count(){

        //计算总页数
        int totalPageTemp = this.totalNumber/this.pageNumber;
        int plus = (this.totalNumber % this.pageNumber) == 0 ? 0 : 1;
        totalPageTemp = totalPageTemp + plus;
        if(totalPageTemp <= 0){
            totalPageTemp = 1;
        }
        this.totalPage = totalPageTemp;

        //设置当前页数
        //总页数小于当前页数，应将当前页数设置为总页数

        if(this.totalPage < this.currentPage){
            this.currentPage = this.totalPage;
        }

        //当前页数小于1，设置为1
        if(this.currentPage < 1){
            this.currentPage = 1;
        }
        //设置limit参数
        this.dbIndex = (this.currentPage - 1) * this.pageNumber;
        this.dbNumber = this.pageNumber;

    }


    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getDbIndex() {
        return dbIndex;
    }

    public void setDbIndex(int dbIndex) {
        this.dbIndex = dbIndex;
    }

    public int getDbNumber() {
        return dbNumber;
    }

    public void setDbNumber(int dbNumber) {
        this.dbNumber = dbNumber;
    }
}
