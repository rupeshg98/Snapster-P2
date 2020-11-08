package com.revature.repository;

import java.io.File;

import org.springframework.stereotype.Repository;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.revature.utility.S3ConnectionFactory;

@Repository(value = "S3Repo")
public class S3RepoImpl implements S3Repo {
	
	public PutObjectResult putObject(File file, String uuid) {
		AmazonS3 s3 = S3ConnectionFactory.getConnection();
		String bucketName = "revature20200921p2snapster";
		
		try {
			PutObjectResult result = s3.putObject(bucketName,uuid,file);
			return result;
		} catch (AmazonServiceException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
