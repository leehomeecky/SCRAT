package com.meecky.SCRAT;

import com.meecky.SCRAT.users.enums.EmailVerificationEnum;
import com.meecky.SCRAT.users.enums.Roles;
import com.meecky.SCRAT.users.enums.SubCycle;
import com.meecky.SCRAT.users.model.UserModel;
import com.meecky.SCRAT.users.repository.UserRepo;
import com.meecky.SCRAT.wallet.enums.Currency;
import com.meecky.SCRAT.wallet.model.WalletModel;
import com.meecky.SCRAT.wallet.repository.WalletRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@SpringBootApplication
public class ScratApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScratApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserRepo userRepo, WalletRepo walletRepo, PasswordEncoder passwordEncoder){
		return args -> {
			if(walletRepo.findByAccountId("1234554321").isPresent()) return;
			WalletModel wallet = new WalletModel();
			wallet.setAmount("1000000");
			wallet.setAccountId("1234554321");

			walletRepo.save(wallet);


			UserModel admin = new UserModel();
			admin.setFirstName("JOHN");
			admin.setLastName("SHANK");
			admin.setEmail("johnshank@gmail.com");
			admin.setPassword(passwordEncoder.encode("1234"));
			admin.setAdminHash(passwordEncoder.encode("SUPER_ADMIN"));
			admin.setWalletId(wallet);
			admin.setRoles(Roles.SUPER_ADMIN);
			admin.setIsVerified(EmailVerificationEnum.VERIFIED);
			admin.setSubscriptionCycle(SubCycle.ANNUALLY);

			userRepo.save(admin);
		};
	}

}
