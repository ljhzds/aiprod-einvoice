package com.asiainfo.einvoice.customized.message.builder.interfaces;


import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsDtlBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceInstBean;

/**
 * 电子发票模块/系统接入税控系统消息构造接口
 *
 * @author zhanghao
 */
public interface IEInvoiceSkMessageBuilder {
    /**
     * 开具消息接口
     *
     * @param dsBean
     * @param dsItemBeans
     * @return
     * @throws Exception
     */
    public String buildSkIssuingMsg(BOInvoiceDsBean dsBean, BOInvoiceDsDtlBean... dsItemBeans) throws Exception;

    /**
     * 冲红消息接口
     *
     * @param inst
     * @return
     * @throws Exception
     */
    public String buildSkRedMsg(BOInvoiceInstBean inst) throws Exception;

    /**
     * 发票查询接口，在电子发票系统开具或冲红发票出现问题时，调用这个方法，来重新查询开票记录
     *
     * @return
     * @throws Exception
     */
    public String buildSkQueryMsg(BOInvoiceInstBean inst) throws Exception;

}
