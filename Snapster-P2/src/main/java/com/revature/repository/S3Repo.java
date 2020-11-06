package com.revature.repository;

import java.io.File;

import com.amazonaws.services.s3.model.PutObjectResult;

public interface S3Repo {
	public PutObjectResult putObject(File file);
}
