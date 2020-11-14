    package com.docs.assignment.web.MVCCommand;

    import com.docs.assignment.student.model.Student;
    import com.docs.assignment.student.service.StudentLocalService;
    import com.docs.assignment.web.constants.StudentPortletKeys;
    import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
    import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
    import com.liferay.portal.kernel.servlet.HttpHeaders;
    import com.liferay.portal.kernel.theme.ThemeDisplay;
    import com.liferay.portal.kernel.util.Base64;
    import com.liferay.portal.kernel.util.StringPool;
    import com.liferay.portal.kernel.util.WebKeys;
    import com.lowagie.text.Chunk;
    import com.lowagie.text.Document;
    import com.lowagie.text.Font;
    import com.lowagie.text.Paragraph;
    import com.lowagie.text.pdf.PdfPTable;
    import com.lowagie.text.pdf.PdfWriter;
    import org.osgi.service.component.annotations.Component;
    import org.osgi.service.component.annotations.Reference;

    import javax.portlet.ResourceRequest;
    import javax.portlet.ResourceResponse;
    import java.io.ByteArrayOutputStream;
    import java.io.OutputStream;
    import java.util.List;

    @Component(
            immediate = true,
            property = {
                    "javax.portlet.name="+ StudentPortletKeys.STUDENT,
                    "mvc.command.name=/download/pdf"
            },
            service = MVCResourceCommand.class
    )
    public class AllStudentsDownloadPdf extends BaseMVCResourceCommand {
        @Reference
        private StudentLocalService _studentLocalService;
        private static Font catFont = new Font(Font.TIMES_ROMAN, 18,
                Font.BOLD);
        @Override
        protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {

            resourceRequest.setCharacterEncoding(StringPool.UTF8);

            ThemeDisplay themeDisplay= (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
            List<Student> allStudents= _studentLocalService.getStudentsByGroupId(themeDisplay.getLayout().getGroupId());


            Document document = new Document();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, baos);
            document.open();
            Paragraph paragraph = new Paragraph();
            paragraph.add(new Paragraph("List of All Students",catFont));

            PdfPTable table= new PdfPTable(3);
            table.setWidthPercentage(100);
            table.addCell("Name");
            table.addCell("Email id");
            table.addCell("Age");

            for(Student student : allStudents){

                table.addCell(student.getName());
                table.addCell(student.getEmail());
                table.addCell(String.valueOf(student.getAge()));

            }
            document.add(paragraph);
            document.add( Chunk.NEWLINE );
            document.add(table);
            document.close();

            String fileName="attachment;filename=studentsDetails.pdf";

            resourceResponse.setContentType("application/pdf");
            resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION, fileName);
            OutputStream out = resourceResponse.getPortletOutputStream();
            byte[] downloadBytes = Base64.decode((String) resourceRequest.getAttribute("fileToDownloadBase64"));
            out.write(downloadBytes);
            baos.writeTo(out);
            out.flush();
            out.close();

        }//End of doServeResource


    } //End of Class