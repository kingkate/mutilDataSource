package multildatasource;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //定义保留策略 {SOURCE,CLASS,RUNTIME}
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD}) //定义注解位置 类，方法，参数，变量,
@Documented
@Inherited
public @interface TestAnno {

	public values type = values.a;
	
	public String value = "";
	
	public enum values{a,b,c,d,e}
	
}
