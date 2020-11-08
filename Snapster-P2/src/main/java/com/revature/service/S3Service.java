package com.revature.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.model.PutObjectResult;
import com.revature.repository.S3Repo;
import com.revature.repository.S3RepoImpl;

@Service(value = "s3service")

public class S3Service {
	
	private S3Repo s3repo;
	
	@Autowired
	public void setS3epository(S3RepoImpl s3repoImpl) {
		this.s3repo = s3repoImpl;
	}
	
	public PutObjectResult putObject(File file, String uuid) {
		return s3repo.putObject(file, uuid);
	}

}
