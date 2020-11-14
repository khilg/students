package com.docs.assignment.web.schedular;

import com.docs.assignment.student.model.Student;
import com.docs.assignment.student.service.StudentLocalService;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.scheduler.*;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.persistence.PortletUtil;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.liferay.portal.kernel.scheduler.SchedulerEngine.STORAGE_TYPE;

@Component(
        immediate = true,
        service = StudentAssignmentUpdateSchedular.class)

public class StudentAssignmentUpdateSchedular extends BaseMessageListener {
    @Reference
    private StudentLocalService _studentLocalService;
    @Override
    protected void doReceive(Message message) throws Exception {
        _log.info("Running Schedular");
        List<Student> studentsList = _studentLocalService.getAllStudents();

        for(Student student : studentsList){
            student.setAssignment_status("Submitted");
            _studentLocalService.updateStudent(student);
        }
    }
    @Activate
    @Modified
    protected void activate(Map<String, Object> properties) throws SchedulerException {
        Configuration configuration = ConfigurationFactoryUtil.getConfiguration(PortalClassLoaderUtil.getClassLoader(), "portlet");

        try {
            String cronExpression = configuration.get("cron.expression");
                    //GetterUtil.getString(properties.get("cron.expression"), _DEFAULT_CRON_EXPRESSION);

            System.out.println(" cronExpression: " + cronExpression);

            String listenerClass = getClass().getName();
            Trigger jobTrigger = _triggerFactory.createTrigger(listenerClass, listenerClass, new Date(), null, cronExpression);

            _schedulerEntryImpl = new SchedulerEntryImpl(listenerClass, jobTrigger);
            _schedulerEntryImpl.setTrigger(jobTrigger);

            if (_initialized) {
                deactivate();
            }

            _schedulerEngineHelper.register(this, _schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);

            _initialized = true;
        } catch (Exception e){
           _log.error(e.getMessage());
        }
    }

    @Deactivate
    protected void deactivate() {
        if (_initialized) {
            try {
                _schedulerEngineHelper.unschedule(_schedulerEntryImpl, getStorageType());
            } catch (SchedulerException se) {
                _log.error(se.getMessage());
            }
            _schedulerEngineHelper.unregister(this);
        }

        _initialized = false;
    }
    @Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
    protected void setModuleServiceLifecycle(ModuleServiceLifecycle moduleServiceLifecycle) {
        _log.info("Schedular Module initialized :: " + new Date());
    }

    @Reference(unbind = "-")
    protected void setTriggerFactory(TriggerFactory triggerFactory) {
        _triggerFactory = triggerFactory;
    }

    @Reference(unbind = "-")
    protected void setSchedulerEngineHelper(SchedulerEngineHelper schedulerEngineHelper) {
        _schedulerEngineHelper = schedulerEngineHelper;
    }

    private static final Log _log = LogFactoryUtil.getLog(StudentAssignmentUpdateSchedular.class);

    protected StorageType getStorageType() {
        return StorageType.MEMORY_CLUSTERED;
    }
    private volatile boolean _initialized;
    private TriggerFactory _triggerFactory;
    private SchedulerEngineHelper _schedulerEngineHelper;
    private SchedulerEntryImpl _schedulerEntryImpl = null;
    private static final String _DEFAULT_CRON_EXPRESSION= "59 59 23 L * ?";
}
