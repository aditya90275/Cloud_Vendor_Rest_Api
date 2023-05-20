package com.CloudVendorRestAPI.Service;

import com.CloudVendorRestAPI.Exception.CloudVendorException;
import com.CloudVendorRestAPI.Model.CloudVendor;

import java.util.List;


public interface CloudVendorService {
    public String createCloudVendor(CloudVendor cloudVendor) ;
    public String updateCloudVendor(CloudVendor cloudVendor);
    public String deleteCloudVendor(String cloudVendorId);
    public CloudVendor getCloudVendor(String cloudVendorId);
    public List<CloudVendor> getAllCloudVendors();
    public List<CloudVendor> getByVendorName(String vendorName);
}
