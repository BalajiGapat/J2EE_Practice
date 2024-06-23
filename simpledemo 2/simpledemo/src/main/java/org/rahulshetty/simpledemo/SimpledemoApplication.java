package org.rahulshetty.simpledemo;

import org.rahulshetty.simpledemo.Model.Library;
import org.rahulshetty.simpledemo.Repositories.LibraryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class SimpledemoApplication implements CommandLineRunner
{
	@Autowired
	LibraryInterface librepo;
	public static void main(String[] args)
	{
		SpringApplication.run(SimpledemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		// Library libentity =librepo.findById("isbn01").get();
		// System.out.println(libentity.getAisle());

		Optional<Library> optionalLibEntity = librepo.findById("isbn01");

		if (optionalLibEntity.isPresent())
		{
			Library libEntity = optionalLibEntity.get();
			System.out.println(libEntity.getAisle());
		}
		else
		{
			System.out.println("No library entity found with ID 'isbn01...!!!'");
			// Handle the case where the entity is not found, maybe throw an exception or handle gracefully
		}

	}
}
