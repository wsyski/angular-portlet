package com.liferay.blade.npm.angular.portlet;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
@Component(
	immediate = true,
	property = "javax.portlet.name=" + AngularPortletKeys.ANGULAR_PORTLET_NAME,
	service = ConfigurationAction.class
)
public class AngularConfigurationAction extends DefaultConfigurationAction {
	@Override
	public String getJspPath(HttpServletRequest httpServletRequest) {
		return "/configuration.jsp";
	}

	@Override
	@Reference(
			target = "(osgi.web.symbolicname=com.liferay.blade.npm.angular.portlet)",
			unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		super.setServletContext(servletContext);
	}

}
