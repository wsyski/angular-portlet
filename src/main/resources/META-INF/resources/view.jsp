<%@ page import="com.liferay.portal.kernel.json.JSONSerializer" %>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
--%>

<%@ include file="/init.jsp" %>

<%
    JSONSerializer jsonSerializer = JSONFactoryUtil.createJSONSerializer();
    String preferencesAsJson = jsonSerializer.serializeDeep(portletPreferences.getMap());
%>
<div id="js-portlet-<portlet:namespace />"></div>

<script type="text/javascript">
	Liferay.Loader.require(
			"<%= moduleName %>",
			function(module) {
				var initializer;

				if (typeof module.default === 'function') {
					initializer = module.default;
				}
				else if (typeof module === 'function') {
					initializer = module;
				}

				if (initializer) {
					initializer(
							{
								configuration: {
									portletInstance: JSON.parse('<%= preferencesAsJson %>'),
									system: JSON.parse('{}')
								},
								contextPath: "<%= renderRequest.getContextPath() %>",
								portletElementId: "js-portlet-<portlet:namespace/>",
								portletNamespace: "<portlet:namespace/>"
							});
				}
				else {
					console.error(
							'Module', '<%= moduleName %>',
							'is not exporting a function: cannot initialize it.');
				}

			});
</script>