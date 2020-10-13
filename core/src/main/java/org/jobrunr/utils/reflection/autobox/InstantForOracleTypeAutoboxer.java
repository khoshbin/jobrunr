package org.jobrunr.utils.reflection.autobox;

import oracle.sql.TIMESTAMP;
import org.jobrunr.JobRunrError;

import java.sql.SQLException;
import java.time.Instant;

public class InstantForOracleTypeAutoboxer extends InstantTypeAutoboxer {

    @Override
    public Instant autobox(Object value, Class<Instant> type) {
        try {
            return ((TIMESTAMP) value).timestampValue().toInstant();
        } catch (SQLException e) {
            throw JobRunrError.canNotHappenError(e);
        }
    }
}
