package com.docs.assignment.student.upgrade.schema;

import com.docs.assignment.student.model.impl.StudentImpl;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

public class AddColumnUpgradeProcess extends UpgradeProcess {

    @Override
    protected void doUpgrade() throws Exception {

        alter(StudentImpl.class,
                new AlterTableAddColumn("assignment_status" + StringPool.SPACE + "VARCHAR(200)"));
    }
}
