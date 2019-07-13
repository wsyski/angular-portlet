package com.axiell.arena.ui.modules.angular_portlet.configuration;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
@Component(
	immediate = true,
	property = "javax.portlet.name=" + "com_axiell_arena_ui_angular_portlet_web_portlet_AngularPortlet",
	service = ConfigurationAction.class
)
public class AngularConfigurationAction extends DefaultConfigurationAction {
	@Override
	public String getJspPath(HttpServletRequest httpServletRequest) {
		return "/configuration.jsp";
	}

	@Override
	@Reference(
			target = "(osgi.web.symbolicname=com.axiell.arena.ui.modules.angular_portlet.web)",
			unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		super.setServletContext(servletContext);
	}

}
