package com.dependencyinjection.dependencyinjection;

import com.dependencyinjection.dependencyinjection.aop.TargetObject;
import com.dependencyinjection.dependencyinjection.atributo.Coche;
import com.dependencyinjection.dependencyinjection.atributo.Motor;
import com.dependencyinjection.dependencyinjection.autowire.AreaCalculatorService;
import com.dependencyinjection.dependencyinjection.lifecycle.ExplicitBean;
import com.dependencyinjection.dependencyinjection.lifecycle.LifeCycleBean;
import com.dependencyinjection.dependencyinjection.profiles.EnvironmentService;
import com.dependencyinjection.dependencyinjection.qualifiers.Animal;
import com.dependencyinjection.dependencyinjection.qualifiers.Nido;
import com.dependencyinjection.dependencyinjection.qualifiers.Pajaro;
import com.dependencyinjection.dependencyinjection.qualifiers.Perro;
import com.dependencyinjection.dependencyinjection.scopes.ScopeExampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

@SpringBootApplication
public class DependencyInjectionApplication {

	private static final Logger log = LoggerFactory.getLogger(Pajaro.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(DependencyInjectionApplication.class, args);
		/*
		// DI
		Motor motor = new Motor("xl", 1984);
		Coche coche = new Coche("Wolswagen", 1866, motor);*/
		//Coche coche = context.getBean(Coche.class);

		// DI usando la clase
		//Perro perro = context.getBean(Perro.class);
		//Pajaro pajaro = context.getBean(Pajaro.class);
		//log.info("Objeto : "+ pajaro.getNombre());

		// FORMAS DE INYECCIÓN CUANDO UNA CLASE PADRE TIENE MÚLTIPLES IMPLEMENTACIONES

		// Forma 1, usando la sobrecarga en getBean
		// DI usando clase padre y especificando Qualifier
		// Por defecto el nombre del Qualifier es el mismo nombre de la clase pero en minúsucula
		// Caso contrario en el decorador Component especifico el nombre del Qualifier
		/*
		Animal animal = context.getBean("pajarito",Animal.class);
		log.info("Animal nombre = {} edad = {}", animal.getNombre(), animal.getEdad());

		// Forma 2, usando solo la clase y especificando el Qualifier en la clase
		// DI usando qualifier, en este ejemplo Nido necesita de un animal que debe ser pájaro
		// Por lo que especificaremos que el Qualifier es un pájaro en la clase nido
		Nido nido = context.getBean(Nido.class);
		nido.imprimir();

		// Forma 3, se puede definir un bean por default usando @Primary

		// PROFILES
		// Existen tres formas de gestionar los perfiles

		//1. Definiendo en el aplication properties, especificando el active profile
		EnvironmentService environmentService = context.getBean(EnvironmentService.class);
		log.info("Active environment {}", environmentService.getEnvironment());

		// 2. En el VM argument
		// 3. Con un decorador en testing
		// Adicionalmente si ni en propiedades ni en VM se ha definido un perfil
		// podemos especificar uno por defecto usando "default" en el decorador Profile

		// SCOPES
		// Por defecto el scope es "singleton"
		ScopeExampleService scope1 = context.getBean(ScopeExampleService.class);
		ScopeExampleService scope2 = context.getBean(ScopeExampleService.class);

		log.info("Are beans equal {}", scope1.equals(scope2));
		log.info("Are beans == {}", scope1 == scope2);

		// EXPLICIT BEANS
		// Cuando queremos que alguna función sea registrada como bean y dependemos de una implementación final
		String nombreAplicacion = context.getBean(String.class);
		log.info("Nombre de la aplicación {}", nombreAplicacion);

		// AUTOWIRE con listas
		AreaCalculatorService areaCalculatorService = context.getBean(AreaCalculatorService.class);
		log.info("Area total de todas figuras {}", areaCalculatorService.calcAreas());

		// SPEL
		// creamos un spel manual para comprobar si la expresión funciona correctamente
		ExpressionParser expressionParser = new SpelExpressionParser();
		Expression expression = expressionParser.parseExpression("10 + 78.8");
		log.info("Expression {}", expression.getValue());

		// LIFECYCLE
		LifeCycleBean lifeCycleBean = context.getBean(LifeCycleBean.class);
		// 1. BeanNameAware (Se ejecuta cuando el nombre del bean es asignado)
		// 2. Se ejecuta postProcessBeforeInitialization del bean
		// 3. Se ejecuta el callback de Post Construct
		// 3. Se ejecuta la sobreescritura de AfterPropertiesSet
		// 5. Se ejecuta el postProcessAfterInitialization del bean
		// 6. Se ejecuta el bean
		// 7. Se ejecuta el callback de  Pre Destroy, evento antes de finalizar el bean
		// 8. Se ejecuta la sobreescritura de DisposableBean

		 */
		// AOP
		TargetObject targetObject = context.getBean(TargetObject.class);
		targetObject.hello("Holaaa");

	}

	@Bean
	public String getApplicationName(){
		return "AndersCFR";
	}

	@Bean(initMethod = "init", destroyMethod = "destroyBean")
	public ExplicitBean getBean(){
		return new ExplicitBean();
	}

}
