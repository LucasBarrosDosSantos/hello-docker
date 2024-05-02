package br.com.byteup.hellodocker.controller;

import br.com.byteup.hellodocker.producer.SqsEventProducer;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("docker")
@RestController
public class HelloDockerController {

	@Autowired
	private SqsEventProducer sqsEventProducer;

	@PostMapping("")
	public ResponseEntity helloDocker(@RequestBody JsonNode jsonNode) {
		sqsEventProducer.publishEvent(jsonNode);
		return ResponseEntity.ok().build();
	}
}
