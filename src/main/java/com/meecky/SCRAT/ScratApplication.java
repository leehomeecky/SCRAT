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
			WalletModel wallet = new WalletModel(1l, "1000000", Currency.NGN,
					"1234554321", LocalDateTime.now(), LocalDateTime.now(), null);

			walletRepo.save(wallet);


			UserModel admin = new UserModel(1l, "JOHN", "SHANK",
					"johnshank@gmail.com", passwordEncoder.encode("1234"),
					null, null, EmailVerificationEnum.VERIFIED, SubCycle.ANNUALLY,
					passwordEncoder.encode("SUPER_ADMIN"), Roles.SUPER_ADMIN, wallet,
					LocalDateTime.now(), LocalDateTime.now(), null
			);

			userRepo.save(admin);
		};
	}

}
