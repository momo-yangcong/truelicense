/*
 * Copyright (C) 2005 - 2019 Schlichtherle IT Services.
 * All rights reserved. Use is subject to license terms.
 */
package global.namespace.truelicense.v4;

import global.namespace.truelicense.api.License;
import global.namespace.truelicense.api.LicenseFactory;

/**
 * A license factory for use with V4 format license keys.
 */
final class V4LicenseFactory implements LicenseFactory {

    @Override
    public License license() {
        return new V4License();
    }

    @Override
    public Class<? extends License> licenseClass() {
        return V4License.class;
    }
}
