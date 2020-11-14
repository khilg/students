package com.docs.assignment.student.upgrade.schema;

import com.liferay.portal.kernel.upgrade.DummyUpgradeStep;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        service = UpgradeStepRegistrator.class)
public class AddColumnUpgradeProcessRegistrator implements UpgradeStepRegistrator {

    @Override
    public void register(Registry registry) {

        registry.register(
                "com.docs.assignment.student.upgrade.schema", "0.0.0", "2.0.0",
                new DummyUpgradeStep());

        registry.register(
                "com.docs.assignment.student.upgrade.schema", "1.0.0", "1.1.0",
                new AddColumnUpgradeProcess());

    }
}
