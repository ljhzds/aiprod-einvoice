package com.asiainfo.einvoice.core.queue;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.complex.center.CenterFactory;
import com.ai.common.util.CenterUtil;
import com.asiainfo.appframe.ext.exeframe.tf.TfFrameWork;
import com.asiainfo.appframe.ext.exeframe.tf.interfaces.ITransform;
import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.ArrayUtils;
import com.asiainfo.appframe.ext.flyingserver.org.apache.commons.lang.StringUtils;
import com.asiainfo.einvoice.core.EInvoiceFactory;
import com.asiainfo.einvoice.core.def.bo.bean.BOInvoicePushTaskBean;
import com.asiainfo.einvoice.customized.message.pusher.interfaces.IEInvoiceMessagePusher;
import com.asiainfo.einvoice.util.DataModelUtil;

/**
 * ���ӷ�Ʊ�������ͽ���
 *
 * @author zhanghao
 */
public class EInvoiceIssuingPushQueue implements ITransform {
	public void transform(HashMap[] args) throws Exception {
		if (args.length > 0) {
			if (!ArrayUtils.isEmpty(args)) {
				for (Map m : args) {
					// ת��Ϊ���͹���
					BOInvoicePushTaskBean task = DataModelUtil.convertMap2Dc(BOInvoicePushTaskBean.class, m);
					String pushType = task.getPushWay();
					if (StringUtils.isNotBlank(pushType)) {
						// ӳ�䷽ʽ
						IEInvoiceMessagePusher pusher = EInvoiceFactory.getIEInvoiceMessagePusher(pushType);
						// ������Ϣ
						pusher.push(task);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		try {
			CenterFactory.setCenterInfoByTypeAndValue(CenterUtil.REGION_ID, "571");
			String[] args1 = new String[] { "E_INV_PUSH_571", "1", "0" };
			TfFrameWork.main(args1);
		} catch (Exception e) {
			Log log = LogFactory.getLog(EInvoiceIssuingPushQueue.class);
			log.error(e.getMessage(), e);
		}
	}
}
