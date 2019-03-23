package com.asiainfo.einvoice.customized.message.builder.interfaces;


import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceDsDtlBean;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoiceInstBean;

/**
 * ���ӷ�Ʊģ��/ϵͳ����˰��ϵͳ��Ϣ����ӿ�
 *
 * @author zhanghao
 */
public interface IEInvoiceSkMessageBuilder {
    /**
     * ������Ϣ�ӿ�
     *
     * @param dsBean
     * @param dsItemBeans
     * @return
     * @throws Exception
     */
    public String buildSkIssuingMsg(BOInvoiceDsBean dsBean, BOInvoiceDsDtlBean... dsItemBeans) throws Exception;

    /**
     * �����Ϣ�ӿ�
     *
     * @param inst
     * @return
     * @throws Exception
     */
    public String buildSkRedMsg(BOInvoiceInstBean inst) throws Exception;

    /**
     * ��Ʊ��ѯ�ӿڣ��ڵ��ӷ�Ʊϵͳ���߻��췢Ʊ��������ʱ��������������������²�ѯ��Ʊ��¼
     *
     * @return
     * @throws Exception
     */
    public String buildSkQueryMsg(BOInvoiceInstBean inst) throws Exception;

}
