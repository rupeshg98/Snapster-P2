package com.revature.utility;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class S3ConnectionFactory {
	
	private static String access_key = System.getenv("AWSAccessKey");
	private static String private_key = System.getenv("AWSSecretKey");
	
	private static AmazonS3 s3 = AmazonS3ClientBuilder.standard()
			.withRegion(Regions.US_EAST_2)
			.withCredentials(new AWSStaticCredentialsProvider
					(new BasicAWSCredentials(access_key,private_key)))
			.build();
	
	public static AmazonS3 getConnection() {
		return s3;
	}
}
