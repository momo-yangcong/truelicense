/*
 * Copyright (C) 2005 - 2019 Schlichtherle IT Services.
 * All rights reserved. Use is subject to license terms.
 */
package global.namespace.truelicense.maven.plugin.commons;

import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;

final class CheckedLog extends DecoratingLog {

    private boolean error;

    CheckedLog(Log log) { super(log); }

    void check() throws MojoFailureException {
        if (error) throw new MojoFailureException("Check logging output.");
    }

    @Override
    public void error(CharSequence content) {
        log.error(content);
        this.error = true;
    }

    @Override
    public void error(CharSequence content, Throwable error) {
        log.error(content, error);
        this.error = true;
    }

    @Override
    public void error(Throwable error) {
        log.error(error);
        this.error = true;
    }
}
