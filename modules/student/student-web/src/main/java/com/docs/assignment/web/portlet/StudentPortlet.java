package com.docs.assignment.web.portlet;

import com.docs.assignment.student.model.Student;
import com.docs.assignment.student.service.StudentLocalService;
import com.docs.assignment.student.service.StudentLocalServiceUtil;
import com.docs.assignment.web.constants.StudentPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author ag8
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.student",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Student",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + StudentPortletKeys.STUDENT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.add-process-action-success-action=false"

	},
	service = Portlet.class
)
public class StudentPortlet extends MVCPortlet {
	
	@Reference
	private StudentLocalService _studentLocalService;
	
	Log log = LogFactoryUtil.getLog(Student.class.getName());
	
	public void addStudent(ActionRequest request, ActionResponse response)
			throws PortalException {

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
            Student.class.getName(), request);

        String name = ParamUtil.getString(request, "name");
        String email = ParamUtil.getString(request, "email");
        int age = ParamUtil.getInteger(request, "age");
        long studentId = ParamUtil.getLong(request, "studentId");

        log.info("StudentId from edit_student.jsp :: studentID : "+studentId);
        
        
    if (studentId > 0) {

        try {

        	_studentLocalService.updateStudent(serviceContext.getUserId(), studentId ,name, email, age,"Assigned", serviceContext);
			SessionMessages.add(request, "studentUpdated");


			response.setRenderParameter(
                "studentId", Long.toString(studentId));
            log.info("Updating Student :: StudentID : "+ studentId );
        }
        catch (Exception e) {
        	log.error("Failed to Update Student :: Message : "+e.getMessage());
			SessionErrors.add(request, "studentActionException");
			SessionMessages.add(request,
					PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
            PortalUtil.copyRequestParameters(request, response);

            response.setRenderParameter(
                "mvcPath", "/edit_student.jsp");
        }

    }
    else {

        try {
        	_studentLocalService.addStudent(serviceContext.getUserId(), name, email, age,"Assigned", serviceContext);
			SessionMessages.add(request, "studentAdded");
            response.setRenderParameter(
                "studentId", Long.toString(studentId));
            log.info("adding Student :: StudentId : "+ studentId);
        }
        catch (Exception e) {
        	log.error(e.getMessage());
			SessionErrors.add(request, "studentActionException");
			SessionMessages.add(request,
					PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			PortalUtil.copyRequestParameters(request, response);

            response.setRenderParameter(
                "mvcPath", "/edit_student.jsp");
        }
    }
}
	
	public void deleteStudent(ActionRequest request, ActionResponse response){
		
        long studentId = ParamUtil.getLong(request, "studentId");

        try {

            response.setRenderParameter(
                "studentId", Long.toString(studentId));

            _studentLocalService.deleteStudent(studentId);

			SessionMessages.add(request, "studentDeleted");
        }

        catch (Exception e) {
        	log.error(e.getMessage());
			SessionErrors.add(request, "studentActionException");
			SessionMessages.add(request,
					PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
        }
}
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
	    throws IOException, PortletException {

	    try {
	        long studentId = ParamUtil.getLong(renderRequest, "studentId");
	        log.info("Rendering Student :: StudentId : "+ studentId);
	        
	        renderRequest.setAttribute("studentId", Long.toString(studentId));
	    }
	    catch (Exception e) {
	        throw new PortletException(e);
	    }

	    super.render(renderRequest, renderResponse);
	}
	

	
}