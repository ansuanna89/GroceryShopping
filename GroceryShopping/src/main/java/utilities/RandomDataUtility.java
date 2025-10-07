package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {

	Faker faker = new Faker();

	public String createRandomUserName() {

		return faker.name().username();

	}

	public String createRandomPassword() {
		
		return faker.internet().password();
	}
	
	public String createRandomFullName() {
		return faker.name().fullName();
	}

	public String createRandomEmailID() {
		
		return faker.internet().emailAddress();
		
	}
}
