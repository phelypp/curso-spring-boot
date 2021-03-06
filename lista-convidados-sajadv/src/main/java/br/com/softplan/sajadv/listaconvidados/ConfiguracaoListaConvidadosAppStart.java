package br.com.softplan.sajadv.listaconvidados;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class ConfiguracaoListaConvidadosAppStart {

	public static void main(String[] args) {
		SpringApplication.run(ConfiguracaoListaConvidadosAppStart.class, args);
	}
	
	@Bean
	public DataSource dataSource(){
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("org.postgresql.Driver");
	    dataSource.setUrl("jdbc:postgresql://localhost:5432/sajadv_listaconvidados");
	    dataSource.setUsername("postgres");
	    dataSource.setPassword("sajadv123");
	    return dataSource;
	}
}
