package com.asiainfo.einvoice.util;

import com.ai.common.util.ExceptionUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BillingCycleUtil {
	/**
	 * 
	 * @Function: getBillingCycleIdArray
	 * @Description: ���ݿ�ʼ������������ڻ�ȡ��������
	 *
	 * @param:��������
	 * @return���������飬Ԫ��Ϊ��YYYYMM����ʽ��������ʼʱ�估����ʱ��������
	 * @throws���쳣����
	 *
	 */
	public static String[] getBillingCycleIdArray(Date beginDate, Date endDate) throws Exception
	{
		if(beginDate != null && endDate != null)
		{
			List list = new ArrayList();
			Calendar bCal = Calendar.getInstance();
			Calendar eCal = Calendar.getInstance();
			bCal.setTime(beginDate);
			eCal.setTime(endDate);
			if(eCal.compareTo(bCal) < 0)
			{
				//���󣺿�ʼʱ����ڽ���ʱ�䣬���ܼ������ڣ�
				ExceptionUtil.throwBusinessException("AMS3000077");
			}
			while(eCal.compareTo(bCal) >= 0 || (eCal.compareTo(bCal) < 0 && (eCal.get(Calendar.YEAR) == bCal.get(Calendar.YEAR) &&
				  (eCal.get(Calendar.MONTH) == bCal.get(Calendar.MONTH)))))
			{
				list.add(new Integer(bCal.get(Calendar.YEAR)*100 + bCal.get(Calendar.MONTH) + 1));
				bCal.add(Calendar.MONTH, 1);
			}
			if(list != null && list.size() > 0)
			{
				String[] ids = new String[list.size()];
				for(int i=0; i < list.size(); i++)
				{
					ids[i] = (list.get(i) != null) ? list.get(i).toString() : null; 
				}
				return ids;
			}
		}
		return null;
	}
}
