package multildatasource;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * 数据源通知器
 * @author lx
 *
 */
public class DataSourceAdvisor {
	
	/**
	 * 切换数据库（环绕通知）
	 * @param point
	 * @throws Throwable 
	 */
	public Object changeDataSource(ProceedingJoinPoint point) throws Throwable{
		//TODO 更改数据源操作
		int key = (int) (Math.random()*10);
		String originalDataSource = DataSourceHolder.get();
		System.out.println(originalDataSource);
		if(key%2==0){
			DataSourceHolder.set("1");
		}else {
			DataSourceHolder.set("2");
		}
		try {
			//获取当前通知方法的名称
			String methodName = point.getSignature().getName();
			Object object = point.getTarget();
			Class[] parameterTypes = ((MethodSignature)point.getSignature()).getParameterTypes();
			Method method = point.getClass().getMethod(methodName, parameterTypes);
			//获取方法的注解
			//method.getAnnotation(DataSourceHolder.class);
			//切回主库
			return point.proceed();
		} finally{
			DataSourceHolder.set(originalDataSource);
		}		
	}
	
	/**
	 * 前置通知
	 */
	public void before(){
		//before TODO
	}
	
	/**
	 * 后置通知
	 */
	public void after(){
		//after TODO
	}
}
