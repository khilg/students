package com.docs.assignment.web.MVCCommand;

import com.docs.assignment.web.constants.StudentPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name="+ StudentPortletKeys.STUDENT,
                "mvc.command.name=/example/resource",
        },
        service = MVCResourceCommand.class
)
public class ResourceExample extends BaseMVCResourceCommand {
    @Override
    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {

        String example = ParamUtil.getString(resourceRequest,"testExample");
        String example2 = resourceRequest.getParameter("testExample");

        System.out.println("Example :: " + example);
        System.out.println("Example :: 2 : " + example2);

    }
}
