package com.weixin.query;

public class ContactSource {
    private final String sourceId;
    private final String sourceType;
    private final String realmId;
    private final String entityType;
    private final String displayName;

    public ContactSource(String sourceId, String sourceType, String realmId, String entityType, String displayName) {
        this.sourceId = sourceId;
        this.sourceType = sourceType;
        this.realmId = realmId;
        this.entityType = entityType;
        this.displayName = displayName;
    }

    public String getSourceType() {
        return sourceType;
    }

    public String getRealmId() {
        return realmId;
    }

    public String getEntityType() {
        return entityType;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getSourceId() {

        return sourceId;
    }
}
