package com.revature.service;

import java.io.File;

import com.amazonaws.services.s3.model.PutObjectResult;
import com.revature.repository.S3RepoImpl;

public class S3Service {
	S3RepoImpl s3repoImpl = new S3RepoImpl();
	
	public PutObjectResult putObject(File file) {
		return s3repoImpl.putObject(file);
	}

}
