package org.genia.fishstore.infrastructure;

import org.eclipse.persistence.config.SessionCustomizer;
import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.sessions.Session;

/**
 * Override EclipseLink default behaviour to name all DB tables in UPPERCASE.
 * Instead, use class names as table names.
 * 
 * Inspired by:
 *     http://stackoverflow.com/questions/19896352/customize-jpa-field-name-mapping-using-eclipselink
 */
public class EclipselinkTablenamesCustomizer implements SessionCustomizer {

    @Override
    public void customize( Session session ) throws Exception {
        for (ClassDescriptor desc : session.getDescriptors().values()) {
        	// Use class name as DB table name. 
        	desc.setTableName(desc.getJavaClass().getSimpleName());
        }
    }
}
