/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.spring.extender.internal.context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.List;

import org.osgi.framework.Bundle;

/**
 * @author Miguel Pastor
 */
public class SpringContextHeaderParser {

	public SpringContextHeaderParser(Bundle bundle) {
		_bundle = bundle;
	}

	public String[] getBeanDefinitionFiles() {
		Dictionary<String, String> headers = _bundle.getHeaders();
		List<String> beanDefinitionFiles = new ArrayList<>();

		String configs = headers.get("Spring-Context");

		if (configs != null) {
			Collections.addAll(beanDefinitionFiles, configs.split(","));
		}

		String liferayService = headers.get("Liferay-Service");

		if (liferayService != null) {
			beanDefinitionFiles.add("META-INF/spring/parent");
		}

		return beanDefinitionFiles.toArray(
			new String[beanDefinitionFiles.size()]);
	}

	private final Bundle _bundle;

}