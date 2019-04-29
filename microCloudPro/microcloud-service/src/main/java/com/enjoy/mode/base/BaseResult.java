package com.enjoy.mode.base;

/**
 * @author kancy
 * @version 1.0
 * @date 2019/3/22 15:46
 */
public class BaseResult {
    public static final String STS_S  = "S";
    public static final String STS_E  = "E";
    private String rtnSts;
    private String rtnMsg;

    public String getRtnSts() {
        return rtnSts;
    }

    public void setRtnSts(String rtnSts) {
        this.rtnSts = rtnSts;
    }

    public String getRtnMsg() {
        return rtnMsg;
    }

    public void setRtnMsg(String rtnMsg) {
        this.rtnMsg = rtnMsg;
    }
}
