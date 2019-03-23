package com.asiainfo.einvoice.util;

/**
 * Created by huangjh on 16/4/12.
 */
public interface ExecuteEvent {
    /**
     * 执行事件，回调时使用的一个壳子
     *
     * @throws Exception
     */
    public void execute() throws Exception;
}
