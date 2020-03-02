package com.example.admin_mvc;

import com.example.admin_mvc.model.Product;
import com.example.admin_mvc.model.ProductModel;
import com.example.admin_mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@SpringBootApplication
public class AdminMvcApplication  implements CommandLineRunner {

	@Autowired
	private ThymeleafProperties properties;

	@Value("${spring.thymeleaf.templates_root:}")
	private String templatesRoot;

	@Bean
	public ITemplateResolver defaultTemplateResolver() {
		FileTemplateResolver resolver = new FileTemplateResolver();
		resolver.setSuffix(properties.getSuffix());
		resolver.setPrefix(templatesRoot);
		resolver.setTemplateMode(properties.getMode());
		resolver.setCacheable(properties.isCache());
		return resolver;
	}

	public static void main(String[] args) {
		SpringApplication.run(AdminMvcApplication.class, args);
	}

	@Autowired
	ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Tổng số bản ghi trong DB là :"
//				+ productRepository.count());
//		ProductModel newProduct =
//				new ProductModel(1,"Áo khoác",1000f,new Date());
//		ProductModel test1 = new ProductModel();
//		test1.setId(2);
//		test1.setCreatedDate(new Date());
//		test1.setName("Áo mưa");
//		test1.setPrice(10000f);
//		productRepository.save(newProduct);
//		System.out.println("Tổng số bản ghi trong DB là :"
//				+ productRepository.count());
//		List<ProductModel> listProduct = productRepository.findAll();
//		for(ProductModel p : listProduct){
//			System.out.println(p.toString());
//		}
//
//		Optional<ProductModel> optProduct = productRepository.findById(5);
//		if(!optProduct.isPresent()){
//			System.out.println("Không tìm thấy sản phẩm");
//			return;
//		}
//		ProductModel exitsProduct = optProduct.get();
//		System.out.println(exitsProduct.toString());
		//update data
//		exitsProduct.setName("Áo Gió");
//		exitsProduct.setPrice(10f);
//		productRepository.save(exitsProduct);
	}
}
