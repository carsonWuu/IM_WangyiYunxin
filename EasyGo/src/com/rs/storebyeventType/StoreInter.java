package com.rs.storebyeventType;

import com.rs.util.bean.ReqBean;

/**存储接口
 * 
 * @author wcs
 *
 */
public interface StoreInter {
	/**存储方法
	 * 
	 * @return
	 */
	public boolean store(ReqBean reqBean);
}
