package com.liferay.blade.npm.angular.portlet;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.youtube.web.internal.constants.YouTubePortletKeys;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = "javax.portlet.name=" + YouTubePortletKeys.YOUTUBE,
	service = ConfigurationAction.class
)
public class AngularConfigurationAction extends DefaultConfigurationAction {
}
