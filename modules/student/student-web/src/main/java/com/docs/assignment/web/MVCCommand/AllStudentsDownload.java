package com.docs.assignment.web.MVCCommand;

import com.docs.assignment.student.model.Student;
import com.docs.assignment.student.service.StudentLocalService;
import com.docs.assignment.web.constants.StudentPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.util.List;


@Component(
        immediate = true,
        property = {
                "javax.portlet.name="+ StudentPortletKeys.STUDENT,
                "mvc.command.name=/download/xlsx"
        },
        service = MVCResourceCommand.class
)
public class AllStudentsDownload extends BaseMVCResourceCommand {

    @Reference
    private StudentLocalService _studentLocalService;

    @Override
    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {

        HSSFWorkbook workbook = createExelWork(resourceRequest);


        resourceResponse.setContentType("application/vnd.ms-excel");
        resourceResponse.addProperty("Content-Disposition", "inline; filename="+ "studentDetails.xls");

        // This will write to OutputStream
       workbook.write(resourceResponse.getPortletOutputStream());
    }



    public HSSFWorkbook createExelWork(ResourceRequest request) {

        HSSFWorkbook hwb = new HSSFWorkbook();
        HSSFSheet sheet = hwb.createSheet("Student Details");

        HSSFRow rowHead = sheet.createRow(0);

        rowHead.createCell(0).setCellValue("Name");
        rowHead.createCell(1).setCellValue("Email");
        rowHead.createCell(2).setCellValue("Age");

        ThemeDisplay themeDisplay= (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        List<Student> allStudents= _studentLocalService.getStudentsByGroupId(themeDisplay.getLayout().getGroupId());

        for(int i=0; i<allStudents.size();i++){

            HSSFRow row = sheet.createRow(i+1);

            row.createCell(0).setCellValue(allStudents.get(i).getName());
            row.createCell(1).setCellValue(allStudents.get(i).getEmail());
            row.createCell(2).setCellValue(allStudents.get(i).getAge());
        }
        return hwb;
    }
}

