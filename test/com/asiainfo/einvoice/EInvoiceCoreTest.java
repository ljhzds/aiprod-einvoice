package com.asiainfo.einvoice;

import java.util.HashMap;
import java.util.Map;

import org.apache.ecs.xhtml.center;

import com.ai.appframe2.complex.center.CenterFactory;
import com.asiainfo.einvoice.core.EInvoiceFactory;
import com.asiainfo.einvoice.core.def.BusiMsg;
import com.asiainfo.einvoice.core.def.CrmRequestMsg;
import com.asiainfo.einvoice.core.def.InvoiceItemMsg;
import com.asiainfo.einvoice.core.def.InvoiceMsg;
import com.asiainfo.einvoice.core.def.PushInfo;

import junit.framework.TestCase;

/**
 * Created by huangjh on 16/4/8.
 */
public class EInvoiceCoreTest extends TestCase {
	public void testIssuing() throws Exception {
		CenterFactory.setCenterInfoByTypeAndValue("RegionId", "A");
		CrmRequestMsg requestMsg = buildCrmRequestMessage();
		EInvoiceFactory.getIEInvoiceCrmSV().issuingEInvoice(requestMsg, "A", "201604");
	}

	public void testIssuingBatch() throws Exception {
		CrmRequestMsg requestMsg = buildCrmRequestMessage();
		EInvoiceFactory.getIEInvoiceCrmSV().issuingEInvoiceBatch(requestMsg, "A", "201604");
	}

	public void testIssuingBatchDispatch() throws Exception {
		CrmRequestMsg requestMsg = buildCrmRequestMessage();
		CenterFactory.setCenterInfoByTypeAndValue("RegionIdBillCycle", "A_201604");
		EInvoiceFactory.getIEInvoiceSV().issuingEInvoiceBatchDisaptch(10156L);
	}

	public void testIssuingRed() throws Exception {
		CrmRequestMsg msg = new CrmRequestMsg();
		msg.setBusiMsg(buildBusiMsg());

		InvoiceMsg invoiceMsg = new InvoiceMsg();
		invoiceMsg.setInvoiceInsId(10156);
		msg.setInvoiceMsg(invoiceMsg);

		// EInvoiceFactory.getIEInvoiceCrmSV().issuingEInvoiceRed(msg);
	}

	public void testSharding() throws Exception {
		CenterFactory.setCenterInfoByTypeAndValue("RegionId", "A");
		EInvoiceFactory.getIEInvoiceSV().getInvoiceDsById(1L, "A", "201604");
	}

	private CrmRequestMsg buildCrmRequestMessage() {
		CrmRequestMsg msg = new CrmRequestMsg();
		msg.setBusiMsg(buildBusiMsg());
		msg.setInvoiceMsg(buildInvoiceMsg());
		msg.setInvoiceItemMsgs(buildInvoiceItemMsg());
		msg.setPushInfos(buildPushInfo());
		return msg;
	}

	private BusiMsg buildBusiMsg() {
		BusiMsg msg = new BusiMsg();
		Map featureMap = new HashMap();
		featureMap.put("regionId", "A");
		featureMap.put("billCycle", "201604");
		msg.setFeatureMap(featureMap);
		return msg;
	}

	private InvoiceMsg buildInvoiceMsg() {
		InvoiceMsg msg = new InvoiceMsg();

		msg.setBusiType("default");
		msg.setBillId("15951922999");
		msg.setCustId(1234L);
		msg.setUserId(1234L);
		msg.setAcctId(1234);
		msg.setSoOrderId("1234567890");
		msg.setSoOrderSeria("0987654321");
		msg.setIssuingChannel("营业厅");
		msg.setIssuingType("1");
		msg.setInvoiceHead("ASIA");
		msg.setInvoiceContent("JAK");
		msg.setXhfYhzh("121");
		msg.setInvoiceType("1");
		msg.setInvoiceType("1");
		msg.setCountyId("025");
		msg.setCreateOpId(13L);
		msg.setDkbz("1");
		msg.setCreateOrgId(1L);
		msg.setFhy("张敏");
		msg.setSky("121");
		msg.setKpy("张三");
		msg.setGhfDhhm("15077877744");
		msg.setGhfNsrmc("钱五");
		msg.setGhfNsrsbh("孙子");
		msg.setGhfDz("addr2");
		msg.setGhfQylx("1");
		msg.setXhfNsrmc("赵四");
		msg.setXhfNsrsbh("NO.123");
		msg.setXhfDz("addr1");
		msg.setXhfDhhm("15000000000");
		msg.setKpfSbh("a");
		msg.setKpfDzdah("asd");
		msg.setKpfMc("345678");
		msg.setGhfYhzh("12313");
		msg.setTotalAmount(1231231);
		msg.setTotalTax(1231.1);

		msg.setTotalPrice(12312);
		return msg;
	}

	private InvoiceItemMsg[] buildInvoiceItemMsg() {
		InvoiceItemMsg itemMsg = new InvoiceItemMsg();
		itemMsg.setFpxz("增值税");
		itemMsg.setHxbz("1200");
		itemMsg.setItemAmount(200);
		itemMsg.setItemFax(12344444);
		itemMsg.setItemFaxRate(50);
		itemMsg.setItemSpec("12313asd");
		itemMsg.setItemUnit("12");
		itemMsg.setItemName("名称");
		itemMsg.setItemNumb(1);
		itemMsg.setItemPrice(12);
		itemMsg.setSpbm("aa");
		itemMsg.setZxbm("121");
		return new InvoiceItemMsg[] { itemMsg };
	}

	private PushInfo[] buildPushInfo() {
		PushInfo info = new PushInfo();
		info.setPushTarget("13456789902");
		info.setPushWay("1");
		return new PushInfo[] { info };
	}

}
