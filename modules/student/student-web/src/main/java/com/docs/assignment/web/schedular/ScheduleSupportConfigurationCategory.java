package com.docs.assignment.web.schedular;

import com.docs.assignment.web.constants.StudentPortletKeys;
import com.liferay.configuration.admin.category.ConfigurationCategory;

import org.osgi.service.component.annotations.Component;

@Component(service = ConfigurationCategory.class)
public class ScheduleSupportConfigurationCategory implements ConfigurationCategory{

	@Override
	public String getCategoryKey() {
		return StudentPortletKeys.CATEGOTY_KEY;
	}

	@Override
	public String getCategorySection() {
		return StudentPortletKeys.CATEGOTY_SECTION;
	}
	 @Override
	    public String getCategoryIcon() {
	        return StudentPortletKeys.CATEGORY_ICON;
	    }
	 
}
