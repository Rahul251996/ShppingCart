package com.netset.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netset.util.Constants;
import com.netset.bean.Product;
import com.netset.service.ProductService;

@RestController
@RequestMapping("/assignment/product")
public class ProductController {

	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.ALL_VALUE)
	public ResponseEntity<Object> addProduct(@RequestBody Product product) {
		if (product != null) {
			productService.save(product);

			return new ResponseEntity<>("Product Added Succesfully", HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/searchProduct", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.ALL_VALUE)
	public ResponseEntity<?> getProduct(@RequestParam(required = false) String product,
			@RequestParam(required = false) String color, @RequestParam(required = false) String category) {
		List<Product> resultList = new ArrayList<>();
		resultList = productService.getProduct(product, color, category);

		if (resultList != null) {
			return new ResponseEntity<Object>(resultList, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("No Product Found ", HttpStatus.NOT_FOUND);
	}

	// Exception handler To handle the Exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(Exception e) throws IOException {
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put(Constants.KEY_STATUS, Constants.STATUS_FAILURE);
		resultMap.put(Constants.KEY_ERROR, e.getMessage());
		return new ResponseEntity<>(resultMap, HttpStatus.BAD_REQUEST);
	}

}
