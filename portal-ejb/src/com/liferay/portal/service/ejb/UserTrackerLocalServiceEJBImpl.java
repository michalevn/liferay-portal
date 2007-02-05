/**
 * Copyright (c) 2000-2007 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portal.service.ejb;

import com.liferay.portal.service.UserTrackerLocalService;
import com.liferay.portal.service.UserTrackerLocalServiceFactory;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

/**
 * <a href="UserTrackerLocalServiceEJBImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class UserTrackerLocalServiceEJBImpl implements UserTrackerLocalService,
	SessionBean {
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.DynamicQueryInitializer queryInitializer)
		throws com.liferay.portal.SystemException {
		return UserTrackerLocalServiceFactory.getTxImpl().dynamicQuery(queryInitializer);
	}

	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.DynamicQueryInitializer queryInitializer,
		int begin, int end) throws com.liferay.portal.SystemException {
		return UserTrackerLocalServiceFactory.getTxImpl().dynamicQuery(queryInitializer,
			begin, end);
	}

	public com.liferay.portal.model.UserTracker addUserTracker(
		java.lang.String companyId, java.lang.String userId,
		java.util.Date modifiedDate, java.lang.String remoteAddr,
		java.lang.String remoteHost, java.lang.String userAgent,
		java.util.List userTrackerPaths)
		throws com.liferay.portal.SystemException {
		return UserTrackerLocalServiceFactory.getTxImpl().addUserTracker(companyId,
			userId, modifiedDate, remoteAddr, remoteHost, userAgent,
			userTrackerPaths);
	}

	public void deleteUserTracker(java.lang.String userTrackerId)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		UserTrackerLocalServiceFactory.getTxImpl().deleteUserTracker(userTrackerId);
	}

	public java.util.List getUserTrackers(java.lang.String companyId,
		int begin, int end) throws com.liferay.portal.SystemException {
		return UserTrackerLocalServiceFactory.getTxImpl().getUserTrackers(companyId,
			begin, end);
	}

	public void ejbCreate() throws CreateException {
	}

	public void ejbRemove() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public SessionContext getSessionContext() {
		return _sc;
	}

	public void setSessionContext(SessionContext sc) {
		_sc = sc;
	}

	private SessionContext _sc;
}