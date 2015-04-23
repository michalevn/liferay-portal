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

package com.liferay.gradle.plugins.poshi.runner;

import java.io.File;

import java.util.HashMap;
import java.util.Map;

import org.gradle.api.Project;

/**
 * @author Andrea Di Giorgi
 */
public class PoshiRunnerExtension {

	public PoshiRunnerExtension(Project project) {
		_baseDir = project.file("poshi-tests");
	}

	public File getBaseDir() {
		return _baseDir;
	}

	public Map<String, Object> getPoshiProperties() {
		return _poshiProperties;
	}

	public String getVersion() {
		return _version;
	}

	public void poshiProperty(String key, Object value) {
		_poshiProperties.put(key, value);
	}

	public void setBaseDir(File baseDir) {
		_baseDir = baseDir;
	}

	public void setPoshiProperties(Map<String, ?> poshiProperties) {
		_poshiProperties.clear();

		_poshiProperties.putAll(poshiProperties);
	}

	public void setVersion(String version) {
		_version = version;
	}

	private File _baseDir;
	private final Map<String, Object> _poshiProperties = new HashMap<>();
	private String _version = "+";

}