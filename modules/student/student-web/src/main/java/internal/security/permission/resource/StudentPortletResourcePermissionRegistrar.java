package internal.security.permission.resource;

import com.docs.assignment.web.constants.StudentPortletKeys;
import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.StagedPortletPermissionLogic;
import com.liferay.portal.kernel.util.HashMapDictionary;

import java.util.Dictionary;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

@Component (immediate = true)
public class StudentPortletResourcePermissionRegistrar {
	   @Activate
	    public void activate(BundleContext bundleContext) {
	        Dictionary<String, Object> properties = new HashMapDictionary<>();

	        properties.put("resource.name", StudentPortletKeys.RESOURCE_NAME);

	        _serviceRegistration = bundleContext.registerService(
	            PortletResourcePermission.class,
	            PortletResourcePermissionFactory.create(
	            		StudentPortletKeys.RESOURCE_NAME,
	                new StagedPortletPermissionLogic(
	                    _stagingPermission, StudentPortletKeys.STUDENT)),
	            properties);
	    }

	    @Deactivate
	    public void deactivate() {
	        _serviceRegistration.unregister();
	    }

	    private ServiceRegistration<PortletResourcePermission> _serviceRegistration;

	    @Reference
	    private StagingPermission _stagingPermission;
}
