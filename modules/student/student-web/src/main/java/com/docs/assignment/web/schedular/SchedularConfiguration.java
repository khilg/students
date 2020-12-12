package com.docs.assignment.web.schedular;

import aQute.bnd.annotation.metatype.Meta;

import com.docs.assignment.web.constants.StudentPortletKeys;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@Meta.OCD(
		id = "com.docs.assignment.web.schedular.SchedularConfiguration"
	)

@ExtendedObjectClassDefinition(
		category = StudentPortletKeys.CATEGOTY_KEY,
		scope = ExtendedObjectClassDefinition.Scope.SYSTEM)
public interface SchedularConfiguration {


	@Meta.AD(required = false, deflt="0 30 12 ? * * *")
	public String cronValue();
}
