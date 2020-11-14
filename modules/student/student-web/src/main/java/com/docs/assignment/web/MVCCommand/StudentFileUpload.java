package com.docs.assignment.web.MVCCommand;

import com.docs.assignment.student.model.Student;
import com.docs.assignment.student.service.StudentLocalService;
import com.docs.assignment.web.constants.StudentPortletKeys;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name="+ StudentPortletKeys.STUDENT,
                "mvc.command.name=/students/uploadDocument",
        },
        service = MVCActionCommand.class
)
public class StudentFileUpload extends BaseMVCActionCommand
        //BaseMVCResourceCommand
{

    private static final String ROOT_FOLDER_NAME ="File_Upload";
    private static final String ROOT_FOLDER_DESCRIPTION ="This folder is create for Upload documents";
    private static final long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;


    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse){

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        createFolder(actionRequest, themeDisplay);
        fileUpload(themeDisplay, actionRequest);
        String url = getAllFileLink(themeDisplay);
        actionRequest.setAttribute("downloadUrl",url);
        //actionResponse.setRenderParameter("downloadUrl",url);


    }

    public String getAllFileLink(ThemeDisplay themeDisplay) {
        long repositoryId = themeDisplay.getScopeGroupId();
        String folderName = "Excel file Download";
        String url ="";
        try {
            Folder folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID,folderName );
            List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(repositoryId, folder.getFolderId());
            for (FileEntry file : fileEntries) {
                 url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + "/" +
                        file.getFolderId() + "/" + file.getTitle();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;

    }
    public Folder createFolder(ActionRequest request,ThemeDisplay themeDisplay){

        Folder folder = null;
        boolean folderExist = isFolderExist(themeDisplay);
        if (!folderExist) {
            long repositoryId = themeDisplay.getScopeGroupId();
            try {
                ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), request);
                folder =  DLAppServiceUtil.addFolder(repositoryId,PARENT_FOLDER_ID, ROOT_FOLDER_NAME,ROOT_FOLDER_DESCRIPTION, serviceContext);
            } catch (PortalException e1) {
                e1.printStackTrace();
            }
        }
        return folder;
    }
    public boolean isFolderExist(ThemeDisplay themeDisplay){
        boolean folderExist = false;
        try {
            DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
            folderExist = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return folderExist;
    }
    public Folder getFolder(ThemeDisplay themeDisplay){
        Folder folder = null;
        try {
            folder =DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return folder;
    }
    public void fileUpload(ThemeDisplay themeDisplay,ActionRequest request){



        UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);

        String fileName = uploadPortletRequest.getFileName("uploadedFile");
        File file = uploadPortletRequest.getFile("uploadedFile");
        String mimeType = uploadPortletRequest.getContentType("uploadedFile");
        String fileSuffix = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String description = "This file is added via programmatically";
       String  fileNameDup = FileUtil.appendSuffix(fileName, "_" + fileSuffix);
        System.out.println(fileNameDup);
        long repositoryId = themeDisplay.getScopeGroupId();

        try
        {
            readXls(file, request);

            Folder folder = getFolder(themeDisplay);
            ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
            InputStream is = new FileInputStream(file);
            List<FileEntry> fileEntryList = DLAppServiceUtil.getFileEntries(repositoryId,folder.getFolderId());

            if(fileEntryList != null && !fileEntryList.isEmpty()){
                FileEntry fileEntry = fileEntryList.get(0);
                DLAppServiceUtil.deleteFileEntryByTitle(fileEntry.getRepositoryId(),fileEntry.getFolderId(),
                        fileEntry.getFileName());
            }
            DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), fileNameDup, mimeType,
                    fileName, description, "", is, file.length(), serviceContext);
            SessionMessages.add(PortalUtil.getHttpServletRequest(request), "studentFileUploaded");

        } catch (Exception e){
            e.printStackTrace();
        }

    }
    public  void  readXls(File file ,ActionRequest request) throws IOException, PortalException {

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                Student.class.getName(), request);

        InputStream is = new FileInputStream(file);
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0); // Getting the first Sheet
        try {
            _studentLocalService.deleteAllStudents();

            for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
                Row row = sheet.getRow(i);
                String name = row.getCell(0).toString();
                String email = row.getCell(1).toString();
                int age = (int)row.getCell(2).getNumericCellValue();
                _studentLocalService.addStudent(serviceContext.getUserId(), name, email, age,"Assigned", serviceContext);
            }
        }catch (NullPointerException npe){
            SessionErrors.add(request, "studentNullPointerException");
            SessionMessages.add(request,
                    PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

        }

    }


    @Reference
    private StudentLocalService _studentLocalService;

//    @Override
//    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
//        System.out.println("hi there in resoure menthod");
//        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
//        createFolder(resourceRequest, themeDisplay);
//        fileUpload(themeDisplay, resourceRequest);
//        String url = getAllFileLink(themeDisplay);
//        resourceRequest.setAttribute("downloadUrl",url);
//        //actionResponse.setRenderParameter("downloadUrl",url);
//    }


}