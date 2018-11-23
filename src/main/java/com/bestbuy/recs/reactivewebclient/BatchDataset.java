package com.bestbuy.recs.reactivewebclient;

import java.util.Date;
import java.util.List;

public class BatchDataset {

    private BatchDatasetKey batchDatasetKey;
    private List<Item> items;
    private Date lastModified;

    public BatchDatasetKey getBatchDatasetKey() {
        return batchDatasetKey;
    }

    public void setBatchDatasetKey(BatchDatasetKey batchDatasetKey) {
        this.batchDatasetKey = batchDatasetKey;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
}
