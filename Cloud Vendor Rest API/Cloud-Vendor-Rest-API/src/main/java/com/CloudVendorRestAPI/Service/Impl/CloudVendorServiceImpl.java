package com.CloudVendorRestAPI.Service.Impl;

import com.CloudVendorRestAPI.Exception.CloudVendorException;
import com.CloudVendorRestAPI.Exception.CloudVendorFoundException;
import com.CloudVendorRestAPI.Exception.CloudVendorNotFoundException;
import com.CloudVendorRestAPI.Model.CloudVendor;
import com.CloudVendorRestAPI.Repository.CloudVendorRepository;
import com.CloudVendorRestAPI.Service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        if(!cloudVendorRepository.findById(cloudVendor.getVendorId()).isEmpty())
            throw new CloudVendorFoundException("Requested Cloud Vendor already exist");
        cloudVendorRepository.save(cloudVendor);
        // More Business Logic

        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        // More Business Logic
        if(cloudVendorRepository.findById(cloudVendor.getVendorId()).isEmpty())
            throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        // More Business Logic
        if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
            throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Success";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        // More Business Logic
        if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
            throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        // More Business Logic
        return cloudVendorRepository.findAll();
    }

    @Override
    public List<CloudVendor> getByVendorName(String vendorName)
    {
        return cloudVendorRepository.findByVendorName(vendorName);
    }
}
