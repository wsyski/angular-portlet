<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.json.JSONSerializer" %>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
    String moduleName = (String)renderRequest.getAttribute("moduleName");
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
