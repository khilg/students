package com.docs.assignment.web.schedular;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactory;

import java.util.Date;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		configurationPid = "com.docs.assignment.web.schedular.SchedularConfiguration",
		service = SampleConfigurationSchedular.class)
public class SampleConfigurationSchedular extends BaseMessageListener{


	public String getCronValue() {
       return _configuration.cronValue();
    }

	@Activate
	@Modified
	protected void activate(Map<String,Object> properties) {
	
	_configuration = ConfigurableUtil.createConfigurable(
        SchedularConfiguration.class, properties);
	
		String cronExpression = getCronValue();
		
		String listenerClass = getClass().getName();
        Trigger jobTrigger = _triggerFactory.createTrigger(listenerClass, listenerClass, new Date(), null, cronExpression);

        _schedulerEntryImpl = new SchedulerEntryImpl(listenerClass, jobTrigger);
        _schedulerEntryImpl.setTrigger(jobTrigger);

        if (_initialized) {
            deactivate();
        }

        _schedulerEngineHelper.register(this, _schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);

        _initialized = true;
	
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

	@Override
	protected void doReceive(Message message) throws Exception {
		if (_log.isInfoEnabled()) {
			_log.info("Received message on schedule: on :: " + message);
		}
	}
	
	 protected StorageType getStorageType() {
	        return StorageType.MEMORY_CLUSTERED;
	    }

	private static final Log _log = LogFactoryUtil.getLog(
			SampleConfigurationSchedular.class);
	
	private volatile SchedularConfiguration _configuration;
	
	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	private volatile ModuleServiceLifecycle _moduleServiceLifecycle;

	@Reference(unbind = "-")
	private volatile SchedulerEngineHelper _schedulerEngineHelper;

	@Reference(unbind = "-")
	private volatile TriggerFactory _triggerFactory;
	
	 private SchedulerEntryImpl _schedulerEntryImpl = null;
	 private volatile boolean _initialized;
}
