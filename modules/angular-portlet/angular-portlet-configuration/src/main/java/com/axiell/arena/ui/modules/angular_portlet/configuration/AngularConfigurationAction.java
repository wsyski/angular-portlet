package com.axiell.arena.ui.modules.angular_portlet.configuration;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.StreamUtil;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Map;
import java.util.stream.Collectors;

@Component(
        immediate = true,
        property = "javax.portlet.name=" + "com_axiell_arena_ui_angular_portlet_web_portlet_AngularPortlet",
        service = ConfigurationAction.class
)
public class AngularConfigurationAction extends DefaultConfigurationAction {
    private static final Log _log = LogFactoryUtil.getLog(
            AngularConfigurationAction.class);
    private URL configURL;

    @Override
    public String getJspPath(HttpServletRequest httpServletRequest) {
        // return super.getJspPath(httpServletRequest);
        return "/configuration.jsp";
    }

    /*
    @Override
    public void include(
            PortletConfig portletConfig, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse)
            throws Exception {
        // super.include(portletConfig, httpServletRequest, httpServletResponse);
        PrintWriter pw = httpServletResponse.getWriter();
        InputStream is = configURL.openStream();
        try {

            try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                pw.write(br.lines().collect(Collectors.joining(System.lineSeparator())));
            }
        } finally {
            is.close();
        }
    }
    */

    /*
    @Override
    @Reference(
            target = "(osgi.web.symbolicname=com.axiell.arena.ui.modules.angular_portlet.web)",
            unbind = "-"
    )
    public void setServletContext(ServletContext servletContext) {
        super.setServletContext(servletContext);
    }
     */

    @Activate
    protected void activate(final BundleContext bundleContext, final Map<String, Object> properties) {
        configURL = bundleContext.getBundle().getResource("/META-INF/resources/configuration.jsp");
        _log.info("url: " + configURL);
    }
}
